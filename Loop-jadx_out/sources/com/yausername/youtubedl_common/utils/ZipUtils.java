package com.yausername.youtubedl_common.utils;

import android.system.Os;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p007io.CloseableKt;
import kotlin.text.StringsKt;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.p013io.IOUtils;

/* JADX INFO: compiled from: ZipUtils.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\u0003\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\n"}, m195d2 = {"Lcom/yausername/youtubedl_common/utils/ZipUtils;", "", "()V", "unzip", "", "sourceFile", "Ljava/io/File;", "targetDirectory", "inputStream", "Ljava/io/InputStream;", "common_release"}, m196k = 1, m197mv = {1, 7, 1}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ZipUtils {
    public static final ZipUtils INSTANCE = new ZipUtils();

    private ZipUtils() {
    }

    public final void unzip(File sourceFile, File targetDirectory) {
        Intrinsics.checkNotNullParameter(targetDirectory, "targetDirectory");
        ZipFile zipFile = new ZipFile(sourceFile);
        try {
            ZipFile zipFile2 = zipFile;
            Enumeration<ZipArchiveEntry> entries = zipFile2.getEntries();
            while (entries.hasMoreElements()) {
                ZipArchiveEntry entry = entries.nextElement();
                File entryDestination = new File(targetDirectory, entry.getName());
                String canonicalPath = entryDestination.getCanonicalPath();
                Intrinsics.checkNotNullExpressionValue(canonicalPath, "entryDestination.canonicalPath");
                if (!StringsKt.startsWith$default(canonicalPath, targetDirectory.getCanonicalPath() + File.separator, false, 2, (Object) null)) {
                    throw new IllegalAccessException("Entry is outside of the target dir: " + entry.getName());
                }
                if (entry.isDirectory()) {
                    entryDestination.mkdirs();
                } else if (entry.isUnixSymlink()) {
                    InputStream inputStream = zipFile2.getInputStream(entry);
                    try {
                        InputStream in = inputStream;
                        String symlink = IOUtils.toString(in, StandardCharsets.UTF_8);
                        Os.symlink(symlink, entryDestination.getAbsolutePath());
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(inputStream, null);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(inputStream, th);
                            throw th2;
                        }
                    }
                } else {
                    File parentFile = entryDestination.getParentFile();
                    if (parentFile != null) {
                        parentFile.mkdirs();
                    }
                    InputStream inputStream2 = zipFile2.getInputStream(entry);
                    try {
                        InputStream in2 = inputStream2;
                        FileOutputStream fileOutputStream = new FileOutputStream(entryDestination);
                        try {
                            FileOutputStream out = fileOutputStream;
                            IOUtils.copy(in2, out);
                            CloseableKt.closeFinally(fileOutputStream, null);
                            CloseableKt.closeFinally(inputStream2, null);
                        } catch (Throwable th3) {
                            try {
                                throw th3;
                            } catch (Throwable th4) {
                                CloseableKt.closeFinally(fileOutputStream, th3);
                                throw th4;
                            }
                        }
                    } catch (Throwable th5) {
                        try {
                            throw th5;
                        } catch (Throwable th6) {
                            CloseableKt.closeFinally(inputStream2, th5);
                            throw th6;
                        }
                    }
                }
            }
            Unit unit2 = Unit.INSTANCE;
            CloseableKt.closeFinally(zipFile, null);
        } catch (Throwable th7) {
            try {
                throw th7;
            } catch (Throwable th8) {
                CloseableKt.closeFinally(zipFile, th7);
                throw th8;
            }
        }
    }

    public final void unzip(InputStream inputStream, File targetDirectory) {
        Intrinsics.checkNotNullParameter(targetDirectory, "targetDirectory");
        ZipArchiveInputStream zipArchiveInputStream = new ZipArchiveInputStream(new BufferedInputStream(inputStream));
        try {
            ZipArchiveInputStream zis = zipArchiveInputStream;
            while (true) {
                ZipArchiveEntry it = zis.getNextZipEntry();
                if (it == null) {
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(zipArchiveInputStream, null);
                    return;
                }
                Intrinsics.checkNotNull(it);
                File entryDestination = new File(targetDirectory, it.getName());
                String canonicalPath = entryDestination.getCanonicalPath();
                Intrinsics.checkNotNullExpressionValue(canonicalPath, "entryDestination.canonicalPath");
                if (!StringsKt.startsWith$default(canonicalPath, targetDirectory.getCanonicalPath() + File.separator, false, 2, (Object) null)) {
                    throw new IllegalAccessException("Entry is outside of the target dir: " + it.getName());
                }
                if (it.isDirectory()) {
                    entryDestination.mkdirs();
                } else {
                    entryDestination.getParentFile().mkdirs();
                    FileOutputStream fileOutputStream = new FileOutputStream(entryDestination);
                    try {
                        FileOutputStream out = fileOutputStream;
                        IOUtils.copy(zis, out);
                        CloseableKt.closeFinally(fileOutputStream, null);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(fileOutputStream, th);
                            throw th2;
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(zipArchiveInputStream, th3);
                throw th4;
            }
        }
    }
}
