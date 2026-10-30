package androidx.compose.p001ui.text.font;

import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FontFamilyResolver.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0017J:\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\b \u0010!J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u00192\u0006\u0010\"\u001a\u00020\u000fH\u0002R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, m195d2 = {"Landroidx/compose/ui/text/font/FontFamilyResolverImpl;", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "platformResolveInterceptor", "Landroidx/compose/ui/text/font/PlatformResolveInterceptor;", "typefaceRequestCache", "Landroidx/compose/ui/text/font/TypefaceRequestCache;", "fontListFontFamilyTypefaceAdapter", "Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter;", "platformFamilyTypefaceAdapter", "Landroidx/compose/ui/text/font/PlatformFontFamilyTypefaceAdapter;", "(Landroidx/compose/ui/text/font/PlatformFontLoader;Landroidx/compose/ui/text/font/PlatformResolveInterceptor;Landroidx/compose/ui/text/font/TypefaceRequestCache;Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter;Landroidx/compose/ui/text/font/PlatformFontFamilyTypefaceAdapter;)V", "createDefaultTypeface", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceRequest;", "", "getPlatformFontLoader$ui_text_release", "()Landroidx/compose/ui/text/font/PlatformFontLoader;", "preload", "", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "(Landroidx/compose/ui/text/font/FontFamily;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolve", "Landroidx/compose/runtime/State;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "resolve-DPcqOEQ", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;II)Landroidx/compose/runtime/State;", "typefaceRequest", "ui-text_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FontFamilyResolverImpl implements FontFamily.Resolver {
    public static final int $stable = 8;
    private final Function1<TypefaceRequest, Object> createDefaultTypeface;
    private final FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter;
    private final PlatformFontFamilyTypefaceAdapter platformFamilyTypefaceAdapter;
    private final PlatformFontLoader platformFontLoader;
    private final PlatformResolveInterceptor platformResolveInterceptor;
    private final TypefaceRequestCache typefaceRequestCache;

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1 */
    /* JADX INFO: compiled from: FontFamilyResolver.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.ui.text.font.FontFamilyResolverImpl", m210f = "FontFamilyResolver.kt", m211i = {0, 0}, m212l = {45}, m213m = "preload", m214n = {"this", "fontFamily"}, m215s = {"L$0", "L$1"})
    static final class C19271 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C19271(Continuation<? super C19271> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FontFamilyResolverImpl.this.preload(null, this);
        }
    }

    public FontFamilyResolverImpl(PlatformFontLoader platformFontLoader, PlatformResolveInterceptor platformResolveInterceptor, TypefaceRequestCache typefaceRequestCache, FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, PlatformFontFamilyTypefaceAdapter platformFamilyTypefaceAdapter) {
        this.platformFontLoader = platformFontLoader;
        this.platformResolveInterceptor = platformResolveInterceptor;
        this.typefaceRequestCache = typefaceRequestCache;
        this.fontListFontFamilyTypefaceAdapter = fontListFontFamilyTypefaceAdapter;
        this.platformFamilyTypefaceAdapter = platformFamilyTypefaceAdapter;
        this.createDefaultTypeface = new Function1<TypefaceRequest, Object>() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl$createDefaultTypeface$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(TypefaceRequest it) {
                return this.this$0.resolve(TypefaceRequest.m6405copye1PVR60$default(it, null, null, 0, 0, null, 30, null)).getValue();
            }
        };
    }

    public /* synthetic */ FontFamilyResolverImpl(PlatformFontLoader platformFontLoader, PlatformResolveInterceptor platformResolveInterceptor, TypefaceRequestCache typefaceRequestCache, FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, PlatformFontFamilyTypefaceAdapter platformFontFamilyTypefaceAdapter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(platformFontLoader, (i & 2) != 0 ? PlatformResolveInterceptor.INSTANCE.getDefault$ui_text_release() : platformResolveInterceptor, (i & 4) != 0 ? FontFamilyResolverKt.getGlobalTypefaceRequestCache() : typefaceRequestCache, (i & 8) != 0 ? new FontListFontFamilyTypefaceAdapter(FontFamilyResolverKt.getGlobalAsyncTypefaceCache(), null, 2, null) : fontListFontFamilyTypefaceAdapter, (i & 16) != 0 ? new PlatformFontFamilyTypefaceAdapter() : platformFontFamilyTypefaceAdapter);
    }

    /* JADX INFO: renamed from: getPlatformFontLoader$ui_text_release, reason: from getter */
    public final PlatformFontLoader getPlatformFontLoader() {
        return this.platformFontLoader;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    @Override // androidx.compose.ui.text.font.FontFamily.Resolver
    public Object preload(FontFamily fontFamily, Continuation<? super Unit> continuation) {
        C19271 c19271;
        FontFamilyResolverImpl fontFamilyResolverImpl;
        FontFamily fontFamily2;
        if (continuation instanceof C19271) {
            C19271 c19272 = (C19271) continuation;
            if ((c19272.label & Integer.MIN_VALUE) != 0) {
                c19272.label -= Integer.MIN_VALUE;
                c19271 = c19272;
            } else {
                c19271 = new C19271(continuation);
            }
        } else {
            c19271 = new C19271(continuation);
        }
        Object $result = c19271.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c19271.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                fontFamilyResolverImpl = this;
                if (!(fontFamily instanceof FontListFontFamily)) {
                    return Unit.INSTANCE;
                }
                FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter = fontFamilyResolverImpl.fontListFontFamilyTypefaceAdapter;
                PlatformFontLoader platformFontLoader = fontFamilyResolverImpl.platformFontLoader;
                c19271.L$0 = fontFamilyResolverImpl;
                c19271.L$1 = fontFamily;
                c19271.label = 1;
                if (fontListFontFamilyTypefaceAdapter.preload(fontFamily, platformFontLoader, c19271) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                fontFamily2 = fontFamily;
                break;
                break;
            case 1:
                fontFamily2 = (FontFamily) c19271.L$1;
                fontFamilyResolverImpl = (FontFamilyResolverImpl) c19271.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List<Font> fonts = ((FontListFontFamily) fontFamily2).getFonts();
        List target$iv = new ArrayList(fonts.size());
        int index$iv$iv = 0;
        int size = fonts.size();
        while (index$iv$iv < size) {
            Object item$iv$iv = fonts.get(index$iv$iv);
            Font it = (Font) item$iv$iv;
            target$iv.add(new TypefaceRequest(fontFamilyResolverImpl.platformResolveInterceptor.interceptFontFamily(fontFamily2), fontFamilyResolverImpl.platformResolveInterceptor.interceptFontWeight(it.getWeight()), fontFamilyResolverImpl.platformResolveInterceptor.mo6315interceptFontStyleT2F_aPo(it.getStyle()), FontSynthesis.INSTANCE.m6381getAllGVVA2EU(), fontFamilyResolverImpl.platformFontLoader.getCacheKey(), null));
            index$iv$iv++;
            c19271 = c19271;
            $result = $result;
        }
        List typeRequests = target$iv;
        fontFamilyResolverImpl.typefaceRequestCache.preWarmCache(typeRequests, new Function1<TypefaceRequest, TypefaceResult>() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl.preload.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final TypefaceResult invoke(TypefaceRequest typeRequest) {
                TypefaceResult typefaceResultResolve = FontFamilyResolverImpl.this.fontListFontFamilyTypefaceAdapter.resolve(typeRequest, FontFamilyResolverImpl.this.getPlatformFontLoader(), new Function1<TypefaceResult.Immutable, Unit>() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl.preload.2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TypefaceResult.Immutable immutable) {
                        invoke2(immutable);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TypefaceResult.Immutable it2) {
                    }
                }, FontFamilyResolverImpl.this.createDefaultTypeface);
                if (typefaceResultResolve == null && (typefaceResultResolve = FontFamilyResolverImpl.this.platformFamilyTypefaceAdapter.resolve(typeRequest, FontFamilyResolverImpl.this.getPlatformFontLoader(), new Function1<TypefaceResult.Immutable, Unit>() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl.preload.2.2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TypefaceResult.Immutable immutable) {
                        invoke2(immutable);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TypefaceResult.Immutable it2) {
                    }
                }, FontFamilyResolverImpl.this.createDefaultTypeface)) == null) {
                    throw new IllegalStateException("Could not load font");
                }
                return typefaceResultResolve;
            }
        });
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.text.font.FontFamily.Resolver
    /* JADX INFO: renamed from: resolve-DPcqOEQ */
    public State<Object> mo6338resolveDPcqOEQ(FontFamily fontFamily, FontWeight fontWeight, int fontStyle, int fontSynthesis) {
        return resolve(new TypefaceRequest(this.platformResolveInterceptor.interceptFontFamily(fontFamily), this.platformResolveInterceptor.interceptFontWeight(fontWeight), this.platformResolveInterceptor.mo6315interceptFontStyleT2F_aPo(fontStyle), this.platformResolveInterceptor.mo6316interceptFontSynthesisMscr08Y(fontSynthesis), this.platformFontLoader.getCacheKey(), null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final State<Object> resolve(final TypefaceRequest typefaceRequest) {
        return this.typefaceRequestCache.runCached(typefaceRequest, new Function1<Function1<? super TypefaceResult, ? extends Unit>, TypefaceResult>() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl$resolve$result$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ TypefaceResult invoke(Function1<? super TypefaceResult, ? extends Unit> function1) {
                return invoke2((Function1<? super TypefaceResult, Unit>) function1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final TypefaceResult invoke2(Function1<? super TypefaceResult, Unit> function1) {
                TypefaceResult typefaceResultResolve = this.this$0.fontListFontFamilyTypefaceAdapter.resolve(typefaceRequest, this.this$0.getPlatformFontLoader(), function1, this.this$0.createDefaultTypeface);
                if (typefaceResultResolve == null && (typefaceResultResolve = this.this$0.platformFamilyTypefaceAdapter.resolve(typefaceRequest, this.this$0.getPlatformFontLoader(), function1, this.this$0.createDefaultTypeface)) == null) {
                    throw new IllegalStateException("Could not load font");
                }
                return typefaceResultResolve;
            }
        });
    }
}
