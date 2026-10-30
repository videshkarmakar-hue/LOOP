package kotlinx.serialization.json.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CharsetReader.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\b\u0010\u0016\u001a\u00020\u0010H\u0002J\u001e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010J\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m195d2 = {"Lkotlinx/serialization/json/internal/CharsetReader;", "", "inputStream", "Ljava/io/InputStream;", "charset", "Ljava/nio/charset/Charset;", "(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V", "byteBuffer", "Ljava/nio/ByteBuffer;", "decoder", "Ljava/nio/charset/CharsetDecoder;", "hasLeftoverPotentiallySurrogateChar", "", "leftoverChar", "", "doRead", "", "array", "", "offset", "length", "fillByteBuffer", "oneShotReadSlowPath", "read", "release", "", "kotlinx-serialization-json"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CharsetReader {
    private final ByteBuffer byteBuffer;
    private final Charset charset;
    private final CharsetDecoder decoder;
    private boolean hasLeftoverPotentiallySurrogateChar;
    private final InputStream inputStream;
    private char leftoverChar;

    public CharsetReader(InputStream inputStream, Charset charset) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(charset, "charset");
        this.inputStream = inputStream;
        this.charset = charset;
        CharsetDecoder charsetDecoderOnUnmappableCharacter = this.charset.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
        Intrinsics.checkNotNullExpressionValue(charsetDecoderOnUnmappableCharacter, "onUnmappableCharacter(...)");
        this.decoder = charsetDecoderOnUnmappableCharacter;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(ByteArrayPool8k.INSTANCE.take());
        Intrinsics.checkNotNullExpressionValue(byteBufferWrap, "wrap(...)");
        this.byteBuffer = byteBufferWrap;
        this.byteBuffer.flip();
    }

    public final int read(char[] array, int offset, int length) {
        Intrinsics.checkNotNullParameter(array, "array");
        if (length == 0) {
            return 0;
        }
        if (!((offset >= 0 && offset < array.length) && length >= 0 && offset + length <= array.length)) {
            throw new IllegalArgumentException(("Unexpected arguments: " + offset + ", " + length + ", " + array.length).toString());
        }
        int offset2 = offset;
        int length2 = length;
        int bytesRead = 0;
        if (this.hasLeftoverPotentiallySurrogateChar) {
            array[offset2] = this.leftoverChar;
            offset2++;
            length2--;
            this.hasLeftoverPotentiallySurrogateChar = false;
            bytesRead = 1;
            if (length2 == 0) {
                return 1;
            }
        }
        if (length2 == 1) {
            int c = oneShotReadSlowPath();
            if (c != -1) {
                array[offset2] = (char) c;
                return bytesRead + 1;
            }
            if (bytesRead == 0) {
                return -1;
            }
            return bytesRead;
        }
        return doRead(array, offset2, length2) + bytesRead;
    }

    private final int doRead(char[] array, int offset, int length) throws CharacterCodingException {
        CharBuffer charBuffer = CharBuffer.wrap(array, offset, length);
        if (charBuffer.position() != 0) {
            charBuffer = charBuffer.slice();
        }
        boolean isEof = false;
        while (true) {
            CoderResult cr = this.decoder.decode(this.byteBuffer, charBuffer, isEof);
            if (cr.isUnderflow()) {
                if (isEof || !charBuffer.hasRemaining()) {
                    break;
                }
                int n = fillByteBuffer();
                if (n < 0) {
                    isEof = true;
                    if (charBuffer.position() == 0 && !this.byteBuffer.hasRemaining()) {
                        break;
                    }
                    this.decoder.reset();
                } else {
                    continue;
                }
            } else {
                if (cr.isOverflow()) {
                    if (charBuffer.position() > 0) {
                        break;
                    }
                    throw new AssertionError("Assertion failed");
                }
                cr.throwException();
            }
        }
        if (isEof) {
            this.decoder.reset();
        }
        if (charBuffer.position() == 0) {
            return -1;
        }
        return charBuffer.position();
    }

    private final int fillByteBuffer() {
        this.byteBuffer.compact();
        try {
            int limit = this.byteBuffer.limit();
            int position = this.byteBuffer.position();
            int remaining = position <= limit ? limit - position : 0;
            int bytesRead = this.inputStream.read(this.byteBuffer.array(), this.byteBuffer.arrayOffset() + position, remaining);
            if (bytesRead < 0) {
                return bytesRead;
            }
            ByteBuffer byteBuffer = this.byteBuffer;
            Intrinsics.checkNotNull(byteBuffer, "null cannot be cast to non-null type java.nio.Buffer");
            byteBuffer.position(position + bytesRead);
            return this.byteBuffer.remaining();
        } finally {
            this.byteBuffer.flip();
        }
    }

    private final int oneShotReadSlowPath() {
        if (this.hasLeftoverPotentiallySurrogateChar) {
            this.hasLeftoverPotentiallySurrogateChar = false;
            return this.leftoverChar;
        }
        char[] array = new char[2];
        int bytesRead = read(array, 0, 2);
        switch (bytesRead) {
            case -1:
                return -1;
            case 0:
            default:
                throw new IllegalStateException(("Unreachable state: " + bytesRead).toString());
            case 1:
                return array[0];
            case 2:
                this.leftoverChar = array[1];
                this.hasLeftoverPotentiallySurrogateChar = true;
                return array[0];
        }
    }

    public final void release() {
        ByteArrayPool8k byteArrayPool8k = ByteArrayPool8k.INSTANCE;
        byte[] bArrArray = this.byteBuffer.array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
        byteArrayPool8k.release(bArrArray);
    }
}
