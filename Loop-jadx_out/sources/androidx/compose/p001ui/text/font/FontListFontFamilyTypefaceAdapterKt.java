package androidx.compose.p001ui.text.font;

import androidx.compose.p001ui.text.platform.SynchronizedObject;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FontListFontFamilyTypefaceAdapter.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aR\u0010\u0000\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\fH\u0002¨\u0006\r"}, m195d2 = {"firstImmediatelyAvailable", "Lkotlin/Pair;", "", "Landroidx/compose/ui/text/font/Font;", "", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "createDefaultTypeface", "Lkotlin/Function1;", "ui-text_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FontListFontFamilyTypefaceAdapterKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<List<Font>, Object> firstImmediatelyAvailable(List<? extends Font> list, TypefaceRequest typefaceRequest, AsyncTypefaceCache asyncTypefaceCache, PlatformFontLoader platformFontLoader, Function1<? super TypefaceRequest, ? extends Object> function1) {
        Object result;
        Object it$iv;
        Object objM6327unboximpl;
        int size = list.size();
        List asyncFontsToLoad = null;
        for (int idx = 0; idx < size; idx++) {
            Font font = list.get(idx);
            int loadingStrategy = font.getLoadingStrategy();
            if (!FontLoadingStrategy.m6351equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m6356getBlockingPKNRLFQ())) {
                if (!FontLoadingStrategy.m6351equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m6357getOptionalLocalPKNRLFQ())) {
                    if (!FontLoadingStrategy.m6351equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m6355getAsyncPKNRLFQ())) {
                        throw new IllegalStateException("Unknown font type " + font);
                    }
                    AsyncTypefaceCache.AsyncTypefaceResult cacheResult = asyncTypefaceCache.m6319get1ASDuI8(font, platformFontLoader);
                    if (cacheResult == null) {
                        if (asyncFontsToLoad == null) {
                            asyncFontsToLoad = CollectionsKt.mutableListOf(font);
                        } else {
                            asyncFontsToLoad.add(font);
                        }
                    } else if (!AsyncTypefaceCache.AsyncTypefaceResult.m6325isPermanentFailureimpl(cacheResult.m6327unboximpl()) && cacheResult.m6327unboximpl() != null) {
                        return TuplesKt.m202to(asyncFontsToLoad, FontSynthesis_androidKt.m6385synthesizeTypefaceFxwP2eA(typefaceRequest.m6410getFontSynthesisGVVA2EU(), cacheResult.m6327unboximpl(), font, typefaceRequest.getFontWeight(), typefaceRequest.m6409getFontStyle_LCdwA()));
                    }
                } else {
                    SynchronizedObject lock$iv$iv = asyncTypefaceCache.cacheLock;
                    synchronized (lock$iv$iv) {
                        AsyncTypefaceCache.Key key$iv = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                        AsyncTypefaceCache.AsyncTypefaceResult priorResult$iv = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key$iv);
                        if (priorResult$iv == null) {
                            priorResult$iv = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key$iv);
                        }
                        if (priorResult$iv == null) {
                            Unit unit = Unit.INSTANCE;
                            try {
                                Result.Companion companion = Result.INSTANCE;
                                it$iv = Result.m7693constructorimpl(platformFontLoader.loadBlocking(font));
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.INSTANCE;
                                it$iv = Result.m7693constructorimpl(ResultKt.createFailure(th));
                            }
                            if (Result.m7699isFailureimpl(it$iv)) {
                                it$iv = null;
                            }
                            AsyncTypefaceCache.put$default(asyncTypefaceCache, font, platformFontLoader, it$iv, false, 8, null);
                            objM6327unboximpl = it$iv;
                        } else {
                            objM6327unboximpl = priorResult$iv.m6327unboximpl();
                        }
                    }
                    Object result2 = objM6327unboximpl;
                    if (result2 != null) {
                        return TuplesKt.m202to(asyncFontsToLoad, FontSynthesis_androidKt.m6385synthesizeTypefaceFxwP2eA(typefaceRequest.m6410getFontSynthesisGVVA2EU(), result2, font, typefaceRequest.getFontWeight(), typefaceRequest.m6409getFontStyle_LCdwA()));
                    }
                }
            } else {
                SynchronizedObject lock$iv$iv2 = asyncTypefaceCache.cacheLock;
                synchronized (lock$iv$iv2) {
                    AsyncTypefaceCache.Key key$iv2 = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                    AsyncTypefaceCache.AsyncTypefaceResult priorResult$iv2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key$iv2);
                    if (priorResult$iv2 == null) {
                        priorResult$iv2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key$iv2);
                    }
                    if (priorResult$iv2 == null) {
                        Unit unit2 = Unit.INSTANCE;
                        try {
                            Object it$iv2 = platformFontLoader.loadBlocking(font);
                            AsyncTypefaceCache.put$default(asyncTypefaceCache, font, platformFontLoader, it$iv2, false, 8, null);
                            result = it$iv2;
                        } catch (Exception cause) {
                            throw new IllegalStateException("Unable to load font " + font, cause);
                        }
                    } else {
                        result = priorResult$iv2.m6327unboximpl();
                    }
                }
                if (result == null) {
                    throw new IllegalStateException("Unable to load font " + font);
                }
                return TuplesKt.m202to(asyncFontsToLoad, FontSynthesis_androidKt.m6385synthesizeTypefaceFxwP2eA(typefaceRequest.m6410getFontSynthesisGVVA2EU(), result, font, typefaceRequest.getFontWeight(), typefaceRequest.m6409getFontStyle_LCdwA()));
            }
        }
        Object fallbackTypeface = function1.invoke(typefaceRequest);
        return TuplesKt.m202to(asyncFontsToLoad, fallbackTypeface);
    }
}
