package com.google.accompanist.flowlayout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: Flow.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, m195d2 = {"Lcom/google/accompanist/flowlayout/MainAxisAlignment;", "", "arrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "(Ljava/lang/String;ILandroidx/compose/foundation/layout/Arrangement$Vertical;)V", "getArrangement$flowlayout_release", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "Center", "Start", "End", "SpaceEvenly", "SpaceBetween", "SpaceAround", "flowlayout_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public enum MainAxisAlignment {
    Center(Arrangement.INSTANCE.getCenter()),
    Start(Arrangement.INSTANCE.getTop()),
    End(Arrangement.INSTANCE.getBottom()),
    SpaceEvenly(Arrangement.INSTANCE.getSpaceEvenly()),
    SpaceBetween(Arrangement.INSTANCE.getSpaceBetween()),
    SpaceAround(Arrangement.INSTANCE.getSpaceAround());

    private final Arrangement.Vertical arrangement;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<MainAxisAlignment> getEntries() {
        return $ENTRIES;
    }

    MainAxisAlignment(Arrangement.Vertical arrangement) {
        this.arrangement = arrangement;
    }

    /* JADX INFO: renamed from: getArrangement$flowlayout_release, reason: from getter */
    public final Arrangement.Vertical getArrangement() {
        return this.arrangement;
    }
}
