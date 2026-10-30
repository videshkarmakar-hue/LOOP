package coil.decode;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.util.Utils;
import java.io.Closeable;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Path;

/* JADX INFO: compiled from: ImageSource.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\u0006\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\b\u0006\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\b\u0006\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\b\u0006\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0002\b\u0006\u001aC\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\b\u0006¨\u0006\u0013"}, m195d2 = {"ImageSource", "Lcoil/decode/ImageSource;", "source", "Lokio/BufferedSource;", "context", "Landroid/content/Context;", "create", "metadata", "Lcoil/decode/ImageSource$Metadata;", "cacheDirectory", "Ljava/io/File;", "file", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "diskCacheKey", "", "closeable", "Ljava/io/Closeable;", "coil-base_release"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ImageSources {
    public static /* synthetic */ ImageSource create$default(Path path, FileSystem fileSystem, String str, Closeable closeable, int i, Object obj) {
        if ((i & 2) != 0) {
            fileSystem = FileSystem.SYSTEM;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            closeable = null;
        }
        return create(path, fileSystem, str, closeable);
    }

    public static final ImageSource create(Path file, FileSystem fileSystem, String diskCacheKey, Closeable closeable) {
        return new FileImageSource(file, fileSystem, diskCacheKey, closeable, null);
    }

    public static /* synthetic */ ImageSource create$default(Path path, FileSystem fileSystem, String str, Closeable closeable, ImageSource.Metadata metadata, int i, Object obj) {
        if ((i & 2) != 0) {
            fileSystem = FileSystem.SYSTEM;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            closeable = null;
        }
        if ((i & 16) != 0) {
            metadata = null;
        }
        return create(path, fileSystem, str, closeable, metadata);
    }

    public static final ImageSource create(Path file, FileSystem fileSystem, String diskCacheKey, Closeable closeable, ImageSource.Metadata metadata) {
        return new FileImageSource(file, fileSystem, diskCacheKey, closeable, metadata);
    }

    public static final ImageSource create(BufferedSource source, final Context context) {
        return new SourceImageSource(source, new Function0<File>() { // from class: coil.decode.ImageSources$ImageSource$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                return Utils.getSafeCacheDir(context);
            }
        }, null);
    }

    public static /* synthetic */ ImageSource create$default(BufferedSource bufferedSource, Context context, ImageSource.Metadata metadata, int i, Object obj) {
        if ((i & 4) != 0) {
            metadata = null;
        }
        return create(bufferedSource, context, metadata);
    }

    public static final ImageSource create(BufferedSource source, final Context context, ImageSource.Metadata metadata) {
        return new SourceImageSource(source, new Function0<File>() { // from class: coil.decode.ImageSources$ImageSource$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                return Utils.getSafeCacheDir(context);
            }
        }, metadata);
    }

    public static final ImageSource create(BufferedSource source, final File cacheDirectory) {
        return new SourceImageSource(source, new Function0<File>() { // from class: coil.decode.ImageSources$ImageSource$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                return cacheDirectory;
            }
        }, null);
    }

    public static /* synthetic */ ImageSource create$default(BufferedSource bufferedSource, File file, ImageSource.Metadata metadata, int i, Object obj) {
        if ((i & 4) != 0) {
            metadata = null;
        }
        return create(bufferedSource, file, metadata);
    }

    public static final ImageSource create(BufferedSource source, final File cacheDirectory, ImageSource.Metadata metadata) {
        return new SourceImageSource(source, new Function0<File>() { // from class: coil.decode.ImageSources$ImageSource$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                return cacheDirectory;
            }
        }, metadata);
    }
}
