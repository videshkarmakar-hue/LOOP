package com.videshkarmakar.loop.util;

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

/* JADX INFO: compiled from: VideoInfo.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m194d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002#$B3\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\fJ\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J&\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!HÁ\u0001¢\u0006\u0002\b\"R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006%"}, m195d2 = {"Lcom/videshkarmakar/loop/util/Thumbnail;", "", "seen1", "", "url", "", "height", "", "width", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;DDLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;DD)V", "getHeight", "()D", "getUrl", "()Ljava/lang/String;", "getWidth", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_debug", "$serializer", "Companion", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
public final /* data */ class Thumbnail {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final double height;
    private final String url;
    private final double width;

    public static /* synthetic */ Thumbnail copy$default(Thumbnail thumbnail, String str, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = thumbnail.url;
        }
        if ((i & 2) != 0) {
            d = thumbnail.height;
        }
        double d3 = d;
        if ((i & 4) != 0) {
            d2 = thumbnail.width;
        }
        return thumbnail.copy(str, d3, d2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final double getWidth() {
        return this.width;
    }

    public final Thumbnail copy(String url, double height, double width) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new Thumbnail(url, height, width);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Thumbnail)) {
            return false;
        }
        Thumbnail thumbnail = (Thumbnail) other;
        return Intrinsics.areEqual(this.url, thumbnail.url) && Double.compare(this.height, thumbnail.height) == 0 && Double.compare(this.width, thumbnail.width) == 0;
    }

    public int hashCode() {
        return (((this.url.hashCode() * 31) + Thumbnail$$ExternalSyntheticBackport0.m191m(this.height)) * 31) + Thumbnail$$ExternalSyntheticBackport0.m191m(this.width);
    }

    public String toString() {
        return "Thumbnail(url=" + this.url + ", height=" + this.height + ", width=" + this.width + ")";
    }

    /* JADX INFO: compiled from: VideoInfo.kt */
    @Metadata(m194d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m195d2 = {"Lcom/videshkarmakar/loop/util/Thumbnail$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/videshkarmakar/loop/util/Thumbnail;", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Thumbnail> serializer() {
            return Thumbnail$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ Thumbnail(int seen1, String url, double height, double width, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen1 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 1, Thumbnail$$serializer.INSTANCE.getDescriptor());
        }
        this.url = url;
        if ((seen1 & 2) == 0) {
            this.height = 0.0d;
        } else {
            this.height = height;
        }
        if ((seen1 & 4) == 0) {
            this.width = 0.0d;
        } else {
            this.width = width;
        }
    }

    public Thumbnail(String url, double height, double width) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.height = height;
        this.width = width;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_debug(Thumbnail self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean z = false;
        output.encodeStringElement(serialDesc, 0, self.url);
        boolean z2 = output.shouldEncodeElementDefault(serialDesc, 1) || Double.compare(self.height, 0.0d) != 0;
        if (z2) {
            output.encodeDoubleElement(serialDesc, 1, self.height);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || Double.compare(self.width, 0.0d) != 0) {
            z = true;
        }
        if (z) {
            output.encodeDoubleElement(serialDesc, 2, self.width);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ Thumbnail(String str, double d, double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        double d3;
        double d4;
        if ((i & 2) == 0) {
            d3 = d;
        } else {
            d3 = 0.0d;
        }
        if ((i & 4) == 0) {
            d4 = d2;
        } else {
            d4 = 0.0d;
        }
        this(str, d3, d4);
    }

    public final String getUrl() {
        return this.url;
    }

    public final double getHeight() {
        return this.height;
    }

    public final double getWidth() {
        return this.width;
    }
}
