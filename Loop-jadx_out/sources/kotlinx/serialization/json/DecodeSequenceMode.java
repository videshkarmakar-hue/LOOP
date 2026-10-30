package kotlinx.serialization.json;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: compiled from: Json.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m195d2 = {"Lkotlinx/serialization/json/DecodeSequenceMode;", "", "(Ljava/lang/String;I)V", "WHITESPACE_SEPARATED", "ARRAY_WRAPPED", "AUTO_DETECT", "kotlinx-serialization-json"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@ExperimentalSerializationApi
public enum DecodeSequenceMode {
    WHITESPACE_SEPARATED,
    ARRAY_WRAPPED,
    AUTO_DETECT;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<DecodeSequenceMode> getEntries() {
        return $ENTRIES;
    }
}
