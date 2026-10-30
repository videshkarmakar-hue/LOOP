package com.videshkarmakar.loop.ui.page;

import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WelcomeScreen.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/videshkarmakar/loop/ui/page/SocialLink;", "", "label", "", "url", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;)V", "getIcon", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "getLabel", "()Ljava/lang/String;", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final /* data */ class SocialLink {
    private final ImageVector icon;
    private final String label;
    private final String url;

    public static /* synthetic */ SocialLink copy$default(SocialLink socialLink, String str, String str2, ImageVector imageVector, int i, Object obj) {
        if ((i & 1) != 0) {
            str = socialLink.label;
        }
        if ((i & 2) != 0) {
            str2 = socialLink.url;
        }
        if ((i & 4) != 0) {
            imageVector = socialLink.icon;
        }
        return socialLink.copy(str, str2, imageVector);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ImageVector getIcon() {
        return this.icon;
    }

    public final SocialLink copy(String label, String url, ImageVector icon) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(icon, "icon");
        return new SocialLink(label, url, icon);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SocialLink)) {
            return false;
        }
        SocialLink socialLink = (SocialLink) other;
        return Intrinsics.areEqual(this.label, socialLink.label) && Intrinsics.areEqual(this.url, socialLink.url) && Intrinsics.areEqual(this.icon, socialLink.icon);
    }

    public int hashCode() {
        return (((this.label.hashCode() * 31) + this.url.hashCode()) * 31) + this.icon.hashCode();
    }

    public String toString() {
        return "SocialLink(label=" + this.label + ", url=" + this.url + ", icon=" + this.icon + ")";
    }

    public SocialLink(String label, String url, ImageVector icon) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.label = label;
        this.url = url;
        this.icon = icon;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getUrl() {
        return this.url;
    }

    public final ImageVector getIcon() {
        return this.icon;
    }
}
