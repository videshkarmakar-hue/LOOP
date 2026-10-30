package io.material.utils;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: StringUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m194d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m195d2 = {"Lio/material/utils/StringUtils;", "", "()V", "hexFromArgb", "", "argb", "", "color_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class StringUtils {
    public static final int $stable = 0;
    public static final StringUtils INSTANCE = new StringUtils();

    private StringUtils() {
    }

    public final String hexFromArgb(int argb) {
        int red = ColorUtils.INSTANCE.redFromArgb(argb);
        int blue = ColorUtils.INSTANCE.blueFromArgb(argb);
        int green = ColorUtils.INSTANCE.greenFromArgb(argb);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("#%02x%02x%02x", Arrays.copyOf(new Object[]{Integer.valueOf(red), Integer.valueOf(green), Integer.valueOf(blue)}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
