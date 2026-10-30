package kotlinx.serialization.json;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* JADX INFO: compiled from: JsonNamingStrategy.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bç\u0080\u0001\u0018\u0000 \t2\u00020\u0001:\u0001\tJ \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&¨\u0006\n"}, m195d2 = {"Lkotlinx/serialization/json/JsonNamingStrategy;", "", "serialNameForJson", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementIndex", "", "serialName", "Builtins", "kotlinx-serialization-json"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@ExperimentalSerializationApi
public interface JsonNamingStrategy {

    /* JADX INFO: renamed from: Builtins, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    String serialNameForJson(SerialDescriptor descriptor, int elementIndex, String serialName);

    /* JADX INFO: renamed from: kotlinx.serialization.json.JsonNamingStrategy$Builtins, reason: from kotlin metadata */
    /* JADX INFO: compiled from: JsonNamingStrategy.kt */
    @Metadata(m194d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m195d2 = {"Lkotlinx/serialization/json/JsonNamingStrategy$Builtins;", "", "()V", "SnakeCase", "Lkotlinx/serialization/json/JsonNamingStrategy;", "getSnakeCase$annotations", "getSnakeCase", "()Lkotlinx/serialization/json/JsonNamingStrategy;", "kotlinx-serialization-json"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @ExperimentalSerializationApi
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final JsonNamingStrategy SnakeCase = new JsonNamingStrategy() { // from class: kotlinx.serialization.json.JsonNamingStrategy$Builtins$SnakeCase$1
            @Override // kotlinx.serialization.json.JsonNamingStrategy
            public String serialNameForJson(SerialDescriptor descriptor, int elementIndex, String serialName) {
                Intrinsics.checkNotNullParameter(descriptor, "descriptor");
                Intrinsics.checkNotNullParameter(serialName, "serialName");
                StringBuilder $this$serialNameForJson_u24lambda_u241 = new StringBuilder(serialName.length() * 2);
                Character chValueOf = null;
                int previousUpperCharsCount = 0;
                String $this$forEach$iv = serialName;
                for (int i = 0; i < $this$forEach$iv.length(); i++) {
                    char element$iv = $this$forEach$iv.charAt(i);
                    if (Character.isUpperCase(element$iv)) {
                        if (previousUpperCharsCount == 0) {
                            if (($this$serialNameForJson_u24lambda_u241.length() > 0) && StringsKt.last($this$serialNameForJson_u24lambda_u241) != '_') {
                                $this$serialNameForJson_u24lambda_u241.append('_');
                            }
                        }
                        if (chValueOf != null) {
                            char p0 = chValueOf.charValue();
                            $this$serialNameForJson_u24lambda_u241.append(p0);
                        }
                        previousUpperCharsCount++;
                        chValueOf = Character.valueOf(Character.toLowerCase(element$iv));
                    } else {
                        if (chValueOf != null) {
                            if (previousUpperCharsCount > 1 && Character.isLetter(element$iv)) {
                                $this$serialNameForJson_u24lambda_u241.append('_');
                            }
                            $this$serialNameForJson_u24lambda_u241.append(chValueOf);
                            previousUpperCharsCount = 0;
                            chValueOf = null;
                        }
                        $this$serialNameForJson_u24lambda_u241.append(element$iv);
                    }
                }
                if (chValueOf != null) {
                    $this$serialNameForJson_u24lambda_u241.append(chValueOf);
                }
                String string = $this$serialNameForJson_u24lambda_u241.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }

            public String toString() {
                return "kotlinx.serialization.json.JsonNamingStrategy.SnakeCase";
            }
        };

        @ExperimentalSerializationApi
        public static /* synthetic */ void getSnakeCase$annotations() {
        }

        private Companion() {
        }

        public final JsonNamingStrategy getSnakeCase() {
            return SnakeCase;
        }
    }
}
