package okhttp3.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Challenge;

/* JADX INFO: compiled from: -ChallengeCommon.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\u0002¨\u0006\t"}, m195d2 = {"commonEquals", "", "Lokhttp3/Challenge;", "other", "", "commonHashCode", "", "commonToString", "", "okhttp"}, m196k = 2, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class _ChallengeCommonKt {
    public static final boolean commonEquals(Challenge $this$commonEquals, Object other) {
        Intrinsics.checkNotNullParameter($this$commonEquals, "<this>");
        return (other instanceof Challenge) && Intrinsics.areEqual(((Challenge) other).scheme(), $this$commonEquals.scheme()) && Intrinsics.areEqual(((Challenge) other).authParams(), $this$commonEquals.authParams());
    }

    public static final int commonHashCode(Challenge $this$commonHashCode) {
        Intrinsics.checkNotNullParameter($this$commonHashCode, "<this>");
        int result = (29 * 31) + $this$commonHashCode.scheme().hashCode();
        return (result * 31) + $this$commonHashCode.authParams().hashCode();
    }

    public static final String commonToString(Challenge $this$commonToString) {
        Intrinsics.checkNotNullParameter($this$commonToString, "<this>");
        return $this$commonToString.scheme() + " authParams=" + $this$commonToString.authParams();
    }
}
