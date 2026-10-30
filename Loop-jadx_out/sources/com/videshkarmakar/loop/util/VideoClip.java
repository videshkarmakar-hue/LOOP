package com.videshkarmakar.loop.util;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatingPointRange;

/* JADX INFO: compiled from: VideoInfo.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m194d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005B\u0019\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\r\u001a\u00020\u0007HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, m195d2 = {"Lcom/videshkarmakar/loop/util/VideoClip;", "", "range", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "(Lkotlin/ranges/ClosedFloatingPointRange;)V", "start", "", "end", "(II)V", "getEnd", "()I", "getStart", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class VideoClip {
    public static final int $stable = 0;
    private final int end;
    private final int start;

    /* JADX WARN: Illegal instructions before constructor call */
    public VideoClip() {
        int i = 0;
        this(i, i, 3, null);
    }

    public static /* synthetic */ VideoClip copy$default(VideoClip videoClip, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = videoClip.start;
        }
        if ((i3 & 2) != 0) {
            i2 = videoClip.end;
        }
        return videoClip.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getStart() {
        return this.start;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getEnd() {
        return this.end;
    }

    public final VideoClip copy(int start, int end) {
        return new VideoClip(start, end);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoClip)) {
            return false;
        }
        VideoClip videoClip = (VideoClip) other;
        return this.start == videoClip.start && this.end == videoClip.end;
    }

    public int hashCode() {
        return (this.start * 31) + this.end;
    }

    public String toString() {
        return "VideoClip(start=" + this.start + ", end=" + this.end + ")";
    }

    public VideoClip(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public /* synthetic */ VideoClip(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getStart() {
        return this.start;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoClip(ClosedFloatingPointRange<Float> range) {
        this(MathKt.roundToInt(range.getStart().floatValue()), MathKt.roundToInt(range.getEndInclusive().floatValue()));
        Intrinsics.checkNotNullParameter(range, "range");
    }
}
