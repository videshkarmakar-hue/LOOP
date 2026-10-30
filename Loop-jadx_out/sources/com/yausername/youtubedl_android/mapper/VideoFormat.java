package com.yausername.youtubedl_android.mapper;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.videshkarmakar.loop.p006ui.common.Route;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: VideoFormat.kt */
/* JADX INFO: loaded from: classes18.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
@Metadata(m194d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0013\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00108\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\nR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\nR\u0014\u0010\u001b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0014\u0010\u001d\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R$\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\nR\u0014\u0010%\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0006R\u0014\u0010'\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0006R\u0013\u0010)\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\nR\u0013\u0010+\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\nR\u0014\u0010-\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0006¨\u0006/"}, m195d2 = {"Lcom/yausername/youtubedl_android/mapper/VideoFormat;", "", "()V", "abr", "", "getAbr", "()I", "acodec", "", "getAcodec", "()Ljava/lang/String;", "asr", "getAsr", "ext", "getExt", "fileSize", "", "getFileSize", "()J", "fileSizeApproximate", "getFileSizeApproximate", Route.FORMAT_SELECTION, "getFormat", "formatId", "getFormatId", "formatNote", "getFormatNote", "fps", "getFps", "height", "getHeight", "httpHeaders", "", "getHttpHeaders", "()Ljava/util/Map;", "manifestUrl", "getManifestUrl", "preference", "getPreference", "tbr", "getTbr", "url", "getUrl", "vcodec", "getVcodec", "width", "getWidth", "library_release"}, m196k = 1, m197mv = {1, 7, 1}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class VideoFormat {
    private final int abr;
    private final String acodec;
    private final int asr;
    private final String ext;

    @JsonProperty("filesize")
    private final long fileSize;

    @JsonProperty("filesize_approx")
    private final long fileSizeApproximate;
    private final String format;

    @JsonProperty("format_id")
    private final String formatId;

    @JsonProperty("format_note")
    private final String formatNote;
    private final int fps;
    private final int height;

    @JsonProperty("http_headers")
    private final Map<String, String> httpHeaders;

    @JsonProperty("manifest_url")
    private final String manifestUrl;
    private final int preference;
    private final int tbr;
    private final String url;
    private final String vcodec;
    private final int width;

    public final int getAsr() {
        return this.asr;
    }

    public final int getTbr() {
        return this.tbr;
    }

    public final int getAbr() {
        return this.abr;
    }

    public final String getFormat() {
        return this.format;
    }

    public final String getFormatId() {
        return this.formatId;
    }

    public final String getFormatNote() {
        return this.formatNote;
    }

    public final String getExt() {
        return this.ext;
    }

    public final int getPreference() {
        return this.preference;
    }

    public final String getVcodec() {
        return this.vcodec;
    }

    public final String getAcodec() {
        return this.acodec;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final long getFileSizeApproximate() {
        return this.fileSizeApproximate;
    }

    public final int getFps() {
        return this.fps;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getManifestUrl() {
        return this.manifestUrl;
    }

    public final Map<String, String> getHttpHeaders() {
        return this.httpHeaders;
    }
}
