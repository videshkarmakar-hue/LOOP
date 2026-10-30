package com.videshkarmakar.loop.util;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: SponsorData.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m194d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB#\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aHÁ\u0001¢\u0006\u0002\b\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001e"}, m195d2 = {"Lcom/videshkarmakar/loop/util/Viewer;", "", "seen1", "", "sponsorshipsAsMaintainer", "Lcom/videshkarmakar/loop/util/SponsorshipsAsMaintainer;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/videshkarmakar/loop/util/SponsorshipsAsMaintainer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/videshkarmakar/loop/util/SponsorshipsAsMaintainer;)V", "getSponsorshipsAsMaintainer", "()Lcom/videshkarmakar/loop/util/SponsorshipsAsMaintainer;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_debug", "$serializer", "Companion", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
public final /* data */ class Viewer {
    private final SponsorshipsAsMaintainer sponsorshipsAsMaintainer;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ Viewer copy$default(Viewer viewer, SponsorshipsAsMaintainer sponsorshipsAsMaintainer, int i, Object obj) {
        if ((i & 1) != 0) {
            sponsorshipsAsMaintainer = viewer.sponsorshipsAsMaintainer;
        }
        return viewer.copy(sponsorshipsAsMaintainer);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SponsorshipsAsMaintainer getSponsorshipsAsMaintainer() {
        return this.sponsorshipsAsMaintainer;
    }

    public final Viewer copy(SponsorshipsAsMaintainer sponsorshipsAsMaintainer) {
        Intrinsics.checkNotNullParameter(sponsorshipsAsMaintainer, "sponsorshipsAsMaintainer");
        return new Viewer(sponsorshipsAsMaintainer);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Viewer) && Intrinsics.areEqual(this.sponsorshipsAsMaintainer, ((Viewer) other).sponsorshipsAsMaintainer);
    }

    public int hashCode() {
        return this.sponsorshipsAsMaintainer.hashCode();
    }

    public String toString() {
        return "Viewer(sponsorshipsAsMaintainer=" + this.sponsorshipsAsMaintainer + ")";
    }

    /* JADX INFO: compiled from: SponsorData.kt */
    @Metadata(m194d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m195d2 = {"Lcom/videshkarmakar/loop/util/Viewer$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/videshkarmakar/loop/util/Viewer;", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Viewer> serializer() {
            return Viewer$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ Viewer(int seen1, SponsorshipsAsMaintainer sponsorshipsAsMaintainer, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen1 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 1, Viewer$$serializer.INSTANCE.getDescriptor());
        }
        this.sponsorshipsAsMaintainer = sponsorshipsAsMaintainer;
    }

    public Viewer(SponsorshipsAsMaintainer sponsorshipsAsMaintainer) {
        Intrinsics.checkNotNullParameter(sponsorshipsAsMaintainer, "sponsorshipsAsMaintainer");
        this.sponsorshipsAsMaintainer = sponsorshipsAsMaintainer;
    }

    public final SponsorshipsAsMaintainer getSponsorshipsAsMaintainer() {
        return this.sponsorshipsAsMaintainer;
    }
}
