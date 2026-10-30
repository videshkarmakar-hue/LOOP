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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: VideoInfo.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m194d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 @2\u00020\u0001:\u0002?@B\u008b\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013B\u0083\u0001\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0014J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010-\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0087\u0001\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u00020\u0003HÖ\u0001J\t\u00106\u001a\u00020\u0005HÖ\u0001J&\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=HÁ\u0001¢\u0006\u0002\b>R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0016R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001f\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010\u0016¨\u0006A"}, m195d2 = {"Lcom/videshkarmakar/loop/util/PlaylistResult;", "Lcom/videshkarmakar/loop/util/YoutubeDLInfo;", "seen1", "", "uploader", "", "availability", "channel", "title", "description", SVGParser.XML_STYLESHEET_ATTR_TYPE, "entries", "", "Lcom/videshkarmakar/loop/util/Entries;", "webpageUrl", "originalUrl", "extractorKey", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvailability", "()Ljava/lang/String;", "getChannel", "getDescription", "getEntries", "()Ljava/util/List;", "getExtractorKey$annotations", "()V", "getExtractorKey", "getOriginalUrl$annotations", "getOriginalUrl", "getTitle", "getType$annotations", "getType", "getUploader", "getWebpageUrl$annotations", "getWebpageUrl", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_debug", "$serializer", "Companion", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
public final /* data */ class PlaylistResult implements YoutubeDLInfo {
    private final String availability;
    private final String channel;
    private final String description;
    private final List<Entries> entries;
    private final String extractorKey;
    private final String originalUrl;
    private final String title;
    private final String type;
    private final String uploader;
    private final String webpageUrl;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, new ArrayListSerializer(Entries$$serializer.INSTANCE), null, null, null};

    public PlaylistResult() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (String) null, (String) null, (String) null, 1023, (DefaultConstructorMarker) null);
    }

    @SerialName("extractor_key")
    public static /* synthetic */ void getExtractorKey$annotations() {
    }

    @SerialName("original_url")
    public static /* synthetic */ void getOriginalUrl$annotations() {
    }

    @SerialName("_type")
    public static /* synthetic */ void getType$annotations() {
    }

    @SerialName("webpage_url")
    public static /* synthetic */ void getWebpageUrl$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUploader() {
        return this.uploader;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getExtractorKey() {
        return this.extractorKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAvailability() {
        return this.availability;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final List<Entries> component7() {
        return this.entries;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getWebpageUrl() {
        return this.webpageUrl;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getOriginalUrl() {
        return this.originalUrl;
    }

    public final PlaylistResult copy(String uploader, String availability, String channel, String title, String description, String type, List<Entries> entries, String webpageUrl, String originalUrl, String extractorKey) {
        return new PlaylistResult(uploader, availability, channel, title, description, type, entries, webpageUrl, originalUrl, extractorKey);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlaylistResult)) {
            return false;
        }
        PlaylistResult playlistResult = (PlaylistResult) other;
        return Intrinsics.areEqual(this.uploader, playlistResult.uploader) && Intrinsics.areEqual(this.availability, playlistResult.availability) && Intrinsics.areEqual(this.channel, playlistResult.channel) && Intrinsics.areEqual(this.title, playlistResult.title) && Intrinsics.areEqual(this.description, playlistResult.description) && Intrinsics.areEqual(this.type, playlistResult.type) && Intrinsics.areEqual(this.entries, playlistResult.entries) && Intrinsics.areEqual(this.webpageUrl, playlistResult.webpageUrl) && Intrinsics.areEqual(this.originalUrl, playlistResult.originalUrl) && Intrinsics.areEqual(this.extractorKey, playlistResult.extractorKey);
    }

    public int hashCode() {
        return ((((((((((((((((((this.uploader == null ? 0 : this.uploader.hashCode()) * 31) + (this.availability == null ? 0 : this.availability.hashCode())) * 31) + (this.channel == null ? 0 : this.channel.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.entries == null ? 0 : this.entries.hashCode())) * 31) + (this.webpageUrl == null ? 0 : this.webpageUrl.hashCode())) * 31) + (this.originalUrl == null ? 0 : this.originalUrl.hashCode())) * 31) + (this.extractorKey != null ? this.extractorKey.hashCode() : 0);
    }

    public String toString() {
        return "PlaylistResult(uploader=" + this.uploader + ", availability=" + this.availability + ", channel=" + this.channel + ", title=" + this.title + ", description=" + this.description + ", type=" + this.type + ", entries=" + this.entries + ", webpageUrl=" + this.webpageUrl + ", originalUrl=" + this.originalUrl + ", extractorKey=" + this.extractorKey + ")";
    }

    /* JADX INFO: compiled from: VideoInfo.kt */
    @Metadata(m194d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m195d2 = {"Lcom/videshkarmakar/loop/util/PlaylistResult$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/videshkarmakar/loop/util/PlaylistResult;", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PlaylistResult> serializer() {
            return new GeneratedSerializer<PlaylistResult>() { // from class: com.videshkarmakar.loop.util.PlaylistResult$$serializer
                public static final int $stable = 0;
                private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

                static {
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.videshkarmakar.loop.util.PlaylistResult", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN 
                          (wrap com.videshkarmakar.loop.util.PlaylistResult$$serializer:0x0002: SGET  A[WRAPPED] (LINE:158) com.videshkarmakar.loop.util.PlaylistResult$$serializer.INSTANCE com.videshkarmakar.loop.util.PlaylistResult$$serializer)
                         (LINE:158) in method: com.videshkarmakar.loop.util.PlaylistResult.Companion.serializer():kotlinx.serialization.KSerializer<com.videshkarmakar.loop.util.PlaylistResult>, file: classes10.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method generation error
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:348)
                        	... 5 more
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0011: CONSTRUCTOR (r0v1 'pluginGeneratedSerialDescriptor' kotlinx.serialization.internal.PluginGeneratedSerialDescriptor) = 
                          ("com.videshkarmakar.loop.util.PlaylistResult")
                          (wrap com.videshkarmakar.loop.util.PlaylistResult$$serializer:0x0009: SGET  A[WRAPPED] com.videshkarmakar.loop.util.PlaylistResult$$serializer.INSTANCE com.videshkarmakar.loop.util.PlaylistResult$$serializer)
                          (10 int)
                         A[DECLARE_VAR, MD:(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer<?>, int):void (m)] (LINE:158) call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: com.videshkarmakar.loop.util.PlaylistResult$$serializer.<clinit>():void, file: classes10.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                        	... 5 more
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: com.videshkarmakar.loop.util.PlaylistResult$$serializer
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:813)
                        	at jadx.core.codegen.InsnGen.staticField(InsnGen.java:225)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:492)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:782)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                        	... 15 more
                        */
                    /*
                        this = this;
                        com.videshkarmakar.loop.util.PlaylistResult$$serializer r0 = com.videshkarmakar.loop.util.PlaylistResult$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.videshkarmakar.loop.util.PlaylistResult.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public /* synthetic */ PlaylistResult(int seen1, String uploader, String availability, String channel, String title, String description, @SerialName("_type") String type, List entries, @SerialName("webpage_url") String webpageUrl, @SerialName("original_url") String originalUrl, @SerialName("extractor_key") String extractorKey, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen1 & 1) == 0) {
                    this.uploader = null;
                } else {
                    this.uploader = uploader;
                }
                if ((seen1 & 2) == 0) {
                    this.availability = null;
                } else {
                    this.availability = availability;
                }
                if ((seen1 & 4) == 0) {
                    this.channel = null;
                } else {
                    this.channel = channel;
                }
                if ((seen1 & 8) == 0) {
                    this.title = null;
                } else {
                    this.title = title;
                }
                if ((seen1 & 16) == 0) {
                    this.description = null;
                } else {
                    this.description = description;
                }
                if ((seen1 & 32) == 0) {
                    this.type = null;
                } else {
                    this.type = type;
                }
                if ((seen1 & 64) == 0) {
                    this.entries = CollectionsKt.emptyList();
                } else {
                    this.entries = entries;
                }
                if ((seen1 & 128) == 0) {
                    this.webpageUrl = null;
                } else {
                    this.webpageUrl = webpageUrl;
                }
                if ((seen1 & 256) == 0) {
                    this.originalUrl = null;
                } else {
                    this.originalUrl = originalUrl;
                }
                if ((seen1 & 512) == 0) {
                    this.extractorKey = null;
                } else {
                    this.extractorKey = extractorKey;
                }
            }

            public PlaylistResult(String uploader, String availability, String channel, String title, String description, String type, List<Entries> list, String webpageUrl, String originalUrl, String extractorKey) {
                this.uploader = uploader;
                this.availability = availability;
                this.channel = channel;
                this.title = title;
                this.description = description;
                this.type = type;
                this.entries = list;
                this.webpageUrl = webpageUrl;
                this.originalUrl = originalUrl;
                this.extractorKey = extractorKey;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$app_debug(PlaylistResult self, CompositeEncoder output, SerialDescriptor serialDesc) {
                KSerializer<Object>[] kSerializerArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.uploader != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.uploader);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.availability != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.availability);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.channel != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.channel);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.title != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.title);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.description != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.description);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.type != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.type);
                }
                boolean z = output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.entries, CollectionsKt.emptyList());
                if (z) {
                    output.encodeNullableSerializableElement(serialDesc, 6, kSerializerArr[6], self.entries);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 7) || self.webpageUrl != null) {
                    output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.webpageUrl);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 8) || self.originalUrl != null) {
                    output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.originalUrl);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 9) || self.extractorKey != null) {
                    output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.extractorKey);
                }
            }

            public /* synthetic */ PlaylistResult(String str, String str2, String str3, String str4, String str5, String str6, List list, String str7, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? CollectionsKt.emptyList() : list, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) == 0 ? str9 : null);
            }

            public final String getUploader() {
                return this.uploader;
            }

            public final String getAvailability() {
                return this.availability;
            }

            public final String getChannel() {
                return this.channel;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getDescription() {
                return this.description;
            }

            public final String getType() {
                return this.type;
            }

            public final List<Entries> getEntries() {
                return this.entries;
            }

            public final String getWebpageUrl() {
                return this.webpageUrl;
            }

            public final String getOriginalUrl() {
                return this.originalUrl;
            }

            public final String getExtractorKey() {
                return this.extractorKey;
            }
        }
