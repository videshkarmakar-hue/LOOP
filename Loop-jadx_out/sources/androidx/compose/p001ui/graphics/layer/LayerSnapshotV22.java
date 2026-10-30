package androidx.compose.p001ui.graphics.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.media.Image;
import android.media.ImageReader;
import android.os.Looper;
import android.view.Surface;
import androidx.compose.p001ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.ColorKt;
import androidx.compose.p001ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.HandlerCompat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: LayerSnapshot.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, m195d2 = {"Landroidx/compose/ui/graphics/layer/LayerSnapshotV22;", "Landroidx/compose/ui/graphics/layer/LayerSnapshotImpl;", "()V", "toBitmap", "Landroid/graphics/Bitmap;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui-graphics_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LayerSnapshotV22 implements LayerSnapshotImpl {
    public static final LayerSnapshotV22 INSTANCE = new LayerSnapshotV22();

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.layer.LayerSnapshotV22$toBitmap$1 */
    /* JADX INFO: compiled from: LayerSnapshot.android.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.ui.graphics.layer.LayerSnapshotV22", m210f = "LayerSnapshot.android.kt", m211i = {0, 0, 0, 0}, m212l = {231}, m213m = "toBitmap", m214n = {"graphicsLayer", "looper", "reader", "$completion$iv"}, m215s = {"L$0", "L$1", "L$3", "L$4"})
    static final class C17551 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C17551(Continuation<? super C17551> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LayerSnapshotV22.this.toBitmap(null, this);
        }
    }

    private LayerSnapshotV22() {
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    @Override // androidx.compose.p001ui.graphics.layer.LayerSnapshotImpl
    public Object toBitmap(GraphicsLayer graphicsLayer, Continuation<? super Bitmap> continuation) throws Exception {
        C17551 c17551;
        ImageReader imageReaderNewInstance;
        Object obj;
        if (continuation instanceof C17551) {
            c17551 = (C17551) continuation;
            if ((c17551.label & Integer.MIN_VALUE) != 0) {
                c17551.label -= Integer.MIN_VALUE;
            } else {
                c17551 = new C17551(continuation);
            }
        } else {
            c17551 = new C17551(continuation);
        }
        Object $result = c17551.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (c17551.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    long size = graphicsLayer.getSize();
                    Looper looper = Looper.myLooper();
                    if (looper == null) {
                        looper = Looper.getMainLooper();
                    }
                    imageReaderNewInstance = ImageReader.newInstance(IntSize.m6975getWidthimpl(size), IntSize.m6974getHeightimpl(size), 1, 1);
                    ImageReader reader = imageReaderNewInstance;
                    Continuation $completion$iv = c17551;
                    c17551.L$0 = graphicsLayer;
                    c17551.L$1 = looper;
                    c17551.L$2 = imageReaderNewInstance;
                    c17551.L$3 = reader;
                    c17551.L$4 = $completion$iv;
                    c17551.label = 1;
                    Continuation uCont$iv = $completion$iv;
                    CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
                    cancellable$iv.initCancellability();
                    final CancellableContinuationImpl continuation2 = cancellable$iv;
                    reader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: androidx.compose.ui.graphics.layer.LayerSnapshotV22$toBitmap$2$image$1$1
                        @Override // android.media.ImageReader.OnImageAvailableListener
                        public final void onImageAvailable(ImageReader it) {
                            CancellableContinuation<Image> cancellableContinuation = continuation2;
                            Result.Companion companion = Result.INSTANCE;
                            cancellableContinuation.resumeWith(Result.m7693constructorimpl(it.acquireLatestImage()));
                        }
                    }, HandlerCompat.createAsync(looper));
                    Surface surface = reader.getSurface();
                    Canvas canvas = SurfaceUtils.INSTANCE.lockCanvas(surface);
                    try {
                        canvas.drawColor(ColorKt.m4345toArgb8_81llA(Color.INSTANCE.m4317getBlack0d7_KjU()), PorterDuff.Mode.CLEAR);
                        graphicsLayer.draw$ui_graphics_release(AndroidCanvas_androidKt.Canvas(canvas), null);
                        surface.unlockCanvasAndPost(canvas);
                        Object result = cancellable$iv.getResult();
                        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended($completion$iv);
                        }
                        if (result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = result;
                        Image image = (Image) obj;
                        Bitmap bitmap = LayerSnapshot_androidKt.toBitmap(image);
                        AutoCloseableKt.closeFinally(imageReaderNewInstance, null);
                        return bitmap;
                    } catch (Throwable th) {
                        surface.unlockCanvasAndPost(canvas);
                        throw th;
                    }
                case 1:
                    imageReaderNewInstance = (AutoCloseable) c17551.L$2;
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    Image image2 = (Image) obj;
                    Bitmap bitmap2 = LayerSnapshot_androidKt.toBitmap(image2);
                    AutoCloseableKt.closeFinally(imageReaderNewInstance, null);
                    return bitmap2;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                AutoCloseableKt.closeFinally(imageReaderNewInstance, th2);
                throw th3;
            }
        }
    }
}
