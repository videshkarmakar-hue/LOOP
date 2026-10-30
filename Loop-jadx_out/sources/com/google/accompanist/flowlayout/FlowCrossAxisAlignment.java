package com.google.accompanist.flowlayout;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: Flow.kt */
/* JADX INFO: loaded from: classes18.dex */
@Deprecated(message = "\naccompanist/FlowCrossAxisAlignment is deprecated.\nFor more migration information, please visit https://google.github.io/accompanist/flowlayout/\n")
@Metadata(m194d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m195d2 = {"Lcom/google/accompanist/flowlayout/FlowCrossAxisAlignment;", "", "(Ljava/lang/String;I)V", "Center", "Start", "End", "flowlayout_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public enum FlowCrossAxisAlignment {
    Center,
    Start,
    End;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<FlowCrossAxisAlignment> getEntries() {
        return $ENTRIES;
    }
}
