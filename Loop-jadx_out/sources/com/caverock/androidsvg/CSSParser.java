package com.caverock.androidsvg;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.p013io.FilenameUtils;

/* JADX INFO: loaded from: classes.dex */
class CSSParser {
    private static final String CLASS = "class";
    static final String CSS_MIME_TYPE = "text/css";

    /* JADX INFO: renamed from: ID */
    private static final String f261ID = "id";
    private static final int SPECIFICITY_ATTRIBUTE_OR_PSEUDOCLASS = 1000;
    private static final int SPECIFICITY_ELEMENT_OR_PSEUDOELEMENT = 1;
    private static final int SPECIFICITY_ID_ATTRIBUTE = 1000000;
    private static final String TAG = "CSSParser";
    private MediaType deviceMediaType;
    private boolean inMediaRule;
    private Source source;

    private enum AttribOp {
        EXISTS,
        EQUALS,
        INCLUDES,
        DASHMATCH
    }

    private enum Combinator {
        DESCENDANT,
        CHILD,
        FOLLOWS
    }

    enum MediaType {
        all,
        aural,
        braille,
        embossed,
        handheld,
        print,
        projection,
        screen,
        speech,
        tty,
        tv
    }

    private interface PseudoClass {
        boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase);
    }

    enum Source {
        Document,
        RenderOptions
    }

    private enum PseudoClassIdents {
        target,
        root,
        nth_child,
        nth_last_child,
        nth_of_type,
        nth_last_of_type,
        first_child,
        last_child,
        first_of_type,
        last_of_type,
        only_child,
        only_of_type,
        empty,
        not,
        lang,
        link,
        visited,
        hover,
        active,
        focus,
        enabled,
        disabled,
        checked,
        indeterminate,
        UNSUPPORTED;

        private static final Map<String, PseudoClassIdents> cache = new HashMap();

        static {
            for (PseudoClassIdents attr : values()) {
                if (attr != UNSUPPORTED) {
                    String key = attr.name().replace('_', '-');
                    cache.put(key, attr);
                }
            }
        }

        public static PseudoClassIdents fromString(String str) {
            PseudoClassIdents attr = cache.get(str);
            if (attr != null) {
                return attr;
            }
            return UNSUPPORTED;
        }
    }

    private static class Attrib {
        public final String name;
        final AttribOp operation;
        public final String value;

        Attrib(String name, AttribOp op, String value) {
            this.name = name;
            this.operation = op;
            this.value = value;
        }
    }

    private static class SimpleSelector {
        Combinator combinator;
        String tag;
        List<Attrib> attribs = null;
        List<PseudoClass> pseudos = null;

        SimpleSelector(Combinator combinator, String tag) {
            this.combinator = null;
            this.tag = null;
            this.combinator = combinator != null ? combinator : Combinator.DESCENDANT;
            this.tag = tag;
        }

        void addAttrib(String attrName, AttribOp op, String attrValue) {
            if (this.attribs == null) {
                this.attribs = new ArrayList();
            }
            this.attribs.add(new Attrib(attrName, op, attrValue));
        }

        void addPseudo(PseudoClass pseudo) {
            if (this.pseudos == null) {
                this.pseudos = new ArrayList();
            }
            this.pseudos.add(pseudo);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.combinator == Combinator.CHILD) {
                sb.append("> ");
            } else if (this.combinator == Combinator.FOLLOWS) {
                sb.append("+ ");
            }
            sb.append(this.tag == null ? "*" : this.tag);
            if (this.attribs != null) {
                for (Attrib attr : this.attribs) {
                    sb.append(AbstractJsonLexerKt.BEGIN_LIST).append(attr.name);
                    switch (attr.operation) {
                        case EQUALS:
                            sb.append('=').append(attr.value);
                            break;
                        case INCLUDES:
                            sb.append("~=").append(attr.value);
                            break;
                        case DASHMATCH:
                            sb.append("|=").append(attr.value);
                            break;
                    }
                    sb.append(AbstractJsonLexerKt.END_LIST);
                }
            }
            if (this.pseudos != null) {
                for (PseudoClass pseu : this.pseudos) {
                    sb.append(AbstractJsonLexerKt.COLON).append(pseu);
                }
            }
            return sb.toString();
        }
    }

    static class Ruleset {
        private List<Rule> rules = null;

        Ruleset() {
        }

        void add(Rule rule) {
            if (this.rules == null) {
                this.rules = new ArrayList();
            }
            for (int i = 0; i < this.rules.size(); i++) {
                Rule nextRule = this.rules.get(i);
                if (nextRule.selector.specificity > rule.selector.specificity) {
                    this.rules.add(i, rule);
                    return;
                }
            }
            this.rules.add(rule);
        }

        void addAll(Ruleset rules) {
            if (rules.rules == null) {
                return;
            }
            if (this.rules == null) {
                this.rules = new ArrayList(rules.rules.size());
            }
            for (Rule rule : rules.rules) {
                add(rule);
            }
        }

        List<Rule> getRules() {
            return this.rules;
        }

        boolean isEmpty() {
            return this.rules == null || this.rules.isEmpty();
        }

        int ruleCount() {
            if (this.rules != null) {
                return this.rules.size();
            }
            return 0;
        }

        void removeFromSource(Source sourceToBeRemoved) {
            if (this.rules == null) {
                return;
            }
            Iterator<Rule> iter = this.rules.iterator();
            while (iter.hasNext()) {
                if (iter.next().source == sourceToBeRemoved) {
                    iter.remove();
                }
            }
        }

        public String toString() {
            if (this.rules == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (Rule rule : this.rules) {
                sb.append(rule.toString()).append('\n');
            }
            return sb.toString();
        }
    }

    static class Rule {
        Selector selector;
        Source source;
        SVG.Style style;

        Rule(Selector selector, SVG.Style style, Source source) {
            this.selector = null;
            this.style = null;
            this.selector = selector;
            this.style = style;
            this.source = source;
        }

        public String toString() {
            return String.valueOf(this.selector) + " {...} (src=" + this.source + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class Selector {
        List<SimpleSelector> simpleSelectors;
        int specificity;

        private Selector() {
            this.simpleSelectors = null;
            this.specificity = 0;
        }

        void add(SimpleSelector part) {
            if (this.simpleSelectors == null) {
                this.simpleSelectors = new ArrayList();
            }
            this.simpleSelectors.add(part);
        }

        int size() {
            if (this.simpleSelectors == null) {
                return 0;
            }
            return this.simpleSelectors.size();
        }

        SimpleSelector get(int i) {
            return this.simpleSelectors.get(i);
        }

        boolean isEmpty() {
            return this.simpleSelectors == null || this.simpleSelectors.isEmpty();
        }

        void addedIdAttribute() {
            this.specificity += 1000000;
        }

        void addedAttributeOrPseudo() {
            this.specificity += 1000;
        }

        void addedElement() {
            this.specificity++;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (SimpleSelector sel : this.simpleSelectors) {
                sb.append(sel).append(' ');
            }
            return sb.append(AbstractJsonLexerKt.BEGIN_LIST).append(this.specificity).append(AbstractJsonLexerKt.END_LIST).toString();
        }
    }

    CSSParser() {
        this(MediaType.screen, Source.Document);
    }

    CSSParser(Source source) {
        this(MediaType.screen, source);
    }

    CSSParser(MediaType rendererMediaType, Source source) {
        this.deviceMediaType = null;
        this.source = null;
        this.inMediaRule = false;
        this.deviceMediaType = rendererMediaType;
        this.source = source;
    }

    Ruleset parse(String sheet) {
        CSSTextScanner scan = new CSSTextScanner(sheet);
        scan.skipWhitespace();
        return parseRuleset(scan);
    }

    static boolean mediaMatches(String mediaListStr, MediaType rendererMediaType) {
        CSSTextScanner scan = new CSSTextScanner(mediaListStr);
        scan.skipWhitespace();
        List<MediaType> mediaList = parseMediaList(scan);
        return mediaMatches(mediaList, rendererMediaType);
    }

    private static void warn(String format, Object... args) {
        Log.w(TAG, String.format(format, args));
    }

    private static class CSSTextScanner extends SVGParser.TextScanner {
        CSSTextScanner(String input) {
            super(input.replaceAll("(?s)/\\*.*?\\*/", ""));
        }

        String nextIdentifier() {
            int end = scanForIdentifier();
            if (end == this.position) {
                return null;
            }
            String result = this.input.substring(this.position, end);
            this.position = end;
            return result;
        }

        private int scanForIdentifier() {
            if (empty()) {
                return this.position;
            }
            int start = this.position;
            int lastValidPos = this.position;
            int ch = this.input.charAt(this.position);
            if (ch == 45) {
                ch = advanceChar();
            }
            if ((ch >= 65 && ch <= 90) || ((ch >= 97 && ch <= 122) || ch == 95)) {
                int ch2 = advanceChar();
                while (true) {
                    if ((ch2 < 65 || ch2 > 90) && ((ch2 < 97 || ch2 > 122) && !((ch2 >= 48 && ch2 <= 57) || ch2 == 45 || ch2 == 95))) {
                        break;
                    }
                    ch2 = advanceChar();
                }
                lastValidPos = this.position;
            }
            this.position = start;
            return lastValidPos;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Selector> nextSelectorGroup() throws CSSParseException {
            if (empty()) {
                return null;
            }
            ArrayList<Selector> selectorGroup = new ArrayList<>(1);
            Selector selector = new Selector();
            while (!empty() && nextSimpleSelector(selector)) {
                if (skipCommaWhitespace()) {
                    selectorGroup.add(selector);
                    selector = new Selector();
                }
            }
            if (!selector.isEmpty()) {
                selectorGroup.add(selector);
            }
            return selectorGroup;
        }

        boolean nextSimpleSelector(Selector selector) throws CSSParseException {
            if (empty()) {
                return false;
            }
            int start = this.position;
            Combinator combinator = null;
            SimpleSelector selectorPart = null;
            if (!selector.isEmpty()) {
                if (consume(Typography.greater)) {
                    combinator = Combinator.CHILD;
                    skipWhitespace();
                } else if (consume('+')) {
                    combinator = Combinator.FOLLOWS;
                    skipWhitespace();
                }
            }
            if (consume('*')) {
                selectorPart = new SimpleSelector(combinator, null);
            } else {
                String tag = nextIdentifier();
                if (tag != null) {
                    selectorPart = new SimpleSelector(combinator, tag);
                    selector.addedElement();
                }
            }
            while (!empty()) {
                if (consume(FilenameUtils.EXTENSION_SEPARATOR)) {
                    if (selectorPart == null) {
                        selectorPart = new SimpleSelector(combinator, null);
                    }
                    String value = nextIdentifier();
                    if (value == null) {
                        throw new CSSParseException("Invalid \".class\" simpleSelectors");
                    }
                    selectorPart.addAttrib(CSSParser.CLASS, AttribOp.EQUALS, value);
                    selector.addedAttributeOrPseudo();
                } else if (consume('#')) {
                    if (selectorPart == null) {
                        selectorPart = new SimpleSelector(combinator, null);
                    }
                    String value2 = nextIdentifier();
                    if (value2 == null) {
                        throw new CSSParseException("Invalid \"#id\" simpleSelectors");
                    }
                    selectorPart.addAttrib(CSSParser.f261ID, AttribOp.EQUALS, value2);
                    selector.addedIdAttribute();
                } else if (consume(AbstractJsonLexerKt.BEGIN_LIST)) {
                    if (selectorPart == null) {
                        selectorPart = new SimpleSelector(combinator, null);
                    }
                    skipWhitespace();
                    String attrName = nextIdentifier();
                    String attrValue = null;
                    if (attrName == null) {
                        throw new CSSParseException("Invalid attribute simpleSelectors");
                    }
                    skipWhitespace();
                    AttribOp op = null;
                    if (consume('=')) {
                        op = AttribOp.EQUALS;
                    } else if (consume("~=")) {
                        op = AttribOp.INCLUDES;
                    } else if (consume("|=")) {
                        op = AttribOp.DASHMATCH;
                    }
                    if (op != null) {
                        skipWhitespace();
                        attrValue = nextAttribValue();
                        if (attrValue == null) {
                            throw new CSSParseException("Invalid attribute simpleSelectors");
                        }
                        skipWhitespace();
                    }
                    if (!consume(AbstractJsonLexerKt.END_LIST)) {
                        throw new CSSParseException("Invalid attribute simpleSelectors");
                    }
                    selectorPart.addAttrib(attrName, op == null ? AttribOp.EXISTS : op, attrValue);
                    selector.addedAttributeOrPseudo();
                } else {
                    if (!consume(AbstractJsonLexerKt.COLON)) {
                        break;
                    }
                    if (selectorPart == null) {
                        selectorPart = new SimpleSelector(combinator, null);
                    }
                    parsePseudoClass(selector, selectorPart);
                }
            }
            if (selectorPart != null) {
                selector.add(selectorPart);
                return true;
            }
            this.position = start;
            return false;
        }

        private static class AnPlusB {

            /* JADX INFO: renamed from: a */
            public int f262a;

            /* JADX INFO: renamed from: b */
            public int f263b;

            AnPlusB(int a, int b) {
                this.f262a = a;
                this.f263b = b;
            }
        }

        private AnPlusB nextAnPlusB() throws CSSParseException {
            AnPlusB result;
            if (empty()) {
                return null;
            }
            int start = this.position;
            if (!consume('(')) {
                return null;
            }
            skipWhitespace();
            if (consume("odd")) {
                result = new AnPlusB(2, 1);
            } else {
                if (consume("even")) {
                    result = new AnPlusB(2, 0);
                } else {
                    int aSign = 1;
                    int bSign = 1;
                    if (!consume('+') && consume('-')) {
                        bSign = -1;
                    }
                    IntegerParser a = null;
                    IntegerParser b = IntegerParser.parseInt(this.input, this.position, this.inputLength, false);
                    if (b != null) {
                        this.position = b.getEndPos();
                    }
                    if (consume('n') || consume('N')) {
                        a = b != null ? b : new IntegerParser(1L, this.position);
                        aSign = bSign;
                        b = null;
                        bSign = 1;
                        skipWhitespace();
                        boolean hasB = consume('+');
                        if (!hasB && (hasB = consume('-'))) {
                            bSign = -1;
                        }
                        if (hasB) {
                            skipWhitespace();
                            b = IntegerParser.parseInt(this.input, this.position, this.inputLength, false);
                            if (b != null) {
                                this.position = b.getEndPos();
                            } else {
                                this.position = start;
                                return null;
                            }
                        }
                    }
                    result = new AnPlusB(a == null ? 0 : a.value() * aSign, b != null ? b.value() * bSign : 0);
                }
            }
            skipWhitespace();
            if (consume(')')) {
                return result;
            }
            this.position = start;
            return null;
        }

        private List<String> nextIdentListParam() throws CSSParseException {
            if (empty()) {
                return null;
            }
            int start = this.position;
            ArrayList<String> result = null;
            if (!consume('(')) {
                return null;
            }
            skipWhitespace();
            do {
                String ident = nextIdentifier();
                if (ident == null) {
                    this.position = start;
                    return null;
                }
                if (result == null) {
                    result = new ArrayList<>();
                }
                result.add(ident);
                skipWhitespace();
            } while (skipCommaWhitespace());
            if (consume(')')) {
                return result;
            }
            this.position = start;
            return null;
        }

        private List<Selector> nextPseudoNotParam() throws CSSParseException {
            if (empty()) {
                return null;
            }
            int start = this.position;
            if (!consume('(')) {
                return null;
            }
            skipWhitespace();
            List<Selector> result = nextSelectorGroup();
            if (result == null) {
                this.position = start;
                return null;
            }
            if (!consume(')')) {
                this.position = start;
                return null;
            }
            for (Selector selector : result) {
                if (selector.simpleSelectors == null) {
                    break;
                }
                for (SimpleSelector simpleSelector : selector.simpleSelectors) {
                    if (simpleSelector.pseudos == null) {
                        break;
                    }
                    for (PseudoClass pseudo : simpleSelector.pseudos) {
                        if (pseudo instanceof PseudoClassNot) {
                            return null;
                        }
                    }
                }
            }
            return result;
        }

        private void parsePseudoClass(Selector selector, SimpleSelector selectorPart) throws CSSParseException {
            PseudoClass pseudo;
            String ident = nextIdentifier();
            if (ident == null) {
                throw new CSSParseException("Invalid pseudo class");
            }
            PseudoClassIdents identEnum = PseudoClassIdents.fromString(ident);
            switch (identEnum) {
                case first_child:
                    pseudo = new PseudoClassAnPlusB(0, 1, true, false, null);
                    selector.addedAttributeOrPseudo();
                    break;
                case last_child:
                    pseudo = new PseudoClassAnPlusB(0, 1, false, false, null);
                    selector.addedAttributeOrPseudo();
                    break;
                case only_child:
                    pseudo = new PseudoClassOnlyChild(false, null);
                    selector.addedAttributeOrPseudo();
                    break;
                case first_of_type:
                    pseudo = new PseudoClassAnPlusB(0, 1, true, true, selectorPart.tag);
                    selector.addedAttributeOrPseudo();
                    break;
                case last_of_type:
                    pseudo = new PseudoClassAnPlusB(0, 1, false, true, selectorPart.tag);
                    selector.addedAttributeOrPseudo();
                    break;
                case only_of_type:
                    pseudo = new PseudoClassOnlyChild(true, selectorPart.tag);
                    selector.addedAttributeOrPseudo();
                    break;
                case root:
                    pseudo = new PseudoClassRoot();
                    selector.addedAttributeOrPseudo();
                    break;
                case empty:
                    pseudo = new PseudoClassEmpty();
                    selector.addedAttributeOrPseudo();
                    break;
                case nth_child:
                case nth_last_child:
                case nth_of_type:
                case nth_last_of_type:
                    boolean fromStart = identEnum == PseudoClassIdents.nth_child || identEnum == PseudoClassIdents.nth_of_type;
                    boolean ofType = identEnum == PseudoClassIdents.nth_of_type || identEnum == PseudoClassIdents.nth_last_of_type;
                    AnPlusB ab = nextAnPlusB();
                    if (ab == null) {
                        throw new CSSParseException("Invalid or missing parameter section for pseudo class: " + ident);
                    }
                    pseudo = new PseudoClassAnPlusB(ab.f262a, ab.f263b, fromStart, ofType, selectorPart.tag);
                    selector.addedAttributeOrPseudo();
                    break;
                    break;
                case not:
                    List<Selector> notSelectorGroup = nextPseudoNotParam();
                    if (notSelectorGroup == null) {
                        throw new CSSParseException("Invalid or missing parameter section for pseudo class: " + ident);
                    }
                    pseudo = new PseudoClassNot(notSelectorGroup);
                    selector.specificity = ((PseudoClassNot) pseudo).getSpecificity();
                    break;
                    break;
                case target:
                    pseudo = new PseudoClassTarget();
                    selector.addedAttributeOrPseudo();
                    break;
                case lang:
                    nextIdentListParam();
                    pseudo = new PseudoClassNotSupported(ident);
                    selector.addedAttributeOrPseudo();
                    break;
                case link:
                case visited:
                case hover:
                case active:
                case focus:
                case enabled:
                case disabled:
                case checked:
                case indeterminate:
                    pseudo = new PseudoClassNotSupported(ident);
                    selector.addedAttributeOrPseudo();
                    break;
                default:
                    throw new CSSParseException("Unsupported pseudo class: " + ident);
            }
            selectorPart.addPseudo(pseudo);
        }

        private String nextAttribValue() {
            if (empty()) {
                return null;
            }
            String result = nextQuotedString();
            if (result != null) {
                return result;
            }
            return nextIdentifier();
        }

        String nextPropertyValue() {
            if (empty()) {
                return null;
            }
            int start = this.position;
            int lastValidPos = this.position;
            int ch = this.input.charAt(this.position);
            while (ch != -1 && ch != 59 && ch != 125 && ch != 33 && !isEOL(ch)) {
                if (!isWhitespace(ch)) {
                    lastValidPos = this.position + 1;
                }
                ch = advanceChar();
            }
            if (this.position > start) {
                return this.input.substring(start, lastValidPos);
            }
            this.position = start;
            return null;
        }

        String nextCSSString() {
            int hc;
            if (empty()) {
                return null;
            }
            int ch = this.input.charAt(this.position);
            if (ch != 39 && ch != 34) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            this.position++;
            int ch2 = nextChar().intValue();
            while (ch2 != -1 && ch2 != ch) {
                if (ch2 == 92) {
                    ch2 = nextChar().intValue();
                    if (ch2 != -1) {
                        if (ch2 == 10 || ch2 == 13 || ch2 == 12) {
                            ch2 = nextChar().intValue();
                        } else {
                            int hc2 = hexChar(ch2);
                            if (hc2 != -1) {
                                int codepoint = hc2;
                                for (int i = 1; i <= 5 && (hc = hexChar((ch2 = nextChar().intValue()))) != -1; i++) {
                                    codepoint = (codepoint * 16) + hc;
                                }
                                sb.append((char) codepoint);
                            }
                        }
                    }
                }
                sb.append((char) ch2);
                ch2 = nextChar().intValue();
            }
            return sb.toString();
        }

        private int hexChar(int ch) {
            if (ch >= 48 && ch <= 57) {
                return ch - 48;
            }
            if (ch >= 65 && ch <= 70) {
                return (ch - 65) + 10;
            }
            if (ch >= 97 && ch <= 102) {
                return (ch - 97) + 10;
            }
            return -1;
        }

        String nextURL() {
            if (empty()) {
                return null;
            }
            int start = this.position;
            if (!consume("url(")) {
                return null;
            }
            skipWhitespace();
            String url = nextCSSString();
            if (url == null) {
                url = nextLegacyURL();
            }
            if (url == null) {
                this.position = start;
                return null;
            }
            skipWhitespace();
            if (empty() || consume(")")) {
                return url;
            }
            this.position = start;
            return null;
        }

        String nextLegacyURL() {
            int ch;
            int hc;
            StringBuilder sb = new StringBuilder();
            while (!empty() && (ch = this.input.charAt(this.position)) != 39 && ch != 34 && ch != 40 && ch != 41 && !isWhitespace(ch) && !Character.isISOControl(ch)) {
                this.position++;
                if (ch == 92) {
                    if (!empty()) {
                        String str = this.input;
                        int i = this.position;
                        this.position = i + 1;
                        ch = str.charAt(i);
                        if (ch != 10 && ch != 13 && ch != 12) {
                            int hc2 = hexChar(ch);
                            if (hc2 != -1) {
                                int codepoint = hc2;
                                for (int i2 = 1; i2 <= 5 && !empty() && (hc = hexChar(this.input.charAt(this.position))) != -1; i2++) {
                                    this.position++;
                                    codepoint = (codepoint * 16) + hc;
                                }
                                sb.append((char) codepoint);
                            }
                        }
                    }
                }
                sb.append((char) ch);
            }
            if (sb.length() == 0) {
                return null;
            }
            return sb.toString();
        }
    }

    private static boolean mediaMatches(List<MediaType> mediaList, MediaType rendererMediaType) {
        for (MediaType type : mediaList) {
            if (type == MediaType.all || type == rendererMediaType) {
                return true;
            }
        }
        return false;
    }

    private static List<MediaType> parseMediaList(CSSTextScanner scan) {
        String type;
        ArrayList<MediaType> typeList = new ArrayList<>();
        while (!scan.empty() && (type = scan.nextWord()) != null) {
            try {
                typeList.add(MediaType.valueOf(type));
            } catch (IllegalArgumentException e) {
            }
            if (!scan.skipCommaWhitespace()) {
                break;
            }
        }
        return typeList;
    }

    private void parseAtRule(Ruleset ruleset, CSSTextScanner scan) throws CSSParseException {
        String atKeyword = scan.nextIdentifier();
        scan.skipWhitespace();
        if (atKeyword == null) {
            throw new CSSParseException("Invalid '@' rule");
        }
        if (!this.inMediaRule && atKeyword.equals(SVGParser.XML_STYLESHEET_ATTR_MEDIA)) {
            List<MediaType> mediaList = parseMediaList(scan);
            if (!scan.consume(AbstractJsonLexerKt.BEGIN_OBJ)) {
                throw new CSSParseException("Invalid @media rule: missing rule set");
            }
            scan.skipWhitespace();
            if (mediaMatches(mediaList, this.deviceMediaType)) {
                this.inMediaRule = true;
                ruleset.addAll(parseRuleset(scan));
                this.inMediaRule = false;
            } else {
                parseRuleset(scan);
            }
            if (!scan.empty() && !scan.consume(AbstractJsonLexerKt.END_OBJ)) {
                throw new CSSParseException("Invalid @media rule: expected '}' at end of rule set");
            }
        } else if (!this.inMediaRule && atKeyword.equals("import")) {
            String file = scan.nextURL();
            if (file == null) {
                file = scan.nextCSSString();
            }
            if (file == null) {
                throw new CSSParseException("Invalid @import rule: expected string or url()");
            }
            scan.skipWhitespace();
            List<MediaType> mediaList2 = parseMediaList(scan);
            if (!scan.empty() && !scan.consume(';')) {
                throw new CSSParseException("Invalid @media rule: expected '}' at end of rule set");
            }
            if (SVG.getFileResolver() != null && mediaMatches(mediaList2, this.deviceMediaType)) {
                String css = SVG.getFileResolver().resolveCSSStyleSheet(file);
                if (css == null) {
                    return;
                } else {
                    ruleset.addAll(parse(css));
                }
            }
        } else {
            warn("Ignoring @%s rule", atKeyword);
            skipAtRule(scan);
        }
        scan.skipWhitespace();
    }

    private void skipAtRule(CSSTextScanner scan) {
        int depth = 0;
        while (!scan.empty()) {
            int ch = scan.nextChar().intValue();
            if (ch == 59 && depth == 0) {
                return;
            }
            if (ch == 123) {
                depth++;
            } else if (ch == 125 && depth > 0 && (depth = depth - 1) == 0) {
                return;
            }
        }
    }

    private Ruleset parseRuleset(CSSTextScanner scan) {
        Ruleset ruleset = new Ruleset();
        while (!scan.empty()) {
            try {
                if (!scan.consume("<!--") && !scan.consume("-->")) {
                    if (scan.consume('@')) {
                        parseAtRule(ruleset, scan);
                    } else if (!parseRule(ruleset, scan)) {
                        break;
                    }
                }
            } catch (CSSParseException e) {
                Log.e(TAG, "CSS parser terminated early due to error: " + e.getMessage());
            }
        }
        return ruleset;
    }

    private boolean parseRule(Ruleset ruleset, CSSTextScanner scan) throws CSSParseException {
        List<Selector> selectors = scan.nextSelectorGroup();
        if (selectors != null && !selectors.isEmpty()) {
            if (!scan.consume(AbstractJsonLexerKt.BEGIN_OBJ)) {
                throw new CSSParseException("Malformed rule block: expected '{'");
            }
            scan.skipWhitespace();
            SVG.Style ruleStyle = parseDeclarations(scan);
            scan.skipWhitespace();
            for (Selector selector : selectors) {
                ruleset.add(new Rule(selector, ruleStyle, this.source));
            }
            return true;
        }
        return false;
    }

    private SVG.Style parseDeclarations(CSSTextScanner scan) throws CSSParseException {
        SVG.Style ruleStyle = new SVG.Style();
        do {
            String propertyName = scan.nextIdentifier();
            scan.skipWhitespace();
            if (!scan.consume(AbstractJsonLexerKt.COLON)) {
                throw new CSSParseException("Expected ':'");
            }
            scan.skipWhitespace();
            String propertyValue = scan.nextPropertyValue();
            if (propertyValue == null) {
                throw new CSSParseException("Expected property value");
            }
            scan.skipWhitespace();
            if (scan.consume('!')) {
                scan.skipWhitespace();
                if (!scan.consume("important")) {
                    throw new CSSParseException("Malformed rule set: found unexpected '!'");
                }
                scan.skipWhitespace();
            }
            scan.consume(';');
            SVGParser.processStyleProperty(ruleStyle, propertyName, propertyValue);
            scan.skipWhitespace();
            if (scan.empty()) {
                break;
            }
        } while (!scan.consume(AbstractJsonLexerKt.END_OBJ));
        return ruleStyle;
    }

    public static List<String> parseClassAttribute(String val) {
        CSSTextScanner scan = new CSSTextScanner(val);
        List<String> classNameList = null;
        while (!scan.empty()) {
            String className = scan.nextToken();
            if (className != null) {
                if (classNameList == null) {
                    classNameList = new ArrayList<>();
                }
                classNameList.add(className);
                scan.skipWhitespace();
            }
        }
        return classNameList;
    }

    static class RuleMatchContext {
        SVG.SvgElementBase targetElement;

        RuleMatchContext() {
        }

        public String toString() {
            return this.targetElement != null ? String.format("<%s id=\"%s\">", this.targetElement.getNodeName(), this.targetElement.f291id) : "";
        }
    }

    static boolean ruleMatch(RuleMatchContext ruleMatchContext, Selector selector, SVG.SvgElementBase obj) {
        List<SVG.SvgContainer> ancestors = new ArrayList<>();
        for (SVG.SvgContainer parent = obj.parent; parent != null; parent = ((SVG.SvgObject) parent).parent) {
            ancestors.add(0, parent);
        }
        int ancestorsPos = ancestors.size() - 1;
        if (selector.size() == 1) {
            return selectorMatch(ruleMatchContext, selector.get(0), ancestors, ancestorsPos, obj);
        }
        return ruleMatch(ruleMatchContext, selector, selector.size() - 1, ancestors, ancestorsPos, obj);
    }

    private static boolean ruleMatch(RuleMatchContext ruleMatchContext, Selector selector, int selPartPos, List<SVG.SvgContainer> ancestors, int ancestorsPos, SVG.SvgElementBase obj) {
        SimpleSelector sel = selector.get(selPartPos);
        if (!selectorMatch(ruleMatchContext, sel, ancestors, ancestorsPos, obj)) {
            return false;
        }
        if (sel.combinator == Combinator.DESCENDANT) {
            if (selPartPos == 0) {
                return true;
            }
            while (ancestorsPos >= 0) {
                if (ruleMatchOnAncestors(ruleMatchContext, selector, selPartPos - 1, ancestors, ancestorsPos)) {
                    return true;
                }
                ancestorsPos--;
            }
            return false;
        }
        if (sel.combinator == Combinator.CHILD) {
            return ruleMatchOnAncestors(ruleMatchContext, selector, selPartPos - 1, ancestors, ancestorsPos);
        }
        int childPos = getChildPosition(ancestors, ancestorsPos, obj);
        if (childPos <= 0) {
            return false;
        }
        SVG.SvgElementBase prevSibling = (SVG.SvgElementBase) obj.parent.getChildren().get(childPos - 1);
        return ruleMatch(ruleMatchContext, selector, selPartPos - 1, ancestors, ancestorsPos, prevSibling);
    }

    private static boolean ruleMatchOnAncestors(RuleMatchContext ruleMatchContext, Selector selector, int selPartPos, List<SVG.SvgContainer> ancestors, int ancestorsPos) {
        SimpleSelector sel = selector.get(selPartPos);
        SVG.SvgElementBase obj = (SVG.SvgElementBase) ancestors.get(ancestorsPos);
        if (!selectorMatch(ruleMatchContext, sel, ancestors, ancestorsPos, obj)) {
            return false;
        }
        if (sel.combinator == Combinator.DESCENDANT) {
            if (selPartPos == 0) {
                return true;
            }
            while (ancestorsPos > 0) {
                ancestorsPos--;
                if (ruleMatchOnAncestors(ruleMatchContext, selector, selPartPos - 1, ancestors, ancestorsPos)) {
                    return true;
                }
            }
            return false;
        }
        if (sel.combinator == Combinator.CHILD) {
            return ruleMatchOnAncestors(ruleMatchContext, selector, selPartPos - 1, ancestors, ancestorsPos - 1);
        }
        int childPos = getChildPosition(ancestors, ancestorsPos, obj);
        if (childPos <= 0) {
            return false;
        }
        SVG.SvgElementBase prevSibling = (SVG.SvgElementBase) obj.parent.getChildren().get(childPos - 1);
        return ruleMatch(ruleMatchContext, selector, selPartPos - 1, ancestors, ancestorsPos, prevSibling);
    }

    private static int getChildPosition(List<SVG.SvgContainer> ancestors, int ancestorsPos, SVG.SvgElementBase obj) {
        if (ancestorsPos < 0) {
            return 0;
        }
        if (ancestors.get(ancestorsPos) != obj.parent) {
            return -1;
        }
        int childPos = 0;
        for (SVG.SvgObject child : obj.parent.getChildren()) {
            if (child == obj) {
                return childPos;
            }
            childPos++;
        }
        return -1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:21:0x004f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0059  */
    /* JADX WARN: Code duplicated, block: B:45:0x0053 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x0064 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x0058 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x0054 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x006e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x0023 A[SYNTHETIC] */
    private static boolean selectorMatch(RuleMatchContext ruleMatchContext, SimpleSelector sel, List<SVG.SvgContainer> ancestors, int ancestorsPos, SVG.SvgElementBase obj) {
        byte b;
        if (sel.tag != null && !sel.tag.equals(obj.getNodeName().toLowerCase(Locale.US))) {
            return false;
        }
        if (sel.attribs != null) {
            for (Attrib attr : sel.attribs) {
                switch (attr.name) {
                    case "id":
                        b = 0;
                    case "class":
                        b = 1;
                    default:
                        b = -1;
                }
            }
        }
        if (sel.pseudos != null) {
            for (PseudoClass pseudo : sel.pseudos) {
                if (!pseudo.matches(ruleMatchContext, obj)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static class PseudoClassAnPlusB implements PseudoClass {

        /* JADX INFO: renamed from: a */
        private int f265a;

        /* JADX INFO: renamed from: b */
        private int f266b;
        private boolean isFromStart;
        private boolean isOfType;
        private String nodeName;

        PseudoClassAnPlusB(int a, int b, boolean isFromStart, boolean isOfType, String nodeName) {
            this.f265a = a;
            this.f266b = b;
            this.isFromStart = isFromStart;
            this.isOfType = isOfType;
            this.nodeName = nodeName;
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase obj) {
            String nodeNameToCheck = (this.isOfType && this.nodeName == null) ? obj.getNodeName() : this.nodeName;
            int childPos = 0;
            int childCount = 1;
            if (obj.parent != null) {
                childCount = 0;
                for (SVG.SvgObject node : obj.parent.getChildren()) {
                    SVG.SvgElementBase child = (SVG.SvgElementBase) node;
                    if (child == obj) {
                        childPos = childCount;
                    }
                    if (nodeNameToCheck == null || child.getNodeName().equals(nodeNameToCheck)) {
                        childCount++;
                    }
                }
            }
            int childPos2 = this.isFromStart ? childPos + 1 : childCount - childPos;
            if (this.f265a == 0) {
                return childPos2 == this.f266b;
            }
            if ((childPos2 - this.f266b) % this.f265a == 0) {
                return Integer.signum(childPos2 - this.f266b) == 0 || Integer.signum(childPos2 - this.f266b) == Integer.signum(this.f265a);
            }
            return false;
        }

        public String toString() {
            String last = this.isFromStart ? "" : "last-";
            return this.isOfType ? String.format("nth-%schild(%dn%+d of type <%s>)", last, Integer.valueOf(this.f265a), Integer.valueOf(this.f266b), this.nodeName) : String.format("nth-%schild(%dn%+d)", last, Integer.valueOf(this.f265a), Integer.valueOf(this.f266b));
        }
    }

    private static class PseudoClassOnlyChild implements PseudoClass {
        private boolean isOfType;
        private String nodeName;

        public PseudoClassOnlyChild(boolean isOfType, String nodeName) {
            this.isOfType = isOfType;
            this.nodeName = nodeName;
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase obj) {
            String nodeNameToCheck = (this.isOfType && this.nodeName == null) ? obj.getNodeName() : this.nodeName;
            int childCount = 1;
            if (obj.parent != null) {
                childCount = 0;
                for (SVG.SvgObject node : obj.parent.getChildren()) {
                    SVG.SvgElementBase child = (SVG.SvgElementBase) node;
                    if (nodeNameToCheck == null || child.getNodeName().equals(nodeNameToCheck)) {
                        childCount++;
                    }
                }
            }
            return childCount == 1;
        }

        public String toString() {
            return this.isOfType ? String.format("only-of-type <%s>", this.nodeName) : String.format("only-child", new Object[0]);
        }
    }

    private static class PseudoClassRoot implements PseudoClass {
        private PseudoClassRoot() {
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase obj) {
            return obj.parent == null;
        }

        public String toString() {
            return "root";
        }
    }

    private static class PseudoClassEmpty implements PseudoClass {
        private PseudoClassEmpty() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            return !(svgElementBase instanceof SVG.SvgContainer) || ((SVG.SvgContainer) svgElementBase).getChildren().size() == 0;
        }

        public String toString() {
            return "empty";
        }
    }

    private static class PseudoClassNot implements PseudoClass {
        private List<Selector> selectorGroup;

        PseudoClassNot(List<Selector> selectorGroup) {
            this.selectorGroup = selectorGroup;
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase obj) {
            for (Selector selector : this.selectorGroup) {
                if (CSSParser.ruleMatch(ruleMatchContext, selector, obj)) {
                    return false;
                }
            }
            return true;
        }

        int getSpecificity() {
            int highest = Integer.MIN_VALUE;
            for (Selector selector : this.selectorGroup) {
                if (selector.specificity > highest) {
                    highest = selector.specificity;
                }
            }
            return highest;
        }

        public String toString() {
            return "not(" + this.selectorGroup + ")";
        }
    }

    private static class PseudoClassTarget implements PseudoClass {
        private PseudoClassTarget() {
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase obj) {
            return ruleMatchContext != null && obj == ruleMatchContext.targetElement;
        }

        public String toString() {
            return "target";
        }
    }

    private static class PseudoClassNotSupported implements PseudoClass {
        private String clazz;

        PseudoClassNotSupported(String clazz) {
            this.clazz = clazz;
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase obj) {
            return false;
        }

        public String toString() {
            return this.clazz;
        }
    }
}
