package kotlinx.serialization.json.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Set;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonElementKt;

/* JADX INFO: compiled from: StreamingJsonEncoder.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005\"\u0018\u0010\u0006\u001a\u00020\u0004*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005¨\u0006\u0007"}, m195d2 = {"unsignedNumberDescriptors", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "isUnquotedLiteral", "", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Z", "isUnsignedNumber", "kotlinx-serialization-json"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class StreamingJsonEncoderKt {
    private static final Set<SerialDescriptor> unsignedNumberDescriptors = SetsKt.setOf((Object[]) new SerialDescriptor[]{BuiltinSerializersKt.serializer(UInt.INSTANCE).getDescriptor(), BuiltinSerializersKt.serializer(ULong.INSTANCE).getDescriptor(), BuiltinSerializersKt.serializer(UByte.INSTANCE).getDescriptor(), BuiltinSerializersKt.serializer(UShort.INSTANCE).getDescriptor()});

    public static final boolean isUnsignedNumber(SerialDescriptor $this$isUnsignedNumber) {
        Intrinsics.checkNotNullParameter($this$isUnsignedNumber, "<this>");
        return $this$isUnsignedNumber.getIsInline() && unsignedNumberDescriptors.contains($this$isUnsignedNumber);
    }

    public static final boolean isUnquotedLiteral(SerialDescriptor $this$isUnquotedLiteral) {
        Intrinsics.checkNotNullParameter($this$isUnquotedLiteral, "<this>");
        return $this$isUnquotedLiteral.getIsInline() && Intrinsics.areEqual($this$isUnquotedLiteral, JsonElementKt.getJsonUnquotedLiteralDescriptor());
    }
}
