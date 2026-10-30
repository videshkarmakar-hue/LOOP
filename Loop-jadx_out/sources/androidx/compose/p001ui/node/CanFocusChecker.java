package androidx.compose.p001ui.node;

import androidx.compose.p001ui.focus.FocusDirection;
import androidx.compose.p001ui.focus.FocusProperties;
import androidx.compose.p001ui.focus.FocusRequester;
import androidx.compose.p001ui.internal.InlineClassHelperKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: NodeKind.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u000eR$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u000f"}, m195d2 = {"Landroidx/compose/ui/node/CanFocusChecker;", "Landroidx/compose/ui/focus/FocusProperties;", "()V", DownloadUtil.CookieScheme.VALUE, "", "canFocus", "getCanFocus", "()Z", "setCanFocus", "(Z)V", "canFocusValue", "Ljava/lang/Boolean;", "isCanFocusSet", "reset", "", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class CanFocusChecker implements FocusProperties {
    public static final CanFocusChecker INSTANCE = new CanFocusChecker();
    private static Boolean canFocusValue;

    @Override // androidx.compose.p001ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getDown() {
        return FocusRequester.INSTANCE.getDefault();
    }

    @Override // androidx.compose.p001ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getEnd() {
        return FocusRequester.INSTANCE.getDefault();
    }

    @Override // androidx.compose.p001ui.focus.FocusProperties
    public /* synthetic */ Function1 getEnter() {
        return new Function1<FocusDirection, FocusRequester>() { // from class: androidx.compose.ui.focus.FocusProperties$enter$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ FocusRequester invoke(FocusDirection focusDirection) {
                return m3988invoke3ESFkO8(focusDirection.getValue());
            }

            /* JADX INFO: renamed from: invoke-3ESFkO8, reason: not valid java name */
            public final FocusRequester m3988invoke3ESFkO8(int it) {
                return FocusRequester.INSTANCE.getDefault();
            }
        };
    }

    @Override // androidx.compose.p001ui.focus.FocusProperties
    public /* synthetic */ Function1 getExit() {
        return new Function1<FocusDirection, FocusRequester>() { // from class: androidx.compose.ui.focus.FocusProperties$exit$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ FocusRequester invoke(FocusDirection focusDirection) {
                return m3989invoke3ESFkO8(focusDirection.getValue());
            }

            /* JADX INFO: renamed from: invoke-3ESFkO8, reason: not valid java name */
            public final FocusRequester m3989invoke3ESFkO8(int it) {
                return FocusRequester.INSTANCE.getDefault();
            }
        };
    }

    @Override // androidx.compose.p001ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getLeft() {
        return FocusRequester.INSTANCE.getDefault();
    }

    @Override // androidx.compose.p001ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getNext() {
        return FocusRequester.INSTANCE.getDefault();
    }

    @Override // androidx.compose.p001ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getPrevious() {
        return FocusRequester.INSTANCE.getDefault();
    }

    @Override // androidx.compose.p001ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getRight() {
        return FocusRequester.INSTANCE.getDefault();
    }

    @Override // androidx.compose.p001ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getStart() {
        return FocusRequester.INSTANCE.getDefault();
    }

    @Override // androidx.compose.p001ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getUp() {
        return FocusRequester.INSTANCE.getDefault();
    }

    @Override // androidx.compose.p001ui.focus.FocusProperties
    public /* synthetic */ void setDown(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setDown(this, focusRequester);
    }

    @Override // androidx.compose.p001ui.focus.FocusProperties
    public /* synthetic */ void setEnd(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setEnd(this, focusRequester);
    }

    @Override // androidx.compose.p001ui.focus.FocusProperties
    public /* synthetic */ void setEnter(Function1 function1) {
        FocusProperties.CC.$default$setEnter(this, function1);
    }

    @Override // androidx.compose.p001ui.focus.FocusProperties
    public /* synthetic */ void setExit(Function1 function1) {
        FocusProperties.CC.$default$setExit(this, function1);
    }

    @Override // androidx.compose.p001ui.focus.FocusProperties
    public /* synthetic */ void setLeft(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setLeft(this, focusRequester);
    }

    @Override // androidx.compose.p001ui.focus.FocusProperties
    public /* synthetic */ void setNext(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setNext(this, focusRequester);
    }

    @Override // androidx.compose.p001ui.focus.FocusProperties
    public /* synthetic */ void setPrevious(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setPrevious(this, focusRequester);
    }

    @Override // androidx.compose.p001ui.focus.FocusProperties
    public /* synthetic */ void setRight(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setRight(this, focusRequester);
    }

    @Override // androidx.compose.p001ui.focus.FocusProperties
    public /* synthetic */ void setStart(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setStart(this, focusRequester);
    }

    @Override // androidx.compose.p001ui.focus.FocusProperties
    public /* synthetic */ void setUp(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setUp(this, focusRequester);
    }

    private CanFocusChecker() {
    }

    @Override // androidx.compose.p001ui.focus.FocusProperties
    public boolean getCanFocus() {
        Boolean bool = canFocusValue;
        if (bool != null) {
            return bool.booleanValue();
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("canFocus is read before it is written");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.p001ui.focus.FocusProperties
    public void setCanFocus(boolean value) {
        canFocusValue = Boolean.valueOf(value);
    }

    public final boolean isCanFocusSet() {
        return canFocusValue != null;
    }

    public final void reset() {
        canFocusValue = null;
    }
}
