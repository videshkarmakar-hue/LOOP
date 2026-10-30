package kotlinx.serialization.json.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;

/* JADX INFO: compiled from: StreamingJsonDecoder.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a9\u0010\t\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u00020\r¢\u0006\u0002\b\u000eH\u0082\b¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, m195d2 = {"decodeStringToJsonTree", "Lkotlinx/serialization/json/JsonElement;", ExifInterface.GPS_DIRECTION_TRUE, "json", "Lkotlinx/serialization/json/Json;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "source", "", "parseString", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "expectedType", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/serialization/json/internal/AbstractJsonLexer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-serialization-json"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class StreamingJsonDecoderKt {
    @JsonFriendModuleApi
    public static final <T> JsonElement decodeStringToJsonTree(Json json, DeserializationStrategy<? extends T> deserializer, String source) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(source, "source");
        StringJsonLexer lexer = new StringJsonLexer(source);
        StreamingJsonDecoder input = new StreamingJsonDecoder(json, WriteMode.OBJ, lexer, deserializer.getDescriptor(), null);
        JsonElement tree = input.decodeJsonElement();
        lexer.expectEof();
        return tree;
    }

    private static final <T> T parseString(JsonReader $this$parseString, String expectedType, Function1<? super String, ? extends T> function1) {
        String input = $this$parseString.consumeStringLenient();
        try {
            return function1.invoke(input);
        } catch (IllegalArgumentException e) {
            JsonReader.fail$default($this$parseString, "Failed to parse type '" + expectedType + "' for input '" + input + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }
}
