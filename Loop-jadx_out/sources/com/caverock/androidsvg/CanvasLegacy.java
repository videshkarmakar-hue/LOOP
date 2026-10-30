package com.caverock.androidsvg;

import android.graphics.Canvas;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class CanvasLegacy {
    static final int MATRIX_SAVE_FLAG;
    private static final Method SAVE;

    CanvasLegacy() {
    }

    static {
        try {
            MATRIX_SAVE_FLAG = ((Integer) Canvas.class.getField("MATRIX_SAVE_FLAG").get(null)).intValue();
            SAVE = Canvas.class.getMethod("save", Integer.TYPE);
        } catch (Throwable e) {
            throw sneakyThrow(e);
        }
    }

    static void save(Canvas canvas, int saveFlags) {
        try {
            SAVE.invoke(canvas, Integer.valueOf(saveFlags));
        } catch (Throwable e) {
            throw sneakyThrow(e);
        }
    }

    private static RuntimeException sneakyThrow(Throwable t) {
        if (t == null) {
            throw new NullPointerException("t");
        }
        return (RuntimeException) sneakyThrow0(t);
    }

    private static <T extends Throwable> T sneakyThrow0(Throwable t) throws Throwable {
        throw t;
    }
}
