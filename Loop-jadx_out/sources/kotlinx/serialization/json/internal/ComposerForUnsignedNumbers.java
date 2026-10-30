package kotlinx.serialization.json.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Composers.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000bH\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\fH\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m195d2 = {"Lkotlinx/serialization/json/internal/ComposerForUnsignedNumbers;", "Lkotlinx/serialization/json/internal/Composer;", "writer", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "forceQuoting", "", "(Lkotlinx/serialization/json/internal/InternalJsonWriter;Z)V", "print", "", "v", "", "", "", "", "kotlinx-serialization-json"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposerForUnsignedNumbers extends Composer {
    private final boolean forceQuoting;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerForUnsignedNumbers(InternalJsonWriter writer, boolean forceQuoting) {
        super(writer);
        Intrinsics.checkNotNullParameter(writer, "writer");
        this.forceQuoting = forceQuoting;
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(int v) {
        if (this.forceQuoting) {
            printQuoted(Long.toString(((long) UInt.m7788constructorimpl(v)) & 4294967295L, 10));
        } else {
            print(Long.toString(((long) UInt.m7788constructorimpl(v)) & 4294967295L, 10));
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(long v) {
        if (this.forceQuoting) {
            printQuoted(ComposerForUnsignedNumbers$$ExternalSyntheticBackport3.m235m(ULong.m7867constructorimpl(v), 10));
        } else {
            print(ComposerForUnsignedNumbers$$ExternalSyntheticBackport3.m235m(ULong.m7867constructorimpl(v), 10));
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(byte v) {
        if (this.forceQuoting) {
            printQuoted(UByte.m7755toStringimpl(UByte.m7711constructorimpl(v)));
        } else {
            print(UByte.m7755toStringimpl(UByte.m7711constructorimpl(v)));
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(short v) {
        if (this.forceQuoting) {
            printQuoted(UShort.m8018toStringimpl(UShort.m7974constructorimpl(v)));
        } else {
            print(UShort.m8018toStringimpl(UShort.m7974constructorimpl(v)));
        }
    }
}
