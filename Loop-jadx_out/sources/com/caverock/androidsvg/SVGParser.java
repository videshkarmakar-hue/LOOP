package com.caverock.androidsvg;

import android.graphics.Matrix;
import android.util.Log;
import android.util.Xml;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.internal.view.SupportMenu;
import androidx.core.location.LocationRequestCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import kotlin.p007io.encoding.Base64;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.internal.http2.Http2Stream;
import org.apache.commons.p013io.FileUtils;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DefaultHandler2;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
class SVGParser {
    private static final String CURRENTCOLOR = "currentColor";
    public static final int ENTITY_WATCH_BUFFER_SIZE = 4096;
    private static final String FEATURE_STRING_PREFIX = "http://www.w3.org/TR/SVG11/feature#";
    private static final String NONE = "none";
    private static final String SVG_NAMESPACE = "http://www.w3.org/2000/svg";
    private static final String TAG = "SVGParser";
    private static final String VALID_DISPLAY_VALUES = "|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|";
    private static final String VALID_VISIBILITY_VALUES = "|visible|hidden|collapse|";
    private static final String XLINK_NAMESPACE = "http://www.w3.org/1999/xlink";
    public static final String XML_STYLESHEET_ATTR_ALTERNATE = "alternate";
    public static final String XML_STYLESHEET_ATTR_ALTERNATE_NO = "no";
    public static final String XML_STYLESHEET_ATTR_HREF = "href";
    public static final String XML_STYLESHEET_ATTR_MEDIA = "media";
    public static final String XML_STYLESHEET_ATTR_MEDIA_ALL = "all";
    public static final String XML_STYLESHEET_ATTR_TYPE = "type";
    private static final String XML_STYLESHEET_PROCESSING_INSTRUCTION = "xml-stylesheet";
    private int ignoreDepth;
    private SVG svgDocument = null;
    private SVG.SvgContainer currentElement = null;
    private boolean ignoring = false;
    private boolean inMetadataElement = false;
    private SVGElem metadataTag = null;
    private StringBuilder metadataElementContents = null;
    private boolean inStyleElement = false;
    private StringBuilder styleElementContents = null;

    SVGParser() {
    }

    private enum SVGElem {
        svg,
        a,
        circle,
        clipPath,
        defs,
        desc,
        ellipse,
        g,
        image,
        line,
        linearGradient,
        marker,
        mask,
        path,
        pattern,
        polygon,
        polyline,
        radialGradient,
        rect,
        solidColor,
        stop,
        style,
        SWITCH,
        symbol,
        text,
        textPath,
        title,
        tref,
        tspan,
        use,
        view,
        UNSUPPORTED;

        private static final Map<String, SVGElem> cache = new HashMap();

        static {
            for (SVGElem elem : values()) {
                if (elem == SWITCH) {
                    cache.put("switch", elem);
                } else if (elem != UNSUPPORTED) {
                    String key = elem.name();
                    cache.put(key, elem);
                }
            }
        }

        public static SVGElem fromString(String str) {
            SVGElem elem = cache.get(str);
            if (elem != null) {
                return elem;
            }
            return UNSUPPORTED;
        }
    }

    private enum SVGAttr {
        CLASS,
        clip,
        clip_path,
        clipPathUnits,
        clip_rule,
        color,
        cx,
        cy,
        direction,
        dx,
        dy,
        fx,
        fy,
        d,
        display,
        fill,
        fill_rule,
        fill_opacity,
        font,
        font_family,
        font_size,
        font_weight,
        font_style,
        gradientTransform,
        gradientUnits,
        height,
        href,
        image_rendering,
        marker,
        marker_start,
        marker_mid,
        marker_end,
        markerHeight,
        markerUnits,
        markerWidth,
        mask,
        maskContentUnits,
        maskUnits,
        media,
        offset,
        opacity,
        orient,
        overflow,
        pathLength,
        patternContentUnits,
        patternTransform,
        patternUnits,
        points,
        preserveAspectRatio,
        r,
        refX,
        refY,
        requiredFeatures,
        requiredExtensions,
        requiredFormats,
        requiredFonts,
        rx,
        ry,
        solid_color,
        solid_opacity,
        spreadMethod,
        startOffset,
        stop_color,
        stop_opacity,
        stroke,
        stroke_dasharray,
        stroke_dashoffset,
        stroke_linecap,
        stroke_linejoin,
        stroke_miterlimit,
        stroke_opacity,
        stroke_width,
        style,
        systemLanguage,
        text_anchor,
        text_decoration,
        transform,
        type,
        vector_effect,
        version,
        viewBox,
        width,
        x,
        y,
        x1,
        y1,
        x2,
        y2,
        viewport_fill,
        viewport_fill_opacity,
        visibility,
        UNSUPPORTED;

        private static final Map<String, SVGAttr> cache = new HashMap();

        static {
            for (SVGAttr attr : values()) {
                if (attr == CLASS) {
                    cache.put("class", attr);
                } else if (attr != UNSUPPORTED) {
                    String key = attr.name().replace('_', '-');
                    cache.put(key, attr);
                }
            }
        }

        public static SVGAttr fromString(String str) {
            SVGAttr attr = cache.get(str);
            if (attr != null) {
                return attr;
            }
            return UNSUPPORTED;
        }
    }

    private static class ColourKeywords {
        private static final Map<String, Integer> colourKeywords = new HashMap(47);

        private ColourKeywords() {
        }

        static {
            colourKeywords.put("aliceblue", -984833);
            colourKeywords.put("antiquewhite", -332841);
            colourKeywords.put("aqua", -16711681);
            colourKeywords.put("aquamarine", -8388652);
            colourKeywords.put("azure", -983041);
            colourKeywords.put("beige", -657956);
            colourKeywords.put("bisque", -6972);
            colourKeywords.put("black", Integer.valueOf(ViewCompat.MEASURED_STATE_MASK));
            colourKeywords.put("blanchedalmond", -5171);
            colourKeywords.put("blue", -16776961);
            colourKeywords.put("blueviolet", -7722014);
            colourKeywords.put("brown", -5952982);
            colourKeywords.put("burlywood", -2180985);
            colourKeywords.put("cadetblue", -10510688);
            colourKeywords.put("chartreuse", -8388864);
            colourKeywords.put("chocolate", -2987746);
            colourKeywords.put("coral", -32944);
            colourKeywords.put("cornflowerblue", -10185235);
            colourKeywords.put("cornsilk", -1828);
            colourKeywords.put("crimson", -2354116);
            colourKeywords.put("cyan", -16711681);
            colourKeywords.put("darkblue", -16777077);
            colourKeywords.put("darkcyan", -16741493);
            colourKeywords.put("darkgoldenrod", -4684277);
            colourKeywords.put("darkgray", -5658199);
            colourKeywords.put("darkgreen", -16751616);
            colourKeywords.put("darkgrey", -5658199);
            colourKeywords.put("darkkhaki", -4343957);
            colourKeywords.put("darkmagenta", -7667573);
            colourKeywords.put("darkolivegreen", -11179217);
            colourKeywords.put("darkorange", -29696);
            colourKeywords.put("darkorchid", -6737204);
            colourKeywords.put("darkred", -7667712);
            colourKeywords.put("darksalmon", -1468806);
            colourKeywords.put("darkseagreen", -7357297);
            colourKeywords.put("darkslateblue", -12042869);
            colourKeywords.put("darkslategray", -13676721);
            colourKeywords.put("darkslategrey", -13676721);
            colourKeywords.put("darkturquoise", -16724271);
            colourKeywords.put("darkviolet", -7077677);
            colourKeywords.put("deeppink", -60269);
            colourKeywords.put("deepskyblue", -16728065);
            colourKeywords.put("dimgray", -9868951);
            colourKeywords.put("dimgrey", -9868951);
            colourKeywords.put("dodgerblue", -14774017);
            colourKeywords.put("firebrick", -5103070);
            colourKeywords.put("floralwhite", -1296);
            colourKeywords.put("forestgreen", -14513374);
            colourKeywords.put("fuchsia", -65281);
            colourKeywords.put("gainsboro", -2302756);
            colourKeywords.put("ghostwhite", -460545);
            colourKeywords.put("gold", -10496);
            colourKeywords.put("goldenrod", -2448096);
            colourKeywords.put("gray", -8355712);
            colourKeywords.put("green", -16744448);
            colourKeywords.put("greenyellow", -5374161);
            colourKeywords.put("grey", -8355712);
            colourKeywords.put("honeydew", -983056);
            colourKeywords.put("hotpink", -38476);
            colourKeywords.put("indianred", -3318692);
            colourKeywords.put("indigo", -11861886);
            colourKeywords.put("ivory", -16);
            colourKeywords.put("khaki", -989556);
            colourKeywords.put("lavender", -1644806);
            colourKeywords.put("lavenderblush", -3851);
            colourKeywords.put("lawngreen", -8586240);
            colourKeywords.put("lemonchiffon", -1331);
            colourKeywords.put("lightblue", -5383962);
            colourKeywords.put("lightcoral", -1015680);
            colourKeywords.put("lightcyan", -2031617);
            colourKeywords.put("lightgoldenrodyellow", -329006);
            colourKeywords.put("lightgray", -2894893);
            colourKeywords.put("lightgreen", -7278960);
            colourKeywords.put("lightgrey", -2894893);
            colourKeywords.put("lightpink", -18751);
            colourKeywords.put("lightsalmon", -24454);
            colourKeywords.put("lightseagreen", -14634326);
            colourKeywords.put("lightskyblue", -7876870);
            colourKeywords.put("lightslategray", -8943463);
            colourKeywords.put("lightslategrey", -8943463);
            colourKeywords.put("lightsteelblue", -5192482);
            colourKeywords.put("lightyellow", -32);
            colourKeywords.put("lime", -16711936);
            colourKeywords.put("limegreen", -13447886);
            colourKeywords.put("linen", -331546);
            colourKeywords.put("magenta", -65281);
            colourKeywords.put("maroon", -8388608);
            colourKeywords.put("mediumaquamarine", -10039894);
            colourKeywords.put("mediumblue", -16777011);
            colourKeywords.put("mediumorchid", -4565549);
            colourKeywords.put("mediumpurple", -7114533);
            colourKeywords.put("mediumseagreen", -12799119);
            colourKeywords.put("mediumslateblue", -8689426);
            colourKeywords.put("mediumspringgreen", -16713062);
            colourKeywords.put("mediumturquoise", -12004916);
            colourKeywords.put("mediumvioletred", -3730043);
            colourKeywords.put("midnightblue", -15132304);
            colourKeywords.put("mintcream", -655366);
            colourKeywords.put("mistyrose", -6943);
            colourKeywords.put("moccasin", -6987);
            colourKeywords.put("navajowhite", -8531);
            colourKeywords.put("navy", -16777088);
            colourKeywords.put("oldlace", -133658);
            colourKeywords.put("olive", -8355840);
            colourKeywords.put("olivedrab", -9728477);
            colourKeywords.put("orange", -23296);
            colourKeywords.put("orangered", -47872);
            colourKeywords.put("orchid", -2461482);
            colourKeywords.put("palegoldenrod", -1120086);
            colourKeywords.put("palegreen", -6751336);
            colourKeywords.put("paleturquoise", -5247250);
            colourKeywords.put("palevioletred", -2396013);
            colourKeywords.put("papayawhip", -4139);
            colourKeywords.put("peachpuff", -9543);
            colourKeywords.put("peru", -3308225);
            colourKeywords.put("pink", -16181);
            colourKeywords.put("plum", -2252579);
            colourKeywords.put("powderblue", -5185306);
            colourKeywords.put("purple", -8388480);
            colourKeywords.put("rebeccapurple", -10079335);
            colourKeywords.put("red", Integer.valueOf(SupportMenu.CATEGORY_MASK));
            colourKeywords.put("rosybrown", -4419697);
            colourKeywords.put("royalblue", -12490271);
            colourKeywords.put("saddlebrown", -7650029);
            colourKeywords.put("salmon", -360334);
            colourKeywords.put("sandybrown", -744352);
            colourKeywords.put("seagreen", -13726889);
            colourKeywords.put("seashell", -2578);
            colourKeywords.put("sienna", -6270419);
            colourKeywords.put("silver", -4144960);
            colourKeywords.put("skyblue", -7876885);
            colourKeywords.put("slateblue", -9807155);
            colourKeywords.put("slategray", -9404272);
            colourKeywords.put("slategrey", -9404272);
            colourKeywords.put("snow", -1286);
            colourKeywords.put("springgreen", -16711809);
            colourKeywords.put("steelblue", -12156236);
            colourKeywords.put("tan", -2968436);
            colourKeywords.put("teal", -16744320);
            colourKeywords.put("thistle", -2572328);
            colourKeywords.put("tomato", -40121);
            colourKeywords.put("turquoise", -12525360);
            colourKeywords.put("violet", -1146130);
            colourKeywords.put("wheat", -663885);
            colourKeywords.put("white", -1);
            colourKeywords.put("whitesmoke", -657931);
            colourKeywords.put("yellow", Integer.valueOf(InputDeviceCompat.SOURCE_ANY));
            colourKeywords.put("yellowgreen", -6632142);
            colourKeywords.put("transparent", 0);
        }

        static Integer get(String colourName) {
            return colourKeywords.get(colourName);
        }
    }

    private static class FontSizeKeywords {
        private static final Map<String, SVG.Length> fontSizeKeywords = new HashMap(9);

        private FontSizeKeywords() {
        }

        static {
            fontSizeKeywords.put("xx-small", new SVG.Length(0.694f, SVG.Unit.pt));
            fontSizeKeywords.put("x-small", new SVG.Length(0.833f, SVG.Unit.pt));
            fontSizeKeywords.put("small", new SVG.Length(10.0f, SVG.Unit.pt));
            fontSizeKeywords.put("medium", new SVG.Length(12.0f, SVG.Unit.pt));
            fontSizeKeywords.put("large", new SVG.Length(14.4f, SVG.Unit.pt));
            fontSizeKeywords.put("x-large", new SVG.Length(17.3f, SVG.Unit.pt));
            fontSizeKeywords.put("xx-large", new SVG.Length(20.7f, SVG.Unit.pt));
            fontSizeKeywords.put("smaller", new SVG.Length(83.33f, SVG.Unit.percent));
            fontSizeKeywords.put("larger", new SVG.Length(120.0f, SVG.Unit.percent));
        }

        static SVG.Length get(String fontSize) {
            return fontSizeKeywords.get(fontSize);
        }
    }

    private static class FontWeightKeywords {
        private static final Map<String, Integer> fontWeightKeywords = new HashMap(13);

        private FontWeightKeywords() {
        }

        static {
            fontWeightKeywords.put("normal", 400);
            fontWeightKeywords.put("bold", 700);
            fontWeightKeywords.put("bolder", 1);
            fontWeightKeywords.put("lighter", -1);
            fontWeightKeywords.put("100", 100);
            fontWeightKeywords.put("200", 200);
            fontWeightKeywords.put("300", 300);
            fontWeightKeywords.put("400", 400);
            fontWeightKeywords.put("500", 500);
            fontWeightKeywords.put("600", 600);
            fontWeightKeywords.put("700", 700);
            fontWeightKeywords.put("800", 800);
            fontWeightKeywords.put("900", 900);
        }

        static Integer get(String fontWeight) {
            return fontWeightKeywords.get(fontWeight);
        }
    }

    private static class AspectRatioKeywords {
        private static final Map<String, PreserveAspectRatio.Alignment> aspectRatioKeywords = new HashMap(10);

        private AspectRatioKeywords() {
        }

        static {
            aspectRatioKeywords.put(SVGParser.NONE, PreserveAspectRatio.Alignment.none);
            aspectRatioKeywords.put("xMinYMin", PreserveAspectRatio.Alignment.xMinYMin);
            aspectRatioKeywords.put("xMidYMin", PreserveAspectRatio.Alignment.xMidYMin);
            aspectRatioKeywords.put("xMaxYMin", PreserveAspectRatio.Alignment.xMaxYMin);
            aspectRatioKeywords.put("xMinYMid", PreserveAspectRatio.Alignment.xMinYMid);
            aspectRatioKeywords.put("xMidYMid", PreserveAspectRatio.Alignment.xMidYMid);
            aspectRatioKeywords.put("xMaxYMid", PreserveAspectRatio.Alignment.xMaxYMid);
            aspectRatioKeywords.put("xMinYMax", PreserveAspectRatio.Alignment.xMinYMax);
            aspectRatioKeywords.put("xMidYMax", PreserveAspectRatio.Alignment.xMidYMax);
            aspectRatioKeywords.put("xMaxYMax", PreserveAspectRatio.Alignment.xMaxYMax);
        }

        static PreserveAspectRatio.Alignment get(String aspectRatio) {
            return aspectRatioKeywords.get(aspectRatio);
        }
    }

    SVG parse(InputStream is, boolean enableInternalEntities) throws SVGParseException {
        if (!is.markSupported()) {
            is = new BufferedInputStream(is);
        }
        try {
            is.mark(3);
            int firstTwoBytes = is.read() + (is.read() << 8);
            is.reset();
            if (firstTwoBytes == 35615) {
                is = new BufferedInputStream(new GZIPInputStream(is));
            }
        } catch (IOException e) {
        }
        try {
            is.mark(4096);
            parseUsingXmlPullParser(is, enableInternalEntities);
            return this.svgDocument;
        } finally {
            try {
                is.close();
            } catch (IOException e2) {
                Log.e(TAG, "Exception thrown closing input stream");
            }
        }
    }

    private class XPPAttributesWrapper implements Attributes {
        private XmlPullParser parser;

        public XPPAttributesWrapper(XmlPullParser parser) {
            this.parser = parser;
        }

        @Override // org.xml.sax.Attributes
        public int getLength() {
            return this.parser.getAttributeCount();
        }

        @Override // org.xml.sax.Attributes
        public String getURI(int index) {
            return this.parser.getAttributeNamespace(index);
        }

        @Override // org.xml.sax.Attributes
        public String getLocalName(int index) {
            return this.parser.getAttributeName(index);
        }

        @Override // org.xml.sax.Attributes
        public String getQName(int index) {
            String qName = this.parser.getAttributeName(index);
            if (this.parser.getAttributePrefix(index) != null) {
                return this.parser.getAttributePrefix(index) + AbstractJsonLexerKt.COLON + qName;
            }
            return qName;
        }

        @Override // org.xml.sax.Attributes
        public String getValue(int index) {
            return this.parser.getAttributeValue(index);
        }

        @Override // org.xml.sax.Attributes
        public String getType(int index) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public int getIndex(String uri, String localName) {
            return -1;
        }

        @Override // org.xml.sax.Attributes
        public int getIndex(String qName) {
            return -1;
        }

        @Override // org.xml.sax.Attributes
        public String getType(String uri, String localName) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getType(String qName) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getValue(String uri, String localName) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getValue(String qName) {
            return null;
        }
    }

    private void parseUsingXmlPullParser(InputStream is, boolean enableInternalEntities) throws SVGParseException {
        try {
            try {
                XmlPullParser parser = Xml.newPullParser();
                XPPAttributesWrapper attributes = new XPPAttributesWrapper(parser);
                parser.setFeature("http://xmlpull.org/v1/doc/features.html#process-docdecl", false);
                parser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                parser.setInput(is, null);
                for (int eventType = parser.getEventType(); eventType != 1; eventType = parser.nextToken()) {
                    switch (eventType) {
                        case 0:
                            startDocument();
                            break;
                        case 2:
                            String qName = parser.getName();
                            if (parser.getPrefix() != null) {
                                qName = parser.getPrefix() + AbstractJsonLexerKt.COLON + qName;
                            }
                            startElement(parser.getNamespace(), parser.getName(), qName, attributes);
                            break;
                        case 3:
                            String qName2 = parser.getName();
                            if (parser.getPrefix() != null) {
                                qName2 = parser.getPrefix() + AbstractJsonLexerKt.COLON + qName2;
                            }
                            endElement(parser.getNamespace(), parser.getName(), qName2);
                            break;
                        case 4:
                            int[] startAndLength = new int[2];
                            char[] text = parser.getTextCharacters(startAndLength);
                            text(text, startAndLength[0], startAndLength[1]);
                            break;
                        case 5:
                            text(parser.getText());
                            break;
                        case 8:
                            Log.d(TAG, "PROC INSTR: " + parser.getText());
                            TextScanner scan = new TextScanner(parser.getText());
                            String instr = scan.nextToken();
                            handleProcessingInstruction(instr, parseProcessingInstructionAttributes(scan));
                            break;
                        case 10:
                            if (!enableInternalEntities || this.svgDocument.getRootElement() != null || !parser.getText().contains("<!ENTITY ")) {
                                break;
                            } else {
                                try {
                                    Log.d(TAG, "Switching to SAX parser to process entities");
                                    is.reset();
                                    parseUsingSAX(is);
                                    return;
                                } catch (IOException e) {
                                    Log.w(TAG, "Detected internal entity definitions, but could not parse them.");
                                    return;
                                }
                            }
                            break;
                    }
                }
                endDocument();
            } catch (IOException e2) {
                throw new SVGParseException("Stream error", e2);
            }
        } catch (XmlPullParserException e3) {
            throw new SVGParseException("XML parser problem", e3);
        }
    }

    private void parseUsingSAX(InputStream is) throws SVGParseException {
        Log.d(TAG, "Falling back to SAX parser");
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setFeature("http://xml.org/sax/features/external-general-entities", false);
            spf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            SAXParser sp = spf.newSAXParser();
            XMLReader xr = sp.getXMLReader();
            SAXHandler handler = new SAXHandler(this, null);
            xr.setContentHandler(handler);
            xr.setProperty("http://xml.org/sax/properties/lexical-handler", handler);
            xr.parse(new InputSource(is));
        } catch (IOException e) {
            throw new SVGParseException("Stream error", e);
        } catch (ParserConfigurationException e2) {
            throw new SVGParseException("XML parser problem", e2);
        } catch (SAXException e3) {
            throw new SVGParseException("SVG parse error", e3);
        }
    }

    private class SAXHandler extends DefaultHandler2 {
        private SAXHandler() {
        }

        /* synthetic */ SAXHandler(SVGParser x0, C26121 x1) {
            this();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startDocument() throws SAXException {
            SVGParser.this.startDocument();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            SVGParser.this.startElement(uri, localName, qName, attributes);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] ch, int start, int length) throws SAXException {
            SVGParser.this.text(new String(ch, start, length));
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String uri, String localName, String qName) throws SAXException {
            SVGParser.this.endElement(uri, localName, qName);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endDocument() throws SAXException {
            SVGParser.this.endDocument();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void processingInstruction(String target, String data) throws SAXException {
            TextScanner scan = new TextScanner(data);
            Map<String, String> attributes = SVGParser.this.parseProcessingInstructionAttributes(scan);
            SVGParser.this.handleProcessingInstruction(target, attributes);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDocument() {
        this.svgDocument = new SVG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SVGParseException {
        if (this.ignoring) {
            this.ignoreDepth++;
        }
        if (!SVG_NAMESPACE.equals(uri) && !"".equals(uri)) {
            return;
        }
        String tag = localName.length() > 0 ? localName : qName;
        SVGElem elem = SVGElem.fromString(tag);
        switch (C26121.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[elem.ordinal()]) {
            case 1:
                svg(attributes);
                break;
            case 2:
            case 3:
                m79g(attributes);
                break;
            case 4:
                defs(attributes);
                break;
            case 5:
                use(attributes);
                break;
            case 6:
                path(attributes);
                break;
            case 7:
                rect(attributes);
                break;
            case 8:
                circle(attributes);
                break;
            case 9:
                ellipse(attributes);
                break;
            case 10:
                line(attributes);
                break;
            case 11:
                polyline(attributes);
                break;
            case 12:
                polygon(attributes);
                break;
            case 13:
                text(attributes);
                break;
            case 14:
                tspan(attributes);
                break;
            case 15:
                tref(attributes);
                break;
            case 16:
                zwitch(attributes);
                break;
            case 17:
                symbol(attributes);
                break;
            case 18:
                marker(attributes);
                break;
            case 19:
                linearGradient(attributes);
                break;
            case 20:
                radialGradient(attributes);
                break;
            case 21:
                stop(attributes);
                break;
            case 22:
            case 23:
                this.inMetadataElement = true;
                this.metadataTag = elem;
                break;
            case 24:
                clipPath(attributes);
                break;
            case 25:
                textPath(attributes);
                break;
            case 26:
                pattern(attributes);
                break;
            case 27:
                image(attributes);
                break;
            case 28:
                view(attributes);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /* 29 */:
                mask(attributes);
                break;
            case 30:
                style(attributes);
                break;
            case 31:
                solidColor(attributes);
                break;
            default:
                this.ignoring = true;
                this.ignoreDepth = 1;
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void text(String characters) throws SVGParseException {
        if (this.ignoring) {
            return;
        }
        if (this.inMetadataElement) {
            if (this.metadataElementContents == null) {
                this.metadataElementContents = new StringBuilder(characters.length());
            }
            this.metadataElementContents.append(characters);
        } else if (this.inStyleElement) {
            if (this.styleElementContents == null) {
                this.styleElementContents = new StringBuilder(characters.length());
            }
            this.styleElementContents.append(characters);
        } else if (this.currentElement instanceof SVG.TextContainer) {
            appendToTextContainer(characters);
        }
    }

    private void text(char[] ch, int start, int length) throws SVGParseException {
        if (this.ignoring) {
            return;
        }
        if (this.inMetadataElement) {
            if (this.metadataElementContents == null) {
                this.metadataElementContents = new StringBuilder(length);
            }
            this.metadataElementContents.append(ch, start, length);
        } else if (this.inStyleElement) {
            if (this.styleElementContents == null) {
                this.styleElementContents = new StringBuilder(length);
            }
            this.styleElementContents.append(ch, start, length);
        } else if (this.currentElement instanceof SVG.TextContainer) {
            appendToTextContainer(new String(ch, start, length));
        }
    }

    private void appendToTextContainer(String characters) throws SVGParseException {
        SVG.SvgConditionalContainer parent = (SVG.SvgConditionalContainer) this.currentElement;
        int numOlderSiblings = parent.children.size();
        SVG.SvgObject previousSibling = numOlderSiblings == 0 ? null : parent.children.get(numOlderSiblings - 1);
        if (previousSibling instanceof SVG.TextSequence) {
            ((SVG.TextSequence) previousSibling).text += characters;
        } else {
            this.currentElement.addChild(new SVG.TextSequence(characters));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endElement(String uri, String localName, String qName) throws SVGParseException {
        if (this.ignoring) {
            int i = this.ignoreDepth - 1;
            this.ignoreDepth = i;
            if (i == 0) {
                this.ignoring = false;
            }
        }
        if (!SVG_NAMESPACE.equals(uri) && !"".equals(uri)) {
            return;
        }
        String tag = localName.length() > 0 ? localName : qName;
        switch (C26121.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.fromString(tag).ordinal()]) {
            case 1:
            case 2:
            case 4:
            case 5:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /* 29 */:
            case 31:
                this.currentElement = ((SVG.SvgObject) this.currentElement).parent;
                break;
            case 22:
            case 23:
                this.inMetadataElement = false;
                if (this.metadataElementContents != null) {
                    if (this.metadataTag == SVGElem.title) {
                        this.svgDocument.setTitle(this.metadataElementContents.toString());
                    } else if (this.metadataTag == SVGElem.desc) {
                        this.svgDocument.setDesc(this.metadataElementContents.toString());
                    }
                    this.metadataElementContents.setLength(0);
                }
                break;
            case 30:
                if (this.styleElementContents != null) {
                    this.inStyleElement = false;
                    parseCSSStyleSheet(this.styleElementContents.toString());
                    this.styleElementContents.setLength(0);
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endDocument() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleProcessingInstruction(String instruction, Map<String, String> attributes) {
        String attr;
        String css;
        if (instruction.equals(XML_STYLESHEET_PROCESSING_INSTRUCTION) && SVG.getFileResolver() != null) {
            String attr2 = attributes.get(XML_STYLESHEET_ATTR_TYPE);
            if (attr2 != null && !"text/css".equals(attributes.get(XML_STYLESHEET_ATTR_TYPE))) {
                return;
            }
            String attr3 = attributes.get(XML_STYLESHEET_ATTR_ALTERNATE);
            if ((attr3 != null && !XML_STYLESHEET_ATTR_ALTERNATE_NO.equals(attributes.get(XML_STYLESHEET_ATTR_ALTERNATE))) || (attr = attributes.get(XML_STYLESHEET_ATTR_HREF)) == null || (css = SVG.getFileResolver().resolveCSSStyleSheet(attr)) == null) {
                return;
            }
            String mediaAttr = attributes.get(XML_STYLESHEET_ATTR_MEDIA);
            if (mediaAttr != null && !XML_STYLESHEET_ATTR_MEDIA_ALL.equals(mediaAttr.trim())) {
                css = "@media " + mediaAttr + " { " + css + "}";
            }
            parseCSSStyleSheet(css);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> parseProcessingInstructionAttributes(TextScanner scan) {
        HashMap<String, String> attributes = new HashMap<>();
        scan.skipWhitespace();
        String attrName = scan.nextToken('=');
        while (attrName != null) {
            scan.consume('=');
            String value = scan.nextQuotedString();
            attributes.put(attrName, value);
            scan.skipWhitespace();
            attrName = scan.nextToken('=');
        }
        return attributes;
    }

    private void dumpNode(SVG.SvgObject elem, String indent) {
        Log.d(TAG, indent + elem);
        if (elem instanceof SVG.SvgConditionalContainer) {
            String indent2 = indent + "  ";
            for (SVG.SvgObject child : ((SVG.SvgConditionalContainer) elem).children) {
                dumpNode(child, indent2);
            }
        }
    }

    private void debug(String format, Object... args) {
    }

    private void svg(Attributes attributes) throws SVGParseException {
        debug("<svg>", new Object[0]);
        SVG.Svg obj = new SVG.Svg();
        obj.document = this.svgDocument;
        obj.parent = this.currentElement;
        parseAttributesCore(obj, attributes);
        parseAttributesStyle(obj, attributes);
        parseAttributesConditional(obj, attributes);
        parseAttributesViewBox(obj, attributes);
        parseAttributesSVG(obj, attributes);
        if (this.currentElement == null) {
            this.svgDocument.setRootElement(obj);
        } else {
            this.currentElement.addChild(obj);
        }
        this.currentElement = obj;
    }

    private void parseAttributesSVG(SVG.Svg obj, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String val = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    obj.f289x = parseLength(val);
                    break;
                case y:
                    obj.f290y = parseLength(val);
                    break;
                case width:
                    obj.width = parseLength(val);
                    if (obj.width.isNegative()) {
                        throw new SVGParseException("Invalid <svg> element. width cannot be negative");
                    }
                    break;
                    break;
                case height:
                    obj.height = parseLength(val);
                    if (obj.height.isNegative()) {
                        throw new SVGParseException("Invalid <svg> element. height cannot be negative");
                    }
                    break;
                    break;
                case version:
                    obj.version = val;
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: com.caverock.androidsvg.SVGParser$1 */
    static /* synthetic */ class C26121 {
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem;

        static {
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.x.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.y.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.width.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.height.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.version.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.href.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.preserveAspectRatio.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.d.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.pathLength.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.rx.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.ry.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.cx.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.cy.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.r.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.x1.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.y1.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.x2.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.y2.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.dx.ordinal()] = 19;
            } catch (NoSuchFieldError e19) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.dy.ordinal()] = 20;
            } catch (NoSuchFieldError e20) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.requiredFeatures.ordinal()] = 21;
            } catch (NoSuchFieldError e21) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.requiredExtensions.ordinal()] = 22;
            } catch (NoSuchFieldError e22) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.systemLanguage.ordinal()] = 23;
            } catch (NoSuchFieldError e23) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.requiredFormats.ordinal()] = 24;
            } catch (NoSuchFieldError e24) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.requiredFonts.ordinal()] = 25;
            } catch (NoSuchFieldError e25) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.refX.ordinal()] = 26;
            } catch (NoSuchFieldError e26) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.refY.ordinal()] = 27;
            } catch (NoSuchFieldError e27) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.markerWidth.ordinal()] = 28;
            } catch (NoSuchFieldError e28) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.markerHeight.ordinal()] = 29;
            } catch (NoSuchFieldError e29) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.markerUnits.ordinal()] = 30;
            } catch (NoSuchFieldError e30) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.orient.ordinal()] = 31;
            } catch (NoSuchFieldError e31) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.gradientUnits.ordinal()] = 32;
            } catch (NoSuchFieldError e32) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.gradientTransform.ordinal()] = 33;
            } catch (NoSuchFieldError e33) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.spreadMethod.ordinal()] = 34;
            } catch (NoSuchFieldError e34) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fx.ordinal()] = 35;
            } catch (NoSuchFieldError e35) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fy.ordinal()] = 36;
            } catch (NoSuchFieldError e36) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.offset.ordinal()] = 37;
            } catch (NoSuchFieldError e37) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.clipPathUnits.ordinal()] = 38;
            } catch (NoSuchFieldError e38) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.startOffset.ordinal()] = 39;
            } catch (NoSuchFieldError e39) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.patternUnits.ordinal()] = 40;
            } catch (NoSuchFieldError e40) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.patternContentUnits.ordinal()] = 41;
            } catch (NoSuchFieldError e41) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.patternTransform.ordinal()] = 42;
            } catch (NoSuchFieldError e42) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.maskUnits.ordinal()] = 43;
            } catch (NoSuchFieldError e43) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.maskContentUnits.ordinal()] = 44;
            } catch (NoSuchFieldError e44) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.style.ordinal()] = 45;
            } catch (NoSuchFieldError e45) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.CLASS.ordinal()] = 46;
            } catch (NoSuchFieldError e46) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fill.ordinal()] = 47;
            } catch (NoSuchFieldError e47) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fill_rule.ordinal()] = 48;
            } catch (NoSuchFieldError e48) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fill_opacity.ordinal()] = 49;
            } catch (NoSuchFieldError e49) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke.ordinal()] = 50;
            } catch (NoSuchFieldError e50) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke_opacity.ordinal()] = 51;
            } catch (NoSuchFieldError e51) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke_width.ordinal()] = 52;
            } catch (NoSuchFieldError e52) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke_linecap.ordinal()] = 53;
            } catch (NoSuchFieldError e53) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke_linejoin.ordinal()] = 54;
            } catch (NoSuchFieldError e54) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke_miterlimit.ordinal()] = 55;
            } catch (NoSuchFieldError e55) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke_dasharray.ordinal()] = 56;
            } catch (NoSuchFieldError e56) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke_dashoffset.ordinal()] = 57;
            } catch (NoSuchFieldError e57) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.opacity.ordinal()] = 58;
            } catch (NoSuchFieldError e58) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.color.ordinal()] = 59;
            } catch (NoSuchFieldError e59) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.font.ordinal()] = 60;
            } catch (NoSuchFieldError e60) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.font_family.ordinal()] = 61;
            } catch (NoSuchFieldError e61) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.font_size.ordinal()] = 62;
            } catch (NoSuchFieldError e62) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.font_weight.ordinal()] = 63;
            } catch (NoSuchFieldError e63) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.font_style.ordinal()] = 64;
            } catch (NoSuchFieldError e64) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.text_decoration.ordinal()] = 65;
            } catch (NoSuchFieldError e65) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.direction.ordinal()] = 66;
            } catch (NoSuchFieldError e66) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.text_anchor.ordinal()] = 67;
            } catch (NoSuchFieldError e67) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.overflow.ordinal()] = 68;
            } catch (NoSuchFieldError e68) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.marker.ordinal()] = 69;
            } catch (NoSuchFieldError e69) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.marker_start.ordinal()] = 70;
            } catch (NoSuchFieldError e70) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.marker_mid.ordinal()] = 71;
            } catch (NoSuchFieldError e71) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.marker_end.ordinal()] = 72;
            } catch (NoSuchFieldError e72) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.display.ordinal()] = 73;
            } catch (NoSuchFieldError e73) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.visibility.ordinal()] = 74;
            } catch (NoSuchFieldError e74) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stop_color.ordinal()] = 75;
            } catch (NoSuchFieldError e75) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stop_opacity.ordinal()] = 76;
            } catch (NoSuchFieldError e76) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.clip.ordinal()] = 77;
            } catch (NoSuchFieldError e77) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.clip_path.ordinal()] = 78;
            } catch (NoSuchFieldError e78) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.clip_rule.ordinal()] = 79;
            } catch (NoSuchFieldError e79) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.mask.ordinal()] = 80;
            } catch (NoSuchFieldError e80) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.solid_color.ordinal()] = 81;
            } catch (NoSuchFieldError e81) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.solid_opacity.ordinal()] = 82;
            } catch (NoSuchFieldError e82) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.viewport_fill.ordinal()] = 83;
            } catch (NoSuchFieldError e83) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.viewport_fill_opacity.ordinal()] = 84;
            } catch (NoSuchFieldError e84) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.vector_effect.ordinal()] = 85;
            } catch (NoSuchFieldError e85) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.image_rendering.ordinal()] = 86;
            } catch (NoSuchFieldError e86) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.viewBox.ordinal()] = 87;
            } catch (NoSuchFieldError e87) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.type.ordinal()] = 88;
            } catch (NoSuchFieldError e88) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.media.ordinal()] = 89;
            } catch (NoSuchFieldError e89) {
            }
            $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem = new int[SVGElem.values().length];
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.svg.ordinal()] = 1;
            } catch (NoSuchFieldError e90) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.g.ordinal()] = 2;
            } catch (NoSuchFieldError e91) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.a.ordinal()] = 3;
            } catch (NoSuchFieldError e92) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.defs.ordinal()] = 4;
            } catch (NoSuchFieldError e93) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.use.ordinal()] = 5;
            } catch (NoSuchFieldError e94) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.path.ordinal()] = 6;
            } catch (NoSuchFieldError e95) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.rect.ordinal()] = 7;
            } catch (NoSuchFieldError e96) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.circle.ordinal()] = 8;
            } catch (NoSuchFieldError e97) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.ellipse.ordinal()] = 9;
            } catch (NoSuchFieldError e98) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.line.ordinal()] = 10;
            } catch (NoSuchFieldError e99) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.polyline.ordinal()] = 11;
            } catch (NoSuchFieldError e100) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.polygon.ordinal()] = 12;
            } catch (NoSuchFieldError e101) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.text.ordinal()] = 13;
            } catch (NoSuchFieldError e102) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.tspan.ordinal()] = 14;
            } catch (NoSuchFieldError e103) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.tref.ordinal()] = 15;
            } catch (NoSuchFieldError e104) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.SWITCH.ordinal()] = 16;
            } catch (NoSuchFieldError e105) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.symbol.ordinal()] = 17;
            } catch (NoSuchFieldError e106) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.marker.ordinal()] = 18;
            } catch (NoSuchFieldError e107) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.linearGradient.ordinal()] = 19;
            } catch (NoSuchFieldError e108) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.radialGradient.ordinal()] = 20;
            } catch (NoSuchFieldError e109) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.stop.ordinal()] = 21;
            } catch (NoSuchFieldError e110) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.title.ordinal()] = 22;
            } catch (NoSuchFieldError e111) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.desc.ordinal()] = 23;
            } catch (NoSuchFieldError e112) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.clipPath.ordinal()] = 24;
            } catch (NoSuchFieldError e113) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.textPath.ordinal()] = 25;
            } catch (NoSuchFieldError e114) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.pattern.ordinal()] = 26;
            } catch (NoSuchFieldError e115) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.image.ordinal()] = 27;
            } catch (NoSuchFieldError e116) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.view.ordinal()] = 28;
            } catch (NoSuchFieldError e117) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.mask.ordinal()] = 29;
            } catch (NoSuchFieldError e118) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.style.ordinal()] = 30;
            } catch (NoSuchFieldError e119) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.solidColor.ordinal()] = 31;
            } catch (NoSuchFieldError e120) {
            }
        }
    }

    /* JADX INFO: renamed from: g */
    private void m79g(Attributes attributes) throws SVGParseException {
        debug("<g>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Group obj = new SVG.Group();
        obj.document = this.svgDocument;
        obj.parent = this.currentElement;
        parseAttributesCore(obj, attributes);
        parseAttributesStyle(obj, attributes);
        parseAttributesTransform(obj, attributes);
        parseAttributesConditional(obj, attributes);
        this.currentElement.addChild(obj);
        this.currentElement = obj;
    }

    private void defs(Attributes attributes) throws SVGParseException {
        debug("<defs>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Defs obj = new SVG.Defs();
        obj.document = this.svgDocument;
        obj.parent = this.currentElement;
        parseAttributesCore(obj, attributes);
        parseAttributesStyle(obj, attributes);
        parseAttributesTransform(obj, attributes);
        this.currentElement.addChild(obj);
        this.currentElement = obj;
    }

    private void use(Attributes attributes) throws SVGParseException {
        debug("<use>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Use obj = new SVG.Use();
        obj.document = this.svgDocument;
        obj.parent = this.currentElement;
        parseAttributesCore(obj, attributes);
        parseAttributesStyle(obj, attributes);
        parseAttributesTransform(obj, attributes);
        parseAttributesConditional(obj, attributes);
        parseAttributesUse(obj, attributes);
        this.currentElement.addChild(obj);
        this.currentElement = obj;
    }

    private void parseAttributesUse(SVG.Use obj, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String val = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    obj.f313x = parseLength(val);
                    break;
                case y:
                    obj.f314y = parseLength(val);
                    break;
                case width:
                    obj.width = parseLength(val);
                    if (obj.width.isNegative()) {
                        throw new SVGParseException("Invalid <use> element. width cannot be negative");
                    }
                    break;
                    break;
                case height:
                    obj.height = parseLength(val);
                    if (obj.height.isNegative()) {
                        throw new SVGParseException("Invalid <use> element. height cannot be negative");
                    }
                    break;
                    break;
                case href:
                    if ("".equals(attributes.getURI(i)) || XLINK_NAMESPACE.equals(attributes.getURI(i))) {
                        obj.href = val;
                    }
                    break;
            }
        }
    }

    private void image(Attributes attributes) throws SVGParseException {
        debug("<image>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Image obj = new SVG.Image();
        obj.document = this.svgDocument;
        obj.parent = this.currentElement;
        parseAttributesCore(obj, attributes);
        parseAttributesStyle(obj, attributes);
        parseAttributesTransform(obj, attributes);
        parseAttributesConditional(obj, attributes);
        parseAttributesImage(obj, attributes);
        this.currentElement.addChild(obj);
        this.currentElement = obj;
    }

    private void parseAttributesImage(SVG.Image obj, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String val = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    obj.f274x = parseLength(val);
                    break;
                case y:
                    obj.f275y = parseLength(val);
                    break;
                case width:
                    obj.width = parseLength(val);
                    if (obj.width.isNegative()) {
                        throw new SVGParseException("Invalid <use> element. width cannot be negative");
                    }
                    break;
                    break;
                case height:
                    obj.height = parseLength(val);
                    if (obj.height.isNegative()) {
                        throw new SVGParseException("Invalid <use> element. height cannot be negative");
                    }
                    break;
                    break;
                case href:
                    if ("".equals(attributes.getURI(i)) || XLINK_NAMESPACE.equals(attributes.getURI(i))) {
                        obj.href = val;
                    }
                    break;
                case preserveAspectRatio:
                    parsePreserveAspectRatio(obj, val);
                    break;
            }
        }
    }

    private void path(Attributes attributes) throws SVGParseException {
        debug("<path>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Path obj = new SVG.Path();
        obj.document = this.svgDocument;
        obj.parent = this.currentElement;
        parseAttributesCore(obj, attributes);
        parseAttributesStyle(obj, attributes);
        parseAttributesTransform(obj, attributes);
        parseAttributesConditional(obj, attributes);
        parseAttributesPath(obj, attributes);
        this.currentElement.addChild(obj);
    }

    private void parseAttributesPath(SVG.Path obj, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String val = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case d:
                    obj.f282d = parsePath(val);
                    break;
                case pathLength:
                    obj.pathLength = Float.valueOf(parseFloat(val));
                    if (obj.pathLength.floatValue() < 0.0f) {
                        throw new SVGParseException("Invalid <path> element. pathLength cannot be negative");
                    }
                    break;
                    break;
            }
        }
    }

    private void rect(Attributes attributes) throws SVGParseException {
        debug("<rect>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Rect obj = new SVG.Rect();
        obj.document = this.svgDocument;
        obj.parent = this.currentElement;
        parseAttributesCore(obj, attributes);
        parseAttributesStyle(obj, attributes);
        parseAttributesTransform(obj, attributes);
        parseAttributesConditional(obj, attributes);
        parseAttributesRect(obj, attributes);
        this.currentElement.addChild(obj);
    }

    private void parseAttributesRect(SVG.Rect obj, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String val = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    obj.f287x = parseLength(val);
                    break;
                case y:
                    obj.f288y = parseLength(val);
                    break;
                case width:
                    obj.width = parseLength(val);
                    if (obj.width.isNegative()) {
                        throw new SVGParseException("Invalid <rect> element. width cannot be negative");
                    }
                    break;
                    break;
                case height:
                    obj.height = parseLength(val);
                    if (obj.height.isNegative()) {
                        throw new SVGParseException("Invalid <rect> element. height cannot be negative");
                    }
                    break;
                    break;
                case rx:
                    obj.f285rx = parseLength(val);
                    if (obj.f285rx.isNegative()) {
                        throw new SVGParseException("Invalid <rect> element. rx cannot be negative");
                    }
                    break;
                    break;
                case ry:
                    obj.f286ry = parseLength(val);
                    if (obj.f286ry.isNegative()) {
                        throw new SVGParseException("Invalid <rect> element. ry cannot be negative");
                    }
                    break;
                    break;
            }
        }
    }

    private void circle(Attributes attributes) throws SVGParseException {
        debug("<circle>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Circle obj = new SVG.Circle();
        obj.document = this.svgDocument;
        obj.parent = this.currentElement;
        parseAttributesCore(obj, attributes);
        parseAttributesStyle(obj, attributes);
        parseAttributesTransform(obj, attributes);
        parseAttributesConditional(obj, attributes);
        parseAttributesCircle(obj, attributes);
        this.currentElement.addChild(obj);
    }

    private void parseAttributesCircle(SVG.Circle obj, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String val = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case cx:
                    obj.f267cx = parseLength(val);
                    break;
                case cy:
                    obj.f268cy = parseLength(val);
                    break;
                case r:
                    obj.f269r = parseLength(val);
                    if (obj.f269r.isNegative()) {
                        throw new SVGParseException("Invalid <circle> element. r cannot be negative");
                    }
                    break;
                    break;
            }
        }
    }

    private void ellipse(Attributes attributes) throws SVGParseException {
        debug("<ellipse>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Ellipse obj = new SVG.Ellipse();
        obj.document = this.svgDocument;
        obj.parent = this.currentElement;
        parseAttributesCore(obj, attributes);
        parseAttributesStyle(obj, attributes);
        parseAttributesTransform(obj, attributes);
        parseAttributesConditional(obj, attributes);
        parseAttributesEllipse(obj, attributes);
        this.currentElement.addChild(obj);
    }

    private void parseAttributesEllipse(SVG.Ellipse obj, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String val = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case rx:
                    obj.f272rx = parseLength(val);
                    if (obj.f272rx.isNegative()) {
                        throw new SVGParseException("Invalid <ellipse> element. rx cannot be negative");
                    }
                    break;
                    break;
                case ry:
                    obj.f273ry = parseLength(val);
                    if (obj.f273ry.isNegative()) {
                        throw new SVGParseException("Invalid <ellipse> element. ry cannot be negative");
                    }
                    break;
                    break;
                case cx:
                    obj.f270cx = parseLength(val);
                    break;
                case cy:
                    obj.f271cy = parseLength(val);
                    break;
            }
        }
    }

    private void line(Attributes attributes) throws SVGParseException {
        debug("<line>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Line obj = new SVG.Line();
        obj.document = this.svgDocument;
        obj.parent = this.currentElement;
        parseAttributesCore(obj, attributes);
        parseAttributesStyle(obj, attributes);
        parseAttributesTransform(obj, attributes);
        parseAttributesConditional(obj, attributes);
        parseAttributesLine(obj, attributes);
        this.currentElement.addChild(obj);
    }

    private void parseAttributesLine(SVG.Line obj, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String val = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x1:
                    obj.f276x1 = parseLength(val);
                    break;
                case y1:
                    obj.f278y1 = parseLength(val);
                    break;
                case x2:
                    obj.f277x2 = parseLength(val);
                    break;
                case y2:
                    obj.f279y2 = parseLength(val);
                    break;
            }
        }
    }

    private void polyline(Attributes attributes) throws SVGParseException {
        debug("<polyline>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.PolyLine obj = new SVG.PolyLine();
        obj.document = this.svgDocument;
        obj.parent = this.currentElement;
        parseAttributesCore(obj, attributes);
        parseAttributesStyle(obj, attributes);
        parseAttributesTransform(obj, attributes);
        parseAttributesConditional(obj, attributes);
        parseAttributesPolyLine(obj, attributes, "polyline");
        this.currentElement.addChild(obj);
    }

    private void parseAttributesPolyLine(SVG.PolyLine obj, Attributes attributes, String tag) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (SVGAttr.fromString(attributes.getLocalName(i)) == SVGAttr.points) {
                TextScanner scan = new TextScanner(attributes.getValue(i));
                List<Float> points = new ArrayList<>();
                scan.skipWhitespace();
                while (!scan.empty()) {
                    float x = scan.nextFloat();
                    if (Float.isNaN(x)) {
                        throw new SVGParseException("Invalid <" + tag + "> points attribute. Non-coordinate content found in list.");
                    }
                    scan.skipCommaWhitespace();
                    float y = scan.nextFloat();
                    if (Float.isNaN(y)) {
                        throw new SVGParseException("Invalid <" + tag + "> points attribute. There should be an even number of coordinates.");
                    }
                    scan.skipCommaWhitespace();
                    points.add(Float.valueOf(x));
                    points.add(Float.valueOf(y));
                }
                obj.points = new float[points.size()];
                int j = 0;
                Iterator<Float> it = points.iterator();
                while (it.hasNext()) {
                    float f = it.next().floatValue();
                    obj.points[j] = f;
                    j++;
                }
            }
        }
    }

    private void polygon(Attributes attributes) throws SVGParseException {
        debug("<polygon>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Polygon obj = new SVG.Polygon();
        obj.document = this.svgDocument;
        obj.parent = this.currentElement;
        parseAttributesCore(obj, attributes);
        parseAttributesStyle(obj, attributes);
        parseAttributesTransform(obj, attributes);
        parseAttributesConditional(obj, attributes);
        parseAttributesPolyLine(obj, attributes, "polygon");
        this.currentElement.addChild(obj);
    }

    private void text(Attributes attributes) throws SVGParseException {
        debug("<text>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Text obj = new SVG.Text();
        obj.document = this.svgDocument;
        obj.parent = this.currentElement;
        parseAttributesCore(obj, attributes);
        parseAttributesStyle(obj, attributes);
        parseAttributesTransform(obj, attributes);
        parseAttributesConditional(obj, attributes);
        parseAttributesTextPosition(obj, attributes);
        this.currentElement.addChild(obj);
        this.currentElement = obj;
    }

    private void parseAttributesTextPosition(SVG.TextPositionedContainer obj, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String val = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    obj.f303x = parseLengthList(val);
                    break;
                case y:
                    obj.f304y = parseLengthList(val);
                    break;
                case dx:
                    obj.f301dx = parseLengthList(val);
                    break;
                case dy:
                    obj.f302dy = parseLengthList(val);
                    break;
            }
        }
    }

    private void tspan(Attributes attributes) throws SVGParseException {
        debug("<tspan>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        if (!(this.currentElement instanceof SVG.TextContainer)) {
            throw new SVGParseException("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
        }
        SVG.TSpan obj = new SVG.TSpan();
        obj.document = this.svgDocument;
        obj.parent = this.currentElement;
        parseAttributesCore(obj, attributes);
        parseAttributesStyle(obj, attributes);
        parseAttributesConditional(obj, attributes);
        parseAttributesTextPosition(obj, attributes);
        this.currentElement.addChild(obj);
        this.currentElement = obj;
        if (obj.parent instanceof SVG.TextRoot) {
            obj.setTextRoot((SVG.TextRoot) obj.parent);
        } else {
            obj.setTextRoot(((SVG.TextChild) obj.parent).getTextRoot());
        }
    }

    private void tref(Attributes attributes) throws SVGParseException {
        debug("<tref>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        if (!(this.currentElement instanceof SVG.TextContainer)) {
            throw new SVGParseException("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
        }
        SVG.TRef obj = new SVG.TRef();
        obj.document = this.svgDocument;
        obj.parent = this.currentElement;
        parseAttributesCore(obj, attributes);
        parseAttributesStyle(obj, attributes);
        parseAttributesConditional(obj, attributes);
        parseAttributesTRef(obj, attributes);
        this.currentElement.addChild(obj);
        if (obj.parent instanceof SVG.TextRoot) {
            obj.setTextRoot((SVG.TextRoot) obj.parent);
        } else {
            obj.setTextRoot(((SVG.TextChild) obj.parent).getTextRoot());
        }
    }

    private void parseAttributesTRef(SVG.TRef obj, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String val = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case href:
                    if ("".equals(attributes.getURI(i)) || XLINK_NAMESPACE.equals(attributes.getURI(i))) {
                        obj.href = val;
                    }
                    break;
            }
        }
    }

    private void zwitch(Attributes attributes) throws SVGParseException {
        debug("<switch>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Switch obj = new SVG.Switch();
        obj.document = this.svgDocument;
        obj.parent = this.currentElement;
        parseAttributesCore(obj, attributes);
        parseAttributesStyle(obj, attributes);
        parseAttributesTransform(obj, attributes);
        parseAttributesConditional(obj, attributes);
        this.currentElement.addChild(obj);
        this.currentElement = obj;
    }

    private void parseAttributesConditional(SVG.SvgConditional obj, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String val = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case requiredFeatures:
                    obj.setRequiredFeatures(parseRequiredFeatures(val));
                    break;
                case requiredExtensions:
                    obj.setRequiredExtensions(val);
                    break;
                case systemLanguage:
                    obj.setSystemLanguage(parseSystemLanguage(val));
                    break;
                case requiredFormats:
                    obj.setRequiredFormats(parseRequiredFormats(val));
                    break;
                case requiredFonts:
                    List<String> fonts = parseFontFamily(val);
                    obj.setRequiredFonts(fonts != null ? new HashSet(fonts) : new HashSet(0));
                    break;
            }
        }
    }

    private void symbol(Attributes attributes) throws SVGParseException {
        debug("<symbol>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Symbol obj = new SVG.Symbol();
        obj.document = this.svgDocument;
        obj.parent = this.currentElement;
        parseAttributesCore(obj, attributes);
        parseAttributesStyle(obj, attributes);
        parseAttributesConditional(obj, attributes);
        parseAttributesViewBox(obj, attributes);
        this.currentElement.addChild(obj);
        this.currentElement = obj;
    }

    private void marker(Attributes attributes) throws SVGParseException {
        debug("<marker>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Marker obj = new SVG.Marker();
        obj.document = this.svgDocument;
        obj.parent = this.currentElement;
        parseAttributesCore(obj, attributes);
        parseAttributesStyle(obj, attributes);
        parseAttributesConditional(obj, attributes);
        parseAttributesViewBox(obj, attributes);
        parseAttributesMarker(obj, attributes);
        this.currentElement.addChild(obj);
        this.currentElement = obj;
    }

    private void parseAttributesMarker(SVG.Marker obj, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String val = attributes.getValue(i).trim();
            switch (C26121.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()]) {
                case 26:
                    obj.refX = parseLength(val);
                    break;
                case 27:
                    obj.refY = parseLength(val);
                    break;
                case 28:
                    obj.markerWidth = parseLength(val);
                    if (obj.markerWidth.isNegative()) {
                        throw new SVGParseException("Invalid <marker> element. markerWidth cannot be negative");
                    }
                    break;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /* 29 */:
                    obj.markerHeight = parseLength(val);
                    if (obj.markerHeight.isNegative()) {
                        throw new SVGParseException("Invalid <marker> element. markerHeight cannot be negative");
                    }
                    break;
                    break;
                case 30:
                    if ("strokeWidth".equals(val)) {
                        obj.markerUnitsAreUser = false;
                    } else if ("userSpaceOnUse".equals(val)) {
                        obj.markerUnitsAreUser = true;
                    } else {
                        throw new SVGParseException("Invalid value for attribute markerUnits");
                    }
                    break;
                case 31:
                    if (DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(val)) {
                        obj.orient = Float.valueOf(Float.NaN);
                    } else {
                        obj.orient = Float.valueOf(parseFloat(val));
                    }
                    break;
            }
        }
    }

    private void linearGradient(Attributes attributes) throws SVGParseException {
        debug("<linearGradient>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.SvgLinearGradient obj = new SVG.SvgLinearGradient();
        obj.document = this.svgDocument;
        obj.parent = this.currentElement;
        parseAttributesCore(obj, attributes);
        parseAttributesStyle(obj, attributes);
        parseAttributesGradient(obj, attributes);
        parseAttributesLinearGradient(obj, attributes);
        this.currentElement.addChild(obj);
        this.currentElement = obj;
    }

    private void parseAttributesGradient(SVG.GradientElement obj, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String val = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case href:
                    if ("".equals(attributes.getURI(i)) || XLINK_NAMESPACE.equals(attributes.getURI(i))) {
                        obj.href = val;
                    }
                    break;
                case gradientUnits:
                    if ("objectBoundingBox".equals(val)) {
                        obj.gradientUnitsAreUser = false;
                    } else if ("userSpaceOnUse".equals(val)) {
                        obj.gradientUnitsAreUser = true;
                    } else {
                        throw new SVGParseException("Invalid value for attribute gradientUnits");
                    }
                    break;
                case gradientTransform:
                    obj.gradientTransform = parseTransformList(val);
                    break;
                case spreadMethod:
                    try {
                        obj.spreadMethod = SVG.GradientSpread.valueOf(val);
                    } catch (IllegalArgumentException e) {
                        throw new SVGParseException("Invalid spreadMethod attribute. \"" + val + "\" is not a valid value.");
                    }
                    break;
            }
        }
    }

    private void parseAttributesLinearGradient(SVG.SvgLinearGradient obj, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String val = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x1:
                    obj.f292x1 = parseLength(val);
                    break;
                case y1:
                    obj.f294y1 = parseLength(val);
                    break;
                case x2:
                    obj.f293x2 = parseLength(val);
                    break;
                case y2:
                    obj.f295y2 = parseLength(val);
                    break;
            }
        }
    }

    private void radialGradient(Attributes attributes) throws SVGParseException {
        debug("<radialGradient>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.SvgRadialGradient obj = new SVG.SvgRadialGradient();
        obj.document = this.svgDocument;
        obj.parent = this.currentElement;
        parseAttributesCore(obj, attributes);
        parseAttributesStyle(obj, attributes);
        parseAttributesGradient(obj, attributes);
        parseAttributesRadialGradient(obj, attributes);
        this.currentElement.addChild(obj);
        this.currentElement = obj;
    }

    private void parseAttributesRadialGradient(SVG.SvgRadialGradient obj, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String val = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case cx:
                    obj.f296cx = parseLength(val);
                    break;
                case cy:
                    obj.f297cy = parseLength(val);
                    break;
                case r:
                    obj.f300r = parseLength(val);
                    if (obj.f300r.isNegative()) {
                        throw new SVGParseException("Invalid <radialGradient> element. r cannot be negative");
                    }
                    break;
                    break;
                case fx:
                    obj.f298fx = parseLength(val);
                    break;
                case fy:
                    obj.f299fy = parseLength(val);
                    break;
            }
        }
    }

    private void stop(Attributes attributes) throws SVGParseException {
        debug("<stop>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        if (!(this.currentElement instanceof SVG.GradientElement)) {
            throw new SVGParseException("Invalid document. <stop> elements are only valid inside <linearGradient> or <radialGradient> elements.");
        }
        SVG.Stop obj = new SVG.Stop();
        obj.document = this.svgDocument;
        obj.parent = this.currentElement;
        parseAttributesCore(obj, attributes);
        parseAttributesStyle(obj, attributes);
        parseAttributesStop(obj, attributes);
        this.currentElement.addChild(obj);
        this.currentElement = obj;
    }

    private void parseAttributesStop(SVG.Stop obj, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String val = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case offset:
                    obj.offset = parseGradientOffset(val);
                    break;
            }
        }
    }

    private Float parseGradientOffset(String val) throws SVGParseException {
        if (val.length() == 0) {
            throw new SVGParseException("Invalid offset value in <stop> (empty string)");
        }
        int end = val.length();
        boolean isPercent = false;
        if (val.charAt(val.length() - 1) == '%') {
            end--;
            isPercent = true;
        }
        try {
            float scalar = parseFloat(val, 0, end);
            float f = 100.0f;
            if (isPercent) {
                scalar /= 100.0f;
            }
            if (scalar < 0.0f) {
                f = 0.0f;
            } else if (scalar <= 100.0f) {
                f = scalar;
            }
            return Float.valueOf(f);
        } catch (NumberFormatException e) {
            throw new SVGParseException("Invalid offset value in <stop>: " + val, e);
        }
    }

    private void solidColor(Attributes attributes) throws SVGParseException {
        debug("<solidColor>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.SolidColor obj = new SVG.SolidColor();
        obj.document = this.svgDocument;
        obj.parent = this.currentElement;
        parseAttributesCore(obj, attributes);
        parseAttributesStyle(obj, attributes);
        this.currentElement.addChild(obj);
        this.currentElement = obj;
    }

    private void clipPath(Attributes attributes) throws SVGParseException {
        debug("<clipPath>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.ClipPath obj = new SVG.ClipPath();
        obj.document = this.svgDocument;
        obj.parent = this.currentElement;
        parseAttributesCore(obj, attributes);
        parseAttributesStyle(obj, attributes);
        parseAttributesTransform(obj, attributes);
        parseAttributesConditional(obj, attributes);
        parseAttributesClipPath(obj, attributes);
        this.currentElement.addChild(obj);
        this.currentElement = obj;
    }

    private void parseAttributesClipPath(SVG.ClipPath obj, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String val = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case clipPathUnits:
                    if ("objectBoundingBox".equals(val)) {
                        obj.clipPathUnitsAreUser = false;
                    } else if ("userSpaceOnUse".equals(val)) {
                        obj.clipPathUnitsAreUser = true;
                    } else {
                        throw new SVGParseException("Invalid value for attribute clipPathUnits");
                    }
                    break;
            }
        }
    }

    private void textPath(Attributes attributes) throws SVGParseException {
        debug("<textPath>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.TextPath obj = new SVG.TextPath();
        obj.document = this.svgDocument;
        obj.parent = this.currentElement;
        parseAttributesCore(obj, attributes);
        parseAttributesStyle(obj, attributes);
        parseAttributesConditional(obj, attributes);
        parseAttributesTextPath(obj, attributes);
        this.currentElement.addChild(obj);
        this.currentElement = obj;
        if (obj.parent instanceof SVG.TextRoot) {
            obj.setTextRoot((SVG.TextRoot) obj.parent);
        } else {
            obj.setTextRoot(((SVG.TextChild) obj.parent).getTextRoot());
        }
    }

    private void parseAttributesTextPath(SVG.TextPath obj, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String val = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case href:
                    if ("".equals(attributes.getURI(i)) || XLINK_NAMESPACE.equals(attributes.getURI(i))) {
                        obj.href = val;
                    }
                    break;
                case startOffset:
                    obj.startOffset = parseLength(val);
                    break;
            }
        }
    }

    private void pattern(Attributes attributes) throws SVGParseException {
        debug("<pattern>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Pattern obj = new SVG.Pattern();
        obj.document = this.svgDocument;
        obj.parent = this.currentElement;
        parseAttributesCore(obj, attributes);
        parseAttributesStyle(obj, attributes);
        parseAttributesConditional(obj, attributes);
        parseAttributesViewBox(obj, attributes);
        parseAttributesPattern(obj, attributes);
        this.currentElement.addChild(obj);
        this.currentElement = obj;
    }

    private void parseAttributesPattern(SVG.Pattern obj, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String val = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    obj.f283x = parseLength(val);
                    break;
                case y:
                    obj.f284y = parseLength(val);
                    break;
                case width:
                    obj.width = parseLength(val);
                    if (obj.width.isNegative()) {
                        throw new SVGParseException("Invalid <pattern> element. width cannot be negative");
                    }
                    break;
                    break;
                case height:
                    obj.height = parseLength(val);
                    if (obj.height.isNegative()) {
                        throw new SVGParseException("Invalid <pattern> element. height cannot be negative");
                    }
                    break;
                    break;
                case href:
                    if ("".equals(attributes.getURI(i)) || XLINK_NAMESPACE.equals(attributes.getURI(i))) {
                        obj.href = val;
                    }
                    break;
                case patternUnits:
                    if ("objectBoundingBox".equals(val)) {
                        obj.patternUnitsAreUser = false;
                    } else if ("userSpaceOnUse".equals(val)) {
                        obj.patternUnitsAreUser = true;
                    } else {
                        throw new SVGParseException("Invalid value for attribute patternUnits");
                    }
                    break;
                case patternContentUnits:
                    if ("objectBoundingBox".equals(val)) {
                        obj.patternContentUnitsAreUser = false;
                    } else if ("userSpaceOnUse".equals(val)) {
                        obj.patternContentUnitsAreUser = true;
                    } else {
                        throw new SVGParseException("Invalid value for attribute patternContentUnits");
                    }
                    break;
                case patternTransform:
                    obj.patternTransform = parseTransformList(val);
                    break;
            }
        }
    }

    private void view(Attributes attributes) throws SVGParseException {
        debug("<view>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.View obj = new SVG.View();
        obj.document = this.svgDocument;
        obj.parent = this.currentElement;
        parseAttributesCore(obj, attributes);
        parseAttributesConditional(obj, attributes);
        parseAttributesViewBox(obj, attributes);
        this.currentElement.addChild(obj);
        this.currentElement = obj;
    }

    private void mask(Attributes attributes) throws SVGParseException {
        debug("<mask>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Mask obj = new SVG.Mask();
        obj.document = this.svgDocument;
        obj.parent = this.currentElement;
        parseAttributesCore(obj, attributes);
        parseAttributesStyle(obj, attributes);
        parseAttributesConditional(obj, attributes);
        parseAttributesMask(obj, attributes);
        this.currentElement.addChild(obj);
        this.currentElement = obj;
    }

    private void parseAttributesMask(SVG.Mask obj, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String val = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    obj.f280x = parseLength(val);
                    break;
                case y:
                    obj.f281y = parseLength(val);
                    break;
                case width:
                    obj.width = parseLength(val);
                    if (obj.width.isNegative()) {
                        throw new SVGParseException("Invalid <mask> element. width cannot be negative");
                    }
                    break;
                    break;
                case height:
                    obj.height = parseLength(val);
                    if (obj.height.isNegative()) {
                        throw new SVGParseException("Invalid <mask> element. height cannot be negative");
                    }
                    break;
                    break;
                case maskUnits:
                    if ("objectBoundingBox".equals(val)) {
                        obj.maskUnitsAreUser = false;
                    } else if ("userSpaceOnUse".equals(val)) {
                        obj.maskUnitsAreUser = true;
                    } else {
                        throw new SVGParseException("Invalid value for attribute maskUnits");
                    }
                    break;
                case maskContentUnits:
                    if ("objectBoundingBox".equals(val)) {
                        obj.maskContentUnitsAreUser = false;
                    } else if ("userSpaceOnUse".equals(val)) {
                        obj.maskContentUnitsAreUser = true;
                    } else {
                        throw new SVGParseException("Invalid value for attribute maskContentUnits");
                    }
                    break;
            }
        }
    }

    static class TextScanner {
        String input;
        int inputLength;
        int position = 0;
        private NumberParser numberParser = new NumberParser();

        TextScanner(String input) {
            this.inputLength = 0;
            this.input = input.trim();
            this.inputLength = this.input.length();
        }

        boolean empty() {
            return this.position == this.inputLength;
        }

        boolean isWhitespace(int c) {
            return c == 32 || c == 10 || c == 13 || c == 9;
        }

        void skipWhitespace() {
            while (this.position < this.inputLength && isWhitespace(this.input.charAt(this.position))) {
                this.position++;
            }
        }

        boolean isEOL(int c) {
            return c == 10 || c == 13;
        }

        boolean skipCommaWhitespace() {
            skipWhitespace();
            if (this.position == this.inputLength || this.input.charAt(this.position) != ',') {
                return false;
            }
            this.position++;
            skipWhitespace();
            return true;
        }

        float nextFloat() {
            float val = this.numberParser.parseNumber(this.input, this.position, this.inputLength);
            if (!Float.isNaN(val)) {
                this.position = this.numberParser.getEndPos();
            }
            return val;
        }

        float possibleNextFloat() {
            skipCommaWhitespace();
            float val = this.numberParser.parseNumber(this.input, this.position, this.inputLength);
            if (!Float.isNaN(val)) {
                this.position = this.numberParser.getEndPos();
            }
            return val;
        }

        float checkedNextFloat(float lastRead) {
            if (Float.isNaN(lastRead)) {
                return Float.NaN;
            }
            skipCommaWhitespace();
            return nextFloat();
        }

        float checkedNextFloat(Boolean lastRead) {
            if (lastRead == null) {
                return Float.NaN;
            }
            skipCommaWhitespace();
            return nextFloat();
        }

        Integer nextChar() {
            if (this.position == this.inputLength) {
                return null;
            }
            String str = this.input;
            int i = this.position;
            this.position = i + 1;
            return Integer.valueOf(str.charAt(i));
        }

        SVG.Length nextLength() {
            float scalar = nextFloat();
            if (Float.isNaN(scalar)) {
                return null;
            }
            SVG.Unit unit = nextUnit();
            if (unit == null) {
                return new SVG.Length(scalar, SVG.Unit.px);
            }
            return new SVG.Length(scalar, unit);
        }

        Boolean nextFlag() {
            if (this.position == this.inputLength) {
                return null;
            }
            char ch = this.input.charAt(this.position);
            if (ch != '0' && ch != '1') {
                return null;
            }
            this.position++;
            return Boolean.valueOf(ch == '1');
        }

        Boolean checkedNextFlag(Object lastRead) {
            if (lastRead == null) {
                return null;
            }
            skipCommaWhitespace();
            return nextFlag();
        }

        boolean consume(char ch) {
            boolean found = this.position < this.inputLength && this.input.charAt(this.position) == ch;
            if (found) {
                this.position++;
            }
            return found;
        }

        boolean consume(String str) {
            int len = str.length();
            boolean found = this.position <= this.inputLength - len && this.input.substring(this.position, this.position + len).equals(str);
            if (found) {
                this.position += len;
            }
            return found;
        }

        int advanceChar() {
            if (this.position == this.inputLength) {
                return -1;
            }
            this.position++;
            if (this.position < this.inputLength) {
                return this.input.charAt(this.position);
            }
            return -1;
        }

        String nextToken() {
            return nextToken(' ', false);
        }

        String nextToken(char terminator) {
            return nextToken(terminator, false);
        }

        String nextTokenWithWhitespace(char terminator) {
            return nextToken(terminator, true);
        }

        String nextToken(char terminator, boolean allowWhitespace) {
            if (empty()) {
                return null;
            }
            int ch = this.input.charAt(this.position);
            if ((!allowWhitespace && isWhitespace(ch)) || ch == terminator) {
                return null;
            }
            int start = this.position;
            int ch2 = advanceChar();
            while (ch2 != -1 && ch2 != terminator && (allowWhitespace || !isWhitespace(ch2))) {
                ch2 = advanceChar();
            }
            return this.input.substring(start, this.position);
        }

        String nextWord() {
            if (empty()) {
                return null;
            }
            int start = this.position;
            int ch = this.input.charAt(this.position);
            if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) {
                int ch2 = advanceChar();
                while (true) {
                    if ((ch2 < 65 || ch2 > 90) && (ch2 < 97 || ch2 > 122)) {
                        break;
                    }
                    ch2 = advanceChar();
                }
                return this.input.substring(start, this.position);
            }
            this.position = start;
            return null;
        }

        String nextFunction() {
            if (empty()) {
                return null;
            }
            int start = this.position;
            int ch = this.input.charAt(this.position);
            while (true) {
                if ((ch < 97 || ch > 122) && (ch < 65 || ch > 90)) {
                    break;
                }
                ch = advanceChar();
            }
            int end = this.position;
            while (isWhitespace(ch)) {
                ch = advanceChar();
            }
            if (ch == 40) {
                this.position++;
                return this.input.substring(start, end);
            }
            this.position = start;
            return null;
        }

        String ahead() {
            int start = this.position;
            while (!empty() && !isWhitespace(this.input.charAt(this.position))) {
                this.position++;
            }
            String str = this.input.substring(start, this.position);
            this.position = start;
            return str;
        }

        SVG.Unit nextUnit() {
            if (empty()) {
                return null;
            }
            int ch = this.input.charAt(this.position);
            if (ch == 37) {
                this.position++;
                return SVG.Unit.percent;
            }
            if (this.position > this.inputLength - 2) {
                return null;
            }
            try {
                SVG.Unit result = SVG.Unit.valueOf(this.input.substring(this.position, this.position + 2).toLowerCase(Locale.US));
                this.position += 2;
                return result;
            } catch (IllegalArgumentException e) {
                return null;
            }
        }

        boolean hasLetter() {
            if (this.position == this.inputLength) {
                return false;
            }
            char ch = this.input.charAt(this.position);
            return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
        }

        String nextQuotedString() {
            if (empty()) {
                return null;
            }
            int start = this.position;
            int ch = this.input.charAt(this.position);
            if (ch != 39 && ch != 34) {
                return null;
            }
            int ch2 = advanceChar();
            while (ch2 != -1 && ch2 != ch) {
                ch2 = advanceChar();
            }
            if (ch2 == -1) {
                this.position = start;
                return null;
            }
            this.position++;
            return this.input.substring(start + 1, this.position - 1);
        }

        String restOfText() {
            if (empty()) {
                return null;
            }
            int start = this.position;
            this.position = this.inputLength;
            return this.input.substring(start);
        }
    }

    private void parseAttributesCore(SVG.SvgElementBase obj, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String qname = attributes.getQName(i);
            if (qname.equals("id") || qname.equals("xml:id")) {
                obj.f291id = attributes.getValue(i).trim();
                return;
            }
            if (qname.equals("xml:space")) {
                String val = attributes.getValue(i).trim();
                if ("default".equals(val)) {
                    obj.spacePreserve = Boolean.FALSE;
                    return;
                } else {
                    if ("preserve".equals(val)) {
                        obj.spacePreserve = Boolean.TRUE;
                        return;
                    }
                    throw new SVGParseException("Invalid value for \"xml:space\" attribute: " + val);
                }
            }
        }
    }

    private void parseAttributesStyle(SVG.SvgElementBase obj, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String val = attributes.getValue(i).trim();
            if (val.length() != 0) {
                switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                    case style:
                        parseStyle(obj, val);
                        break;
                    case CLASS:
                        obj.classNames = CSSParser.parseClassAttribute(val);
                        break;
                    default:
                        if (obj.baseStyle == null) {
                            obj.baseStyle = new SVG.Style();
                        }
                        processStyleProperty(obj.baseStyle, attributes.getLocalName(i), attributes.getValue(i).trim());
                        break;
                }
            }
        }
    }

    private static void parseStyle(SVG.SvgElementBase obj, String style) {
        TextScanner scan = new TextScanner(style.replaceAll("/\\*.*?\\*/", ""));
        while (true) {
            String propertyName = scan.nextToken(AbstractJsonLexerKt.COLON);
            scan.skipWhitespace();
            if (scan.consume(AbstractJsonLexerKt.COLON)) {
                scan.skipWhitespace();
                String propertyValue = scan.nextTokenWithWhitespace(';');
                if (propertyValue != null) {
                    scan.skipWhitespace();
                    if (scan.empty() || scan.consume(';')) {
                        if (obj.style == null) {
                            obj.style = new SVG.Style();
                        }
                        processStyleProperty(obj.style, propertyName, propertyValue);
                        scan.skipWhitespace();
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    static void processStyleProperty(SVG.Style style, String localName, String val) {
        if (val.length() == 0 || val.equals("inherit")) {
            return;
        }
        switch (C26121.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(localName).ordinal()]) {
            case 47:
                style.fill = parsePaintSpecifier(val);
                if (style.fill != null) {
                    style.specifiedFlags |= 1;
                }
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                style.fillRule = parseFillRule(val);
                if (style.fillRule != null) {
                    style.specifiedFlags |= 2;
                }
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                style.fillOpacity = parseOpacity(val);
                if (style.fillOpacity != null) {
                    style.specifiedFlags |= 4;
                }
                break;
            case 50:
                style.stroke = parsePaintSpecifier(val);
                if (style.stroke != null) {
                    style.specifiedFlags |= 8;
                }
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                style.strokeOpacity = parseOpacity(val);
                if (style.strokeOpacity != null) {
                    style.specifiedFlags |= 16;
                }
                break;
            case 52:
                try {
                    style.strokeWidth = parseLength(val);
                    style.specifiedFlags |= 32;
                } catch (SVGParseException e) {
                    return;
                }
                break;
            case 53:
                style.strokeLineCap = parseStrokeLineCap(val);
                if (style.strokeLineCap != null) {
                    style.specifiedFlags |= 64;
                }
                break;
            case 54:
                style.strokeLineJoin = parseStrokeLineJoin(val);
                if (style.strokeLineJoin != null) {
                    style.specifiedFlags |= 128;
                }
                break;
            case 55:
                try {
                    style.strokeMiterLimit = Float.valueOf(parseFloat(val));
                    style.specifiedFlags |= 256;
                } catch (SVGParseException e2) {
                    return;
                }
                break;
            case 56:
                if (NONE.equals(val)) {
                    style.strokeDashArray = null;
                    style.specifiedFlags |= 512;
                } else {
                    style.strokeDashArray = parseStrokeDashArray(val);
                    if (style.strokeDashArray != null) {
                        style.specifiedFlags |= 512;
                    }
                }
                break;
            case 57:
                try {
                    style.strokeDashOffset = parseLength(val);
                    style.specifiedFlags |= 1024;
                } catch (SVGParseException e3) {
                    return;
                }
                break;
            case 58:
                style.opacity = parseOpacity(val);
                style.specifiedFlags |= 2048;
                break;
            case 59:
                try {
                    style.color = parseColour(val);
                    style.specifiedFlags |= 4096;
                } catch (SVGParseException e4) {
                    return;
                }
                break;
            case 60:
                parseFont(style, val);
                break;
            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                style.fontFamily = parseFontFamily(val);
                if (style.fontFamily != null) {
                    style.specifiedFlags |= 8192;
                }
                break;
            case 62:
                style.fontSize = parseFontSize(val);
                if (style.fontSize != null) {
                    style.specifiedFlags |= Http2Stream.EMIT_BUFFER_SIZE;
                }
                break;
            case 63:
                style.fontWeight = parseFontWeight(val);
                if (style.fontWeight != null) {
                    style.specifiedFlags |= 32768;
                }
                break;
            case 64:
                style.fontStyle = parseFontStyle(val);
                if (style.fontStyle != null) {
                    style.specifiedFlags |= 65536;
                }
                break;
            case 65:
                style.textDecoration = parseTextDecoration(val);
                if (style.textDecoration != null) {
                    style.specifiedFlags |= 131072;
                }
                break;
            case 66:
                style.direction = parseTextDirection(val);
                if (style.direction != null) {
                    style.specifiedFlags |= 68719476736L;
                }
                break;
            case 67:
                style.textAnchor = parseTextAnchor(val);
                if (style.textAnchor != null) {
                    style.specifiedFlags |= 262144;
                }
                break;
            case 68:
                style.overflow = parseOverflow(val);
                if (style.overflow != null) {
                    style.specifiedFlags |= 524288;
                }
                break;
            case 69:
                style.markerStart = parseFunctionalIRI(val, localName);
                style.markerMid = style.markerStart;
                style.markerEnd = style.markerStart;
                style.specifiedFlags |= 14680064;
                break;
            case 70:
                style.markerStart = parseFunctionalIRI(val, localName);
                style.specifiedFlags |= 2097152;
                break;
            case 71:
                style.markerMid = parseFunctionalIRI(val, localName);
                style.specifiedFlags |= 4194304;
                break;
            case 72:
                style.markerEnd = parseFunctionalIRI(val, localName);
                style.specifiedFlags |= 8388608;
                break;
            case 73:
                if (val.indexOf(124) < 0 && VALID_DISPLAY_VALUES.contains('|' + val + '|')) {
                    style.display = Boolean.valueOf(!val.equals(NONE));
                    style.specifiedFlags |= 16777216;
                    break;
                }
                break;
            case 74:
                if (val.indexOf(124) < 0 && VALID_VISIBILITY_VALUES.contains('|' + val + '|')) {
                    style.visibility = Boolean.valueOf(val.equals("visible"));
                    style.specifiedFlags |= 33554432;
                    break;
                }
                break;
            case 75:
                if (val.equals(CURRENTCOLOR)) {
                    style.stopColor = SVG.CurrentColor.getInstance();
                } else {
                    try {
                        style.stopColor = parseColour(val);
                    } catch (SVGParseException e5) {
                        Log.w(TAG, e5.getMessage());
                        return;
                    }
                }
                style.specifiedFlags |= 67108864;
                break;
            case Base64.mimeLineLength /* 76 */:
                style.stopOpacity = parseOpacity(val);
                style.specifiedFlags |= 134217728;
                break;
            case 77:
                style.clip = parseClip(val);
                if (style.clip != null) {
                    style.specifiedFlags |= FileUtils.ONE_MB;
                }
                break;
            case 78:
                style.clipPath = parseFunctionalIRI(val, localName);
                style.specifiedFlags |= 268435456;
                break;
            case 79:
                style.clipRule = parseFillRule(val);
                style.specifiedFlags |= 536870912;
                break;
            case 80:
                style.mask = parseFunctionalIRI(val, localName);
                style.specifiedFlags |= FileUtils.ONE_GB;
                break;
            case 81:
                if (val.equals(CURRENTCOLOR)) {
                    style.solidColor = SVG.CurrentColor.getInstance();
                } else {
                    try {
                        style.solidColor = parseColour(val);
                    } catch (SVGParseException e6) {
                        Log.w(TAG, e6.getMessage());
                        return;
                    }
                }
                style.specifiedFlags |= 2147483648L;
                break;
            case 82:
                style.solidOpacity = parseOpacity(val);
                style.specifiedFlags |= 4294967296L;
                break;
            case 83:
                if (val.equals(CURRENTCOLOR)) {
                    style.viewportFill = SVG.CurrentColor.getInstance();
                } else {
                    try {
                        style.viewportFill = parseColour(val);
                    } catch (SVGParseException e7) {
                        Log.w(TAG, e7.getMessage());
                        return;
                    }
                }
                style.specifiedFlags |= 8589934592L;
                break;
            case 84:
                style.viewportFillOpacity = parseOpacity(val);
                style.specifiedFlags |= 17179869184L;
                break;
            case 85:
                style.vectorEffect = parseVectorEffect(val);
                if (style.vectorEffect != null) {
                    style.specifiedFlags |= 34359738368L;
                }
                break;
            case 86:
                style.imageRendering = parseRenderQuality(val);
                if (style.imageRendering != null) {
                    style.specifiedFlags |= 137438953472L;
                }
                break;
        }
    }

    private void parseAttributesViewBox(SVG.SvgViewBoxContainer obj, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String val = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case preserveAspectRatio:
                    parsePreserveAspectRatio(obj, val);
                    break;
                case viewBox:
                    obj.viewBox = parseViewBox(val);
                    break;
            }
        }
    }

    private void parseAttributesTransform(SVG.HasTransform obj, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (SVGAttr.fromString(attributes.getLocalName(i)) == SVGAttr.transform) {
                obj.setTransform(parseTransformList(attributes.getValue(i)));
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:28:0x006b  */
    private Matrix parseTransformList(String val) throws SVGParseException {
        Matrix matrix = new Matrix();
        TextScanner scan = new TextScanner(val);
        scan.skipWhitespace();
        while (!scan.empty()) {
            String cmd = scan.nextFunction();
            if (cmd == null) {
                throw new SVGParseException("Bad transform function encountered in transform list: " + val);
            }
            switch (cmd) {
                case "matrix":
                    scan.skipWhitespace();
                    float a = scan.nextFloat();
                    scan.skipCommaWhitespace();
                    float b = scan.nextFloat();
                    scan.skipCommaWhitespace();
                    float c = scan.nextFloat();
                    scan.skipCommaWhitespace();
                    float d = scan.nextFloat();
                    scan.skipCommaWhitespace();
                    float e = scan.nextFloat();
                    scan.skipCommaWhitespace();
                    float f = scan.nextFloat();
                    scan.skipWhitespace();
                    if (Float.isNaN(f) || !scan.consume(')')) {
                        throw new SVGParseException("Invalid transform list: " + val);
                    }
                    Matrix m = new Matrix();
                    m.setValues(new float[]{a, c, e, b, d, f, 0.0f, 0.0f, 1.0f});
                    matrix.preConcat(m);
                    break;
                    break;
                case "translate":
                    scan.skipWhitespace();
                    float tx = scan.nextFloat();
                    float ty = scan.possibleNextFloat();
                    scan.skipWhitespace();
                    if (Float.isNaN(tx) || !scan.consume(')')) {
                        throw new SVGParseException("Invalid transform list: " + val);
                    }
                    if (Float.isNaN(ty)) {
                        matrix.preTranslate(tx, 0.0f);
                    } else {
                        matrix.preTranslate(tx, ty);
                    }
                    break;
                    break;
                case "scale":
                    scan.skipWhitespace();
                    float sx = scan.nextFloat();
                    float sy = scan.possibleNextFloat();
                    scan.skipWhitespace();
                    if (Float.isNaN(sx) || !scan.consume(')')) {
                        throw new SVGParseException("Invalid transform list: " + val);
                    }
                    if (Float.isNaN(sy)) {
                        matrix.preScale(sx, sx);
                    } else {
                        matrix.preScale(sx, sy);
                    }
                    break;
                    break;
                case "rotate":
                    scan.skipWhitespace();
                    float ang = scan.nextFloat();
                    float cx = scan.possibleNextFloat();
                    float cy = scan.possibleNextFloat();
                    scan.skipWhitespace();
                    if (Float.isNaN(ang) || !scan.consume(')')) {
                        throw new SVGParseException("Invalid transform list: " + val);
                    }
                    if (Float.isNaN(cx)) {
                        matrix.preRotate(ang);
                    } else if (!Float.isNaN(cy)) {
                        matrix.preRotate(ang, cx, cy);
                    } else {
                        throw new SVGParseException("Invalid transform list: " + val);
                    }
                    break;
                    break;
                case "skewX":
                    scan.skipWhitespace();
                    float ang2 = scan.nextFloat();
                    scan.skipWhitespace();
                    if (Float.isNaN(ang2) || !scan.consume(')')) {
                        throw new SVGParseException("Invalid transform list: " + val);
                    }
                    matrix.preSkew((float) Math.tan(Math.toRadians(ang2)), 0.0f);
                    break;
                    break;
                case "skewY":
                    scan.skipWhitespace();
                    float ang3 = scan.nextFloat();
                    scan.skipWhitespace();
                    if (Float.isNaN(ang3) || !scan.consume(')')) {
                        throw new SVGParseException("Invalid transform list: " + val);
                    }
                    matrix.preSkew(0.0f, (float) Math.tan(Math.toRadians(ang3)));
                    break;
                    break;
                default:
                    throw new SVGParseException("Invalid transform list fn: " + cmd + ")");
            }
            if (!scan.empty()) {
                scan.skipCommaWhitespace();
            } else {
                return matrix;
            }
        }
        return matrix;
    }

    static SVG.Length parseLength(String val) throws SVGParseException {
        if (val.length() == 0) {
            throw new SVGParseException("Invalid length value (empty string)");
        }
        int end = val.length();
        SVG.Unit unit = SVG.Unit.px;
        char lastChar = val.charAt(end - 1);
        if (lastChar == '%') {
            end--;
            unit = SVG.Unit.percent;
        } else if (end > 2 && Character.isLetter(lastChar) && Character.isLetter(val.charAt(end - 2))) {
            end -= 2;
            String unitStr = val.substring(end);
            try {
                unit = SVG.Unit.valueOf(unitStr.toLowerCase(Locale.US));
            } catch (IllegalArgumentException e) {
                throw new SVGParseException("Invalid length unit specifier: " + val);
            }
        }
        try {
            float scalar = parseFloat(val, 0, end);
            return new SVG.Length(scalar, unit);
        } catch (NumberFormatException e2) {
            throw new SVGParseException("Invalid length value: " + val, e2);
        }
    }

    private static List<SVG.Length> parseLengthList(String val) throws SVGParseException {
        if (val.length() == 0) {
            throw new SVGParseException("Invalid length list (empty string)");
        }
        List<SVG.Length> coords = new ArrayList<>(1);
        TextScanner scan = new TextScanner(val);
        scan.skipWhitespace();
        while (!scan.empty()) {
            float scalar = scan.nextFloat();
            if (Float.isNaN(scalar)) {
                throw new SVGParseException("Invalid length list value: " + scan.ahead());
            }
            SVG.Unit unit = scan.nextUnit();
            if (unit == null) {
                unit = SVG.Unit.px;
            }
            coords.add(new SVG.Length(scalar, unit));
            scan.skipCommaWhitespace();
        }
        return coords;
    }

    private static float parseFloat(String val) throws SVGParseException {
        int len = val.length();
        if (len == 0) {
            throw new SVGParseException("Invalid float value (empty string)");
        }
        return parseFloat(val, 0, len);
    }

    private static float parseFloat(String val, int offset, int len) throws SVGParseException {
        NumberParser np = new NumberParser();
        float num = np.parseNumber(val, offset, len);
        if (!Float.isNaN(num)) {
            return num;
        }
        throw new SVGParseException("Invalid float value: " + val);
    }

    private static Float parseOpacity(String val) {
        try {
            float o = parseFloat(val);
            float f = 0.0f;
            if (o >= 0.0f) {
                f = 1.0f;
                if (o <= 1.0f) {
                    f = o;
                }
            }
            return Float.valueOf(f);
        } catch (SVGParseException e) {
            return null;
        }
    }

    private static SVG.Box parseViewBox(String val) throws SVGParseException {
        TextScanner scan = new TextScanner(val);
        scan.skipWhitespace();
        float minX = scan.nextFloat();
        scan.skipCommaWhitespace();
        float minY = scan.nextFloat();
        scan.skipCommaWhitespace();
        float width = scan.nextFloat();
        scan.skipCommaWhitespace();
        float height = scan.nextFloat();
        if (Float.isNaN(minX) || Float.isNaN(minY) || Float.isNaN(width) || Float.isNaN(height)) {
            throw new SVGParseException("Invalid viewBox definition - should have four numbers");
        }
        if (width < 0.0f) {
            throw new SVGParseException("Invalid viewBox. width cannot be negative");
        }
        if (height < 0.0f) {
            throw new SVGParseException("Invalid viewBox. height cannot be negative");
        }
        return new SVG.Box(minX, minY, width, height);
    }

    private static void parsePreserveAspectRatio(SVG.SvgPreserveAspectRatioContainer obj, String val) throws SVGParseException {
        obj.preserveAspectRatio = parsePreserveAspectRatio(val);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:16:0x004c  */
    static PreserveAspectRatio parsePreserveAspectRatio(String val) throws SVGParseException {
        TextScanner scan = new TextScanner(val);
        scan.skipWhitespace();
        String word = scan.nextToken();
        if ("defer".equals(word)) {
            scan.skipWhitespace();
            word = scan.nextToken();
        }
        PreserveAspectRatio.Alignment align = AspectRatioKeywords.get(word);
        PreserveAspectRatio.Scale scale = null;
        scan.skipWhitespace();
        if (!scan.empty()) {
            String meetOrSlice = scan.nextToken();
            switch (meetOrSlice) {
                case "meet":
                    scale = PreserveAspectRatio.Scale.meet;
                    break;
                case "slice":
                    scale = PreserveAspectRatio.Scale.slice;
                    break;
                default:
                    throw new SVGParseException("Invalid preserveAspectRatio definition: " + val);
            }
        }
        return new PreserveAspectRatio(align, scale);
    }

    private static SVG.SvgPaint parsePaintSpecifier(String val) {
        if (val.startsWith("url(")) {
            int closeBracket = val.indexOf(")");
            if (closeBracket != -1) {
                String href = val.substring(4, closeBracket).trim();
                SVG.SvgPaint fallback = null;
                String val2 = val.substring(closeBracket + 1).trim();
                if (val2.length() > 0) {
                    fallback = parseColourSpecifer(val2);
                }
                return new SVG.PaintReference(href, fallback);
            }
            String href2 = val.substring(4);
            return new SVG.PaintReference(href2.trim(), null);
        }
        return parseColourSpecifer(val);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x001e  */
    private static SVG.SvgPaint parseColourSpecifer(String val) {
        switch (val) {
            case "none":
                return SVG.Colour.TRANSPARENT;
            case "currentColor":
                return SVG.CurrentColor.getInstance();
            default:
                try {
                    return parseColour(val);
                } catch (SVGParseException e) {
                    return null;
                }
        }
    }

    private static SVG.Colour parseColour(String val) throws SVGParseException {
        if (val.charAt(0) == '#') {
            IntegerParser ip = IntegerParser.parseHex(val, 1, val.length());
            if (ip == null) {
                throw new SVGParseException("Bad hex colour value: " + val);
            }
            int pos = ip.getEndPos();
            switch (pos) {
                case 4:
                    int threehex = ip.value();
                    int h1 = threehex & 3840;
                    int h2 = threehex & 240;
                    int h3 = threehex & 15;
                    return new SVG.Colour((-16777216) | (h1 << 12) | (h1 << 8) | (h2 << 8) | (h2 << 4) | (h3 << 4) | h3);
                case 5:
                    int fourhex = ip.value();
                    int h4 = 61440 & fourhex;
                    int h5 = fourhex & 3840;
                    int h6 = fourhex & 240;
                    int h7 = fourhex & 15;
                    return new SVG.Colour((h7 << 28) | (h7 << 24) | (h4 << 8) | (h4 << 4) | (h5 << 4) | h5 | h6 | (h6 >> 4));
                case 6:
                case 8:
                default:
                    throw new SVGParseException("Bad hex colour value: " + val);
                case 7:
                    return new SVG.Colour((-16777216) | ip.value());
                case 9:
                    return new SVG.Colour((ip.value() << 24) | (ip.value() >>> 8));
            }
        }
        String valLowerCase = val.toLowerCase(Locale.US);
        boolean isRGBA = valLowerCase.startsWith("rgba(");
        if (isRGBA || valLowerCase.startsWith("rgb(")) {
            TextScanner scan = new TextScanner(val.substring(isRGBA ? 5 : 4));
            scan.skipWhitespace();
            float red = scan.nextFloat();
            if (!Float.isNaN(red) && scan.consume('%')) {
                red = (red * 256.0f) / 100.0f;
            }
            float green = scan.checkedNextFloat(red);
            if (!Float.isNaN(green) && scan.consume('%')) {
                green = (green * 256.0f) / 100.0f;
            }
            float blue = scan.checkedNextFloat(green);
            if (!Float.isNaN(blue) && scan.consume('%')) {
                blue = (blue * 256.0f) / 100.0f;
            }
            if (isRGBA) {
                float alpha = scan.checkedNextFloat(blue);
                scan.skipWhitespace();
                if (Float.isNaN(alpha) || !scan.consume(')')) {
                    throw new SVGParseException("Bad rgba() colour value: " + val);
                }
                return new SVG.Colour((clamp255(256.0f * alpha) << 24) | (clamp255(red) << 16) | (clamp255(green) << 8) | clamp255(blue));
            }
            scan.skipWhitespace();
            if (Float.isNaN(blue) || !scan.consume(')')) {
                throw new SVGParseException("Bad rgb() colour value: " + val);
            }
            return new SVG.Colour((-16777216) | (clamp255(red) << 16) | (clamp255(green) << 8) | clamp255(blue));
        }
        boolean isHSLA = valLowerCase.startsWith("hsla(");
        if (isHSLA || valLowerCase.startsWith("hsl(")) {
            TextScanner scan2 = new TextScanner(val.substring(isHSLA ? 5 : 4));
            scan2.skipWhitespace();
            float hue = scan2.nextFloat();
            float saturation = scan2.checkedNextFloat(hue);
            if (!Float.isNaN(saturation)) {
                scan2.consume('%');
            }
            float lightness = scan2.checkedNextFloat(saturation);
            if (!Float.isNaN(lightness)) {
                scan2.consume('%');
            }
            if (isHSLA) {
                float alpha2 = scan2.checkedNextFloat(lightness);
                scan2.skipWhitespace();
                if (Float.isNaN(alpha2) || !scan2.consume(')')) {
                    throw new SVGParseException("Bad hsla() colour value: " + val);
                }
                return new SVG.Colour((clamp255(256.0f * alpha2) << 24) | hslToRgb(hue, saturation, lightness));
            }
            scan2.skipWhitespace();
            if (Float.isNaN(lightness) || !scan2.consume(')')) {
                throw new SVGParseException("Bad hsl() colour value: " + val);
            }
            return new SVG.Colour((-16777216) | hslToRgb(hue, saturation, lightness));
        }
        return parseColourKeyword(valLowerCase);
    }

    private static int clamp255(float val) {
        if (val < 0.0f) {
            return 0;
        }
        if (val > 255.0f) {
            return 255;
        }
        return Math.round(val);
    }

    private static int hslToRgb(float hue, float sat, float light) {
        float f;
        float t2;
        float f2 = 0.0f;
        float hue2 = (hue >= 0.0f ? hue % 360.0f : 360.0f + (hue % 360.0f)) / 60.0f;
        float sat2 = sat / 100.0f;
        float light2 = light / 100.0f;
        if (sat2 < 0.0f) {
            f = 0.0f;
        } else {
            f = sat2 > 1.0f ? 1.0f : sat2;
        }
        float sat3 = f;
        if (light2 >= 0.0f) {
            f2 = light2 > 1.0f ? 1.0f : light2;
        }
        float light3 = f2;
        if (light3 <= 0.5f) {
            t2 = (1.0f + sat3) * light3;
        } else {
            float t3 = light3 + sat3;
            t2 = t3 - (light3 * sat3);
        }
        float t1 = (light3 * 2.0f) - t2;
        float r = hueToRgb(t1, t2, hue2 + 2.0f);
        float g = hueToRgb(t1, t2, hue2);
        float b = hueToRgb(t1, t2, hue2 - 2.0f);
        return clamp255(256.0f * b) | (clamp255(r * 256.0f) << 16) | (clamp255(g * 256.0f) << 8);
    }

    private static float hueToRgb(float t1, float t2, float hue) {
        if (hue < 0.0f) {
            hue += 6.0f;
        }
        if (hue >= 6.0f) {
            hue -= 6.0f;
        }
        if (hue < 1.0f) {
            return ((t2 - t1) * hue) + t1;
        }
        if (hue < 3.0f) {
            return t2;
        }
        if (hue < 4.0f) {
            return ((t2 - t1) * (4.0f - hue)) + t1;
        }
        return t1;
    }

    private static SVG.Colour parseColourKeyword(String nameLowerCase) throws SVGParseException {
        Integer col = ColourKeywords.get(nameLowerCase);
        if (col == null) {
            throw new SVGParseException("Invalid colour keyword: " + nameLowerCase);
        }
        return new SVG.Colour(col.intValue());
    }

    private static void parseFont(SVG.Style style, String val) {
        String item;
        Integer fontWeight = null;
        SVG.Style.FontStyle fontStyle = null;
        String fontVariant = null;
        if (!"|caption|icon|menu|message-box|small-caption|status-bar|".contains('|' + val + '|')) {
            return;
        }
        TextScanner scan = new TextScanner(val);
        while (true) {
            item = scan.nextToken('/');
            scan.skipWhitespace();
            if (item == null) {
                return;
            }
            if (fontWeight != null && fontStyle != null) {
                break;
            }
            if (!item.equals("normal") && (fontWeight != null || (fontWeight = FontWeightKeywords.get(item)) == null)) {
                if (fontStyle != null || (fontStyle = parseFontStyle(item)) == null) {
                    if (fontVariant != null || !item.equals("small-caps")) {
                        break;
                    } else {
                        fontVariant = item;
                    }
                }
            }
        }
        SVG.Length fontSize = parseFontSize(item);
        if (scan.consume('/')) {
            scan.skipWhitespace();
            String item2 = scan.nextToken();
            if (item2 != null) {
                try {
                    parseLength(item2);
                } catch (SVGParseException e) {
                    return;
                }
            }
            scan.skipWhitespace();
        }
        style.fontFamily = parseFontFamily(scan.restOfText());
        style.fontSize = fontSize;
        style.fontWeight = Integer.valueOf(fontWeight == null ? 400 : fontWeight.intValue());
        style.fontStyle = fontStyle == null ? SVG.Style.FontStyle.Normal : fontStyle;
        style.specifiedFlags |= 122880;
    }

    private static List<String> parseFontFamily(String val) {
        List<String> fonts = null;
        TextScanner scan = new TextScanner(val);
        do {
            String item = scan.nextQuotedString();
            if (item == null) {
                item = scan.nextTokenWithWhitespace(AbstractJsonLexerKt.COMMA);
            }
            if (item == null) {
                break;
            }
            if (fonts == null) {
                fonts = new ArrayList<>();
            }
            fonts.add(item);
            scan.skipCommaWhitespace();
        } while (!scan.empty());
        return fonts;
    }

    private static SVG.Length parseFontSize(String val) {
        try {
            SVG.Length size = FontSizeKeywords.get(val);
            if (size == null) {
                return parseLength(val);
            }
            return size;
        } catch (SVGParseException e) {
            return null;
        }
    }

    private static Integer parseFontWeight(String val) {
        return FontWeightKeywords.get(val);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:14:0x0029  */
    private static SVG.Style.FontStyle parseFontStyle(String val) {
        switch (val) {
            case "italic":
                return SVG.Style.FontStyle.Italic;
            case "normal":
                return SVG.Style.FontStyle.Normal;
            case "oblique":
                return SVG.Style.FontStyle.Oblique;
            default:
                return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x003f  */
    private static SVG.Style.TextDecoration parseTextDecoration(String val) {
        switch (val) {
            case "none":
                return SVG.Style.TextDecoration.None;
            case "underline":
                return SVG.Style.TextDecoration.Underline;
            case "overline":
                return SVG.Style.TextDecoration.Overline;
            case "line-through":
                return SVG.Style.TextDecoration.LineThrough;
            case "blink":
                return SVG.Style.TextDecoration.Blink;
            default:
                return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x001e  */
    private static SVG.Style.TextDirection parseTextDirection(String val) {
        switch (val) {
            case "ltr":
                return SVG.Style.TextDirection.LTR;
            case "rtl":
                return SVG.Style.TextDirection.RTL;
            default:
                return null;
        }
    }

    private static SVG.Style.FillRule parseFillRule(String val) {
        if ("nonzero".equals(val)) {
            return SVG.Style.FillRule.NonZero;
        }
        if ("evenodd".equals(val)) {
            return SVG.Style.FillRule.EvenOdd;
        }
        return null;
    }

    private static SVG.Style.LineCap parseStrokeLineCap(String val) {
        if ("butt".equals(val)) {
            return SVG.Style.LineCap.Butt;
        }
        if ("round".equals(val)) {
            return SVG.Style.LineCap.Round;
        }
        if ("square".equals(val)) {
            return SVG.Style.LineCap.Square;
        }
        return null;
    }

    private static SVG.Style.LineJoin parseStrokeLineJoin(String val) {
        if ("miter".equals(val)) {
            return SVG.Style.LineJoin.Miter;
        }
        if ("round".equals(val)) {
            return SVG.Style.LineJoin.Round;
        }
        if ("bevel".equals(val)) {
            return SVG.Style.LineJoin.Bevel;
        }
        return null;
    }

    private static SVG.Length[] parseStrokeDashArray(String val) {
        SVG.Length dash;
        TextScanner scan = new TextScanner(val);
        scan.skipWhitespace();
        if (scan.empty() || (dash = scan.nextLength()) == null || dash.isNegative()) {
            return null;
        }
        float sum = dash.floatValue();
        List<SVG.Length> dashes = new ArrayList<>();
        dashes.add(dash);
        while (!scan.empty()) {
            scan.skipCommaWhitespace();
            SVG.Length dash2 = scan.nextLength();
            if (dash2 == null || dash2.isNegative()) {
                return null;
            }
            dashes.add(dash2);
            sum += dash2.floatValue();
        }
        if (sum == 0.0f) {
            return null;
        }
        return (SVG.Length[]) dashes.toArray(new SVG.Length[dashes.size()]);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:14:0x0029  */
    private static SVG.Style.TextAnchor parseTextAnchor(String val) {
        switch (val) {
            case "start":
                return SVG.Style.TextAnchor.Start;
            case "middle":
                return SVG.Style.TextAnchor.Middle;
            case "end":
                return SVG.Style.TextAnchor.End;
            default:
                return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x0034  */
    private static Boolean parseOverflow(String val) {
        switch (val) {
            case "visible":
            case "auto":
                return Boolean.TRUE;
            case "hidden":
            case "scroll":
                return Boolean.FALSE;
            default:
                return null;
        }
    }

    private static SVG.CSSClipRect parseClip(String val) {
        if (DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(val) || !val.startsWith("rect(")) {
            return null;
        }
        TextScanner scan = new TextScanner(val.substring(5));
        scan.skipWhitespace();
        SVG.Length top = parseLengthOrAuto(scan);
        scan.skipCommaWhitespace();
        SVG.Length right = parseLengthOrAuto(scan);
        scan.skipCommaWhitespace();
        SVG.Length bottom = parseLengthOrAuto(scan);
        scan.skipCommaWhitespace();
        SVG.Length left = parseLengthOrAuto(scan);
        scan.skipWhitespace();
        if (scan.consume(')') || scan.empty()) {
            return new SVG.CSSClipRect(top, right, bottom, left);
        }
        return null;
    }

    private static SVG.Length parseLengthOrAuto(TextScanner scan) {
        if (scan.consume(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
            return new SVG.Length(0.0f);
        }
        return scan.nextLength();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x001e  */
    private static SVG.Style.VectorEffect parseVectorEffect(String val) {
        switch (val) {
            case "none":
                return SVG.Style.VectorEffect.None;
            case "non-scaling-stroke":
                return SVG.Style.VectorEffect.NonScalingStroke;
            default:
                return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:14:0x0029  */
    private static SVG.Style.RenderQuality parseRenderQuality(String val) {
        switch (val) {
            case "auto":
                return SVG.Style.RenderQuality.auto;
            case "optimizeQuality":
                return SVG.Style.RenderQuality.optimizeQuality;
            case "optimizeSpeed":
                return SVG.Style.RenderQuality.optimizeSpeed;
            default:
                return null;
        }
    }

    private static SVG.PathDefinition parsePath(String val) {
        float x;
        float y;
        float x2;
        float y2;
        float x3;
        float y3;
        float y4;
        float x4;
        float x5;
        float y5;
        float y6;
        float y7;
        TextScanner scan = new TextScanner(val);
        float currentX = 0.0f;
        float currentY = 0.0f;
        float lastMoveX = 0.0f;
        float lastMoveY = 0.0f;
        float lastControlX = 0.0f;
        float lastControlY = 0.0f;
        SVG.PathDefinition path = new SVG.PathDefinition();
        if (scan.empty()) {
            return path;
        }
        int pathCommand = scan.nextChar().intValue();
        if (pathCommand != 77 && pathCommand != 109) {
            return path;
        }
        int pathCommand2 = pathCommand;
        while (true) {
            scan.skipWhitespace();
            int pathCommand3 = AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR;
            switch (pathCommand2) {
                case 65:
                case 97:
                    float lastMoveX2 = lastMoveX;
                    lastMoveY = lastMoveY;
                    int pathCommand4 = pathCommand2;
                    float rx = scan.nextFloat();
                    float ry = scan.checkedNextFloat(rx);
                    float xAxisRotation = scan.checkedNextFloat(ry);
                    Boolean largeArcFlag = scan.checkedNextFlag(Float.valueOf(xAxisRotation));
                    Boolean sweepFlag = scan.checkedNextFlag(largeArcFlag);
                    float x6 = scan.checkedNextFloat(sweepFlag);
                    float y8 = scan.checkedNextFloat(x6);
                    if (!Float.isNaN(y8) && rx >= 0.0f) {
                        if (ry >= 0.0f) {
                            if (pathCommand4 != 97) {
                                x = x6;
                                y = y8;
                            } else {
                                x = x6 + currentX;
                                y = y8 + currentY;
                            }
                            path.arcTo(rx, ry, xAxisRotation, largeArcFlag.booleanValue(), sweepFlag.booleanValue(), x, y);
                            lastControlX = x;
                            currentX = x;
                            lastControlY = y;
                            currentY = y;
                            pathCommand2 = pathCommand4;
                            lastMoveX = lastMoveX2;
                            break;
                        }
                    }
                    Log.e(TAG, "Bad path coords for " + ((char) pathCommand4) + " path segment");
                    return path;
                case 67:
                case 99:
                    float lastMoveX3 = lastMoveX;
                    lastMoveY = lastMoveY;
                    int pathCommand5 = pathCommand2;
                    float x1 = scan.nextFloat();
                    float y1 = scan.checkedNextFloat(x1);
                    float x7 = scan.checkedNextFloat(y1);
                    float y9 = scan.checkedNextFloat(x7);
                    float x8 = scan.checkedNextFloat(y9);
                    float y10 = scan.checkedNextFloat(x8);
                    if (Float.isNaN(y10)) {
                        Log.e(TAG, "Bad path coords for " + ((char) pathCommand5) + " path segment");
                        return path;
                    }
                    if (pathCommand5 != 99) {
                        x2 = x7;
                        y2 = y9;
                        x3 = x8;
                        y3 = y10;
                        y4 = y1;
                    } else {
                        x1 += currentX;
                        x2 = x7 + currentX;
                        y2 = y9 + currentY;
                        x3 = x8 + currentX;
                        y3 = y10 + currentY;
                        y4 = y1 + currentY;
                    }
                    path.cubicTo(x1, y4, x2, y2, x3, y3);
                    lastControlX = x2;
                    lastControlY = y2;
                    currentX = x3;
                    currentY = y3;
                    pathCommand2 = pathCommand5;
                    lastMoveX = lastMoveX3;
                    break;
                    break;
                case 72:
                case LocationRequestCompat.QUALITY_LOW_POWER /* 104 */:
                    float lastMoveX4 = lastMoveX;
                    lastMoveY = lastMoveY;
                    int pathCommand6 = pathCommand2;
                    float x9 = scan.nextFloat();
                    if (Float.isNaN(x9)) {
                        Log.e(TAG, "Bad path coords for " + ((char) pathCommand6) + " path segment");
                        return path;
                    }
                    if (pathCommand6 == 104) {
                        x9 += currentX;
                    }
                    path.lineTo(x9, currentY);
                    lastControlX = x9;
                    currentX = x9;
                    pathCommand2 = pathCommand6;
                    lastMoveX = lastMoveX4;
                    break;
                    break;
                case Base64.mimeLineLength /* 76 */:
                case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
                    float lastMoveX5 = lastMoveX;
                    lastMoveY = lastMoveY;
                    int pathCommand7 = pathCommand2;
                    float x10 = scan.nextFloat();
                    float y11 = scan.checkedNextFloat(x10);
                    if (Float.isNaN(y11)) {
                        Log.e(TAG, "Bad path coords for " + ((char) pathCommand7) + " path segment");
                        return path;
                    }
                    if (pathCommand7 == 108) {
                        x10 += currentX;
                        y11 += currentY;
                    }
                    path.lineTo(x10, y11);
                    lastControlX = x10;
                    currentX = x10;
                    lastControlY = y11;
                    currentY = y11;
                    pathCommand2 = pathCommand7;
                    lastMoveX = lastMoveX5;
                    break;
                    break;
                case 77:
                case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY /* 109 */:
                    int pathCommand8 = pathCommand2;
                    float x11 = scan.nextFloat();
                    float y12 = scan.checkedNextFloat(x11);
                    if (Float.isNaN(y12)) {
                        Log.e(TAG, "Bad path coords for " + ((char) pathCommand8) + " path segment");
                        return path;
                    }
                    if (pathCommand8 == 109 && !path.isEmpty()) {
                        x11 += currentX;
                        y12 += currentY;
                    }
                    path.moveTo(x11, y12);
                    lastControlX = x11;
                    float lastMoveX6 = x11;
                    currentX = x11;
                    lastControlY = y12;
                    float lastMoveY2 = y12;
                    currentY = y12;
                    if (pathCommand8 != 109) {
                        pathCommand3 = 76;
                    }
                    pathCommand2 = pathCommand3;
                    lastMoveX = lastMoveX6;
                    lastMoveY = lastMoveY2;
                    break;
                    break;
                case 81:
                case 113:
                    float lastMoveX7 = lastMoveX;
                    lastMoveY = lastMoveY;
                    int pathCommand9 = pathCommand2;
                    float x12 = scan.nextFloat();
                    float y13 = scan.checkedNextFloat(x12);
                    float x13 = scan.checkedNextFloat(y13);
                    float y14 = scan.checkedNextFloat(x13);
                    if (Float.isNaN(y14)) {
                        Log.e(TAG, "Bad path coords for " + ((char) pathCommand9) + " path segment");
                        return path;
                    }
                    if (pathCommand9 == 113) {
                        x13 += currentX;
                        y14 += currentY;
                        x12 += currentX;
                        y13 += currentY;
                    }
                    path.quadTo(x12, y13, x13, y14);
                    lastControlX = x12;
                    lastControlY = y13;
                    currentX = x13;
                    currentY = y14;
                    pathCommand2 = pathCommand9;
                    lastMoveX = lastMoveX7;
                    break;
                    break;
                case 83:
                case 115:
                    float x14 = (currentX * 2.0f) - lastControlX;
                    float y15 = (2.0f * currentY) - lastControlY;
                    float x15 = scan.nextFloat();
                    float y16 = scan.checkedNextFloat(x15);
                    float x16 = scan.checkedNextFloat(y16);
                    float y17 = scan.checkedNextFloat(x16);
                    if (Float.isNaN(y17)) {
                        Log.e(TAG, "Bad path coords for " + ((char) pathCommand2) + " path segment");
                        return path;
                    }
                    float lastMoveX8 = lastMoveX;
                    if (pathCommand2 != 115) {
                        x4 = x15;
                        x5 = x16;
                        y5 = y17;
                        y6 = y16;
                    } else {
                        x4 = x15 + currentX;
                        x5 = x16 + currentX;
                        y5 = y17 + currentY;
                        y6 = y16 + currentY;
                    }
                    lastMoveY = lastMoveY;
                    path.cubicTo(x14, y15, x4, y6, x5, y5);
                    lastControlX = x4;
                    lastControlY = y6;
                    currentX = x5;
                    currentY = y5;
                    pathCommand2 = pathCommand2;
                    lastMoveX = lastMoveX8;
                    break;
                    break;
                case 84:
                case 116:
                    float x17 = (currentX * 2.0f) - lastControlX;
                    float y18 = (2.0f * currentY) - lastControlY;
                    float x18 = scan.nextFloat();
                    float y19 = scan.checkedNextFloat(x18);
                    if (Float.isNaN(y19)) {
                        Log.e(TAG, "Bad path coords for " + ((char) pathCommand2) + " path segment");
                        return path;
                    }
                    if (pathCommand2 != 116) {
                        y7 = y19;
                    } else {
                        x18 += currentX;
                        y7 = y19 + currentY;
                    }
                    path.quadTo(x17, y18, x18, y7);
                    lastControlX = x17;
                    lastControlY = y18;
                    currentX = x18;
                    currentY = y7;
                    lastMoveY = lastMoveY;
                    break;
                    break;
                case 86:
                case 118:
                    float y20 = scan.nextFloat();
                    if (Float.isNaN(y20)) {
                        Log.e(TAG, "Bad path coords for " + ((char) pathCommand2) + " path segment");
                        return path;
                    }
                    if (pathCommand2 == 118) {
                        y20 += currentY;
                    }
                    path.lineTo(currentX, y20);
                    lastControlY = y20;
                    currentY = y20;
                    lastMoveY = lastMoveY;
                    break;
                    break;
                case 90:
                case 122:
                    path.close();
                    lastControlX = lastMoveX;
                    currentX = lastMoveX;
                    lastControlY = lastMoveY;
                    currentY = lastMoveY;
                    lastMoveY = lastMoveY;
                    break;
                default:
                    return path;
            }
            scan.skipCommaWhitespace();
            if (!scan.empty()) {
                if (scan.hasLetter()) {
                    pathCommand2 = scan.nextChar().intValue();
                }
            } else {
                return path;
            }
        }
    }

    private static Set<String> parseRequiredFeatures(String val) {
        TextScanner scan = new TextScanner(val);
        HashSet<String> result = new HashSet<>();
        while (!scan.empty()) {
            String feature = scan.nextToken();
            if (feature.startsWith(FEATURE_STRING_PREFIX)) {
                result.add(feature.substring(FEATURE_STRING_PREFIX.length()));
            } else {
                result.add("UNSUPPORTED");
            }
            scan.skipWhitespace();
        }
        return result;
    }

    private static Set<String> parseSystemLanguage(String val) {
        TextScanner scan = new TextScanner(val);
        HashSet<String> result = new HashSet<>();
        while (!scan.empty()) {
            String language = scan.nextToken();
            int hyphenPos = language.indexOf(45);
            if (hyphenPos != -1) {
                language = language.substring(0, hyphenPos);
            }
            result.add(new Locale(language, "", "").getLanguage());
            scan.skipWhitespace();
        }
        return result;
    }

    private static Set<String> parseRequiredFormats(String val) {
        TextScanner scan = new TextScanner(val);
        HashSet<String> result = new HashSet<>();
        while (!scan.empty()) {
            String mimetype = scan.nextToken();
            result.add(mimetype);
            scan.skipWhitespace();
        }
        return result;
    }

    private static String parseFunctionalIRI(String val, String attrName) {
        if (val.equals(NONE) || !val.startsWith("url(")) {
            return null;
        }
        if (val.endsWith(")")) {
            return val.substring(4, val.length() - 1).trim();
        }
        return val.substring(4).trim();
    }

    private void style(Attributes attributes) throws SVGParseException {
        debug("<style>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        boolean isTextCSS = true;
        String media = XML_STYLESHEET_ATTR_MEDIA_ALL;
        for (int i = 0; i < attributes.getLength(); i++) {
            String val = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case type:
                    isTextCSS = val.equals("text/css");
                    break;
                case media:
                    media = val;
                    break;
            }
        }
        if (isTextCSS && CSSParser.mediaMatches(media, CSSParser.MediaType.screen)) {
            this.inStyleElement = true;
        } else {
            this.ignoring = true;
            this.ignoreDepth = 1;
        }
    }

    private void parseCSSStyleSheet(String sheet) {
        CSSParser cssp = new CSSParser(CSSParser.MediaType.screen, CSSParser.Source.Document);
        this.svgDocument.addCSSRules(cssp.parse(sheet));
    }
}
