package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes18.dex */
class ExplodingInputStream extends InputStream {
    private BitStream bits;
    private final CircularBuffer buffer = new CircularBuffer(32768);
    private final int dictionarySize;
    private BinaryTree distanceTree;

    /* JADX INFO: renamed from: in */
    private final InputStream f569in;
    private BinaryTree lengthTree;
    private BinaryTree literalTree;
    private final int minimumMatchLength;
    private final int numberOfTrees;

    public ExplodingInputStream(int dictionarySize, int numberOfTrees, InputStream in) {
        if (dictionarySize != 4096 && dictionarySize != 8192) {
            throw new IllegalArgumentException("The dictionary size must be 4096 or 8192");
        }
        if (numberOfTrees != 2 && numberOfTrees != 3) {
            throw new IllegalArgumentException("The number of trees must be 2 or 3");
        }
        this.dictionarySize = dictionarySize;
        this.numberOfTrees = numberOfTrees;
        this.minimumMatchLength = numberOfTrees;
        this.f569in = in;
    }

    private void init() throws IOException {
        if (this.bits == null) {
            if (this.numberOfTrees == 3) {
                this.literalTree = BinaryTree.decode(this.f569in, 256);
            }
            this.lengthTree = BinaryTree.decode(this.f569in, 64);
            this.distanceTree = BinaryTree.decode(this.f569in, 64);
            this.bits = new BitStream(this.f569in);
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (!this.buffer.available()) {
            fillBuffer();
        }
        return this.buffer.get();
    }

    private void fillBuffer() throws IOException {
        int literal;
        init();
        int bit = this.bits.nextBit();
        if (bit == 1) {
            if (this.literalTree != null) {
                literal = this.literalTree.read(this.bits);
            } else {
                literal = this.bits.nextByte();
            }
            if (literal == -1) {
                return;
            }
            this.buffer.put(literal);
            return;
        }
        if (bit == 0) {
            int distanceLowSize = this.dictionarySize == 4096 ? 6 : 7;
            int distanceLow = (int) this.bits.nextBits(distanceLowSize);
            int distanceHigh = this.distanceTree.read(this.bits);
            if (distanceHigh == -1 && distanceLow <= 0) {
                return;
            }
            int distance = (distanceHigh << distanceLowSize) | distanceLow;
            int length = this.lengthTree.read(this.bits);
            if (length == 63) {
                length = (int) (((long) length) + this.bits.nextBits(8));
            }
            this.buffer.copy(distance + 1, length + this.minimumMatchLength);
        }
    }
}
