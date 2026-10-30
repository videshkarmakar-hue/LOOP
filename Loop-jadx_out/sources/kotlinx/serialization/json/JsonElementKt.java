package kotlinx.serialization.json;

import androidx.compose.p001ui.geometry.InlineClassHelperKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.InlineClassDescriptorKt;
import kotlinx.serialization.json.internal.JsonDecodingException;
import kotlinx.serialization.json.internal.JsonEncodingException;
import kotlinx.serialization.json.internal.StringJsonLexer;
import kotlinx.serialization.json.internal.StringOpsKt;
import okhttp3.internal.p009ws.WebSocketProtocol;

/* JADX INFO: compiled from: JsonElement.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0001\n\u0002\u0010\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0015\u0010<\u001a\u00020\u00062\b\u0010=\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010>\u001a\u0012\u0010<\u001a\u00020+2\b\u0010=\u001a\u0004\u0018\u00010?H\u0007\u001a\u0010\u0010<\u001a\u00020\u00062\b\u0010=\u001a\u0004\u0018\u00010@\u001a\u0010\u0010<\u001a\u00020\u00062\b\u0010=\u001a\u0004\u0018\u00010\r\u001a\u001a\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u00020AH\u0007ø\u0001\u0000¢\u0006\u0004\bB\u0010C\u001a\u001a\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u00020DH\u0007ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001a\u001a\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u00020GH\u0007ø\u0001\u0000¢\u0006\u0004\bH\u0010I\u001a\u001a\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u00020JH\u0007ø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001a\u0012\u0010M\u001a\u00020\u00062\b\u0010=\u001a\u0004\u0018\u00010\rH\u0007\u001a\"\u0010N\u001a\u0002HO\"\u0004\b\u0000\u0010O2\f\u0010P\u001a\b\u0012\u0004\u0012\u0002HO0QH\u0082\b¢\u0006\u0002\u0010R\u001a$\u0010S\u001a\u0004\u0018\u0001HO\"\u0004\b\u0000\u0010O2\f\u0010P\u001a\b\u0012\u0004\u0012\u0002HO0QH\u0082\b¢\u0006\u0002\u0010R\u001a\u0018\u0010T\u001a\u00020?2\u0006\u0010U\u001a\u00020\r2\u0006\u0010V\u001a\u00020\rH\u0001\u001a\u0014\u0010W\u001a\u00020?*\u00020'2\u0006\u0010X\u001a\u00020\rH\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0017\u0010\t\u001a\u0004\u0018\u00010\u0005*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0017\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0015\u0010\u0010\u001a\u00020\u0011*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u0011*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0015\u0010\u0017\u001a\u00020\u0018*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\"\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u0018*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\"\u0015\u0010\u001e\u001a\u00020\u001f*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b \u0010!\"\u0017\u0010\"\u001a\u0004\u0018\u00010\u001f*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b#\u0010$\"\u0015\u0010%\u001a\u00020&*\u00020'8F¢\u0006\u0006\u001a\u0004\b(\u0010)\"\u0015\u0010*\u001a\u00020+*\u00020'8F¢\u0006\u0006\u001a\u0004\b,\u0010-\"\u0015\u0010.\u001a\u00020/*\u00020'8F¢\u0006\u0006\u001a\u0004\b0\u00101\"\u0015\u00102\u001a\u00020\u0006*\u00020'8F¢\u0006\u0006\u001a\u0004\b3\u00104\"\u0015\u00105\u001a\u000206*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b7\u00108\"\u0017\u00109\u001a\u0004\u0018\u000106*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b:\u0010;\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006Y"}, m195d2 = {"jsonUnquotedLiteralDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getJsonUnquotedLiteralDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "boolean", "", "Lkotlinx/serialization/json/JsonPrimitive;", "getBoolean", "(Lkotlinx/serialization/json/JsonPrimitive;)Z", "booleanOrNull", "getBooleanOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Boolean;", "contentOrNull", "", "getContentOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/String;", "double", "", "getDouble", "(Lkotlinx/serialization/json/JsonPrimitive;)D", "doubleOrNull", "getDoubleOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Double;", "float", "", "getFloat", "(Lkotlinx/serialization/json/JsonPrimitive;)F", "floatOrNull", "getFloatOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Float;", "int", "", "getInt", "(Lkotlinx/serialization/json/JsonPrimitive;)I", "intOrNull", "getIntOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Integer;", "jsonArray", "Lkotlinx/serialization/json/JsonArray;", "Lkotlinx/serialization/json/JsonElement;", "getJsonArray", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonArray;", "jsonNull", "Lkotlinx/serialization/json/JsonNull;", "getJsonNull", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonNull;", "jsonObject", "Lkotlinx/serialization/json/JsonObject;", "getJsonObject", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonObject;", "jsonPrimitive", "getJsonPrimitive", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonPrimitive;", "long", "", "getLong", "(Lkotlinx/serialization/json/JsonPrimitive;)J", "longOrNull", "getLongOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Long;", "JsonPrimitive", DownloadUtil.CookieScheme.VALUE, "(Ljava/lang/Boolean;)Lkotlinx/serialization/json/JsonPrimitive;", "", "", "Lkotlin/UByte;", "JsonPrimitive-7apg3OU", "(B)Lkotlinx/serialization/json/JsonPrimitive;", "Lkotlin/UInt;", "JsonPrimitive-WZ4Q5Ns", "(I)Lkotlinx/serialization/json/JsonPrimitive;", "Lkotlin/ULong;", "JsonPrimitive-VKZWuLQ", "(J)Lkotlinx/serialization/json/JsonPrimitive;", "Lkotlin/UShort;", "JsonPrimitive-xj2QHRw", "(S)Lkotlinx/serialization/json/JsonPrimitive;", "JsonUnquotedLiteral", "mapExceptions", ExifInterface.GPS_DIRECTION_TRUE, "f", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "mapExceptionsToNull", "unexpectedJson", "key", "expected", "error", "element", "kotlinx-serialization-json"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class JsonElementKt {
    private static final SerialDescriptor jsonUnquotedLiteralDescriptor = InlineClassDescriptorKt.InlinePrimitiveDescriptor("kotlinx.serialization.json.JsonUnquotedLiteral", BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE));

    public static final JsonPrimitive JsonPrimitive(Boolean value) {
        return value == null ? JsonNull.INSTANCE : new JsonLiteral(value, false, null, 4, null);
    }

    public static final JsonPrimitive JsonPrimitive(Number value) {
        return value == null ? JsonNull.INSTANCE : new JsonLiteral(value, false, null, 4, null);
    }

    @ExperimentalSerializationApi
    /* JADX INFO: renamed from: JsonPrimitive-7apg3OU, reason: not valid java name */
    public static final JsonPrimitive m9302JsonPrimitive7apg3OU(byte value) {
        return m9303JsonPrimitiveVKZWuLQ(ULong.m7867constructorimpl(((long) value) & 255));
    }

    @ExperimentalSerializationApi
    /* JADX INFO: renamed from: JsonPrimitive-xj2QHRw, reason: not valid java name */
    public static final JsonPrimitive m9305JsonPrimitivexj2QHRw(short value) {
        return m9303JsonPrimitiveVKZWuLQ(ULong.m7867constructorimpl(((long) value) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @ExperimentalSerializationApi
    /* JADX INFO: renamed from: JsonPrimitive-WZ4Q5Ns, reason: not valid java name */
    public static final JsonPrimitive m9304JsonPrimitiveWZ4Q5Ns(int value) {
        return m9303JsonPrimitiveVKZWuLQ(ULong.m7867constructorimpl(((long) value) & 4294967295L));
    }

    @ExperimentalSerializationApi
    /* JADX INFO: renamed from: JsonPrimitive-VKZWuLQ, reason: not valid java name */
    public static final JsonPrimitive m9303JsonPrimitiveVKZWuLQ(long value) {
        return JsonUnquotedLiteral(JsonElementKt$$ExternalSyntheticBackport1.m227m(value, 10));
    }

    public static final JsonPrimitive JsonPrimitive(String value) {
        return value == null ? JsonNull.INSTANCE : new JsonLiteral(value, true, null, 4, null);
    }

    @ExperimentalSerializationApi
    public static final JsonNull JsonPrimitive(Void value) {
        return JsonNull.INSTANCE;
    }

    @ExperimentalSerializationApi
    public static final JsonPrimitive JsonUnquotedLiteral(String value) {
        if (value == null) {
            return JsonNull.INSTANCE;
        }
        if (Intrinsics.areEqual(value, JsonNull.INSTANCE.getContent())) {
            throw new JsonEncodingException("Creating a literal unquoted value of 'null' is forbidden. If you want to create JSON null literal, use JsonNull object, otherwise, use JsonPrimitive");
        }
        return new JsonLiteral(value, false, jsonUnquotedLiteralDescriptor);
    }

    public static final SerialDescriptor getJsonUnquotedLiteralDescriptor() {
        return jsonUnquotedLiteralDescriptor;
    }

    public static final JsonPrimitive getJsonPrimitive(JsonElement $this$jsonPrimitive) {
        Intrinsics.checkNotNullParameter($this$jsonPrimitive, "<this>");
        JsonPrimitive jsonPrimitive = $this$jsonPrimitive instanceof JsonPrimitive ? (JsonPrimitive) $this$jsonPrimitive : null;
        if (jsonPrimitive != null) {
            return jsonPrimitive;
        }
        error($this$jsonPrimitive, "JsonPrimitive");
        throw new KotlinNothingValueException();
    }

    public static final JsonObject getJsonObject(JsonElement $this$jsonObject) {
        Intrinsics.checkNotNullParameter($this$jsonObject, "<this>");
        JsonObject jsonObject = $this$jsonObject instanceof JsonObject ? (JsonObject) $this$jsonObject : null;
        if (jsonObject != null) {
            return jsonObject;
        }
        error($this$jsonObject, "JsonObject");
        throw new KotlinNothingValueException();
    }

    public static final JsonArray getJsonArray(JsonElement $this$jsonArray) {
        Intrinsics.checkNotNullParameter($this$jsonArray, "<this>");
        JsonArray jsonArray = $this$jsonArray instanceof JsonArray ? (JsonArray) $this$jsonArray : null;
        if (jsonArray != null) {
            return jsonArray;
        }
        error($this$jsonArray, "JsonArray");
        throw new KotlinNothingValueException();
    }

    public static final JsonNull getJsonNull(JsonElement $this$jsonNull) {
        Intrinsics.checkNotNullParameter($this$jsonNull, "<this>");
        JsonNull jsonNull = $this$jsonNull instanceof JsonNull ? (JsonNull) $this$jsonNull : null;
        if (jsonNull != null) {
            return jsonNull;
        }
        error($this$jsonNull, "JsonNull");
        throw new KotlinNothingValueException();
    }

    public static final int getInt(JsonPrimitive $this$int) {
        Intrinsics.checkNotNullParameter($this$int, "<this>");
        try {
            long result = new StringJsonLexer($this$int.getContent()).consumeNumericLiteral();
            boolean z = false;
            if (-2147483648L <= result && result <= InlineClassHelperKt.FloatNonFiniteMask) {
                z = true;
            }
            if (!z) {
                throw new NumberFormatException($this$int.getContent() + " is not an Int");
            }
            return (int) result;
        } catch (JsonDecodingException e$iv) {
            throw new NumberFormatException(e$iv.getMessage());
        }
    }

    public static final Integer getIntOrNull(JsonPrimitive $this$intOrNull) {
        Long lValueOf;
        Intrinsics.checkNotNullParameter($this$intOrNull, "<this>");
        try {
            lValueOf = Long.valueOf(new StringJsonLexer($this$intOrNull.getContent()).consumeNumericLiteral());
        } catch (JsonDecodingException e) {
            lValueOf = null;
        }
        if (lValueOf == null) {
            return null;
        }
        long result = lValueOf.longValue();
        boolean z = false;
        if (-2147483648L <= result && result <= InlineClassHelperKt.FloatNonFiniteMask) {
            z = true;
        }
        if (z) {
            return Integer.valueOf((int) result);
        }
        return null;
    }

    public static final long getLong(JsonPrimitive $this$long) {
        Intrinsics.checkNotNullParameter($this$long, "<this>");
        try {
            return new StringJsonLexer($this$long.getContent()).consumeNumericLiteral();
        } catch (JsonDecodingException e$iv) {
            throw new NumberFormatException(e$iv.getMessage());
        }
    }

    public static final Long getLongOrNull(JsonPrimitive $this$longOrNull) {
        Intrinsics.checkNotNullParameter($this$longOrNull, "<this>");
        try {
            return Long.valueOf(new StringJsonLexer($this$longOrNull.getContent()).consumeNumericLiteral());
        } catch (JsonDecodingException e) {
            return null;
        }
    }

    public static final double getDouble(JsonPrimitive $this$double) {
        Intrinsics.checkNotNullParameter($this$double, "<this>");
        return Double.parseDouble($this$double.getContent());
    }

    public static final Double getDoubleOrNull(JsonPrimitive $this$doubleOrNull) {
        Intrinsics.checkNotNullParameter($this$doubleOrNull, "<this>");
        return StringsKt.toDoubleOrNull($this$doubleOrNull.getContent());
    }

    public static final float getFloat(JsonPrimitive $this$float) {
        Intrinsics.checkNotNullParameter($this$float, "<this>");
        return Float.parseFloat($this$float.getContent());
    }

    public static final Float getFloatOrNull(JsonPrimitive $this$floatOrNull) {
        Intrinsics.checkNotNullParameter($this$floatOrNull, "<this>");
        return StringsKt.toFloatOrNull($this$floatOrNull.getContent());
    }

    public static final boolean getBoolean(JsonPrimitive $this$boolean) {
        Intrinsics.checkNotNullParameter($this$boolean, "<this>");
        Boolean booleanStrictOrNull = StringOpsKt.toBooleanStrictOrNull($this$boolean.getContent());
        if (booleanStrictOrNull != null) {
            return booleanStrictOrNull.booleanValue();
        }
        throw new IllegalStateException($this$boolean + " does not represent a Boolean");
    }

    public static final Boolean getBooleanOrNull(JsonPrimitive $this$booleanOrNull) {
        Intrinsics.checkNotNullParameter($this$booleanOrNull, "<this>");
        return StringOpsKt.toBooleanStrictOrNull($this$booleanOrNull.getContent());
    }

    public static final String getContentOrNull(JsonPrimitive $this$contentOrNull) {
        Intrinsics.checkNotNullParameter($this$contentOrNull, "<this>");
        if ($this$contentOrNull instanceof JsonNull) {
            return null;
        }
        return $this$contentOrNull.getContent();
    }

    private static final Void error(JsonElement $this$error, String element) {
        throw new IllegalArgumentException("Element " + Reflection.getOrCreateKotlinClass($this$error.getClass()) + " is not a " + element);
    }

    private static final <T> T mapExceptionsToNull(Function0<? extends T> function0) {
        try {
            return function0.invoke();
        } catch (JsonDecodingException e) {
            return null;
        }
    }

    private static final <T> T mapExceptions(Function0<? extends T> function0) {
        try {
            return function0.invoke();
        } catch (JsonDecodingException e) {
            throw new NumberFormatException(e.getMessage());
        }
    }

    public static final Void unexpectedJson(String key, String expected) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(expected, "expected");
        throw new IllegalArgumentException("Element " + key + " is not a " + expected);
    }
}
