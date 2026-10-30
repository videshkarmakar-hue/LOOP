package com.google.android.material.color.utilities;

/* JADX INFO: loaded from: classes18.dex */
public final class CorePalette {

    /* JADX INFO: renamed from: a1 */
    public TonalPalette f408a1;

    /* JADX INFO: renamed from: a2 */
    public TonalPalette f409a2;

    /* JADX INFO: renamed from: a3 */
    public TonalPalette f410a3;
    public TonalPalette error;

    /* JADX INFO: renamed from: n1 */
    public TonalPalette f411n1;

    /* JADX INFO: renamed from: n2 */
    public TonalPalette f412n2;

    /* JADX INFO: renamed from: of */
    public static CorePalette m97of(int argb) {
        return new CorePalette(argb, false);
    }

    public static CorePalette contentOf(int argb) {
        return new CorePalette(argb, true);
    }

    private CorePalette(int argb, boolean isContent) {
        Hct hct = Hct.fromInt(argb);
        double hue = hct.getHue();
        double chroma = hct.getChroma();
        if (isContent) {
            this.f408a1 = TonalPalette.fromHueAndChroma(hue, chroma);
            this.f409a2 = TonalPalette.fromHueAndChroma(hue, chroma / 3.0d);
            this.f410a3 = TonalPalette.fromHueAndChroma(60.0d + hue, chroma / 2.0d);
            this.f411n1 = TonalPalette.fromHueAndChroma(hue, Math.min(chroma / 12.0d, 4.0d));
            this.f412n2 = TonalPalette.fromHueAndChroma(hue, Math.min(chroma / 6.0d, 8.0d));
        } else {
            this.f408a1 = TonalPalette.fromHueAndChroma(hue, Math.max(48.0d, chroma));
            this.f409a2 = TonalPalette.fromHueAndChroma(hue, 16.0d);
            this.f410a3 = TonalPalette.fromHueAndChroma(60.0d + hue, 24.0d);
            this.f411n1 = TonalPalette.fromHueAndChroma(hue, 4.0d);
            this.f412n2 = TonalPalette.fromHueAndChroma(hue, 8.0d);
        }
        this.error = TonalPalette.fromHueAndChroma(25.0d, 84.0d);
    }
}
