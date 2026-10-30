package com.caverock.androidsvg;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.Base64;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;
import okhttp3.internal.http2.Http2Stream;
import org.apache.commons.p013io.FileUtils;

/* JADX INFO: loaded from: classes.dex */
class SVGAndroidRenderer {
    private static final float BEZIER_ARC_FACTOR = 0.5522848f;
    private static final String DEFAULT_FONT_FAMILY = "serif";
    public static final float LUMINANCE_TO_ALPHA_BLUE = 0.0722f;
    public static final float LUMINANCE_TO_ALPHA_GREEN = 0.7151f;
    public static final float LUMINANCE_TO_ALPHA_RED = 0.2127f;
    private static final String TAG = "SVGAndroidRenderer";
    private static HashSet<String> supportedFeatures = null;
    private Canvas canvas;
    private SVG document;
    private float dpi;
    private Stack<Matrix> matrixStack;
    private Stack<SVG.SvgContainer> parentStack;
    private CSSParser.RuleMatchContext ruleMatchContext = null;
    private RendererState state;
    private Stack<RendererState> stateStack;

    private class RendererState {
        Paint fillPaint;
        boolean hasFill;
        boolean hasStroke;
        boolean spacePreserve;
        Paint strokePaint;
        SVG.Style style;
        SVG.Box viewBox;
        SVG.Box viewPort;

        RendererState() {
            this.fillPaint = new Paint();
            this.fillPaint.setFlags(193);
            this.fillPaint.setHinting(0);
            this.fillPaint.setStyle(Paint.Style.FILL);
            this.fillPaint.setTypeface(Typeface.DEFAULT);
            this.strokePaint = new Paint();
            this.strokePaint.setFlags(193);
            this.strokePaint.setHinting(0);
            this.strokePaint.setStyle(Paint.Style.STROKE);
            this.strokePaint.setTypeface(Typeface.DEFAULT);
            this.style = SVG.Style.getDefaultStyle();
        }

        RendererState(RendererState copy) {
            this.hasFill = copy.hasFill;
            this.hasStroke = copy.hasStroke;
            this.fillPaint = new Paint(copy.fillPaint);
            this.strokePaint = new Paint(copy.strokePaint);
            if (copy.viewPort != null) {
                this.viewPort = new SVG.Box(copy.viewPort);
            }
            if (copy.viewBox != null) {
                this.viewBox = new SVG.Box(copy.viewBox);
            }
            this.spacePreserve = copy.spacePreserve;
            try {
                this.style = (SVG.Style) copy.style.clone();
            } catch (CloneNotSupportedException e) {
                Log.e(SVGAndroidRenderer.TAG, "Unexpected clone error", e);
                this.style = SVG.Style.getDefaultStyle();
            }
        }
    }

    private void resetState() {
        this.state = new RendererState();
        this.stateStack = new Stack<>();
        updateStyle(this.state, SVG.Style.getDefaultStyle());
        this.state.viewPort = null;
        this.state.spacePreserve = false;
        this.stateStack.push(new RendererState(this.state));
        this.matrixStack = new Stack<>();
        this.parentStack = new Stack<>();
    }

    SVGAndroidRenderer(Canvas canvas, float defaultDPI) {
        this.canvas = canvas;
        this.dpi = defaultDPI;
    }

    float getDPI() {
        return this.dpi;
    }

    float getCurrentFontSize() {
        return this.state.fillPaint.getTextSize();
    }

    float getCurrentFontXHeight() {
        return this.state.fillPaint.getTextSize() / 2.0f;
    }

    SVG.Box getCurrentViewPortInUserUnits() {
        if (this.state.viewBox != null) {
            return this.state.viewBox;
        }
        return this.state.viewPort;
    }

    void renderDocument(SVG document, RenderOptions renderOptions) {
        SVG.Box viewBox;
        PreserveAspectRatio preserveAspectRatio;
        if (renderOptions == null) {
            throw new NullPointerException("renderOptions shouldn't be null");
        }
        this.document = document;
        SVG.Svg rootObj = document.getRootElement();
        if (rootObj == null) {
            warn("Nothing to render. Document is empty.", new Object[0]);
            return;
        }
        if (renderOptions.hasView()) {
            SVG.SvgObject obj = this.document.getElementById(renderOptions.viewId);
            if (obj == null || !(obj instanceof SVG.View)) {
                Log.w(TAG, String.format("View element with id \"%s\" not found.", renderOptions.viewId));
                return;
            }
            SVG.View view = (SVG.View) obj;
            if (view.viewBox == null) {
                Log.w(TAG, String.format("View element with id \"%s\" is missing a viewBox attribute.", renderOptions.viewId));
                return;
            } else {
                viewBox = view.viewBox;
                preserveAspectRatio = view.preserveAspectRatio;
            }
        } else {
            viewBox = renderOptions.hasViewBox() ? renderOptions.viewBox : rootObj.viewBox;
            preserveAspectRatio = renderOptions.hasPreserveAspectRatio() ? renderOptions.preserveAspectRatio : rootObj.preserveAspectRatio;
        }
        if (renderOptions.hasCss()) {
            document.addCSSRules(renderOptions.css);
        }
        if (renderOptions.hasTarget()) {
            this.ruleMatchContext = new CSSParser.RuleMatchContext();
            this.ruleMatchContext.targetElement = document.getElementById(renderOptions.targetId);
        }
        resetState();
        checkXMLSpaceAttribute(rootObj);
        statePush();
        SVG.Box viewPort = new SVG.Box(renderOptions.viewPort);
        if (rootObj.width != null) {
            viewPort.width = rootObj.width.floatValue(this, viewPort.width);
        }
        if (rootObj.height != null) {
            viewPort.height = rootObj.height.floatValue(this, viewPort.height);
        }
        render(rootObj, viewPort, viewBox, preserveAspectRatio);
        statePop();
        if (renderOptions.hasCss()) {
            document.clearRenderCSSRules();
        }
    }

    private void render(SVG.SvgObject obj) {
        if (obj instanceof SVG.NotDirectlyRendered) {
            return;
        }
        statePush();
        checkXMLSpaceAttribute(obj);
        if (obj instanceof SVG.Svg) {
            render((SVG.Svg) obj);
        } else if (obj instanceof SVG.Use) {
            render((SVG.Use) obj);
        } else if (obj instanceof SVG.Switch) {
            render((SVG.Switch) obj);
        } else if (obj instanceof SVG.Group) {
            render((SVG.Group) obj);
        } else if (obj instanceof SVG.Image) {
            render((SVG.Image) obj);
        } else if (obj instanceof SVG.Path) {
            render((SVG.Path) obj);
        } else if (obj instanceof SVG.Rect) {
            render((SVG.Rect) obj);
        } else if (obj instanceof SVG.Circle) {
            render((SVG.Circle) obj);
        } else if (obj instanceof SVG.Ellipse) {
            render((SVG.Ellipse) obj);
        } else if (obj instanceof SVG.Line) {
            render((SVG.Line) obj);
        } else if (obj instanceof SVG.Polygon) {
            render((SVG.Polygon) obj);
        } else if (obj instanceof SVG.PolyLine) {
            render((SVG.PolyLine) obj);
        } else if (obj instanceof SVG.Text) {
            render((SVG.Text) obj);
        }
        statePop();
    }

    private void renderChildren(SVG.SvgContainer obj, boolean isContainer) {
        if (isContainer) {
            parentPush(obj);
        }
        for (SVG.SvgObject child : obj.getChildren()) {
            render(child);
        }
        if (isContainer) {
            parentPop();
        }
    }

    private void statePush() {
        this.canvas.save();
        this.stateStack.push(this.state);
        this.state = new RendererState(this.state);
    }

    private void statePop() {
        this.canvas.restore();
        this.state = this.stateStack.pop();
    }

    private void parentPush(SVG.SvgContainer obj) {
        this.parentStack.push(obj);
        this.matrixStack.push(this.canvas.getMatrix());
    }

    private void parentPop() {
        this.parentStack.pop();
        this.matrixStack.pop();
    }

    private void updateStyleForElement(RendererState state, SVG.SvgElementBase obj) {
        boolean isRootSVG = obj.parent == null;
        state.style.resetNonInheritingProperties(isRootSVG);
        if (obj.baseStyle != null) {
            updateStyle(state, obj.baseStyle);
        }
        if (this.document.hasCSSRules()) {
            for (CSSParser.Rule rule : this.document.getCSSRules()) {
                if (CSSParser.ruleMatch(this.ruleMatchContext, rule.selector, obj)) {
                    updateStyle(state, rule.style);
                }
            }
        }
        if (obj.style != null) {
            updateStyle(state, obj.style);
        }
    }

    private void checkXMLSpaceAttribute(SVG.SvgObject obj) {
        if (!(obj instanceof SVG.SvgElementBase)) {
            return;
        }
        SVG.SvgElementBase bobj = (SVG.SvgElementBase) obj;
        if (bobj.spacePreserve != null) {
            this.state.spacePreserve = bobj.spacePreserve.booleanValue();
        }
    }

    private void doFilledPath(SVG.SvgElement obj, Path path) {
        if (this.state.style.fill instanceof SVG.PaintReference) {
            SVG.SvgObject ref = this.document.resolveIRI(((SVG.PaintReference) this.state.style.fill).href);
            if (ref instanceof SVG.Pattern) {
                SVG.Pattern pattern = (SVG.Pattern) ref;
                fillWithPattern(obj, path, pattern);
                return;
            }
        }
        this.canvas.drawPath(path, this.state.fillPaint);
    }

    private void doStroke(Path path) {
        if (this.state.style.vectorEffect == SVG.Style.VectorEffect.NonScalingStroke) {
            Matrix currentMatrix = this.canvas.getMatrix();
            Path transformedPath = new Path();
            path.transform(currentMatrix, transformedPath);
            this.canvas.setMatrix(new Matrix());
            Shader shader = this.state.strokePaint.getShader();
            Matrix currentShaderMatrix = new Matrix();
            if (shader != null) {
                shader.getLocalMatrix(currentShaderMatrix);
                Matrix newShaderMatrix = new Matrix(currentShaderMatrix);
                newShaderMatrix.postConcat(currentMatrix);
                shader.setLocalMatrix(newShaderMatrix);
            }
            this.canvas.drawPath(transformedPath, this.state.strokePaint);
            this.canvas.setMatrix(currentMatrix);
            if (shader != null) {
                shader.setLocalMatrix(currentShaderMatrix);
                return;
            }
            return;
        }
        this.canvas.drawPath(path, this.state.strokePaint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void warn(String format, Object... args) {
        Log.w(TAG, String.format(format, args));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void error(String format, Object... args) {
        Log.e(TAG, String.format(format, args));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void debug(String format, Object... args) {
    }

    private void render(SVG.Svg obj) {
        SVG.Box viewPort = makeViewPort(obj.f289x, obj.f290y, obj.width, obj.height);
        render(obj, viewPort, obj.viewBox, obj.preserveAspectRatio);
    }

    private void render(SVG.Svg obj, SVG.Box viewPort) {
        render(obj, viewPort, obj.viewBox, obj.preserveAspectRatio);
    }

    private void render(SVG.Svg obj, SVG.Box viewPort, SVG.Box viewBox, PreserveAspectRatio positioning) {
        debug("Svg render", new Object[0]);
        if (viewPort.width == 0.0f || viewPort.height == 0.0f) {
            return;
        }
        if (positioning == null) {
            positioning = obj.preserveAspectRatio != null ? obj.preserveAspectRatio : PreserveAspectRatio.LETTERBOX;
        }
        updateStyleForElement(this.state, obj);
        if (!display()) {
            return;
        }
        this.state.viewPort = viewPort;
        if (!this.state.style.overflow.booleanValue()) {
            setClipRect(this.state.viewPort.minX, this.state.viewPort.minY, this.state.viewPort.width, this.state.viewPort.height);
        }
        checkForClipPath(obj, this.state.viewPort);
        if (viewBox != null) {
            this.canvas.concat(calculateViewBoxTransform(this.state.viewPort, viewBox, positioning));
            this.state.viewBox = obj.viewBox;
        } else {
            this.canvas.translate(this.state.viewPort.minX, this.state.viewPort.minY);
        }
        boolean compositing = pushLayer();
        viewportFill();
        renderChildren(obj, true);
        if (compositing) {
            popLayer(obj);
        }
        updateParentBoundingBox(obj);
    }

    private SVG.Box makeViewPort(SVG.Length x, SVG.Length y, SVG.Length width, SVG.Length height) {
        float _x = x != null ? x.floatValueX(this) : 0.0f;
        float _y = y != null ? y.floatValueY(this) : 0.0f;
        SVG.Box viewPortUser = getCurrentViewPortInUserUnits();
        float _w = width != null ? width.floatValueX(this) : viewPortUser.width;
        float _h = height != null ? height.floatValueY(this) : viewPortUser.height;
        return new SVG.Box(_x, _y, _w, _h);
    }

    private void render(SVG.Group obj) {
        debug("Group render", new Object[0]);
        updateStyleForElement(this.state, obj);
        if (!display()) {
            return;
        }
        if (obj.transform != null) {
            this.canvas.concat(obj.transform);
        }
        checkForClipPath(obj);
        boolean compositing = pushLayer();
        renderChildren(obj, true);
        if (compositing) {
            popLayer(obj);
        }
        updateParentBoundingBox(obj);
    }

    private void updateParentBoundingBox(SVG.SvgElement obj) {
        if (obj.parent == null || obj.boundingBox == null) {
            return;
        }
        Matrix m = new Matrix();
        if (this.matrixStack.peek().invert(m)) {
            float[] pts = {obj.boundingBox.minX, obj.boundingBox.minY, obj.boundingBox.maxX(), obj.boundingBox.minY, obj.boundingBox.maxX(), obj.boundingBox.maxY(), obj.boundingBox.minX, obj.boundingBox.maxY()};
            m.preConcat(this.canvas.getMatrix());
            m.mapPoints(pts);
            RectF rect = new RectF(pts[0], pts[1], pts[0], pts[1]);
            for (int i = 2; i <= 6; i += 2) {
                if (pts[i] < rect.left) {
                    rect.left = pts[i];
                }
                if (pts[i] > rect.right) {
                    rect.right = pts[i];
                }
                if (pts[i + 1] < rect.top) {
                    rect.top = pts[i + 1];
                }
                if (pts[i + 1] > rect.bottom) {
                    rect.bottom = pts[i + 1];
                }
            }
            SVG.SvgElement parent = (SVG.SvgElement) this.parentStack.peek();
            if (parent.boundingBox == null) {
                parent.boundingBox = SVG.Box.fromLimits(rect.left, rect.top, rect.right, rect.bottom);
            } else {
                parent.boundingBox.union(SVG.Box.fromLimits(rect.left, rect.top, rect.right, rect.bottom));
            }
        }
    }

    private boolean pushLayer() {
        SVG.SvgObject ref;
        if (!requiresCompositing()) {
            return false;
        }
        this.canvas.saveLayerAlpha(null, clamp255(this.state.style.opacity.floatValue()), 31);
        this.stateStack.push(this.state);
        this.state = new RendererState(this.state);
        if (this.state.style.mask == null || ((ref = this.document.resolveIRI(this.state.style.mask)) != null && (ref instanceof SVG.Mask))) {
            return true;
        }
        error("Mask reference '%s' not found", this.state.style.mask);
        this.state.style.mask = null;
        return true;
    }

    private void popLayer(SVG.SvgElement obj) {
        popLayer(obj, obj.boundingBox);
    }

    private void popLayer(SVG.SvgElement obj, SVG.Box originalObjBBox) {
        if (this.state.style.mask != null) {
            Paint maskPaintCombined = new Paint();
            maskPaintCombined.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.canvas.saveLayer(null, maskPaintCombined, 31);
            Paint maskPaint1 = new Paint();
            ColorMatrix luminanceToAlpha = new ColorMatrix(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2127f, 0.7151f, 0.0722f, 0.0f, 0.0f});
            maskPaint1.setColorFilter(new ColorMatrixColorFilter(luminanceToAlpha));
            this.canvas.saveLayer(null, maskPaint1, 31);
            SVG.SvgObject ref = this.document.resolveIRI(this.state.style.mask);
            renderMask((SVG.Mask) ref, obj, originalObjBBox);
            this.canvas.restore();
            Paint maskPaint2 = new Paint();
            maskPaint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.canvas.saveLayer(null, maskPaint2, 31);
            renderMask((SVG.Mask) ref, obj, originalObjBBox);
            this.canvas.restore();
            this.canvas.restore();
        }
        statePop();
    }

    private boolean requiresCompositing() {
        return this.state.style.opacity.floatValue() < 1.0f || this.state.style.mask != null;
    }

    private void render(SVG.Switch obj) {
        debug("Switch render", new Object[0]);
        updateStyleForElement(this.state, obj);
        if (!display()) {
            return;
        }
        if (obj.transform != null) {
            this.canvas.concat(obj.transform);
        }
        checkForClipPath(obj);
        boolean compositing = pushLayer();
        renderSwitchChild(obj);
        if (compositing) {
            popLayer(obj);
        }
        updateParentBoundingBox(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void renderSwitchChild(SVG.Switch obj) {
        Set<String> syslang;
        String fontName;
        String deviceLanguage = Locale.getDefault().getLanguage();
        SVGExternalFileResolver fileResolver = SVG.getFileResolver();
        for (SVG.SvgObject svgObject : obj.getChildren()) {
            if (svgObject instanceof SVG.SvgConditional) {
                SVG.SvgConditional condObj = (SVG.SvgConditional) svgObject;
                if (condObj.getRequiredExtensions() == null && ((syslang = condObj.getSystemLanguage()) == null || (!syslang.isEmpty() && syslang.contains(deviceLanguage)))) {
                    Set<String> reqfeat = condObj.getRequiredFeatures();
                    if (reqfeat != null) {
                        if (supportedFeatures == null) {
                            initialiseSupportedFeaturesMap();
                        }
                        if (reqfeat.isEmpty() || !supportedFeatures.containsAll(reqfeat)) {
                        }
                    }
                    Set<String> reqfmts = condObj.getRequiredFormats();
                    if (reqfmts != null) {
                        if (!reqfmts.isEmpty() && fileResolver != null) {
                            Iterator<String> it = reqfmts.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    String mimeType = it.next();
                                    if (!fileResolver.isFormatSupported(mimeType)) {
                                    }
                                }
                            }
                        }
                    }
                    Set<String> reqfonts = condObj.getRequiredFonts();
                    if (reqfonts != null) {
                        if (!reqfonts.isEmpty() && fileResolver != null) {
                            Iterator<String> it2 = reqfonts.iterator();
                            do {
                                if (it2.hasNext()) {
                                    fontName = it2.next();
                                }
                            } while (fileResolver.resolveFont(fontName, this.state.style.fontWeight.intValue(), String.valueOf(this.state.style.fontStyle)) != null);
                        }
                    }
                    render(svgObject);
                    return;
                }
            }
        }
    }

    private static synchronized void initialiseSupportedFeaturesMap() {
        supportedFeatures = new HashSet<>();
        supportedFeatures.add("Structure");
        supportedFeatures.add("BasicStructure");
        supportedFeatures.add("ConditionalProcessing");
        supportedFeatures.add("Image");
        supportedFeatures.add("Style");
        supportedFeatures.add("ViewportAttribute");
        supportedFeatures.add("Shape");
        supportedFeatures.add("BasicText");
        supportedFeatures.add("PaintAttribute");
        supportedFeatures.add("BasicPaintAttribute");
        supportedFeatures.add("OpacityAttribute");
        supportedFeatures.add("BasicGraphicsAttribute");
        supportedFeatures.add("Marker");
        supportedFeatures.add("Gradient");
        supportedFeatures.add("Pattern");
        supportedFeatures.add("Clip");
        supportedFeatures.add("BasicClip");
        supportedFeatures.add("Mask");
        supportedFeatures.add("View");
    }

    private void render(SVG.Use obj) {
        debug("Use render", new Object[0]);
        if (obj.width == null || !obj.width.isZero()) {
            if (obj.height != null && obj.height.isZero()) {
                return;
            }
            updateStyleForElement(this.state, obj);
            if (!display()) {
                return;
            }
            SVG.SvgObject ref = obj.document.resolveIRI(obj.href);
            if (ref == null) {
                error("Use reference '%s' not found", obj.href);
                return;
            }
            if (obj.transform != null) {
                this.canvas.concat(obj.transform);
            }
            float _x = obj.f313x != null ? obj.f313x.floatValueX(this) : 0.0f;
            float _y = obj.f314y != null ? obj.f314y.floatValueY(this) : 0.0f;
            this.canvas.translate(_x, _y);
            checkForClipPath(obj);
            boolean compositing = pushLayer();
            parentPush(obj);
            if (ref instanceof SVG.Svg) {
                SVG.Svg svgElem = (SVG.Svg) ref;
                SVG.Box viewPort = makeViewPort(null, null, obj.width, obj.height);
                statePush();
                render(svgElem, viewPort);
                statePop();
            } else if (ref instanceof SVG.Symbol) {
                SVG.Length _w = obj.width != null ? obj.width : new SVG.Length(100.0f, SVG.Unit.percent);
                SVG.Length _h = obj.height != null ? obj.height : new SVG.Length(100.0f, SVG.Unit.percent);
                SVG.Box viewPort2 = makeViewPort(null, null, _w, _h);
                statePush();
                render((SVG.Symbol) ref, viewPort2);
                statePop();
            } else {
                render(ref);
            }
            parentPop();
            if (compositing) {
                popLayer(obj);
            }
            updateParentBoundingBox(obj);
        }
    }

    private void render(SVG.Path obj) {
        debug("Path render", new Object[0]);
        if (obj.f282d == null) {
            return;
        }
        updateStyleForElement(this.state, obj);
        if (!display() || !visible()) {
            return;
        }
        if (!this.state.hasStroke && !this.state.hasFill) {
            return;
        }
        if (obj.transform != null) {
            this.canvas.concat(obj.transform);
        }
        Path path = new PathConverter(obj.f282d).getPath();
        if (obj.boundingBox == null) {
            obj.boundingBox = calculatePathBounds(path);
        }
        updateParentBoundingBox(obj);
        checkForGradientsAndPatterns(obj);
        checkForClipPath(obj);
        boolean compositing = pushLayer();
        if (this.state.hasFill) {
            path.setFillType(getFillTypeFromState());
            doFilledPath(obj, path);
        }
        if (this.state.hasStroke) {
            doStroke(path);
        }
        renderMarkers(obj);
        if (compositing) {
            popLayer(obj);
        }
    }

    private SVG.Box calculatePathBounds(Path path) {
        RectF pathBounds = new RectF();
        path.computeBounds(pathBounds, true);
        return new SVG.Box(pathBounds.left, pathBounds.top, pathBounds.width(), pathBounds.height());
    }

    private void render(SVG.Rect obj) {
        debug("Rect render", new Object[0]);
        if (obj.width == null || obj.height == null || obj.width.isZero() || obj.height.isZero()) {
            return;
        }
        updateStyleForElement(this.state, obj);
        if (!display() || !visible()) {
            return;
        }
        if (obj.transform != null) {
            this.canvas.concat(obj.transform);
        }
        Path path = makePathAndBoundingBox(obj);
        updateParentBoundingBox(obj);
        checkForGradientsAndPatterns(obj);
        checkForClipPath(obj);
        boolean compositing = pushLayer();
        if (this.state.hasFill) {
            doFilledPath(obj, path);
        }
        if (this.state.hasStroke) {
            doStroke(path);
        }
        if (compositing) {
            popLayer(obj);
        }
    }

    private void render(SVG.Circle obj) {
        debug("Circle render", new Object[0]);
        if (obj.f269r == null || obj.f269r.isZero()) {
            return;
        }
        updateStyleForElement(this.state, obj);
        if (!display() || !visible()) {
            return;
        }
        if (obj.transform != null) {
            this.canvas.concat(obj.transform);
        }
        Path path = makePathAndBoundingBox(obj);
        updateParentBoundingBox(obj);
        checkForGradientsAndPatterns(obj);
        checkForClipPath(obj);
        boolean compositing = pushLayer();
        if (this.state.hasFill) {
            doFilledPath(obj, path);
        }
        if (this.state.hasStroke) {
            doStroke(path);
        }
        if (compositing) {
            popLayer(obj);
        }
    }

    private void render(SVG.Ellipse obj) {
        debug("Ellipse render", new Object[0]);
        if (obj.f272rx == null || obj.f273ry == null || obj.f272rx.isZero() || obj.f273ry.isZero()) {
            return;
        }
        updateStyleForElement(this.state, obj);
        if (!display() || !visible()) {
            return;
        }
        if (obj.transform != null) {
            this.canvas.concat(obj.transform);
        }
        Path path = makePathAndBoundingBox(obj);
        updateParentBoundingBox(obj);
        checkForGradientsAndPatterns(obj);
        checkForClipPath(obj);
        boolean compositing = pushLayer();
        if (this.state.hasFill) {
            doFilledPath(obj, path);
        }
        if (this.state.hasStroke) {
            doStroke(path);
        }
        if (compositing) {
            popLayer(obj);
        }
    }

    private void render(SVG.Line obj) {
        debug("Line render", new Object[0]);
        updateStyleForElement(this.state, obj);
        if (!display() || !visible() || !this.state.hasStroke) {
            return;
        }
        if (obj.transform != null) {
            this.canvas.concat(obj.transform);
        }
        Path path = makePathAndBoundingBox(obj);
        updateParentBoundingBox(obj);
        checkForGradientsAndPatterns(obj);
        checkForClipPath(obj);
        boolean compositing = pushLayer();
        doStroke(path);
        renderMarkers(obj);
        if (compositing) {
            popLayer(obj);
        }
    }

    private List<MarkerVector> calculateMarkerPositions(SVG.Line obj) {
        float _x1 = obj.f276x1 != null ? obj.f276x1.floatValueX(this) : 0.0f;
        float _y1 = obj.f278y1 != null ? obj.f278y1.floatValueY(this) : 0.0f;
        float _x2 = obj.f277x2 != null ? obj.f277x2.floatValueX(this) : 0.0f;
        float _y2 = obj.f279y2 != null ? obj.f279y2.floatValueY(this) : 0.0f;
        List<MarkerVector> markers = new ArrayList<>(2);
        markers.add(new MarkerVector(_x1, _y1, _x2 - _x1, _y2 - _y1));
        markers.add(new MarkerVector(_x2, _y2, _x2 - _x1, _y2 - _y1));
        return markers;
    }

    private void render(SVG.PolyLine obj) {
        debug("PolyLine render", new Object[0]);
        updateStyleForElement(this.state, obj);
        if (!display() || !visible()) {
            return;
        }
        if (!this.state.hasStroke && !this.state.hasFill) {
            return;
        }
        if (obj.transform != null) {
            this.canvas.concat(obj.transform);
        }
        int numPoints = obj.points.length;
        if (numPoints < 2) {
            return;
        }
        Path path = makePathAndBoundingBox(obj);
        updateParentBoundingBox(obj);
        path.setFillType(getFillTypeFromState());
        checkForGradientsAndPatterns(obj);
        checkForClipPath(obj);
        boolean compositing = pushLayer();
        if (this.state.hasFill) {
            doFilledPath(obj, path);
        }
        if (this.state.hasStroke) {
            doStroke(path);
        }
        renderMarkers(obj);
        if (compositing) {
            popLayer(obj);
        }
    }

    private List<MarkerVector> calculateMarkerPositions(SVG.PolyLine obj) {
        int numPoints = obj.points.length;
        if (numPoints < 2) {
            return null;
        }
        List<MarkerVector> markers = new ArrayList<>();
        MarkerVector lastPos = new MarkerVector(obj.points[0], obj.points[1], 0.0f, 0.0f);
        float x = 0.0f;
        float y = 0.0f;
        for (int i = 2; i < numPoints; i += 2) {
            x = obj.points[i];
            y = obj.points[i + 1];
            lastPos.add(x, y);
            markers.add(lastPos);
            lastPos = new MarkerVector(x, y, x - lastPos.f317x, y - lastPos.f318y);
        }
        if (!(obj instanceof SVG.Polygon)) {
            markers.add(lastPos);
        } else if (x != obj.points[0] && y != obj.points[1]) {
            float x2 = obj.points[0];
            float y2 = obj.points[1];
            lastPos.add(x2, y2);
            markers.add(lastPos);
            MarkerVector newPos = new MarkerVector(x2, y2, x2 - lastPos.f317x, y2 - lastPos.f318y);
            newPos.add(markers.get(0));
            markers.add(newPos);
            markers.set(0, newPos);
        }
        return markers;
    }

    private void render(SVG.Polygon obj) {
        debug("Polygon render", new Object[0]);
        updateStyleForElement(this.state, obj);
        if (!display() || !visible()) {
            return;
        }
        if (!this.state.hasStroke && !this.state.hasFill) {
            return;
        }
        if (obj.transform != null) {
            this.canvas.concat(obj.transform);
        }
        int numPoints = obj.points.length;
        if (numPoints < 2) {
            return;
        }
        Path path = makePathAndBoundingBox(obj);
        updateParentBoundingBox(obj);
        checkForGradientsAndPatterns(obj);
        checkForClipPath(obj);
        boolean compositing = pushLayer();
        if (this.state.hasFill) {
            doFilledPath(obj, path);
        }
        if (this.state.hasStroke) {
            doStroke(path);
        }
        renderMarkers(obj);
        if (compositing) {
            popLayer(obj);
        }
    }

    private void render(SVG.Text obj) {
        debug("Text render", new Object[0]);
        updateStyleForElement(this.state, obj);
        if (!display()) {
            return;
        }
        if (obj.transform != null) {
            this.canvas.concat(obj.transform);
        }
        float fFloatValueY = 0.0f;
        float x = (obj.f303x == null || obj.f303x.size() == 0) ? 0.0f : obj.f303x.get(0).floatValueX(this);
        float y = (obj.f304y == null || obj.f304y.size() == 0) ? 0.0f : obj.f304y.get(0).floatValueY(this);
        float dx = (obj.f301dx == null || obj.f301dx.size() == 0) ? 0.0f : obj.f301dx.get(0).floatValueX(this);
        if (obj.f302dy != null && obj.f302dy.size() != 0) {
            fFloatValueY = obj.f302dy.get(0).floatValueY(this);
        }
        float dy = fFloatValueY;
        SVG.Style.TextAnchor anchor = getAnchorPosition();
        if (anchor != SVG.Style.TextAnchor.Start) {
            float textWidth = calculateTextWidth(obj);
            if (anchor == SVG.Style.TextAnchor.Middle) {
                x -= textWidth / 2.0f;
            } else {
                x -= textWidth;
            }
        }
        if (obj.boundingBox == null) {
            TextBoundsCalculator proc = new TextBoundsCalculator(x, y);
            enumerateTextSpans(obj, proc);
            obj.boundingBox = new SVG.Box(proc.bbox.left, proc.bbox.top, proc.bbox.width(), proc.bbox.height());
        }
        updateParentBoundingBox(obj);
        checkForGradientsAndPatterns(obj);
        checkForClipPath(obj);
        boolean compositing = pushLayer();
        enumerateTextSpans(obj, new PlainTextDrawer(x + dx, y + dy));
        if (compositing) {
            popLayer(obj);
        }
    }

    private SVG.Style.TextAnchor getAnchorPosition() {
        if (this.state.style.direction == SVG.Style.TextDirection.LTR || this.state.style.textAnchor == SVG.Style.TextAnchor.Middle) {
            return this.state.style.textAnchor;
        }
        return this.state.style.textAnchor == SVG.Style.TextAnchor.Start ? SVG.Style.TextAnchor.End : SVG.Style.TextAnchor.Start;
    }

    private class PlainTextDrawer extends TextProcessor {

        /* JADX INFO: renamed from: x */
        float f319x;

        /* JADX INFO: renamed from: y */
        float f320y;

        PlainTextDrawer(float x, float y) {
            super();
            this.f319x = x;
            this.f320y = y;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String text) {
            SVGAndroidRenderer.debug("TextSequence render", new Object[0]);
            if (SVGAndroidRenderer.this.visible()) {
                if (SVGAndroidRenderer.this.state.hasFill) {
                    SVGAndroidRenderer.this.canvas.drawText(text, this.f319x, this.f320y, SVGAndroidRenderer.this.state.fillPaint);
                }
                if (SVGAndroidRenderer.this.state.hasStroke) {
                    SVGAndroidRenderer.this.canvas.drawText(text, this.f319x, this.f320y, SVGAndroidRenderer.this.state.strokePaint);
                }
            }
            this.f319x += SVGAndroidRenderer.this.state.fillPaint.measureText(text);
        }
    }

    private abstract class TextProcessor {
        public abstract void processText(String str);

        private TextProcessor() {
        }

        public boolean doTextContainer(SVG.TextContainer obj) {
            return true;
        }
    }

    private void enumerateTextSpans(SVG.TextContainer obj, TextProcessor textprocessor) {
        if (!display()) {
            return;
        }
        Iterator<SVG.SvgObject> iter = obj.children.iterator();
        boolean isFirstChild = true;
        while (iter.hasNext()) {
            SVG.SvgObject child = iter.next();
            if (child instanceof SVG.TextSequence) {
                textprocessor.processText(textXMLSpaceTransform(((SVG.TextSequence) child).text, isFirstChild, !iter.hasNext()));
            } else {
                processTextChild(child, textprocessor);
            }
            isFirstChild = false;
        }
    }

    private void processTextChild(SVG.SvgObject obj, TextProcessor textprocessor) {
        SVG.Style.TextAnchor anchor;
        if (!textprocessor.doTextContainer((SVG.TextContainer) obj)) {
            return;
        }
        if (obj instanceof SVG.TextPath) {
            statePush();
            renderTextPath((SVG.TextPath) obj);
            statePop();
            return;
        }
        if (obj instanceof SVG.TSpan) {
            debug("TSpan render", new Object[0]);
            statePush();
            SVG.TSpan tspan = (SVG.TSpan) obj;
            updateStyleForElement(this.state, tspan);
            if (display()) {
                float x = 0.0f;
                float y = 0.0f;
                float dx = 0.0f;
                float dy = 0.0f;
                boolean specifiedX = tspan.f303x != null && tspan.f303x.size() > 0;
                if (textprocessor instanceof PlainTextDrawer) {
                    x = !specifiedX ? ((PlainTextDrawer) textprocessor).f319x : tspan.f303x.get(0).floatValueX(this);
                    y = (tspan.f304y == null || tspan.f304y.size() == 0) ? ((PlainTextDrawer) textprocessor).f320y : tspan.f304y.get(0).floatValueY(this);
                    float fFloatValueY = 0.0f;
                    dx = (tspan.f301dx == null || tspan.f301dx.size() == 0) ? 0.0f : tspan.f301dx.get(0).floatValueX(this);
                    if (tspan.f302dy != null && tspan.f302dy.size() != 0) {
                        fFloatValueY = tspan.f302dy.get(0).floatValueY(this);
                    }
                    dy = fFloatValueY;
                }
                if (specifiedX && (anchor = getAnchorPosition()) != SVG.Style.TextAnchor.Start) {
                    float textWidth = calculateTextWidth(tspan);
                    if (anchor == SVG.Style.TextAnchor.Middle) {
                        x -= textWidth / 2.0f;
                    } else {
                        x -= textWidth;
                    }
                }
                checkForGradientsAndPatterns((SVG.SvgElement) tspan.getTextRoot());
                if (textprocessor instanceof PlainTextDrawer) {
                    ((PlainTextDrawer) textprocessor).f319x = x + dx;
                    ((PlainTextDrawer) textprocessor).f320y = y + dy;
                }
                boolean compositing = pushLayer();
                enumerateTextSpans(tspan, textprocessor);
                if (compositing) {
                    popLayer(tspan);
                }
            }
            statePop();
            return;
        }
        if (obj instanceof SVG.TRef) {
            statePush();
            SVG.TRef tref = (SVG.TRef) obj;
            updateStyleForElement(this.state, tref);
            if (display()) {
                checkForGradientsAndPatterns((SVG.SvgElement) tref.getTextRoot());
                SVG.SvgObject ref = obj.document.resolveIRI(tref.href);
                if (ref == null || !(ref instanceof SVG.TextContainer)) {
                    error("Tref reference '%s' not found", tref.href);
                } else {
                    StringBuilder str = new StringBuilder();
                    extractRawText((SVG.TextContainer) ref, str);
                    if (str.length() > 0) {
                        textprocessor.processText(str.toString());
                    }
                }
            }
            statePop();
        }
    }

    private void renderTextPath(SVG.TextPath obj) {
        debug("TextPath render", new Object[0]);
        updateStyleForElement(this.state, obj);
        if (!display() || !visible()) {
            return;
        }
        SVG.SvgObject ref = obj.document.resolveIRI(obj.href);
        if (ref == null) {
            error("TextPath reference '%s' not found", obj.href);
            return;
        }
        SVG.Path pathObj = (SVG.Path) ref;
        Path path = new PathConverter(pathObj.f282d).getPath();
        if (pathObj.transform != null) {
            path.transform(pathObj.transform);
        }
        PathMeasure measure = new PathMeasure(path, false);
        float startOffset = obj.startOffset != null ? obj.startOffset.floatValue(this, measure.getLength()) : 0.0f;
        SVG.Style.TextAnchor anchor = getAnchorPosition();
        if (anchor != SVG.Style.TextAnchor.Start) {
            float textWidth = calculateTextWidth(obj);
            if (anchor == SVG.Style.TextAnchor.Middle) {
                startOffset -= textWidth / 2.0f;
            } else {
                startOffset -= textWidth;
            }
        }
        checkForGradientsAndPatterns((SVG.SvgElement) obj.getTextRoot());
        boolean compositing = pushLayer();
        enumerateTextSpans(obj, new PathTextDrawer(path, startOffset, 0.0f));
        if (compositing) {
            popLayer(obj);
        }
    }

    private class PathTextDrawer extends PlainTextDrawer {
        private Path path;

        PathTextDrawer(Path path, float x, float y) {
            super(x, y);
            this.path = path;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.PlainTextDrawer, com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String text) {
            if (SVGAndroidRenderer.this.visible()) {
                if (SVGAndroidRenderer.this.state.hasFill) {
                    SVGAndroidRenderer.this.canvas.drawTextOnPath(text, this.path, this.f319x, this.f320y, SVGAndroidRenderer.this.state.fillPaint);
                }
                if (SVGAndroidRenderer.this.state.hasStroke) {
                    SVGAndroidRenderer.this.canvas.drawTextOnPath(text, this.path, this.f319x, this.f320y, SVGAndroidRenderer.this.state.strokePaint);
                }
            }
            this.f319x += SVGAndroidRenderer.this.state.fillPaint.measureText(text);
        }
    }

    private float calculateTextWidth(SVG.TextContainer parentTextObj) {
        TextWidthCalculator proc = new TextWidthCalculator();
        enumerateTextSpans(parentTextObj, proc);
        return proc.f325x;
    }

    private class TextWidthCalculator extends TextProcessor {

        /* JADX INFO: renamed from: x */
        float f325x;

        private TextWidthCalculator() {
            super();
            this.f325x = 0.0f;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String text) {
            this.f325x += SVGAndroidRenderer.this.state.fillPaint.measureText(text);
        }
    }

    private class TextBoundsCalculator extends TextProcessor {
        RectF bbox;

        /* JADX INFO: renamed from: x */
        float f323x;

        /* JADX INFO: renamed from: y */
        float f324y;

        TextBoundsCalculator(float x, float y) {
            super();
            this.bbox = new RectF();
            this.f323x = x;
            this.f324y = y;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public boolean doTextContainer(SVG.TextContainer obj) {
            if (!(obj instanceof SVG.TextPath)) {
                return true;
            }
            SVG.TextPath tpath = (SVG.TextPath) obj;
            SVG.SvgObject ref = obj.document.resolveIRI(tpath.href);
            if (ref == null) {
                SVGAndroidRenderer.error("TextPath path reference '%s' not found", tpath.href);
                return false;
            }
            SVG.Path pathObj = (SVG.Path) ref;
            Path path = SVGAndroidRenderer.this.new PathConverter(pathObj.f282d).getPath();
            if (pathObj.transform != null) {
                path.transform(pathObj.transform);
            }
            RectF pathBounds = new RectF();
            path.computeBounds(pathBounds, true);
            this.bbox.union(pathBounds);
            return false;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String text) {
            if (SVGAndroidRenderer.this.visible()) {
                Rect rect = new Rect();
                SVGAndroidRenderer.this.state.fillPaint.getTextBounds(text, 0, text.length(), rect);
                RectF textbounds = new RectF(rect);
                textbounds.offset(this.f323x, this.f324y);
                this.bbox.union(textbounds);
            }
            this.f323x += SVGAndroidRenderer.this.state.fillPaint.measureText(text);
        }
    }

    private void extractRawText(SVG.TextContainer parent, StringBuilder str) {
        Iterator<SVG.SvgObject> iter = parent.children.iterator();
        boolean isFirstChild = true;
        while (iter.hasNext()) {
            SVG.SvgObject child = iter.next();
            if (child instanceof SVG.TextContainer) {
                extractRawText((SVG.TextContainer) child, str);
            } else if (child instanceof SVG.TextSequence) {
                str.append(textXMLSpaceTransform(((SVG.TextSequence) child).text, isFirstChild, !iter.hasNext()));
            }
            isFirstChild = false;
        }
    }

    private String textXMLSpaceTransform(String text, boolean isFirstChild, boolean isLastChild) {
        if (this.state.spacePreserve) {
            return text.replaceAll("[\\n\\t]", " ");
        }
        String text2 = text.replaceAll("\\n", "").replaceAll("\\t", " ");
        if (isFirstChild) {
            text2 = text2.replaceAll("^\\s+", "");
        }
        if (isLastChild) {
            text2 = text2.replaceAll("\\s+$", "");
        }
        return text2.replaceAll("\\s{2,}", " ");
    }

    private void render(SVG.Symbol obj, SVG.Box viewPort) {
        debug("Symbol render", new Object[0]);
        if (viewPort.width == 0.0f || viewPort.height == 0.0f) {
            return;
        }
        PreserveAspectRatio positioning = obj.preserveAspectRatio != null ? obj.preserveAspectRatio : PreserveAspectRatio.LETTERBOX;
        updateStyleForElement(this.state, obj);
        this.state.viewPort = viewPort;
        if (!this.state.style.overflow.booleanValue()) {
            setClipRect(this.state.viewPort.minX, this.state.viewPort.minY, this.state.viewPort.width, this.state.viewPort.height);
        }
        if (obj.viewBox != null) {
            this.canvas.concat(calculateViewBoxTransform(this.state.viewPort, obj.viewBox, positioning));
            this.state.viewBox = obj.viewBox;
        } else {
            this.canvas.translate(this.state.viewPort.minX, this.state.viewPort.minY);
        }
        boolean compositing = pushLayer();
        renderChildren(obj, true);
        if (compositing) {
            popLayer(obj);
        }
        updateParentBoundingBox(obj);
    }

    private void render(SVG.Image obj) {
        debug("Image render", new Object[0]);
        if (obj.width == null || obj.width.isZero() || obj.height == null || obj.height.isZero() || obj.href == null) {
            return;
        }
        PreserveAspectRatio positioning = obj.preserveAspectRatio != null ? obj.preserveAspectRatio : PreserveAspectRatio.LETTERBOX;
        Bitmap image = checkForImageDataURL(obj.href);
        if (image == null) {
            SVGExternalFileResolver fileResolver = SVG.getFileResolver();
            if (fileResolver == null) {
                return;
            } else {
                image = fileResolver.resolveImage(obj.href);
            }
        }
        if (image == null) {
            error("Could not locate image '%s'", obj.href);
            return;
        }
        SVG.Box imageNaturalSize = new SVG.Box(0.0f, 0.0f, image.getWidth(), image.getHeight());
        updateStyleForElement(this.state, obj);
        if (!display() || !visible()) {
            return;
        }
        if (obj.transform != null) {
            this.canvas.concat(obj.transform);
        }
        float _x = obj.f274x != null ? obj.f274x.floatValueX(this) : 0.0f;
        float _y = obj.f275y != null ? obj.f275y.floatValueY(this) : 0.0f;
        float _w = obj.width.floatValueX(this);
        float _h = obj.height.floatValueX(this);
        this.state.viewPort = new SVG.Box(_x, _y, _w, _h);
        if (!this.state.style.overflow.booleanValue()) {
            setClipRect(this.state.viewPort.minX, this.state.viewPort.minY, this.state.viewPort.width, this.state.viewPort.height);
        }
        obj.boundingBox = this.state.viewPort;
        updateParentBoundingBox(obj);
        checkForClipPath(obj);
        boolean compositing = pushLayer();
        viewportFill();
        this.canvas.save();
        this.canvas.concat(calculateViewBoxTransform(this.state.viewPort, imageNaturalSize, positioning));
        Paint bmPaint = new Paint(this.state.style.imageRendering != SVG.Style.RenderQuality.optimizeSpeed ? 2 : 0);
        this.canvas.drawBitmap(image, 0.0f, 0.0f, bmPaint);
        this.canvas.restore();
        if (compositing) {
            popLayer(obj);
        }
    }

    private Bitmap checkForImageDataURL(String url) {
        int comma;
        if (!url.startsWith("data:") || url.length() < 14 || (comma = url.indexOf(44)) < 12 || !";base64".equals(url.substring(comma - 7, comma))) {
            return null;
        }
        try {
            byte[] imageData = Base64.decode(url.substring(comma + 1), 0);
            return BitmapFactory.decodeByteArray(imageData, 0, imageData.length);
        } catch (Exception e) {
            Log.e(TAG, "Could not decode bad Data URL", e);
            return null;
        }
    }

    private boolean display() {
        if (this.state.style.display != null) {
            return this.state.style.display.booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean visible() {
        if (this.state.style.visibility != null) {
            return this.state.style.visibility.booleanValue();
        }
        return true;
    }

    private Matrix calculateViewBoxTransform(SVG.Box viewPort, SVG.Box viewBox, PreserveAspectRatio positioning) {
        Matrix m = new Matrix();
        if (positioning == null || positioning.getAlignment() == null) {
            return m;
        }
        float xScale = viewPort.width / viewBox.width;
        float yScale = viewPort.height / viewBox.height;
        float xOffset = -viewBox.minX;
        float yOffset = -viewBox.minY;
        if (positioning.equals(PreserveAspectRatio.STRETCH)) {
            m.preTranslate(viewPort.minX, viewPort.minY);
            m.preScale(xScale, yScale);
            m.preTranslate(xOffset, yOffset);
            return m;
        }
        float scale = positioning.getScale() == PreserveAspectRatio.Scale.slice ? Math.max(xScale, yScale) : Math.min(xScale, yScale);
        float imageW = viewPort.width / scale;
        float imageH = viewPort.height / scale;
        switch (positioning.getAlignment()) {
            case xMidYMin:
            case xMidYMid:
            case xMidYMax:
                xOffset -= (viewBox.width - imageW) / 2.0f;
                break;
            case xMaxYMin:
            case xMaxYMid:
            case xMaxYMax:
                xOffset -= viewBox.width - imageW;
                break;
        }
        switch (positioning.getAlignment()) {
            case xMidYMid:
            case xMaxYMid:
            case xMinYMid:
                yOffset -= (viewBox.height - imageH) / 2.0f;
                break;
            case xMidYMax:
            case xMaxYMax:
            case xMinYMax:
                yOffset -= viewBox.height - imageH;
                break;
        }
        m.preTranslate(viewPort.minX, viewPort.minY);
        m.preScale(scale, scale);
        m.preTranslate(xOffset, yOffset);
        return m;
    }

    private boolean isSpecified(SVG.Style style, long flag) {
        return (style.specifiedFlags & flag) != 0;
    }

    private void updateStyle(RendererState state, SVG.Style style) {
        if (isSpecified(style, 4096L)) {
            state.style.color = style.color;
        }
        if (isSpecified(style, 2048L)) {
            state.style.opacity = style.opacity;
        }
        if (isSpecified(style, 1L)) {
            state.style.fill = style.fill;
            state.hasFill = (style.fill == null || style.fill == SVG.Colour.TRANSPARENT) ? false : true;
        }
        if (isSpecified(style, 4L)) {
            state.style.fillOpacity = style.fillOpacity;
        }
        if (isSpecified(style, 6149L)) {
            setPaintColour(state, true, state.style.fill);
        }
        if (isSpecified(style, 2L)) {
            state.style.fillRule = style.fillRule;
        }
        if (isSpecified(style, 8L)) {
            state.style.stroke = style.stroke;
            state.hasStroke = (style.stroke == null || style.stroke == SVG.Colour.TRANSPARENT) ? false : true;
        }
        if (isSpecified(style, 16L)) {
            state.style.strokeOpacity = style.strokeOpacity;
        }
        if (isSpecified(style, 6168L)) {
            setPaintColour(state, false, state.style.stroke);
        }
        if (isSpecified(style, 34359738368L)) {
            state.style.vectorEffect = style.vectorEffect;
        }
        if (isSpecified(style, 32L)) {
            state.style.strokeWidth = style.strokeWidth;
            state.strokePaint.setStrokeWidth(state.style.strokeWidth.floatValue(this));
        }
        if (isSpecified(style, 64L)) {
            state.style.strokeLineCap = style.strokeLineCap;
            switch (style.strokeLineCap) {
                case Butt:
                    state.strokePaint.setStrokeCap(Paint.Cap.BUTT);
                    break;
                case Round:
                    state.strokePaint.setStrokeCap(Paint.Cap.ROUND);
                    break;
                case Square:
                    state.strokePaint.setStrokeCap(Paint.Cap.SQUARE);
                    break;
            }
        }
        if (isSpecified(style, 128L)) {
            state.style.strokeLineJoin = style.strokeLineJoin;
            switch (style.strokeLineJoin) {
                case Miter:
                    state.strokePaint.setStrokeJoin(Paint.Join.MITER);
                    break;
                case Round:
                    state.strokePaint.setStrokeJoin(Paint.Join.ROUND);
                    break;
                case Bevel:
                    state.strokePaint.setStrokeJoin(Paint.Join.BEVEL);
                    break;
            }
        }
        if (isSpecified(style, 256L)) {
            state.style.strokeMiterLimit = style.strokeMiterLimit;
            state.strokePaint.setStrokeMiter(style.strokeMiterLimit.floatValue());
        }
        if (isSpecified(style, 512L)) {
            state.style.strokeDashArray = style.strokeDashArray;
        }
        if (isSpecified(style, 1024L)) {
            state.style.strokeDashOffset = style.strokeDashOffset;
        }
        if (isSpecified(style, 1536L)) {
            if (state.style.strokeDashArray == null) {
                state.strokePaint.setPathEffect(null);
            } else {
                float intervalSum = 0.0f;
                int n = state.style.strokeDashArray.length;
                int arrayLen = n % 2 == 0 ? n : n * 2;
                float[] intervals = new float[arrayLen];
                for (int i = 0; i < arrayLen; i++) {
                    intervals[i] = state.style.strokeDashArray[i % n].floatValue(this);
                    intervalSum += intervals[i];
                }
                if (intervalSum == 0.0f) {
                    state.strokePaint.setPathEffect(null);
                } else {
                    float offset = state.style.strokeDashOffset.floatValue(this);
                    if (offset < 0.0f) {
                        offset = intervalSum + (offset % intervalSum);
                    }
                    state.strokePaint.setPathEffect(new DashPathEffect(intervals, offset));
                }
            }
        }
        if (isSpecified(style, Http2Stream.EMIT_BUFFER_SIZE)) {
            float currentFontSize = getCurrentFontSize();
            state.style.fontSize = style.fontSize;
            state.fillPaint.setTextSize(style.fontSize.floatValue(this, currentFontSize));
            state.strokePaint.setTextSize(style.fontSize.floatValue(this, currentFontSize));
        }
        if (isSpecified(style, 8192L)) {
            state.style.fontFamily = style.fontFamily;
        }
        if (isSpecified(style, 32768L)) {
            if (style.fontWeight.intValue() == -1 && state.style.fontWeight.intValue() > 100) {
                SVG.Style style2 = state.style;
                style2.fontWeight = Integer.valueOf(style2.fontWeight.intValue() - 100);
            } else if (style.fontWeight.intValue() == 1 && state.style.fontWeight.intValue() < 900) {
                SVG.Style style3 = state.style;
                style3.fontWeight = Integer.valueOf(style3.fontWeight.intValue() + 100);
            } else {
                state.style.fontWeight = style.fontWeight;
            }
        }
        if (isSpecified(style, 65536L)) {
            state.style.fontStyle = style.fontStyle;
        }
        if (isSpecified(style, 106496L)) {
            Typeface font = null;
            if (state.style.fontFamily != null && this.document != null) {
                SVGExternalFileResolver fileResolver = SVG.getFileResolver();
                for (String fontName : state.style.fontFamily) {
                    font = checkGenericFont(fontName, state.style.fontWeight, state.style.fontStyle);
                    if (font == null && fileResolver != null) {
                        font = fileResolver.resolveFont(fontName, state.style.fontWeight.intValue(), String.valueOf(state.style.fontStyle));
                    }
                    if (font != null) {
                    }
                }
            }
            if (font == null) {
                font = checkGenericFont(DEFAULT_FONT_FAMILY, state.style.fontWeight, state.style.fontStyle);
            }
            state.fillPaint.setTypeface(font);
            state.strokePaint.setTypeface(font);
        }
        if (isSpecified(style, 131072L)) {
            state.style.textDecoration = style.textDecoration;
            state.fillPaint.setStrikeThruText(style.textDecoration == SVG.Style.TextDecoration.LineThrough);
            state.fillPaint.setUnderlineText(style.textDecoration == SVG.Style.TextDecoration.Underline);
            state.strokePaint.setStrikeThruText(style.textDecoration == SVG.Style.TextDecoration.LineThrough);
            state.strokePaint.setUnderlineText(style.textDecoration == SVG.Style.TextDecoration.Underline);
        }
        if (isSpecified(style, 68719476736L)) {
            state.style.direction = style.direction;
        }
        if (isSpecified(style, 262144L)) {
            state.style.textAnchor = style.textAnchor;
        }
        if (isSpecified(style, 524288L)) {
            state.style.overflow = style.overflow;
        }
        if (isSpecified(style, 2097152L)) {
            state.style.markerStart = style.markerStart;
        }
        if (isSpecified(style, 4194304L)) {
            state.style.markerMid = style.markerMid;
        }
        if (isSpecified(style, 8388608L)) {
            state.style.markerEnd = style.markerEnd;
        }
        if (isSpecified(style, 16777216L)) {
            state.style.display = style.display;
        }
        if (isSpecified(style, 33554432L)) {
            state.style.visibility = style.visibility;
        }
        if (isSpecified(style, FileUtils.ONE_MB)) {
            state.style.clip = style.clip;
        }
        if (isSpecified(style, 268435456L)) {
            state.style.clipPath = style.clipPath;
        }
        if (isSpecified(style, 536870912L)) {
            state.style.clipRule = style.clipRule;
        }
        if (isSpecified(style, FileUtils.ONE_GB)) {
            state.style.mask = style.mask;
        }
        if (isSpecified(style, 67108864L)) {
            state.style.stopColor = style.stopColor;
        }
        if (isSpecified(style, 134217728L)) {
            state.style.stopOpacity = style.stopOpacity;
        }
        if (isSpecified(style, 8589934592L)) {
            state.style.viewportFill = style.viewportFill;
        }
        if (isSpecified(style, 17179869184L)) {
            state.style.viewportFillOpacity = style.viewportFillOpacity;
        }
        if (isSpecified(style, 137438953472L)) {
            state.style.imageRendering = style.imageRendering;
        }
    }

    private void setPaintColour(RendererState state, boolean isFill, SVG.SvgPaint paint) {
        int col;
        SVG.Style style = state.style;
        float paintOpacity = (isFill ? style.fillOpacity : style.strokeOpacity).floatValue();
        if (paint instanceof SVG.Colour) {
            col = ((SVG.Colour) paint).colour;
        } else if (paint instanceof SVG.CurrentColor) {
            col = state.style.color.colour;
        } else {
            return;
        }
        int col2 = colourWithOpacity(col, paintOpacity);
        if (isFill) {
            state.fillPaint.setColor(col2);
        } else {
            state.strokePaint.setColor(col2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:0x005d  */
    private Typeface checkGenericFont(String fontName, Integer fontWeight, SVG.Style.FontStyle fontStyle) {
        int typefaceStyle;
        boolean italic = fontStyle == SVG.Style.FontStyle.Italic;
        if (fontWeight.intValue() > 500) {
            typefaceStyle = italic ? 3 : 1;
        } else {
            typefaceStyle = italic ? 2 : 0;
        }
        switch (fontName) {
            case "serif":
                Typeface font = Typeface.create(Typeface.SERIF, typefaceStyle);
                return font;
            case "sans-serif":
                Typeface font2 = Typeface.create(Typeface.SANS_SERIF, typefaceStyle);
                return font2;
            case "monospace":
                Typeface font3 = Typeface.create(Typeface.MONOSPACE, typefaceStyle);
                return font3;
            case "cursive":
                Typeface font4 = Typeface.create(Typeface.SANS_SERIF, typefaceStyle);
                return font4;
            case "fantasy":
                Typeface font5 = Typeface.create(Typeface.SANS_SERIF, typefaceStyle);
                return font5;
            default:
                return null;
        }
    }

    private static int clamp255(float val) {
        int i = (int) (256.0f * val);
        if (i < 0) {
            return 0;
        }
        if (i > 255) {
            return 255;
        }
        return i;
    }

    private static int colourWithOpacity(int colour, float opacity) {
        int alpha = 255;
        int alpha2 = Math.round(((colour >> 24) & 255) * opacity);
        if (alpha2 < 0) {
            alpha = 0;
        } else if (alpha2 <= 255) {
            alpha = alpha2;
        }
        return (alpha << 24) | (16777215 & colour);
    }

    private Path.FillType getFillTypeFromState() {
        if (this.state.style.fillRule != null && this.state.style.fillRule == SVG.Style.FillRule.EvenOdd) {
            return Path.FillType.EVEN_ODD;
        }
        return Path.FillType.WINDING;
    }

    private void setClipRect(float minX, float minY, float width, float height) {
        float left = minX;
        float top = minY;
        float right = minX + width;
        float bottom = minY + height;
        if (this.state.style.clip != null) {
            left += this.state.style.clip.left.floatValueX(this);
            top += this.state.style.clip.top.floatValueY(this);
            right -= this.state.style.clip.right.floatValueX(this);
            bottom -= this.state.style.clip.bottom.floatValueY(this);
        }
        this.canvas.clipRect(left, top, right, bottom);
    }

    private void viewportFill() {
        int col;
        if (this.state.style.viewportFill instanceof SVG.Colour) {
            col = ((SVG.Colour) this.state.style.viewportFill).colour;
        } else if (this.state.style.viewportFill instanceof SVG.CurrentColor) {
            col = this.state.style.color.colour;
        } else {
            return;
        }
        if (this.state.style.viewportFillOpacity != null) {
            col = colourWithOpacity(col, this.state.style.viewportFillOpacity.floatValue());
        }
        this.canvas.drawColor(col);
    }

    private class PathConverter implements SVG.PathInterface {
        float lastX;
        float lastY;
        Path path = new Path();

        PathConverter(SVG.PathDefinition pathDef) {
            if (pathDef == null) {
                return;
            }
            pathDef.enumeratePath(this);
        }

        Path getPath() {
            return this.path;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void moveTo(float x, float y) {
            this.path.moveTo(x, y);
            this.lastX = x;
            this.lastY = y;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void lineTo(float x, float y) {
            this.path.lineTo(x, y);
            this.lastX = x;
            this.lastY = y;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void cubicTo(float x1, float y1, float x2, float y2, float x3, float y3) {
            this.path.cubicTo(x1, y1, x2, y2, x3, y3);
            this.lastX = x3;
            this.lastY = y3;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void quadTo(float x1, float y1, float x2, float y2) {
            this.path.quadTo(x1, y1, x2, y2);
            this.lastX = x2;
            this.lastY = y2;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void arcTo(float rx, float ry, float xAxisRotation, boolean largeArcFlag, boolean sweepFlag, float x, float y) {
            SVGAndroidRenderer.arcTo(this.lastX, this.lastY, rx, ry, xAxisRotation, largeArcFlag, sweepFlag, x, y, this);
            this.lastX = x;
            this.lastY = y;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void close() {
            this.path.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void arcTo(float lastX, float lastY, float rx, float ry, float angle, boolean largeArcFlag, boolean sweepFlag, float x, float y, SVG.PathInterface pather) {
        if (lastX == x && lastY == y) {
            return;
        }
        if (rx == 0.0f || ry == 0.0f) {
            pather.lineTo(x, y);
            return;
        }
        float rx2 = Math.abs(rx);
        float ry2 = Math.abs(ry);
        double angleRad = Math.toRadians(((double) angle) % 360.0d);
        double cosAngle = Math.cos(angleRad);
        double sinAngle = Math.sin(angleRad);
        double dx2 = ((double) (lastX - x)) / 2.0d;
        double dy2 = ((double) (lastY - y)) / 2.0d;
        double x1 = (cosAngle * dx2) + (sinAngle * dy2);
        double y1 = ((-sinAngle) * dx2) + (cosAngle * dy2);
        double rx_sq = rx2 * rx2;
        double ry_sq = ry2 * ry2;
        double x1_sq = x1 * x1;
        double y1_sq = y1 * y1;
        double radiiCheck = (x1_sq / rx_sq) + (y1_sq / ry_sq);
        if (radiiCheck > 0.99999d) {
            double radiiScale = Math.sqrt(radiiCheck) * 1.00001d;
            float rx3 = (float) (((double) rx2) * radiiScale);
            ry2 = (float) (((double) ry2) * radiiScale);
            rx_sq = rx3 * rx3;
            ry_sq = ry2 * ry2;
            rx2 = rx3;
        }
        double sign = largeArcFlag == sweepFlag ? -1.0d : 1.0d;
        double sq = (((rx_sq * ry_sq) - (rx_sq * y1_sq)) - (ry_sq * x1_sq)) / ((rx_sq * y1_sq) + (ry_sq * x1_sq));
        double coef = Math.sqrt(sq < 0.0d ? 0.0d : sq) * sign;
        double cx1 = ((((double) rx2) * y1) / ((double) ry2)) * coef;
        double cy1 = (-((((double) ry2) * x1) / ((double) rx2))) * coef;
        double sx2 = ((double) (lastX + x)) / 2.0d;
        float ry3 = ry2;
        double sy2 = ((double) (lastY + y)) / 2.0d;
        float rx4 = rx2;
        double cx = sx2 + ((cosAngle * cx1) - (sinAngle * cy1));
        double cosAngle2 = sy2 + (sinAngle * cx1) + (cosAngle * cy1);
        double ux = (x1 - cx1) / ((double) rx4);
        double sx3 = ry3;
        double uy = (y1 - cy1) / sx3;
        double vx = ((-x1) - cx1) / ((double) rx4);
        double vy = ((-y1) - cy1) / ((double) ry3);
        double n = Math.sqrt((ux * ux) + (uy * uy));
        double sign2 = uy < 0.0d ? -1.0d : 1.0d;
        double angleStart = Math.acos(ux / n) * sign2;
        double n2 = Math.sqrt(((ux * ux) + (uy * uy)) * ((vx * vx) + (vy * vy)));
        double p = (ux * vx) + (uy * vy);
        double p2 = ux * vy;
        double sign3 = p2 - (uy * vx) >= 0.0d ? 1.0d : -1.0d;
        double angleExtent = checkedArcCos(p / n2) * sign3;
        if (!sweepFlag && angleExtent > 0.0d) {
            angleExtent -= 6.283185307179586d;
        } else if (sweepFlag && angleExtent < 0.0d) {
            angleExtent += 6.283185307179586d;
        }
        double TWO_PI = angleExtent % 6.283185307179586d;
        float[] bezierPoints = arcToBeziers(angleStart % 6.283185307179586d, TWO_PI);
        Matrix m = new Matrix();
        m.postScale(rx4, ry3);
        m.postRotate(angle);
        m.postTranslate((float) cx, (float) cosAngle2);
        m.mapPoints(bezierPoints);
        bezierPoints[bezierPoints.length - 2] = x;
        bezierPoints[bezierPoints.length - 1] = y;
        for (int i = 0; i < bezierPoints.length; i += 6) {
            pather.cubicTo(bezierPoints[i], bezierPoints[i + 1], bezierPoints[i + 2], bezierPoints[i + 3], bezierPoints[i + 4], bezierPoints[i + 5]);
        }
    }

    private static double checkedArcCos(double val) {
        if (val < -1.0d) {
            return 3.141592653589793d;
        }
        if (val > 1.0d) {
            return 0.0d;
        }
        return Math.acos(val);
    }

    private static float[] arcToBeziers(double angleStart, double angleExtent) {
        int numSegments = (int) Math.ceil((Math.abs(angleExtent) * 2.0d) / 3.141592653589793d);
        double angleIncrement = angleExtent / ((double) numSegments);
        double controlLength = (Math.sin(angleIncrement / 2.0d) * 1.3333333333333333d) / (Math.cos(angleIncrement / 2.0d) + 1.0d);
        float[] coords = new float[numSegments * 6];
        int pos = 0;
        int i = 0;
        while (i < numSegments) {
            double angle = angleStart + (((double) i) * angleIncrement);
            double dx = Math.cos(angle);
            double dy = Math.sin(angle);
            int pos2 = pos + 1;
            double angleIncrement2 = angleIncrement;
            int i2 = i;
            coords[pos] = (float) (dx - (controlLength * dy));
            int pos3 = pos2 + 1;
            coords[pos2] = (float) ((controlLength * dx) + dy);
            double angle2 = angle + angleIncrement2;
            double dx2 = Math.cos(angle2);
            double dy2 = Math.sin(angle2);
            int pos4 = pos3 + 1;
            coords[pos3] = (float) ((controlLength * dy2) + dx2);
            int pos5 = pos4 + 1;
            coords[pos4] = (float) (dy2 - (controlLength * dx2));
            int pos6 = pos5 + 1;
            coords[pos5] = (float) dx2;
            pos = pos6 + 1;
            coords[pos6] = (float) dy2;
            i = i2 + 1;
            angleIncrement = angleIncrement2;
        }
        return coords;
    }

    private class MarkerVector {

        /* JADX INFO: renamed from: dx */
        float f315dx;

        /* JADX INFO: renamed from: dy */
        float f316dy;
        boolean isAmbiguous = false;

        /* JADX INFO: renamed from: x */
        float f317x;

        /* JADX INFO: renamed from: y */
        float f318y;

        MarkerVector(float x, float y, float dx, float dy) {
            this.f315dx = 0.0f;
            this.f316dy = 0.0f;
            this.f317x = x;
            this.f318y = y;
            double len = Math.sqrt((dx * dx) + (dy * dy));
            if (len != 0.0d) {
                this.f315dx = (float) (((double) dx) / len);
                this.f316dy = (float) (((double) dy) / len);
            }
        }

        void add(float x, float y) {
            float dx = x - this.f317x;
            float dy = y - this.f318y;
            double len = Math.sqrt((dx * dx) + (dy * dy));
            if (len != 0.0d) {
                dx = (float) (((double) dx) / len);
                dy = (float) (((double) dy) / len);
            }
            if (dx == (-this.f315dx) && dy == (-this.f316dy)) {
                this.isAmbiguous = true;
                this.f315dx = -dy;
                this.f316dy = dx;
            } else {
                this.f315dx += dx;
                this.f316dy += dy;
            }
        }

        void add(MarkerVector v2) {
            if (v2.f315dx == (-this.f315dx) && v2.f316dy == (-this.f316dy)) {
                this.isAmbiguous = true;
                this.f315dx = -v2.f316dy;
                this.f316dy = v2.f315dx;
            } else {
                this.f315dx += v2.f315dx;
                this.f316dy += v2.f316dy;
            }
        }

        public String toString() {
            return "(" + this.f317x + "," + this.f318y + " " + this.f315dx + "," + this.f316dy + ")";
        }
    }

    private class MarkerPositionCalculator implements SVG.PathInterface {
        private boolean closepathReAdjustPending;
        private float startX;
        private float startY;
        private List<MarkerVector> markers = new ArrayList();
        private MarkerVector lastPos = null;
        private boolean startArc = false;
        private boolean normalCubic = true;
        private int subpathStartIndex = -1;

        MarkerPositionCalculator(SVG.PathDefinition pathDef) {
            if (pathDef == null) {
                return;
            }
            pathDef.enumeratePath(this);
            if (this.closepathReAdjustPending) {
                this.lastPos.add(this.markers.get(this.subpathStartIndex));
                this.markers.set(this.subpathStartIndex, this.lastPos);
                this.closepathReAdjustPending = false;
            }
            if (this.lastPos != null) {
                this.markers.add(this.lastPos);
            }
        }

        List<MarkerVector> getMarkers() {
            return this.markers;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void moveTo(float x, float y) {
            if (this.closepathReAdjustPending) {
                this.lastPos.add(this.markers.get(this.subpathStartIndex));
                this.markers.set(this.subpathStartIndex, this.lastPos);
                this.closepathReAdjustPending = false;
            }
            if (this.lastPos != null) {
                this.markers.add(this.lastPos);
            }
            this.startX = x;
            this.startY = y;
            this.lastPos = SVGAndroidRenderer.this.new MarkerVector(x, y, 0.0f, 0.0f);
            this.subpathStartIndex = this.markers.size();
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void lineTo(float x, float y) {
            this.lastPos.add(x, y);
            this.markers.add(this.lastPos);
            this.lastPos = SVGAndroidRenderer.this.new MarkerVector(x, y, x - this.lastPos.f317x, y - this.lastPos.f318y);
            this.closepathReAdjustPending = false;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void cubicTo(float x1, float y1, float x2, float y2, float x3, float y3) {
            if (this.normalCubic || this.startArc) {
                this.lastPos.add(x1, y1);
                this.markers.add(this.lastPos);
                this.startArc = false;
            }
            this.lastPos = SVGAndroidRenderer.this.new MarkerVector(x3, y3, x3 - x2, y3 - y2);
            this.closepathReAdjustPending = false;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void quadTo(float x1, float y1, float x2, float y2) {
            this.lastPos.add(x1, y1);
            this.markers.add(this.lastPos);
            this.lastPos = SVGAndroidRenderer.this.new MarkerVector(x2, y2, x2 - x1, y2 - y1);
            this.closepathReAdjustPending = false;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void arcTo(float rx, float ry, float xAxisRotation, boolean largeArcFlag, boolean sweepFlag, float x, float y) {
            this.startArc = true;
            this.normalCubic = false;
            SVGAndroidRenderer.arcTo(this.lastPos.f317x, this.lastPos.f318y, rx, ry, xAxisRotation, largeArcFlag, sweepFlag, x, y, this);
            this.normalCubic = true;
            this.closepathReAdjustPending = false;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void close() {
            this.markers.add(this.lastPos);
            lineTo(this.startX, this.startY);
            this.closepathReAdjustPending = true;
        }
    }

    private void renderMarkers(SVG.GraphicsElement obj) {
        List<MarkerVector> markers;
        int markerCount;
        if (this.state.style.markerStart == null && this.state.style.markerMid == null && this.state.style.markerEnd == null) {
            return;
        }
        SVG.Marker _markerStart = null;
        SVG.Marker _markerMid = null;
        SVG.Marker _markerEnd = null;
        if (this.state.style.markerStart != null) {
            SVG.SvgObject ref = obj.document.resolveIRI(this.state.style.markerStart);
            if (ref != null) {
                _markerStart = (SVG.Marker) ref;
            } else {
                error("Marker reference '%s' not found", this.state.style.markerStart);
            }
        }
        if (this.state.style.markerMid != null) {
            SVG.SvgObject ref2 = obj.document.resolveIRI(this.state.style.markerMid);
            if (ref2 != null) {
                _markerMid = (SVG.Marker) ref2;
            } else {
                error("Marker reference '%s' not found", this.state.style.markerMid);
            }
        }
        if (this.state.style.markerEnd != null) {
            SVG.SvgObject ref3 = obj.document.resolveIRI(this.state.style.markerEnd);
            if (ref3 != null) {
                _markerEnd = (SVG.Marker) ref3;
            } else {
                error("Marker reference '%s' not found", this.state.style.markerEnd);
            }
        }
        if (obj instanceof SVG.Path) {
            markers = new MarkerPositionCalculator(((SVG.Path) obj).f282d).getMarkers();
        } else if (obj instanceof SVG.Line) {
            markers = calculateMarkerPositions((SVG.Line) obj);
        } else {
            markers = calculateMarkerPositions((SVG.PolyLine) obj);
        }
        if (markers == null || (markerCount = markers.size()) == 0) {
            return;
        }
        SVG.Style style = this.state.style;
        SVG.Style style2 = this.state.style;
        this.state.style.markerEnd = null;
        style2.markerMid = null;
        style.markerStart = null;
        if (_markerStart != null) {
            renderMarker(_markerStart, markers.get(0));
        }
        if (_markerMid != null && markers.size() > 2) {
            MarkerVector lastPos = markers.get(0);
            MarkerVector thisPos = markers.get(1);
            for (int i = 1; i < markerCount - 1; i++) {
                MarkerVector nextPos = markers.get(i + 1);
                if (thisPos.isAmbiguous) {
                    thisPos = realignMarkerMid(lastPos, thisPos, nextPos);
                }
                renderMarker(_markerMid, thisPos);
                lastPos = thisPos;
                thisPos = nextPos;
            }
        }
        if (_markerEnd != null) {
            renderMarker(_markerEnd, markers.get(markerCount - 1));
        }
    }

    private MarkerVector realignMarkerMid(MarkerVector lastPos, MarkerVector thisPos, MarkerVector nextPos) {
        float dot = dotProduct(thisPos.f315dx, thisPos.f316dy, thisPos.f317x - lastPos.f317x, thisPos.f318y - lastPos.f318y);
        if (dot == 0.0f) {
            dot = dotProduct(thisPos.f315dx, thisPos.f316dy, nextPos.f317x - thisPos.f317x, nextPos.f318y - thisPos.f318y);
        }
        if (dot > 0.0f) {
            return thisPos;
        }
        if (dot == 0.0f && (thisPos.f315dx > 0.0f || thisPos.f316dy >= 0.0f)) {
            return thisPos;
        }
        thisPos.f315dx = -thisPos.f315dx;
        thisPos.f316dy = -thisPos.f316dy;
        return thisPos;
    }

    private float dotProduct(float x1, float y1, float x2, float y2) {
        return (x1 * x2) + (y1 * y2);
    }

    private void renderMarker(SVG.Marker marker, MarkerVector pos) {
        float yOffset;
        float angle = 0.0f;
        statePush();
        if (marker.orient != null) {
            if (!Float.isNaN(marker.orient.floatValue())) {
                angle = marker.orient.floatValue();
            } else if (pos.f315dx != 0.0f || pos.f316dy != 0.0f) {
                angle = (float) Math.toDegrees(Math.atan2(pos.f316dy, pos.f315dx));
            }
        }
        float unitsScale = marker.markerUnitsAreUser ? 1.0f : this.state.style.strokeWidth.floatValue(this.dpi);
        this.state = findInheritFromAncestorState(marker);
        Matrix m = new Matrix();
        m.preTranslate(pos.f317x, pos.f318y);
        m.preRotate(angle);
        m.preScale(unitsScale, unitsScale);
        float _refX = marker.refX != null ? marker.refX.floatValueX(this) : 0.0f;
        float _refY = marker.refY != null ? marker.refY.floatValueY(this) : 0.0f;
        float _markerWidth = marker.markerWidth != null ? marker.markerWidth.floatValueX(this) : 3.0f;
        float _markerHeight = marker.markerHeight != null ? marker.markerHeight.floatValueY(this) : 3.0f;
        if (marker.viewBox != null) {
            float xScale = _markerWidth / marker.viewBox.width;
            float yScale = _markerHeight / marker.viewBox.height;
            PreserveAspectRatio positioning = marker.preserveAspectRatio != null ? marker.preserveAspectRatio : PreserveAspectRatio.LETTERBOX;
            if (!positioning.equals(PreserveAspectRatio.STRETCH)) {
                float aspectScale = positioning.getScale() == PreserveAspectRatio.Scale.slice ? Math.max(xScale, yScale) : Math.min(xScale, yScale);
                yScale = aspectScale;
                xScale = aspectScale;
            }
            m.preTranslate((-_refX) * xScale, (-_refY) * yScale);
            this.canvas.concat(m);
            float imageW = marker.viewBox.width * xScale;
            float imageH = marker.viewBox.height * yScale;
            float xOffset = 0.0f;
            switch (positioning.getAlignment()) {
                case xMidYMin:
                case xMidYMid:
                case xMidYMax:
                    xOffset = 0.0f - ((_markerWidth - imageW) / 2.0f);
                    break;
                case xMaxYMin:
                case xMaxYMid:
                case xMaxYMax:
                    xOffset = 0.0f - (_markerWidth - imageW);
                    break;
            }
            switch (positioning.getAlignment()) {
                case xMidYMid:
                case xMaxYMid:
                case xMinYMid:
                    float yOffset2 = 0.0f - ((_markerHeight - imageH) / 2.0f);
                    yOffset = yOffset2;
                    break;
                case xMidYMax:
                case xMaxYMax:
                case xMinYMax:
                    float yOffset3 = 0.0f - (_markerHeight - imageH);
                    yOffset = yOffset3;
                    break;
                case xMaxYMin:
                default:
                    yOffset = 0.0f;
                    break;
            }
            if (!this.state.style.overflow.booleanValue()) {
                setClipRect(xOffset, yOffset, _markerWidth, _markerHeight);
            }
            m.reset();
            m.preScale(xScale, yScale);
            this.canvas.concat(m);
        } else {
            m.preTranslate(-_refX, -_refY);
            this.canvas.concat(m);
            if (!this.state.style.overflow.booleanValue()) {
                setClipRect(0.0f, 0.0f, _markerWidth, _markerHeight);
            }
        }
        boolean compositing = pushLayer();
        renderChildren(marker, false);
        if (compositing) {
            popLayer(marker);
        }
        statePop();
    }

    private RendererState findInheritFromAncestorState(SVG.SvgObject obj) {
        RendererState newState = new RendererState();
        updateStyle(newState, SVG.Style.getDefaultStyle());
        return findInheritFromAncestorState(obj, newState);
    }

    private RendererState findInheritFromAncestorState(SVG.SvgObject obj, RendererState newState) {
        List<SVG.SvgElementBase> ancestors = new ArrayList<>();
        while (true) {
            if (obj instanceof SVG.SvgElementBase) {
                ancestors.add(0, (SVG.SvgElementBase) obj);
            }
            if (obj.parent == null) {
                break;
            }
            obj = (SVG.SvgObject) obj.parent;
        }
        for (SVG.SvgElementBase ancestor : ancestors) {
            updateStyleForElement(newState, ancestor);
        }
        newState.viewBox = this.state.viewBox;
        newState.viewPort = this.state.viewPort;
        return newState;
    }

    private void checkForGradientsAndPatterns(SVG.SvgElement obj) {
        if (this.state.style.fill instanceof SVG.PaintReference) {
            decodePaintReference(true, obj.boundingBox, (SVG.PaintReference) this.state.style.fill);
        }
        if (this.state.style.stroke instanceof SVG.PaintReference) {
            decodePaintReference(false, obj.boundingBox, (SVG.PaintReference) this.state.style.stroke);
        }
    }

    private void decodePaintReference(boolean isFill, SVG.Box boundingBox, SVG.PaintReference paintref) {
        SVG.SvgObject ref = this.document.resolveIRI(paintref.href);
        if (ref == null) {
            error("%s reference '%s' not found", isFill ? "Fill" : "Stroke", paintref.href);
            if (paintref.fallback != null) {
                setPaintColour(this.state, isFill, paintref.fallback);
                return;
            } else if (isFill) {
                this.state.hasFill = false;
                return;
            } else {
                this.state.hasStroke = false;
                return;
            }
        }
        if (ref instanceof SVG.SvgLinearGradient) {
            makeLinearGradient(isFill, boundingBox, (SVG.SvgLinearGradient) ref);
        } else if (ref instanceof SVG.SvgRadialGradient) {
            makeRadialGradient(isFill, boundingBox, (SVG.SvgRadialGradient) ref);
        } else if (ref instanceof SVG.SolidColor) {
            setSolidColor(isFill, (SVG.SolidColor) ref);
        }
    }

    private void makeLinearGradient(boolean isFill, SVG.Box boundingBox, SVG.SvgLinearGradient gradient) {
        float _y1;
        float _x2;
        float _x1;
        float _y2;
        if (gradient.href != null) {
            fillInChainedGradientFields(gradient, gradient.href);
        }
        boolean userUnits = gradient.gradientUnitsAreUser != null && gradient.gradientUnitsAreUser.booleanValue();
        RendererState rendererState = this.state;
        Paint paint = isFill ? rendererState.fillPaint : rendererState.strokePaint;
        if (userUnits) {
            SVG.Box viewPortUser = getCurrentViewPortInUserUnits();
            _x1 = gradient.f292x1 != null ? gradient.f292x1.floatValueX(this) : 0.0f;
            _y1 = gradient.f294y1 != null ? gradient.f294y1.floatValueY(this) : 0.0f;
            _x2 = gradient.f293x2 != null ? gradient.f293x2.floatValueX(this) : viewPortUser.width;
            _y2 = gradient.f295y2 != null ? gradient.f295y2.floatValueY(this) : 0.0f;
        } else {
            float _x3 = gradient.f292x1 != null ? gradient.f292x1.floatValue(this, 1.0f) : 0.0f;
            _y1 = gradient.f294y1 != null ? gradient.f294y1.floatValue(this, 1.0f) : 0.0f;
            _x2 = gradient.f293x2 != null ? gradient.f293x2.floatValue(this, 1.0f) : 1.0f;
            _x1 = _x3;
            _y2 = gradient.f295y2 != null ? gradient.f295y2.floatValue(this, 1.0f) : 0.0f;
        }
        statePush();
        this.state = findInheritFromAncestorState(gradient);
        Matrix m = new Matrix();
        if (!userUnits) {
            m.preTranslate(boundingBox.minX, boundingBox.minY);
            m.preScale(boundingBox.width, boundingBox.height);
        }
        if (gradient.gradientTransform != null) {
            m.preConcat(gradient.gradientTransform);
        }
        int numStops = gradient.children.size();
        if (numStops == 0) {
            statePop();
            if (isFill) {
                this.state.hasFill = false;
                return;
            } else {
                this.state.hasStroke = false;
                return;
            }
        }
        int[] colours = new int[numStops];
        float[] positions = new float[numStops];
        int i = 0;
        float lastOffset = -1.0f;
        for (SVG.SvgObject child : gradient.children) {
            SVG.Stop stop = (SVG.Stop) child;
            float offset = stop.offset != null ? stop.offset.floatValue() : 0.0f;
            if (i == 0 || offset >= lastOffset) {
                positions[i] = offset;
                lastOffset = offset;
            } else {
                positions[i] = lastOffset;
            }
            statePush();
            updateStyleForElement(this.state, stop);
            SVG.Colour col = (SVG.Colour) this.state.style.stopColor;
            if (col == null) {
                col = SVG.Colour.BLACK;
            }
            colours[i] = colourWithOpacity(col.colour, this.state.style.stopOpacity.floatValue());
            i++;
            statePop();
            userUnits = userUnits;
        }
        if ((_x1 == _x2 && _y1 == _y2) || numStops == 1) {
            statePop();
            paint.setColor(colours[numStops - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        if (gradient.spreadMethod != null) {
            if (gradient.spreadMethod == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (gradient.spreadMethod == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        statePop();
        LinearGradient gr = new LinearGradient(_x1, _y1, _x2, _y2, colours, positions, tileMode);
        gr.setLocalMatrix(m);
        paint.setShader(gr);
        paint.setAlpha(clamp255(this.state.style.fillOpacity.floatValue()));
    }

    private void makeRadialGradient(boolean isFill, SVG.Box boundingBox, SVG.SvgRadialGradient gradient) {
        float _cy;
        float _cx;
        float _r;
        if (gradient.href != null) {
            fillInChainedGradientFields(gradient, gradient.href);
        }
        boolean userUnits = gradient.gradientUnitsAreUser != null && gradient.gradientUnitsAreUser.booleanValue();
        RendererState rendererState = this.state;
        Paint paint = isFill ? rendererState.fillPaint : rendererState.strokePaint;
        if (userUnits) {
            SVG.Length fiftyPercent = new SVG.Length(50.0f, SVG.Unit.percent);
            _cx = gradient.f296cx != null ? gradient.f296cx.floatValueX(this) : fiftyPercent.floatValueX(this);
            _cy = gradient.f297cy != null ? gradient.f297cy.floatValueY(this) : fiftyPercent.floatValueY(this);
            _r = gradient.f300r != null ? gradient.f300r.floatValue(this) : fiftyPercent.floatValue(this);
        } else {
            float _cx2 = gradient.f296cx != null ? gradient.f296cx.floatValue(this, 1.0f) : 0.5f;
            float _cy2 = gradient.f297cy != null ? gradient.f297cy.floatValue(this, 1.0f) : 0.5f;
            _cy = _cy2;
            _cx = _cx2;
            _r = gradient.f300r != null ? gradient.f300r.floatValue(this, 1.0f) : 0.5f;
        }
        statePush();
        this.state = findInheritFromAncestorState(gradient);
        Matrix m = new Matrix();
        if (!userUnits) {
            m.preTranslate(boundingBox.minX, boundingBox.minY);
            m.preScale(boundingBox.width, boundingBox.height);
        }
        if (gradient.gradientTransform != null) {
            m.preConcat(gradient.gradientTransform);
        }
        int numStops = gradient.children.size();
        if (numStops == 0) {
            statePop();
            if (isFill) {
                this.state.hasFill = false;
                return;
            } else {
                this.state.hasStroke = false;
                return;
            }
        }
        int[] colours = new int[numStops];
        float[] positions = new float[numStops];
        int i = 0;
        float lastOffset = -1.0f;
        for (SVG.SvgObject child : gradient.children) {
            SVG.Stop stop = (SVG.Stop) child;
            float offset = stop.offset != null ? stop.offset.floatValue() : 0.0f;
            if (i == 0 || offset >= lastOffset) {
                positions[i] = offset;
                lastOffset = offset;
            } else {
                positions[i] = lastOffset;
            }
            statePush();
            updateStyleForElement(this.state, stop);
            SVG.Colour col = (SVG.Colour) this.state.style.stopColor;
            if (col == null) {
                col = SVG.Colour.BLACK;
            }
            colours[i] = colourWithOpacity(col.colour, this.state.style.stopOpacity.floatValue());
            i++;
            statePop();
            userUnits = userUnits;
        }
        if (_r == 0.0f || numStops == 1) {
            statePop();
            paint.setColor(colours[numStops - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        if (gradient.spreadMethod != null) {
            if (gradient.spreadMethod == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (gradient.spreadMethod == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        statePop();
        RadialGradient gr = new RadialGradient(_cx, _cy, _r, colours, positions, tileMode);
        gr.setLocalMatrix(m);
        paint.setShader(gr);
        paint.setAlpha(clamp255(this.state.style.fillOpacity.floatValue()));
    }

    private void fillInChainedGradientFields(SVG.GradientElement gradient, String href) {
        SVG.SvgObject ref = gradient.document.resolveIRI(href);
        if (ref == null) {
            warn("Gradient reference '%s' not found", href);
            return;
        }
        if (!(ref instanceof SVG.GradientElement)) {
            error("Gradient href attributes must point to other gradient elements", new Object[0]);
            return;
        }
        if (ref == gradient) {
            error("Circular reference in gradient href attribute '%s'", href);
            return;
        }
        SVG.GradientElement grRef = (SVG.GradientElement) ref;
        if (gradient.gradientUnitsAreUser == null) {
            gradient.gradientUnitsAreUser = grRef.gradientUnitsAreUser;
        }
        if (gradient.gradientTransform == null) {
            gradient.gradientTransform = grRef.gradientTransform;
        }
        if (gradient.spreadMethod == null) {
            gradient.spreadMethod = grRef.spreadMethod;
        }
        if (gradient.children.isEmpty()) {
            gradient.children = grRef.children;
        }
        try {
            if (gradient instanceof SVG.SvgLinearGradient) {
                fillInChainedGradientFields((SVG.SvgLinearGradient) gradient, (SVG.SvgLinearGradient) ref);
            } else {
                fillInChainedGradientFields((SVG.SvgRadialGradient) gradient, (SVG.SvgRadialGradient) ref);
            }
        } catch (ClassCastException e) {
        }
        if (grRef.href != null) {
            fillInChainedGradientFields(gradient, grRef.href);
        }
    }

    private void fillInChainedGradientFields(SVG.SvgLinearGradient gradient, SVG.SvgLinearGradient grRef) {
        if (gradient.f292x1 == null) {
            gradient.f292x1 = grRef.f292x1;
        }
        if (gradient.f294y1 == null) {
            gradient.f294y1 = grRef.f294y1;
        }
        if (gradient.f293x2 == null) {
            gradient.f293x2 = grRef.f293x2;
        }
        if (gradient.f295y2 == null) {
            gradient.f295y2 = grRef.f295y2;
        }
    }

    private void fillInChainedGradientFields(SVG.SvgRadialGradient gradient, SVG.SvgRadialGradient grRef) {
        if (gradient.f296cx == null) {
            gradient.f296cx = grRef.f296cx;
        }
        if (gradient.f297cy == null) {
            gradient.f297cy = grRef.f297cy;
        }
        if (gradient.f300r == null) {
            gradient.f300r = grRef.f300r;
        }
        if (gradient.f298fx == null) {
            gradient.f298fx = grRef.f298fx;
        }
        if (gradient.f299fy == null) {
            gradient.f299fy = grRef.f299fy;
        }
    }

    private void setSolidColor(boolean isFill, SVG.SolidColor ref) {
        if (isFill) {
            if (isSpecified(ref.baseStyle, 2147483648L)) {
                this.state.style.fill = ref.baseStyle.solidColor;
                this.state.hasFill = ref.baseStyle.solidColor != null;
            }
            if (isSpecified(ref.baseStyle, 4294967296L)) {
                this.state.style.fillOpacity = ref.baseStyle.solidOpacity;
            }
            if (isSpecified(ref.baseStyle, 6442450944L)) {
                setPaintColour(this.state, isFill, this.state.style.fill);
                return;
            }
            return;
        }
        if (isSpecified(ref.baseStyle, 2147483648L)) {
            this.state.style.stroke = ref.baseStyle.solidColor;
            this.state.hasStroke = ref.baseStyle.solidColor != null;
        }
        if (isSpecified(ref.baseStyle, 4294967296L)) {
            this.state.style.strokeOpacity = ref.baseStyle.solidOpacity;
        }
        if (isSpecified(ref.baseStyle, 6442450944L)) {
            setPaintColour(this.state, isFill, this.state.style.stroke);
        }
    }

    private void checkForClipPath(SVG.SvgElement obj) {
        checkForClipPath(obj, obj.boundingBox);
    }

    private void checkForClipPath(SVG.SvgElement obj, SVG.Box boundingBox) {
        Path combinedPath;
        if (this.state.style.clipPath != null && (combinedPath = calculateClipPath(obj, boundingBox)) != null) {
            this.canvas.clipPath(combinedPath);
        }
    }

    private Path calculateClipPath(SVG.SvgElement obj, SVG.Box boundingBox) {
        Path part;
        SVG.SvgObject ref = obj.document.resolveIRI(this.state.style.clipPath);
        if (ref == null) {
            error("ClipPath reference '%s' not found", this.state.style.clipPath);
            return null;
        }
        SVG.ClipPath clipPath = (SVG.ClipPath) ref;
        this.stateStack.push(this.state);
        this.state = findInheritFromAncestorState(clipPath);
        boolean userUnits = clipPath.clipPathUnitsAreUser == null || clipPath.clipPathUnitsAreUser.booleanValue();
        Matrix m = new Matrix();
        if (!userUnits) {
            m.preTranslate(boundingBox.minX, boundingBox.minY);
            m.preScale(boundingBox.width, boundingBox.height);
        }
        if (clipPath.transform != null) {
            m.preConcat(clipPath.transform);
        }
        Path combinedPath = new Path();
        for (SVG.SvgObject child : clipPath.children) {
            if ((child instanceof SVG.SvgElement) && (part = objectToPath((SVG.SvgElement) child, true)) != null) {
                combinedPath.op(part, Path.Op.UNION);
            }
        }
        if (this.state.style.clipPath != null) {
            if (clipPath.boundingBox == null) {
                clipPath.boundingBox = calculatePathBounds(combinedPath);
            }
            Path clipClipPath = calculateClipPath(clipPath, clipPath.boundingBox);
            if (clipClipPath != null) {
                combinedPath.op(clipClipPath, Path.Op.INTERSECT);
            }
        }
        combinedPath.transform(m);
        this.state = this.stateStack.pop();
        return combinedPath;
    }

    private Path objectToPath(SVG.SvgElement obj, boolean allowUse) {
        Path childsClipPath;
        this.stateStack.push(this.state);
        this.state = new RendererState(this.state);
        updateStyleForElement(this.state, obj);
        if (!display() || !visible()) {
            this.state = this.stateStack.pop();
            return null;
        }
        Path path = null;
        if (obj instanceof SVG.Use) {
            if (!allowUse) {
                error("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
            }
            SVG.Use useElement = (SVG.Use) obj;
            SVG.SvgObject ref = obj.document.resolveIRI(useElement.href);
            if (ref == null) {
                error("Use reference '%s' not found", useElement.href);
                this.state = this.stateStack.pop();
                return null;
            }
            if (!(ref instanceof SVG.SvgElement)) {
                this.state = this.stateStack.pop();
                return null;
            }
            path = objectToPath((SVG.SvgElement) ref, false);
            if (path == null) {
                return null;
            }
            if (useElement.boundingBox == null) {
                useElement.boundingBox = calculatePathBounds(path);
            }
            if (useElement.transform != null) {
                path.transform(useElement.transform);
            }
        } else if (obj instanceof SVG.GraphicsElement) {
            SVG.GraphicsElement elem = (SVG.GraphicsElement) obj;
            if (obj instanceof SVG.Path) {
                SVG.Path pathElem = (SVG.Path) obj;
                path = new PathConverter(pathElem.f282d).getPath();
                if (obj.boundingBox == null) {
                    obj.boundingBox = calculatePathBounds(path);
                }
            } else if (obj instanceof SVG.Rect) {
                path = makePathAndBoundingBox((SVG.Rect) obj);
            } else if (obj instanceof SVG.Circle) {
                path = makePathAndBoundingBox((SVG.Circle) obj);
            } else if (obj instanceof SVG.Ellipse) {
                path = makePathAndBoundingBox((SVG.Ellipse) obj);
            } else if (obj instanceof SVG.PolyLine) {
                path = makePathAndBoundingBox((SVG.PolyLine) obj);
            }
            if (path == null) {
                return null;
            }
            if (elem.boundingBox == null) {
                elem.boundingBox = calculatePathBounds(path);
            }
            if (elem.transform != null) {
                path.transform(elem.transform);
            }
            path.setFillType(getClipRuleFromState());
        } else {
            if (!(obj instanceof SVG.Text)) {
                error("Invalid %s element found in clipPath definition", obj.getNodeName());
                return null;
            }
            SVG.Text textElem = (SVG.Text) obj;
            path = makePathAndBoundingBox(textElem);
            if (path == null) {
                return null;
            }
            if (textElem.transform != null) {
                path.transform(textElem.transform);
            }
            path.setFillType(getClipRuleFromState());
        }
        if (this.state.style.clipPath != null && (childsClipPath = calculateClipPath(obj, obj.boundingBox)) != null) {
            path.op(childsClipPath, Path.Op.INTERSECT);
        }
        this.state = this.stateStack.pop();
        return path;
    }

    private void checkForClipPath_OldStyle(SVG.SvgElement obj, SVG.Box boundingBox) {
        SVG.SvgObject ref = obj.document.resolveIRI(this.state.style.clipPath);
        if (ref == null) {
            error("ClipPath reference '%s' not found", this.state.style.clipPath);
            return;
        }
        SVG.ClipPath clipPath = (SVG.ClipPath) ref;
        if (clipPath.children.isEmpty()) {
            this.canvas.clipRect(0, 0, 0, 0);
            return;
        }
        boolean userUnits = clipPath.clipPathUnitsAreUser == null || clipPath.clipPathUnitsAreUser.booleanValue();
        if ((obj instanceof SVG.Group) && !userUnits) {
            warn("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", obj.getNodeName());
            return;
        }
        clipStatePush();
        if (!userUnits) {
            Matrix m = new Matrix();
            m.preTranslate(boundingBox.minX, boundingBox.minY);
            m.preScale(boundingBox.width, boundingBox.height);
            this.canvas.concat(m);
        }
        if (clipPath.transform != null) {
            this.canvas.concat(clipPath.transform);
        }
        this.state = findInheritFromAncestorState(clipPath);
        checkForClipPath(clipPath);
        Path combinedPath = new Path();
        for (SVG.SvgObject child : clipPath.children) {
            addObjectToClip(child, true, combinedPath, new Matrix());
        }
        this.canvas.clipPath(combinedPath);
        clipStatePop();
    }

    private void addObjectToClip(SVG.SvgObject obj, boolean allowUse, Path combinedPath, Matrix combinedPathMatrix) {
        if (!display()) {
            return;
        }
        clipStatePush();
        if (obj instanceof SVG.Use) {
            if (allowUse) {
                addObjectToClip((SVG.Use) obj, combinedPath, combinedPathMatrix);
            } else {
                error("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
            }
        } else if (obj instanceof SVG.Path) {
            addObjectToClip((SVG.Path) obj, combinedPath, combinedPathMatrix);
        } else if (obj instanceof SVG.Text) {
            addObjectToClip((SVG.Text) obj, combinedPath, combinedPathMatrix);
        } else if (obj instanceof SVG.GraphicsElement) {
            addObjectToClip((SVG.GraphicsElement) obj, combinedPath, combinedPathMatrix);
        } else {
            error("Invalid %s element found in clipPath definition", obj.toString());
        }
        clipStatePop();
    }

    private void clipStatePush() {
        CanvasLegacy.save(this.canvas, CanvasLegacy.MATRIX_SAVE_FLAG);
        this.stateStack.push(this.state);
        this.state = new RendererState(this.state);
    }

    private void clipStatePop() {
        this.canvas.restore();
        this.state = this.stateStack.pop();
    }

    private Path.FillType getClipRuleFromState() {
        if (this.state.style.clipRule != null && this.state.style.clipRule == SVG.Style.FillRule.EvenOdd) {
            return Path.FillType.EVEN_ODD;
        }
        return Path.FillType.WINDING;
    }

    private void addObjectToClip(SVG.Path obj, Path combinedPath, Matrix combinedPathMatrix) {
        updateStyleForElement(this.state, obj);
        if (!display() || !visible()) {
            return;
        }
        if (obj.transform != null) {
            combinedPathMatrix.preConcat(obj.transform);
        }
        Path path = new PathConverter(obj.f282d).getPath();
        if (obj.boundingBox == null) {
            obj.boundingBox = calculatePathBounds(path);
        }
        checkForClipPath(obj);
        combinedPath.setFillType(getClipRuleFromState());
        combinedPath.addPath(path, combinedPathMatrix);
    }

    private void addObjectToClip(SVG.GraphicsElement obj, Path combinedPath, Matrix combinedPathMatrix) {
        Path path;
        updateStyleForElement(this.state, obj);
        if (!display() || !visible()) {
            return;
        }
        if (obj.transform != null) {
            combinedPathMatrix.preConcat(obj.transform);
        }
        if (obj instanceof SVG.Rect) {
            path = makePathAndBoundingBox((SVG.Rect) obj);
        } else if (obj instanceof SVG.Circle) {
            path = makePathAndBoundingBox((SVG.Circle) obj);
        } else if (obj instanceof SVG.Ellipse) {
            path = makePathAndBoundingBox((SVG.Ellipse) obj);
        } else if (obj instanceof SVG.PolyLine) {
            path = makePathAndBoundingBox((SVG.PolyLine) obj);
        } else {
            return;
        }
        checkForClipPath(obj);
        combinedPath.setFillType(getClipRuleFromState());
        combinedPath.addPath(path, combinedPathMatrix);
    }

    private void addObjectToClip(SVG.Use obj, Path combinedPath, Matrix combinedPathMatrix) {
        updateStyleForElement(this.state, obj);
        if (!display() || !visible()) {
            return;
        }
        if (obj.transform != null) {
            combinedPathMatrix.preConcat(obj.transform);
        }
        SVG.SvgObject ref = obj.document.resolveIRI(obj.href);
        if (ref == null) {
            error("Use reference '%s' not found", obj.href);
        } else {
            checkForClipPath(obj);
            addObjectToClip(ref, false, combinedPath, combinedPathMatrix);
        }
    }

    private void addObjectToClip(SVG.Text obj, Path combinedPath, Matrix combinedPathMatrix) {
        updateStyleForElement(this.state, obj);
        if (!display()) {
            return;
        }
        if (obj.transform != null) {
            combinedPathMatrix.preConcat(obj.transform);
        }
        float fFloatValueY = 0.0f;
        float x = (obj.f303x == null || obj.f303x.size() == 0) ? 0.0f : obj.f303x.get(0).floatValueX(this);
        float y = (obj.f304y == null || obj.f304y.size() == 0) ? 0.0f : obj.f304y.get(0).floatValueY(this);
        float dx = (obj.f301dx == null || obj.f301dx.size() == 0) ? 0.0f : obj.f301dx.get(0).floatValueX(this);
        if (obj.f302dy != null && obj.f302dy.size() != 0) {
            fFloatValueY = obj.f302dy.get(0).floatValueY(this);
        }
        float dy = fFloatValueY;
        if (this.state.style.textAnchor != SVG.Style.TextAnchor.Start) {
            float textWidth = calculateTextWidth(obj);
            if (this.state.style.textAnchor == SVG.Style.TextAnchor.Middle) {
                x -= textWidth / 2.0f;
            } else {
                x -= textWidth;
            }
        }
        if (obj.boundingBox == null) {
            TextBoundsCalculator proc = new TextBoundsCalculator(x, y);
            enumerateTextSpans(obj, proc);
            obj.boundingBox = new SVG.Box(proc.bbox.left, proc.bbox.top, proc.bbox.width(), proc.bbox.height());
        }
        checkForClipPath(obj);
        Path textAsPath = new Path();
        enumerateTextSpans(obj, new PlainTextToPath(x + dx, y + dy, textAsPath));
        combinedPath.setFillType(getClipRuleFromState());
        combinedPath.addPath(textAsPath, combinedPathMatrix);
    }

    private class PlainTextToPath extends TextProcessor {
        Path textAsPath;

        /* JADX INFO: renamed from: x */
        float f321x;

        /* JADX INFO: renamed from: y */
        float f322y;

        PlainTextToPath(float x, float y, Path textAsPath) {
            super();
            this.f321x = x;
            this.f322y = y;
            this.textAsPath = textAsPath;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public boolean doTextContainer(SVG.TextContainer obj) {
            if (obj instanceof SVG.TextPath) {
                SVGAndroidRenderer.warn("Using <textPath> elements in a clip path is not supported.", new Object[0]);
                return false;
            }
            return true;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String text) {
            if (SVGAndroidRenderer.this.visible()) {
                Path spanPath = new Path();
                SVGAndroidRenderer.this.state.fillPaint.getTextPath(text, 0, text.length(), this.f321x, this.f322y, spanPath);
                this.textAsPath.addPath(spanPath);
            }
            this.f321x += SVGAndroidRenderer.this.state.fillPaint.measureText(text);
        }
    }

    private Path makePathAndBoundingBox(SVG.Line obj) {
        float x1 = obj.f276x1 == null ? 0.0f : obj.f276x1.floatValueX(this);
        float y1 = obj.f278y1 == null ? 0.0f : obj.f278y1.floatValueY(this);
        float x2 = obj.f277x2 == null ? 0.0f : obj.f277x2.floatValueX(this);
        float y2 = obj.f279y2 != null ? obj.f279y2.floatValueY(this) : 0.0f;
        if (obj.boundingBox == null) {
            obj.boundingBox = new SVG.Box(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
        }
        Path p = new Path();
        p.moveTo(x1, y1);
        p.lineTo(x2, y2);
        return p;
    }

    private Path makePathAndBoundingBox(SVG.Rect obj) {
        float rx;
        float ry;
        if (obj.f285rx == null && obj.f286ry == null) {
            rx = 0.0f;
            ry = 0.0f;
        } else if (obj.f285rx == null) {
            rx = obj.f286ry.floatValueY(this);
            ry = rx;
        } else if (obj.f286ry == null) {
            rx = obj.f285rx.floatValueX(this);
            ry = rx;
        } else {
            rx = obj.f285rx.floatValueX(this);
            ry = obj.f286ry.floatValueY(this);
        }
        float rx2 = Math.min(rx, obj.width.floatValueX(this) / 2.0f);
        float ry2 = Math.min(ry, obj.height.floatValueY(this) / 2.0f);
        float x = obj.f287x != null ? obj.f287x.floatValueX(this) : 0.0f;
        float y = obj.f288y != null ? obj.f288y.floatValueY(this) : 0.0f;
        float w = obj.width.floatValueX(this);
        float h = obj.height.floatValueY(this);
        if (obj.boundingBox == null) {
            obj.boundingBox = new SVG.Box(x, y, w, h);
        }
        float right = x + w;
        float bottom = y + h;
        Path p = new Path();
        if (rx2 == 0.0f || ry2 == 0.0f) {
            p.moveTo(x, y);
            p.lineTo(right, y);
            p.lineTo(right, bottom);
            p.lineTo(x, bottom);
            p.lineTo(x, y);
        } else {
            float cpx = rx2 * BEZIER_ARC_FACTOR;
            float cpy = BEZIER_ARC_FACTOR * ry2;
            p.moveTo(x, y + ry2);
            p = p;
            p.cubicTo(x, (y + ry2) - cpy, (x + rx2) - cpx, y, x + rx2, y);
            p.lineTo(right - rx2, y);
            p.cubicTo((right - rx2) + cpx, y, right, (y + ry2) - cpy, right, y + ry2);
            p.lineTo(right, bottom - ry2);
            p.cubicTo(right, (bottom - ry2) + cpy, (right - rx2) + cpx, bottom, right - rx2, bottom);
            p.lineTo(x + rx2, bottom);
            p.cubicTo((x + rx2) - cpx, bottom, x, (bottom - ry2) + cpy, x, bottom - ry2);
            p.lineTo(x, y + ry2);
        }
        p.close();
        return p;
    }

    private Path makePathAndBoundingBox(SVG.Circle obj) {
        float cx = obj.f267cx != null ? obj.f267cx.floatValueX(this) : 0.0f;
        float cy = obj.f268cy != null ? obj.f268cy.floatValueY(this) : 0.0f;
        float r = obj.f269r.floatValue(this);
        float left = cx - r;
        float top = cy - r;
        float right = cx + r;
        float bottom = cy + r;
        if (obj.boundingBox == null) {
            obj.boundingBox = new SVG.Box(left, top, r * 2.0f, 2.0f * r);
        }
        float cp = r * BEZIER_ARC_FACTOR;
        Path p = new Path();
        p.moveTo(cx, top);
        p.cubicTo(cx + cp, top, right, cy - cp, right, cy);
        p.cubicTo(right, cy + cp, cx + cp, bottom, cx, bottom);
        p.cubicTo(cx - cp, bottom, left, cy + cp, left, cy);
        p.cubicTo(left, cy - cp, cx - cp, top, cx, top);
        p.close();
        return p;
    }

    private Path makePathAndBoundingBox(SVG.Ellipse obj) {
        float cx = obj.f270cx != null ? obj.f270cx.floatValueX(this) : 0.0f;
        float cy = obj.f271cy != null ? obj.f271cy.floatValueY(this) : 0.0f;
        float rx = obj.f272rx.floatValueX(this);
        float ry = obj.f273ry.floatValueY(this);
        float left = cx - rx;
        float top = cy - ry;
        float right = cx + rx;
        float bottom = cy + ry;
        if (obj.boundingBox == null) {
            obj.boundingBox = new SVG.Box(left, top, rx * 2.0f, 2.0f * ry);
        }
        float cpx = rx * BEZIER_ARC_FACTOR;
        float cpy = ry * BEZIER_ARC_FACTOR;
        Path p = new Path();
        p.moveTo(cx, top);
        p.cubicTo(cx + cpx, top, right, cy - cpy, right, cy);
        p.cubicTo(right, cy + cpy, cx + cpx, bottom, cx, bottom);
        p.cubicTo(cx - cpx, bottom, left, cy + cpy, left, cy);
        p.cubicTo(left, cy - cpy, cx - cpx, top, cx, top);
        p.close();
        return p;
    }

    private Path makePathAndBoundingBox(SVG.PolyLine obj) {
        Path path = new Path();
        path.moveTo(obj.points[0], obj.points[1]);
        for (int i = 2; i < obj.points.length; i += 2) {
            path.lineTo(obj.points[i], obj.points[i + 1]);
        }
        if (obj instanceof SVG.Polygon) {
            path.close();
        }
        if (obj.boundingBox == null) {
            obj.boundingBox = calculatePathBounds(path);
        }
        return path;
    }

    private Path makePathAndBoundingBox(SVG.Text obj) {
        float fFloatValueY = 0.0f;
        float x = (obj.f303x == null || obj.f303x.size() == 0) ? 0.0f : obj.f303x.get(0).floatValueX(this);
        float y = (obj.f304y == null || obj.f304y.size() == 0) ? 0.0f : obj.f304y.get(0).floatValueY(this);
        float dx = (obj.f301dx == null || obj.f301dx.size() == 0) ? 0.0f : obj.f301dx.get(0).floatValueX(this);
        if (obj.f302dy != null && obj.f302dy.size() != 0) {
            fFloatValueY = obj.f302dy.get(0).floatValueY(this);
        }
        float dy = fFloatValueY;
        if (this.state.style.textAnchor != SVG.Style.TextAnchor.Start) {
            float textWidth = calculateTextWidth(obj);
            if (this.state.style.textAnchor == SVG.Style.TextAnchor.Middle) {
                x -= textWidth / 2.0f;
            } else {
                x -= textWidth;
            }
        }
        if (obj.boundingBox == null) {
            TextBoundsCalculator proc = new TextBoundsCalculator(x, y);
            enumerateTextSpans(obj, proc);
            obj.boundingBox = new SVG.Box(proc.bbox.left, proc.bbox.top, proc.bbox.width(), proc.bbox.height());
        }
        Path textAsPath = new Path();
        enumerateTextSpans(obj, new PlainTextToPath(x + dx, y + dy, textAsPath));
        return textAsPath;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x025f  */
    /* JADX WARN: Code duplicated, block: B:102:0x0273  */
    /* JADX WARN: Code duplicated, block: B:106:0x0285 A[LOOP:3: B:104:0x027f->B:106:0x0285, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:111:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:82:0x0200  */
    /* JADX WARN: Code duplicated, block: B:85:0x0205  */
    /* JADX WARN: Code duplicated, block: B:87:0x0218  */
    /* JADX WARN: Code duplicated, block: B:88:0x022a  */
    /* JADX WARN: Code duplicated, block: B:91:0x0234  */
    /* JADX WARN: Code duplicated, block: B:92:0x0246  */
    /* JADX WARN: Code duplicated, block: B:98:0x0257  */
    private void fillWithPattern(SVG.SvgElement obj, Path path, SVG.Pattern pattern) {
        float x;
        float w;
        float y;
        float w2;
        SVG.Box patternArea;
        float originX;
        float originY;
        float right;
        float bottom;
        SVG.Box stepViewBox;
        boolean compositing;
        float stepY;
        float stepX;
        PreserveAspectRatio positioning;
        boolean patternContentUnitsAreUser;
        PreserveAspectRatio positioning2;
        boolean patternUnitsAreUser = pattern.patternUnitsAreUser != null && pattern.patternUnitsAreUser.booleanValue();
        if (pattern.href != null) {
            fillInChainedPatternFields(pattern, pattern.href);
        }
        if (patternUnitsAreUser) {
            x = pattern.f283x != null ? pattern.f283x.floatValueX(this) : 0.0f;
            y = pattern.f284y != null ? pattern.f284y.floatValueY(this) : 0.0f;
            w2 = pattern.width != null ? pattern.width.floatValueX(this) : 0.0f;
            w = pattern.height != null ? pattern.height.floatValueY(this) : 0.0f;
        } else {
            float x2 = pattern.f283x != null ? pattern.f283x.floatValue(this, 1.0f) : 0.0f;
            float y2 = pattern.f284y != null ? pattern.f284y.floatValue(this, 1.0f) : 0.0f;
            float w3 = pattern.width != null ? pattern.width.floatValue(this, 1.0f) : 0.0f;
            float h = pattern.height != null ? pattern.height.floatValue(this, 1.0f) : 0.0f;
            x = obj.boundingBox.minX + (obj.boundingBox.width * x2);
            float y3 = obj.boundingBox.minY + (obj.boundingBox.height * y2);
            float w4 = w3 * obj.boundingBox.width;
            w = h * obj.boundingBox.height;
            y = y3;
            w2 = w4;
        }
        if (w2 != 0.0f && w != 0.0f) {
            PreserveAspectRatio positioning3 = pattern.preserveAspectRatio != null ? pattern.preserveAspectRatio : PreserveAspectRatio.LETTERBOX;
            statePush();
            this.canvas.clipPath(path);
            RendererState baseState = new RendererState();
            updateStyle(baseState, SVG.Style.getDefaultStyle());
            baseState.style.overflow = false;
            this.state = findInheritFromAncestorState(pattern, baseState);
            SVG.Box patternArea2 = obj.boundingBox;
            if (pattern.patternTransform != null) {
                this.canvas.concat(pattern.patternTransform);
                Matrix inverse = new Matrix();
                if (pattern.patternTransform.invert(inverse)) {
                    float f = obj.boundingBox.minX;
                    float f2 = obj.boundingBox.minY;
                    float fMaxX = obj.boundingBox.maxX();
                    float f3 = obj.boundingBox.minY;
                    float fMaxX2 = obj.boundingBox.maxX();
                    float fMaxY = obj.boundingBox.maxY();
                    SVG.Box patternArea3 = obj.boundingBox;
                    positioning3 = positioning3;
                    float[] pts = {f, f2, fMaxX, f3, fMaxX2, fMaxY, patternArea3.minX, obj.boundingBox.maxY()};
                    inverse.mapPoints(pts);
                    RectF rect = new RectF(pts[0], pts[1], pts[0], pts[1]);
                    for (int i = 2; i <= 6; i += 2) {
                        if (pts[i] < rect.left) {
                            rect.left = pts[i];
                        }
                        if (pts[i] > rect.right) {
                            rect.right = pts[i];
                        }
                        if (pts[i + 1] < rect.top) {
                            rect.top = pts[i + 1];
                        }
                        if (pts[i + 1] > rect.bottom) {
                            rect.bottom = pts[i + 1];
                        }
                    }
                    patternArea = new SVG.Box(rect.left, rect.top, rect.right - rect.left, rect.bottom - rect.top);
                }
                originX = (((float) Math.floor((patternArea.minX - x) / w2)) * w2) + x;
                originY = (((float) Math.floor((patternArea.minY - y) / w)) * w) + y;
                right = patternArea.maxX();
                bottom = patternArea.maxY();
                stepViewBox = new SVG.Box(0.0f, 0.0f, w2, w);
                compositing = pushLayer();
                for (stepY = originY; stepY < bottom; stepY += w) {
                    stepX = originX;
                    while (stepX < right) {
                        stepViewBox.minX = stepX;
                        stepViewBox.minY = stepY;
                        statePush();
                        if (!this.state.style.overflow.booleanValue()) {
                            float f4 = stepViewBox.minX;
                            float originX2 = stepViewBox.minY;
                            float originY2 = stepViewBox.width;
                            float right2 = stepViewBox.height;
                            setClipRect(f4, originX2, originY2, right2);
                        }
                        if (pattern.viewBox != null) {
                            PreserveAspectRatio positioning4 = positioning3;
                            this.canvas.concat(calculateViewBoxTransform(stepViewBox, pattern.viewBox, positioning4));
                            positioning2 = positioning4;
                        } else {
                            positioning = positioning3;
                            if (pattern.patternContentUnitsAreUser != null || pattern.patternContentUnitsAreUser.booleanValue()) {
                                patternContentUnitsAreUser = true;
                            } else {
                                patternContentUnitsAreUser = false;
                            }
                            this.canvas.translate(stepX, stepY);
                            if (patternContentUnitsAreUser) {
                                positioning2 = positioning;
                            } else {
                                positioning2 = positioning;
                                this.canvas.scale(obj.boundingBox.width, obj.boundingBox.height);
                            }
                        }
                        for (SVG.SvgObject child : pattern.children) {
                            render(child);
                        }
                        statePop();
                        stepX += w2;
                        originX = originX;
                        originY = originY;
                        right = right;
                        positioning3 = positioning2;
                    }
                }
                if (compositing) {
                    popLayer(pattern);
                }
                statePop();
            }
            patternArea = patternArea2;
            originX = (((float) Math.floor((patternArea.minX - x) / w2)) * w2) + x;
            originY = (((float) Math.floor((patternArea.minY - y) / w)) * w) + y;
            right = patternArea.maxX();
            bottom = patternArea.maxY();
            stepViewBox = new SVG.Box(0.0f, 0.0f, w2, w);
            compositing = pushLayer();
            while (stepY < bottom) {
                stepX = originX;
                while (stepX < right) {
                    stepViewBox.minX = stepX;
                    stepViewBox.minY = stepY;
                    statePush();
                    if (!this.state.style.overflow.booleanValue()) {
                        float f5 = stepViewBox.minX;
                        float originX3 = stepViewBox.minY;
                        float originY3 = stepViewBox.width;
                        float right3 = stepViewBox.height;
                        setClipRect(f5, originX3, originY3, right3);
                    }
                    if (pattern.viewBox != null) {
                        PreserveAspectRatio positioning5 = positioning3;
                        this.canvas.concat(calculateViewBoxTransform(stepViewBox, pattern.viewBox, positioning5));
                        positioning2 = positioning5;
                    } else {
                        positioning = positioning3;
                        if (pattern.patternContentUnitsAreUser != null) {
                            patternContentUnitsAreUser = true;
                        } else {
                            patternContentUnitsAreUser = true;
                        }
                        this.canvas.translate(stepX, stepY);
                        if (patternContentUnitsAreUser) {
                            positioning2 = positioning;
                            this.canvas.scale(obj.boundingBox.width, obj.boundingBox.height);
                        } else {
                            positioning2 = positioning;
                        }
                    }
                    while (r1.hasNext()) {
                        render(child);
                    }
                    statePop();
                    stepX += w2;
                    originX = originX;
                    originY = originY;
                    right = right;
                    positioning3 = positioning2;
                }
            }
            if (compositing) {
                popLayer(pattern);
            }
            statePop();
        }
    }

    private void fillInChainedPatternFields(SVG.Pattern pattern, String href) {
        SVG.SvgObject ref = pattern.document.resolveIRI(href);
        if (ref == null) {
            warn("Pattern reference '%s' not found", href);
            return;
        }
        if (!(ref instanceof SVG.Pattern)) {
            error("Pattern href attributes must point to other pattern elements", new Object[0]);
            return;
        }
        if (ref == pattern) {
            error("Circular reference in pattern href attribute '%s'", href);
            return;
        }
        SVG.Pattern pRef = (SVG.Pattern) ref;
        if (pattern.patternUnitsAreUser == null) {
            pattern.patternUnitsAreUser = pRef.patternUnitsAreUser;
        }
        if (pattern.patternContentUnitsAreUser == null) {
            pattern.patternContentUnitsAreUser = pRef.patternContentUnitsAreUser;
        }
        if (pattern.patternTransform == null) {
            pattern.patternTransform = pRef.patternTransform;
        }
        if (pattern.f283x == null) {
            pattern.f283x = pRef.f283x;
        }
        if (pattern.f284y == null) {
            pattern.f284y = pRef.f284y;
        }
        if (pattern.width == null) {
            pattern.width = pRef.width;
        }
        if (pattern.height == null) {
            pattern.height = pRef.height;
        }
        if (pattern.children.isEmpty()) {
            pattern.children = pRef.children;
        }
        if (pattern.viewBox == null) {
            pattern.viewBox = pRef.viewBox;
        }
        if (pattern.preserveAspectRatio == null) {
            pattern.preserveAspectRatio = pRef.preserveAspectRatio;
        }
        if (pRef.href != null) {
            fillInChainedPatternFields(pattern, pRef.href);
        }
    }

    private void renderMask(SVG.Mask mask, SVG.SvgElement obj, SVG.Box originalObjBBox) {
        float w;
        float h;
        debug("Mask render", new Object[0]);
        boolean maskContentUnitsAreUser = true;
        boolean maskUnitsAreUser = mask.maskUnitsAreUser != null && mask.maskUnitsAreUser.booleanValue();
        if (maskUnitsAreUser) {
            w = mask.width != null ? mask.width.floatValueX(this) : originalObjBBox.width;
            h = mask.height != null ? mask.height.floatValueY(this) : originalObjBBox.height;
        } else {
            float w2 = mask.width != null ? mask.width.floatValue(this, 1.0f) : 1.2f;
            float h2 = mask.height != null ? mask.height.floatValue(this, 1.0f) : 1.2f;
            w = w2 * originalObjBBox.width;
            h = h2 * originalObjBBox.height;
        }
        if (w == 0.0f || h == 0.0f) {
            return;
        }
        statePush();
        this.state = findInheritFromAncestorState(mask);
        this.state.style.opacity = Float.valueOf(1.0f);
        boolean compositing = pushLayer();
        this.canvas.save();
        if (mask.maskContentUnitsAreUser != null && !mask.maskContentUnitsAreUser.booleanValue()) {
            maskContentUnitsAreUser = false;
        }
        if (!maskContentUnitsAreUser) {
            this.canvas.translate(originalObjBBox.minX, originalObjBBox.minY);
            this.canvas.scale(originalObjBBox.width, originalObjBBox.height);
        }
        renderChildren(mask, false);
        this.canvas.restore();
        if (compositing) {
            popLayer(obj, originalObjBBox);
        }
        statePop();
    }
}
