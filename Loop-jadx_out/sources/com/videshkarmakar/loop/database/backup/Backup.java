package com.videshkarmakar.loop.database.backup;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.database.objects.CommandTemplate;
import com.videshkarmakar.loop.database.objects.CommandTemplate$$serializer;
import com.videshkarmakar.loop.database.objects.DownloadedVideoInfo;
import com.videshkarmakar.loop.database.objects.DownloadedVideoInfo$$serializer;
import com.videshkarmakar.loop.database.objects.OptionShortcut;
import com.videshkarmakar.loop.database.objects.OptionShortcut$$serializer;
import java.util.List;
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
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: Backup.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m194d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&BI\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rB;\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005HÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J&\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#HÁ\u0001¢\u0006\u0002\b$R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006'"}, m195d2 = {"Lcom/videshkarmakar/loop/database/backup/Backup;", "", "seen1", "", "templates", "", "Lcom/videshkarmakar/loop/database/objects/CommandTemplate;", "shortcuts", "Lcom/videshkarmakar/loop/database/objects/OptionShortcut;", "downloadHistory", "Lcom/videshkarmakar/loop/database/objects/DownloadedVideoInfo;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getDownloadHistory", "()Ljava/util/List;", "getShortcuts", "getTemplates", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_debug", "$serializer", "Companion", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
public final /* data */ class Backup {
    private final List<DownloadedVideoInfo> downloadHistory;
    private final List<OptionShortcut> shortcuts;
    private final List<CommandTemplate> templates;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(CommandTemplate$$serializer.INSTANCE), new ArrayListSerializer(OptionShortcut$$serializer.INSTANCE), new ArrayListSerializer(DownloadedVideoInfo$$serializer.INSTANCE)};

    public Backup() {
        this((List) null, (List) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Backup copy$default(Backup backup, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = backup.templates;
        }
        if ((i & 2) != 0) {
            list2 = backup.shortcuts;
        }
        if ((i & 4) != 0) {
            list3 = backup.downloadHistory;
        }
        return backup.copy(list, list2, list3);
    }

    public final List<CommandTemplate> component1() {
        return this.templates;
    }

    public final List<OptionShortcut> component2() {
        return this.shortcuts;
    }

    public final List<DownloadedVideoInfo> component3() {
        return this.downloadHistory;
    }

    public final Backup copy(List<CommandTemplate> templates, List<OptionShortcut> shortcuts, List<DownloadedVideoInfo> downloadHistory) {
        return new Backup(templates, shortcuts, downloadHistory);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Backup)) {
            return false;
        }
        Backup backup = (Backup) other;
        return Intrinsics.areEqual(this.templates, backup.templates) && Intrinsics.areEqual(this.shortcuts, backup.shortcuts) && Intrinsics.areEqual(this.downloadHistory, backup.downloadHistory);
    }

    public int hashCode() {
        return ((((this.templates == null ? 0 : this.templates.hashCode()) * 31) + (this.shortcuts == null ? 0 : this.shortcuts.hashCode())) * 31) + (this.downloadHistory != null ? this.downloadHistory.hashCode() : 0);
    }

    public String toString() {
        return "Backup(templates=" + this.templates + ", shortcuts=" + this.shortcuts + ", downloadHistory=" + this.downloadHistory + ")";
    }

    /* JADX INFO: compiled from: Backup.kt */
    @Metadata(m194d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m195d2 = {"Lcom/videshkarmakar/loop/database/backup/Backup$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/videshkarmakar/loop/database/backup/Backup;", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Backup> serializer() {
            return new GeneratedSerializer<Backup>() { // from class: com.videshkarmakar.loop.database.backup.Backup$$serializer
                public static final int $stable = 0;
                private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

                static {
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.videshkarmakar.loop.database.backup.Backup", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN 
                          (wrap com.videshkarmakar.loop.database.backup.Backup$$serializer:0x0002: SGET  A[WRAPPED] (LINE:8) com.videshkarmakar.loop.database.backup.Backup$$serializer.INSTANCE com.videshkarmakar.loop.database.backup.Backup$$serializer)
                         (LINE:8) in method: com.videshkarmakar.loop.database.backup.Backup.Companion.serializer():kotlinx.serialization.KSerializer<com.videshkarmakar.loop.database.backup.Backup>, file: classes8.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0010: CONSTRUCTOR (r0v1 'pluginGeneratedSerialDescriptor' kotlinx.serialization.internal.PluginGeneratedSerialDescriptor) = 
                          ("com.videshkarmakar.loop.database.backup.Backup")
                          (wrap com.videshkarmakar.loop.database.backup.Backup$$serializer:0x0009: SGET  A[WRAPPED] com.videshkarmakar.loop.database.backup.Backup$$serializer.INSTANCE com.videshkarmakar.loop.database.backup.Backup$$serializer)
                          (3 int)
                         A[DECLARE_VAR, MD:(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer<?>, int):void (m)] (LINE:8) call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: com.videshkarmakar.loop.database.backup.Backup$$serializer.<clinit>():void, file: classes8.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: com.videshkarmakar.loop.database.backup.Backup$$serializer
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
                        com.videshkarmakar.loop.database.backup.Backup$$serializer r0 = com.videshkarmakar.loop.database.backup.Backup$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.videshkarmakar.loop.database.backup.Backup.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public /* synthetic */ Backup(int seen1, List templates, List shortcuts, List downloadHistory, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen1 & 1) == 0) {
                    this.templates = null;
                } else {
                    this.templates = templates;
                }
                if ((seen1 & 2) == 0) {
                    this.shortcuts = null;
                } else {
                    this.shortcuts = shortcuts;
                }
                if ((seen1 & 4) == 0) {
                    this.downloadHistory = null;
                } else {
                    this.downloadHistory = downloadHistory;
                }
            }

            public Backup(List<CommandTemplate> list, List<OptionShortcut> list2, List<DownloadedVideoInfo> list3) {
                this.templates = list;
                this.shortcuts = list2;
                this.downloadHistory = list3;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$app_debug(Backup self, CompositeEncoder output, SerialDescriptor serialDesc) {
                KSerializer<Object>[] kSerializerArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.templates != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, kSerializerArr[0], self.templates);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.shortcuts != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, kSerializerArr[1], self.shortcuts);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.downloadHistory != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, kSerializerArr[2], self.downloadHistory);
                }
            }

            public /* synthetic */ Backup(List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : list3);
            }

            public final List<CommandTemplate> getTemplates() {
                return this.templates;
            }

            public final List<OptionShortcut> getShortcuts() {
                return this.shortcuts;
            }

            public final List<DownloadedVideoInfo> getDownloadHistory() {
                return this.downloadHistory;
            }
        }
