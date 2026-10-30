package org.apache.commons.compress.archivers.tar;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.utils.ArchiveUtils;

/* JADX INFO: loaded from: classes18.dex */
public class TarArchiveEntry implements TarConstants, ArchiveEntry {
    public static final int DEFAULT_DIR_MODE = 16877;
    public static final int DEFAULT_FILE_MODE = 33188;
    private static final TarArchiveEntry[] EMPTY_TAR_ARCHIVE_ENTRIES = new TarArchiveEntry[0];
    public static final int MAX_NAMELEN = 31;
    public static final int MILLIS_PER_SECOND = 1000;
    private boolean checkSumOK;
    private int devMajor;
    private int devMinor;
    private final File file;
    private long groupId;
    private String groupName;
    private boolean isExtended;
    private byte linkFlag;
    private String linkName;
    private String magic;
    private long modTime;
    private int mode;
    private String name;
    private boolean paxGNUSparse;
    private boolean preserveLeadingSlashes;
    private long realSize;
    private long size;
    private boolean starSparse;
    private long userId;
    private String userName;
    private String version;

    private TarArchiveEntry() {
        this.name = "";
        this.userId = 0L;
        this.groupId = 0L;
        this.size = 0L;
        this.linkName = "";
        this.magic = "ustar\u0000";
        this.version = TarConstants.VERSION_POSIX;
        this.groupName = "";
        this.devMajor = 0;
        this.devMinor = 0;
        String user = System.getProperty("user.name", "");
        this.userName = user.length() > 31 ? user.substring(0, 31) : user;
        this.file = null;
    }

    public TarArchiveEntry(String name) {
        this(name, false);
    }

    public TarArchiveEntry(String name, boolean preserveLeadingSlashes) {
        this();
        this.preserveLeadingSlashes = preserveLeadingSlashes;
        String name2 = normalizeFileName(name, preserveLeadingSlashes);
        boolean isDir = name2.endsWith("/");
        this.name = name2;
        this.mode = isDir ? DEFAULT_DIR_MODE : DEFAULT_FILE_MODE;
        this.linkFlag = isDir ? TarConstants.LF_DIR : TarConstants.LF_NORMAL;
        this.modTime = new Date().getTime() / 1000;
        this.userName = "";
    }

    public TarArchiveEntry(String name, byte linkFlag) {
        this(name, linkFlag, false);
    }

    public TarArchiveEntry(String name, byte linkFlag, boolean preserveLeadingSlashes) {
        this(name, preserveLeadingSlashes);
        this.linkFlag = linkFlag;
        if (linkFlag == 76) {
            this.magic = TarConstants.MAGIC_GNU;
            this.version = TarConstants.VERSION_GNU_SPACE;
        }
    }

    public TarArchiveEntry(File file) {
        this(file, file.getPath());
    }

    public TarArchiveEntry(File file, String fileName) {
        this.name = "";
        this.userId = 0L;
        this.groupId = 0L;
        this.size = 0L;
        this.linkName = "";
        this.magic = "ustar\u0000";
        this.version = TarConstants.VERSION_POSIX;
        this.groupName = "";
        this.devMajor = 0;
        this.devMinor = 0;
        String normalizedName = normalizeFileName(fileName, false);
        this.file = file;
        if (file.isDirectory()) {
            this.mode = DEFAULT_DIR_MODE;
            this.linkFlag = TarConstants.LF_DIR;
            int nameLength = normalizedName.length();
            if (nameLength == 0 || normalizedName.charAt(nameLength - 1) != '/') {
                this.name = normalizedName + "/";
            } else {
                this.name = normalizedName;
            }
        } else {
            this.mode = DEFAULT_FILE_MODE;
            this.linkFlag = TarConstants.LF_NORMAL;
            this.size = file.length();
            this.name = normalizedName;
        }
        this.modTime = file.lastModified() / 1000;
        this.userName = "";
    }

    public TarArchiveEntry(byte[] headerBuf) {
        this();
        parseTarHeader(headerBuf);
    }

    public TarArchiveEntry(byte[] headerBuf, ZipEncoding encoding) throws IOException {
        this();
        parseTarHeader(headerBuf, encoding);
    }

    public boolean equals(TarArchiveEntry it) {
        return getName().equals(it.getName());
    }

    public boolean equals(Object it) {
        if (it == null || getClass() != it.getClass()) {
            return false;
        }
        return equals((TarArchiveEntry) it);
    }

    public int hashCode() {
        return getName().hashCode();
    }

    public boolean isDescendent(TarArchiveEntry desc) {
        return desc.getName().startsWith(getName());
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = normalizeFileName(name, this.preserveLeadingSlashes);
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getLinkName() {
        return this.linkName;
    }

    public void setLinkName(String link) {
        this.linkName = link;
    }

    @Deprecated
    public int getUserId() {
        return (int) (this.userId & (-1));
    }

    public void setUserId(int userId) {
        setUserId(userId);
    }

    public long getLongUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Deprecated
    public int getGroupId() {
        return (int) (this.groupId & (-1));
    }

    public void setGroupId(int groupId) {
        setGroupId(groupId);
    }

    public long getLongGroupId() {
        return this.groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setIds(int userId, int groupId) {
        setUserId(userId);
        setGroupId(groupId);
    }

    public void setNames(String userName, String groupName) {
        setUserName(userName);
        setGroupName(groupName);
    }

    public void setModTime(long time) {
        this.modTime = time / 1000;
    }

    public void setModTime(Date time) {
        this.modTime = time.getTime() / 1000;
    }

    public Date getModTime() {
        return new Date(this.modTime * 1000);
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public Date getLastModifiedDate() {
        return getModTime();
    }

    public boolean isCheckSumOK() {
        return this.checkSumOK;
    }

    public File getFile() {
        return this.file;
    }

    public int getMode() {
        return this.mode;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public long getSize() {
        return this.size;
    }

    public void setSize(long size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size is out of range: " + size);
        }
        this.size = size;
    }

    public int getDevMajor() {
        return this.devMajor;
    }

    public void setDevMajor(int devNo) {
        if (devNo < 0) {
            throw new IllegalArgumentException("Major device number is out of range: " + devNo);
        }
        this.devMajor = devNo;
    }

    public int getDevMinor() {
        return this.devMinor;
    }

    public void setDevMinor(int devNo) {
        if (devNo < 0) {
            throw new IllegalArgumentException("Minor device number is out of range: " + devNo);
        }
        this.devMinor = devNo;
    }

    public boolean isExtended() {
        return this.isExtended;
    }

    public long getRealSize() {
        return this.realSize;
    }

    public boolean isGNUSparse() {
        return isOldGNUSparse() || isPaxGNUSparse();
    }

    public boolean isOldGNUSparse() {
        return this.linkFlag == 83;
    }

    public boolean isPaxGNUSparse() {
        return this.paxGNUSparse;
    }

    public boolean isStarSparse() {
        return this.starSparse;
    }

    public boolean isGNULongLinkEntry() {
        return this.linkFlag == 75;
    }

    public boolean isGNULongNameEntry() {
        return this.linkFlag == 76;
    }

    public boolean isPaxHeader() {
        return this.linkFlag == 120 || this.linkFlag == 88;
    }

    public boolean isGlobalPaxHeader() {
        return this.linkFlag == 103;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public boolean isDirectory() {
        if (this.file != null) {
            return this.file.isDirectory();
        }
        if (this.linkFlag == 53) {
            return true;
        }
        return (isPaxHeader() || isGlobalPaxHeader() || !getName().endsWith("/")) ? false : true;
    }

    public boolean isFile() {
        if (this.file != null) {
            return this.file.isFile();
        }
        if (this.linkFlag == 0 || this.linkFlag == 48) {
            return true;
        }
        return !getName().endsWith("/");
    }

    public boolean isSymbolicLink() {
        return this.linkFlag == 50;
    }

    public boolean isLink() {
        return this.linkFlag == 49;
    }

    public boolean isCharacterDevice() {
        return this.linkFlag == 51;
    }

    public boolean isBlockDevice() {
        return this.linkFlag == 52;
    }

    public boolean isFIFO() {
        return this.linkFlag == 54;
    }

    public boolean isSparse() {
        return isGNUSparse() || isStarSparse();
    }

    public TarArchiveEntry[] getDirectoryEntries() {
        if (this.file == null || !this.file.isDirectory()) {
            return EMPTY_TAR_ARCHIVE_ENTRIES;
        }
        String[] list = this.file.list();
        if (list == null) {
            return EMPTY_TAR_ARCHIVE_ENTRIES;
        }
        TarArchiveEntry[] result = new TarArchiveEntry[list.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new TarArchiveEntry(new File(this.file, list[i]));
        }
        return result;
    }

    public void writeEntryHeader(byte[] outbuf) {
        try {
            writeEntryHeader(outbuf, TarUtils.DEFAULT_ENCODING, false);
        } catch (IOException e) {
            try {
                writeEntryHeader(outbuf, TarUtils.FALLBACK_ENCODING, false);
            } catch (IOException ex2) {
                throw new RuntimeException(ex2);
            }
        }
    }

    public void writeEntryHeader(byte[] outbuf, ZipEncoding encoding, boolean starMode) throws IOException {
        int offset = TarUtils.formatNameBytes(this.name, outbuf, 0, 100, encoding);
        int offset2 = this.mode;
        int offset3 = writeEntryHeaderField(this.modTime, outbuf, writeEntryHeaderField(this.size, outbuf, writeEntryHeaderField(this.groupId, outbuf, writeEntryHeaderField(this.userId, outbuf, writeEntryHeaderField(offset2, outbuf, offset, 8, starMode), 8, starMode), 8, starMode), 12, starMode), 12, starMode);
        int c = 0;
        while (c < 8) {
            outbuf[offset3] = 32;
            c++;
            offset3++;
        }
        int c2 = offset3 + 1;
        outbuf[offset3] = this.linkFlag;
        int offset4 = TarUtils.formatNameBytes(this.linkName, outbuf, c2, 100, encoding);
        int offset5 = TarUtils.formatNameBytes(this.groupName, outbuf, TarUtils.formatNameBytes(this.userName, outbuf, TarUtils.formatNameBytes(this.version, outbuf, TarUtils.formatNameBytes(this.magic, outbuf, offset4, 6), 2), 32, encoding), 32, encoding);
        int offset6 = this.devMajor;
        for (int offset7 = writeEntryHeaderField(this.devMinor, outbuf, writeEntryHeaderField(offset6, outbuf, offset5, 8, starMode), 8, starMode); offset7 < outbuf.length; offset7++) {
            outbuf[offset7] = 0;
        }
        long chk = TarUtils.computeCheckSum(outbuf);
        TarUtils.formatCheckSumOctalBytes(chk, outbuf, offset3, 8);
    }

    private int writeEntryHeaderField(long value, byte[] outbuf, int offset, int length, boolean starMode) {
        if (!starMode && (value < 0 || value >= (1 << ((length - 1) * 3)))) {
            return TarUtils.formatLongOctalBytes(0L, outbuf, offset, length);
        }
        return TarUtils.formatLongOctalOrBinaryBytes(value, outbuf, offset, length);
    }

    public void parseTarHeader(byte[] header) {
        try {
            parseTarHeader(header, TarUtils.DEFAULT_ENCODING);
        } catch (IOException e) {
            try {
                parseTarHeader(header, TarUtils.DEFAULT_ENCODING, true);
            } catch (IOException ex2) {
                throw new RuntimeException(ex2);
            }
        }
    }

    public void parseTarHeader(byte[] header, ZipEncoding encoding) throws IOException {
        parseTarHeader(header, encoding, false);
    }

    private void parseTarHeader(byte[] header, ZipEncoding encoding, boolean oldStyle) throws IOException {
        this.name = oldStyle ? TarUtils.parseName(header, 0, 100) : TarUtils.parseName(header, 0, 100, encoding);
        int offset = 0 + 100;
        this.mode = (int) TarUtils.parseOctalOrBinary(header, offset, 8);
        int offset2 = offset + 8;
        this.userId = (int) TarUtils.parseOctalOrBinary(header, offset2, 8);
        int offset3 = offset2 + 8;
        this.groupId = (int) TarUtils.parseOctalOrBinary(header, offset3, 8);
        int offset4 = offset3 + 8;
        this.size = TarUtils.parseOctalOrBinary(header, offset4, 12);
        int offset5 = offset4 + 12;
        this.modTime = TarUtils.parseOctalOrBinary(header, offset5, 12);
        this.checkSumOK = TarUtils.verifyCheckSum(header);
        int offset6 = offset5 + 12 + 8;
        int offset7 = offset6 + 1;
        this.linkFlag = header[offset6];
        this.linkName = oldStyle ? TarUtils.parseName(header, offset7, 100) : TarUtils.parseName(header, offset7, 100, encoding);
        int offset8 = offset7 + 100;
        this.magic = TarUtils.parseName(header, offset8, 6);
        int offset9 = offset8 + 6;
        this.version = TarUtils.parseName(header, offset9, 2);
        int offset10 = offset9 + 2;
        this.userName = oldStyle ? TarUtils.parseName(header, offset10, 32) : TarUtils.parseName(header, offset10, 32, encoding);
        int offset11 = offset10 + 32;
        this.groupName = oldStyle ? TarUtils.parseName(header, offset11, 32) : TarUtils.parseName(header, offset11, 32, encoding);
        int offset12 = offset11 + 32;
        this.devMajor = (int) TarUtils.parseOctalOrBinary(header, offset12, 8);
        int offset13 = offset12 + 8;
        this.devMinor = (int) TarUtils.parseOctalOrBinary(header, offset13, 8);
        int offset14 = offset13 + 8;
        int type = evaluateType(header);
        switch (type) {
            case 2:
                int offset15 = offset14 + 12 + 12 + 12 + 4 + 1 + 96;
                this.isExtended = TarUtils.parseBoolean(header, offset15);
                int offset16 = offset15 + 1;
                this.realSize = TarUtils.parseOctal(header, offset16, 12);
                int i = offset16 + 12;
                break;
            case 3:
            default:
                String prefix = oldStyle ? TarUtils.parseName(header, offset14, TarConstants.PREFIXLEN) : TarUtils.parseName(header, offset14, TarConstants.PREFIXLEN, encoding);
                if (isDirectory() && !this.name.endsWith("/")) {
                    this.name += "/";
                }
                if (prefix.length() > 0) {
                    this.name = prefix + "/" + this.name;
                }
                break;
            case 4:
                String xstarPrefix = oldStyle ? TarUtils.parseName(header, offset14, TarConstants.PREFIXLEN_XSTAR) : TarUtils.parseName(header, offset14, TarConstants.PREFIXLEN_XSTAR, encoding);
                if (xstarPrefix.length() > 0) {
                    this.name = xstarPrefix + "/" + this.name;
                }
                break;
        }
    }

    private static String normalizeFileName(String fileName, boolean preserveLeadingSlashes) {
        int colon;
        String osname = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
        if (osname != null) {
            if (osname.startsWith("windows")) {
                if (fileName.length() > 2) {
                    char ch1 = fileName.charAt(0);
                    char ch2 = fileName.charAt(1);
                    if (ch2 == ':' && ((ch1 >= 'a' && ch1 <= 'z') || (ch1 >= 'A' && ch1 <= 'Z'))) {
                        fileName = fileName.substring(2);
                    }
                }
            } else if (osname.contains("netware") && (colon = fileName.indexOf(58)) != -1) {
                fileName = fileName.substring(colon + 1);
            }
        }
        String fileName2 = fileName.replace(File.separatorChar, '/');
        while (!preserveLeadingSlashes && fileName2.startsWith("/")) {
            fileName2 = fileName2.substring(1);
        }
        return fileName2;
    }

    private int evaluateType(byte[] header) {
        if (ArchiveUtils.matchAsciiBuffer(TarConstants.MAGIC_GNU, header, 257, 6)) {
            return 2;
        }
        if (ArchiveUtils.matchAsciiBuffer("ustar\u0000", header, 257, 6)) {
            return ArchiveUtils.matchAsciiBuffer(TarConstants.MAGIC_XSTAR, header, 508, 4) ? 4 : 3;
        }
        return 0;
    }

    void fillGNUSparse0xData(Map<String, String> headers) {
        this.paxGNUSparse = true;
        this.realSize = Integer.parseInt(headers.get("GNU.sparse.size"));
        if (headers.containsKey("GNU.sparse.name")) {
            this.name = headers.get("GNU.sparse.name");
        }
    }

    void fillGNUSparse1xData(Map<String, String> headers) {
        this.paxGNUSparse = true;
        this.realSize = Integer.parseInt(headers.get("GNU.sparse.realsize"));
        this.name = headers.get("GNU.sparse.name");
    }

    void fillStarSparseData(Map<String, String> headers) {
        this.starSparse = true;
        if (headers.containsKey("SCHILY.realsize")) {
            this.realSize = Long.parseLong(headers.get("SCHILY.realsize"));
        }
    }
}
