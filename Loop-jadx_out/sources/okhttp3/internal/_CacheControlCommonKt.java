package okhttp3.internal;

import androidx.compose.p001ui.geometry.InlineClassHelperKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import okhttp3.CacheControl;
import okhttp3.Headers;

/* JADX INFO: compiled from: -CacheControlCommon.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0001*\u00020\u0007H\u0000\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0007H\u0000\u001a\f\u0010\t\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\u001c\u0010\n\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u001c\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u001c\u0010\u0010\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\f\u0010\u0012\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010\u0014\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010\u0015\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\u0014\u0010\u0016\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0000\u001a\f\u0010\u0019\u001a\u00020\u001a*\u00020\u0001H\u0000\u001a\u001e\u0010\u001b\u001a\u00020\u0004*\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u0004H\u0002¨\u0006\u001e"}, m195d2 = {"commonBuild", "Lokhttp3/CacheControl;", "Lokhttp3/CacheControl$Builder;", "commonClampToInt", "", "", "commonForceCache", "Lokhttp3/CacheControl$Companion;", "commonForceNetwork", "commonImmutable", "commonMaxAge", "maxAge", "timeUnit", "Lkotlin/time/DurationUnit;", "commonMaxStale", "maxStale", "commonMinFresh", "minFresh", "commonNoCache", "commonNoStore", "commonNoTransform", "commonOnlyIfCached", "commonParse", "headers", "Lokhttp3/Headers;", "commonToString", "", "indexOfElement", "characters", "startIndex", "okhttp"}, m196k = 2, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class _CacheControlCommonKt {
    public static final String commonToString(CacheControl $this$commonToString) {
        Intrinsics.checkNotNullParameter($this$commonToString, "<this>");
        String result = $this$commonToString.getHeaderValue();
        if (result == null) {
            StringBuilder $this$commonToString_u24lambda_u2d0 = new StringBuilder();
            if ($this$commonToString.noCache()) {
                $this$commonToString_u24lambda_u2d0.append("no-cache, ");
            }
            if ($this$commonToString.noStore()) {
                $this$commonToString_u24lambda_u2d0.append("no-store, ");
            }
            if ($this$commonToString.maxAgeSeconds() != -1) {
                $this$commonToString_u24lambda_u2d0.append("max-age=").append($this$commonToString.maxAgeSeconds()).append(", ");
            }
            if ($this$commonToString.sMaxAgeSeconds() != -1) {
                $this$commonToString_u24lambda_u2d0.append("s-maxage=").append($this$commonToString.sMaxAgeSeconds()).append(", ");
            }
            if ($this$commonToString.getIsPrivate()) {
                $this$commonToString_u24lambda_u2d0.append("private, ");
            }
            if ($this$commonToString.getIsPublic()) {
                $this$commonToString_u24lambda_u2d0.append("public, ");
            }
            if ($this$commonToString.mustRevalidate()) {
                $this$commonToString_u24lambda_u2d0.append("must-revalidate, ");
            }
            if ($this$commonToString.maxStaleSeconds() != -1) {
                $this$commonToString_u24lambda_u2d0.append("max-stale=").append($this$commonToString.maxStaleSeconds()).append(", ");
            }
            if ($this$commonToString.minFreshSeconds() != -1) {
                $this$commonToString_u24lambda_u2d0.append("min-fresh=").append($this$commonToString.minFreshSeconds()).append(", ");
            }
            if ($this$commonToString.onlyIfCached()) {
                $this$commonToString_u24lambda_u2d0.append("only-if-cached, ");
            }
            if ($this$commonToString.noTransform()) {
                $this$commonToString_u24lambda_u2d0.append("no-transform, ");
            }
            if ($this$commonToString.immutable()) {
                $this$commonToString_u24lambda_u2d0.append("immutable, ");
            }
            if ($this$commonToString_u24lambda_u2d0.length() == 0) {
                return "";
            }
            Intrinsics.checkNotNullExpressionValue($this$commonToString_u24lambda_u2d0.delete($this$commonToString_u24lambda_u2d0.length() - 2, $this$commonToString_u24lambda_u2d0.length()), "this.delete(startIndex, endIndex)");
            String result2 = $this$commonToString_u24lambda_u2d0.toString();
            Intrinsics.checkNotNullExpressionValue(result2, "StringBuilder().apply(builderAction).toString()");
            $this$commonToString.setHeaderValue$okhttp(result2);
            return result2;
        }
        return result;
    }

    public static final CacheControl.Builder commonMaxAge(CacheControl.Builder $this$commonMaxAge, int maxAge, DurationUnit timeUnit) {
        Intrinsics.checkNotNullParameter($this$commonMaxAge, "<this>");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        if (!(maxAge >= 0)) {
            throw new IllegalArgumentException(("maxAge < 0: " + maxAge).toString());
        }
        long maxAgeSecondsLong = Duration.m9040getInWholeSecondsimpl(DurationKt.toDuration(maxAge, timeUnit));
        $this$commonMaxAge.setMaxAgeSeconds$okhttp(commonClampToInt(maxAgeSecondsLong));
        return $this$commonMaxAge;
    }

    public static final CacheControl.Builder commonMaxStale(CacheControl.Builder $this$commonMaxStale, int maxStale, DurationUnit timeUnit) {
        Intrinsics.checkNotNullParameter($this$commonMaxStale, "<this>");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        if (!(maxStale >= 0)) {
            throw new IllegalArgumentException(("maxStale < 0: " + maxStale).toString());
        }
        long maxStaleSecondsLong = Duration.m9040getInWholeSecondsimpl(DurationKt.toDuration(maxStale, timeUnit));
        $this$commonMaxStale.setMaxStaleSeconds$okhttp(commonClampToInt(maxStaleSecondsLong));
        return $this$commonMaxStale;
    }

    public static final CacheControl.Builder commonMinFresh(CacheControl.Builder $this$commonMinFresh, int minFresh, DurationUnit timeUnit) {
        Intrinsics.checkNotNullParameter($this$commonMinFresh, "<this>");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        if (!(minFresh >= 0)) {
            throw new IllegalArgumentException(("minFresh < 0: " + minFresh).toString());
        }
        long minFreshSecondsLong = Duration.m9040getInWholeSecondsimpl(DurationKt.toDuration(minFresh, timeUnit));
        $this$commonMinFresh.setMinFreshSeconds$okhttp(commonClampToInt(minFreshSecondsLong));
        return $this$commonMinFresh;
    }

    public static final int commonClampToInt(long $this$commonClampToInt) {
        if ($this$commonClampToInt > InlineClassHelperKt.FloatNonFiniteMask) {
            return Integer.MAX_VALUE;
        }
        return (int) $this$commonClampToInt;
    }

    public static final CacheControl commonForceNetwork(CacheControl.Companion $this$commonForceNetwork) {
        Intrinsics.checkNotNullParameter($this$commonForceNetwork, "<this>");
        return new CacheControl.Builder().noCache().build();
    }

    public static final CacheControl commonForceCache(CacheControl.Companion $this$commonForceCache) {
        Intrinsics.checkNotNullParameter($this$commonForceCache, "<this>");
        return new CacheControl.Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, DurationUnit.SECONDS).build();
    }

    public static final CacheControl commonBuild(CacheControl.Builder $this$commonBuild) {
        Intrinsics.checkNotNullParameter($this$commonBuild, "<this>");
        return new CacheControl($this$commonBuild.getNoCache(), $this$commonBuild.getNoStore(), $this$commonBuild.getMaxAgeSeconds(), -1, false, false, false, $this$commonBuild.getMaxStaleSeconds(), $this$commonBuild.getMinFreshSeconds(), $this$commonBuild.getOnlyIfCached(), $this$commonBuild.getNoTransform(), $this$commonBuild.getImmutable(), null);
    }

    public static final CacheControl.Builder commonNoCache(CacheControl.Builder $this$commonNoCache) {
        Intrinsics.checkNotNullParameter($this$commonNoCache, "<this>");
        $this$commonNoCache.setNoCache$okhttp(true);
        return $this$commonNoCache;
    }

    public static final CacheControl.Builder commonNoStore(CacheControl.Builder $this$commonNoStore) {
        Intrinsics.checkNotNullParameter($this$commonNoStore, "<this>");
        $this$commonNoStore.setNoStore$okhttp(true);
        return $this$commonNoStore;
    }

    public static final CacheControl.Builder commonOnlyIfCached(CacheControl.Builder $this$commonOnlyIfCached) {
        Intrinsics.checkNotNullParameter($this$commonOnlyIfCached, "<this>");
        $this$commonOnlyIfCached.setOnlyIfCached$okhttp(true);
        return $this$commonOnlyIfCached;
    }

    public static final CacheControl.Builder commonNoTransform(CacheControl.Builder $this$commonNoTransform) {
        Intrinsics.checkNotNullParameter($this$commonNoTransform, "<this>");
        $this$commonNoTransform.setNoTransform$okhttp(true);
        return $this$commonNoTransform;
    }

    public static final CacheControl.Builder commonImmutable(CacheControl.Builder $this$commonImmutable) {
        Intrinsics.checkNotNullParameter($this$commonImmutable, "<this>");
        $this$commonImmutable.setImmutable$okhttp(true);
        return $this$commonImmutable;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:101:0x01e7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:102:0x01da A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x00fa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x010d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x00ed A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x0102 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x0123 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x0116 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x013b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x012c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x014f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x0143 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x0163 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x0157 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x0177 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x016b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x0191 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x017f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x01a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x0199 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:0x01bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x01b1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x01d2 A[SYNTHETIC] */
    public static final CacheControl commonParse(CacheControl.Companion $this$commonParse, Headers headers) {
        int sMaxAgeSeconds;
        String parameter;
        Headers headers2 = headers;
        Intrinsics.checkNotNullParameter($this$commonParse, "<this>");
        Intrinsics.checkNotNullParameter(headers2, "headers");
        boolean noStore = false;
        int maxAgeSeconds = -1;
        int sMaxAgeSeconds2 = -1;
        boolean isPrivate = false;
        boolean isPublic = false;
        boolean mustRevalidate = false;
        int maxStaleSeconds = -1;
        int minFreshSeconds = -1;
        boolean onlyIfCached = false;
        boolean noTransform = false;
        boolean immutable = false;
        boolean canUseHeaderValue = true;
        String headerValue = null;
        boolean noCache = false;
        int size = headers.size();
        int i = 0;
        while (i < size) {
            int i2 = size;
            String name = headers2.name(i);
            boolean immutable2 = immutable;
            String value = headers2.value(i);
            boolean noTransform2 = noTransform;
            if (StringsKt.equals(name, "Cache-Control", true)) {
                if (headerValue != null) {
                    canUseHeaderValue = false;
                } else {
                    headerValue = value;
                }
            } else {
                if (StringsKt.equals(name, "Pragma", true)) {
                    canUseHeaderValue = false;
                }
                immutable = immutable2;
                noTransform = noTransform2;
                i++;
                headers2 = headers;
                size = i2;
            }
            int pos = 0;
            while (pos < value.length()) {
                int tokenStart = pos;
                name = name;
                int pos2 = indexOfElement(value, "=,;", pos);
                String strSubstring = value.substring(tokenStart, pos2);
                boolean noStore2 = noStore;
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                String directive = StringsKt.trim((CharSequence) strSubstring).toString();
                int maxAgeSeconds2 = maxAgeSeconds;
                int maxAgeSeconds3 = value.length();
                if (pos2 == maxAgeSeconds3) {
                    sMaxAgeSeconds = sMaxAgeSeconds2;
                } else {
                    sMaxAgeSeconds = sMaxAgeSeconds2;
                    if (value.charAt(pos2) != ',' && value.charAt(pos2) != ';') {
                        int pos3 = _UtilCommonKt.indexOfNonWhitespace(value, pos2 + 1);
                        if (pos3 < value.length() && value.charAt(pos3) == '\"') {
                            int pos4 = pos3 + 1;
                            int pos5 = StringsKt.indexOf$default((CharSequence) value, '\"', pos4, false, 4, (Object) null);
                            String strSubstring2 = value.substring(pos4, pos5);
                            Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                            parameter = strSubstring2;
                            pos = pos5 + 1;
                        } else {
                            pos = indexOfElement(value, ",;", pos3);
                            String strSubstring3 = value.substring(pos3, pos);
                            Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                            parameter = StringsKt.trim((CharSequence) strSubstring3).toString();
                        }
                    }
                    if (StringsKt.equals("no-cache", directive, true)) {
                        noCache = true;
                        noStore = noStore2;
                        maxAgeSeconds = maxAgeSeconds2;
                        sMaxAgeSeconds2 = sMaxAgeSeconds;
                    } else if (StringsKt.equals("no-store", directive, true)) {
                        noStore = true;
                        maxAgeSeconds = maxAgeSeconds2;
                        sMaxAgeSeconds2 = sMaxAgeSeconds;
                    } else if (StringsKt.equals("max-age", directive, true)) {
                        maxAgeSeconds = _UtilCommonKt.toNonNegativeInt(parameter, -1);
                        noStore = noStore2;
                        sMaxAgeSeconds2 = sMaxAgeSeconds;
                    } else if (StringsKt.equals("s-maxage", directive, true)) {
                        sMaxAgeSeconds2 = _UtilCommonKt.toNonNegativeInt(parameter, -1);
                        noStore = noStore2;
                        maxAgeSeconds = maxAgeSeconds2;
                    } else if (StringsKt.equals("private", directive, true)) {
                        isPrivate = true;
                        noStore = noStore2;
                        maxAgeSeconds = maxAgeSeconds2;
                        sMaxAgeSeconds2 = sMaxAgeSeconds;
                    } else if (StringsKt.equals("public", directive, true)) {
                        isPublic = true;
                        noStore = noStore2;
                        maxAgeSeconds = maxAgeSeconds2;
                        sMaxAgeSeconds2 = sMaxAgeSeconds;
                    } else if (StringsKt.equals("must-revalidate", directive, true)) {
                        mustRevalidate = true;
                        noStore = noStore2;
                        maxAgeSeconds = maxAgeSeconds2;
                        sMaxAgeSeconds2 = sMaxAgeSeconds;
                    } else if (StringsKt.equals("max-stale", directive, true)) {
                        maxStaleSeconds = _UtilCommonKt.toNonNegativeInt(parameter, Integer.MAX_VALUE);
                        noStore = noStore2;
                        maxAgeSeconds = maxAgeSeconds2;
                        sMaxAgeSeconds2 = sMaxAgeSeconds;
                    } else if (StringsKt.equals("min-fresh", directive, true)) {
                        minFreshSeconds = _UtilCommonKt.toNonNegativeInt(parameter, -1);
                        noStore = noStore2;
                        maxAgeSeconds = maxAgeSeconds2;
                        sMaxAgeSeconds2 = sMaxAgeSeconds;
                    } else if (StringsKt.equals("only-if-cached", directive, true)) {
                        onlyIfCached = true;
                        noStore = noStore2;
                        maxAgeSeconds = maxAgeSeconds2;
                        sMaxAgeSeconds2 = sMaxAgeSeconds;
                    } else if (StringsKt.equals("no-transform", directive, true)) {
                        noTransform2 = true;
                        noStore = noStore2;
                        maxAgeSeconds = maxAgeSeconds2;
                        sMaxAgeSeconds2 = sMaxAgeSeconds;
                    } else if (StringsKt.equals("immutable", directive, true)) {
                        immutable2 = true;
                        noStore = noStore2;
                        maxAgeSeconds = maxAgeSeconds2;
                        sMaxAgeSeconds2 = sMaxAgeSeconds;
                    } else {
                        noStore = noStore2;
                        maxAgeSeconds = maxAgeSeconds2;
                        sMaxAgeSeconds2 = sMaxAgeSeconds;
                    }
                }
                pos = pos2 + 1;
                parameter = null;
                if (StringsKt.equals("no-cache", directive, true)) {
                    noCache = true;
                    noStore = noStore2;
                    maxAgeSeconds = maxAgeSeconds2;
                    sMaxAgeSeconds2 = sMaxAgeSeconds;
                } else if (StringsKt.equals("no-store", directive, true)) {
                    noStore = true;
                    maxAgeSeconds = maxAgeSeconds2;
                    sMaxAgeSeconds2 = sMaxAgeSeconds;
                } else if (StringsKt.equals("max-age", directive, true)) {
                    maxAgeSeconds = _UtilCommonKt.toNonNegativeInt(parameter, -1);
                    noStore = noStore2;
                    sMaxAgeSeconds2 = sMaxAgeSeconds;
                } else if (StringsKt.equals("s-maxage", directive, true)) {
                    sMaxAgeSeconds2 = _UtilCommonKt.toNonNegativeInt(parameter, -1);
                    noStore = noStore2;
                    maxAgeSeconds = maxAgeSeconds2;
                } else if (StringsKt.equals("private", directive, true)) {
                    isPrivate = true;
                    noStore = noStore2;
                    maxAgeSeconds = maxAgeSeconds2;
                    sMaxAgeSeconds2 = sMaxAgeSeconds;
                } else if (StringsKt.equals("public", directive, true)) {
                    isPublic = true;
                    noStore = noStore2;
                    maxAgeSeconds = maxAgeSeconds2;
                    sMaxAgeSeconds2 = sMaxAgeSeconds;
                } else if (StringsKt.equals("must-revalidate", directive, true)) {
                    mustRevalidate = true;
                    noStore = noStore2;
                    maxAgeSeconds = maxAgeSeconds2;
                    sMaxAgeSeconds2 = sMaxAgeSeconds;
                } else if (StringsKt.equals("max-stale", directive, true)) {
                    maxStaleSeconds = _UtilCommonKt.toNonNegativeInt(parameter, Integer.MAX_VALUE);
                    noStore = noStore2;
                    maxAgeSeconds = maxAgeSeconds2;
                    sMaxAgeSeconds2 = sMaxAgeSeconds;
                } else if (StringsKt.equals("min-fresh", directive, true)) {
                    minFreshSeconds = _UtilCommonKt.toNonNegativeInt(parameter, -1);
                    noStore = noStore2;
                    maxAgeSeconds = maxAgeSeconds2;
                    sMaxAgeSeconds2 = sMaxAgeSeconds;
                } else if (StringsKt.equals("only-if-cached", directive, true)) {
                    onlyIfCached = true;
                    noStore = noStore2;
                    maxAgeSeconds = maxAgeSeconds2;
                    sMaxAgeSeconds2 = sMaxAgeSeconds;
                } else if (StringsKt.equals("no-transform", directive, true)) {
                    noTransform2 = true;
                    noStore = noStore2;
                    maxAgeSeconds = maxAgeSeconds2;
                    sMaxAgeSeconds2 = sMaxAgeSeconds;
                } else if (StringsKt.equals("immutable", directive, true)) {
                    immutable2 = true;
                    noStore = noStore2;
                    maxAgeSeconds = maxAgeSeconds2;
                    sMaxAgeSeconds2 = sMaxAgeSeconds;
                } else {
                    noStore = noStore2;
                    maxAgeSeconds = maxAgeSeconds2;
                    sMaxAgeSeconds2 = sMaxAgeSeconds;
                }
            }
            immutable = immutable2;
            noTransform = noTransform2;
            i++;
            headers2 = headers;
            size = i2;
        }
        boolean noTransform3 = noTransform;
        boolean immutable3 = immutable;
        if (!canUseHeaderValue) {
            headerValue = null;
        }
        return new CacheControl(noCache, noStore, maxAgeSeconds, sMaxAgeSeconds2, isPrivate, isPublic, mustRevalidate, maxStaleSeconds, minFreshSeconds, onlyIfCached, noTransform3, immutable3, headerValue);
    }

    static /* synthetic */ int indexOfElement$default(String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return indexOfElement(str, str2, i);
    }

    private static final int indexOfElement(String $this$indexOfElement, String characters, int startIndex) {
        int length = $this$indexOfElement.length();
        for (int i = startIndex; i < length; i++) {
            if (StringsKt.contains$default((CharSequence) characters, $this$indexOfElement.charAt(i), false, 2, (Object) null)) {
                return i;
            }
        }
        int i2 = $this$indexOfElement.length();
        return i2;
    }
}
