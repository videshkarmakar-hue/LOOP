package com.yausername.youtubedl_android.mapper;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.videshkarmakar.loop.p006ui.common.Route;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: VideoInfo.kt */
/* JADX INFO: loaded from: classes18.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
@Metadata(m194d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R%\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0006R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0006R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0006R\u0014\u0010\u0012\u001a\u00020\u0013X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0006R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0006R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0006R\u0016\u0010\u001c\u001a\u00020\u001d8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u001d8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0013\u0010\"\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0006R\u0018\u0010$\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0006R%\u0010&\u001a\u0016\u0012\u0004\u0012\u00020'\u0018\u00010\bj\n\u0012\u0004\u0012\u00020'\u0018\u0001`\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u000bR\u0013\u0010)\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0006R\u0014\u0010+\u001a\u00020\u0013X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0015R$\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010.8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u00101\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0006R\u0013\u00103\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0006R\u0018\u00105\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0006R\u0018\u00107\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0006R\u0018\u00109\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0006R\u0018\u0010;\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0006R*\u0010=\u001a\u0016\u0012\u0004\u0012\u00020'\u0018\u00010\bj\n\u0012\u0004\u0012\u00020'\u0018\u0001`\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u000bR\u0013\u0010?\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0006R%\u0010A\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\t¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u000bR\u0013\u0010C\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u0006R%\u0010E\u001a\u0016\u0012\u0004\u0012\u00020F\u0018\u00010\bj\n\u0012\u0004\u0012\u00020F\u0018\u0001`\t¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u000bR\u0013\u0010H\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0006R\u0018\u0010J\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\u0006R\u0013\u0010L\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\u0006R\u0018\u0010N\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u0006R\u0013\u0010P\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u0006R\u0018\u0010R\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u0006R\u0018\u0010T\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u0006R\u0018\u0010V\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010\u0006R\u0014\u0010X\u001a\u00020\u0013X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bY\u0010\u0015¨\u0006Z"}, m195d2 = {"Lcom/yausername/youtubedl_android/mapper/VideoInfo;", "", "()V", "averageRating", "", "getAverageRating", "()Ljava/lang/String;", "categories", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCategories", "()Ljava/util/ArrayList;", "description", "getDescription", "dislikeCount", "getDislikeCount", "displayId", "getDisplayId", "duration", "", "getDuration", "()I", "ext", "getExt", "extractor", "getExtractor", "extractorKey", "getExtractorKey", "fileSize", "", "getFileSize", "()J", "fileSizeApproximate", "getFileSizeApproximate", Route.FORMAT_SELECTION, "getFormat", "formatId", "getFormatId", "formats", "Lcom/yausername/youtubedl_android/mapper/VideoFormat;", "getFormats", "fulltitle", "getFulltitle", "height", "getHeight", "httpHeaders", "", "getHttpHeaders", "()Ljava/util/Map;", "id", "getId", "license", "getLicense", "likeCount", "getLikeCount", "manifestUrl", "getManifestUrl", "playerUrl", "getPlayerUrl", "repostCount", "getRepostCount", "requestedFormats", "getRequestedFormats", "resolution", "getResolution", "tags", "getTags", "thumbnail", "getThumbnail", "thumbnails", "Lcom/yausername/youtubedl_android/mapper/VideoThumbnail;", "getThumbnails", "title", "getTitle", "uploadDate", "getUploadDate", "uploader", "getUploader", "uploaderId", "getUploaderId", "url", "getUrl", "viewCount", "getViewCount", "webpageUrl", "getWebpageUrl", "webpageUrlBasename", "getWebpageUrlBasename", "width", "getWidth", "library_release"}, m196k = 1, m197mv = {1, 7, 1}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class VideoInfo {

    @JsonProperty("average_rating")
    private final String averageRating;
    private final ArrayList<String> categories;
    private final String description;

    @JsonProperty("dislike_count")
    private final String dislikeCount;

    @JsonProperty("display_id")
    private final String displayId;
    private final int duration;
    private final String ext;
    private final String extractor;

    @JsonProperty("extractor_key")
    private final String extractorKey;

    @JsonProperty("filesize")
    private final long fileSize;

    @JsonProperty("filesize_approx")
    private final long fileSizeApproximate;
    private final String format;

    @JsonProperty("format_id")
    private final String formatId;
    private final ArrayList<VideoFormat> formats;
    private final String fulltitle;
    private final int height;

    @JsonProperty("http_headers")
    private final Map<String, String> httpHeaders;
    private final String id;
    private final String license;

    @JsonProperty("like_count")
    private final String likeCount;

    @JsonProperty("manifest_url")
    private final String manifestUrl;

    @JsonProperty("player_url")
    private final String playerUrl;

    @JsonProperty("repost_count")
    private final String repostCount;

    @JsonProperty("requested_formats")
    private final ArrayList<VideoFormat> requestedFormats;
    private final String resolution;
    private final ArrayList<String> tags;
    private final String thumbnail;
    private final ArrayList<VideoThumbnail> thumbnails;
    private final String title;

    @JsonProperty("upload_date")
    private final String uploadDate;
    private final String uploader;

    @JsonProperty("uploader_id")
    private final String uploaderId;
    private final String url;

    @JsonProperty("view_count")
    private final String viewCount;

    @JsonProperty("webpage_url")
    private final String webpageUrl;

    @JsonProperty("webpage_url_basename")
    private final String webpageUrlBasename;
    private final int width;

    public final String getId() {
        return this.id;
    }

    public final String getFulltitle() {
        return this.fulltitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUploadDate() {
        return this.uploadDate;
    }

    public final String getDisplayId() {
        return this.displayId;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final String getLicense() {
        return this.license;
    }

    public final String getExtractor() {
        return this.extractor;
    }

    public final String getExtractorKey() {
        return this.extractorKey;
    }

    public final String getViewCount() {
        return this.viewCount;
    }

    public final String getLikeCount() {
        return this.likeCount;
    }

    public final String getDislikeCount() {
        return this.dislikeCount;
    }

    public final String getRepostCount() {
        return this.repostCount;
    }

    public final String getAverageRating() {
        return this.averageRating;
    }

    public final String getUploaderId() {
        return this.uploaderId;
    }

    public final String getUploader() {
        return this.uploader;
    }

    public final String getPlayerUrl() {
        return this.playerUrl;
    }

    public final String getWebpageUrl() {
        return this.webpageUrl;
    }

    public final String getWebpageUrlBasename() {
        return this.webpageUrlBasename;
    }

    public final String getResolution() {
        return this.resolution;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getFormat() {
        return this.format;
    }

    public final String getFormatId() {
        return this.formatId;
    }

    public final String getExt() {
        return this.ext;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final long getFileSizeApproximate() {
        return this.fileSizeApproximate;
    }

    public final Map<String, String> getHttpHeaders() {
        return this.httpHeaders;
    }

    public final ArrayList<String> getCategories() {
        return this.categories;
    }

    public final ArrayList<String> getTags() {
        return this.tags;
    }

    public final ArrayList<VideoFormat> getRequestedFormats() {
        return this.requestedFormats;
    }

    public final ArrayList<VideoFormat> getFormats() {
        return this.formats;
    }

    public final ArrayList<VideoThumbnail> getThumbnails() {
        return this.thumbnails;
    }

    public final String getManifestUrl() {
        return this.manifestUrl;
    }

    public final String getUrl() {
        return this.url;
    }
}
