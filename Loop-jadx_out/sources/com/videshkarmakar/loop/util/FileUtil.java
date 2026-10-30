package com.videshkarmakar.loop.util;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.FileProvider;
import androidx.documentfile.provider.DocumentFile;
import com.videshkarmakar.loop.App;
import com.videshkarmakar.loop.C3070R;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p007io.ByteStreamsKt;
import kotlin.p007io.FilesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.internal._UtilCommonKt;

/* JADX INFO: compiled from: FileUtil.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m194d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u000b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\bH\u0000¢\u0006\u0002\b\u0014J\r\u0010\u0015\u001a\u00020\bH\u0000¢\u0006\u0002\b\u0016J\u0006\u0010\u0017\u001a\u00020\bJ\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001aJ1\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001c0\u000f2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 J;\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u000b\u001a\u00020\u00042\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00100#H\u0086\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&J\u001f\u0010'\u001a\u00020\u00102\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001c0\u000f¢\u0006\u0002\u0010)J\u000e\u0010*\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0004J\u001e\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\u0016\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\bJ%\u00100\u001a\b\u0012\u0004\u0012\u00020\b0\u000f*\u00020\b2\u0006\u00101\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u0010 J\n\u00103\u001a\u00020\b*\u000204J\n\u00105\u001a\u00020\b*\u000204J\u0014\u00106\u001a\u00020\b*\u0002042\b\b\u0002\u00107\u001a\u00020\u0004J\n\u00108\u001a\u00020\b*\u000204J\n\u00109\u001a\u00020\u0004*\u00020\u0004J\n\u0010:\u001a\u00020\u0004*\u000204J\n\u0010;\u001a\u00020<*\u00020\u0004J\n\u0010=\u001a\u00020\b*\u000204J\u0014\u0010>\u001a\u00020\b*\u0002042\b\u0010?\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0012\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0005\b\u009920\u0001¨\u0006@"}, m195d2 = {"Lcom/videshkarmakar/loop/util/FileUtil;", "", "()V", "TAG", "", "clearTempFiles", "", "downloadDir", "Ljava/io/File;", "createIntentForFile", "Landroid/content/Intent;", DownloadUtil.CookieScheme.PATH, "createIntentForOpeningFile", "createIntentForSharingFile", "deleteFile", "Lkotlin/Result;", "", "deleteFile-IoAF18A", "(Ljava/lang/String;)Ljava/lang/Object;", "getExternalDownloadDirectory", "getExternalDownloadDirectory$app_debug", "getExternalPrivateDownloadDirectory", "getExternalPrivateDownloadDirectory$app_debug", "getExternalTempDir", "getRealPath", "treeUri", "Landroid/net/Uri;", "moveFilesToSdcard", "", "tempPath", "sdcardUri", "moveFilesToSdcard-gIAlu-s", "(Ljava/io/File;Ljava/lang/String;)Ljava/lang/Object;", "openFile", "onFailureCallback", "Lkotlin/Function1;", "", "openFile-gIAlu-s", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "openFileFromResult", "downloadResult", "(Ljava/lang/Object;)V", "scanDownloadDirectoryToMediaLibrary", "scanFileToMediaLibraryPostDownload", "title", "writeContentToFile", "content", "file", "createEmptyFile", "fileName", "createEmptyFile-gIAlu-s", "getArchiveFile", "Landroid/content/Context;", "getConfigDirectory", "getConfigFile", "suffix", "getCookiesFile", "getFileName", "getFileProvider", "getFileSize", "", "getInternalTempDir", "getSdcardTempDir", "child", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FileUtil {
    public static final int $stable = 0;
    public static final FileUtil INSTANCE = new FileUtil();
    private static final String TAG = "FileUtil";

    private FileUtil() {
    }

    public final void openFileFromResult(Object downloadResult) {
        Object objM7693constructorimpl;
        Unit unit = null;
        List filePaths = (List) (Result.m7699isFailureimpl(downloadResult) ? null : downloadResult);
        List list = filePaths;
        if (list == null || list.isEmpty()) {
            return;
        }
        String path$iv = (String) CollectionsKt.first(filePaths);
        try {
            Result.Companion companion = Result.INSTANCE;
            Intent $this$openFile_gIAlu_s_u24lambda_u242_u24lambda_u241$iv = INSTANCE.createIntentForOpeningFile(path$iv);
            if ($this$openFile_gIAlu_s_u24lambda_u242_u24lambda_u241$iv != null) {
                App.INSTANCE.getContext().startActivity($this$openFile_gIAlu_s_u24lambda_u242_u24lambda_u241$iv);
                unit = Unit.INSTANCE;
            }
            if (unit != null) {
                objM7693constructorimpl = Result.m7693constructorimpl(Unit.INSTANCE);
                if (Result.m7696exceptionOrNullimpl(objM7693constructorimpl) != null) {
                    ToastUtil toastUtil = ToastUtil.INSTANCE;
                    String string = App.INSTANCE.getContext().getString(C3070R.string.file_unavailable);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    toastUtil.makeToastSuspend(string);
                    return;
                }
                return;
            }
            throw new Exception();
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7693constructorimpl = Result.m7693constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: renamed from: openFile-gIAlu-s, reason: not valid java name */
    public final Object m7679openFilegIAlus(String path, Function1<? super Throwable, Unit> onFailureCallback) {
        Object objM7693constructorimpl;
        Unit unit;
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(onFailureCallback, "onFailureCallback");
        try {
            Result.Companion companion = Result.INSTANCE;
            Intent $this$openFile_gIAlu_s_u24lambda_u242_u24lambda_u241 = INSTANCE.createIntentForOpeningFile(path);
            if ($this$openFile_gIAlu_s_u24lambda_u242_u24lambda_u241 != null) {
                App.INSTANCE.getContext().startActivity($this$openFile_gIAlu_s_u24lambda_u242_u24lambda_u241);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit != null) {
                objM7693constructorimpl = Result.m7693constructorimpl(Unit.INSTANCE);
                Throwable it = Result.m7696exceptionOrNullimpl(objM7693constructorimpl);
                if (it != null) {
                    onFailureCallback.invoke(it);
                }
                return objM7693constructorimpl;
            }
            throw new Exception();
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7693constructorimpl = Result.m7693constructorimpl(ResultKt.createFailure(th));
        }
    }

    private final Intent createIntentForFile(String path) {
        Object objM7693constructorimpl;
        Uri uriForFile;
        if (path == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            DocumentFile $this$createIntentForFile_u24lambda_u245_u24lambda_u244 = DocumentFile.fromSingleUri(App.INSTANCE.getContext(), Uri.parse(path));
            boolean z = false;
            if ($this$createIntentForFile_u24lambda_u245_u24lambda_u244 != null && $this$createIntentForFile_u24lambda_u245_u24lambda_u244.exists()) {
                z = true;
            }
            if (z) {
                uriForFile = $this$createIntentForFile_u24lambda_u245_u24lambda_u244.getUri();
            } else {
                uriForFile = new File(path).exists() ? FileProvider.getUriForFile(App.INSTANCE.getContext(), INSTANCE.getFileProvider(App.INSTANCE.getContext()), new File(path)) : null;
            }
            objM7693constructorimpl = Result.m7693constructorimpl(uriForFile);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7693constructorimpl = Result.m7693constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7699isFailureimpl(objM7693constructorimpl)) {
            objM7693constructorimpl = null;
        }
        Uri uri = (Uri) objM7693constructorimpl;
        if (uri == null) {
            return null;
        }
        Intent $this$createIntentForFile_u24lambda_u246 = new Intent();
        $this$createIntentForFile_u24lambda_u246.setFlags(1);
        $this$createIntentForFile_u24lambda_u246.setData(uri);
        return $this$createIntentForFile_u24lambda_u246;
    }

    public final Intent createIntentForOpeningFile(String path) {
        Intent it = createIntentForFile(path);
        if (it == null) {
            return null;
        }
        it.setAction("android.intent.action.VIEW");
        it.addFlags(268435456);
        return it;
    }

    public final Intent createIntentForSharingFile(String path) {
        String mimeType;
        Intent $this$createIntentForSharingFile_u24lambda_u2410 = createIntentForFile(path);
        if ($this$createIntentForSharingFile_u24lambda_u2410 == null) {
            return null;
        }
        $this$createIntentForSharingFile_u24lambda_u2410.setAction("android.intent.action.SEND");
        $this$createIntentForSharingFile_u24lambda_u2410.putExtra("android.intent.extra.STREAM", $this$createIntentForSharingFile_u24lambda_u2410.getData());
        Uri it = $this$createIntentForSharingFile_u24lambda_u2410.getData();
        if (it == null || (mimeType = App.INSTANCE.getContext().getContentResolver().getType(it)) == null) {
            mimeType = "media/*";
        }
        Intrinsics.checkNotNull(mimeType);
        $this$createIntentForSharingFile_u24lambda_u2410.setDataAndType($this$createIntentForSharingFile_u24lambda_u2410.getData(), mimeType);
        $this$createIntentForSharingFile_u24lambda_u2410.setClipData(new ClipData(null, new String[]{mimeType}, new ClipData.Item($this$createIntentForSharingFile_u24lambda_u2410.getData())));
        return $this$createIntentForSharingFile_u24lambda_u2410;
    }

    public final String getFileProvider(Context $this$getFileProvider) {
        Intrinsics.checkNotNullParameter($this$getFileProvider, "<this>");
        return $this$getFileProvider.getPackageName() + ".provider";
    }

    public final long getFileSize(String $this$getFileSize) {
        Intrinsics.checkNotNullParameter($this$getFileSize, "<this>");
        long length = new File($this$getFileSize).length();
        if (length == 0) {
            DocumentFile documentFileFromSingleUri = DocumentFile.fromSingleUri(App.INSTANCE.getContext(), Uri.parse($this$getFileSize));
            if (documentFileFromSingleUri != null) {
                return documentFileFromSingleUri.length();
            }
            return 0L;
        }
        return length;
    }

    public final String getFileName(String $this$getFileName) {
        String name;
        Intrinsics.checkNotNullParameter($this$getFileName, "<this>");
        String nameWithoutExtension = FilesKt.getNameWithoutExtension(new File($this$getFileName));
        if (nameWithoutExtension.length() == 0) {
            DocumentFile documentFileFromSingleUri = DocumentFile.fromSingleUri(App.INSTANCE.getContext(), Uri.parse($this$getFileName));
            if (documentFileFromSingleUri == null || (name = documentFileFromSingleUri.getName()) == null) {
                name = "video";
            }
            nameWithoutExtension = name;
        }
        return nameWithoutExtension;
    }

    /* JADX INFO: renamed from: deleteFile-IoAF18A, reason: not valid java name */
    public final Object m7677deleteFileIoAF18A(String path) {
        DocumentFile documentFileFromSingleUri;
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            Result.Companion companion = Result.INSTANCE;
            if (!new File(path).delete() && (documentFileFromSingleUri = DocumentFile.fromSingleUri(App.INSTANCE.getContext(), Uri.parse(path))) != null) {
                documentFileFromSingleUri.delete();
            }
            return Result.m7693constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7693constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final List<String> scanFileToMediaLibraryPostDownload(final String title, String downloadDir) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(downloadDir, "downloadDir");
        List<String> mutableList = SequencesKt.toMutableList(SequencesKt.map(SequencesKt.filter(FilesKt.walkTopDown(new File(downloadDir)), new Function1<File, Boolean>() { // from class: com.videshkarmakar.loop.util.FileUtil.scanFileToMediaLibraryPostDownload.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(File it) {
                Intrinsics.checkNotNullParameter(it, "it");
                boolean z = false;
                if (it.isFile()) {
                    String absolutePath = it.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                    if (StringsKt.contains$default((CharSequence) absolutePath, (CharSequence) title, false, 2, (Object) null)) {
                        z = true;
                    }
                }
                return Boolean.valueOf(z);
            }
        }), new Function1<File, String>() { // from class: com.videshkarmakar.loop.util.FileUtil.scanFileToMediaLibraryPostDownload.2
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(File it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getAbsolutePath();
            }
        }));
        Context context = App.INSTANCE.getContext();
        Collection $this$toTypedArray$iv = CollectionsKt.toList(mutableList);
        MediaScannerConnection.scanFile(context, (String[]) $this$toTypedArray$iv.toArray(new String[0]), null, null);
        CollectionsKt.removeAll((List) mutableList, (Function1) new Function1<String, Boolean>() { // from class: com.videshkarmakar.loop.util.FileUtil$scanFileToMediaLibraryPostDownload$3$1
            /* JADX WARN: Code duplicated, block: B:8:0x0026  */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String it) {
                boolean z;
                Intrinsics.checkNotNull(it);
                if (new Regex(FileUtilKt.THUMBNAIL_REGEX).containsMatchIn(it)) {
                    z = true;
                } else {
                    if (new Regex(FileUtilKt.SUBTITLE_REGEX).containsMatchIn(it)) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                return Boolean.valueOf(z);
            }
        });
        return mutableList;
    }

    public final void scanDownloadDirectoryToMediaLibrary(String downloadDir) {
        Intrinsics.checkNotNullParameter(downloadDir, "downloadDir");
        Sequence $this$scanDownloadDirectoryToMediaLibrary_u24lambda_u2416 = SequencesKt.map(SequencesKt.filter(FilesKt.walkTopDown(new File(downloadDir)), new Function1<File, Boolean>() { // from class: com.videshkarmakar.loop.util.FileUtil.scanDownloadDirectoryToMediaLibrary.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(File it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.isFile());
            }
        }), new Function1<File, String>() { // from class: com.videshkarmakar.loop.util.FileUtil.scanDownloadDirectoryToMediaLibrary.2
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(File it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getAbsolutePath();
            }
        });
        Context context = App.INSTANCE.getContext();
        Collection $this$toTypedArray$iv = SequencesKt.toList($this$scanDownloadDirectoryToMediaLibrary_u24lambda_u2416);
        MediaScannerConnection.scanFile(context, (String[]) $this$toTypedArray$iv.toArray(new String[0]), null, null);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX INFO: renamed from: moveFilesToSdcard-gIAlu-s, reason: not valid java name */
    public final Object m7678moveFilesToSdcardgIAlus(File tempPath, String sdcardUri) {
        Object res;
        Intrinsics.checkNotNullParameter(tempPath, "tempPath");
        Intrinsics.checkNotNullParameter(sdcardUri, "sdcardUri");
        List uriList = new ArrayList();
        Uri $this$moveFilesToSdcard_gIAlu_s_u24lambda_u2417 = Uri.parse(sdcardUri);
        Uri destDir = DocumentsContract.buildDocumentUriUsingTree($this$moveFilesToSdcard_gIAlu_s_u24lambda_u2417, DocumentsContract.getTreeDocumentId($this$moveFilesToSdcard_gIAlu_s_u24lambda_u2417));
        try {
            Result.Companion companion = Result.INSTANCE;
            File $this$moveFilesToSdcard_gIAlu_s_u24lambda_u2419 = tempPath;
            Sequence $this$forEach$iv = FilesKt.walkTopDown($this$moveFilesToSdcard_gIAlu_s_u24lambda_u2419);
            for (Object element$iv : $this$forEach$iv) {
                File it = (File) element$iv;
                if (!it.isDirectory()) {
                    String mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(FilesKt.getExtension(it));
                    if (mimeType == null) {
                        mimeType = "*/*";
                    }
                    Intrinsics.checkNotNull(mimeType);
                    Uri destUri = DocumentsContract.createDocument(App.INSTANCE.getContext().getContentResolver(), destDir, mimeType, it.getName());
                    if (destUri != null) {
                        Intrinsics.checkNotNull(destUri);
                        FileInputStream inputStream = new FileInputStream(it);
                        OutputStream outputStream = App.INSTANCE.getContext().getContentResolver().openOutputStream(destUri);
                        if (outputStream != null) {
                            Intrinsics.checkNotNull(outputStream);
                            try {
                                ByteStreamsKt.copyTo$default(inputStream, outputStream, 0, 2, null);
                                _UtilCommonKt.closeQuietly(inputStream);
                                _UtilCommonKt.closeQuietly(outputStream);
                                String string = destUri.toString();
                                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                                uriList.add(string);
                            } catch (Throwable th) {
                                th = th;
                                Result.Companion companion2 = Result.INSTANCE;
                                res = Result.m7693constructorimpl(ResultKt.createFailure(th));
                                FilesKt.deleteRecursively(tempPath);
                                return res;
                            }
                        }
                    }
                }
                $this$moveFilesToSdcard_gIAlu_s_u24lambda_u2419 = $this$moveFilesToSdcard_gIAlu_s_u24lambda_u2419;
                destDir = destDir;
            }
            res = Result.m7693constructorimpl(uriList);
        } catch (Throwable th2) {
            th = th2;
        }
        FilesKt.deleteRecursively(tempPath);
        return res;
    }

    public final int clearTempFiles(File downloadDir) {
        Intrinsics.checkNotNullParameter(downloadDir, "downloadDir");
        int count = 0;
        Sequence $this$forEach$iv = FilesKt.walkTopDown(downloadDir);
        for (Object element$iv : $this$forEach$iv) {
            File it = (File) element$iv;
            if (it.isFile() && !it.isHidden() && it.delete()) {
                count++;
            }
        }
        return count;
    }

    public final File getConfigDirectory(Context $this$getConfigDirectory) {
        Intrinsics.checkNotNullParameter($this$getConfigDirectory, "<this>");
        File cacheDir = $this$getConfigDirectory.getCacheDir();
        Intrinsics.checkNotNullExpressionValue(cacheDir, "getCacheDir(...)");
        return cacheDir;
    }

    public static /* synthetic */ File getConfigFile$default(FileUtil fileUtil, Context context, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return fileUtil.getConfigFile(context, str);
    }

    public final File getConfigFile(Context $this$getConfigFile, String suffix) {
        Intrinsics.checkNotNullParameter($this$getConfigFile, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return new File(getConfigDirectory($this$getConfigFile), "config" + suffix + ".txt");
    }

    public final File getCookiesFile(Context $this$getCookiesFile) {
        Intrinsics.checkNotNullParameter($this$getCookiesFile, "<this>");
        return new File(getConfigDirectory($this$getCookiesFile), "cookies.txt");
    }

    public final File getExternalTempDir() {
        File $this$getExternalTempDir_u24lambda_u2421 = new File(getExternalDownloadDirectory$app_debug(), "tmp");
        $this$getExternalTempDir_u24lambda_u2421.mkdirs();
        INSTANCE.m7676createEmptyFilegIAlus($this$getExternalTempDir_u24lambda_u2421, ".nomedia");
        return $this$getExternalTempDir_u24lambda_u2421;
    }

    public final File getSdcardTempDir(Context $this$getSdcardTempDir, String child) {
        File fileResolve;
        Intrinsics.checkNotNullParameter($this$getSdcardTempDir, "<this>");
        File $this$getSdcardTempDir_u24lambda_u2423 = getExternalTempDir();
        return (child == null || (fileResolve = FilesKt.resolve($this$getSdcardTempDir_u24lambda_u2423, child)) == null) ? $this$getSdcardTempDir_u24lambda_u2423 : fileResolve;
    }

    public final File getArchiveFile(Context $this$getArchiveFile) {
        Intrinsics.checkNotNullParameter($this$getArchiveFile, "<this>");
        File filesDir = $this$getArchiveFile.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "getFilesDir(...)");
        Object objM7676createEmptyFilegIAlus = m7676createEmptyFilegIAlus(filesDir, "archive.txt");
        ResultKt.throwOnFailure(objM7676createEmptyFilegIAlus);
        return (File) objM7676createEmptyFilegIAlus;
    }

    public final File getInternalTempDir(Context $this$getInternalTempDir) {
        Intrinsics.checkNotNullParameter($this$getInternalTempDir, "<this>");
        return new File($this$getInternalTempDir.getFilesDir(), "tmp");
    }

    public final File getExternalDownloadDirectory$app_debug() {
        File it = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "LOOP");
        it.mkdir();
        return it;
    }

    public final File getExternalPrivateDownloadDirectory$app_debug() {
        return new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), ".LOOP");
    }

    /* JADX INFO: renamed from: createEmptyFile-gIAlu-s, reason: not valid java name */
    public final Object m7676createEmptyFilegIAlus(File createEmptyFile, String fileName) {
        Object objM7693constructorimpl;
        Intrinsics.checkNotNullParameter(createEmptyFile, "$this$createEmptyFile");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        try {
            Result.Companion companion = Result.INSTANCE;
            createEmptyFile.mkdirs();
            File $this$createEmptyFile_gIAlu_s_u24lambda_u2426_u24lambda_u2425 = FilesKt.resolve(createEmptyFile, fileName);
            $this$createEmptyFile_gIAlu_s_u24lambda_u2426_u24lambda_u2425.createNewFile();
            objM7693constructorimpl = Result.m7693constructorimpl($this$createEmptyFile_gIAlu_s_u24lambda_u2426_u24lambda_u2425);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7693constructorimpl = Result.m7693constructorimpl(ResultKt.createFailure(th));
        }
        Throwable it = Result.m7696exceptionOrNullimpl(objM7693constructorimpl);
        if (it != null) {
            it.printStackTrace();
        }
        return objM7693constructorimpl;
    }

    public final File writeContentToFile(String content, File file) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(file, "file");
        FilesKt.writeText$default(file, content, null, 2, null);
        return file;
    }

    public final String getRealPath(Uri treeUri) {
        Intrinsics.checkNotNullParameter(treeUri, "treeUri");
        String path = String.valueOf(treeUri.getPath());
        Log.d(TAG, path);
        if (!StringsKt.contains$default((CharSequence) path, (CharSequence) "primary:", false, 2, (Object) null)) {
            ToastUtil.INSTANCE.makeToast("This directory is not supported");
            String absolutePath = getExternalDownloadDirectory$app_debug().getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
            return absolutePath;
        }
        String last = (String) CollectionsKt.last(StringsKt.split$default((CharSequence) path, new String[]{"primary:"}, false, 0, 6, (Object) null));
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + last;
    }
}
