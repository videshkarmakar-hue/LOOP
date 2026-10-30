package coil.fetch;

import androidx.constraintlayout.widget.ConstraintLayout;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.ImageSources;
import coil.request.Options;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okio.Buffer;

/* JADX INFO: compiled from: ByteBufferFetcher.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\nB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, m195d2 = {"Lcoil/fetch/ByteBufferFetcher;", "Lcoil/fetch/Fetcher;", "data", "Ljava/nio/ByteBuffer;", "options", "Lcoil/request/Options;", "(Ljava/nio/ByteBuffer;Lcoil/request/Options;)V", "fetch", "Lcoil/fetch/FetchResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Factory", "coil-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ByteBufferFetcher implements Fetcher {
    private final ByteBuffer data;
    private final Options options;

    public ByteBufferFetcher(ByteBuffer data, Options options) {
        this.data = data;
        this.options = options;
    }

    @Override // coil.fetch.Fetcher
    public Object fetch(Continuation<? super FetchResult> continuation) {
        try {
            Buffer $this$fetch_u24lambda_u240 = new Buffer();
            $this$fetch_u24lambda_u240.write(this.data);
            return new SourceResult(ImageSources.create($this$fetch_u24lambda_u240, this.options.getContext()), null, DataSource.MEMORY);
        } finally {
            this.data.position(0);
        }
    }

    /* JADX INFO: compiled from: ByteBufferFetcher.kt */
    @Metadata(m194d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, m195d2 = {"Lcoil/fetch/ByteBufferFetcher$Factory;", "Lcoil/fetch/Fetcher$Factory;", "Ljava/nio/ByteBuffer;", "()V", "create", "Lcoil/fetch/Fetcher;", "data", "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "coil-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Factory implements Fetcher.Factory<ByteBuffer> {
        @Override // coil.fetch.Fetcher.Factory
        public Fetcher create(ByteBuffer data, Options options, ImageLoader imageLoader) {
            return new ByteBufferFetcher(data, options);
        }
    }
}
