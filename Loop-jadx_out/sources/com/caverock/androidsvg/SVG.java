package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.util.Log;
import androidx.core.view.ViewCompat;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.p013io.IOUtils;

/* JADX INFO: loaded from: classes.dex */
public class SVG {
    private static final int DEFAULT_PICTURE_HEIGHT = 512;
    private static final int DEFAULT_PICTURE_WIDTH = 512;
    private static final long SPECIFIED_ALL = -1;
    static final long SPECIFIED_CLIP = 1048576;
    static final long SPECIFIED_CLIP_PATH = 268435456;
    static final long SPECIFIED_CLIP_RULE = 536870912;
    static final long SPECIFIED_COLOR = 4096;
    static final long SPECIFIED_DIRECTION = 68719476736L;
    static final long SPECIFIED_DISPLAY = 16777216;
    static final long SPECIFIED_FILL = 1;
    static final long SPECIFIED_FILL_OPACITY = 4;
    static final long SPECIFIED_FILL_RULE = 2;
    static final long SPECIFIED_FONT_FAMILY = 8192;
    static final long SPECIFIED_FONT_SIZE = 16384;
    static final long SPECIFIED_FONT_STYLE = 65536;
    static final long SPECIFIED_FONT_WEIGHT = 32768;
    static final long SPECIFIED_IMAGE_RENDERING = 137438953472L;
    static final long SPECIFIED_MARKER_END = 8388608;
    static final long SPECIFIED_MARKER_MID = 4194304;
    static final long SPECIFIED_MARKER_START = 2097152;
    static final long SPECIFIED_MASK = 1073741824;
    static final long SPECIFIED_OPACITY = 2048;
    static final long SPECIFIED_OVERFLOW = 524288;
    static final long SPECIFIED_SOLID_COLOR = 2147483648L;
    static final long SPECIFIED_SOLID_OPACITY = 4294967296L;
    static final long SPECIFIED_STOP_COLOR = 67108864;
    static final long SPECIFIED_STOP_OPACITY = 134217728;
    static final long SPECIFIED_STROKE = 8;
    static final long SPECIFIED_STROKE_DASHARRAY = 512;
    static final long SPECIFIED_STROKE_DASHOFFSET = 1024;
    static final long SPECIFIED_STROKE_LINECAP = 64;
    static final long SPECIFIED_STROKE_LINEJOIN = 128;
    static final long SPECIFIED_STROKE_MITERLIMIT = 256;
    static final long SPECIFIED_STROKE_OPACITY = 16;
    static final long SPECIFIED_STROKE_WIDTH = 32;
    static final long SPECIFIED_TEXT_ANCHOR = 262144;
    static final long SPECIFIED_TEXT_DECORATION = 131072;
    static final long SPECIFIED_VECTOR_EFFECT = 34359738368L;
    static final long SPECIFIED_VIEWPORT_FILL = 8589934592L;
    static final long SPECIFIED_VIEWPORT_FILL_OPACITY = 17179869184L;
    static final long SPECIFIED_VISIBILITY = 33554432;
    private static final double SQRT2 = 1.414213562373095d;
    private static final String VERSION = "1.4";
    private static SVGExternalFileResolver externalFileResolver = null;
    private static boolean enableInternalEntities = true;
    private Svg rootElement = null;
    private String title = "";
    private String desc = "";
    private float renderDPI = 96.0f;
    private CSSParser.Ruleset cssRules = new CSSParser.Ruleset();
    private Map<String, SvgElementBase> idToElementMap = new HashMap();

    enum GradientSpread {
        pad,
        reflect,
        repeat
    }

    interface HasTransform {
        void setTransform(Matrix matrix);
    }

    interface NotDirectlyRendered {
    }

    interface PathInterface {
        void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5);

        void close();

        void cubicTo(float f, float f2, float f3, float f4, float f5, float f6);

        void lineTo(float f, float f2);

        void moveTo(float f, float f2);

        void quadTo(float f, float f2, float f3, float f4);
    }

    interface SvgConditional {
        String getRequiredExtensions();

        Set<String> getRequiredFeatures();

        Set<String> getRequiredFonts();

        Set<String> getRequiredFormats();

        Set<String> getSystemLanguage();

        void setRequiredExtensions(String str);

        void setRequiredFeatures(Set<String> set);

        void setRequiredFonts(Set<String> set);

        void setRequiredFormats(Set<String> set);

        void setSystemLanguage(Set<String> set);
    }

    interface SvgContainer {
        void addChild(SvgObject svgObject) throws SVGParseException;

        List<SvgObject> getChildren();
    }

    interface TextChild {
        TextRoot getTextRoot();

        void setTextRoot(TextRoot textRoot);
    }

    interface TextRoot {
    }

    enum Unit {
        px,
        em,
        ex,
        in,
        cm,
        mm,
        pt,
        pc,
        percent
    }

    SVG() {
    }

    public static SVG getFromInputStream(InputStream is) throws SVGParseException {
        SVGParser parser = new SVGParser();
        return parser.parse(is, enableInternalEntities);
    }

    public static SVG getFromString(String svg) throws SVGParseException {
        SVGParser parser = new SVGParser();
        return parser.parse(new ByteArrayInputStream(svg.getBytes()), enableInternalEntities);
    }

    public static SVG getFromResource(Context context, int resourceId) throws SVGParseException {
        return getFromResource(context.getResources(), resourceId);
    }

    public static SVG getFromResource(Resources resources, int resourceId) throws SVGParseException {
        SVGParser parser = new SVGParser();
        InputStream is = resources.openRawResource(resourceId);
        try {
            return parser.parse(is, enableInternalEntities);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
            }
        }
    }

    public static SVG getFromAsset(AssetManager assetManager, String filename) throws IOException, SVGParseException {
        SVGParser parser = new SVGParser();
        InputStream is = assetManager.open(filename);
        try {
            return parser.parse(is, enableInternalEntities);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
            }
        }
    }

    public static void setInternalEntitiesEnabled(boolean enable) {
        enableInternalEntities = enable;
    }

    public static boolean isInternalEntitiesEnabled() {
        return enableInternalEntities;
    }

    public static void registerExternalFileResolver(SVGExternalFileResolver fileResolver) {
        externalFileResolver = fileResolver;
    }

    public static void deregisterExternalFileResolver() {
        externalFileResolver = null;
    }

    public void setRenderDPI(float dpi) {
        this.renderDPI = dpi;
    }

    public float getRenderDPI() {
        return this.renderDPI;
    }

    public Picture renderToPicture() {
        return renderToPicture(null);
    }

    public Picture renderToPicture(int widthInPixels, int heightInPixels) {
        return renderToPicture(widthInPixels, heightInPixels, null);
    }

    public Picture renderToPicture(RenderOptions renderOptions) {
        Box viewBox = (renderOptions == null || !renderOptions.hasViewBox()) ? this.rootElement.viewBox : renderOptions.viewBox;
        if (renderOptions != null && renderOptions.hasViewPort()) {
            return renderToPicture((int) Math.ceil(renderOptions.viewPort.maxX()), (int) Math.ceil(renderOptions.viewPort.maxY()), renderOptions);
        }
        if (this.rootElement.width != null && this.rootElement.width.unit != Unit.percent && this.rootElement.height != null && this.rootElement.height.unit != Unit.percent) {
            return renderToPicture((int) Math.ceil(this.rootElement.width.floatValue(this.renderDPI)), (int) Math.ceil(this.rootElement.height.floatValue(this.renderDPI)), renderOptions);
        }
        if (this.rootElement.width != null && viewBox != null) {
            float w = this.rootElement.width.floatValue(this.renderDPI);
            return renderToPicture((int) Math.ceil(w), (int) Math.ceil((viewBox.height * w) / viewBox.width), renderOptions);
        }
        if (this.rootElement.height != null && viewBox != null) {
            float h = this.rootElement.height.floatValue(this.renderDPI);
            return renderToPicture((int) Math.ceil((viewBox.width * h) / viewBox.height), (int) Math.ceil(h), renderOptions);
        }
        return renderToPicture(512, 512, renderOptions);
    }

    public Picture renderToPicture(int widthInPixels, int heightInPixels, RenderOptions renderOptions) {
        Picture picture = new Picture();
        Canvas canvas = picture.beginRecording(widthInPixels, heightInPixels);
        if (renderOptions == null || renderOptions.viewPort == null) {
            renderOptions = renderOptions == null ? new RenderOptions() : new RenderOptions(renderOptions);
            renderOptions.viewPort(0.0f, 0.0f, widthInPixels, heightInPixels);
        }
        SVGAndroidRenderer renderer = new SVGAndroidRenderer(canvas, this.renderDPI);
        renderer.renderDocument(this, renderOptions);
        picture.endRecording();
        return picture;
    }

    public Picture renderViewToPicture(String viewId, int widthInPixels, int heightInPixels) {
        RenderOptions renderOptions = new RenderOptions();
        renderOptions.view(viewId).viewPort(0.0f, 0.0f, widthInPixels, heightInPixels);
        Picture picture = new Picture();
        Canvas canvas = picture.beginRecording(widthInPixels, heightInPixels);
        SVGAndroidRenderer renderer = new SVGAndroidRenderer(canvas, this.renderDPI);
        renderer.renderDocument(this, renderOptions);
        picture.endRecording();
        return picture;
    }

    public void renderToCanvas(Canvas canvas) {
        renderToCanvas(canvas, (RenderOptions) null);
    }

    public void renderToCanvas(Canvas canvas, RectF viewPort) {
        RenderOptions renderOptions = new RenderOptions();
        if (viewPort != null) {
            renderOptions.viewPort(viewPort.left, viewPort.top, viewPort.width(), viewPort.height());
        } else {
            renderOptions.viewPort(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        }
        SVGAndroidRenderer renderer = new SVGAndroidRenderer(canvas, this.renderDPI);
        renderer.renderDocument(this, renderOptions);
    }

    public void renderToCanvas(Canvas canvas, RenderOptions renderOptions) {
        if (renderOptions == null) {
            renderOptions = new RenderOptions();
        }
        if (!renderOptions.hasViewPort()) {
            renderOptions.viewPort(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        }
        SVGAndroidRenderer renderer = new SVGAndroidRenderer(canvas, this.renderDPI);
        renderer.renderDocument(this, renderOptions);
    }

    public void renderViewToCanvas(String viewId, Canvas canvas) {
        renderToCanvas(canvas, RenderOptions.create().view(viewId));
    }

    public void renderViewToCanvas(String viewId, Canvas canvas, RectF viewPort) {
        RenderOptions renderOptions = RenderOptions.create().view(viewId);
        if (viewPort != null) {
            renderOptions.viewPort(viewPort.left, viewPort.top, viewPort.width(), viewPort.height());
        }
        renderToCanvas(canvas, renderOptions);
    }

    public static String getVersion() {
        return VERSION;
    }

    public String getDocumentTitle() {
        if (this.rootElement == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        return this.title;
    }

    public String getDocumentDescription() {
        if (this.rootElement == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        return this.desc;
    }

    public String getDocumentSVGVersion() {
        if (this.rootElement == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        return this.rootElement.version;
    }

    public Set<String> getViewList() {
        if (this.rootElement == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        List<SvgObject> viewElems = getElementsByTagName("view");
        Set<String> viewIds = new HashSet<>(viewElems.size());
        for (SvgObject elem : viewElems) {
            View view = (View) elem;
            if (view.f291id != null) {
                viewIds.add(view.f291id);
            } else {
                Log.w("AndroidSVG", "getViewList(): found a <view> without an id attribute");
            }
        }
        return viewIds;
    }

    public float getDocumentWidth() {
        if (this.rootElement == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        return getDocumentDimensions(this.renderDPI).width;
    }

    public void setDocumentWidth(float pixels) {
        if (this.rootElement == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        this.rootElement.width = new Length(pixels);
    }

    public void setDocumentWidth(String value) throws SVGParseException {
        if (this.rootElement == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        this.rootElement.width = SVGParser.parseLength(value);
    }

    public float getDocumentHeight() {
        if (this.rootElement == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        return getDocumentDimensions(this.renderDPI).height;
    }

    public void setDocumentHeight(float pixels) {
        if (this.rootElement == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        this.rootElement.height = new Length(pixels);
    }

    public void setDocumentHeight(String value) throws SVGParseException {
        if (this.rootElement == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        this.rootElement.height = SVGParser.parseLength(value);
    }

    public void setDocumentViewBox(float minX, float minY, float width, float height) {
        if (this.rootElement == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        this.rootElement.viewBox = new Box(minX, minY, width, height);
    }

    public RectF getDocumentViewBox() {
        if (this.rootElement == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        if (this.rootElement.viewBox == null) {
            return null;
        }
        return this.rootElement.viewBox.toRectF();
    }

    public void setDocumentPreserveAspectRatio(PreserveAspectRatio preserveAspectRatio) {
        if (this.rootElement == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        this.rootElement.preserveAspectRatio = preserveAspectRatio;
    }

    public PreserveAspectRatio getDocumentPreserveAspectRatio() {
        if (this.rootElement == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        if (this.rootElement.preserveAspectRatio == null) {
            return null;
        }
        return this.rootElement.preserveAspectRatio;
    }

    public float getDocumentAspectRatio() {
        if (this.rootElement == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        Length w = this.rootElement.width;
        Length h = this.rootElement.height;
        if (w != null && h != null && w.unit != Unit.percent && h.unit != Unit.percent) {
            if (w.isZero() || h.isZero()) {
                return -1.0f;
            }
            return w.floatValue(this.renderDPI) / h.floatValue(this.renderDPI);
        }
        if (this.rootElement.viewBox == null || this.rootElement.viewBox.width == 0.0f || this.rootElement.viewBox.height == 0.0f) {
            return -1.0f;
        }
        return this.rootElement.viewBox.width / this.rootElement.viewBox.height;
    }

    Svg getRootElement() {
        return this.rootElement;
    }

    void setRootElement(Svg rootElement) {
        this.rootElement = rootElement;
    }

    SvgObject resolveIRI(String iri) {
        if (iri == null) {
            return null;
        }
        String iri2 = cssQuotedString(iri);
        if (iri2.length() <= 1 || !iri2.startsWith("#")) {
            return null;
        }
        return getElementById(iri2.substring(1));
    }

    private String cssQuotedString(String str) {
        if (str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length() - 1).replace("\\\"", "\"");
        } else if (str.startsWith("'") && str.endsWith("'")) {
            str = str.substring(1, str.length() - 1).replace("\\'", "'");
        }
        return str.replace("\\\n", "").replace("\\A", IOUtils.LINE_SEPARATOR_UNIX);
    }

    private Box getDocumentDimensions(float dpi) {
        float hOut;
        Length w = this.rootElement.width;
        Length h = this.rootElement.height;
        if (w == null || w.isZero() || w.unit == Unit.percent || w.unit == Unit.em || w.unit == Unit.ex) {
            return new Box(-1.0f, -1.0f, -1.0f, -1.0f);
        }
        float wOut = w.floatValue(dpi);
        if (h != null) {
            if (h.isZero() || h.unit == Unit.percent || h.unit == Unit.em || h.unit == Unit.ex) {
                return new Box(-1.0f, -1.0f, -1.0f, -1.0f);
            }
            hOut = h.floatValue(dpi);
        } else if (this.rootElement.viewBox != null) {
            hOut = (this.rootElement.viewBox.height * wOut) / this.rootElement.viewBox.width;
        } else {
            hOut = wOut;
        }
        return new Box(0.0f, 0.0f, wOut, hOut);
    }

    void addCSSRules(CSSParser.Ruleset ruleset) {
        this.cssRules.addAll(ruleset);
    }

    List<CSSParser.Rule> getCSSRules() {
        return this.cssRules.getRules();
    }

    boolean hasCSSRules() {
        return !this.cssRules.isEmpty();
    }

    void clearRenderCSSRules() {
        this.cssRules.removeFromSource(CSSParser.Source.RenderOptions);
    }

    static class Box {
        float height;
        float minX;
        float minY;
        float width;

        Box(float minX, float minY, float width, float height) {
            this.minX = minX;
            this.minY = minY;
            this.width = width;
            this.height = height;
        }

        Box(Box copy) {
            this.minX = copy.minX;
            this.minY = copy.minY;
            this.width = copy.width;
            this.height = copy.height;
        }

        static Box fromLimits(float minX, float minY, float maxX, float maxY) {
            return new Box(minX, minY, maxX - minX, maxY - minY);
        }

        RectF toRectF() {
            return new RectF(this.minX, this.minY, maxX(), maxY());
        }

        float maxX() {
            return this.minX + this.width;
        }

        float maxY() {
            return this.minY + this.height;
        }

        void union(Box other) {
            if (other.minX < this.minX) {
                this.minX = other.minX;
            }
            if (other.minY < this.minY) {
                this.minY = other.minY;
            }
            if (other.maxX() > maxX()) {
                this.width = other.maxX() - this.minX;
            }
            if (other.maxY() > maxY()) {
                this.height = other.maxY() - this.minY;
            }
        }

        public String toString() {
            return "[" + this.minX + " " + this.minY + " " + this.width + " " + this.height + "]";
        }
    }

    static class Style implements Cloneable {
        static final int FONT_WEIGHT_BOLD = 700;
        static final int FONT_WEIGHT_BOLDER = 1;
        static final int FONT_WEIGHT_LIGHTER = -1;
        static final int FONT_WEIGHT_NORMAL = 400;
        CSSClipRect clip;
        String clipPath;
        FillRule clipRule;
        Colour color;
        TextDirection direction;
        Boolean display;
        SvgPaint fill;
        Float fillOpacity;
        FillRule fillRule;
        List<String> fontFamily;
        Length fontSize;
        FontStyle fontStyle;
        Integer fontWeight;
        RenderQuality imageRendering;
        String markerEnd;
        String markerMid;
        String markerStart;
        String mask;
        Float opacity;
        Boolean overflow;
        SvgPaint solidColor;
        Float solidOpacity;
        long specifiedFlags = 0;
        SvgPaint stopColor;
        Float stopOpacity;
        SvgPaint stroke;
        Length[] strokeDashArray;
        Length strokeDashOffset;
        LineCap strokeLineCap;
        LineJoin strokeLineJoin;
        Float strokeMiterLimit;
        Float strokeOpacity;
        Length strokeWidth;
        TextAnchor textAnchor;
        TextDecoration textDecoration;
        VectorEffect vectorEffect;
        SvgPaint viewportFill;
        Float viewportFillOpacity;
        Boolean visibility;

        public enum FillRule {
            NonZero,
            EvenOdd
        }

        public enum FontStyle {
            Normal,
            Italic,
            Oblique
        }

        public enum LineCap {
            Butt,
            Round,
            Square
        }

        public enum LineJoin {
            Miter,
            Round,
            Bevel
        }

        public enum RenderQuality {
            auto,
            optimizeQuality,
            optimizeSpeed
        }

        public enum TextAnchor {
            Start,
            Middle,
            End
        }

        public enum TextDecoration {
            None,
            Underline,
            Overline,
            LineThrough,
            Blink
        }

        public enum TextDirection {
            LTR,
            RTL
        }

        public enum VectorEffect {
            None,
            NonScalingStroke
        }

        Style() {
        }

        static Style getDefaultStyle() {
            Style def = new Style();
            def.specifiedFlags = -1L;
            def.fill = Colour.BLACK;
            def.fillRule = FillRule.NonZero;
            Float fValueOf = Float.valueOf(1.0f);
            def.fillOpacity = fValueOf;
            def.stroke = null;
            def.strokeOpacity = fValueOf;
            def.strokeWidth = new Length(1.0f);
            def.strokeLineCap = LineCap.Butt;
            def.strokeLineJoin = LineJoin.Miter;
            def.strokeMiterLimit = Float.valueOf(4.0f);
            def.strokeDashArray = null;
            def.strokeDashOffset = new Length(0.0f);
            def.opacity = fValueOf;
            def.color = Colour.BLACK;
            def.fontFamily = null;
            def.fontSize = new Length(12.0f, Unit.pt);
            def.fontWeight = 400;
            def.fontStyle = FontStyle.Normal;
            def.textDecoration = TextDecoration.None;
            def.direction = TextDirection.LTR;
            def.textAnchor = TextAnchor.Start;
            def.overflow = true;
            def.clip = null;
            def.markerStart = null;
            def.markerMid = null;
            def.markerEnd = null;
            def.display = Boolean.TRUE;
            def.visibility = Boolean.TRUE;
            def.stopColor = Colour.BLACK;
            def.stopOpacity = fValueOf;
            def.clipPath = null;
            def.clipRule = FillRule.NonZero;
            def.mask = null;
            def.solidColor = null;
            def.solidOpacity = fValueOf;
            def.viewportFill = null;
            def.viewportFillOpacity = fValueOf;
            def.vectorEffect = VectorEffect.None;
            def.imageRendering = RenderQuality.auto;
            return def;
        }

        void resetNonInheritingProperties(boolean isRootSVG) {
            this.display = Boolean.TRUE;
            this.overflow = isRootSVG ? Boolean.TRUE : Boolean.FALSE;
            this.clip = null;
            this.clipPath = null;
            this.opacity = Float.valueOf(1.0f);
            this.stopColor = Colour.BLACK;
            this.stopOpacity = Float.valueOf(1.0f);
            this.mask = null;
            this.solidColor = null;
            this.solidOpacity = Float.valueOf(1.0f);
            this.viewportFill = null;
            this.viewportFillOpacity = Float.valueOf(1.0f);
            this.vectorEffect = VectorEffect.None;
        }

        protected Object clone() throws CloneNotSupportedException {
            Style obj = (Style) super.clone();
            if (this.strokeDashArray != null) {
                obj.strokeDashArray = (Length[]) this.strokeDashArray.clone();
            }
            return obj;
        }
    }

    static abstract class SvgPaint implements Cloneable {
        SvgPaint() {
        }
    }

    static class Colour extends SvgPaint {
        static final Colour BLACK = new Colour(ViewCompat.MEASURED_STATE_MASK);
        static final Colour TRANSPARENT = new Colour(0);
        int colour;

        Colour(int val) {
            this.colour = val;
        }

        public String toString() {
            return String.format("#%08x", Integer.valueOf(this.colour));
        }
    }

    static class CurrentColor extends SvgPaint {
        private static CurrentColor instance = new CurrentColor();

        private CurrentColor() {
        }

        static CurrentColor getInstance() {
            return instance;
        }
    }

    static class PaintReference extends SvgPaint {
        SvgPaint fallback;
        String href;

        PaintReference(String href, SvgPaint fallback) {
            this.href = href;
            this.fallback = fallback;
        }

        public String toString() {
            return this.href + " " + this.fallback;
        }
    }

    static class Length implements Cloneable {
        Unit unit;
        float value;

        Length(float value, Unit unit) {
            this.value = value;
            this.unit = unit;
        }

        Length(float value) {
            this.value = value;
            this.unit = Unit.px;
        }

        float floatValue() {
            return this.value;
        }

        float floatValueX(SVGAndroidRenderer renderer) {
            switch (this.unit) {
                case px:
                    return this.value;
                case em:
                    return this.value * renderer.getCurrentFontSize();
                case ex:
                    return this.value * renderer.getCurrentFontXHeight();
                case in:
                    return this.value * renderer.getDPI();
                case cm:
                    return (this.value * renderer.getDPI()) / 2.54f;
                case mm:
                    return (this.value * renderer.getDPI()) / 25.4f;
                case pt:
                    return (this.value * renderer.getDPI()) / 72.0f;
                case pc:
                    return (this.value * renderer.getDPI()) / 6.0f;
                case percent:
                    Box viewPortUser = renderer.getCurrentViewPortInUserUnits();
                    if (viewPortUser == null) {
                        return this.value;
                    }
                    return (this.value * viewPortUser.width) / 100.0f;
                default:
                    return this.value;
            }
        }

        float floatValueY(SVGAndroidRenderer renderer) {
            if (this.unit == Unit.percent) {
                Box viewPortUser = renderer.getCurrentViewPortInUserUnits();
                if (viewPortUser == null) {
                    return this.value;
                }
                return (this.value * viewPortUser.height) / 100.0f;
            }
            return floatValueX(renderer);
        }

        float floatValue(SVGAndroidRenderer renderer) {
            if (this.unit == Unit.percent) {
                Box viewPortUser = renderer.getCurrentViewPortInUserUnits();
                if (viewPortUser == null) {
                    return this.value;
                }
                float w = viewPortUser.width;
                float h = viewPortUser.height;
                if (w == h) {
                    return (this.value * w) / 100.0f;
                }
                float n = (float) (Math.sqrt((w * w) + (h * h)) / SVG.SQRT2);
                return (this.value * n) / 100.0f;
            }
            return floatValueX(renderer);
        }

        float floatValue(SVGAndroidRenderer renderer, float max) {
            if (this.unit == Unit.percent) {
                return (this.value * max) / 100.0f;
            }
            return floatValueX(renderer);
        }

        float floatValue(float dpi) {
            switch (this.unit) {
                case px:
                    return this.value;
                case em:
                case ex:
                default:
                    return this.value;
                case in:
                    return this.value * dpi;
                case cm:
                    return (this.value * dpi) / 2.54f;
                case mm:
                    return (this.value * dpi) / 25.4f;
                case pt:
                    return (this.value * dpi) / 72.0f;
                case pc:
                    return (this.value * dpi) / 6.0f;
            }
        }

        boolean isZero() {
            return this.value == 0.0f;
        }

        boolean isNegative() {
            return this.value < 0.0f;
        }

        public String toString() {
            return String.valueOf(this.value) + this.unit;
        }
    }

    static class CSSClipRect {
        Length bottom;
        Length left;
        Length right;
        Length top;

        CSSClipRect(Length top, Length right, Length bottom, Length left) {
            this.top = top;
            this.right = right;
            this.bottom = bottom;
            this.left = left;
        }
    }

    static class SvgObject {
        SVG document;
        SvgContainer parent;

        SvgObject() {
        }

        String getNodeName() {
            return "";
        }
    }

    static abstract class SvgElementBase extends SvgObject {

        /* JADX INFO: renamed from: id */
        String f291id = null;
        Boolean spacePreserve = null;
        Style baseStyle = null;
        Style style = null;
        List<String> classNames = null;

        SvgElementBase() {
        }

        public String toString() {
            return getNodeName();
        }
    }

    static abstract class SvgElement extends SvgElementBase {
        Box boundingBox = null;

        SvgElement() {
        }
    }

    static abstract class SvgConditionalElement extends SvgElement implements SvgConditional {
        Set<String> requiredFeatures = null;
        String requiredExtensions = null;
        Set<String> systemLanguage = null;
        Set<String> requiredFormats = null;
        Set<String> requiredFonts = null;

        SvgConditionalElement() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFeatures(Set<String> features) {
            this.requiredFeatures = features;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFeatures() {
            return this.requiredFeatures;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredExtensions(String extensions) {
            this.requiredExtensions = extensions;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public String getRequiredExtensions() {
            return this.requiredExtensions;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setSystemLanguage(Set<String> languages) {
            this.systemLanguage = languages;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getSystemLanguage() {
            return this.systemLanguage;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFormats(Set<String> mimeTypes) {
            this.requiredFormats = mimeTypes;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFormats() {
            return this.requiredFormats;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFonts(Set<String> fontNames) {
            this.requiredFonts = fontNames;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFonts() {
            return this.requiredFonts;
        }
    }

    static abstract class SvgConditionalContainer extends SvgElement implements SvgContainer, SvgConditional {
        List<SvgObject> children = new ArrayList();
        Set<String> requiredFeatures = null;
        String requiredExtensions = null;
        Set<String> systemLanguage = null;
        Set<String> requiredFormats = null;
        Set<String> requiredFonts = null;

        SvgConditionalContainer() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List<SvgObject> getChildren() {
            return this.children;
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(SvgObject elem) throws SVGParseException {
            this.children.add(elem);
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFeatures(Set<String> features) {
            this.requiredFeatures = features;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFeatures() {
            return this.requiredFeatures;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredExtensions(String extensions) {
            this.requiredExtensions = extensions;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public String getRequiredExtensions() {
            return this.requiredExtensions;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setSystemLanguage(Set<String> languages) {
            this.systemLanguage = languages;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getSystemLanguage() {
            return null;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFormats(Set<String> mimeTypes) {
            this.requiredFormats = mimeTypes;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFormats() {
            return this.requiredFormats;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFonts(Set<String> fontNames) {
            this.requiredFonts = fontNames;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFonts() {
            return this.requiredFonts;
        }
    }

    static abstract class SvgPreserveAspectRatioContainer extends SvgConditionalContainer {
        PreserveAspectRatio preserveAspectRatio = null;

        SvgPreserveAspectRatioContainer() {
        }
    }

    static abstract class SvgViewBoxContainer extends SvgPreserveAspectRatioContainer {
        Box viewBox;

        SvgViewBoxContainer() {
        }
    }

    static class Svg extends SvgViewBoxContainer {
        Length height;
        public String version;
        Length width;

        /* JADX INFO: renamed from: x */
        Length f289x;

        /* JADX INFO: renamed from: y */
        Length f290y;

        Svg() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "svg";
        }
    }

    static class Group extends SvgConditionalContainer implements HasTransform {
        Matrix transform;

        Group() {
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void setTransform(Matrix transform) {
            this.transform = transform;
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "group";
        }
    }

    static class Defs extends Group implements NotDirectlyRendered {
        Defs() {
        }

        @Override // com.caverock.androidsvg.SVG.Group, com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "defs";
        }
    }

    static abstract class GraphicsElement extends SvgConditionalElement implements HasTransform {
        Matrix transform;

        GraphicsElement() {
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void setTransform(Matrix transform) {
            this.transform = transform;
        }
    }

    static class Use extends Group {
        Length height;
        String href;
        Length width;

        /* JADX INFO: renamed from: x */
        Length f313x;

        /* JADX INFO: renamed from: y */
        Length f314y;

        Use() {
        }

        @Override // com.caverock.androidsvg.SVG.Group, com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "use";
        }
    }

    static class Path extends GraphicsElement {

        /* JADX INFO: renamed from: d */
        PathDefinition f282d;
        Float pathLength;

        Path() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return DownloadUtil.CookieScheme.PATH;
        }
    }

    static class Rect extends GraphicsElement {
        Length height;

        /* JADX INFO: renamed from: rx */
        Length f285rx;

        /* JADX INFO: renamed from: ry */
        Length f286ry;
        Length width;

        /* JADX INFO: renamed from: x */
        Length f287x;

        /* JADX INFO: renamed from: y */
        Length f288y;

        Rect() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "rect";
        }
    }

    static class Circle extends GraphicsElement {

        /* JADX INFO: renamed from: cx */
        Length f267cx;

        /* JADX INFO: renamed from: cy */
        Length f268cy;

        /* JADX INFO: renamed from: r */
        Length f269r;

        Circle() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "circle";
        }
    }

    static class Ellipse extends GraphicsElement {

        /* JADX INFO: renamed from: cx */
        Length f270cx;

        /* JADX INFO: renamed from: cy */
        Length f271cy;

        /* JADX INFO: renamed from: rx */
        Length f272rx;

        /* JADX INFO: renamed from: ry */
        Length f273ry;

        Ellipse() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "ellipse";
        }
    }

    static class Line extends GraphicsElement {

        /* JADX INFO: renamed from: x1 */
        Length f276x1;

        /* JADX INFO: renamed from: x2 */
        Length f277x2;

        /* JADX INFO: renamed from: y1 */
        Length f278y1;

        /* JADX INFO: renamed from: y2 */
        Length f279y2;

        Line() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "line";
        }
    }

    static class PolyLine extends GraphicsElement {
        float[] points;

        PolyLine() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "polyline";
        }
    }

    static class Polygon extends PolyLine {
        Polygon() {
        }

        @Override // com.caverock.androidsvg.SVG.PolyLine, com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "polygon";
        }
    }

    static abstract class TextContainer extends SvgConditionalContainer {
        TextContainer() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditionalContainer, com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(SvgObject elem) throws SVGParseException {
            if (elem instanceof TextChild) {
                this.children.add(elem);
                return;
            }
            throw new SVGParseException("Text content elements cannot contain " + elem + " elements.");
        }
    }

    static abstract class TextPositionedContainer extends TextContainer {

        /* JADX INFO: renamed from: dx */
        List<Length> f301dx;

        /* JADX INFO: renamed from: dy */
        List<Length> f302dy;

        /* JADX INFO: renamed from: x */
        List<Length> f303x;

        /* JADX INFO: renamed from: y */
        List<Length> f304y;

        TextPositionedContainer() {
        }
    }

    static class Text extends TextPositionedContainer implements TextRoot, HasTransform {
        Matrix transform;

        Text() {
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void setTransform(Matrix transform) {
            this.transform = transform;
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "text";
        }
    }

    static class TSpan extends TextPositionedContainer implements TextChild {
        private TextRoot textRoot;

        TSpan() {
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public void setTextRoot(TextRoot obj) {
            this.textRoot = obj;
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot getTextRoot() {
            return this.textRoot;
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "tspan";
        }
    }

    static class TextSequence extends SvgObject implements TextChild {
        String text;
        private TextRoot textRoot;

        TextSequence(String text) {
            this.text = text;
        }

        public String toString() {
            return "TextChild: '" + this.text + "'";
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public void setTextRoot(TextRoot obj) {
            this.textRoot = obj;
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot getTextRoot() {
            return this.textRoot;
        }
    }

    static class TRef extends TextContainer implements TextChild {
        String href;
        private TextRoot textRoot;

        TRef() {
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public void setTextRoot(TextRoot obj) {
            this.textRoot = obj;
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot getTextRoot() {
            return this.textRoot;
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "tref";
        }
    }

    static class TextPath extends TextContainer implements TextChild {
        String href;
        Length startOffset;
        private TextRoot textRoot;

        TextPath() {
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public void setTextRoot(TextRoot obj) {
            this.textRoot = obj;
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot getTextRoot() {
            return this.textRoot;
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "textPath";
        }
    }

    static class Switch extends Group {
        Switch() {
        }

        @Override // com.caverock.androidsvg.SVG.Group, com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "switch";
        }
    }

    static class Symbol extends SvgViewBoxContainer implements NotDirectlyRendered {
        Symbol() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "symbol";
        }
    }

    static class Marker extends SvgViewBoxContainer implements NotDirectlyRendered {
        Length markerHeight;
        boolean markerUnitsAreUser;
        Length markerWidth;
        Float orient;
        Length refX;
        Length refY;

        Marker() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "marker";
        }
    }

    static abstract class GradientElement extends SvgElementBase implements SvgContainer {
        List<SvgObject> children = new ArrayList();
        Matrix gradientTransform;
        Boolean gradientUnitsAreUser;
        String href;
        GradientSpread spreadMethod;

        GradientElement() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List<SvgObject> getChildren() {
            return this.children;
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(SvgObject elem) throws SVGParseException {
            if (elem instanceof Stop) {
                this.children.add(elem);
                return;
            }
            throw new SVGParseException("Gradient elements cannot contain " + elem + " elements.");
        }
    }

    static class Stop extends SvgElementBase implements SvgContainer {
        Float offset;

        Stop() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List<SvgObject> getChildren() {
            return Collections.emptyList();
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(SvgObject elem) {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "stop";
        }
    }

    static class SvgLinearGradient extends GradientElement {

        /* JADX INFO: renamed from: x1 */
        Length f292x1;

        /* JADX INFO: renamed from: x2 */
        Length f293x2;

        /* JADX INFO: renamed from: y1 */
        Length f294y1;

        /* JADX INFO: renamed from: y2 */
        Length f295y2;

        SvgLinearGradient() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "linearGradient";
        }
    }

    static class SvgRadialGradient extends GradientElement {

        /* JADX INFO: renamed from: cx */
        Length f296cx;

        /* JADX INFO: renamed from: cy */
        Length f297cy;

        /* JADX INFO: renamed from: fx */
        Length f298fx;

        /* JADX INFO: renamed from: fy */
        Length f299fy;

        /* JADX INFO: renamed from: r */
        Length f300r;

        SvgRadialGradient() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "radialGradient";
        }
    }

    static class ClipPath extends Group implements NotDirectlyRendered {
        Boolean clipPathUnitsAreUser;

        ClipPath() {
        }

        @Override // com.caverock.androidsvg.SVG.Group, com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "clipPath";
        }
    }

    static class Pattern extends SvgViewBoxContainer implements NotDirectlyRendered {
        Length height;
        String href;
        Boolean patternContentUnitsAreUser;
        Matrix patternTransform;
        Boolean patternUnitsAreUser;
        Length width;

        /* JADX INFO: renamed from: x */
        Length f283x;

        /* JADX INFO: renamed from: y */
        Length f284y;

        Pattern() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "pattern";
        }
    }

    static class Image extends SvgPreserveAspectRatioContainer implements HasTransform {
        Length height;
        String href;
        Matrix transform;
        Length width;

        /* JADX INFO: renamed from: x */
        Length f274x;

        /* JADX INFO: renamed from: y */
        Length f275y;

        Image() {
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void setTransform(Matrix transform) {
            this.transform = transform;
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "image";
        }
    }

    static class View extends SvgViewBoxContainer implements NotDirectlyRendered {
        static final String NODE_NAME = "view";

        View() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return NODE_NAME;
        }
    }

    static class Mask extends SvgConditionalContainer implements NotDirectlyRendered {
        Length height;
        Boolean maskContentUnitsAreUser;
        Boolean maskUnitsAreUser;
        Length width;

        /* JADX INFO: renamed from: x */
        Length f280x;

        /* JADX INFO: renamed from: y */
        Length f281y;

        Mask() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "mask";
        }
    }

    static class SolidColor extends SvgElementBase implements SvgContainer {
        SolidColor() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List<SvgObject> getChildren() {
            return Collections.emptyList();
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(SvgObject elem) {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "solidColor";
        }
    }

    void setTitle(String title) {
        this.title = title;
    }

    void setDesc(String desc) {
        this.desc = desc;
    }

    static SVGExternalFileResolver getFileResolver() {
        return externalFileResolver;
    }

    static class PathDefinition implements PathInterface {
        private static final byte ARCTO = 4;
        private static final byte CLOSE = 8;
        private static final byte CUBICTO = 2;
        private static final byte LINETO = 1;
        private static final byte MOVETO = 0;
        private static final byte QUADTO = 3;
        private int commandsLength = 0;
        private int coordsLength = 0;
        private byte[] commands = new byte[8];
        private float[] coords = new float[16];

        PathDefinition() {
        }

        boolean isEmpty() {
            return this.commandsLength == 0;
        }

        private void addCommand(byte value) {
            if (this.commandsLength == this.commands.length) {
                byte[] newCommands = new byte[this.commands.length * 2];
                System.arraycopy(this.commands, 0, newCommands, 0, this.commands.length);
                this.commands = newCommands;
            }
            byte[] newCommands2 = this.commands;
            int i = this.commandsLength;
            this.commandsLength = i + 1;
            newCommands2[i] = value;
        }

        private void coordsEnsure(int num) {
            if (this.coords.length < this.coordsLength + num) {
                float[] newCoords = new float[this.coords.length * 2];
                System.arraycopy(this.coords, 0, newCoords, 0, this.coords.length);
                this.coords = newCoords;
            }
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void moveTo(float x, float y) {
            addCommand((byte) 0);
            coordsEnsure(2);
            float[] fArr = this.coords;
            int i = this.coordsLength;
            this.coordsLength = i + 1;
            fArr[i] = x;
            float[] fArr2 = this.coords;
            int i2 = this.coordsLength;
            this.coordsLength = i2 + 1;
            fArr2[i2] = y;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void lineTo(float x, float y) {
            addCommand((byte) 1);
            coordsEnsure(2);
            float[] fArr = this.coords;
            int i = this.coordsLength;
            this.coordsLength = i + 1;
            fArr[i] = x;
            float[] fArr2 = this.coords;
            int i2 = this.coordsLength;
            this.coordsLength = i2 + 1;
            fArr2[i2] = y;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void cubicTo(float x1, float y1, float x2, float y2, float x3, float y3) {
            addCommand((byte) 2);
            coordsEnsure(6);
            float[] fArr = this.coords;
            int i = this.coordsLength;
            this.coordsLength = i + 1;
            fArr[i] = x1;
            float[] fArr2 = this.coords;
            int i2 = this.coordsLength;
            this.coordsLength = i2 + 1;
            fArr2[i2] = y1;
            float[] fArr3 = this.coords;
            int i3 = this.coordsLength;
            this.coordsLength = i3 + 1;
            fArr3[i3] = x2;
            float[] fArr4 = this.coords;
            int i4 = this.coordsLength;
            this.coordsLength = i4 + 1;
            fArr4[i4] = y2;
            float[] fArr5 = this.coords;
            int i5 = this.coordsLength;
            this.coordsLength = i5 + 1;
            fArr5[i5] = x3;
            float[] fArr6 = this.coords;
            int i6 = this.coordsLength;
            this.coordsLength = i6 + 1;
            fArr6[i6] = y3;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void quadTo(float x1, float y1, float x2, float y2) {
            addCommand((byte) 3);
            coordsEnsure(4);
            float[] fArr = this.coords;
            int i = this.coordsLength;
            this.coordsLength = i + 1;
            fArr[i] = x1;
            float[] fArr2 = this.coords;
            int i2 = this.coordsLength;
            this.coordsLength = i2 + 1;
            fArr2[i2] = y1;
            float[] fArr3 = this.coords;
            int i3 = this.coordsLength;
            this.coordsLength = i3 + 1;
            fArr3[i3] = x2;
            float[] fArr4 = this.coords;
            int i4 = this.coordsLength;
            this.coordsLength = i4 + 1;
            fArr4[i4] = y2;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            addCommand((byte) ((z ? 2 : 0) | 4 | (z2 ? 1 : 0)));
            coordsEnsure(5);
            float[] fArr = this.coords;
            int i = this.coordsLength;
            this.coordsLength = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.coords;
            int i2 = this.coordsLength;
            this.coordsLength = i2 + 1;
            fArr2[i2] = f2;
            float[] fArr3 = this.coords;
            int i3 = this.coordsLength;
            this.coordsLength = i3 + 1;
            fArr3[i3] = f3;
            float[] fArr4 = this.coords;
            int i4 = this.coordsLength;
            this.coordsLength = i4 + 1;
            fArr4[i4] = f4;
            float[] fArr5 = this.coords;
            int i5 = this.coordsLength;
            this.coordsLength = i5 + 1;
            fArr5[i5] = f5;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void close() {
            addCommand((byte) 8);
        }

        void enumeratePath(PathInterface handler) {
            int coordsPos = 0;
            for (int commandPos = 0; commandPos < this.commandsLength; commandPos++) {
                byte command = this.commands[commandPos];
                switch (command) {
                    case 0:
                        int coordsPos2 = coordsPos + 1;
                        handler.moveTo(this.coords[coordsPos], this.coords[coordsPos2]);
                        coordsPos = coordsPos2 + 1;
                        break;
                    case 1:
                        int coordsPos3 = coordsPos + 1;
                        handler.lineTo(this.coords[coordsPos], this.coords[coordsPos3]);
                        coordsPos = coordsPos3 + 1;
                        break;
                    case 2:
                        int coordsPos4 = coordsPos + 1;
                        float f = this.coords[coordsPos];
                        int coordsPos5 = coordsPos4 + 1;
                        float f2 = this.coords[coordsPos4];
                        int coordsPos6 = coordsPos5 + 1;
                        float f3 = this.coords[coordsPos5];
                        int coordsPos7 = coordsPos6 + 1;
                        float f4 = this.coords[coordsPos6];
                        int coordsPos8 = coordsPos7 + 1;
                        handler.cubicTo(f, f2, f3, f4, this.coords[coordsPos7], this.coords[coordsPos8]);
                        coordsPos = coordsPos8 + 1;
                        break;
                    case 3:
                        int coordsPos9 = coordsPos + 1;
                        int coordsPos10 = coordsPos9 + 1;
                        int coordsPos11 = coordsPos10 + 1;
                        handler.quadTo(this.coords[coordsPos], this.coords[coordsPos9], this.coords[coordsPos10], this.coords[coordsPos11]);
                        coordsPos = coordsPos11 + 1;
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    default:
                        boolean largeArcFlag = (command & 2) != 0;
                        boolean sweepFlag = (command & 1) != 0;
                        int coordsPos12 = coordsPos + 1;
                        float f5 = this.coords[coordsPos];
                        int coordsPos13 = coordsPos12 + 1;
                        float f6 = this.coords[coordsPos12];
                        int coordsPos14 = coordsPos13 + 1;
                        float f7 = this.coords[coordsPos13];
                        int coordsPos15 = coordsPos14 + 1;
                        handler.arcTo(f5, f6, f7, largeArcFlag, sweepFlag, this.coords[coordsPos14], this.coords[coordsPos15]);
                        coordsPos = coordsPos15 + 1;
                        break;
                    case 8:
                        handler.close();
                        break;
                }
            }
        }
    }

    SvgElementBase getElementById(String id) {
        if (id == null || id.length() == 0) {
            return null;
        }
        if (id.equals(this.rootElement.f291id)) {
            return this.rootElement;
        }
        if (this.idToElementMap.containsKey(id)) {
            return this.idToElementMap.get(id);
        }
        SvgElementBase result = getElementById(this.rootElement, id);
        this.idToElementMap.put(id, result);
        return result;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SvgElementBase getElementById(SvgContainer svgContainer, String id) {
        SvgElementBase found;
        SvgElementBase elem = (SvgElementBase) svgContainer;
        if (id.equals(elem.f291id)) {
            return elem;
        }
        for (Object obj : svgContainer.getChildren()) {
            if (obj instanceof SvgElementBase) {
                SvgElementBase childElem = (SvgElementBase) obj;
                if (id.equals(childElem.f291id)) {
                    return childElem;
                }
                if ((obj instanceof SvgContainer) && (found = getElementById((SvgContainer) obj, id)) != null) {
                    return found;
                }
            }
        }
        return null;
    }

    private List<SvgObject> getElementsByTagName(String nodeName) {
        List<SvgObject> result = new ArrayList<>();
        getElementsByTagName(result, this.rootElement, nodeName);
        return result;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void getElementsByTagName(List<SvgObject> result, SvgObject svgObject, String nodeName) {
        if (svgObject.getNodeName().equals(nodeName)) {
            result.add(svgObject);
        }
        if (svgObject instanceof SvgContainer) {
            for (SvgObject child : ((SvgContainer) svgObject).getChildren()) {
                getElementsByTagName(result, child, nodeName);
            }
        }
    }
}
