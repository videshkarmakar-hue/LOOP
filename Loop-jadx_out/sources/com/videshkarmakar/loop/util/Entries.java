package com.videshkarmakar.loop.util;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.caverock.androidsvg.SVGParser;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: VideoInfo.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m194d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 =2\u00020\u0001:\u0002<=B{\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013Bw\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f¢\u0006\u0002\u0010\u0014J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003J\u0080\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0003HÖ\u0001J\t\u00103\u001a\u00020\u0005HÖ\u0001J&\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:HÁ\u0001¢\u0006\u0002\b;R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016¨\u0006>"}, m195d2 = {"Lcom/videshkarmakar/loop/util/Entries;", "", "seen1", "", SVGParser.XML_STYLESHEET_ATTR_TYPE, "", "ieKey", "id", "url", "title", "duration", "", "uploader", "channel", "thumbnails", "", "Lcom/videshkarmakar/loop/util/Thumbnail;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getChannel", "()Ljava/lang/String;", "getDuration", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getId", "getIeKey", "getThumbnails", "()Ljava/util/List;", "getTitle", "getType$annotations", "()V", "getType", "getUploader", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/videshkarmakar/loop/util/Entries;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_debug", "$serializer", "Companion", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
public final /* data */ class Entries {
    private final String channel;
    private final Double duration;
    private final String id;
    private final String ieKey;
    private final List<Thumbnail> thumbnails;
    private final String title;
    private final String type;
    private final String uploader;
    private final String url;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, new ArrayListSerializer(Thumbnail$$serializer.INSTANCE)};

    public Entries() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (Double) null, (String) null, (String) null, (List) null, 511, (DefaultConstructorMarker) null);
    }

    @SerialName("_type")
    public static /* synthetic */ void getType$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getIeKey() {
        return this.ieKey;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Double getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getUploader() {
        return this.uploader;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getChannel() {
        return this.channel;
    }

    public final List<Thumbnail> component9() {
        return this.thumbnails;
    }

    public final Entries copy(String type, String ieKey, String id, String url, String title, Double duration, String uploader, String channel, List<Thumbnail> thumbnails) {
        return new Entries(type, ieKey, id, url, title, duration, uploader, channel, thumbnails);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Entries)) {
            return false;
        }
        Entries entries = (Entries) other;
        return Intrinsics.areEqual(this.type, entries.type) && Intrinsics.areEqual(this.ieKey, entries.ieKey) && Intrinsics.areEqual(this.id, entries.id) && Intrinsics.areEqual(this.url, entries.url) && Intrinsics.areEqual(this.title, entries.title) && Intrinsics.areEqual((Object) this.duration, (Object) entries.duration) && Intrinsics.areEqual(this.uploader, entries.uploader) && Intrinsics.areEqual(this.channel, entries.channel) && Intrinsics.areEqual(this.thumbnails, entries.thumbnails);
    }

    public int hashCode() {
        return ((((((((((((((((this.type == null ? 0 : this.type.hashCode()) * 31) + (this.ieKey == null ? 0 : this.ieKey.hashCode())) * 31) + (this.id == null ? 0 : this.id.hashCode())) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.duration == null ? 0 : this.duration.hashCode())) * 31) + (this.uploader == null ? 0 : this.uploader.hashCode())) * 31) + (this.channel == null ? 0 : this.channel.hashCode())) * 31) + (this.thumbnails != null ? this.thumbnails.hashCode() : 0);
    }

    public String toString() {
        return "Entries(type=" + this.type + ", ieKey=" + this.ieKey + ", id=" + this.id + ", url=" + this.url + ", title=" + this.title + ", duration=" + this.duration + ", uploader=" + this.uploader + ", channel=" + this.channel + ", thumbnails=" + this.thumbnails + ")";
    }

    /* JADX INFO: compiled from: VideoInfo.kt */
    @Metadata(m194d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m195d2 = {"Lcom/videshkarmakar/loop/util/Entries$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/videshkarmakar/loop/util/Entries;", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Entries> serializer() {
            return Entries$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ Entries(int seen1, @SerialName("_type") String type, String ieKey, String id, String url, String title, Double duration, String uploader, String channel, List thumbnails, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen1 & 1) == 0) {
            this.type = null;
        } else {
            this.type = type;
        }
        if ((seen1 & 2) == 0) {
            this.ieKey = null;
        } else {
            this.ieKey = ieKey;
        }
        if ((seen1 & 4) == 0) {
            this.id = null;
        } else {
            this.id = id;
        }
        if ((seen1 & 8) == 0) {
            this.url = null;
        } else {
            this.url = url;
        }
        if ((seen1 & 16) == 0) {
            this.title = null;
        } else {
            this.title = title;
        }
        if ((seen1 & 32) == 0) {
            this.duration = Double.valueOf(0.0d);
        } else {
            this.duration = duration;
        }
        if ((seen1 & 64) == 0) {
            this.uploader = null;
        } else {
            this.uploader = uploader;
        }
        if ((seen1 & 128) == 0) {
            this.channel = null;
        } else {
            this.channel = channel;
        }
        if ((seen1 & 256) == 0) {
            this.thumbnails = CollectionsKt.emptyList();
        } else {
            this.thumbnails = thumbnails;
        }
    }

    public Entries(String type, String ieKey, String id, String url, String title, Double duration, String uploader, String channel, List<Thumbnail> list) {
        this.type = type;
        this.ieKey = ieKey;
        this.id = id;
        this.url = url;
        this.title = title;
        this.duration = duration;
        this.uploader = uploader;
        this.channel = channel;
        this.thumbnails = list;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_debug(Entries self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        boolean z = false;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.type != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.type);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.ieKey != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.ieKey);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.id != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.id);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.url != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.url);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.title != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.title);
        }
        boolean z2 = output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual((Object) self.duration, (Object) Double.valueOf(0.0d));
        if (z2) {
            output.encodeNullableSerializableElement(serialDesc, 5, DoubleSerializer.INSTANCE, self.duration);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.uploader != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.uploader);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.channel != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.channel);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || !Intrinsics.areEqual(self.thumbnails, CollectionsKt.emptyList())) {
            z = true;
        }
        if (z) {
            output.encodeNullableSerializableElement(serialDesc, 8, kSerializerArr[8], self.thumbnails);
        }
    }

    public /* synthetic */ Entries(String str, String str2, String str3, String str4, String str5, Double d, String str6, String str7, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? Double.valueOf(0.0d) : d, (i & 64) != 0 ? null : str6, (i & 128) == 0 ? str7 : null, (i & 256) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getType() {
        return this.type;
    }

    public final String getIeKey() {
        return this.ieKey;
    }

    public final String getId() {
        return this.id;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Double getDuration() {
        return this.duration;
    }

    public final String getUploader() {
        return this.uploader;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final List<Thumbnail> getThumbnails() {
        return this.thumbnails;
    }
}
