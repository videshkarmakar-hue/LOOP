package androidx.compose.p001ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: AndroidFontLoader.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\n \t*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m195d2 = {"Landroidx/compose/ui/text/font/AndroidFontLoader;", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cacheKey", "", "getCacheKey", "()Ljava/lang/Object;", "kotlin.jvm.PlatformType", "awaitLoad", "Landroid/graphics/Typeface;", "font", "Landroidx/compose/ui/text/font/Font;", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadBlocking", "ui-text_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AndroidFontLoader implements PlatformFontLoader {
    public static final int $stable = 8;
    private final Object cacheKey;
    private final Context context;

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1 */
    /* JADX INFO: compiled from: AndroidFontLoader.android.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.ui.text.font.AndroidFontLoader", m210f = "AndroidFontLoader.android.kt", m211i = {1, 1}, m212l = {57, 58}, m213m = "awaitLoad", m214n = {"this", "font"}, m215s = {"L$0", "L$1"})
    static final class C19241 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C19241(Continuation<? super C19241> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidFontLoader.this.awaitLoad(null, this);
        }
    }

    public AndroidFontLoader(Context context) {
        this.context = context.getApplicationContext();
    }

    @Override // androidx.compose.p001ui.text.font.PlatformFontLoader
    public Typeface loadBlocking(Font font) {
        Object objM7693constructorimpl;
        Typeface typefaceLoad;
        if (font instanceof AndroidFont) {
            return ((AndroidFont) font).getTypefaceLoader().loadBlocking(this.context, (AndroidFont) font);
        }
        if (!(font instanceof ResourceFont)) {
            return null;
        }
        int loadingStrategy = font.getLoadingStrategy();
        if (FontLoadingStrategy.m6351equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m6356getBlockingPKNRLFQ())) {
            typefaceLoad = AndroidFontLoader_androidKt.load((ResourceFont) font, this.context);
        } else if (FontLoadingStrategy.m6351equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m6357getOptionalLocalPKNRLFQ())) {
            try {
                Result.Companion companion = Result.INSTANCE;
                AndroidFontLoader $this$loadBlocking_u24lambda_u240 = this;
                objM7693constructorimpl = Result.m7693constructorimpl(AndroidFontLoader_androidKt.load((ResourceFont) font, $this$loadBlocking_u24lambda_u240.context));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7693constructorimpl = Result.m7693constructorimpl(ResultKt.createFailure(th));
            }
            typefaceLoad = (Typeface) (Result.m7699isFailureimpl(objM7693constructorimpl) ? null : objM7693constructorimpl);
        } else {
            if (FontLoadingStrategy.m6351equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m6355getAsyncPKNRLFQ())) {
                throw new UnsupportedOperationException("Unsupported Async font load path");
            }
            throw new IllegalArgumentException("Unknown loading type " + ((Object) FontLoadingStrategy.m6353toStringimpl(font.getLoadingStrategy())));
        }
        return PlatformTypefaces_androidKt.setFontVariationSettings(typefaceLoad, ((ResourceFont) font).getVariationSettings(), this.context);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.compose.p001ui.text.font.PlatformFontLoader
    public Object awaitLoad(Font font, Continuation<? super Typeface> continuation) {
        C19241 c19241;
        Object objLoadAsync;
        AndroidFontLoader androidFontLoader;
        if (continuation instanceof C19241) {
            c19241 = (C19241) continuation;
            if ((c19241.label & Integer.MIN_VALUE) != 0) {
                c19241.label -= Integer.MIN_VALUE;
            } else {
                c19241 = new C19241(continuation);
            }
        } else {
            c19241 = new C19241(continuation);
        }
        C19241 c19242 = c19241;
        Object $result = c19242.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c19242.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (font instanceof AndroidFont) {
                    c19242.label = 1;
                    Object objAwaitLoad = ((AndroidFont) font).getTypefaceLoader().awaitLoad(this.context, (AndroidFont) font, c19242);
                    return objAwaitLoad == coroutine_suspended ? coroutine_suspended : objAwaitLoad;
                }
                if (!(font instanceof ResourceFont)) {
                    throw new IllegalArgumentException("Unknown font type: " + font);
                }
                Context context = this.context;
                c19242.L$0 = this;
                c19242.L$1 = font;
                c19242.label = 2;
                objLoadAsync = AndroidFontLoader_androidKt.loadAsync((ResourceFont) font, context, c19242);
                if (objLoadAsync == coroutine_suspended) {
                    return coroutine_suspended;
                }
                androidFontLoader = this;
                break;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            case 2:
                font = (Font) c19242.L$1;
                androidFontLoader = (AndroidFontLoader) c19242.L$0;
                ResultKt.throwOnFailure($result);
                objLoadAsync = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return PlatformTypefaces_androidKt.setFontVariationSettings((Typeface) objLoadAsync, ((ResourceFont) font).getVariationSettings(), androidFontLoader.context);
    }

    @Override // androidx.compose.p001ui.text.font.PlatformFontLoader
    public Object getCacheKey() {
        return this.cacheKey;
    }
}
