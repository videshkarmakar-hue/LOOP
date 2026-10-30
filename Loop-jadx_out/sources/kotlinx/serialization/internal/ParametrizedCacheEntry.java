package kotlinx.serialization.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;

/* JADX INFO: compiled from: Caching.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003JK\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\u0014\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u000eH\u0086\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u000f\u0010\u0010R.\u0010\u0004\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0012\n\u0005\b\u009920\u0001\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, m195d2 = {"Lkotlinx/serialization/internal/ParametrizedCacheEntry;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "serializers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlinx/serialization/internal/KTypeWrapper;", "Lkotlin/Result;", "Lkotlinx/serialization/KSerializer;", "computeIfAbsent", "types", "Lkotlin/reflect/KType;", "producer", "Lkotlin/Function0;", "computeIfAbsent-gIAlu-s", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlinx-serialization-core"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class ParametrizedCacheEntry<T> {
    private final ConcurrentHashMap<List<KTypeWrapper>, Result<KSerializer<T>>> serializers = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: computeIfAbsent-gIAlu-s, reason: not valid java name */
    public final Object m9267computeIfAbsentgIAlus(List<? extends KType> types, Function0<? extends KSerializer<T>> producer) {
        Object objM7693constructorimpl;
        Intrinsics.checkNotNullParameter(types, "types");
        Intrinsics.checkNotNullParameter(producer, "producer");
        List<? extends KType> $this$map$iv = types;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KType it = (KType) item$iv$iv;
            destination$iv$iv.add(new KTypeWrapper(it));
        }
        ArrayList arrayList = (List) destination$iv$iv;
        ConcurrentMap $this$getOrPut$iv = this.serializers;
        Object default$iv = $this$getOrPut$iv.get(arrayList);
        if (default$iv == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objM7693constructorimpl = Result.m7693constructorimpl(producer.invoke());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7693constructorimpl = Result.m7693constructorimpl(ResultKt.createFailure(th));
            }
            default$iv = Result.m7692boximpl(objM7693constructorimpl);
            Object objPutIfAbsent = $this$getOrPut$iv.putIfAbsent(arrayList, default$iv);
            if (objPutIfAbsent != null) {
                default$iv = objPutIfAbsent;
            }
        }
        Intrinsics.checkNotNullExpressionValue(default$iv, "getOrPut(...)");
        return ((Result) default$iv).getValue();
    }
}
