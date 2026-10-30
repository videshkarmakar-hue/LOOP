package com.videshkarmakar.loop.util;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: FileUtil.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m195d2 = {"AUDIO_REGEX", "", "PRIVATE_DIRECTORY_SUFFIX", "SUBTITLE_REGEX", "THUMBNAIL_REGEX", "app_debug"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FileUtilKt {
    public static final String AUDIO_REGEX = "(mp3|aac|opus|m4a)$";
    private static final String PRIVATE_DIRECTORY_SUFFIX = ".LOOP";
    public static final String SUBTITLE_REGEX = "\\.(lrc|vtt|srt|ass|json3|srv.|ttml)$";
    public static final String THUMBNAIL_REGEX = "\\.(jpg|png)$";
}
