package com.videshkarmakar.loop.ui.component;

import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FoXinBottomNavigation.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/videshkarmakar/loop/ui/component/BottomNavItem;", "", "route", "", "label", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;)V", "getIcon", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "getLabel", "()Ljava/lang/String;", "getRoute", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class BottomNavItem {
    public static final int $stable = 0;
    private final ImageVector icon;
    private final String label;
    private final String route;

    public static /* synthetic */ BottomNavItem copy$default(BottomNavItem bottomNavItem, String str, String str2, ImageVector imageVector, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bottomNavItem.route;
        }
        if ((i & 2) != 0) {
            str2 = bottomNavItem.label;
        }
        if ((i & 4) != 0) {
            imageVector = bottomNavItem.icon;
        }
        return bottomNavItem.copy(str, str2, imageVector);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRoute() {
        return this.route;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ImageVector getIcon() {
        return this.icon;
    }

    public final BottomNavItem copy(String route, String label, ImageVector icon) {
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(icon, "icon");
        return new BottomNavItem(route, label, icon);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BottomNavItem)) {
            return false;
        }
        BottomNavItem bottomNavItem = (BottomNavItem) other;
        return Intrinsics.areEqual(this.route, bottomNavItem.route) && Intrinsics.areEqual(this.label, bottomNavItem.label) && Intrinsics.areEqual(this.icon, bottomNavItem.icon);
    }

    public int hashCode() {
        return (((this.route.hashCode() * 31) + this.label.hashCode()) * 31) + this.icon.hashCode();
    }

    public String toString() {
        return "BottomNavItem(route=" + this.route + ", label=" + this.label + ", icon=" + this.icon + ")";
    }

    public BottomNavItem(String route, String label, ImageVector icon) {
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.route = route;
        this.label = label;
        this.icon = icon;
    }

    public final String getRoute() {
        return this.route;
    }

    public final String getLabel() {
        return this.label;
    }

    public final ImageVector getIcon() {
        return this.icon;
    }
}
