package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: SplitPairFilter.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014J\b\u0010\u0019\u001a\u00020\u0006H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, m195d2 = {"Landroidx/window/embedding/SplitPairFilter;", "", "primaryActivityName", "Landroid/content/ComponentName;", "secondaryActivityName", "secondaryActivityIntentAction", "", "(Landroid/content/ComponentName;Landroid/content/ComponentName;Ljava/lang/String;)V", "getPrimaryActivityName", "()Landroid/content/ComponentName;", "getSecondaryActivityIntentAction", "()Ljava/lang/String;", "getSecondaryActivityName", "equals", "", "other", "hashCode", "", "matchesActivityIntentPair", "primaryActivity", "Landroid/app/Activity;", "secondaryActivityIntent", "Landroid/content/Intent;", "matchesActivityPair", "secondaryActivity", "toString", "window_release"}, m196k = 1, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SplitPairFilter {
    private final ComponentName primaryActivityName;

    /* JADX INFO: renamed from: secondaryActivityIntentAction, reason: from kotlin metadata and from toString */
    private final String secondaryActivityAction;
    private final ComponentName secondaryActivityName;

    /* JADX WARN: Code duplicated, block: B:13:0x006e  */
    /* JADX WARN: Code duplicated, block: B:26:0x008f  */
    public SplitPairFilter(ComponentName primaryActivityName, ComponentName secondaryActivityName, String secondaryActivityIntentAction) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(primaryActivityName, "primaryActivityName");
        Intrinsics.checkNotNullParameter(secondaryActivityName, "secondaryActivityName");
        this.primaryActivityName = primaryActivityName;
        this.secondaryActivityName = secondaryActivityName;
        this.secondaryActivityAction = secondaryActivityIntentAction;
        String primaryPackageName = this.primaryActivityName.getPackageName();
        Intrinsics.checkNotNullExpressionValue(primaryPackageName, "primaryActivityName.packageName");
        String primaryClassName = this.primaryActivityName.getClassName();
        Intrinsics.checkNotNullExpressionValue(primaryClassName, "primaryActivityName.className");
        String secondaryPackageName = this.secondaryActivityName.getPackageName();
        Intrinsics.checkNotNullExpressionValue(secondaryPackageName, "secondaryActivityName.packageName");
        String secondaryClassName = this.secondaryActivityName.getClassName();
        Intrinsics.checkNotNullExpressionValue(secondaryClassName, "secondaryActivityName.className");
        if (primaryPackageName.length() == 0) {
            z = false;
        } else {
            if (secondaryPackageName.length() == 0) {
                z = false;
            } else {
                z = true;
            }
        }
        if (!z) {
            throw new IllegalArgumentException("Package name must not be empty".toString());
        }
        if (primaryClassName.length() == 0) {
            z2 = false;
        } else {
            if (secondaryClassName.length() == 0) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        if (!z2) {
            throw new IllegalArgumentException("Activity class name must not be empty.".toString());
        }
        if (!(!StringsKt.contains$default((CharSequence) primaryPackageName, (CharSequence) "*", false, 2, (Object) null) || StringsKt.indexOf$default((CharSequence) primaryPackageName, "*", 0, false, 6, (Object) null) == primaryPackageName.length() - 1)) {
            throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.".toString());
        }
        if (!(!StringsKt.contains$default((CharSequence) primaryClassName, (CharSequence) "*", false, 2, (Object) null) || StringsKt.indexOf$default((CharSequence) primaryClassName, "*", 0, false, 6, (Object) null) == primaryClassName.length() - 1)) {
            throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.".toString());
        }
        if (!(!StringsKt.contains$default((CharSequence) secondaryPackageName, (CharSequence) "*", false, 2, (Object) null) || StringsKt.indexOf$default((CharSequence) secondaryPackageName, "*", 0, false, 6, (Object) null) == secondaryPackageName.length() + (-1))) {
            throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.".toString());
        }
        if (!StringsKt.contains$default((CharSequence) secondaryClassName, (CharSequence) "*", false, 2, (Object) null) || StringsKt.indexOf$default((CharSequence) secondaryClassName, "*", 0, false, 6, (Object) null) == secondaryClassName.length() - 1) {
        } else {
            throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.".toString());
        }
    }

    public final ComponentName getPrimaryActivityName() {
        return this.primaryActivityName;
    }

    public final ComponentName getSecondaryActivityName() {
        return this.secondaryActivityName;
    }

    /* JADX INFO: renamed from: getSecondaryActivityIntentAction, reason: from getter */
    public final String getSecondaryActivityAction() {
        return this.secondaryActivityAction;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0047  */
    public final boolean matchesActivityPair(Activity primaryActivity, Activity secondaryActivity) {
        boolean match;
        Intrinsics.checkNotNullParameter(primaryActivity, "primaryActivity");
        Intrinsics.checkNotNullParameter(secondaryActivity, "secondaryActivity");
        boolean match2 = MatcherUtils.INSTANCE.areComponentsMatching$window_release(primaryActivity.getComponentName(), this.primaryActivityName) && MatcherUtils.INSTANCE.areComponentsMatching$window_release(secondaryActivity.getComponentName(), this.secondaryActivityName);
        if (secondaryActivity.getIntent() != null) {
            if (match2) {
                Intent intent = secondaryActivity.getIntent();
                Intrinsics.checkNotNullExpressionValue(intent, "secondaryActivity.intent");
                match = matchesActivityIntentPair(primaryActivity, intent);
            }
            return match;
        }
        return match2;
    }

    public final boolean matchesActivityIntentPair(Activity primaryActivity, Intent secondaryActivityIntent) {
        Intrinsics.checkNotNullParameter(primaryActivity, "primaryActivity");
        Intrinsics.checkNotNullParameter(secondaryActivityIntent, "secondaryActivityIntent");
        ComponentName inPrimaryActivityName = primaryActivity.getComponentName();
        boolean z = false;
        if (MatcherUtils.INSTANCE.areComponentsMatching$window_release(inPrimaryActivityName, this.primaryActivityName) && MatcherUtils.INSTANCE.areComponentsMatching$window_release(secondaryActivityIntent.getComponent(), this.secondaryActivityName) && (this.secondaryActivityAction == null || Intrinsics.areEqual(this.secondaryActivityAction, secondaryActivityIntent.getAction()))) {
            z = true;
        }
        boolean match = z;
        return match;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SplitPairFilter) && Intrinsics.areEqual(this.primaryActivityName, ((SplitPairFilter) other).primaryActivityName) && Intrinsics.areEqual(this.secondaryActivityName, ((SplitPairFilter) other).secondaryActivityName) && Intrinsics.areEqual(this.secondaryActivityAction, ((SplitPairFilter) other).secondaryActivityAction);
    }

    public int hashCode() {
        int result = this.primaryActivityName.hashCode();
        int result2 = ((result * 31) + this.secondaryActivityName.hashCode()) * 31;
        String str = this.secondaryActivityAction;
        return result2 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SplitPairFilter{primaryActivityName=" + this.primaryActivityName + ", secondaryActivityName=" + this.secondaryActivityName + ", secondaryActivityAction=" + ((Object) this.secondaryActivityAction) + AbstractJsonLexerKt.END_OBJ;
    }
}
