package com.videshkarmakar.loop.database.objects;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: DownloadedVideoInfo.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(m194d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0002/0B\u0007\b\u0017¢\u0006\u0002\u0010\u0002B]\b\u0011\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fB?\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007¢\u0006\u0002\u0010\u0010J\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003JO\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0004HÖ\u0001J\t\u0010&\u001a\u00020\u0007HÖ\u0001J&\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-HÁ\u0001¢\u0006\u0002\b.R\u0016\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012¨\u00061"}, m195d2 = {"Lcom/videshkarmakar/loop/database/objects/DownloadedVideoInfo;", "", "()V", "seen1", "", "id", "videoTitle", "", "videoAuthor", "videoUrl", "thumbnailUrl", "videoPath", "extractor", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getExtractor", "()Ljava/lang/String;", "getId", "()I", "getThumbnailUrl", "getVideoAuthor", "getVideoPath", "getVideoTitle", "getVideoUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_debug", "$serializer", "Companion", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
public final /* data */ class DownloadedVideoInfo {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String extractor;
    private final int id;
    private final String thumbnailUrl;
    private final String videoAuthor;
    private final String videoPath;
    private final String videoTitle;
    private final String videoUrl;

    public static /* synthetic */ DownloadedVideoInfo copy$default(DownloadedVideoInfo downloadedVideoInfo, int i, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = downloadedVideoInfo.id;
        }
        if ((i2 & 2) != 0) {
            str = downloadedVideoInfo.videoTitle;
        }
        String str7 = str;
        if ((i2 & 4) != 0) {
            str2 = downloadedVideoInfo.videoAuthor;
        }
        String str8 = str2;
        if ((i2 & 8) != 0) {
            str3 = downloadedVideoInfo.videoUrl;
        }
        String str9 = str3;
        if ((i2 & 16) != 0) {
            str4 = downloadedVideoInfo.thumbnailUrl;
        }
        String str10 = str4;
        if ((i2 & 32) != 0) {
            str5 = downloadedVideoInfo.videoPath;
        }
        String str11 = str5;
        if ((i2 & 64) != 0) {
            str6 = downloadedVideoInfo.extractor;
        }
        return downloadedVideoInfo.copy(i, str7, str8, str9, str10, str11, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getVideoTitle() {
        return this.videoTitle;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getVideoAuthor() {
        return this.videoAuthor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getVideoPath() {
        return this.videoPath;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getExtractor() {
        return this.extractor;
    }

    public final DownloadedVideoInfo copy(int id, String videoTitle, String videoAuthor, String videoUrl, String thumbnailUrl, String videoPath, String extractor) {
        Intrinsics.checkNotNullParameter(videoTitle, "videoTitle");
        Intrinsics.checkNotNullParameter(videoAuthor, "videoAuthor");
        Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
        Intrinsics.checkNotNullParameter(thumbnailUrl, "thumbnailUrl");
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        Intrinsics.checkNotNullParameter(extractor, "extractor");
        return new DownloadedVideoInfo(id, videoTitle, videoAuthor, videoUrl, thumbnailUrl, videoPath, extractor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadedVideoInfo)) {
            return false;
        }
        DownloadedVideoInfo downloadedVideoInfo = (DownloadedVideoInfo) other;
        return this.id == downloadedVideoInfo.id && Intrinsics.areEqual(this.videoTitle, downloadedVideoInfo.videoTitle) && Intrinsics.areEqual(this.videoAuthor, downloadedVideoInfo.videoAuthor) && Intrinsics.areEqual(this.videoUrl, downloadedVideoInfo.videoUrl) && Intrinsics.areEqual(this.thumbnailUrl, downloadedVideoInfo.thumbnailUrl) && Intrinsics.areEqual(this.videoPath, downloadedVideoInfo.videoPath) && Intrinsics.areEqual(this.extractor, downloadedVideoInfo.extractor);
    }

    public int hashCode() {
        return (((((((((((this.id * 31) + this.videoTitle.hashCode()) * 31) + this.videoAuthor.hashCode()) * 31) + this.videoUrl.hashCode()) * 31) + this.thumbnailUrl.hashCode()) * 31) + this.videoPath.hashCode()) * 31) + this.extractor.hashCode();
    }

    public String toString() {
        return "DownloadedVideoInfo(id=" + this.id + ", videoTitle=" + this.videoTitle + ", videoAuthor=" + this.videoAuthor + ", videoUrl=" + this.videoUrl + ", thumbnailUrl=" + this.thumbnailUrl + ", videoPath=" + this.videoPath + ", extractor=" + this.extractor + ")";
    }

    /* JADX INFO: compiled from: DownloadedVideoInfo.kt */
    @Metadata(m194d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m195d2 = {"Lcom/videshkarmakar/loop/database/objects/DownloadedVideoInfo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/videshkarmakar/loop/database/objects/DownloadedVideoInfo;", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DownloadedVideoInfo> serializer() {
            return DownloadedVideoInfo$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ DownloadedVideoInfo(int seen1, int id, String videoTitle, String videoAuthor, String videoUrl, String thumbnailUrl, String videoPath, String extractor, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (seen1 & 63)) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 63, DownloadedVideoInfo$$serializer.INSTANCE.getDescriptor());
        }
        this.id = id;
        this.videoTitle = videoTitle;
        this.videoAuthor = videoAuthor;
        this.videoUrl = videoUrl;
        this.thumbnailUrl = thumbnailUrl;
        this.videoPath = videoPath;
        if ((seen1 & 64) == 0) {
            this.extractor = "Unknown";
        } else {
            this.extractor = extractor;
        }
    }

    public DownloadedVideoInfo(int id, String videoTitle, String videoAuthor, String videoUrl, String thumbnailUrl, String videoPath, String extractor) {
        Intrinsics.checkNotNullParameter(videoTitle, "videoTitle");
        Intrinsics.checkNotNullParameter(videoAuthor, "videoAuthor");
        Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
        Intrinsics.checkNotNullParameter(thumbnailUrl, "thumbnailUrl");
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        Intrinsics.checkNotNullParameter(extractor, "extractor");
        this.id = id;
        this.videoTitle = videoTitle;
        this.videoAuthor = videoAuthor;
        this.videoUrl = videoUrl;
        this.thumbnailUrl = thumbnailUrl;
        this.videoPath = videoPath;
        this.extractor = extractor;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_debug(DownloadedVideoInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean z = false;
        output.encodeIntElement(serialDesc, 0, self.id);
        output.encodeStringElement(serialDesc, 1, self.videoTitle);
        output.encodeStringElement(serialDesc, 2, self.videoAuthor);
        output.encodeStringElement(serialDesc, 3, self.videoUrl);
        output.encodeStringElement(serialDesc, 4, self.thumbnailUrl);
        output.encodeStringElement(serialDesc, 5, self.videoPath);
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.extractor, "Unknown")) {
            z = true;
        }
        if (z) {
            output.encodeStringElement(serialDesc, 6, self.extractor);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DownloadedVideoInfo(int i, String str, String str2, String str3, String str4, String str5, String str6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        String str7;
        if ((i2 & 64) == 0) {
            str7 = str6;
        } else {
            str7 = "Unknown";
        }
        this(i, str, str2, str3, str4, str5, str7);
    }

    public final int getId() {
        return this.id;
    }

    public final String getVideoTitle() {
        return this.videoTitle;
    }

    public final String getVideoAuthor() {
        return this.videoAuthor;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public final String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public final String getVideoPath() {
        return this.videoPath;
    }

    public final String getExtractor() {
        return this.extractor;
    }

    public DownloadedVideoInfo() {
        this(0, "Video", "Author", "Url", "Thumbnail", "Path", "Unknown");
    }
}
