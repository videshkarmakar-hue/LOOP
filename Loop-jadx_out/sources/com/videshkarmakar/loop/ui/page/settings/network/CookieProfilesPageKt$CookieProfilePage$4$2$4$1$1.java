package com.videshkarmakar.loop.ui.page.settings.network;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CookieProfilesPage.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* synthetic */ class CookieProfilesPageKt$CookieProfilePage$4$2$4$1$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    final /* synthetic */ MutableState<Boolean> $expanded$delegate;
    final /* synthetic */ MutableState<Boolean> $userAgent$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CookieProfilesPageKt$CookieProfilePage$4$2$4$1$1(MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2) {
        super(1, Intrinsics.Kotlin.class, "toggleUserAgent", "invoke$toggleUserAgent(Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Z)V", 0);
        this.$userAgent$delegate = mutableState;
        this.$expanded$delegate = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean p0) {
        CookieProfilesPageKt.C10604.AnonymousClass2.C02434.invoke$toggleUserAgent(this.$userAgent$delegate, this.$expanded$delegate, p0);
    }
}
