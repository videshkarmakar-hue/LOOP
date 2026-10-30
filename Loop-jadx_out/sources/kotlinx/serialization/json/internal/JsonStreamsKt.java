package kotlinx.serialization.json.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.videshkarmakar.loop.p006ui.common.Route;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.reflect.KType;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.DecodeSequenceMode;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: JsonStreams.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u00008\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a<\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\n\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007\u001a1\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\n\"\u0006\b\u0000\u0010\u0001\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0087\b\u001a9\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00122\u0006\u0010\u0013\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, m195d2 = {"decodeByReader", ExifInterface.GPS_DIRECTION_TRUE, "json", "Lkotlinx/serialization/json/Json;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "reader", "Lkotlinx/serialization/json/internal/InternalJsonReader;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/DeserializationStrategy;Lkotlinx/serialization/json/internal/InternalJsonReader;)Ljava/lang/Object;", "decodeToSequenceByReader", "Lkotlin/sequences/Sequence;", Route.FORMAT_SELECTION, "Lkotlinx/serialization/json/DecodeSequenceMode;", "encodeByWriter", "", "writer", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "serializer", "Lkotlinx/serialization/SerializationStrategy;", DownloadUtil.CookieScheme.VALUE, "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/InternalJsonWriter;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "kotlinx-serialization-json"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class JsonStreamsKt {
    @JsonFriendModuleApi
    public static final <T> void encodeByWriter(Json json, InternalJsonWriter writer, SerializationStrategy<? super T> serializer, T t) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        StreamingJsonEncoder encoder = new StreamingJsonEncoder(writer, json, WriteMode.OBJ, new JsonEncoder[WriteMode.getEntries().size()]);
        encoder.encodeSerializableValue(serializer, t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JsonFriendModuleApi
    public static final <T> T decodeByReader(Json json, DeserializationStrategy<? extends T> deserializer, InternalJsonReader reader) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(reader, "reader");
        ReaderJsonLexer readerJsonLexer = new ReaderJsonLexer(reader, null, 2, 0 == true ? 1 : 0);
        try {
            T t = (T) new StreamingJsonDecoder(json, WriteMode.OBJ, readerJsonLexer, deserializer.getDescriptor(), null).decodeSerializableValue(deserializer);
            readerJsonLexer.expectEof();
            return t;
        } finally {
            readerJsonLexer.release();
        }
    }

    public static /* synthetic */ Sequence decodeToSequenceByReader$default(Json json, InternalJsonReader internalJsonReader, DeserializationStrategy deserializationStrategy, DecodeSequenceMode decodeSequenceMode, int i, Object obj) {
        if ((i & 8) != 0) {
            decodeSequenceMode = DecodeSequenceMode.AUTO_DETECT;
        }
        return decodeToSequenceByReader(json, internalJsonReader, deserializationStrategy, decodeSequenceMode);
    }

    @JsonFriendModuleApi
    @ExperimentalSerializationApi
    public static final <T> Sequence<T> decodeToSequenceByReader(Json json, InternalJsonReader reader, DeserializationStrategy<? extends T> deserializer, DecodeSequenceMode format) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(format, "format");
        ReaderJsonLexer lexer = new ReaderJsonLexer(reader, new char[16384]);
        final Iterator iter = JsonIteratorKt.JsonIterator(format, json, lexer, deserializer);
        return SequencesKt.constrainOnce(new Sequence<T>() { // from class: kotlinx.serialization.json.internal.JsonStreamsKt$decodeToSequenceByReader$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                return iter;
            }
        });
    }

    public static /* synthetic */ Sequence decodeToSequenceByReader$default(Json json, InternalJsonReader reader, DecodeSequenceMode format, int i, Object obj) {
        if ((i & 4) != 0) {
            format = DecodeSequenceMode.AUTO_DETECT;
        }
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(format, "format");
        SerializersModule serializersModule = json.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return decodeToSequenceByReader(json, reader, SerializersKt.serializer(serializersModule, (KType) null), format);
    }

    @JsonFriendModuleApi
    @ExperimentalSerializationApi
    public static final /* synthetic */ <T> Sequence<T> decodeToSequenceByReader(Json json, InternalJsonReader reader, DecodeSequenceMode format) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(format, "format");
        SerializersModule serializersModule = json.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return decodeToSequenceByReader(json, reader, SerializersKt.serializer(serializersModule, (KType) null), format);
    }
}
