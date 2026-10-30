package kotlinx.serialization.json.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.DeepRecursiveFunction;
import kotlin.DeepRecursiveKt;
import kotlin.DeepRecursiveScope;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: JsonTreeReader.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0002J\u0017\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0014H\u0082\bJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bH\u0002J\u001e\u0010\u0010\u001a\u00020\r*\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\r0\u0018H\u0082@¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m195d2 = {"Lkotlinx/serialization/json/internal/JsonTreeReader;", "", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "lexer", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "(Lkotlinx/serialization/json/JsonConfiguration;Lkotlinx/serialization/json/internal/AbstractJsonLexer;)V", "isLenient", "", "stackDepth", "", "trailingCommaAllowed", "read", "Lkotlinx/serialization/json/JsonElement;", "readArray", "readDeepRecursive", "readObject", "readObjectImpl", "Lkotlinx/serialization/json/JsonObject;", "reader", "Lkotlin/Function0;", "readValue", "Lkotlinx/serialization/json/JsonPrimitive;", "isString", "Lkotlin/DeepRecursiveScope;", "", "(Lkotlin/DeepRecursiveScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-serialization-json"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class JsonTreeReader {
    private final boolean isLenient;
    private final JsonReader lexer;
    private int stackDepth;
    private final boolean trailingCommaAllowed;

    /* JADX INFO: renamed from: kotlinx.serialization.json.internal.JsonTreeReader$readObject$2 */
    /* JADX INFO: compiled from: JsonTreeReader.kt */
    @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "kotlinx.serialization.json.internal.JsonTreeReader", m210f = "JsonTreeReader.kt", m211i = {0, 0, 0, 0}, m212l = {24}, m213m = "readObject", m214n = {"$this$readObject", "this_$iv", "result$iv", "key$iv"}, m215s = {"L$0", "L$1", "L$2", "L$3"})
    static final class C44782 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C44782(Continuation<? super C44782> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JsonTreeReader.this.readObject(null, this);
        }
    }

    public JsonTreeReader(JsonConfiguration configuration, JsonReader lexer) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(lexer, "lexer");
        this.lexer = lexer;
        this.isLenient = configuration.getIsLenient();
        this.trailingCommaAllowed = configuration.getAllowTrailingComma();
    }

    private final JsonElement readObject() {
        byte lastToken$iv = this.lexer.consumeNextToken((byte) 6);
        if (this.lexer.peekNextToken() == 4) {
            JsonReader.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        LinkedHashMap result$iv = new LinkedHashMap();
        while (this.lexer.canConsumeValue()) {
            String key$iv = this.isLenient ? this.lexer.consumeStringLenient() : this.lexer.consumeString();
            this.lexer.consumeNextToken((byte) 5);
            JsonElement element$iv = read();
            result$iv.put(key$iv, element$iv);
            lastToken$iv = this.lexer.consumeNextToken();
            if (lastToken$iv != 4) {
                if (lastToken$iv == 7) {
                    break;
                }
                JsonReader.fail$default(this.lexer, "Expected end of the object or comma", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
        }
        if (lastToken$iv == 6) {
            this.lexer.consumeNextToken((byte) 7);
        } else if (lastToken$iv == 4) {
            if (!this.trailingCommaAllowed) {
                JsonExceptionsKt.invalidTrailingComma$default(this.lexer, null, 1, null);
                throw new KotlinNothingValueException();
            }
            this.lexer.consumeNextToken((byte) 7);
        }
        return new JsonObject(result$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:18:0x007b  */
    /* JADX WARN: Code duplicated, block: B:20:0x007f  */
    /* JADX WARN: Code duplicated, block: B:21:0x0086  */
    /* JADX WARN: Code duplicated, block: B:24:0x00a5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:28:0x00c2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:29:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:30:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:32:0x00de  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00a6 -> B:26:0x00b0). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object readObject(kotlin.DeepRecursiveScope<kotlin.Unit, kotlinx.serialization.json.JsonElement> r23, kotlin.coroutines.Continuation<? super kotlinx.serialization.json.JsonElement> r24) {
        /*
            Method dump skipped, instruction units count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.JsonTreeReader.readObject(kotlin.DeepRecursiveScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final JsonObject readObjectImpl(Function0<? extends JsonElement> reader) {
        byte lastToken = this.lexer.consumeNextToken((byte) 6);
        if (this.lexer.peekNextToken() == 4) {
            JsonReader.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        LinkedHashMap result = new LinkedHashMap();
        while (this.lexer.canConsumeValue()) {
            String key = this.isLenient ? this.lexer.consumeStringLenient() : this.lexer.consumeString();
            this.lexer.consumeNextToken((byte) 5);
            JsonElement element = reader.invoke();
            result.put(key, element);
            lastToken = this.lexer.consumeNextToken();
            if (lastToken != 4) {
                if (lastToken == 7) {
                    break;
                }
                JsonReader.fail$default(this.lexer, "Expected end of the object or comma", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
        }
        if (lastToken == 6) {
            this.lexer.consumeNextToken((byte) 7);
        } else if (lastToken == 4) {
            if (!this.trailingCommaAllowed) {
                JsonExceptionsKt.invalidTrailingComma$default(this.lexer, null, 1, null);
                throw new KotlinNothingValueException();
            }
            this.lexer.consumeNextToken((byte) 7);
        }
        return new JsonObject(result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonElement readArray() {
        byte lastToken = this.lexer.consumeNextToken();
        if (this.lexer.peekNextToken() == 4) {
            JsonReader.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        ArrayList result = new ArrayList();
        while (this.lexer.canConsumeValue()) {
            JsonElement element = read();
            result.add(element);
            lastToken = this.lexer.consumeNextToken();
            if (lastToken != 4) {
                JsonReader $this$iv = this.lexer;
                boolean condition$iv = lastToken == 9;
                int position$iv = $this$iv.currentPosition;
                if (!condition$iv) {
                    JsonReader.fail$default($this$iv, "Expected end of the array or comma", position$iv, null, 4, null);
                    throw new KotlinNothingValueException();
                }
            }
        }
        if (lastToken == 8) {
            this.lexer.consumeNextToken((byte) 9);
        } else if (lastToken == 4) {
            if (!this.trailingCommaAllowed) {
                JsonExceptionsKt.invalidTrailingComma(this.lexer, "array");
                throw new KotlinNothingValueException();
            }
            this.lexer.consumeNextToken((byte) 9);
        }
        return new JsonArray(result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonPrimitive readValue(boolean isString) {
        String string;
        if (this.isLenient || !isString) {
            string = this.lexer.consumeStringLenient();
        } else {
            string = this.lexer.consumeString();
        }
        return (isString || !Intrinsics.areEqual(string, AbstractJsonLexerKt.NULL)) ? new JsonLiteral(string, isString, null, 4, null) : JsonNull.INSTANCE;
    }

    public final JsonElement read() {
        JsonElement object;
        byte token = this.lexer.peekNextToken();
        if (token == 1) {
            return readValue(true);
        }
        if (token == 0) {
            return readValue(false);
        }
        if (token == 6) {
            this.stackDepth++;
            if (this.stackDepth == 200) {
                object = readDeepRecursive();
            } else {
                object = readObject();
            }
            this.stackDepth--;
            return object;
        }
        if (token == 8) {
            return readArray();
        }
        JsonReader.fail$default(this.lexer, "Cannot read Json element because of unexpected " + AbstractJsonLexerKt.tokenDescription(token), 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1 */
    /* JADX INFO: compiled from: JsonTreeReader.kt */
    @Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u008a@"}, m195d2 = {"<anonymous>", "Lkotlinx/serialization/json/JsonElement;", "Lkotlin/DeepRecursiveScope;", "", "it"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1", m210f = "JsonTreeReader.kt", m211i = {}, m212l = {115}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C44771 extends RestrictedSuspendLambda implements Function3<DeepRecursiveScope<Unit, JsonElement>, Unit, Continuation<? super JsonElement>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C44771(Continuation<? super C44771> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(DeepRecursiveScope<Unit, JsonElement> deepRecursiveScope, Unit unit, Continuation<? super JsonElement> continuation) {
            C44771 c44771 = JsonTreeReader.this.new C44771(continuation);
            c44771.L$0 = deepRecursiveScope;
            return c44771.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    DeepRecursiveScope $this$$receiver = (DeepRecursiveScope) this.L$0;
                    byte bPeekNextToken = JsonTreeReader.this.lexer.peekNextToken();
                    if (bPeekNextToken == 1) {
                        return JsonTreeReader.this.readValue(true);
                    }
                    if (bPeekNextToken == 0) {
                        return JsonTreeReader.this.readValue(false);
                    }
                    if (bPeekNextToken == 6) {
                        this.label = 1;
                        Object object = JsonTreeReader.this.readObject($this$$receiver, this);
                        if (object == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = object;
                    } else {
                        if (bPeekNextToken == 8) {
                            return JsonTreeReader.this.readArray();
                        }
                        JsonReader.fail$default(JsonTreeReader.this.lexer, "Can't begin reading element, unexpected token", 0, null, 6, null);
                        throw new KotlinNothingValueException();
                    }
                    break;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return (JsonElement) $result;
        }
    }

    private final JsonElement readDeepRecursive() {
        return (JsonElement) DeepRecursiveKt.invoke(new DeepRecursiveFunction(new C44771(null)), Unit.INSTANCE);
    }
}
