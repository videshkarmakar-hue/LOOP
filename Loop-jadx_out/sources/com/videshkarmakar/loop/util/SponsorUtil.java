package com.videshkarmakar.loop.util;

import android.util.Base64;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: SponsorUtil.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m194d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, m195d2 = {"Lcom/videshkarmakar/loop/util/SponsorUtil;", "", "()V", "MAGIC_STRING_0", "", "MAGIC_STRING_1", "MAGIC_STRING_2", "TAG", "body", "Lokhttp3/RequestBody;", "client", "Lokhttp3/OkHttpClient;", "jsonFormat", "Lkotlinx/serialization/json/Json;", "magicString", "request", "Lokhttp3/Request;", "sponsorData", "Lcom/videshkarmakar/loop/util/SponsorData;", "getSponsors", "Lkotlin/Result;", "getSponsors-d1pmJ48", "()Ljava/lang/Object;", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SponsorUtil {
    public static final int $stable;
    public static final SponsorUtil INSTANCE = new SponsorUtil();
    private static final String MAGIC_STRING_0 = "Z2hwX1Rzb2";
    private static final String MAGIC_STRING_1 = "JNU2xHNDZzNlVZNlBE";
    private static final String MAGIC_STRING_2 = "TXowRWJIYlVYNGNEZTJvaE5Ncg";
    private static final String TAG = "SponsorUtil";
    private static final RequestBody body;
    private static final OkHttpClient client;
    private static final Json jsonFormat;
    private static final String magicString;
    private static final Request request;
    private static SponsorData sponsorData;

    private SponsorUtil() {
    }

    static {
        byte[] bArrDecode = Base64.decode("Z2hwX1Rzb2JNU2xHNDZzNlVZNlBETXowRWJIYlVYNGNEZTJvaE5Ncg", 0);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
        magicString = new String(bArrDecode, Charsets.UTF_8);
        body = RequestBody.INSTANCE.create("\n{ \"query\": \"query { viewer { sponsorshipsAsMaintainer(first: 100) { nodes { sponsorEntity { ... on User { login name websiteUrl socialAccounts(first: 4) { nodes { displayName url } } } ... on Organization { login name websiteUrl } } tier { monthlyPriceInDollars } } } } }\" }\n", MediaType.INSTANCE.get("application/json"));
        request = new Request.Builder().url("https://api.github.com/graphql").post(body).addHeader("Authorization", "bearer " + magicString).build();
        client = new OkHttpClient();
        jsonFormat = JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: com.videshkarmakar.loop.util.SponsorUtil$jsonFormat$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
                invoke2(jsonBuilder);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JsonBuilder Json) {
                Intrinsics.checkNotNullParameter(Json, "$this$Json");
                Json.setIgnoreUnknownKeys(true);
            }
        }, 1, null);
        $stable = 8;
    }

    /* JADX INFO: renamed from: getSponsors-d1pmJ48, reason: not valid java name */
    public final Object m7680getSponsorsd1pmJ48() {
        Object objM7693constructorimpl;
        OkHttpClient $this$getSponsors_d1pmJ48_u24lambda_u242 = client;
        try {
            Result.Companion companion = Result.INSTANCE;
            SponsorData sponsorData2 = sponsorData;
            if (sponsorData2 == null) {
                Json this_$iv = jsonFormat;
                String string$iv = $this$getSponsors_d1pmJ48_u24lambda_u242.newCall(request).execute().body().string();
                Log.d(TAG, string$iv);
                this_$iv.getSerializersModule();
                Object objDecodeFromString = this_$iv.decodeFromString(SponsorData.INSTANCE.serializer(), string$iv);
                SponsorData $this$getSponsors_d1pmJ48_u24lambda_u242_u24lambda_u241 = (SponsorData) objDecodeFromString;
                sponsorData = $this$getSponsors_d1pmJ48_u24lambda_u242_u24lambda_u241;
                sponsorData2 = (SponsorData) objDecodeFromString;
            }
            objM7693constructorimpl = Result.m7693constructorimpl(sponsorData2);
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
}
