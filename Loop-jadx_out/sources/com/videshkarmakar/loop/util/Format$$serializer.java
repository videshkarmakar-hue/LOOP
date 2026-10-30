package com.videshkarmakar.loop.util;

import androidx.compose.foundation.text.modifiers.LayoutUtilsKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.p006ui.common.Route;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: VideoInfo.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m194d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, m195d2 = {"com/videshkarmakar/loop/util/Format.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/videshkarmakar/loop/util/Format;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", DownloadUtil.CookieScheme.VALUE, "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class Format$$serializer implements GeneratedSerializer<Format> {
    public static final int $stable = 0;
    public static final Format$$serializer INSTANCE = new Format$$serializer();
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.videshkarmakar.loop.util.Format", INSTANCE, 18);
        pluginGeneratedSerialDescriptor.addElement("format_id", true);
        pluginGeneratedSerialDescriptor.addElement("format_note", true);
        pluginGeneratedSerialDescriptor.addElement("ext", true);
        pluginGeneratedSerialDescriptor.addElement("acodec", true);
        pluginGeneratedSerialDescriptor.addElement("vcodec", true);
        pluginGeneratedSerialDescriptor.addElement("url", true);
        pluginGeneratedSerialDescriptor.addElement("width", true);
        pluginGeneratedSerialDescriptor.addElement("height", true);
        pluginGeneratedSerialDescriptor.addElement("fps", true);
        pluginGeneratedSerialDescriptor.addElement("audio_ext", true);
        pluginGeneratedSerialDescriptor.addElement("video_ext", true);
        pluginGeneratedSerialDescriptor.addElement(Route.FORMAT_SELECTION, true);
        pluginGeneratedSerialDescriptor.addElement("resolution", true);
        pluginGeneratedSerialDescriptor.addElement("vbr", true);
        pluginGeneratedSerialDescriptor.addElement("abr", true);
        pluginGeneratedSerialDescriptor.addElement("tbr", true);
        pluginGeneratedSerialDescriptor.addElement("filesize", true);
        pluginGeneratedSerialDescriptor.addElement("filesize_approx", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Format$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Format deserialize(Decoder decoder) {
        String str;
        Double d;
        Double d2;
        Double d3;
        int i;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Double d4;
        Double d5;
        String str8;
        Double d6;
        String str9;
        String str10;
        Double d7;
        Double d8;
        int i2;
        String str11;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, null);
            String str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, null);
            String str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, null);
            String str15 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, null);
            String str16 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, null);
            String str17 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, null);
            Double d9 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, DoubleSerializer.INSTANCE, null);
            Double d10 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, DoubleSerializer.INSTANCE, null);
            Double d11 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, DoubleSerializer.INSTANCE, null);
            String str18 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, StringSerializer.INSTANCE, null);
            String str19 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, StringSerializer.INSTANCE, null);
            String str20 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, StringSerializer.INSTANCE, null);
            String str21 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, StringSerializer.INSTANCE, null);
            Double d12 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, DoubleSerializer.INSTANCE, null);
            Double d13 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, DoubleSerializer.INSTANCE, null);
            Double d14 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 15, DoubleSerializer.INSTANCE, null);
            Double d15 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 16, DoubleSerializer.INSTANCE, null);
            d = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 17, DoubleSerializer.INSTANCE, null);
            d7 = d11;
            str8 = str19;
            str10 = str18;
            d8 = d10;
            d6 = d9;
            str7 = str17;
            d2 = d15;
            d3 = d14;
            d4 = d13;
            d5 = d12;
            str2 = str21;
            str9 = str20;
            i = LayoutUtilsKt.BigConstraintValue;
            str = str12;
            str6 = str16;
            str4 = str14;
            str3 = str13;
            str5 = str15;
        } else {
            Double d16 = null;
            Double d17 = null;
            String str22 = null;
            Double d18 = null;
            Double d19 = null;
            Double d20 = null;
            Double d21 = null;
            String str23 = null;
            String str24 = null;
            String str25 = null;
            Double d22 = null;
            Double d23 = null;
            String str26 = null;
            String str27 = null;
            String str28 = null;
            String str29 = null;
            String str30 = null;
            String str31 = null;
            int i3 = 0;
            boolean z = true;
            while (z) {
                String str32 = str26;
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        str26 = str32;
                        d17 = d17;
                        d16 = d16;
                        z = false;
                        break;
                    case 0:
                        str11 = str32;
                        str27 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, str27);
                        i3 |= 1;
                        str28 = str28;
                        str26 = str11;
                        d17 = d17;
                        d16 = d16;
                        break;
                    case 1:
                        str11 = str32;
                        str28 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str28);
                        i3 |= 2;
                        str29 = str29;
                        str26 = str11;
                        d17 = d17;
                        d16 = d16;
                        break;
                    case 2:
                        str11 = str32;
                        str29 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, str29);
                        i3 |= 4;
                        str30 = str30;
                        str26 = str11;
                        d17 = d17;
                        d16 = d16;
                        break;
                    case 3:
                        str11 = str32;
                        str30 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, str30);
                        i3 |= 8;
                        str31 = str31;
                        str26 = str11;
                        d17 = d17;
                        d16 = d16;
                        break;
                    case 4:
                        str11 = str32;
                        str31 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, str31);
                        i3 |= 16;
                        str26 = str11;
                        d17 = d17;
                        d16 = d16;
                        break;
                    case 5:
                        d16 = d16;
                        d17 = d17;
                        str26 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, str32);
                        i3 |= 32;
                        d17 = d17;
                        d16 = d16;
                        break;
                    case 6:
                        d18 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, DoubleSerializer.INSTANCE, d18);
                        i3 |= 64;
                        d16 = d16;
                        str26 = str32;
                        break;
                    case 7:
                        d18 = d18;
                        d23 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, DoubleSerializer.INSTANCE, d23);
                        i3 |= 128;
                        str26 = str32;
                        d18 = d18;
                        break;
                    case 8:
                        d18 = d18;
                        d22 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, DoubleSerializer.INSTANCE, d22);
                        i3 |= 256;
                        str26 = str32;
                        d18 = d18;
                        break;
                    case 9:
                        d18 = d18;
                        str25 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, StringSerializer.INSTANCE, str25);
                        i3 |= 512;
                        str26 = str32;
                        d18 = d18;
                        break;
                    case 10:
                        d18 = d18;
                        str22 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, StringSerializer.INSTANCE, str22);
                        i3 |= 1024;
                        str26 = str32;
                        d18 = d18;
                        break;
                    case 11:
                        d18 = d18;
                        str24 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, StringSerializer.INSTANCE, str24);
                        i3 |= 2048;
                        str26 = str32;
                        d18 = d18;
                        break;
                    case 12:
                        d18 = d18;
                        str23 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, StringSerializer.INSTANCE, str23);
                        i3 |= 4096;
                        str26 = str32;
                        d18 = d18;
                        break;
                    case 13:
                        d18 = d18;
                        d16 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, DoubleSerializer.INSTANCE, d16);
                        i3 |= 8192;
                        str26 = str32;
                        d18 = d18;
                        break;
                    case 14:
                        d18 = d18;
                        d17 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, DoubleSerializer.INSTANCE, d17);
                        i3 |= 16384;
                        str26 = str32;
                        d18 = d18;
                        break;
                    case 15:
                        d21 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 15, DoubleSerializer.INSTANCE, d21);
                        i2 = 32768;
                        i3 |= i2;
                        str26 = str32;
                        d18 = d18;
                        break;
                    case 16:
                        d20 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 16, DoubleSerializer.INSTANCE, d20);
                        i2 = 65536;
                        i3 |= i2;
                        str26 = str32;
                        d18 = d18;
                        break;
                    case 17:
                        d19 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 17, DoubleSerializer.INSTANCE, d19);
                        i2 = 131072;
                        i3 |= i2;
                        str26 = str32;
                        d18 = d18;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            String str33 = str28;
            str = str27;
            d = d19;
            d2 = d20;
            d3 = d21;
            i = i3;
            str2 = str23;
            str3 = str33;
            str4 = str29;
            str5 = str30;
            str6 = str31;
            str7 = str26;
            d4 = d17;
            d5 = d16;
            str8 = str22;
            d6 = d18;
            str9 = str24;
            str10 = str25;
            d7 = d22;
            d8 = d23;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new Format(i, str, str3, str4, str5, str6, str7, d6, d8, d7, str10, str8, str9, str2, d5, d4, d3, d2, d, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Format value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        Format.write$Self$app_debug(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
