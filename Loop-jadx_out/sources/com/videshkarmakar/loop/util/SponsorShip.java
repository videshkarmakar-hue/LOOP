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

/* JADX INFO: compiled from: SponsorData.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m194d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B-\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u001f\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J&\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fHÁ\u0001¢\u0006\u0002\b R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006#"}, m195d2 = {"Lcom/videshkarmakar/loop/util/SponsorShip;", "", "seen1", "", "sponsorEntity", "Lcom/videshkarmakar/loop/util/SponsorEntity;", "tier", "Lcom/videshkarmakar/loop/util/Tier;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/videshkarmakar/loop/util/SponsorEntity;Lcom/videshkarmakar/loop/util/Tier;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/videshkarmakar/loop/util/SponsorEntity;Lcom/videshkarmakar/loop/util/Tier;)V", "getSponsorEntity", "()Lcom/videshkarmakar/loop/util/SponsorEntity;", "getTier", "()Lcom/videshkarmakar/loop/util/Tier;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_debug", "$serializer", "Companion", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
public final /* data */ class SponsorShip {
    private final SponsorEntity sponsorEntity;
    private final Tier tier;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ SponsorShip copy$default(SponsorShip sponsorShip, SponsorEntity sponsorEntity, Tier tier, int i, Object obj) {
        if ((i & 1) != 0) {
            sponsorEntity = sponsorShip.sponsorEntity;
        }
        if ((i & 2) != 0) {
            tier = sponsorShip.tier;
        }
        return sponsorShip.copy(sponsorEntity, tier);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SponsorEntity getSponsorEntity() {
        return this.sponsorEntity;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Tier getTier() {
        return this.tier;
    }

    public final SponsorShip copy(SponsorEntity sponsorEntity, Tier tier) {
        Intrinsics.checkNotNullParameter(sponsorEntity, "sponsorEntity");
        return new SponsorShip(sponsorEntity, tier);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SponsorShip)) {
            return false;
        }
        SponsorShip sponsorShip = (SponsorShip) other;
        return Intrinsics.areEqual(this.sponsorEntity, sponsorShip.sponsorEntity) && Intrinsics.areEqual(this.tier, sponsorShip.tier);
    }

    public int hashCode() {
        return (this.sponsorEntity.hashCode() * 31) + (this.tier == null ? 0 : this.tier.hashCode());
    }

    public String toString() {
        return "SponsorShip(sponsorEntity=" + this.sponsorEntity + ", tier=" + this.tier + ")";
    }

    /* JADX INFO: compiled from: SponsorData.kt */
    @Metadata(m194d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m195d2 = {"Lcom/videshkarmakar/loop/util/SponsorShip$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/videshkarmakar/loop/util/SponsorShip;", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SponsorShip> serializer() {
            return SponsorShip$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ SponsorShip(int seen1, SponsorEntity sponsorEntity, Tier tier, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen1 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 1, SponsorShip$$serializer.INSTANCE.getDescriptor());
        }
        this.sponsorEntity = sponsorEntity;
        if ((seen1 & 2) == 0) {
            this.tier = null;
        } else {
            this.tier = tier;
        }
    }

    public SponsorShip(SponsorEntity sponsorEntity, Tier tier) {
        Intrinsics.checkNotNullParameter(sponsorEntity, "sponsorEntity");
        this.sponsorEntity = sponsorEntity;
        this.tier = tier;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_debug(SponsorShip self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, SponsorEntity$$serializer.INSTANCE, self.sponsorEntity);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.tier != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, Tier$$serializer.INSTANCE, self.tier);
        }
    }

    public /* synthetic */ SponsorShip(SponsorEntity sponsorEntity, Tier tier, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sponsorEntity, (i & 2) != 0 ? null : tier);
    }

    public final SponsorEntity getSponsorEntity() {
        return this.sponsorEntity;
    }

    public final Tier getTier() {
        return this.tier;
    }
}
