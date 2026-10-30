package org.apache.commons.compress.archivers.sevenz;

import androidx.compose.p001ui.geometry.InlineClassHelperKt;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.zip.CRC32;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.commons.compress.utils.BoundedInputStream;
import org.apache.commons.compress.utils.CRC32VerifyingInputStream;
import org.apache.commons.compress.utils.CharsetNames;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: loaded from: classes18.dex */
public class SevenZFile implements Closeable {
    static final int SIGNATURE_HEADER_SIZE = 32;
    static final byte[] sevenZSignature = {TarConstants.LF_CONTIG, 122, -68, -81, 39, 28};
    private final Archive archive;
    private int currentEntryIndex;
    private int currentFolderIndex;
    private InputStream currentFolderInputStream;
    private final ArrayList<InputStream> deferredBlockStreams;
    private RandomAccessFile file;
    private final String fileName;
    private byte[] password;

    public SevenZFile(File filename, byte[] password) throws IOException {
        this.currentEntryIndex = -1;
        this.currentFolderIndex = -1;
        this.currentFolderInputStream = null;
        this.deferredBlockStreams = new ArrayList<>();
        boolean succeeded = false;
        this.file = new RandomAccessFile(filename, "r");
        this.fileName = filename.getAbsolutePath();
        try {
            this.archive = readHeaders(password);
            if (password != null) {
                this.password = new byte[password.length];
                System.arraycopy(password, 0, this.password, 0, password.length);
            } else {
                this.password = null;
            }
            succeeded = true;
        } finally {
            if (!succeeded) {
                this.file.close();
            }
        }
    }

    public SevenZFile(File filename) throws IOException {
        this(filename, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.file != null) {
            try {
                this.file.close();
            } finally {
                this.file = null;
                if (this.password != null) {
                    Arrays.fill(this.password, (byte) 0);
                }
                this.password = null;
            }
        }
    }

    public SevenZArchiveEntry getNextEntry() throws IOException {
        if (this.currentEntryIndex >= this.archive.files.length - 1) {
            return null;
        }
        this.currentEntryIndex++;
        SevenZArchiveEntry entry = this.archive.files[this.currentEntryIndex];
        buildDecodingStream();
        return entry;
    }

    public Iterable<SevenZArchiveEntry> getEntries() {
        return Arrays.asList(this.archive.files);
    }

    private Archive readHeaders(byte[] password) throws IOException {
        byte[] signature = new byte[6];
        this.file.readFully(signature);
        if (!Arrays.equals(signature, sevenZSignature)) {
            throw new IOException("Bad 7z signature");
        }
        byte archiveVersionMajor = this.file.readByte();
        byte archiveVersionMinor = this.file.readByte();
        if (archiveVersionMajor != 0) {
            throw new IOException(String.format("Unsupported 7z version (%d,%d)", Byte.valueOf(archiveVersionMajor), Byte.valueOf(archiveVersionMinor)));
        }
        long startHeaderCrc = ((long) Integer.reverseBytes(this.file.readInt())) & 4294967295L;
        StartHeader startHeader = readStartHeader(startHeaderCrc);
        int nextHeaderSizeInt = (int) startHeader.nextHeaderSize;
        if (nextHeaderSizeInt != startHeader.nextHeaderSize) {
            throw new IOException("cannot handle nextHeaderSize " + startHeader.nextHeaderSize);
        }
        this.file.seek(startHeader.nextHeaderOffset + 32);
        byte[] nextHeader = new byte[nextHeaderSizeInt];
        this.file.readFully(nextHeader);
        CRC32 crc = new CRC32();
        crc.update(nextHeader);
        if (startHeader.nextHeaderCrc != crc.getValue()) {
            throw new IOException("NextHeader CRC mismatch");
        }
        ByteArrayInputStream byteStream = new ByteArrayInputStream(nextHeader);
        DataInputStream nextHeaderInputStream = new DataInputStream(byteStream);
        Archive archive = new Archive();
        int nid = nextHeaderInputStream.readUnsignedByte();
        if (nid == 23) {
            nextHeaderInputStream = readEncodedHeader(nextHeaderInputStream, archive, password);
            archive = new Archive();
            nid = nextHeaderInputStream.readUnsignedByte();
        }
        if (nid == 1) {
            readHeader(nextHeaderInputStream, archive);
            nextHeaderInputStream.close();
            return archive;
        }
        throw new IOException("Broken or unsupported archive: no Header");
    }

    private StartHeader readStartHeader(long startHeaderCrc) throws IOException {
        StartHeader startHeader = new StartHeader();
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(new CRC32VerifyingInputStream(new BoundedRandomAccessFileInputStream(this.file, 20L), 20L, startHeaderCrc));
            startHeader.nextHeaderOffset = Long.reverseBytes(dataInputStream.readLong());
            startHeader.nextHeaderSize = Long.reverseBytes(dataInputStream.readLong());
            startHeader.nextHeaderCrc = ((long) Integer.reverseBytes(dataInputStream.readInt())) & 4294967295L;
            dataInputStream.close();
            return startHeader;
        } catch (Throwable th) {
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            throw th;
        }
    }

    private void readHeader(DataInput header, Archive archive) throws IOException {
        int nid = header.readUnsignedByte();
        if (nid == 2) {
            readArchiveProperties(header);
            nid = header.readUnsignedByte();
        }
        if (nid == 3) {
            throw new IOException("Additional streams unsupported");
        }
        if (nid == 4) {
            readStreamsInfo(header, archive);
            nid = header.readUnsignedByte();
        }
        if (nid == 5) {
            readFilesInfo(header, archive);
            nid = header.readUnsignedByte();
        }
        if (nid != 0) {
            throw new IOException("Badly terminated header, found " + nid);
        }
    }

    private void readArchiveProperties(DataInput input) throws IOException {
        int nid = input.readUnsignedByte();
        while (nid != 0) {
            long propertySize = readUint64(input);
            byte[] property = new byte[(int) propertySize];
            input.readFully(property);
            nid = input.readUnsignedByte();
        }
    }

    private DataInputStream readEncodedHeader(DataInputStream header, Archive archive, byte[] password) throws IOException {
        InputStream inputStreamStack;
        readStreamsInfo(header, archive);
        Folder folder = archive.folders[0];
        long folderOffset = archive.packPos + 32 + 0;
        this.file.seek(folderOffset);
        InputStream inputStreamStack2 = new BoundedRandomAccessFileInputStream(this.file, archive.packSizes[0]);
        for (Coder coder : folder.getOrderedCoders()) {
            if (coder.numInStreams != 1 || coder.numOutStreams != 1) {
                throw new IOException("Multi input/output stream coders are not yet supported");
            }
            inputStreamStack2 = Coders.addDecoder(this.fileName, inputStreamStack2, folder.getUnpackSizeForCoder(coder), coder, password);
        }
        if (!folder.hasCrc) {
            inputStreamStack = inputStreamStack2;
        } else {
            inputStreamStack = new CRC32VerifyingInputStream(inputStreamStack2, folder.getUnpackSize(), folder.crc);
        }
        byte[] nextHeader = new byte[(int) folder.getUnpackSize()];
        DataInputStream nextHeaderInputStream = new DataInputStream(inputStreamStack);
        try {
            nextHeaderInputStream.readFully(nextHeader);
            return new DataInputStream(new ByteArrayInputStream(nextHeader));
        } finally {
            nextHeaderInputStream.close();
        }
    }

    private void readStreamsInfo(DataInput header, Archive archive) throws IOException {
        int nid = header.readUnsignedByte();
        if (nid == 6) {
            readPackInfo(header, archive);
            nid = header.readUnsignedByte();
        }
        if (nid == 7) {
            readUnpackInfo(header, archive);
            nid = header.readUnsignedByte();
        } else {
            archive.folders = new Folder[0];
        }
        if (nid == 8) {
            readSubStreamsInfo(header, archive);
            nid = header.readUnsignedByte();
        }
        if (nid != 0) {
            throw new IOException("Badly terminated StreamsInfo");
        }
    }

    private void readPackInfo(DataInput header, Archive archive) throws IOException {
        archive.packPos = readUint64(header);
        long numPackStreams = readUint64(header);
        int nid = header.readUnsignedByte();
        if (nid == 9) {
            archive.packSizes = new long[(int) numPackStreams];
            for (int i = 0; i < archive.packSizes.length; i++) {
                archive.packSizes[i] = readUint64(header);
            }
            nid = header.readUnsignedByte();
        }
        if (nid == 10) {
            archive.packCrcsDefined = readAllOrBits(header, (int) numPackStreams);
            archive.packCrcs = new long[(int) numPackStreams];
            for (int i2 = 0; i2 < ((int) numPackStreams); i2++) {
                if (archive.packCrcsDefined.get(i2)) {
                    archive.packCrcs[i2] = ((long) Integer.reverseBytes(header.readInt())) & 4294967295L;
                }
            }
            nid = header.readUnsignedByte();
        }
        if (nid != 0) {
            throw new IOException("Badly terminated PackInfo (" + nid + ")");
        }
    }

    private void readUnpackInfo(DataInput header, Archive archive) throws IOException {
        int nid = header.readUnsignedByte();
        if (nid != 11) {
            throw new IOException("Expected kFolder, got " + nid);
        }
        long numFolders = readUint64(header);
        Folder[] folders = new Folder[(int) numFolders];
        archive.folders = folders;
        int external = header.readUnsignedByte();
        if (external != 0) {
            throw new IOException("External unsupported");
        }
        for (int i = 0; i < ((int) numFolders); i++) {
            folders[i] = readFolder(header);
        }
        int nid2 = header.readUnsignedByte();
        if (nid2 != 12) {
            throw new IOException("Expected kCodersUnpackSize, got " + nid2);
        }
        for (Folder folder : folders) {
            folder.unpackSizes = new long[(int) folder.totalOutputStreams];
            for (int i2 = 0; i2 < folder.totalOutputStreams; i2++) {
                folder.unpackSizes[i2] = readUint64(header);
            }
        }
        int nid3 = header.readUnsignedByte();
        if (nid3 == 10) {
            BitSet crcsDefined = readAllOrBits(header, (int) numFolders);
            for (int i3 = 0; i3 < ((int) numFolders); i3++) {
                if (crcsDefined.get(i3)) {
                    folders[i3].hasCrc = true;
                    folders[i3].crc = ((long) Integer.reverseBytes(header.readInt())) & 4294967295L;
                } else {
                    folders[i3].hasCrc = false;
                }
            }
            nid3 = header.readUnsignedByte();
        }
        if (nid3 != 0) {
            throw new IOException("Badly terminated UnpackInfo");
        }
    }

    private void readSubStreamsInfo(DataInput header, Archive archive) throws IOException {
        SubStreamsInfo subStreamsInfo;
        int totalUnpackStreams;
        SubStreamsInfo subStreamsInfo2;
        for (Folder folder : archive.folders) {
            folder.numUnpackSubStreams = 1;
        }
        int totalUnpackStreams2 = archive.folders.length;
        int nid = header.readUnsignedByte();
        if (nid == 13) {
            totalUnpackStreams2 = 0;
            Folder[] arr$ = archive.folders;
            for (Folder folder2 : arr$) {
                long numStreams = readUint64(header);
                folder2.numUnpackSubStreams = (int) numStreams;
                totalUnpackStreams2 = (int) (((long) totalUnpackStreams2) + numStreams);
            }
            nid = header.readUnsignedByte();
        }
        SubStreamsInfo subStreamsInfo3 = new SubStreamsInfo();
        subStreamsInfo3.unpackSizes = new long[totalUnpackStreams2];
        subStreamsInfo3.hasCrc = new BitSet(totalUnpackStreams2);
        subStreamsInfo3.crcs = new long[totalUnpackStreams2];
        int nextUnpackStream = 0;
        Folder[] arr$2 = archive.folders;
        for (Folder folder3 : arr$2) {
            if (folder3.numUnpackSubStreams != 0) {
                long sum = 0;
                if (nid == 9) {
                    int i = 0;
                    while (i < folder3.numUnpackSubStreams - 1) {
                        long size = readUint64(header);
                        subStreamsInfo3.unpackSizes[nextUnpackStream] = size;
                        sum += size;
                        i++;
                        nextUnpackStream++;
                    }
                }
                subStreamsInfo3.unpackSizes[nextUnpackStream] = folder3.getUnpackSize() - sum;
                nextUnpackStream++;
            }
        }
        if (nid == 9) {
            nid = header.readUnsignedByte();
        }
        int numDigests = 0;
        Folder[] arr$3 = archive.folders;
        for (Folder folder4 : arr$3) {
            if (folder4.numUnpackSubStreams != 1 || !folder4.hasCrc) {
                numDigests += folder4.numUnpackSubStreams;
            }
        }
        if (nid == 10) {
            BitSet hasMissingCrc = readAllOrBits(header, numDigests);
            long[] missingCrcs = new long[numDigests];
            for (int i2 = 0; i2 < numDigests; i2++) {
                if (hasMissingCrc.get(i2)) {
                    missingCrcs[i2] = ((long) Integer.reverseBytes(header.readInt())) & 4294967295L;
                }
            }
            int nextCrc = 0;
            int nextMissingCrc = 0;
            Folder[] arr$4 = archive.folders;
            int len$ = arr$4.length;
            int i$ = 0;
            while (i$ < len$) {
                Folder folder5 = arr$4[i$];
                int totalUnpackStreams3 = totalUnpackStreams2;
                int totalUnpackStreams4 = folder5.numUnpackSubStreams;
                int nid2 = nid;
                if (totalUnpackStreams4 != 1 || !folder5.hasCrc) {
                    SubStreamsInfo subStreamsInfo4 = subStreamsInfo3;
                    int i3 = 0;
                    while (i3 < folder5.numUnpackSubStreams) {
                        SubStreamsInfo subStreamsInfo5 = subStreamsInfo4;
                        subStreamsInfo5.hasCrc.set(nextCrc, hasMissingCrc.get(nextMissingCrc));
                        subStreamsInfo5.crcs[nextCrc] = missingCrcs[nextMissingCrc];
                        nextCrc++;
                        nextMissingCrc++;
                        i3++;
                        folder5 = folder5;
                        subStreamsInfo4 = subStreamsInfo5;
                    }
                    subStreamsInfo2 = subStreamsInfo4;
                } else {
                    subStreamsInfo3.hasCrc.set(nextCrc, true);
                    subStreamsInfo3.crcs[nextCrc] = folder5.crc;
                    nextCrc++;
                    subStreamsInfo2 = subStreamsInfo3;
                }
                i$++;
                subStreamsInfo3 = subStreamsInfo2;
                totalUnpackStreams2 = totalUnpackStreams3;
                nid = nid2;
            }
            subStreamsInfo = subStreamsInfo3;
            totalUnpackStreams = header.readUnsignedByte();
        } else {
            int nid3 = nid;
            subStreamsInfo = subStreamsInfo3;
            totalUnpackStreams = nid3;
        }
        if (totalUnpackStreams != 0) {
            throw new IOException("Badly terminated SubStreamsInfo");
        }
        archive.subStreamsInfo = subStreamsInfo;
    }

    private Folder readFolder(DataInput header) throws IOException {
        Folder folder = new Folder();
        long numCoders = readUint64(header);
        Coder[] coders = new Coder[(int) numCoders];
        long totalInStreams = 0;
        long totalOutStreams = 0;
        int i = 0;
        while (i < coders.length) {
            coders[i] = new Coder();
            int bits = header.readUnsignedByte();
            int idSize = bits & 15;
            boolean isSimple = (bits & 16) == 0;
            boolean hasAttributes = (bits & 32) != 0;
            boolean moreAlternativeMethods = (bits & 128) != 0;
            coders[i].decompressionMethodId = new byte[idSize];
            header.readFully(coders[i].decompressionMethodId);
            if (isSimple) {
                coders[i].numInStreams = 1L;
                coders[i].numOutStreams = 1L;
            } else {
                coders[i].numInStreams = readUint64(header);
                coders[i].numOutStreams = readUint64(header);
            }
            totalInStreams += coders[i].numInStreams;
            totalOutStreams += coders[i].numOutStreams;
            if (hasAttributes) {
                long propertiesSize = readUint64(header);
                coders[i].properties = new byte[(int) propertiesSize];
                header.readFully(coders[i].properties);
            }
            if (!moreAlternativeMethods) {
                i++;
                numCoders = numCoders;
            } else {
                throw new IOException("Alternative methods are unsupported, please report. The reference implementation doesn't support them either.");
            }
        }
        folder.coders = coders;
        folder.totalInputStreams = totalInStreams;
        folder.totalOutputStreams = totalOutStreams;
        if (totalOutStreams == 0) {
            throw new IOException("Total output streams can't be 0");
        }
        long numBindPairs = totalOutStreams - 1;
        BindPair[] bindPairs = new BindPair[(int) numBindPairs];
        for (int i2 = 0; i2 < bindPairs.length; i2++) {
            bindPairs[i2] = new BindPair();
            bindPairs[i2].inIndex = readUint64(header);
            bindPairs[i2].outIndex = readUint64(header);
        }
        folder.bindPairs = bindPairs;
        if (totalInStreams < numBindPairs) {
            throw new IOException("Total input streams can't be less than the number of bind pairs");
        }
        long numPackedStreams = totalInStreams - numBindPairs;
        long[] packedStreams = new long[(int) numPackedStreams];
        if (numPackedStreams == 1) {
            int i3 = 0;
            while (i3 < ((int) totalInStreams) && folder.findBindPairForInStream(i3) >= 0) {
                i3++;
            }
            if (i3 == ((int) totalInStreams)) {
                throw new IOException("Couldn't find stream's bind pair index");
            }
            packedStreams[0] = i3;
        } else {
            for (int i4 = 0; i4 < ((int) numPackedStreams); i4++) {
                packedStreams[i4] = readUint64(header);
            }
        }
        folder.packedStreams = packedStreams;
        return folder;
    }

    private BitSet readAllOrBits(DataInput header, int size) throws IOException {
        int areAllDefined = header.readUnsignedByte();
        if (areAllDefined != 0) {
            BitSet bits = new BitSet(size);
            for (int i = 0; i < size; i++) {
                bits.set(i, true);
            }
            return bits;
        }
        return readBits(header, size);
    }

    private BitSet readBits(DataInput header, int size) throws IOException {
        BitSet bits = new BitSet(size);
        int mask = 0;
        int cache = 0;
        for (int i = 0; i < size; i++) {
            if (mask == 0) {
                mask = 128;
                cache = header.readUnsignedByte();
            }
            bits.set(i, (cache & mask) != 0);
            mask >>>= 1;
        }
        return bits;
    }

    private void readFilesInfo(DataInput header, Archive archive) throws IOException {
        long numFiles;
        BitSet isEmptyFile;
        long numFiles2 = readUint64(header);
        SevenZArchiveEntry[] files = new SevenZArchiveEntry[(int) numFiles2];
        for (int i = 0; i < files.length; i++) {
            files[i] = new SevenZArchiveEntry();
        }
        BitSet isEmptyStream = null;
        BitSet isEmptyFile2 = null;
        BitSet isAnti = null;
        while (true) {
            int propertyType = header.readUnsignedByte();
            if (propertyType != 0) {
                long size = readUint64(header);
                switch (propertyType) {
                    case 14:
                        numFiles = numFiles2;
                        BitSet isEmptyStream2 = readBits(header, files.length);
                        isEmptyStream = isEmptyStream2;
                        continue;
                        numFiles2 = numFiles;
                        break;
                    case 15:
                        numFiles = numFiles2;
                        if (isEmptyStream != null) {
                            BitSet isEmptyFile3 = readBits(header, isEmptyStream.cardinality());
                            isEmptyFile2 = isEmptyFile3;
                            continue;
                            numFiles2 = numFiles;
                        } else {
                            throw new IOException("Header format error: kEmptyStream must appear before kEmptyFile");
                        }
                        break;
                    case 16:
                        numFiles = numFiles2;
                        BitSet isEmptyFile4 = isEmptyFile2;
                        if (isEmptyStream != null) {
                            BitSet isAnti2 = readBits(header, isEmptyStream.cardinality());
                            isAnti = isAnti2;
                            isEmptyFile2 = isEmptyFile4;
                            continue;
                            numFiles2 = numFiles;
                        } else {
                            throw new IOException("Header format error: kEmptyStream must appear before kAnti");
                        }
                        break;
                    case 17:
                        numFiles = numFiles2;
                        int external = header.readUnsignedByte();
                        if (external != 0) {
                            throw new IOException("Not implemented");
                        }
                        if (((size - 1) & 1) != 0) {
                            throw new IOException("File names length invalid");
                        }
                        byte[] names = new byte[(int) (size - 1)];
                        header.readFully(names);
                        int nextFile = 0;
                        int nextName = 0;
                        int i2 = 0;
                        while (i2 < names.length) {
                            if (names[i2] == 0 && names[i2 + 1] == 0) {
                                files[nextFile].setName(new String(names, nextName, i2 - nextName, CharsetNames.UTF_16LE));
                                nextName = i2 + 2;
                                nextFile++;
                            }
                            i2 += 2;
                            external = external;
                            isEmptyFile2 = isEmptyFile2;
                        }
                        isEmptyFile = isEmptyFile2;
                        if (nextName != names.length || nextFile != files.length) {
                            throw new IOException("Error parsing file names");
                        }
                        break;
                    case 18:
                        numFiles = numFiles2;
                        BitSet timesDefined = readAllOrBits(header, files.length);
                        if (header.readUnsignedByte() != 0) {
                            throw new IOException("Unimplemented");
                        }
                        for (int i3 = 0; i3 < files.length; i3++) {
                            files[i3].setHasCreationDate(timesDefined.get(i3));
                            if (files[i3].getHasCreationDate()) {
                                files[i3].setCreationDate(Long.reverseBytes(header.readLong()));
                            }
                        }
                        isEmptyFile = isEmptyFile2;
                        break;
                        break;
                    case 19:
                        numFiles = numFiles2;
                        BitSet timesDefined2 = readAllOrBits(header, files.length);
                        if (header.readUnsignedByte() != 0) {
                            throw new IOException("Unimplemented");
                        }
                        for (int i4 = 0; i4 < files.length; i4++) {
                            files[i4].setHasAccessDate(timesDefined2.get(i4));
                            if (files[i4].getHasAccessDate()) {
                                files[i4].setAccessDate(Long.reverseBytes(header.readLong()));
                            }
                        }
                        isEmptyFile = isEmptyFile2;
                        break;
                        break;
                    case 20:
                        BitSet timesDefined3 = readAllOrBits(header, files.length);
                        if (header.readUnsignedByte() != 0) {
                            throw new IOException("Unimplemented");
                        }
                        int i5 = 0;
                        while (i5 < files.length) {
                            files[i5].setHasLastModifiedDate(timesDefined3.get(i5));
                            if (files[i5].getHasLastModifiedDate()) {
                                files[i5].setLastModifiedDate(Long.reverseBytes(header.readLong()));
                            }
                            i5++;
                            timesDefined3 = timesDefined3;
                            numFiles2 = numFiles2;
                        }
                        numFiles = numFiles2;
                        isEmptyFile = isEmptyFile2;
                        break;
                        break;
                    case 21:
                        BitSet attributesDefined = readAllOrBits(header, files.length);
                        if (header.readUnsignedByte() != 0) {
                            throw new IOException("Unimplemented");
                        }
                        for (int i6 = 0; i6 < files.length; i6++) {
                            files[i6].setHasWindowsAttributes(attributesDefined.get(i6));
                            if (files[i6].getHasWindowsAttributes()) {
                                files[i6].setWindowsAttributes(Integer.reverseBytes(header.readInt()));
                            }
                        }
                        numFiles = numFiles2;
                        isEmptyFile = isEmptyFile2;
                        break;
                        break;
                    case 22:
                    case 23:
                    default:
                        numFiles = numFiles2;
                        isEmptyFile = isEmptyFile2;
                        if (skipBytesFully(header, size) < size) {
                            throw new IOException("Incomplete property of type " + propertyType);
                        }
                        break;
                    case 24:
                        throw new IOException("kStartPos is unsupported, please report");
                    case 25:
                        if (skipBytesFully(header, size) < size) {
                            throw new IOException("Incomplete kDummy property");
                        }
                        numFiles = numFiles2;
                        isEmptyFile = isEmptyFile2;
                        break;
                        break;
                }
                isEmptyFile2 = isEmptyFile;
                numFiles2 = numFiles;
            } else {
                int nonEmptyFileCounter = 0;
                int emptyFileCounter = 0;
                for (int i7 = 0; i7 < files.length; i7++) {
                    files[i7].setHasStream(isEmptyStream == null || !isEmptyStream.get(i7));
                    if (files[i7].hasStream()) {
                        files[i7].setDirectory(false);
                        files[i7].setAntiItem(false);
                        files[i7].setHasCrc(archive.subStreamsInfo.hasCrc.get(nonEmptyFileCounter));
                        files[i7].setCrcValue(archive.subStreamsInfo.crcs[nonEmptyFileCounter]);
                        files[i7].setSize(archive.subStreamsInfo.unpackSizes[nonEmptyFileCounter]);
                        nonEmptyFileCounter++;
                    } else {
                        files[i7].setDirectory(isEmptyFile2 == null || !isEmptyFile2.get(emptyFileCounter));
                        files[i7].setAntiItem(isAnti == null ? false : isAnti.get(emptyFileCounter));
                        files[i7].setHasCrc(false);
                        files[i7].setSize(0L);
                        emptyFileCounter++;
                    }
                }
                archive.files = files;
                calculateStreamMap(archive);
                return;
            }
        }
    }

    private void calculateStreamMap(Archive archive) throws IOException {
        StreamMap streamMap = new StreamMap();
        int nextFolderPackStreamIndex = 0;
        int numFolders = archive.folders != null ? archive.folders.length : 0;
        streamMap.folderFirstPackStreamIndex = new int[numFolders];
        for (int i = 0; i < numFolders; i++) {
            streamMap.folderFirstPackStreamIndex[i] = nextFolderPackStreamIndex;
            nextFolderPackStreamIndex += archive.folders[i].packedStreams.length;
        }
        long nextPackStreamOffset = 0;
        int numPackSizes = archive.packSizes != null ? archive.packSizes.length : 0;
        streamMap.packStreamOffsets = new long[numPackSizes];
        for (int i2 = 0; i2 < numPackSizes; i2++) {
            streamMap.packStreamOffsets[i2] = nextPackStreamOffset;
            nextPackStreamOffset += archive.packSizes[i2];
        }
        streamMap.folderFirstFileIndex = new int[numFolders];
        streamMap.fileFolderIndex = new int[archive.files.length];
        int nextFolderIndex = 0;
        int nextFolderUnpackStreamIndex = 0;
        for (int i3 = 0; i3 < archive.files.length; i3++) {
            if (!archive.files[i3].hasStream() && nextFolderUnpackStreamIndex == 0) {
                streamMap.fileFolderIndex[i3] = -1;
            } else {
                if (nextFolderUnpackStreamIndex == 0) {
                    while (nextFolderIndex < archive.folders.length) {
                        streamMap.folderFirstFileIndex[nextFolderIndex] = i3;
                        if (archive.folders[nextFolderIndex].numUnpackSubStreams > 0) {
                            break;
                        } else {
                            nextFolderIndex++;
                        }
                    }
                    if (nextFolderIndex >= archive.folders.length) {
                        throw new IOException("Too few folders in archive");
                    }
                }
                streamMap.fileFolderIndex[i3] = nextFolderIndex;
                if (archive.files[i3].hasStream() && (nextFolderUnpackStreamIndex = nextFolderUnpackStreamIndex + 1) >= archive.folders[nextFolderIndex].numUnpackSubStreams) {
                    nextFolderIndex++;
                    nextFolderUnpackStreamIndex = 0;
                }
            }
        }
        archive.streamMap = streamMap;
    }

    private void buildDecodingStream() throws IOException {
        InputStream fileStream;
        int folderIndex = this.archive.streamMap.fileFolderIndex[this.currentEntryIndex];
        if (folderIndex >= 0) {
            SevenZArchiveEntry file = this.archive.files[this.currentEntryIndex];
            if (this.currentFolderIndex == folderIndex) {
                file.setContentMethods(this.archive.files[this.currentEntryIndex - 1].getContentMethods());
            } else {
                this.currentFolderIndex = folderIndex;
                this.deferredBlockStreams.clear();
                if (this.currentFolderInputStream != null) {
                    this.currentFolderInputStream.close();
                    this.currentFolderInputStream = null;
                }
                Folder folder = this.archive.folders[folderIndex];
                int firstPackStreamIndex = this.archive.streamMap.folderFirstPackStreamIndex[folderIndex];
                long folderOffset = this.archive.packPos + 32 + this.archive.streamMap.packStreamOffsets[firstPackStreamIndex];
                this.currentFolderInputStream = buildDecoderStack(folder, folderOffset, firstPackStreamIndex, file);
            }
            InputStream fileStream2 = new BoundedInputStream(this.currentFolderInputStream, file.getSize());
            if (!file.getHasCrc()) {
                fileStream = fileStream2;
            } else {
                fileStream = new CRC32VerifyingInputStream(fileStream2, file.getSize(), file.getCrcValue());
            }
            this.deferredBlockStreams.add(fileStream);
            return;
        }
        this.deferredBlockStreams.clear();
    }

    private InputStream buildDecoderStack(Folder folder, long folderOffset, int firstPackStreamIndex, SevenZArchiveEntry entry) throws IOException {
        this.file.seek(folderOffset);
        InputStream inputStreamStack = new BufferedInputStream(new BoundedRandomAccessFileInputStream(this.file, this.archive.packSizes[firstPackStreamIndex]));
        LinkedList<SevenZMethodConfiguration> methods = new LinkedList<>();
        for (Coder coder : folder.getOrderedCoders()) {
            if (coder.numInStreams != 1 || coder.numOutStreams != 1) {
                throw new IOException("Multi input/output stream coders are not yet supported");
            }
            SevenZMethod method = SevenZMethod.byId(coder.decompressionMethodId);
            inputStreamStack = Coders.addDecoder(this.fileName, inputStreamStack, folder.getUnpackSizeForCoder(coder), coder, this.password);
            methods.addFirst(new SevenZMethodConfiguration(method, Coders.findByMethod(method).getOptionsFromCoder(coder, inputStreamStack)));
        }
        entry.setContentMethods(methods);
        if (folder.hasCrc) {
            return new CRC32VerifyingInputStream(inputStreamStack, folder.getUnpackSize(), folder.crc);
        }
        return inputStreamStack;
    }

    public int read() throws IOException {
        return getCurrentStream().read();
    }

    private InputStream getCurrentStream() throws IOException {
        if (this.archive.files[this.currentEntryIndex].getSize() == 0) {
            return new ByteArrayInputStream(new byte[0]);
        }
        if (this.deferredBlockStreams.isEmpty()) {
            throw new IllegalStateException("No current 7z entry (call getNextEntry() first).");
        }
        while (this.deferredBlockStreams.size() > 1) {
            InputStream stream = this.deferredBlockStreams.remove(0);
            IOUtils.skip(stream, Long.MAX_VALUE);
            stream.close();
        }
        return this.deferredBlockStreams.get(0);
    }

    public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    public int read(byte[] b, int off, int len) throws IOException {
        return getCurrentStream().read(b, off, len);
    }

    private static long readUint64(DataInput in) throws IOException {
        long firstByte = in.readUnsignedByte();
        int mask = 128;
        long value = 0;
        for (int i = 0; i < 8; i++) {
            if ((((long) mask) & firstByte) == 0) {
                return ((((long) (mask - 1)) & firstByte) << (i * 8)) | value;
            }
            long nextByte = in.readUnsignedByte();
            value |= nextByte << (i * 8);
            mask >>>= 1;
        }
        return value;
    }

    public static boolean matches(byte[] signature, int length) {
        if (length < sevenZSignature.length) {
            return false;
        }
        for (int i = 0; i < sevenZSignature.length; i++) {
            if (signature[i] != sevenZSignature[i]) {
                return false;
            }
        }
        return true;
    }

    private static long skipBytesFully(DataInput input, long bytesToSkip) throws IOException {
        if (bytesToSkip < 1) {
            return 0L;
        }
        long skipped = 0;
        while (bytesToSkip > InlineClassHelperKt.FloatNonFiniteMask) {
            long skippedNow = skipBytesFully(input, InlineClassHelperKt.FloatNonFiniteMask);
            if (skippedNow == 0) {
                return skipped;
            }
            skipped += skippedNow;
            bytesToSkip -= skippedNow;
        }
        while (bytesToSkip > 0) {
            int skippedNow2 = input.skipBytes((int) bytesToSkip);
            if (skippedNow2 == 0) {
                return skipped;
            }
            skipped += (long) skippedNow2;
            bytesToSkip -= (long) skippedNow2;
        }
        return skipped;
    }

    public String toString() {
        return this.archive.toString();
    }
}
