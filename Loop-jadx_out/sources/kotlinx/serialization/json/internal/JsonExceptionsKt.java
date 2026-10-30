package kotlinx.serialization.json.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* JADX INFO: compiled from: JsonExceptions.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a \u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\u0018\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0000\u001a \u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\u001a\u0018\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0000\u001a \u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\u0016\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0005H\u0000\u001a\u0016\u0010\u0018\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0000\u001a\u0014\u0010\u0019\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0003H\u0000¨\u0006\u001b"}, m195d2 = {"InvalidFloatingPointDecoded", "Lkotlinx/serialization/json/internal/JsonDecodingException;", DownloadUtil.CookieScheme.VALUE, "", "key", "", "output", "InvalidFloatingPointEncoded", "Lkotlinx/serialization/json/internal/JsonEncodingException;", "InvalidKeyKindException", "keyDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "JsonDecodingException", "offset", "", "message", "input", "", "UnknownKeyException", "unexpectedFpErrorMessage", "invalidTrailingComma", "", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "entity", "minify", "throwInvalidFloatingPointDecoded", "result", "kotlinx-serialization-json"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class JsonExceptionsKt {
    public static final JsonDecodingException JsonDecodingException(int offset, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        return new JsonDecodingException(offset >= 0 ? "Unexpected JSON token at offset " + offset + ": " + message : message);
    }

    public static final JsonDecodingException JsonDecodingException(int offset, String message, CharSequence input) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(input, "input");
        return JsonDecodingException(offset, message + "\nJSON input: " + ((Object) minify(input, offset)));
    }

    public static final JsonEncodingException InvalidFloatingPointEncoded(Number value, String output) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(output, "output");
        return new JsonEncodingException("Unexpected special floating-point value " + value + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) minify$default(output, 0, 1, null)));
    }

    public static final Void throwInvalidFloatingPointDecoded(JsonReader $this$throwInvalidFloatingPointDecoded, Number result) {
        Intrinsics.checkNotNullParameter($this$throwInvalidFloatingPointDecoded, "<this>");
        Intrinsics.checkNotNullParameter(result, "result");
        JsonReader.fail$default($this$throwInvalidFloatingPointDecoded, "Unexpected special floating-point value " + result + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, AbstractJsonLexerKt.specialFlowingValuesHint, 2, null);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ Void invalidTrailingComma$default(JsonReader jsonReader, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "object";
        }
        return invalidTrailingComma(jsonReader, str);
    }

    public static final Void invalidTrailingComma(JsonReader $this$invalidTrailingComma, String entity) {
        Intrinsics.checkNotNullParameter($this$invalidTrailingComma, "<this>");
        Intrinsics.checkNotNullParameter(entity, "entity");
        $this$invalidTrailingComma.fail("Trailing comma before the end of JSON " + entity, $this$invalidTrailingComma.currentPosition - 1, "Trailing commas are non-complaint JSON and not allowed by default. Use 'allowTrailingCommas = true' in 'Json {}' builder to support them.");
        throw new KotlinNothingValueException();
    }

    public static final JsonEncodingException InvalidKeyKindException(SerialDescriptor keyDescriptor) {
        Intrinsics.checkNotNullParameter(keyDescriptor, "keyDescriptor");
        return new JsonEncodingException("Value of type '" + keyDescriptor.getSerialName() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + keyDescriptor.getKind() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }

    public static final JsonEncodingException InvalidFloatingPointEncoded(Number value, String key, String output) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(output, "output");
        return new JsonEncodingException(unexpectedFpErrorMessage(value, key, output));
    }

    public static final JsonDecodingException InvalidFloatingPointDecoded(Number value, String key, String output) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(output, "output");
        return JsonDecodingException(-1, unexpectedFpErrorMessage(value, key, output));
    }

    private static final String unexpectedFpErrorMessage(Number value, String key, String output) {
        return "Unexpected special floating-point value " + value + " with key " + key + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) minify$default(output, 0, 1, null));
    }

    public static final JsonDecodingException UnknownKeyException(String key, String input) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(input, "input");
        return JsonDecodingException(-1, "Encountered an unknown key '" + key + "'.\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.\nCurrent input: " + ((Object) minify$default(input, 0, 1, null)));
    }

    public static /* synthetic */ CharSequence minify$default(CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        return minify(charSequence, i);
    }

    public static final CharSequence minify(CharSequence $this$minify, int offset) {
        Intrinsics.checkNotNullParameter($this$minify, "<this>");
        if ($this$minify.length() < 200) {
            return $this$minify;
        }
        if (offset == -1) {
            int start = $this$minify.length() - 60;
            return start <= 0 ? $this$minify : "....." + $this$minify.subSequence(start, $this$minify.length()).toString();
        }
        int start2 = offset - 30;
        int end = offset + 30;
        String prefix = start2 <= 0 ? "" : ".....";
        String suffix = end >= $this$minify.length() ? "" : ".....";
        return prefix + $this$minify.subSequence(RangesKt.coerceAtLeast(start2, 0), RangesKt.coerceAtMost(end, $this$minify.length())).toString() + suffix;
    }
}
