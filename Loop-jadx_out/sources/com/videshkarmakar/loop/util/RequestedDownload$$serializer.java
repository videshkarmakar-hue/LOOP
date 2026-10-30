package com.videshkarmakar.loop.util;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.p006ui.common.Route;
import java.util.List;
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
@Metadata(m194d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, m195d2 = {"com/videshkarmakar/loop/util/RequestedDownload.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/videshkarmakar/loop/util/RequestedDownload;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", DownloadUtil.CookieScheme.VALUE, "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class RequestedDownload$$serializer implements GeneratedSerializer<RequestedDownload> {
    public static final int $stable = 0;
    public static final RequestedDownload$$serializer INSTANCE = new RequestedDownload$$serializer();
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.videshkarmakar.loop.util.RequestedDownload", INSTANCE, 20);
        pluginGeneratedSerialDescriptor.addElement("requested_formats", true);
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
        pluginGeneratedSerialDescriptor.addElement("filename", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private RequestedDownload$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(RequestedDownload.$childSerializers[0]), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public RequestedDownload deserialize(Decoder decoder) {
        Double d;
        Double d2;
        String str;
        Double d3;
        Double d4;
        int i;
        String str2;
        Double d5;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Double d6;
        String str8;
        String str9;
        Double d7;
        String str10;
        List list;
        Double d8;
        String str11;
        int i2;
        Double d9;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = RequestedDownload.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            List list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, kSerializerArr[0], null);
            String str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, null);
            String str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, null);
            String str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, null);
            String str15 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, null);
            String str16 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, null);
            String str17 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, null);
            Double d10 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, DoubleSerializer.INSTANCE, null);
            Double d11 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, DoubleSerializer.INSTANCE, null);
            Double d12 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, DoubleSerializer.INSTANCE, null);
            String str18 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, StringSerializer.INSTANCE, null);
            String str19 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, StringSerializer.INSTANCE, null);
            String str20 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, StringSerializer.INSTANCE, null);
            str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, StringSerializer.INSTANCE, null);
            Double d13 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, DoubleSerializer.INSTANCE, null);
            Double d14 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 15, DoubleSerializer.INSTANCE, null);
            Double d15 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 16, DoubleSerializer.INSTANCE, null);
            Double d16 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 17, DoubleSerializer.INSTANCE, null);
            Double d17 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 18, DoubleSerializer.INSTANCE, null);
            str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 19, StringSerializer.INSTANCE, null);
            str7 = str17;
            str5 = str15;
            d6 = d10;
            d7 = d17;
            d8 = d16;
            d3 = d15;
            str2 = str19;
            list = list2;
            d2 = d11;
            str3 = str13;
            d5 = d12;
            d4 = d14;
            i = 1048575;
            str11 = str12;
            str4 = str14;
            str = str18;
            str6 = str16;
            d = d13;
            str9 = str20;
        } else {
            String str21 = null;
            String str22 = null;
            Double d18 = null;
            Double d19 = null;
            Double d20 = null;
            Double d21 = null;
            String str23 = null;
            String str24 = null;
            Double d22 = null;
            Double d23 = null;
            Double d24 = null;
            String str25 = null;
            Double d25 = null;
            List list3 = null;
            String str26 = null;
            String str27 = null;
            String str28 = null;
            String str29 = null;
            String str30 = null;
            String str31 = null;
            int i3 = 0;
            boolean z = true;
            while (z) {
                Double d26 = d20;
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        d20 = d26;
                        str21 = str21;
                        z = false;
                        break;
                    case 0:
                        d9 = d26;
                        list3 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, kSerializerArr[0], list3);
                        i3 |= 1;
                        str26 = str26;
                        d20 = d9;
                        str22 = str22;
                        str21 = str21;
                        break;
                    case 1:
                        d9 = d26;
                        str26 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str26);
                        i3 |= 2;
                        str27 = str27;
                        d20 = d9;
                        str22 = str22;
                        str21 = str21;
                        break;
                    case 2:
                        d9 = d26;
                        str27 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, str27);
                        i3 |= 4;
                        str28 = str28;
                        d20 = d9;
                        str22 = str22;
                        str21 = str21;
                        break;
                    case 3:
                        d9 = d26;
                        str28 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, str28);
                        i3 |= 8;
                        str29 = str29;
                        d20 = d9;
                        str22 = str22;
                        str21 = str21;
                        break;
                    case 4:
                        d9 = d26;
                        str29 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, str29);
                        i3 |= 16;
                        str30 = str30;
                        d20 = d9;
                        str22 = str22;
                        str21 = str21;
                        break;
                    case 5:
                        d9 = d26;
                        str30 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, str30);
                        i3 |= 32;
                        str31 = str31;
                        d20 = d9;
                        str22 = str22;
                        str21 = str21;
                        break;
                    case 6:
                        d9 = d26;
                        str31 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, str31);
                        i3 |= 64;
                        d20 = d9;
                        str22 = str22;
                        str21 = str21;
                        break;
                    case 7:
                        str21 = str21;
                        str22 = str22;
                        d20 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, DoubleSerializer.INSTANCE, d26);
                        i3 |= 128;
                        str22 = str22;
                        str21 = str21;
                        break;
                    case 8:
                        d19 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, DoubleSerializer.INSTANCE, d19);
                        i3 |= 256;
                        str21 = str21;
                        d20 = d26;
                        break;
                    case 9:
                        d19 = d19;
                        d25 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, DoubleSerializer.INSTANCE, d25);
                        i3 |= 512;
                        d20 = d26;
                        d19 = d19;
                        break;
                    case 10:
                        d19 = d19;
                        str23 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, StringSerializer.INSTANCE, str23);
                        i3 |= 1024;
                        d20 = d26;
                        d19 = d19;
                        break;
                    case 11:
                        d19 = d19;
                        str25 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, StringSerializer.INSTANCE, str25);
                        i3 |= 2048;
                        d20 = d26;
                        d19 = d19;
                        break;
                    case 12:
                        d19 = d19;
                        str21 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, StringSerializer.INSTANCE, str21);
                        i3 |= 4096;
                        d20 = d26;
                        d19 = d19;
                        break;
                    case 13:
                        d19 = d19;
                        str22 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, StringSerializer.INSTANCE, str22);
                        i3 |= 8192;
                        d20 = d26;
                        d19 = d19;
                        break;
                    case 14:
                        d19 = d19;
                        d18 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, DoubleSerializer.INSTANCE, d18);
                        i3 |= 16384;
                        d20 = d26;
                        d19 = d19;
                        break;
                    case 15:
                        d24 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 15, DoubleSerializer.INSTANCE, d24);
                        i2 = 32768;
                        i3 |= i2;
                        d20 = d26;
                        d19 = d19;
                        break;
                    case 16:
                        d23 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 16, DoubleSerializer.INSTANCE, d23);
                        i2 = 65536;
                        i3 |= i2;
                        d20 = d26;
                        d19 = d19;
                        break;
                    case 17:
                        d22 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 17, DoubleSerializer.INSTANCE, d22);
                        i2 = 131072;
                        i3 |= i2;
                        d20 = d26;
                        d19 = d19;
                        break;
                    case 18:
                        d21 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 18, DoubleSerializer.INSTANCE, d21);
                        i2 = 262144;
                        i3 |= i2;
                        d20 = d26;
                        d19 = d19;
                        break;
                    case 19:
                        str24 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 19, StringSerializer.INSTANCE, str24);
                        i2 = 524288;
                        i3 |= i2;
                        d20 = d26;
                        d19 = d19;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            d = d18;
            d2 = d19;
            str = str23;
            d3 = d23;
            d4 = d24;
            i = i3;
            str2 = str25;
            d5 = d25;
            str3 = str27;
            str4 = str28;
            str5 = str29;
            str6 = str30;
            str7 = str31;
            d6 = d20;
            str8 = str22;
            str9 = str21;
            d7 = d21;
            str10 = str24;
            list = list3;
            d8 = d22;
            str11 = str26;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new RequestedDownload(i, list, str11, str3, str4, str5, str6, str7, d6, d2, d5, str, str2, str9, str8, d, d4, d3, d8, d7, str10, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, RequestedDownload value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        RequestedDownload.write$Self$app_debug(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
