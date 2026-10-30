package org.apache.commons.p013io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.p013io.FileUtils;

/* JADX INFO: loaded from: classes18.dex */
public class AgeFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = -2132740084016138541L;
    private final boolean acceptOlder;
    private final long cutoff;

    public AgeFileFilter(long cutoff) {
        this(cutoff, true);
    }

    public AgeFileFilter(long cutoff, boolean acceptOlder) {
        this.acceptOlder = acceptOlder;
        this.cutoff = cutoff;
    }

    public AgeFileFilter(Date cutoffDate) {
        this(cutoffDate, true);
    }

    public AgeFileFilter(Date cutoffDate, boolean acceptOlder) {
        this(cutoffDate.getTime(), acceptOlder);
    }

    public AgeFileFilter(File cutoffReference) {
        this(cutoffReference, true);
    }

    public AgeFileFilter(File cutoffReference, boolean acceptOlder) {
        this(cutoffReference.lastModified(), acceptOlder);
    }

    @Override // org.apache.commons.p013io.filefilter.AbstractFileFilter, org.apache.commons.p013io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        boolean newer = FileUtils.isFileNewer(file, this.cutoff);
        if (this.acceptOlder) {
            return !newer;
        }
        return newer;
    }

    @Override // org.apache.commons.p013io.filefilter.AbstractFileFilter
    public String toString() {
        String condition = this.acceptOlder ? "<=" : ">";
        return super.toString() + "(" + condition + this.cutoff + ")";
    }
}
