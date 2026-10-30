package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.UByte;
import org.tukaani.xz.FinishableWrapperOutputStream;
import org.tukaani.xz.LZMA2InputStream;
import org.tukaani.xz.LZMA2Options;

/* JADX INFO: loaded from: classes18.dex */
class LZMA2Decoder extends CoderBase {
    LZMA2Decoder() {
        super(LZMA2Options.class, Number.class);
    }

    @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
    InputStream decode(String archiveName, InputStream in, long uncompressedLength, Coder coder, byte[] password) throws IOException {
        try {
            int dictionarySize = getDictionarySize(coder);
            return new LZMA2InputStream(in, dictionarySize);
        } catch (IllegalArgumentException ex) {
            throw new IOException(ex.getMessage());
        }
    }

    @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
    OutputStream encode(OutputStream out, Object opts) throws IOException {
        LZMA2Options options = getOptions(opts);
        return options.getOutputStream(new FinishableWrapperOutputStream(out));
    }

    @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
    byte[] getOptionsAsProperties(Object opts) {
        int dictSize = getDictSize(opts);
        int lead = Integer.numberOfLeadingZeros(dictSize);
        int secondBit = (dictSize >>> (30 - lead)) - 2;
        return new byte[]{(byte) (((19 - lead) * 2) + secondBit)};
    }

    @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
    Object getOptionsFromCoder(Coder coder, InputStream in) {
        return Integer.valueOf(getDictionarySize(coder));
    }

    private int getDictSize(Object opts) {
        if (opts instanceof LZMA2Options) {
            return ((LZMA2Options) opts).getDictSize();
        }
        return numberOptionOrDefault(opts);
    }

    private int getDictionarySize(Coder coder) throws IllegalArgumentException {
        int dictionarySizeBits = coder.properties[0] & UByte.MAX_VALUE;
        if ((dictionarySizeBits & (-64)) != 0) {
            throw new IllegalArgumentException("Unsupported LZMA2 property bits");
        }
        if (dictionarySizeBits > 40) {
            throw new IllegalArgumentException("Dictionary larger than 4GiB maximum size");
        }
        if (dictionarySizeBits == 40) {
            return -1;
        }
        return ((dictionarySizeBits & 1) | 2) << ((dictionarySizeBits / 2) + 11);
    }

    private LZMA2Options getOptions(Object opts) throws IOException {
        if (opts instanceof LZMA2Options) {
            return (LZMA2Options) opts;
        }
        LZMA2Options options = new LZMA2Options();
        options.setDictSize(numberOptionOrDefault(opts));
        return options;
    }

    private int numberOptionOrDefault(Object opts) {
        return numberOptionOrDefault(opts, 8388608);
    }
}
