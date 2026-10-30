package com.videshkarmakar.loop.util;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.p006ui.common.Route;
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
@Metadata(m194d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b;\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 g2\u00020\u0001:\u0002fgBù\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0001\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010\u001eBû\u0001\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u001fJ\u0011\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010D\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010I\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010J\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010K\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010L\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010M\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010U\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010!J\u0084\u0002\u0010V\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010WJ\u0013\u0010X\u001a\u00020Y2\b\u0010Z\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010[\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\\\u001a\u00020\u0006J\t\u0010]\u001a\u00020\bHÖ\u0001J&\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020\u00002\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020dHÁ\u0001¢\u0006\u0002\beR\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010$\u001a\u0004\b(\u0010&R\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R \u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\"\u0012\u0004\b*\u0010$\u001a\u0004\b+\u0010!R \u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\"\u0012\u0004\b,\u0010$\u001a\u0004\b-\u0010!R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010&R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b/\u0010&R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010$\u001a\u0004\b1\u0010&R\u001e\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010$\u001a\u0004\b3\u0010&R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b4\u0010!R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b5\u0010!R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010$\u001a\u0004\b7\u00108R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b9\u0010&R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b:\u0010!R\u0013\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b;\u0010&R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b<\u0010!R\u001e\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b=\u0010$\u001a\u0004\b>\u0010&R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b?\u0010$\u001a\u0004\b@\u0010&R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\"\u001a\u0004\bA\u0010!¨\u0006h"}, m195d2 = {"Lcom/videshkarmakar/loop/util/RequestedDownload;", "", "seen1", "", "requestedFormats", "", "Lcom/videshkarmakar/loop/util/Format;", "formatId", "", "formatNote", "ext", "acodec", "vcodec", "url", "width", "", "height", "fps", "audioExt", "videoExt", Route.FORMAT_SELECTION, "resolution", "vbr", "abr", "tbr", "fileSize", "fileSizeApprox", "filename", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)V", "getAbr", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getAcodec$annotations", "()V", "getAcodec", "()Ljava/lang/String;", "getAudioExt$annotations", "getAudioExt", "getExt", "getFileSize$annotations", "getFileSize", "getFileSizeApprox$annotations", "getFileSizeApprox", "getFilename", "getFormat", "getFormatId$annotations", "getFormatId", "getFormatNote$annotations", "getFormatNote", "getFps", "getHeight", "getRequestedFormats$annotations", "getRequestedFormats", "()Ljava/util/List;", "getResolution", "getTbr", "getUrl", "getVbr", "getVcodec$annotations", "getVcodec", "getVideoExt$annotations", "getVideoExt", "getWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)Lcom/videshkarmakar/loop/util/RequestedDownload;", "equals", "", "other", "hashCode", "toFormat", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_debug", "$serializer", "Companion", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
public final /* data */ class RequestedDownload {
    private final Double abr;
    private final String acodec;
    private final String audioExt;
    private final String ext;
    private final Double fileSize;
    private final Double fileSizeApprox;
    private final String filename;
    private final String format;
    private final String formatId;
    private final String formatNote;
    private final Double fps;
    private final Double height;
    private final List<Format> requestedFormats;
    private final String resolution;
    private final Double tbr;
    private final String url;
    private final Double vbr;
    private final String vcodec;
    private final String videoExt;
    private final Double width;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(Format$$serializer.INSTANCE), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};

    public RequestedDownload() {
        this((List) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Double) null, (Double) null, (Double) null, (String) null, (String) null, (String) null, (String) null, (Double) null, (Double) null, (Double) null, (Double) null, (Double) null, (String) null, 1048575, (DefaultConstructorMarker) null);
    }

    @SerialName("acodec")
    public static /* synthetic */ void getAcodec$annotations() {
    }

    @SerialName("audio_ext")
    public static /* synthetic */ void getAudioExt$annotations() {
    }

    @SerialName("filesize")
    public static /* synthetic */ void getFileSize$annotations() {
    }

    @SerialName("filesize_approx")
    public static /* synthetic */ void getFileSizeApprox$annotations() {
    }

    @SerialName("format_id")
    public static /* synthetic */ void getFormatId$annotations() {
    }

    @SerialName("format_note")
    public static /* synthetic */ void getFormatNote$annotations() {
    }

    @SerialName("requested_formats")
    public static /* synthetic */ void getRequestedFormats$annotations() {
    }

    @SerialName("vcodec")
    public static /* synthetic */ void getVcodec$annotations() {
    }

    @SerialName("video_ext")
    public static /* synthetic */ void getVideoExt$annotations() {
    }

    public final List<Format> component1() {
        return this.requestedFormats;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Double getFps() {
        return this.fps;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getAudioExt() {
        return this.audioExt;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getVideoExt() {
        return this.videoExt;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getFormat() {
        return this.format;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getResolution() {
        return this.resolution;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Double getVbr() {
        return this.vbr;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Double getAbr() {
        return this.abr;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Double getTbr() {
        return this.tbr;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final Double getFileSize() {
        return this.fileSize;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final Double getFileSizeApprox() {
        return this.fileSizeApprox;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFormatId() {
        return this.formatId;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getFilename() {
        return this.filename;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFormatNote() {
        return this.formatNote;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getExt() {
        return this.ext;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAcodec() {
        return this.acodec;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getVcodec() {
        return this.vcodec;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Double getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Double getHeight() {
        return this.height;
    }

    public final RequestedDownload copy(List<Format> requestedFormats, String formatId, String formatNote, String ext, String acodec, String vcodec, String url, Double width, Double height, Double fps, String audioExt, String videoExt, String format, String resolution, Double vbr, Double abr, Double tbr, Double fileSize, Double fileSizeApprox, String filename) {
        return new RequestedDownload(requestedFormats, formatId, formatNote, ext, acodec, vcodec, url, width, height, fps, audioExt, videoExt, format, resolution, vbr, abr, tbr, fileSize, fileSizeApprox, filename);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequestedDownload)) {
            return false;
        }
        RequestedDownload requestedDownload = (RequestedDownload) other;
        return Intrinsics.areEqual(this.requestedFormats, requestedDownload.requestedFormats) && Intrinsics.areEqual(this.formatId, requestedDownload.formatId) && Intrinsics.areEqual(this.formatNote, requestedDownload.formatNote) && Intrinsics.areEqual(this.ext, requestedDownload.ext) && Intrinsics.areEqual(this.acodec, requestedDownload.acodec) && Intrinsics.areEqual(this.vcodec, requestedDownload.vcodec) && Intrinsics.areEqual(this.url, requestedDownload.url) && Intrinsics.areEqual((Object) this.width, (Object) requestedDownload.width) && Intrinsics.areEqual((Object) this.height, (Object) requestedDownload.height) && Intrinsics.areEqual((Object) this.fps, (Object) requestedDownload.fps) && Intrinsics.areEqual(this.audioExt, requestedDownload.audioExt) && Intrinsics.areEqual(this.videoExt, requestedDownload.videoExt) && Intrinsics.areEqual(this.format, requestedDownload.format) && Intrinsics.areEqual(this.resolution, requestedDownload.resolution) && Intrinsics.areEqual((Object) this.vbr, (Object) requestedDownload.vbr) && Intrinsics.areEqual((Object) this.abr, (Object) requestedDownload.abr) && Intrinsics.areEqual((Object) this.tbr, (Object) requestedDownload.tbr) && Intrinsics.areEqual((Object) this.fileSize, (Object) requestedDownload.fileSize) && Intrinsics.areEqual((Object) this.fileSizeApprox, (Object) requestedDownload.fileSizeApprox) && Intrinsics.areEqual(this.filename, requestedDownload.filename);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((this.requestedFormats == null ? 0 : this.requestedFormats.hashCode()) * 31) + (this.formatId == null ? 0 : this.formatId.hashCode())) * 31) + (this.formatNote == null ? 0 : this.formatNote.hashCode())) * 31) + (this.ext == null ? 0 : this.ext.hashCode())) * 31) + (this.acodec == null ? 0 : this.acodec.hashCode())) * 31) + (this.vcodec == null ? 0 : this.vcodec.hashCode())) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.width == null ? 0 : this.width.hashCode())) * 31) + (this.height == null ? 0 : this.height.hashCode())) * 31) + (this.fps == null ? 0 : this.fps.hashCode())) * 31) + (this.audioExt == null ? 0 : this.audioExt.hashCode())) * 31) + (this.videoExt == null ? 0 : this.videoExt.hashCode())) * 31) + (this.format == null ? 0 : this.format.hashCode())) * 31) + (this.resolution == null ? 0 : this.resolution.hashCode())) * 31) + (this.vbr == null ? 0 : this.vbr.hashCode())) * 31) + (this.abr == null ? 0 : this.abr.hashCode())) * 31) + (this.tbr == null ? 0 : this.tbr.hashCode())) * 31) + (this.fileSize == null ? 0 : this.fileSize.hashCode())) * 31) + (this.fileSizeApprox == null ? 0 : this.fileSizeApprox.hashCode())) * 31) + (this.filename != null ? this.filename.hashCode() : 0);
    }

    public String toString() {
        return "RequestedDownload(requestedFormats=" + this.requestedFormats + ", formatId=" + this.formatId + ", formatNote=" + this.formatNote + ", ext=" + this.ext + ", acodec=" + this.acodec + ", vcodec=" + this.vcodec + ", url=" + this.url + ", width=" + this.width + ", height=" + this.height + ", fps=" + this.fps + ", audioExt=" + this.audioExt + ", videoExt=" + this.videoExt + ", format=" + this.format + ", resolution=" + this.resolution + ", vbr=" + this.vbr + ", abr=" + this.abr + ", tbr=" + this.tbr + ", fileSize=" + this.fileSize + ", fileSizeApprox=" + this.fileSizeApprox + ", filename=" + this.filename + ")";
    }

    /* JADX INFO: compiled from: VideoInfo.kt */
    @Metadata(m194d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m195d2 = {"Lcom/videshkarmakar/loop/util/RequestedDownload$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/videshkarmakar/loop/util/RequestedDownload;", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<RequestedDownload> serializer() {
            return RequestedDownload$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ RequestedDownload(int seen1, @SerialName("requested_formats") List requestedFormats, @SerialName("format_id") String formatId, @SerialName("format_note") String formatNote, String ext, @SerialName("acodec") String acodec, @SerialName("vcodec") String vcodec, String url, Double width, Double height, Double fps, @SerialName("audio_ext") String audioExt, @SerialName("video_ext") String videoExt, String format, String resolution, Double vbr, Double abr, Double tbr, @SerialName("filesize") Double fileSize, @SerialName("filesize_approx") Double fileSizeApprox, String filename, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen1 & 1) == 0) {
            this.requestedFormats = CollectionsKt.emptyList();
        } else {
            this.requestedFormats = requestedFormats;
        }
        if ((seen1 & 2) == 0) {
            this.formatId = null;
        } else {
            this.formatId = formatId;
        }
        if ((seen1 & 4) == 0) {
            this.formatNote = null;
        } else {
            this.formatNote = formatNote;
        }
        if ((seen1 & 8) == 0) {
            this.ext = null;
        } else {
            this.ext = ext;
        }
        if ((seen1 & 16) == 0) {
            this.acodec = null;
        } else {
            this.acodec = acodec;
        }
        if ((seen1 & 32) == 0) {
            this.vcodec = null;
        } else {
            this.vcodec = vcodec;
        }
        if ((seen1 & 64) == 0) {
            this.url = null;
        } else {
            this.url = url;
        }
        if ((seen1 & 128) == 0) {
            this.width = null;
        } else {
            this.width = width;
        }
        if ((seen1 & 256) == 0) {
            this.height = null;
        } else {
            this.height = height;
        }
        if ((seen1 & 512) == 0) {
            this.fps = null;
        } else {
            this.fps = fps;
        }
        if ((seen1 & 1024) == 0) {
            this.audioExt = null;
        } else {
            this.audioExt = audioExt;
        }
        if ((seen1 & 2048) == 0) {
            this.videoExt = null;
        } else {
            this.videoExt = videoExt;
        }
        if ((seen1 & 4096) == 0) {
            this.format = null;
        } else {
            this.format = format;
        }
        if ((seen1 & 8192) == 0) {
            this.resolution = null;
        } else {
            this.resolution = resolution;
        }
        if ((seen1 & 16384) == 0) {
            this.vbr = null;
        } else {
            this.vbr = vbr;
        }
        if ((seen1 & 32768) == 0) {
            this.abr = null;
        } else {
            this.abr = abr;
        }
        if ((seen1 & 65536) == 0) {
            this.tbr = null;
        } else {
            this.tbr = tbr;
        }
        if ((seen1 & 131072) == 0) {
            this.fileSize = null;
        } else {
            this.fileSize = fileSize;
        }
        if ((seen1 & 262144) == 0) {
            this.fileSizeApprox = null;
        } else {
            this.fileSizeApprox = fileSizeApprox;
        }
        if ((seen1 & 524288) == 0) {
            this.filename = null;
        } else {
            this.filename = filename;
        }
    }

    public RequestedDownload(List<Format> list, String formatId, String formatNote, String ext, String acodec, String vcodec, String url, Double width, Double height, Double fps, String audioExt, String videoExt, String format, String resolution, Double vbr, Double abr, Double tbr, Double fileSize, Double fileSizeApprox, String filename) {
        this.requestedFormats = list;
        this.formatId = formatId;
        this.formatNote = formatNote;
        this.ext = ext;
        this.acodec = acodec;
        this.vcodec = vcodec;
        this.url = url;
        this.width = width;
        this.height = height;
        this.fps = fps;
        this.audioExt = audioExt;
        this.videoExt = videoExt;
        this.format = format;
        this.resolution = resolution;
        this.vbr = vbr;
        this.abr = abr;
        this.tbr = tbr;
        this.fileSize = fileSize;
        this.fileSizeApprox = fileSizeApprox;
        this.filename = filename;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_debug(RequestedDownload self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        boolean z = output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.requestedFormats, CollectionsKt.emptyList());
        if (z) {
            output.encodeNullableSerializableElement(serialDesc, 0, kSerializerArr[0], self.requestedFormats);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.formatId != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.formatId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.formatNote != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.formatNote);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.ext != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.ext);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.acodec != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.acodec);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.vcodec != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.vcodec);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.url != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.url);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.width != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, DoubleSerializer.INSTANCE, self.width);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.height != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, DoubleSerializer.INSTANCE, self.height);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.fps != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, DoubleSerializer.INSTANCE, self.fps);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.audioExt != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.audioExt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.videoExt != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.videoExt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.format != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.format);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.resolution != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.resolution);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.vbr != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, DoubleSerializer.INSTANCE, self.vbr);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.abr != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, DoubleSerializer.INSTANCE, self.abr);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.tbr != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, DoubleSerializer.INSTANCE, self.tbr);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.fileSize != null) {
            output.encodeNullableSerializableElement(serialDesc, 17, DoubleSerializer.INSTANCE, self.fileSize);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) || self.fileSizeApprox != null) {
            output.encodeNullableSerializableElement(serialDesc, 18, DoubleSerializer.INSTANCE, self.fileSizeApprox);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 19) || self.filename != null) {
            output.encodeNullableSerializableElement(serialDesc, 19, StringSerializer.INSTANCE, self.filename);
        }
    }

    public /* synthetic */ RequestedDownload(List list, String str, String str2, String str3, String str4, String str5, String str6, Double d, Double d2, Double d3, String str7, String str8, String str9, String str10, Double d4, Double d5, Double d6, Double d7, Double d8, String str11, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : d, (i & 256) != 0 ? null : d2, (i & 512) != 0 ? null : d3, (i & 1024) != 0 ? null : str7, (i & 2048) != 0 ? null : str8, (i & 4096) != 0 ? null : str9, (i & 8192) != 0 ? null : str10, (i & 16384) != 0 ? null : d4, (i & 32768) != 0 ? null : d5, (i & 65536) != 0 ? null : d6, (i & 131072) != 0 ? null : d7, (i & 262144) != 0 ? null : d8, (i & 524288) != 0 ? null : str11);
    }

    public final List<Format> getRequestedFormats() {
        return this.requestedFormats;
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

    public final String getAcodec() {
        return this.acodec;
    }

    public final String getVcodec() {
        return this.vcodec;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Double getWidth() {
        return this.width;
    }

    public final Double getHeight() {
        return this.height;
    }

    public final Double getFps() {
        return this.fps;
    }

    public final String getAudioExt() {
        return this.audioExt;
    }

    public final String getVideoExt() {
        return this.videoExt;
    }

    public final String getFormat() {
        return this.format;
    }

    public final String getResolution() {
        return this.resolution;
    }

    public final Double getVbr() {
        return this.vbr;
    }

    public final Double getAbr() {
        return this.abr;
    }

    public final Double getTbr() {
        return this.tbr;
    }

    public final Double getFileSize() {
        return this.fileSize;
    }

    public final Double getFileSizeApprox() {
        return this.fileSizeApprox;
    }

    public final String getFilename() {
        return this.filename;
    }

    public final Format toFormat() {
        return new Format(this.formatId, this.formatNote, this.ext, this.acodec, this.vcodec, this.url, this.width, this.height, this.fps, this.audioExt, this.videoExt, this.format, this.resolution, this.vbr, this.abr, this.tbr, this.fileSize, this.fileSizeApprox);
    }
}
