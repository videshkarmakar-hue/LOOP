package androidx.compose.material3.windowsizeclass;

import androidx.compose.p001ui.unit.C1979Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WindowSizeClass.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0000H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, m195d2 = {"Landroidx/compose/material3/windowsizeclass/WindowHeightSizeClass;", "", DownloadUtil.CookieScheme.VALUE, "", "constructor-impl", "(I)I", "compareTo", "other", "compareTo-pav6bQQ", "(II)I", "equals", "", "", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "material3-window-size-class_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmInline
public final class WindowHeightSizeClass implements Comparable<WindowHeightSizeClass> {
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Compact = m3718constructorimpl(0);
    private static final int Medium = m3718constructorimpl(1);
    private static final int Expanded = m3718constructorimpl(2);
    private static final Set<WindowHeightSizeClass> DefaultSizeClasses = SetsKt.setOf((Object[]) new WindowHeightSizeClass[]{m3716boximpl(Compact), m3716boximpl(Medium), m3716boximpl(Expanded)});
    private static final List<WindowHeightSizeClass> AllSizeClassList = CollectionsKt.listOf((Object[]) new WindowHeightSizeClass[]{m3716boximpl(Expanded), m3716boximpl(Medium), m3716boximpl(Compact)});
    private static final Set<WindowHeightSizeClass> AllSizeClasses = CollectionsKt.toSet(AllSizeClassList);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ WindowHeightSizeClass m3716boximpl(int i) {
        return new WindowHeightSizeClass(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m3718constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3719equalsimpl(int i, Object obj) {
        return (obj instanceof WindowHeightSizeClass) && i == ((WindowHeightSizeClass) obj).getValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3720equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3721hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m3719equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3721hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(WindowHeightSizeClass windowHeightSizeClass) {
        return m3723compareTopav6bQQ(windowHeightSizeClass.getValue());
    }

    private /* synthetic */ WindowHeightSizeClass(int value) {
        this.value = value;
    }

    /* JADX INFO: renamed from: compareTo-pav6bQQ, reason: not valid java name */
    public int m3723compareTopav6bQQ(int other) {
        return m3717compareTopav6bQQ(this.value, other);
    }

    /* JADX INFO: renamed from: compareTo-pav6bQQ, reason: not valid java name */
    public static int m3717compareTopav6bQQ(int arg0, int other) {
        return C1979Dp.m6800compareTo0680j_4(INSTANCE.m3726breakpointsr04XMo(arg0), INSTANCE.m3726breakpointsr04XMo(other));
    }

    public String toString() {
        return m3722toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3722toStringimpl(int arg0) {
        String str;
        StringBuilder sbAppend = new StringBuilder().append("WindowHeightSizeClass.");
        if (m3720equalsimpl0(arg0, Compact)) {
            str = "Compact";
        } else if (m3720equalsimpl0(arg0, Medium)) {
            str = "Medium";
        } else {
            str = m3720equalsimpl0(arg0, Expanded) ? "Expanded" : "";
        }
        return sbAppend.append(str).toString();
    }

    /* JADX INFO: compiled from: WindowSizeClass.kt */
    @Metadata(m194d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u0019*\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\u000bR\u0019\u0010\u0013\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\u000eR\u0019\u0010\u0015\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0016\u0010\u000e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, m195d2 = {"Landroidx/compose/material3/windowsizeclass/WindowHeightSizeClass$Companion;", "", "()V", "AllSizeClassList", "", "Landroidx/compose/material3/windowsizeclass/WindowHeightSizeClass;", "getAllSizeClassList$annotations", "AllSizeClasses", "", "getAllSizeClasses$annotations", "getAllSizeClasses", "()Ljava/util/Set;", "Compact", "getCompact-Pt018CI", "()I", "I", "DefaultSizeClasses", "getDefaultSizeClasses$annotations", "getDefaultSizeClasses", "Expanded", "getExpanded-Pt018CI", "Medium", "getMedium-Pt018CI", "fromHeight", "height", "Landroidx/compose/ui/unit/Dp;", "supportedSizeClasses", "fromHeight-BkRwncw$material3_window_size_class_release", "(FLjava/util/Set;)I", "breakpoint", "breakpoint-sr04XMo", "(I)F", "material3-window-size-class_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private static /* synthetic */ void getAllSizeClassList$annotations() {
        }

        public static /* synthetic */ void getAllSizeClasses$annotations() {
        }

        public static /* synthetic */ void getDefaultSizeClasses$annotations() {
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getCompact-Pt018CI, reason: not valid java name */
        public final int m3728getCompactPt018CI() {
            return WindowHeightSizeClass.Compact;
        }

        /* JADX INFO: renamed from: getMedium-Pt018CI, reason: not valid java name */
        public final int m3730getMediumPt018CI() {
            return WindowHeightSizeClass.Medium;
        }

        /* JADX INFO: renamed from: getExpanded-Pt018CI, reason: not valid java name */
        public final int m3729getExpandedPt018CI() {
            return WindowHeightSizeClass.Expanded;
        }

        public final Set<WindowHeightSizeClass> getDefaultSizeClasses() {
            return WindowHeightSizeClass.DefaultSizeClasses;
        }

        public final Set<WindowHeightSizeClass> getAllSizeClasses() {
            return WindowHeightSizeClass.AllSizeClasses;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: breakpoint-sr04XMo, reason: not valid java name */
        public final float m3726breakpointsr04XMo(int $this$breakpoint_u2dsr04XMo) {
            if (!WindowHeightSizeClass.m3720equalsimpl0($this$breakpoint_u2dsr04XMo, m3729getExpandedPt018CI())) {
                if (WindowHeightSizeClass.m3720equalsimpl0($this$breakpoint_u2dsr04XMo, m3730getMediumPt018CI())) {
                    return C1979Dp.m6801constructorimpl(480);
                }
                return C1979Dp.m6801constructorimpl(0);
            }
            return C1979Dp.m6801constructorimpl(900);
        }

        /* JADX INFO: renamed from: fromHeight-BkRwncw$material3_window_size_class_release, reason: not valid java name */
        public final int m3727fromHeightBkRwncw$material3_window_size_class_release(float height, Set<WindowHeightSizeClass> supportedSizeClasses) {
            int $this$dp$iv = C1979Dp.m6800compareTo0680j_4(height, C1979Dp.m6801constructorimpl(0));
            if (!($this$dp$iv >= 0)) {
                throw new IllegalArgumentException("Width must not be negative".toString());
            }
            if (!(!supportedSizeClasses.isEmpty())) {
                throw new IllegalArgumentException("Must support at least one size class".toString());
            }
            int smallestSupportedSizeClass = m3729getExpandedPt018CI();
            List $this$fastForEach$iv = WindowHeightSizeClass.AllSizeClassList;
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                Object item$iv = $this$fastForEach$iv.get(index$iv);
                int it = ((WindowHeightSizeClass) item$iv).getValue();
                if (supportedSizeClasses.contains(WindowHeightSizeClass.m3716boximpl(it))) {
                    if (C1979Dp.m6800compareTo0680j_4(height, WindowHeightSizeClass.INSTANCE.m3726breakpointsr04XMo(it)) >= 0) {
                        return it;
                    }
                    smallestSupportedSizeClass = it;
                }
            }
            return smallestSupportedSizeClass;
        }
    }
}
