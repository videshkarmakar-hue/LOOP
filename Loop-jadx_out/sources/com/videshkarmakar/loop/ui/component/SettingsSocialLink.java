package com.videshkarmakar.loop.ui.component;

import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SettingsPanel.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/videshkarmakar/loop/ui/component/SettingsSocialLink;", "", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "label", "", "url", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Ljava/lang/String;)V", "getIcon", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "getLabel", "()Ljava/lang/String;", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class SettingsSocialLink {
    public static final int $stable = 0;
    private final ImageVector icon;
    private final String label;
    private final String url;

    public static /* synthetic */ SettingsSocialLink copy$default(SettingsSocialLink settingsSocialLink, ImageVector imageVector, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            imageVector = settingsSocialLink.icon;
        }
        if ((i & 2) != 0) {
            str = settingsSocialLink.label;
        }
        if ((i & 4) != 0) {
            str2 = settingsSocialLink.url;
        }
        return settingsSocialLink.copy(imageVector, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ImageVector getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final SettingsSocialLink copy(ImageVector icon, String label, String url) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(url, "url");
        return new SettingsSocialLink(icon, label, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsSocialLink)) {
            return false;
        }
        SettingsSocialLink settingsSocialLink = (SettingsSocialLink) other;
        return Intrinsics.areEqual(this.icon, settingsSocialLink.icon) && Intrinsics.areEqual(this.label, settingsSocialLink.label) && Intrinsics.areEqual(this.url, settingsSocialLink.url);
    }

    public int hashCode() {
        return (((this.icon.hashCode() * 31) + this.label.hashCode()) * 31) + this.url.hashCode();
    }

    public String toString() {
        return "SettingsSocialLink(icon=" + this.icon + ", label=" + this.label + ", url=" + this.url + ")";
    }

    public SettingsSocialLink(ImageVector icon, String label, String url) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(url, "url");
        this.icon = icon;
        this.label = label;
        this.url = url;
    }

    public final ImageVector getIcon() {
        return this.icon;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getUrl() {
        return this.url;
    }
}
