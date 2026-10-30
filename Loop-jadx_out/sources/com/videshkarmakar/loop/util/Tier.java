package com.videshkarmakar.loop.util;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: SponsorData.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m194d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB!\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J&\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019HÁ\u0001¢\u0006\u0002\b\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001d"}, m195d2 = {"Lcom/videshkarmakar/loop/util/Tier;", "", "seen1", "", "monthlyPriceInDollars", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(I)V", "getMonthlyPriceInDollars", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_debug", "$serializer", "Companion", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
public final /* data */ class Tier {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int monthlyPriceInDollars;

    public static /* synthetic */ Tier copy$default(Tier tier, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = tier.monthlyPriceInDollars;
        }
        return tier.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getMonthlyPriceInDollars() {
        return this.monthlyPriceInDollars;
    }

    public final Tier copy(int monthlyPriceInDollars) {
        return new Tier(monthlyPriceInDollars);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Tier) && this.monthlyPriceInDollars == ((Tier) other).monthlyPriceInDollars;
    }

    public int hashCode() {
        return this.monthlyPriceInDollars;
    }

    public String toString() {
        return "Tier(monthlyPriceInDollars=" + this.monthlyPriceInDollars + ")";
    }

    /* JADX INFO: compiled from: SponsorData.kt */
    @Metadata(m194d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m195d2 = {"Lcom/videshkarmakar/loop/util/Tier$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/videshkarmakar/loop/util/Tier;", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Tier> serializer() {
            return Tier$$serializer.INSTANCE;
        }
    }

    public Tier(int monthlyPriceInDollars) {
        this.monthlyPriceInDollars = monthlyPriceInDollars;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ Tier(int seen1, int monthlyPriceInDollars, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen1 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 1, Tier$$serializer.INSTANCE.getDescriptor());
        }
        this.monthlyPriceInDollars = monthlyPriceInDollars;
    }

    public final int getMonthlyPriceInDollars() {
        return this.monthlyPriceInDollars;
    }
}
