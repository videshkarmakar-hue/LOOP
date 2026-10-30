package com.caverock.androidsvg;

/* JADX INFO: loaded from: classes.dex */
public class RenderOptions {
    CSSParser.Ruleset css;
    PreserveAspectRatio preserveAspectRatio;
    String targetId;
    SVG.Box viewBox;
    String viewId;
    SVG.Box viewPort;

    public RenderOptions() {
        this.css = null;
        this.preserveAspectRatio = null;
        this.targetId = null;
        this.viewBox = null;
        this.viewId = null;
        this.viewPort = null;
    }

    public static RenderOptions create() {
        return new RenderOptions();
    }

    public RenderOptions(RenderOptions other) {
        this.css = null;
        this.preserveAspectRatio = null;
        this.targetId = null;
        this.viewBox = null;
        this.viewId = null;
        this.viewPort = null;
        if (other == null) {
            return;
        }
        this.css = other.css;
        this.preserveAspectRatio = other.preserveAspectRatio;
        this.viewBox = other.viewBox;
        this.viewId = other.viewId;
        this.viewPort = other.viewPort;
    }

    public RenderOptions css(String css) {
        CSSParser parser = new CSSParser(CSSParser.Source.RenderOptions);
        this.css = parser.parse(css);
        return this;
    }

    public boolean hasCss() {
        return this.css != null && this.css.ruleCount() > 0;
    }

    public RenderOptions preserveAspectRatio(PreserveAspectRatio preserveAspectRatio) {
        this.preserveAspectRatio = preserveAspectRatio;
        return this;
    }

    public boolean hasPreserveAspectRatio() {
        return this.preserveAspectRatio != null;
    }

    public RenderOptions view(String viewId) {
        this.viewId = viewId;
        return this;
    }

    public boolean hasView() {
        return this.viewId != null;
    }

    public RenderOptions viewBox(float minX, float minY, float width, float height) {
        this.viewBox = new SVG.Box(minX, minY, width, height);
        return this;
    }

    public boolean hasViewBox() {
        return this.viewBox != null;
    }

    public RenderOptions viewPort(float minX, float minY, float width, float height) {
        this.viewPort = new SVG.Box(minX, minY, width, height);
        return this;
    }

    public boolean hasViewPort() {
        return this.viewPort != null;
    }

    public RenderOptions target(String targetId) {
        this.targetId = targetId;
        return this;
    }

    public boolean hasTarget() {
        return this.targetId != null;
    }
}
