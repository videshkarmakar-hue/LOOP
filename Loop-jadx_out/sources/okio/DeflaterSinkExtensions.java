package okio;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.compressors.CompressorStreamFactory;

/* JADX INFO: renamed from: okio.-DeflaterSinkExtensions, reason: invalid class name */
/* JADX INFO: compiled from: DeflaterSink.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0086\b¨\u0006\u0005"}, m195d2 = {CompressorStreamFactory.DEFLATE, "Lokio/DeflaterSink;", "Lokio/Sink;", "deflater", "Ljava/util/zip/Deflater;", "okio"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DeflaterSinkExtensions {
    public static /* synthetic */ DeflaterSink deflate$default(Sink $this$deflate_u24default, Deflater deflater, int i, Object obj) {
        if ((i & 1) != 0) {
            deflater = new Deflater();
        }
        Intrinsics.checkNotNullParameter($this$deflate_u24default, "<this>");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
        return new DeflaterSink($this$deflate_u24default, deflater);
    }

    public static final DeflaterSink deflate(Sink $this$deflate, Deflater deflater) {
        Intrinsics.checkNotNullParameter($this$deflate, "<this>");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
        return new DeflaterSink($this$deflate, deflater);
    }
}
