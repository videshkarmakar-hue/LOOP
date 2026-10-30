package com.videshkarmakar.loop.p006ui.page.videolist;

import android.content.Context;
import android.net.Uri;
import androidx.compose.material3.SnackbarHostState;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.database.backup.Backup;
import com.videshkarmakar.loop.database.backup.BackupUtil;
import com.videshkarmakar.loop.database.objects.DownloadedVideoInfo;
import com.videshkarmakar.loop.p006ui.page.download.DownloadViewModel$ViewState$$ExternalSyntheticBackport0;
import com.videshkarmakar.loop.util.DatabaseUtil;
import com.videshkarmakar.loop.util.DownloadUtil;
import com.videshkarmakar.loop.util.FileUtil;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.p007io.CloseableKt;
import kotlin.p007io.TextStreamsKt;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal.p009ws.WebSocketProtocol;

/* JADX INFO: compiled from: VideoListViewModel.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(m194d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001>B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\tJ\u0006\u0010#\u001a\u00020 J\u001c\u0010$\u001a\u00020 2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010&\u001a\u00020'J\u0016\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010*J7\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\u000f2\"\u0010+\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0-\u0012\u0006\u0012\u0004\u0018\u00010.0,¢\u0006\u0002\u0010/J?\u00100\u001a\u00020 2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\"\u0010+\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0-\u0012\u0006\u0012\u0004\u0018\u00010.0,¢\u0006\u0002\u00105J\u001e\u00106\u001a\u00020 2\u0006\u00107\u001a\u0002082\u0006\u00101\u001a\u0002022\u0006\u00109\u001a\u00020\tJ\u0010\u0010:\u001a\u00020 2\b\b\u0002\u0010;\u001a\u00020'J\u000e\u0010<\u001a\u00020 2\u0006\u0010=\u001a\u00020\u000fR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\fR\u0014\u0010\u001c\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006?"}, m195d2 = {"Lcom/videshkarmakar/loop/ui/page/videolist/VideoListViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_mediaInfoFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/videshkarmakar/loop/database/objects/DownloadedVideoInfo;", "fileSizeMapFlow", "", "", "", "getFileSizeMapFlow", "()Lkotlinx/coroutines/flow/Flow;", "filterSetFlow", "", "", "getFilterSetFlow", "mutableStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/videshkarmakar/loop/ui/page/videolist/VideoListViewModel$VideoListViewState;", "searchedVideoListFlow", "getSearchedVideoListFlow", "stateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "videoListFlow", "getVideoListFlow", "viewState", "getViewState", "()Lcom/videshkarmakar/loop/ui/page/videolist/VideoListViewModel$VideoListViewState;", "clickAudioFilter", "", "clickExtractorFilter", "index", "clickVideoFilter", "deleteDownloadHistory", "infoList", "deleteFile", "", "importBackupFromText", "string", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onComplete", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "importBackupFromUri", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "(Landroid/content/Context;Landroid/net/Uri;Lkotlin/jvm/functions/Function2;)V", "showImportedSnackbar", "hostState", "Landroidx/compose/material3/SnackbarHostState;", "importedCount", "toggleSearch", "isSearching", "updateSearchText", "text", "VideoListViewState", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class VideoListViewModel extends ViewModel {
    public static final int $stable = 8;
    private final Flow<Map<Integer, Long>> fileSizeMapFlow;
    private final Flow<Set<String>> filterSetFlow;
    private final Flow<List<DownloadedVideoInfo>> searchedVideoListFlow;
    private final Flow<List<DownloadedVideoInfo>> videoListFlow;
    private final MutableStateFlow<VideoListViewState> mutableStateFlow = StateFlowKt.MutableStateFlow(new VideoListViewState(0, false, false, false, null, 31, null));
    private final StateFlow<VideoListViewState> stateFlow = FlowKt.asStateFlow(this.mutableStateFlow);
    private final Flow<List<DownloadedVideoInfo>> _mediaInfoFlow = DatabaseUtil.INSTANCE.getDownloadHistoryFlow();

    @Inject
    public VideoListViewModel() {
        final Flow<List<DownloadedVideoInfo>> flow = this._mediaInfoFlow;
        this.videoListFlow = (Flow) new Flow<List<? extends DownloadedVideoInfo>>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$special$$inlined$map$1

            /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$special$$inlined$map$1$2 */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m195d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", DownloadUtil.CookieScheme.VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            public static final class C40332<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$special$$inlined$map$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$special$$inlined$map$1$2", m210f = "VideoListViewModel.kt", m211i = {}, m212l = {223}, m213m = "emit", m214n = {}, m215s = {})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return C40332.this.emit(null, this);
                    }
                }

                public C40332(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object value, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                    AnonymousClass1 anonymousClass2 = anonymousClass1;
                    Object $result = anonymousClass2.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (anonymousClass2.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            FlowCollector flowCollector = this.$this_unsafeFlow;
                            List it = (List) value;
                            Iterable $this$sortedBy$iv = CollectionsKt.reversed(it);
                            List listSortedWith = CollectionsKt.sortedWith($this$sortedBy$iv, 
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0050: INVOKE (r5v4 'listSortedWith' java.util.List A[D('$this$sortedBy$iv' java.lang.Iterable)]) = 
                                  (r5v3 '$this$sortedBy$iv' java.lang.Iterable A[D('$this$sortedBy$iv' java.lang.Iterable)])
                                  (wrap java.util.Comparator:0x004b: CONSTRUCTOR  A[MD:():void (m), WRAPPED] (LINE:225) call: com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$videoListFlow$lambda$1$$inlined$sortedBy$1.<init>():void type: CONSTRUCTOR)
                                 STATIC call: kotlin.collections.CollectionsKt.sortedWith(java.lang.Iterable, java.util.Comparator):java.util.List A[DECLARE_VAR, MD:<T>:(java.lang.Iterable<? extends T>, java.util.Comparator<? super T>):java.util.List<T> (m)] (LINE:225) in method: com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$special$$inlined$map$1.2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object, file: classes15.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:267)
                                	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$videoListFlow$lambda$1$$inlined$sortedBy$1, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	... 21 more
                                */
                            /*
                                this = this;
                                boolean r0 = r10 instanceof com.videshkarmakar.loop.p006ui.page.videolist.VideoListViewModel$special$$inlined$map$1.C40332.AnonymousClass1
                                if (r0 == 0) goto L14
                                r0 = r10
                                com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$special$$inlined$map$1$2$1 r0 = (com.videshkarmakar.loop.p006ui.page.videolist.VideoListViewModel$special$$inlined$map$1.C40332.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r1 = r1 & r2
                                if (r1 == 0) goto L14
                                int r10 = r0.label
                                int r10 = r10 - r2
                                r0.label = r10
                                goto L19
                            L14:
                                com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$special$$inlined$map$1$2$1 r0 = new com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$special$$inlined$map$1$2$1
                                r0.<init>(r10)
                            L19:
                                r10 = r0
                                java.lang.Object r0 = r10.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r10.label
                                switch(r2) {
                                    case 0: goto L32;
                                    case 1: goto L2d;
                                    default: goto L25;
                                }
                            L25:
                                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                                r9.<init>(r10)
                                throw r9
                            L2d:
                                r9 = 0
                                kotlin.ResultKt.throwOnFailure(r0)
                                goto L60
                            L32:
                                kotlin.ResultKt.throwOnFailure(r0)
                                r2 = r8
                                kotlinx.coroutines.flow.FlowCollector r2 = r2.$this_unsafeFlow
                                r3 = 0
                                r4 = r10
                                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                                java.util.List r9 = (java.util.List) r9
                                r4 = 0
                                r5 = r9
                                java.lang.Iterable r5 = (java.lang.Iterable) r5
                                java.util.List r5 = kotlin.collections.CollectionsKt.reversed(r5)
                                java.lang.Iterable r5 = (java.lang.Iterable) r5
                                r6 = 0
                                com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$videoListFlow$lambda$1$$inlined$sortedBy$1 r7 = new com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$videoListFlow$lambda$1$$inlined$sortedBy$1
                                r7.<init>()
                                java.util.Comparator r7 = (java.util.Comparator) r7
                                java.util.List r5 = kotlin.collections.CollectionsKt.sortedWith(r5, r7)
                                r9 = 1
                                r10.label = r9
                                java.lang.Object r9 = r2.emit(r5, r10)
                                if (r9 != r1) goto L5f
                                return r1
                            L5f:
                                r9 = r3
                            L60:
                                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                                return r9
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.videshkarmakar.loop.p006ui.page.videolist.VideoListViewModel$special$$inlined$map$1.C40332.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector<? super List<? extends DownloadedVideoInfo>> flowCollector, Continuation $completion) {
                        Object objCollect = flow.collect(new C40332(flowCollector), $completion);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                };
                this.searchedVideoListFlow = FlowKt.flowCombine(this.videoListFlow, this.stateFlow, new VideoListViewModel$searchedVideoListFlow$1(null));
                final Flow<List<DownloadedVideoInfo>> flow2 = this.searchedVideoListFlow;
                this.filterSetFlow = new Flow<Set<String>>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$special$$inlined$map$2

                    /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$special$$inlined$map$2$2 */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m195d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", DownloadUtil.CookieScheme.VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    public static final class C40342<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$special$$inlined$map$2$2$1, reason: invalid class name */
                        /* JADX INFO: compiled from: Emitters.kt */
                        @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                        @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$special$$inlined$map$2$2", m210f = "VideoListViewModel.kt", m211i = {}, m212l = {223}, m213m = "emit", m214n = {}, m215s = {})
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            Object L$0;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return C40342.this.emit(null, this);
                            }
                        }

                        public C40342(FlowCollector flowCollector) {
                            this.$this_unsafeFlow = flowCollector;
                        }

                        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(Object value, Continuation continuation) {
                            AnonymousClass1 anonymousClass1;
                            if (continuation instanceof AnonymousClass1) {
                                anonymousClass1 = (AnonymousClass1) continuation;
                                if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                                    anonymousClass1.label -= Integer.MIN_VALUE;
                                } else {
                                    anonymousClass1 = new AnonymousClass1(continuation);
                                }
                            } else {
                                anonymousClass1 = new AnonymousClass1(continuation);
                            }
                            AnonymousClass1 anonymousClass2 = anonymousClass1;
                            Object $result = anonymousClass2.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (anonymousClass2.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    Iterable infoList = (List) value;
                                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                                    Iterable $this$forEach$iv = infoList;
                                    for (Object element$iv : $this$forEach$iv) {
                                        DownloadedVideoInfo it = (DownloadedVideoInfo) element$iv;
                                        linkedHashSet.add(it.getExtractor());
                                    }
                                    anonymousClass2.label = 1;
                                    if (flowCollector.emit(linkedHashSet, anonymousClass2) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    break;
                                    break;
                                case 1:
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector<? super Set<String>> flowCollector, Continuation $completion) {
                        Object objCollect = flow2.collect(new C40342(flowCollector), $completion);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                };
                final Flow $this$map$iv = FlowKt.flowOn(this.videoListFlow, Dispatchers.getIO());
                this.fileSizeMapFlow = (Flow) new Flow<Map<Integer, ? extends Long>>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$special$$inlined$map$3

                    /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$special$$inlined$map$3$2 */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m195d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", DownloadUtil.CookieScheme.VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    public static final class C40352<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$special$$inlined$map$3$2$1, reason: invalid class name */
                        /* JADX INFO: compiled from: Emitters.kt */
                        @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                        @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$special$$inlined$map$3$2", m210f = "VideoListViewModel.kt", m211i = {}, m212l = {223}, m213m = "emit", m214n = {}, m215s = {})
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            Object L$0;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return C40352.this.emit(null, this);
                            }
                        }

                        public C40352(FlowCollector flowCollector) {
                            this.$this_unsafeFlow = flowCollector;
                        }

                        /* JADX WARN: Code duplicated, block: B:7:0x0019  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(Object value, Continuation continuation) {
                            AnonymousClass1 anonymousClass1;
                            if (continuation instanceof AnonymousClass1) {
                                AnonymousClass1 anonymousClass2 = (AnonymousClass1) continuation;
                                if ((anonymousClass2.label & Integer.MIN_VALUE) != 0) {
                                    anonymousClass2.label -= Integer.MIN_VALUE;
                                    anonymousClass1 = anonymousClass2;
                                } else {
                                    anonymousClass1 = new AnonymousClass1(continuation);
                                }
                            } else {
                                anonymousClass1 = new AnonymousClass1(continuation);
                            }
                            Object $result = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (anonymousClass1.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    Iterable list = (List) value;
                                    Iterable $this$associate$iv = list;
                                    int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
                                    LinkedHashMap linkedHashMap = new LinkedHashMap(capacity$iv);
                                    for (Object element$iv$iv : $this$associate$iv) {
                                        DownloadedVideoInfo it = (DownloadedVideoInfo) element$iv$iv;
                                        Object $result2 = $result;
                                        Pair pairM202to = TuplesKt.m202to(Boxing.boxInt(it.getId()), Boxing.boxLong(FileUtil.INSTANCE.getFileSize(it.getVideoPath())));
                                        linkedHashMap.put(pairM202to.getFirst(), pairM202to.getSecond());
                                        $result = $result2;
                                    }
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(linkedHashMap, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    break;
                                    break;
                                case 1:
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector<? super Map<Integer, ? extends Long>> flowCollector, Continuation $completion) {
                        Object objCollect = $this$map$iv.collect(new C40352(flowCollector), $completion);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                };
            }

            public final StateFlow<VideoListViewState> getStateFlow() {
                return this.stateFlow;
            }

            private final VideoListViewState getViewState() {
                return this.stateFlow.getValue();
            }

            public final Flow<List<DownloadedVideoInfo>> getVideoListFlow() {
                return this.videoListFlow;
            }

            public final Flow<List<DownloadedVideoInfo>> getSearchedVideoListFlow() {
                return this.searchedVideoListFlow;
            }

            public final Flow<Set<String>> getFilterSetFlow() {
                return this.filterSetFlow;
            }

            public final Flow<Map<Integer, Long>> getFileSizeMapFlow() {
                return this.fileSizeMapFlow;
            }

            public final void clickVideoFilter() {
                VideoListViewState value;
                VideoListViewState it;
                VideoListViewState value2;
                VideoListViewState it2;
                if (!this.mutableStateFlow.getValue().getVideoFilter()) {
                    MutableStateFlow<VideoListViewState> mutableStateFlow = this.mutableStateFlow;
                    do {
                        value = mutableStateFlow.getValue();
                        it = value;
                    } while (!mutableStateFlow.compareAndSet(value, VideoListViewState.copy$default(it, 0, true, false, false, null, 25, null)));
                    return;
                }
                MutableStateFlow<VideoListViewState> mutableStateFlow2 = this.mutableStateFlow;
                do {
                    value2 = mutableStateFlow2.getValue();
                    it2 = value2;
                } while (!mutableStateFlow2.compareAndSet(value2, VideoListViewState.copy$default(it2, 0, false, false, false, null, 29, null)));
            }

            public final void clickAudioFilter() {
                VideoListViewState value;
                VideoListViewState it;
                VideoListViewState value2;
                VideoListViewState it2;
                if (!this.mutableStateFlow.getValue().getAudioFilter()) {
                    MutableStateFlow<VideoListViewState> mutableStateFlow = this.mutableStateFlow;
                    do {
                        value = mutableStateFlow.getValue();
                        it = value;
                    } while (!mutableStateFlow.compareAndSet(value, VideoListViewState.copy$default(it, 0, false, true, false, null, 25, null)));
                    return;
                }
                MutableStateFlow<VideoListViewState> mutableStateFlow2 = this.mutableStateFlow;
                do {
                    value2 = mutableStateFlow2.getValue();
                    it2 = value2;
                } while (!mutableStateFlow2.compareAndSet(value2, VideoListViewState.copy$default(it2, 0, false, false, false, null, 27, null)));
            }

            public final void clickExtractorFilter(int index) {
                VideoListViewState value;
                VideoListViewState it;
                VideoListViewState value2;
                VideoListViewState it2;
                if (this.mutableStateFlow.getValue().getActiveFilterIndex() != index) {
                    MutableStateFlow<VideoListViewState> mutableStateFlow = this.mutableStateFlow;
                    do {
                        value = mutableStateFlow.getValue();
                        it = value;
                    } while (!mutableStateFlow.compareAndSet(value, VideoListViewState.copy$default(it, index, false, false, false, null, 30, null)));
                    return;
                }
                MutableStateFlow<VideoListViewState> mutableStateFlow2 = this.mutableStateFlow;
                do {
                    value2 = mutableStateFlow2.getValue();
                    it2 = value2;
                } while (!mutableStateFlow2.compareAndSet(value2, VideoListViewState.copy$default(it2, -1, false, false, false, null, 30, null)));
            }

            public static /* synthetic */ void toggleSearch$default(VideoListViewModel videoListViewModel, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = !videoListViewModel.getViewState().isSearching();
                }
                videoListViewModel.toggleSearch(z);
            }

            public final void toggleSearch(boolean isSearching) {
                VideoListViewState value;
                VideoListViewState it;
                MutableStateFlow<VideoListViewState> mutableStateFlow = this.mutableStateFlow;
                do {
                    value = mutableStateFlow.getValue();
                    it = value;
                } while (!mutableStateFlow.compareAndSet(value, VideoListViewState.copy$default(it, 0, false, false, isSearching, "", 7, null)));
            }

            public final void updateSearchText(String text) {
                VideoListViewState value;
                VideoListViewState it;
                Intrinsics.checkNotNullParameter(text, "text");
                MutableStateFlow<VideoListViewState> mutableStateFlow = this.mutableStateFlow;
                do {
                    value = mutableStateFlow.getValue();
                    it = value;
                } while (!mutableStateFlow.compareAndSet(value, VideoListViewState.copy$default(it, 0, false, false, false, text, 15, null)));
            }

            /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$deleteDownloadHistory$1 */
            /* JADX INFO: compiled from: VideoListViewModel.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$deleteDownloadHistory$1", m210f = "VideoListViewModel.kt", m211i = {}, m212l = {102}, m213m = "invokeSuspend", m214n = {}, m215s = {})
            static final class C40291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ boolean $deleteFile;
                final /* synthetic */ List<DownloadedVideoInfo> $infoList;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C40291(List<DownloadedVideoInfo> list, boolean z, Continuation<? super C40291> continuation) {
                    super(2, continuation);
                    this.$infoList = list;
                    this.$deleteFile = z;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C40291(this.$infoList, this.$deleteFile, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C40291) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            this.label = 1;
                            if (DatabaseUtil.INSTANCE.deleteInfoList(this.$infoList, this.$deleteFile, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        case 1:
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return Unit.INSTANCE;
                }
            }

            public final void deleteDownloadHistory(List<DownloadedVideoInfo> infoList, boolean deleteFile) {
                Intrinsics.checkNotNullParameter(infoList, "infoList");
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C40291(infoList, deleteFile, null), 2, null);
            }

            /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$importBackupFromUri$1 */
            /* JADX INFO: compiled from: VideoListViewModel.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$importBackupFromUri$1", m210f = "VideoListViewModel.kt", m211i = {0}, m212l = {113, 116}, m213m = "invokeSuspend", m214n = {"res"}, m215s = {"L$0"})
            static final class C40311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Context $context;
                final /* synthetic */ Function2<Integer, Continuation<? super Unit>, Object> $onComplete;
                final /* synthetic */ Uri $uri;
                Object L$0;
                Object L$1;
                Object L$2;
                int label;
                final /* synthetic */ VideoListViewModel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C40311(Context context, Uri uri, VideoListViewModel videoListViewModel, Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super C40311> continuation) {
                    super(2, continuation);
                    this.$context = context;
                    this.$uri = uri;
                    this.this$0 = videoListViewModel;
                    this.$onComplete = function2;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C40311(this.$context, this.$uri, this.this$0, this.$onComplete, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C40311) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code duplicated, block: B:33:0x00c6 A[RETURN] */
                /* JADX WARN: Code duplicated, block: B:34:0x00c7  */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) throws FileNotFoundException {
                    C40311 c40311;
                    Ref.IntRef res;
                    InputStream inputStream;
                    Ref.IntRef res2;
                    C40311 c40312;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    try {
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                c40311 = this;
                                res = new Ref.IntRef();
                                InputStream inputStreamOpenInputStream = c40311.$context.getContentResolver().openInputStream(c40311.$uri);
                                if (inputStreamOpenInputStream != null) {
                                    inputStream = inputStreamOpenInputStream;
                                    VideoListViewModel videoListViewModel = c40311.this$0;
                                    InputStream input = inputStream;
                                    Reader inputStreamReader = new InputStreamReader(input, Charsets.UTF_8);
                                    String it = TextStreamsKt.readText(inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192));
                                    c40311.L$0 = res;
                                    c40311.L$1 = inputStream;
                                    c40311.L$2 = res;
                                    c40311.label = 1;
                                    Object objImportBackupFromText = videoListViewModel.importBackupFromText(it, (Continuation<? super Integer>) c40311);
                                    if (objImportBackupFromText == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    res2 = res;
                                    $result = objImportBackupFromText;
                                    c40312 = c40311;
                                    try {
                                        res.element = ((Number) $result).intValue();
                                        Unit unit = Unit.INSTANCE;
                                        CloseableKt.closeFinally(inputStream, null);
                                        c40311 = c40312;
                                        res = res2;
                                    } catch (Throwable th) {
                                        th = th;
                                        try {
                                            throw th;
                                        } catch (Throwable th2) {
                                            CloseableKt.closeFinally(inputStream, th);
                                            throw th2;
                                        }
                                    }
                                }
                                c40311.L$0 = null;
                                c40311.L$1 = null;
                                c40311.L$2 = null;
                                c40311.label = 2;
                                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(c40311.$onComplete, res, null), c40311) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return Unit.INSTANCE;
                            case 1:
                                res = (Ref.IntRef) this.L$2;
                                inputStream = (Closeable) this.L$1;
                                Ref.IntRef res3 = (Ref.IntRef) this.L$0;
                                ResultKt.throwOnFailure($result);
                                res2 = res3;
                                c40312 = this;
                                res.element = ((Number) $result).intValue();
                                Unit unit2 = Unit.INSTANCE;
                                CloseableKt.closeFinally(inputStream, null);
                                c40311 = c40312;
                                res = res2;
                                c40311.L$0 = null;
                                c40311.L$1 = null;
                                c40311.L$2 = null;
                                c40311.label = 2;
                                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(c40311.$onComplete, res, null), c40311) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return Unit.INSTANCE;
                            case 2:
                                ResultKt.throwOnFailure($result);
                                return Unit.INSTANCE;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }

                /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$importBackupFromUri$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: VideoListViewModel.kt */
                @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$importBackupFromUri$1$2", m210f = "VideoListViewModel.kt", m211i = {}, m212l = {117}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Function2<Integer, Continuation<? super Unit>, Object> $onComplete;
                    final /* synthetic */ Ref.IntRef $res;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    AnonymousClass2(Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object> function2, Ref.IntRef intRef, Continuation<? super AnonymousClass2> continuation) {
                        super(2, continuation);
                        this.$onComplete = function2;
                        this.$res = intRef;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass2(this.$onComplete, this.$res, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object $result) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                Function2<Integer, Continuation<? super Unit>, Object> function2 = this.$onComplete;
                                Integer numBoxInt = Boxing.boxInt(this.$res.element);
                                this.label = 1;
                                if (function2.invoke(numBoxInt, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                break;
                            case 1:
                                ResultKt.throwOnFailure($result);
                                break;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        return Unit.INSTANCE;
                    }
                }
            }

            public final void importBackupFromUri(Context context, Uri uri, Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object> onComplete) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(uri, "uri");
                Intrinsics.checkNotNullParameter(onComplete, "onComplete");
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C40311(context, uri, this, onComplete, null), 2, null);
            }

            /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$importBackupFromText$1 */
            /* JADX INFO: compiled from: VideoListViewModel.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$importBackupFromText$1", m210f = "VideoListViewModel.kt", m211i = {}, m212l = {WebSocketProtocol.PAYLOAD_SHORT, 127}, m213m = "invokeSuspend", m214n = {}, m215s = {})
            static final class C40301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function2<Integer, Continuation<? super Unit>, Object> $onComplete;
                final /* synthetic */ String $string;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C40301(String str, Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super C40301> continuation) {
                    super(2, continuation);
                    this.$string = str;
                    this.$onComplete = function2;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return VideoListViewModel.this.new C40301(this.$string, this.$onComplete, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C40301) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code duplicated, block: B:14:0x0058 A[RETURN] */
                /* JADX WARN: Code duplicated, block: B:15:0x0059  */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    C40301 c40301;
                    int res;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            this.label = 1;
                            Object objImportBackupFromText = VideoListViewModel.this.importBackupFromText(this.$string, (Continuation<? super Integer>) this);
                            if (objImportBackupFromText == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result = objImportBackupFromText;
                            c40301 = this;
                            res = ((Number) $result).intValue();
                            c40301.label = 2;
                            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(c40301.$onComplete, res, null), c40301) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        case 1:
                            ResultKt.throwOnFailure($result);
                            c40301 = this;
                            res = ((Number) $result).intValue();
                            c40301.label = 2;
                            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(c40301.$onComplete, res, null), c40301) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        case 2:
                            ResultKt.throwOnFailure($result);
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }

                /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$importBackupFromText$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: VideoListViewModel.kt */
                @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$importBackupFromText$1$1", m210f = "VideoListViewModel.kt", m211i = {}, m212l = {128}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Function2<Integer, Continuation<? super Unit>, Object> $onComplete;
                    final /* synthetic */ int $res;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    AnonymousClass1(Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object> function2, int i, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$onComplete = function2;
                        this.$res = i;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$onComplete, this.$res, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object $result) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                Function2<Integer, Continuation<? super Unit>, Object> function2 = this.$onComplete;
                                Integer numBoxInt = Boxing.boxInt(this.$res);
                                this.label = 1;
                                if (function2.invoke(numBoxInt, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                break;
                            case 1:
                                ResultKt.throwOnFailure($result);
                                break;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        return Unit.INSTANCE;
                    }
                }
            }

            public final void importBackupFromText(String string, Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object> onComplete) {
                Intrinsics.checkNotNullParameter(string, "string");
                Intrinsics.checkNotNullParameter(onComplete, "onComplete");
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C40301(string, onComplete, null), 2, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final Object importBackupFromText(String string, Continuation<? super Integer> continuation) {
                Object objM7232decodeToBackupIoAF18A = BackupUtil.INSTANCE.m7232decodeToBackupIoAF18A(string);
                if (Result.m7700isSuccessimpl(objM7232decodeToBackupIoAF18A)) {
                    Backup it = (Backup) objM7232decodeToBackupIoAF18A;
                    return DatabaseUtil.INSTANCE.importBackup(it, SetsKt.setOf(BackupUtil.BackupType.DownloadHistory), continuation);
                }
                return Boxing.boxInt(0);
            }

            /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$showImportedSnackbar$1 */
            /* JADX INFO: compiled from: VideoListViewModel.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel$showImportedSnackbar$1", m210f = "VideoListViewModel.kt", m211i = {}, m212l = {144}, m213m = "invokeSuspend", m214n = {}, m215s = {})
            static final class C40321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Context $context;
                final /* synthetic */ SnackbarHostState $hostState;
                final /* synthetic */ int $importedCount;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C40321(SnackbarHostState snackbarHostState, Context context, int i, Continuation<? super C40321> continuation) {
                    super(2, continuation);
                    this.$hostState = snackbarHostState;
                    this.$context = context;
                    this.$importedCount = i;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C40321(this.$hostState, this.$context, this.$importedCount, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C40321) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            SnackbarHostState snackbarHostState = this.$hostState;
                            String string = this.$context.getString(C3070R.string.download_history_imported);
                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                            String quantityString = this.$context.getResources().getQuantityString(C3070R.plurals.item_count, this.$importedCount);
                            Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
                            String str = String.format(quantityString, Arrays.copyOf(new Object[]{Boxing.boxInt(this.$importedCount)}, 1));
                            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                            String str2 = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
                            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                            this.label = 1;
                            if (SnackbarHostState.showSnackbar$default(snackbarHostState, str2, null, false, null, this, 14, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        case 1:
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return Unit.INSTANCE;
                }
            }

            public final void showImportedSnackbar(SnackbarHostState hostState, Context context, int importedCount) {
                Intrinsics.checkNotNullParameter(hostState, "hostState");
                Intrinsics.checkNotNullParameter(context, "context");
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new C40321(hostState, context, importedCount, null), 2, null);
            }

            /* JADX INFO: compiled from: VideoListViewModel.kt */
            @Metadata(m194d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001c"}, m195d2 = {"Lcom/videshkarmakar/loop/ui/page/videolist/VideoListViewModel$VideoListViewState;", "", "activeFilterIndex", "", "videoFilter", "", "audioFilter", "isSearching", "searchText", "", "(IZZZLjava/lang/String;)V", "getActiveFilterIndex", "()I", "getAudioFilter", "()Z", "getSearchText", "()Ljava/lang/String;", "getVideoFilter", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            public static final /* data */ class VideoListViewState {
                public static final int $stable = 0;
                private final int activeFilterIndex;
                private final boolean audioFilter;
                private final boolean isSearching;
                private final String searchText;
                private final boolean videoFilter;

                public VideoListViewState() {
                    this(0, false, false, false, null, 31, null);
                }

                public static /* synthetic */ VideoListViewState copy$default(VideoListViewState videoListViewState, int i, boolean z, boolean z2, boolean z3, String str, int i2, Object obj) {
                    if ((i2 & 1) != 0) {
                        i = videoListViewState.activeFilterIndex;
                    }
                    if ((i2 & 2) != 0) {
                        z = videoListViewState.videoFilter;
                    }
                    boolean z4 = z;
                    if ((i2 & 4) != 0) {
                        z2 = videoListViewState.audioFilter;
                    }
                    boolean z5 = z2;
                    if ((i2 & 8) != 0) {
                        z3 = videoListViewState.isSearching;
                    }
                    boolean z6 = z3;
                    if ((i2 & 16) != 0) {
                        str = videoListViewState.searchText;
                    }
                    return videoListViewState.copy(i, z4, z5, z6, str);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final int getActiveFilterIndex() {
                    return this.activeFilterIndex;
                }

                /* JADX INFO: renamed from: component2, reason: from getter */
                public final boolean getVideoFilter() {
                    return this.videoFilter;
                }

                /* JADX INFO: renamed from: component3, reason: from getter */
                public final boolean getAudioFilter() {
                    return this.audioFilter;
                }

                /* JADX INFO: renamed from: component4, reason: from getter */
                public final boolean getIsSearching() {
                    return this.isSearching;
                }

                /* JADX INFO: renamed from: component5, reason: from getter */
                public final String getSearchText() {
                    return this.searchText;
                }

                public final VideoListViewState copy(int activeFilterIndex, boolean videoFilter, boolean audioFilter, boolean isSearching, String searchText) {
                    Intrinsics.checkNotNullParameter(searchText, "searchText");
                    return new VideoListViewState(activeFilterIndex, videoFilter, audioFilter, isSearching, searchText);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof VideoListViewState)) {
                        return false;
                    }
                    VideoListViewState videoListViewState = (VideoListViewState) other;
                    return this.activeFilterIndex == videoListViewState.activeFilterIndex && this.videoFilter == videoListViewState.videoFilter && this.audioFilter == videoListViewState.audioFilter && this.isSearching == videoListViewState.isSearching && Intrinsics.areEqual(this.searchText, videoListViewState.searchText);
                }

                public int hashCode() {
                    return (((((((this.activeFilterIndex * 31) + DownloadViewModel$ViewState$$ExternalSyntheticBackport0.m185m(this.videoFilter)) * 31) + DownloadViewModel$ViewState$$ExternalSyntheticBackport0.m185m(this.audioFilter)) * 31) + DownloadViewModel$ViewState$$ExternalSyntheticBackport0.m185m(this.isSearching)) * 31) + this.searchText.hashCode();
                }

                public String toString() {
                    return "VideoListViewState(activeFilterIndex=" + this.activeFilterIndex + ", videoFilter=" + this.videoFilter + ", audioFilter=" + this.audioFilter + ", isSearching=" + this.isSearching + ", searchText=" + this.searchText + ")";
                }

                public VideoListViewState(int activeFilterIndex, boolean videoFilter, boolean audioFilter, boolean isSearching, String searchText) {
                    Intrinsics.checkNotNullParameter(searchText, "searchText");
                    this.activeFilterIndex = activeFilterIndex;
                    this.videoFilter = videoFilter;
                    this.audioFilter = audioFilter;
                    this.isSearching = isSearching;
                    this.searchText = searchText;
                }

                public /* synthetic */ VideoListViewState(int i, boolean z, boolean z2, boolean z3, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? false : z2, (i2 & 8) == 0 ? z3 : false, (i2 & 16) != 0 ? "" : str);
                }

                public final int getActiveFilterIndex() {
                    return this.activeFilterIndex;
                }

                public final boolean getVideoFilter() {
                    return this.videoFilter;
                }

                public final boolean getAudioFilter() {
                    return this.audioFilter;
                }

                public final boolean isSearching() {
                    return this.isSearching;
                }

                public final String getSearchText() {
                    return this.searchText;
                }
            }
        }
