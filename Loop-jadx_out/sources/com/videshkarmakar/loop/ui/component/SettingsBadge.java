package com.videshkarmakar.loop.ui.component;

import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SettingsPanel.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/videshkarmakar/loop/ui/component/SettingsBadge;", "", "label", "", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;)V", "getIcon", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "getLabel", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class SettingsBadge {
    public static final int $stable = 0;
    private final ImageVector icon;
    private final String label;

    public static /* synthetic */ SettingsBadge copy$default(SettingsBadge settingsBadge, String str, ImageVector imageVector, int i, Object obj) {
        if ((i & 1) != 0) {
            str = settingsBadge.label;
        }
        if ((i & 2) != 0) {
            imageVector = settingsBadge.icon;
        }
        return settingsBadge.copy(str, imageVector);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ImageVector getIcon() {
        return this.icon;
    }

    public final SettingsBadge copy(String label, ImageVector icon) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(icon, "icon");
        return new SettingsBadge(label, icon);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsBadge)) {
            return false;
        }
        SettingsBadge settingsBadge = (SettingsBadge) other;
        return Intrinsics.areEqual(this.label, settingsBadge.label) && Intrinsics.areEqual(this.icon, settingsBadge.icon);
    }

    public int hashCode() {
        return (this.label.hashCode() * 31) + this.icon.hashCode();
    }

    public String toString() {
        return "SettingsBadge(label=" + this.label + ", icon=" + this.icon + ")";
    }

    public SettingsBadge(String label, ImageVector icon) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.label = label;
        this.icon = icon;
    }

    public final String getLabel() {
        return this.label;
    }

    public final ImageVector getIcon() {
        return this.icon;
    }
}
