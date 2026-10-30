package okio.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import okio.BufferedSink;
import okio.FileMetadata;
import okio.Okio;
import okio.Path;
import okio.Source;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* JADX INFO: renamed from: okio.internal.-FileSystem, reason: invalid class name */
/* JADX INFO: compiled from: FileSystem.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aI\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a\u001c\u0010\r\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0000\u001a\u001c\u0010\u0010\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\nH\u0000\u001a\u001c\u0010\u0013\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\nH\u0000\u001a\u0014\u0010\u0016\u001a\u00020\n*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0014\u0010\u0019\u001a\u00020\u001a*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u0003*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, m195d2 = {"collectRecursively", "", "Lkotlin/sequences/SequenceScope;", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "stack", "Lkotlin/collections/ArrayDeque;", DownloadUtil.CookieScheme.PATH, "followSymlinks", "", "postorder", "(Lkotlin/sequences/SequenceScope;Lokio/FileSystem;Lkotlin/collections/ArrayDeque;Lokio/Path;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commonCopy", "source", "target", "commonCreateDirectories", "dir", "mustCreate", "commonDeleteRecursively", "fileOrDirectory", "mustExist", "commonExists", "commonListRecursively", "Lkotlin/sequences/Sequence;", "commonMetadata", "Lokio/FileMetadata;", "symlinkTarget", "okio"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FileSystem {

    /* JADX INFO: renamed from: okio.internal.-FileSystem$collectRecursively$1 */
    /* JADX INFO: compiled from: FileSystem.kt */
    @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "okio.internal.-FileSystem", m210f = "FileSystem.kt", m211i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, m212l = {116, 135, 145}, m213m = "collectRecursively", m214n = {"$this$collectRecursively", "fileSystem", "stack", DownloadUtil.CookieScheme.PATH, "followSymlinks", "postorder", "$this$collectRecursively", "fileSystem", "stack", DownloadUtil.CookieScheme.PATH, "followSymlinks", "postorder"}, m215s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1"})
    static final class C45081 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        C45081(Continuation<? super C45081> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileSystem.collectRecursively(null, null, null, null, false, false, this);
        }
    }

    public static final FileMetadata commonMetadata(okio.FileSystem $this$commonMetadata, Path path) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonMetadata, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        FileMetadata fileMetadataMetadataOrNull = $this$commonMetadata.metadataOrNull(path);
        if (fileMetadataMetadataOrNull != null) {
            return fileMetadataMetadataOrNull;
        }
        throw new FileNotFoundException("no such file: " + path);
    }

    public static final boolean commonExists(okio.FileSystem $this$commonExists, Path path) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonExists, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        return $this$commonExists.metadataOrNull(path) != null;
    }

    public static final void commonCreateDirectories(okio.FileSystem $this$commonCreateDirectories, Path dir, boolean mustCreate) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonCreateDirectories, "<this>");
        Intrinsics.checkNotNullParameter(dir, "dir");
        ArrayDeque<Path> directories = new ArrayDeque();
        for (Path path = dir; path != null && !$this$commonCreateDirectories.exists(path); path = path.parent()) {
            directories.addFirst(path);
        }
        if (mustCreate && directories.isEmpty()) {
            throw new IOException(dir + " already exists.");
        }
        for (Path toCreate : directories) {
            $this$commonCreateDirectories.createDirectory(toCreate);
        }
    }

    public static final void commonDeleteRecursively(okio.FileSystem $this$commonDeleteRecursively, Path fileOrDirectory, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonDeleteRecursively, "<this>");
        Intrinsics.checkNotNullParameter(fileOrDirectory, "fileOrDirectory");
        Sequence sequence = SequencesKt.sequence(new FileSystem$commonDeleteRecursively$sequence$1($this$commonDeleteRecursively, fileOrDirectory, null));
        Iterator iterator = sequence.iterator();
        while (iterator.hasNext()) {
            Path toDelete = (Path) iterator.next();
            $this$commonDeleteRecursively.delete(toDelete, mustExist && !iterator.hasNext());
        }
    }

    /* JADX INFO: renamed from: okio.internal.-FileSystem$commonListRecursively$1 */
    /* JADX INFO: compiled from: FileSystem.kt */
    @Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lokio/Path;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "okio.internal.-FileSystem$commonListRecursively$1", m210f = "FileSystem.kt", m211i = {0, 0}, m212l = {TarConstants.SPARSELEN_GNU}, m213m = "invokeSuspend", m214n = {"$this$sequence", "stack"}, m215s = {"L$0", "L$1"})
    static final class C45091 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Path $dir;
        final /* synthetic */ boolean $followSymlinks;
        final /* synthetic */ okio.FileSystem $this_commonListRecursively;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C45091(Path path, okio.FileSystem fileSystem, boolean z, Continuation<? super C45091> continuation) {
            super(2, continuation);
            this.$dir = path;
            this.$this_commonListRecursively = fileSystem;
            this.$followSymlinks = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C45091 c45091 = new C45091(this.$dir, this.$this_commonListRecursively, this.$followSymlinks, continuation);
            c45091.L$0 = obj;
            return c45091;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super Path> sequenceScope, Continuation<? super Unit> continuation) {
            return ((C45091) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            C45091 c45091;
            SequenceScope $this$sequence;
            ArrayDeque stack;
            Iterator<Path> it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c45091 = this;
                    SequenceScope $this$sequence2 = (SequenceScope) c45091.L$0;
                    ArrayDeque stack2 = new ArrayDeque();
                    stack2.addLast(c45091.$dir);
                    $this$sequence = $this$sequence2;
                    stack = stack2;
                    it = c45091.$this_commonListRecursively.list(c45091.$dir).iterator();
                    break;
                case 1:
                    c45091 = this;
                    it = (Iterator) c45091.L$2;
                    ArrayDeque stack3 = (ArrayDeque) c45091.L$1;
                    SequenceScope $this$sequence3 = (SequenceScope) c45091.L$0;
                    ResultKt.throwOnFailure($result);
                    stack = stack3;
                    $this$sequence = $this$sequence3;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            while (it.hasNext()) {
                Path next = it.next();
                c45091.L$0 = $this$sequence;
                c45091.L$1 = stack;
                c45091.L$2 = it;
                c45091.label = 1;
                if (FileSystem.collectRecursively($this$sequence, c45091.$this_commonListRecursively, stack, next, c45091.$followSymlinks, false, c45091) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final Sequence<Path> commonListRecursively(okio.FileSystem $this$commonListRecursively, Path dir, boolean followSymlinks) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonListRecursively, "<this>");
        Intrinsics.checkNotNullParameter(dir, "dir");
        return SequencesKt.sequence(new C45091(dir, $this$commonListRecursively, followSymlinks, null));
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0098  */
    /* JADX WARN: Code duplicated, block: B:30:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e8 A[Catch: all -> 0x0052, TryCatch #1 {all -> 0x0052, blocks: (B:14:0x004d, B:45:0x00e2, B:47:0x00e8, B:53:0x00f9), top: B:72:0x004d }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:50:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:62:0x0128 A[LOOP:1: B:32:0x00a9->B:62:0x0128, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:64:0x012f  */
    /* JADX WARN: Code duplicated, block: B:66:0x0143 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:74:0x011a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:? A[LOOP:0: B:45:0x00e2->B:77:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x00d1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Instruction removed from duplicated block: B:47:0x00e8, please report this as an issue */
    public static final Object collectRecursively(SequenceScope<? super Path> sequenceScope, okio.FileSystem fileSystem, ArrayDeque<Path> arrayDeque, Path path, boolean z, boolean z2, Continuation<? super Unit> continuation) throws Throwable {
        C45081 c45081;
        SequenceScope $this$collectRecursively;
        ArrayDeque<Path> arrayDeque2;
        boolean followSymlinks;
        okio.FileSystem fileSystem2;
        Path path2;
        boolean postorder;
        List<Path> listListOrNull;
        Path symlinkPath;
        int symlinkCount;
        Path pathSymlinkTarget;
        ArrayDeque<Path> arrayDeque3;
        SequenceScope $this$collectRecursively2;
        okio.FileSystem fileSystem3;
        Path path3;
        Iterator<Path> it;
        Path next;
        boolean z3;
        boolean z4;
        if (continuation instanceof C45081) {
            c45081 = (C45081) continuation;
            if ((c45081.label & Integer.MIN_VALUE) != 0) {
                c45081.label -= Integer.MIN_VALUE;
            } else {
                c45081 = new C45081(continuation);
            }
        } else {
            c45081 = new C45081(continuation);
        }
        Object $result = c45081.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c45081.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$collectRecursively = sequenceScope;
                arrayDeque2 = arrayDeque;
                followSymlinks = z;
                fileSystem2 = fileSystem;
                path2 = path;
                postorder = z2;
                if (!postorder) {
                    c45081.L$0 = $this$collectRecursively;
                    c45081.L$1 = fileSystem2;
                    c45081.L$2 = arrayDeque2;
                    c45081.L$3 = path2;
                    c45081.Z$0 = followSymlinks;
                    c45081.Z$1 = postorder;
                    c45081.label = 1;
                    if ($this$collectRecursively.yield(path2, c45081) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                listListOrNull = fileSystem2.listOrNull(path2);
                if (listListOrNull == null) {
                    listListOrNull = CollectionsKt.emptyList();
                }
                if (!listListOrNull.isEmpty()) {
                    symlinkPath = path2;
                    symlinkCount = 0;
                    while (true) {
                        if (!followSymlinks && arrayDeque2.contains(symlinkPath)) {
                            throw new IOException("symlink cycle at " + path2);
                        }
                        pathSymlinkTarget = symlinkTarget(fileSystem2, symlinkPath);
                        if (pathSymlinkTarget == null) {
                            if (!followSymlinks || symlinkCount == 0) {
                                arrayDeque2.addLast(symlinkPath);
                                try {
                                    Iterator<Path> it2 = listListOrNull.iterator();
                                    $this$collectRecursively2 = $this$collectRecursively;
                                    fileSystem3 = fileSystem2;
                                    arrayDeque3 = arrayDeque2;
                                    path3 = path2;
                                    it = it2;
                                    while (it.hasNext()) {
                                        next = it.next();
                                        if (followSymlinks) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                        z4 = postorder;
                                        c45081.L$0 = $this$collectRecursively2;
                                        c45081.L$1 = fileSystem3;
                                        c45081.L$2 = arrayDeque3;
                                        c45081.L$3 = path3;
                                        c45081.L$4 = it;
                                        c45081.Z$0 = followSymlinks;
                                        c45081.Z$1 = postorder;
                                        c45081.label = 2;
                                        if (collectRecursively($this$collectRecursively2, fileSystem3, arrayDeque3, next, z3, z4, c45081) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        break;
                                    }
                                    arrayDeque3.removeLast();
                                    path2 = path3;
                                    $this$collectRecursively = $this$collectRecursively2;
                                } catch (Throwable th) {
                                    th = th;
                                    arrayDeque3 = arrayDeque2;
                                    arrayDeque3.removeLast();
                                    throw th;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        symlinkPath = pathSymlinkTarget;
                        symlinkCount++;
                    }
                }
                if (postorder) {
                    c45081.L$0 = null;
                    c45081.L$1 = null;
                    c45081.L$2 = null;
                    c45081.L$3 = null;
                    c45081.L$4 = null;
                    c45081.label = 3;
                    if ($this$collectRecursively.yield(path2, c45081) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            case 1:
                postorder = c45081.Z$1;
                followSymlinks = c45081.Z$0;
                path2 = (Path) c45081.L$3;
                arrayDeque2 = (ArrayDeque) c45081.L$2;
                fileSystem2 = (okio.FileSystem) c45081.L$1;
                $this$collectRecursively = (SequenceScope) c45081.L$0;
                ResultKt.throwOnFailure($result);
                listListOrNull = fileSystem2.listOrNull(path2);
                if (listListOrNull == null) {
                    listListOrNull = CollectionsKt.emptyList();
                }
                if (!listListOrNull.isEmpty()) {
                    symlinkPath = path2;
                    symlinkCount = 0;
                    while (true) {
                        if (!followSymlinks) {
                        }
                        pathSymlinkTarget = symlinkTarget(fileSystem2, symlinkPath);
                        if (pathSymlinkTarget == null) {
                            if (!followSymlinks) {
                            }
                            arrayDeque2.addLast(symlinkPath);
                            Iterator<Path> it3 = listListOrNull.iterator();
                            $this$collectRecursively2 = $this$collectRecursively;
                            fileSystem3 = fileSystem2;
                            arrayDeque3 = arrayDeque2;
                            path3 = path2;
                            it = it3;
                            while (it.hasNext()) {
                                next = it.next();
                                if (followSymlinks) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (postorder) {
                                }
                                c45081.L$0 = $this$collectRecursively2;
                                c45081.L$1 = fileSystem3;
                                c45081.L$2 = arrayDeque3;
                                c45081.L$3 = path3;
                                c45081.L$4 = it;
                                c45081.Z$0 = followSymlinks;
                                c45081.Z$1 = postorder;
                                c45081.label = 2;
                                if (collectRecursively($this$collectRecursively2, fileSystem3, arrayDeque3, next, z3, z4, c45081) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                break;
                            }
                            arrayDeque3.removeLast();
                            path2 = path3;
                            $this$collectRecursively = $this$collectRecursively2;
                        } else {
                            symlinkPath = pathSymlinkTarget;
                            symlinkCount++;
                        }
                        break;
                    }
                }
                if (postorder) {
                    c45081.L$0 = null;
                    c45081.L$1 = null;
                    c45081.L$2 = null;
                    c45081.L$3 = null;
                    c45081.L$4 = null;
                    c45081.label = 3;
                    if ($this$collectRecursively.yield(path2, c45081) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            case 2:
                postorder = c45081.Z$1;
                followSymlinks = c45081.Z$0;
                it = (Iterator) c45081.L$4;
                path3 = (Path) c45081.L$3;
                arrayDeque3 = (ArrayDeque) c45081.L$2;
                fileSystem3 = (okio.FileSystem) c45081.L$1;
                $this$collectRecursively2 = (SequenceScope) c45081.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    while (it.hasNext()) {
                        next = it.next();
                        if (followSymlinks) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (postorder) {
                        }
                        c45081.L$0 = $this$collectRecursively2;
                        c45081.L$1 = fileSystem3;
                        c45081.L$2 = arrayDeque3;
                        c45081.L$3 = path3;
                        c45081.L$4 = it;
                        c45081.Z$0 = followSymlinks;
                        c45081.Z$1 = postorder;
                        c45081.label = 2;
                        if (collectRecursively($this$collectRecursively2, fileSystem3, arrayDeque3, next, z3, z4, c45081) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    }
                    arrayDeque3.removeLast();
                    path2 = path3;
                    $this$collectRecursively = $this$collectRecursively2;
                    if (postorder) {
                        c45081.L$0 = null;
                        c45081.L$1 = null;
                        c45081.L$2 = null;
                        c45081.L$3 = null;
                        c45081.L$4 = null;
                        c45081.label = 3;
                        if ($this$collectRecursively.yield(path2, c45081) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    arrayDeque3.removeLast();
                    throw th;
                }
            case 3:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final Path symlinkTarget(okio.FileSystem $this$symlinkTarget, Path path) throws IOException {
        Intrinsics.checkNotNullParameter($this$symlinkTarget, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        Path target = $this$symlinkTarget.metadata(path).getSymlinkTarget();
        if (target == null) {
            return null;
        }
        Path pathParent = path.parent();
        Intrinsics.checkNotNull(pathParent);
        return pathParent.resolve(target);
    }

    public static final void commonCopy(okio.FileSystem $this$commonCopy, Path source, Path target) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonCopy, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        Closeable $this$use$iv = $this$commonCopy.source(source);
        Object result$iv = null;
        Throwable thrown$iv = null;
        try {
            Source bytesIn = (Source) $this$use$iv;
            Closeable $this$use$iv2 = Okio.buffer($this$commonCopy.sink(target));
            Object result$iv2 = null;
            Throwable thrown$iv2 = null;
            try {
                BufferedSink bytesOut = (BufferedSink) $this$use$iv2;
                result$iv2 = Long.valueOf(bytesOut.writeAll(bytesIn));
                if ($this$use$iv2 != null) {
                    try {
                        $this$use$iv2.close();
                    } catch (Throwable t$iv) {
                        thrown$iv2 = t$iv;
                    }
                }
            } catch (Throwable t$iv2) {
                thrown$iv2 = t$iv2;
                if ($this$use$iv2 != null) {
                    try {
                        $this$use$iv2.close();
                    } catch (Throwable t$iv3) {
                        ExceptionsKt.addSuppressed(thrown$iv2, t$iv3);
                    }
                }
            }
            if (thrown$iv2 != null) {
                throw thrown$iv2;
            }
            Intrinsics.checkNotNull(result$iv2);
            result$iv = Long.valueOf(((Number) result$iv2).longValue());
            if ($this$use$iv != null) {
                try {
                    $this$use$iv.close();
                } catch (Throwable t$iv4) {
                    thrown$iv = t$iv4;
                }
            }
            if (thrown$iv != null) {
                throw thrown$iv;
            }
            Intrinsics.checkNotNull(result$iv);
        } catch (Throwable t$iv5) {
            thrown$iv = t$iv5;
            if ($this$use$iv != null) {
                try {
                    $this$use$iv.close();
                } catch (Throwable t$iv6) {
                    ExceptionsKt.addSuppressed(thrown$iv, t$iv6);
                }
            }
        }
    }
}
