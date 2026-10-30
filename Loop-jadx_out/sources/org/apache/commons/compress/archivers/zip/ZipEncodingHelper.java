package org.apache.commons.compress.archivers.zip;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.commons.compress.utils.Charsets;

/* JADX INFO: loaded from: classes18.dex */
public abstract class ZipEncodingHelper {
    private static final byte[] HEX_DIGITS;
    static final String UTF8 = "UTF8";
    static final ZipEncoding UTF8_ZIP_ENCODING;
    private static final Map<String, SimpleEncodingHolder> simpleEncodings;

    private static class SimpleEncodingHolder {
        private Simple8BitZipEncoding encoding;
        private final char[] highChars;

        SimpleEncodingHolder(char[] highChars) {
            this.highChars = highChars;
        }

        public synchronized Simple8BitZipEncoding getEncoding() {
            if (this.encoding == null) {
                this.encoding = new Simple8BitZipEncoding(this.highChars);
            }
            return this.encoding;
        }
    }

    static {
        Map<String, SimpleEncodingHolder> se = new HashMap<>();
        char[] cp437_high_chars = {199, 252, 233, 226, 228, 224, 229, 231, 234, 235, 232, 239, 238, 236, 196, 197, 201, 230, 198, 244, 246, 242, 251, 249, 255, 214, 220, Typography.cent, Typography.pound, 165, 8359, 402, 225, 237, 243, 250, 241, 209, 170, 186, 191, 8976, 172, Typography.half, 188, 161, 171, 187, 9617, 9618, 9619, 9474, 9508, 9569, 9570, 9558, 9557, 9571, 9553, 9559, 9565, 9564, 9563, 9488, 9492, 9524, 9516, 9500, 9472, 9532, 9566, 9567, 9562, 9556, 9577, 9574, 9568, 9552, 9580, 9575, 9576, 9572, 9573, 9561, 9560, 9554, 9555, 9579, 9578, 9496, 9484, 9608, 9604, 9612, 9616, 9600, 945, 223, 915, 960, 931, 963, 181, 964, 934, 920, 937, 948, 8734, 966, 949, 8745, 8801, Typography.plusMinus, Typography.greaterOrEqual, Typography.lessOrEqual, 8992, 8993, 247, Typography.almostEqual, Typography.degree, 8729, Typography.middleDot, 8730, 8319, 178, 9632, Typography.nbsp};
        SimpleEncodingHolder cp437 = new SimpleEncodingHolder(cp437_high_chars);
        se.put("CP437", cp437);
        se.put("Cp437", cp437);
        se.put("cp437", cp437);
        se.put("IBM437", cp437);
        se.put("ibm437", cp437);
        char[] cp850_high_chars = {199, 252, 233, 226, 228, 224, 229, 231, 234, 235, 232, 239, 238, 236, 196, 197, 201, 230, 198, 244, 246, 242, 251, 249, 255, 214, 220, 248, Typography.pound, 216, Typography.times, 402, 225, 237, 243, 250, 241, 209, 170, 186, 191, Typography.registered, 172, Typography.half, 188, 161, 171, 187, 9617, 9618, 9619, 9474, 9508, 193, 194, 192, Typography.copyright, 9571, 9553, 9559, 9565, Typography.cent, 165, 9488, 9492, 9524, 9516, 9500, 9472, 9532, 227, 195, 9562, 9556, 9577, 9574, 9568, 9552, 9580, 164, 240, 208, 202, 203, 200, 305, 205, 206, 207, 9496, 9484, 9608, 9604, 166, 204, 9600, 211, 223, 212, 210, 245, 213, 181, 254, 222, 218, 219, 217, 253, 221, 175, 180, 173, Typography.plusMinus, 8215, 190, Typography.paragraph, Typography.section, 247, 184, Typography.degree, 168, Typography.middleDot, 185, 179, 178, 9632, Typography.nbsp};
        SimpleEncodingHolder cp850 = new SimpleEncodingHolder(cp850_high_chars);
        se.put("CP850", cp850);
        se.put("Cp850", cp850);
        se.put("cp850", cp850);
        se.put("IBM850", cp850);
        se.put("ibm850", cp850);
        simpleEncodings = Collections.unmodifiableMap(se);
        HEX_DIGITS = new byte[]{TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 65, 66, 67, 68, 69, 70};
        UTF8_ZIP_ENCODING = new FallbackZipEncoding(UTF8);
    }

    static ByteBuffer growBuffer(ByteBuffer b, int newCapacity) {
        b.limit(b.position());
        b.rewind();
        int c2 = b.capacity() * 2;
        ByteBuffer on = ByteBuffer.allocate(c2 < newCapacity ? newCapacity : c2);
        on.put(b);
        return on;
    }

    static void appendSurrogate(ByteBuffer bb, char c) {
        bb.put((byte) 37);
        bb.put((byte) 85);
        bb.put(HEX_DIGITS[(c >> '\f') & 15]);
        bb.put(HEX_DIGITS[(c >> '\b') & 15]);
        bb.put(HEX_DIGITS[(c >> 4) & 15]);
        bb.put(HEX_DIGITS[c & 15]);
    }

    public static ZipEncoding getZipEncoding(String name) {
        if (isUTF8(name)) {
            return UTF8_ZIP_ENCODING;
        }
        if (name == null) {
            return new FallbackZipEncoding();
        }
        SimpleEncodingHolder h = simpleEncodings.get(name);
        if (h != null) {
            return h.getEncoding();
        }
        try {
            Charset cs = Charset.forName(name);
            return new NioZipEncoding(cs);
        } catch (UnsupportedCharsetException e) {
            return new FallbackZipEncoding(name);
        }
    }

    static boolean isUTF8(String charsetName) {
        if (charsetName == null) {
            charsetName = Charset.defaultCharset().name();
        }
        if (Charsets.UTF_8.name().equalsIgnoreCase(charsetName)) {
            return true;
        }
        for (String alias : Charsets.UTF_8.aliases()) {
            if (alias.equalsIgnoreCase(charsetName)) {
                return true;
            }
        }
        return false;
    }
}
