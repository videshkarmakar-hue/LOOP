package com.google.android.material.color;

import com.google.android.material.C2727R;

/* JADX INFO: loaded from: classes18.dex */
public final class HarmonizedColorAttributes {
    private static final int[] HARMONIZED_MATERIAL_ATTRIBUTES = {C2727R.attr.colorError, C2727R.attr.colorOnError, C2727R.attr.colorErrorContainer, C2727R.attr.colorOnErrorContainer};
    private final int[] attributes;
    private final int themeOverlay;

    public static HarmonizedColorAttributes create(int[] attributes) {
        return new HarmonizedColorAttributes(attributes, 0);
    }

    public static HarmonizedColorAttributes create(int[] attributes, int themeOverlay) {
        return new HarmonizedColorAttributes(attributes, themeOverlay);
    }

    public static HarmonizedColorAttributes createMaterialDefaults() {
        return create(HARMONIZED_MATERIAL_ATTRIBUTES, C2727R.style.ThemeOverlay_Material3_HarmonizedColors);
    }

    private HarmonizedColorAttributes(int[] attributes, int themeOverlay) {
        if (themeOverlay != 0 && attributes.length == 0) {
            throw new IllegalArgumentException("Theme overlay should be used with the accompanying int[] attributes.");
        }
        this.attributes = attributes;
        this.themeOverlay = themeOverlay;
    }

    public int[] getAttributes() {
        return this.attributes;
    }

    public int getThemeOverlay() {
        return this.themeOverlay;
    }
}
