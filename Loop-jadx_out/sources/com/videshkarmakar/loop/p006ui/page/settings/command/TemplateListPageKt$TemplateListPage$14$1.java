package com.videshkarmakar.loop.p006ui.page.settings.command;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.database.objects.CommandTemplate;
import com.videshkarmakar.loop.util.PreferenceUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TemplateListPage.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$14$1", m210f = "TemplateListPage.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
final class TemplateListPageKt$TemplateListPage$14$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableIntState $selectedTemplateId$delegate;
    final /* synthetic */ State<List<CommandTemplate>> $templates$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TemplateListPageKt$TemplateListPage$14$1(State<? extends List<CommandTemplate>> state, MutableIntState mutableIntState, Continuation<? super TemplateListPageKt$TemplateListPage$14$1> continuation) {
        super(2, continuation);
        this.$templates$delegate = state;
        this.$selectedTemplateId$delegate = mutableIntState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TemplateListPageKt$TemplateListPage$14$1(this.$templates$delegate, this.$selectedTemplateId$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TemplateListPageKt$TemplateListPage$14$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0053  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object next;
        CommandTemplate it;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                if (!TemplateListPageKt.TemplateListPage$lambda$0(this.$templates$delegate).isEmpty()) {
                    List listTemplateListPage$lambda$0 = TemplateListPageKt.TemplateListPage$lambda$0(this.$templates$delegate);
                    MutableIntState mutableIntState = this.$selectedTemplateId$delegate;
                    Iterator it2 = listTemplateListPage$lambda$0.iterator();
                    do {
                        if (it2.hasNext()) {
                            next = it2.next();
                            it = (CommandTemplate) next;
                        } else {
                            next = null;
                        }
                        if (next == null) {
                            this.$selectedTemplateId$delegate.setIntValue(((CommandTemplate) CollectionsKt.first(TemplateListPageKt.TemplateListPage$lambda$0(this.$templates$delegate))).getId());
                            PreferenceUtil.INSTANCE.encodeInt("template_id", TemplateListPageKt.TemplateListPage$lambda$18(this.$selectedTemplateId$delegate));
                        }
                    } while (!(it.getId() == TemplateListPageKt.TemplateListPage$lambda$18(mutableIntState)));
                    if (next == null) {
                        this.$selectedTemplateId$delegate.setIntValue(((CommandTemplate) CollectionsKt.first(TemplateListPageKt.TemplateListPage$lambda$0(this.$templates$delegate))).getId());
                        PreferenceUtil.INSTANCE.encodeInt("template_id", TemplateListPageKt.TemplateListPage$lambda$18(this.$selectedTemplateId$delegate));
                    }
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
