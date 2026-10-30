package com.google.android.material.textfield;

import android.widget.EditText;

/* JADX INFO: loaded from: classes18.dex */
class EditTextUtils {
    private EditTextUtils() {
    }

    static boolean isEditable(EditText editText) {
        return editText.getInputType() != 0;
    }
}
