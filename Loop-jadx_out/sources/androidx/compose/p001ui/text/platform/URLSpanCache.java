package androidx.compose.p001ui.text.platform;

import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import androidx.collection.LongObjectMap;
import androidx.compose.p001ui.text.AnnotatedString;
import androidx.compose.p001ui.text.LinkAnnotation;
import androidx.compose.p001ui.text.UrlAnnotation;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: URLSpanCache.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J2\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u00132\u0006\u0010\u0016\u001a\u00020\tJ\u0014\u0010\u0017\u001a\u00020\f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005J\u000e\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u000bR,\u0010\u0003\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0005\u0012\u0004\u0012\u00020\f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m195d2 = {"Landroidx/compose/ui/text/platform/URLSpanCache;", "", "()V", "clickableSpansByAnnotation", "Ljava/util/WeakHashMap;", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/LinkAnnotation;", "Lkotlin/Pair;", "Landroidx/compose/ui/text/platform/ComposeClickableSpan;", "", "spansByAnnotation", "Landroidx/compose/ui/text/UrlAnnotation;", "Landroid/text/style/URLSpan;", "urlSpansByAnnotation", "Landroidx/compose/ui/text/LinkAnnotation$Url;", "toClickableSpan", "Landroid/text/style/ClickableSpan;", "linkRange", "linkActions", "Landroidx/collection/LongObjectMap;", "Lkotlin/Function0;", "", "accessibilityNodeId", "toURLSpan", "urlRange", "urlAnnotation", "ui-text_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class URLSpanCache {
    public static final int $stable = 8;
    private final WeakHashMap<UrlAnnotation, URLSpan> spansByAnnotation = new WeakHashMap<>();
    private final WeakHashMap<AnnotatedString.Range<LinkAnnotation.Url>, URLSpan> urlSpansByAnnotation = new WeakHashMap<>();
    private final WeakHashMap<AnnotatedString.Range<LinkAnnotation>, Pair<ComposeClickableSpan, Integer>> clickableSpansByAnnotation = new WeakHashMap<>();

    public final URLSpan toURLSpan(UrlAnnotation urlAnnotation) {
        URLSpan uRLSpan;
        Map $this$getOrPut$iv = this.spansByAnnotation;
        URLSpan uRLSpan2 = $this$getOrPut$iv.get(urlAnnotation);
        if (uRLSpan2 == null) {
            uRLSpan = new URLSpan(urlAnnotation.getUrl());
            $this$getOrPut$iv.put(urlAnnotation, uRLSpan);
        } else {
            uRLSpan = uRLSpan2;
        }
        return uRLSpan;
    }

    public final URLSpan toURLSpan(AnnotatedString.Range<LinkAnnotation.Url> urlRange) {
        URLSpan uRLSpan;
        Map $this$getOrPut$iv = this.urlSpansByAnnotation;
        URLSpan uRLSpan2 = $this$getOrPut$iv.get(urlRange);
        if (uRLSpan2 == null) {
            uRLSpan = new URLSpan(urlRange.getItem().getUrl());
            $this$getOrPut$iv.put(urlRange, uRLSpan);
        } else {
            uRLSpan = uRLSpan2;
        }
        return uRLSpan;
    }

    public final ClickableSpan toClickableSpan(AnnotatedString.Range<LinkAnnotation> linkRange, LongObjectMap<Function0<Unit>> linkActions, int accessibilityNodeId) {
        ComposeClickableSpan newSpan;
        Pair<ComposeClickableSpan, Integer> pair = this.clickableSpansByAnnotation.get(linkRange);
        if (pair == null || pair.getSecond().intValue() != accessibilityNodeId) {
            int val1$iv = linkRange.getStart();
            int val2$iv = linkRange.getEnd();
            Function0<Unit> function0 = linkActions.get((((long) val1$iv) << 32) | (((long) val2$iv) & 4294967295L));
            if (function0 != null) {
                newSpan = new ComposeClickableSpan(function0);
                this.clickableSpansByAnnotation.put(linkRange, new Pair<>(newSpan, Integer.valueOf(accessibilityNodeId)));
            } else {
                newSpan = null;
            }
            return newSpan;
        }
        return pair.getFirst();
    }
}
