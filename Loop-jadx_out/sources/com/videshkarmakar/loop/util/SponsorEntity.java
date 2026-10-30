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
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: SponsorData.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m194d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'BA\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\rJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$HÁ\u0001¢\u0006\u0002\b%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006("}, m195d2 = {"Lcom/videshkarmakar/loop/util/SponsorEntity;", "", "seen1", "", "login", "", "name", "websiteUrl", "socialAccounts", "Lcom/videshkarmakar/loop/util/SocialAccounts;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/videshkarmakar/loop/util/SocialAccounts;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/videshkarmakar/loop/util/SocialAccounts;)V", "getLogin", "()Ljava/lang/String;", "getName", "getSocialAccounts", "()Lcom/videshkarmakar/loop/util/SocialAccounts;", "getWebsiteUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_debug", "$serializer", "Companion", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
public final /* data */ class SponsorEntity {
    private final String login;
    private final String name;
    private final SocialAccounts socialAccounts;
    private final String websiteUrl;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ SponsorEntity copy$default(SponsorEntity sponsorEntity, String str, String str2, String str3, SocialAccounts socialAccounts, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sponsorEntity.login;
        }
        if ((i & 2) != 0) {
            str2 = sponsorEntity.name;
        }
        if ((i & 4) != 0) {
            str3 = sponsorEntity.websiteUrl;
        }
        if ((i & 8) != 0) {
            socialAccounts = sponsorEntity.socialAccounts;
        }
        return sponsorEntity.copy(str, str2, str3, socialAccounts);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLogin() {
        return this.login;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getWebsiteUrl() {
        return this.websiteUrl;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final SocialAccounts getSocialAccounts() {
        return this.socialAccounts;
    }

    public final SponsorEntity copy(String login, String name, String websiteUrl, SocialAccounts socialAccounts) {
        Intrinsics.checkNotNullParameter(login, "login");
        return new SponsorEntity(login, name, websiteUrl, socialAccounts);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SponsorEntity)) {
            return false;
        }
        SponsorEntity sponsorEntity = (SponsorEntity) other;
        return Intrinsics.areEqual(this.login, sponsorEntity.login) && Intrinsics.areEqual(this.name, sponsorEntity.name) && Intrinsics.areEqual(this.websiteUrl, sponsorEntity.websiteUrl) && Intrinsics.areEqual(this.socialAccounts, sponsorEntity.socialAccounts);
    }

    public int hashCode() {
        return (((((this.login.hashCode() * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.websiteUrl == null ? 0 : this.websiteUrl.hashCode())) * 31) + (this.socialAccounts != null ? this.socialAccounts.hashCode() : 0);
    }

    public String toString() {
        return "SponsorEntity(login=" + this.login + ", name=" + this.name + ", websiteUrl=" + this.websiteUrl + ", socialAccounts=" + this.socialAccounts + ")";
    }

    /* JADX INFO: compiled from: SponsorData.kt */
    @Metadata(m194d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m195d2 = {"Lcom/videshkarmakar/loop/util/SponsorEntity$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/videshkarmakar/loop/util/SponsorEntity;", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SponsorEntity> serializer() {
            return SponsorEntity$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ SponsorEntity(int seen1, String login, String name, String websiteUrl, SocialAccounts socialAccounts, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen1 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 1, SponsorEntity$$serializer.INSTANCE.getDescriptor());
        }
        this.login = login;
        if ((seen1 & 2) == 0) {
            this.name = null;
        } else {
            this.name = name;
        }
        if ((seen1 & 4) == 0) {
            this.websiteUrl = null;
        } else {
            this.websiteUrl = websiteUrl;
        }
        if ((seen1 & 8) == 0) {
            this.socialAccounts = null;
        } else {
            this.socialAccounts = socialAccounts;
        }
    }

    public SponsorEntity(String login, String name, String websiteUrl, SocialAccounts socialAccounts) {
        Intrinsics.checkNotNullParameter(login, "login");
        this.login = login;
        this.name = name;
        this.websiteUrl = websiteUrl;
        this.socialAccounts = socialAccounts;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_debug(SponsorEntity self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.login);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.name != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.websiteUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.websiteUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.socialAccounts != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, SocialAccounts$$serializer.INSTANCE, self.socialAccounts);
        }
    }

    public /* synthetic */ SponsorEntity(String str, String str2, String str3, SocialAccounts socialAccounts, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : socialAccounts);
    }

    public final String getLogin() {
        return this.login;
    }

    public final String getName() {
        return this.name;
    }

    public final String getWebsiteUrl() {
        return this.websiteUrl;
    }

    public final SocialAccounts getSocialAccounts() {
        return this.socialAccounts;
    }
}
