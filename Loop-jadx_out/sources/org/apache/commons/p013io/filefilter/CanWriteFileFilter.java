package org.apache.commons.p013io.filefilter;

import java.io.File;
import java.io.Serializable;

/* JADX INFO: loaded from: classes18.dex */
public class CanWriteFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = 5132005214688990379L;
    public static final IOFileFilter CAN_WRITE = new CanWriteFileFilter();
    public static final IOFileFilter CANNOT_WRITE = new NotFileFilter(CAN_WRITE);

    protected CanWriteFileFilter() {
    }

    @Override // org.apache.commons.p013io.filefilter.AbstractFileFilter, org.apache.commons.p013io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        return file.canWrite();
    }
}
