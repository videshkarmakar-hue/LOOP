package com.yausername.youtubedl_android.mapper;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kotlin.Metadata;

/* JADX INFO: compiled from: VideoThumbnail.kt */
/* JADX INFO: loaded from: classes18.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
@Metadata(m194d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, m195d2 = {"Lcom/yausername/youtubedl_android/mapper/VideoThumbnail;", "", "()V", "id", "", "getId", "()Ljava/lang/String;", "url", "getUrl", "library_release"}, m196k = 1, m197mv = {1, 7, 1}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class VideoThumbnail {
    private final String id;
    private final String url;

    public final String getUrl() {
        return this.url;
    }

    public final String getId() {
        return this.id;
    }
}
