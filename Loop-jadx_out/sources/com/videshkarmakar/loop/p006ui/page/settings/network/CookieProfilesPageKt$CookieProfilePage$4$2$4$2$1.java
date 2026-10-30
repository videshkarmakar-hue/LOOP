package com.videshkarmakar.loop.p006ui.page.settings.network;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CookieProfilesPage.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* synthetic */ class CookieProfilesPageKt$CookieProfilePage$4$2$4$2$1 extends AdaptedFunctionReference implements Function0<Unit> {
    final /* synthetic */ MutableState<Boolean> $expanded$delegate;
    final /* synthetic */ MutableState<Boolean> $userAgent$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CookieProfilesPageKt$CookieProfilePage$4$2$4$2$1(MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2) {
        super(0, Intrinsics.Kotlin.class, "toggleUserAgent", "invoke$toggleUserAgent(Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Z)V", 0);
        this.$userAgent$delegate = mutableState;
        this.$expanded$delegate = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        CookieProfilesPageKt.C39194.AnonymousClass2.AnonymousClass4.invoke$toggleUserAgent$default(this.$userAgent$delegate, this.$expanded$delegate, false, 4, null);
    }
}
