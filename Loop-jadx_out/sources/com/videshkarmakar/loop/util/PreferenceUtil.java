package com.videshkarmakar.loop.util;

import android.os.Build;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.color.DynamicColors;
import com.videshkarmakar.loop.App;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.database.objects.CommandTemplate;
import com.videshkarmakar.loop.p006ui.theme.ColorSchemeKt;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: PreferenceUtil.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m194d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001IB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tJ\u0016\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tJ\u0006\u0010\u001c\u001a\u00020\u0019J\u0006\u0010\u001d\u001a\u00020\u0019J\u0006\u0010\u001e\u001a\u00020\u0019J\u0010\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u0019J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0007J\u0006\u0010$\u001a\u00020\tJ\u0006\u0010%\u001a\u00020\tJ\u0006\u0010&\u001a\u00020\u000fJ\u000e\u0010'\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tJ\u0006\u0010(\u001a\u00020\u0019J\u0006\u0010)\u001a\u00020\u0019J\u000e\u0010*\u001a\u00020+H\u0086@¢\u0006\u0002\u0010,J\u0006\u0010-\u001a\u00020\u0015J\u0006\u0010.\u001a\u00020\u0015J\u001a\u0010/\u001a\u00020+2\b\b\u0002\u00100\u001a\u00020\u00192\b\b\u0002\u00101\u001a\u00020\u0015J\u0016\u00102\u001a\u00020+2\u0006\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u00020\u0019J\u0010\u00105\u001a\u00020+2\b\u00106\u001a\u0004\u0018\u00010#J\u0010\u00107\u001a\u00020+2\b\b\u0002\u00108\u001a\u00020\u0015J\u0016\u00109\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010:\u001a\u00020\u0015J\u0014\u0010;\u001a\u00020\u0015*\u00020\t2\b\b\u0002\u0010<\u001a\u00020\u0015J\u0014\u0010=\u001a\u00020\u0019*\u00020\t2\b\b\u0002\u0010<\u001a\u00020\u0019J\u0014\u0010>\u001a\u00020?*\u00020\t2\b\b\u0002\u0010<\u001a\u00020?J\u0014\u0010@\u001a\u00020\t*\u00020\t2\b\b\u0002\u0010<\u001a\u00020\tJ\u0012\u0010A\u001a\u00020\u0015*\u00020\t2\u0006\u0010B\u001a\u00020\u0015J\u0012\u0010C\u001a\u00020\u0015*\u00020\t2\u0006\u0010D\u001a\u00020\u0019J\u0012\u0010E\u001a\u00020\u0015*\u00020\t2\u0006\u0010F\u001a\u00020?J\u0012\u0010G\u001a\u00020\u0015*\u00020\t2\u0006\u0010H\u001a\u00020\tR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0007R \u0010\u0011\u001a\u0004\u0018\u00010\u000f*\b\u0012\u0004\u0012\u00020\u000f0\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006J"}, m195d2 = {"Lcom/videshkarmakar/loop/util/PreferenceUtil;", "", "()V", "AppSettingsStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/videshkarmakar/loop/util/PreferenceUtil$AppSettings;", "getAppSettingsStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "COOKIE_HEADER", "", "TAG", "mutableAppSettingsStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "templateListStateFlow", "", "Lcom/videshkarmakar/loop/database/objects/CommandTemplate;", "getTemplateListStateFlow", "selectedTemplate", "getSelectedTemplate", "(Ljava/util/List;)Lcom/videshkarmakar/loop/database/objects/CommandTemplate;", "containsKey", "", "key", "encodeInt", "int", "", "encodeString", "string", "getAudioConvertFormat", "getAudioFormat", "getAudioQuality", "getConcurrentFragments", "", "level", "getLocaleFromPreference", "Ljava/util/Locale;", "getMaxDownloadRate", "getSponsorBlockCategories", "getTemplate", "getValue", "getVideoFormat", "getVideoResolution", "initializeTemplateSample", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAutoUpdateEnabled", "isNetworkAvailableForDownload", "modifyDarkThemePreference", "darkThemeValue", "isHighContrastModeEnabled", "modifyThemeSeedColor", "colorArgb", "paletteStyleIndex", "saveLocalePreference", "locale", "switchDynamicColor", "enabled", "updateValue", "b", "getBoolean", "default", "getInt", "getLong", "", "getString", "updateBoolean", "newValue", "updateInt", "newInt", "updateLong", "newLong", "updateString", "newString", "AppSettings", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PreferenceUtil {
    public static final String COOKIE_HEADER = "# Netscape HTTP Cookie File\n# Auto-generated by LOOP built-in WebView\n";
    private static final String TAG = "PreferenceUtil";
    public static final PreferenceUtil INSTANCE = new PreferenceUtil();
    private static final StateFlow<List<CommandTemplate>> templateListStateFlow = FlowKt.stateIn(DatabaseUtil.INSTANCE.getTemplateFlow(), App.INSTANCE.getApplicationScope(), SharingStarted.INSTANCE.getEagerly(), CollectionsKt.emptyList());
    private static final MutableStateFlow<AppSettings> mutableAppSettingsStateFlow = StateFlowKt.MutableStateFlow(new AppSettings(new DarkThemePreference(PreferenceUtilKt.f513kv.decodeInt(PreferenceUtilKt.DARK_THEME_VALUE, 1), PreferenceUtilKt.f513kv.decodeBool("high_contrast", false)), PreferenceUtilKt.f513kv.decodeBool("dynamic_color", DynamicColors.isDynamicColorAvailable()), PreferenceUtilKt.f513kv.decodeInt("theme_color", ColorSchemeKt.DEFAULT_SEED_COLOR), PreferenceUtilKt.f513kv.decodeInt(PreferenceUtilKt.PALETTE_STYLE, 0)));
    private static final StateFlow<AppSettings> AppSettingsStateFlow = FlowKt.asStateFlow(mutableAppSettingsStateFlow);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.videshkarmakar.loop.util.PreferenceUtil$initializeTemplateSample$1 */
    /* JADX INFO: compiled from: PreferenceUtil.kt */
    @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.util.PreferenceUtil", m210f = "PreferenceUtil.kt", m211i = {}, m212l = {314}, m213m = "initializeTemplateSample", m214n = {}, m215s = {})
    static final class C40491 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C40491(Continuation<? super C40491> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferenceUtil.this.initializeTemplateSample(this);
        }
    }

    private PreferenceUtil() {
    }

    public static /* synthetic */ int getInt$default(PreferenceUtil preferenceUtil, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            Object obj2 = PreferenceUtilKt.IntPreferenceDefaults.get(str);
            if (obj2 == null) {
                obj2 = 0;
            }
            i = ((Number) obj2).intValue();
        }
        return preferenceUtil.getInt(str, i);
    }

    public final int getInt(String $this$getInt, int i) {
        Intrinsics.checkNotNullParameter($this$getInt, "<this>");
        return PreferenceUtilKt.f513kv.decodeInt($this$getInt, i);
    }

    public static /* synthetic */ String getString$default(PreferenceUtil preferenceUtil, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            Object obj2 = PreferenceUtilKt.StringPreferenceDefaults.get(str);
            if (obj2 == null) {
                obj2 = "";
            }
            str2 = (String) obj2;
        }
        return preferenceUtil.getString(str, str2);
    }

    public final String getString(String $this$getString, String str) {
        Intrinsics.checkNotNullParameter($this$getString, "<this>");
        Intrinsics.checkNotNullParameter(str, "default");
        String strDecodeString = PreferenceUtilKt.f513kv.decodeString($this$getString);
        return strDecodeString == null ? str : strDecodeString;
    }

    public static /* synthetic */ boolean getBoolean$default(PreferenceUtil preferenceUtil, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            Object obj2 = PreferenceUtilKt.BooleanPreferenceDefaults.get(str);
            if (obj2 == null) {
                obj2 = false;
            }
            z = ((Boolean) obj2).booleanValue();
        }
        return preferenceUtil.getBoolean(str, z);
    }

    public final boolean getBoolean(String $this$getBoolean, boolean z) {
        Intrinsics.checkNotNullParameter($this$getBoolean, "<this>");
        return PreferenceUtilKt.f513kv.decodeBool($this$getBoolean, z);
    }

    public static /* synthetic */ long getLong$default(PreferenceUtil preferenceUtil, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            Object obj2 = PreferenceUtilKt.LongPreferenceDefaults.get(str);
            if (obj2 == null) {
                obj2 = 0L;
            }
            j = ((Number) obj2).longValue();
        }
        return preferenceUtil.getLong(str, j);
    }

    public final long getLong(String $this$getLong, long j) {
        Intrinsics.checkNotNullParameter($this$getLong, "<this>");
        return PreferenceUtilKt.f513kv.decodeLong($this$getLong, j);
    }

    public final boolean updateString(String $this$updateString, String newString) {
        Intrinsics.checkNotNullParameter($this$updateString, "<this>");
        Intrinsics.checkNotNullParameter(newString, "newString");
        return PreferenceUtilKt.f513kv.encode($this$updateString, newString);
    }

    public final boolean updateInt(String $this$updateInt, int newInt) {
        Intrinsics.checkNotNullParameter($this$updateInt, "<this>");
        return PreferenceUtilKt.f513kv.encode($this$updateInt, newInt);
    }

    public final boolean updateLong(String $this$updateLong, long newLong) {
        Intrinsics.checkNotNullParameter($this$updateLong, "<this>");
        return PreferenceUtilKt.f513kv.encode($this$updateLong, newLong);
    }

    public final boolean updateBoolean(String $this$updateBoolean, boolean newValue) {
        Intrinsics.checkNotNullParameter($this$updateBoolean, "<this>");
        return PreferenceUtilKt.f513kv.encode($this$updateBoolean, newValue);
    }

    public final boolean updateValue(String key, boolean b) {
        Intrinsics.checkNotNullParameter(key, "key");
        return updateBoolean(key, b);
    }

    public final boolean encodeInt(String key, int i) {
        Intrinsics.checkNotNullParameter(key, "key");
        return updateInt(key, i);
    }

    public final boolean getValue(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getBoolean$default(this, key, false, 1, null);
    }

    public final boolean encodeString(String key, String string) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(string, "string");
        return updateString(key, string);
    }

    public final boolean containsKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return PreferenceUtilKt.f513kv.containsKey(key);
    }

    public final int getAudioConvertFormat() {
        return getInt$default(this, PreferenceUtilKt.AUDIO_CONVERSION_FORMAT, 0, 1, null);
    }

    public final int getVideoResolution() {
        return getInt$default(this, PreferenceUtilKt.VIDEO_QUALITY, 0, 1, null);
    }

    public final int getAudioQuality() {
        return getInt$default(this, PreferenceUtilKt.AUDIO_QUALITY, 0, 1, null);
    }

    public final int getVideoFormat() {
        return getInt$default(this, PreferenceUtilKt.VIDEO_FORMAT, 0, 1, null);
    }

    public final int getAudioFormat() {
        return getInt$default(this, PreferenceUtilKt.AUDIO_FORMAT, 0, 1, null);
    }

    public final boolean isNetworkAvailableForDownload() {
        return getBoolean$default(this, PreferenceUtilKt.CELLULAR_DOWNLOAD, false, 1, null) || !App.INSTANCE.getConnectivityManager().isActiveNetworkMetered();
    }

    public final boolean isAutoUpdateEnabled() {
        return getBoolean(PreferenceUtilKt.AUTO_UPDATE, !App.INSTANCE.isFDroidBuild());
    }

    public final Locale getLocaleFromPreference() {
        Object next;
        Map.Entry it;
        int languageCode = getInt$default(this, "language", 0, 1, null);
        Iterator<T> it2 = LanguageSettingsKt.getLocaleLanguageCodeMap().entrySet().iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            it = (Map.Entry) next;
        } while (!(((Number) it.getValue()).intValue() == languageCode));
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (Locale) entry.getKey();
        }
        return null;
    }

    public final void saveLocalePreference(Locale locale) {
        if (Build.VERSION.SDK_INT < 33) {
            Integer num = LanguageSettingsKt.getLocaleLanguageCodeMap().get(locale);
            updateInt("language", num != null ? num.intValue() : 0);
        }
    }

    public static /* synthetic */ float getConcurrentFragments$default(PreferenceUtil preferenceUtil, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = getInt$default(preferenceUtil, PreferenceUtilKt.CONCURRENT, 0, 1, null);
        }
        return preferenceUtil.getConcurrentFragments(i);
    }

    public final float getConcurrentFragments(int level) {
        switch (level) {
            case 1:
                return 0.0f;
            case 8:
                return 0.33f;
            case 16:
                return 0.66f;
            default:
                return 1.0f;
        }
    }

    public final String getSponsorBlockCategories() {
        return getString$default(this, PreferenceUtilKt.SPONSORBLOCK_CATEGORIES, null, 1, null);
    }

    public final StateFlow<List<CommandTemplate>> getTemplateListStateFlow() {
        return templateListStateFlow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CommandTemplate getSelectedTemplate(List<CommandTemplate> list) {
        Object obj;
        Object next;
        boolean z;
        Iterator<T> it = list.iterator();
        do {
            obj = null;
            if (it.hasNext()) {
                next = it.next();
                CommandTemplate it2 = (CommandTemplate) next;
                z = false;
                if (it2.getId() == getInt$default(INSTANCE, "template_id", 0, 1, null)) {
                    z = true;
                }
            }
            return (CommandTemplate) obj;
        } while (!z);
        obj = next;
        return (CommandTemplate) obj;
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.util.PreferenceUtil$getTemplate$1 */
    /* JADX INFO: compiled from: PreferenceUtil.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.util.PreferenceUtil$getTemplate$1", m210f = "PreferenceUtil.kt", m211i = {0}, m212l = {306}, m213m = "invokeSuspend", m214n = {"cnt"}, m215s = {"I$0"})
    static final class C40481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<CommandTemplate> $template;
        int I$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C40481(Ref.ObjectRef<CommandTemplate> objectRef, Continuation<? super C40481> continuation) {
            super(2, continuation);
            this.$template = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C40481(this.$template, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C40481) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0021  */
        /* JADX WARN: Code duplicated, block: B:12:0x003d  */
        /* JADX WARN: Code duplicated, block: B:14:0x0040  */
        /* JADX WARN: Code duplicated, block: B:16:0x004f A[RETURN] */
        /* JADX WARN: Type inference failed for: r5v1, types: [T, com.videshkarmakar.loop.database.objects.CommandTemplate] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x004d -> B:17:0x0050). Please report as a decompilation issue!!! */
        /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
            java.lang.StackOverflowError
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 1
                switch(r1) {
                    case 0: goto L19;
                    case 1: goto L12;
                    default: goto La;
                }
            La:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L12:
                r1 = r7
                int r3 = r1.I$0
                kotlin.ResultKt.throwOnFailure(r8)
                goto L50
            L19:
                kotlin.ResultKt.throwOnFailure(r8)
                r1 = r7
                r3 = 1
            L1e:
                r4 = 6
                if (r3 >= r4) goto L52
                kotlin.jvm.internal.Ref$ObjectRef<com.videshkarmakar.loop.database.objects.CommandTemplate> r4 = r1.$template
                com.videshkarmakar.loop.util.PreferenceUtil r5 = com.videshkarmakar.loop.util.PreferenceUtil.INSTANCE
                com.videshkarmakar.loop.util.PreferenceUtil r6 = com.videshkarmakar.loop.util.PreferenceUtil.INSTANCE
                kotlinx.coroutines.flow.StateFlow r6 = r6.getTemplateListStateFlow()
                java.lang.Object r6 = r6.getValue()
                java.util.List r6 = (java.util.List) r6
                com.videshkarmakar.loop.database.objects.CommandTemplate r5 = com.videshkarmakar.loop.util.PreferenceUtil.access$getSelectedTemplate(r5, r6)
                r4.element = r5
                kotlin.jvm.internal.Ref$ObjectRef<com.videshkarmakar.loop.database.objects.CommandTemplate> r4 = r1.$template
                T r4 = r4.element
                if (r4 == 0) goto L40
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            L40:
                r4 = r1
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r1.I$0 = r3
                r1.label = r2
                r5 = 100
                java.lang.Object r4 = kotlinx.coroutines.DelayKt.delay(r5, r4)
                if (r4 != r0) goto L50
                return r0
            L50:
                int r3 = r3 + r2
                goto L1e
            L52:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.videshkarmakar.loop.util.PreferenceUtil.C40481.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CommandTemplate getTemplate() throws InterruptedException {
        Ref.ObjectRef template = new Ref.ObjectRef();
        BuildersKt__BuildersKt.runBlocking$default(null, new C40481(template, null), 1, null);
        CommandTemplate commandTemplate = (CommandTemplate) template.element;
        if (commandTemplate != null) {
            return commandTemplate;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object initializeTemplateSample(Continuation<? super Unit> continuation) {
        C40491 c40491;
        PreferenceUtil preferenceUtil;
        Object objInsertTemplate;
        String str;
        if (continuation instanceof C40491) {
            c40491 = (C40491) continuation;
            if ((c40491.label & Integer.MIN_VALUE) != 0) {
                c40491.label -= Integer.MIN_VALUE;
            } else {
                c40491 = new C40491(continuation);
            }
        } else {
            c40491 = new C40491(continuation);
        }
        C40491 c40492 = c40491;
        Object $result = c40492.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c40492.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                preferenceUtil = this;
                DatabaseUtil databaseUtil = DatabaseUtil.INSTANCE;
                String string = App.INSTANCE.getContext().getString(C3070R.string.custom_command_template);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                CommandTemplate commandTemplate = new CommandTemplate(0, string, PreferenceUtilKt.TEMPLATE_EXAMPLE);
                c40492.L$0 = preferenceUtil;
                c40492.L$1 = "template_id";
                c40492.label = 1;
                objInsertTemplate = databaseUtil.insertTemplate(commandTemplate, c40492);
                if (objInsertTemplate == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = "template_id";
                break;
                break;
            case 1:
                str = (String) c40492.L$1;
                preferenceUtil = (PreferenceUtil) c40492.L$0;
                ResultKt.throwOnFailure($result);
                objInsertTemplate = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        preferenceUtil.updateInt(str, (int) ((Number) objInsertTemplate).longValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: PreferenceUtil.kt */
    @Metadata(m194d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, m195d2 = {"Lcom/videshkarmakar/loop/util/PreferenceUtil$AppSettings;", "", "darkTheme", "Lcom/videshkarmakar/loop/util/DarkThemePreference;", "isDynamicColorEnabled", "", "seedColor", "", "paletteStyleIndex", "(Lcom/videshkarmakar/loop/util/DarkThemePreference;ZII)V", "getDarkTheme", "()Lcom/videshkarmakar/loop/util/DarkThemePreference;", "()Z", "getPaletteStyleIndex", "()I", "getSeedColor", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class AppSettings {
        public static final int $stable = 0;
        private final DarkThemePreference darkTheme;
        private final boolean isDynamicColorEnabled;
        private final int paletteStyleIndex;
        private final int seedColor;

        public AppSettings() {
            this(null, false, 0, 0, 15, null);
        }

        public static /* synthetic */ AppSettings copy$default(AppSettings appSettings, DarkThemePreference darkThemePreference, boolean z, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                darkThemePreference = appSettings.darkTheme;
            }
            if ((i3 & 2) != 0) {
                z = appSettings.isDynamicColorEnabled;
            }
            if ((i3 & 4) != 0) {
                i = appSettings.seedColor;
            }
            if ((i3 & 8) != 0) {
                i2 = appSettings.paletteStyleIndex;
            }
            return appSettings.copy(darkThemePreference, z, i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DarkThemePreference getDarkTheme() {
            return this.darkTheme;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsDynamicColorEnabled() {
            return this.isDynamicColorEnabled;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getSeedColor() {
            return this.seedColor;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getPaletteStyleIndex() {
            return this.paletteStyleIndex;
        }

        public final AppSettings copy(DarkThemePreference darkTheme, boolean isDynamicColorEnabled, int seedColor, int paletteStyleIndex) {
            Intrinsics.checkNotNullParameter(darkTheme, "darkTheme");
            return new AppSettings(darkTheme, isDynamicColorEnabled, seedColor, paletteStyleIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AppSettings)) {
                return false;
            }
            AppSettings appSettings = (AppSettings) other;
            return Intrinsics.areEqual(this.darkTheme, appSettings.darkTheme) && this.isDynamicColorEnabled == appSettings.isDynamicColorEnabled && this.seedColor == appSettings.seedColor && this.paletteStyleIndex == appSettings.paletteStyleIndex;
        }

        public int hashCode() {
            return (((((this.darkTheme.hashCode() * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.isDynamicColorEnabled)) * 31) + this.seedColor) * 31) + this.paletteStyleIndex;
        }

        public String toString() {
            return "AppSettings(darkTheme=" + this.darkTheme + ", isDynamicColorEnabled=" + this.isDynamicColorEnabled + ", seedColor=" + this.seedColor + ", paletteStyleIndex=" + this.paletteStyleIndex + ")";
        }

        public AppSettings(DarkThemePreference darkTheme, boolean isDynamicColorEnabled, int seedColor, int paletteStyleIndex) {
            Intrinsics.checkNotNullParameter(darkTheme, "darkTheme");
            this.darkTheme = darkTheme;
            this.isDynamicColorEnabled = isDynamicColorEnabled;
            this.seedColor = seedColor;
            this.paletteStyleIndex = paletteStyleIndex;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ AppSettings(DarkThemePreference darkThemePreference, boolean z, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            int i4 = 0;
            Object[] objArr = 0;
            if ((i3 & 1) != 0) {
                darkThemePreference = new DarkThemePreference(i4, objArr == true ? 1 : 0, 3, null);
            }
            this(darkThemePreference, (i3 & 2) != 0 ? false : z, (i3 & 4) != 0 ? ColorSchemeKt.DEFAULT_SEED_COLOR : i, (i3 & 8) != 0 ? 0 : i2);
        }

        public final DarkThemePreference getDarkTheme() {
            return this.darkTheme;
        }

        public final boolean isDynamicColorEnabled() {
            return this.isDynamicColorEnabled;
        }

        public final int getSeedColor() {
            return this.seedColor;
        }

        public final int getPaletteStyleIndex() {
            return this.paletteStyleIndex;
        }
    }

    public final String getMaxDownloadRate() {
        return getString$default(this, PreferenceUtilKt.MAX_RATE, null, 1, null);
    }

    public final StateFlow<AppSettings> getAppSettingsStateFlow() {
        return AppSettingsStateFlow;
    }

    public static /* synthetic */ void modifyDarkThemePreference$default(PreferenceUtil preferenceUtil, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = AppSettingsStateFlow.getValue().getDarkTheme().getDarkThemeValue();
        }
        if ((i2 & 2) != 0) {
            z = AppSettingsStateFlow.getValue().getDarkTheme().isHighContrastModeEnabled();
        }
        preferenceUtil.modifyDarkThemePreference(i, z);
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.util.PreferenceUtil$modifyDarkThemePreference$1 */
    /* JADX INFO: compiled from: PreferenceUtil.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.util.PreferenceUtil$modifyDarkThemePreference$1", m210f = "PreferenceUtil.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C40501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $darkThemeValue;
        final /* synthetic */ boolean $isHighContrastModeEnabled;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C40501(int i, boolean z, Continuation<? super C40501> continuation) {
            super(2, continuation);
            this.$darkThemeValue = i;
            this.$isHighContrastModeEnabled = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C40501(this.$darkThemeValue, this.$isHighContrastModeEnabled, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C40501) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object prevValue$iv;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    MutableStateFlow $this$update$iv = PreferenceUtil.mutableAppSettingsStateFlow;
                    int i = this.$darkThemeValue;
                    boolean z = this.$isHighContrastModeEnabled;
                    do {
                        prevValue$iv = $this$update$iv.getValue();
                    } while (!$this$update$iv.compareAndSet(prevValue$iv, AppSettings.copy$default((AppSettings) prevValue$iv, PreferenceUtil.INSTANCE.getAppSettingsStateFlow().getValue().getDarkTheme().copy(i, z), false, 0, 0, 14, null)));
                    PreferenceUtilKt.f513kv.encode(PreferenceUtilKt.DARK_THEME_VALUE, this.$darkThemeValue);
                    PreferenceUtilKt.f513kv.encode("high_contrast", this.$isHighContrastModeEnabled);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final void modifyDarkThemePreference(int darkThemeValue, boolean isHighContrastModeEnabled) {
        BuildersKt__Builders_commonKt.launch$default(App.INSTANCE.getApplicationScope(), Dispatchers.getIO(), null, new C40501(darkThemeValue, isHighContrastModeEnabled, null), 2, null);
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.util.PreferenceUtil$modifyThemeSeedColor$1 */
    /* JADX INFO: compiled from: PreferenceUtil.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.util.PreferenceUtil$modifyThemeSeedColor$1", m210f = "PreferenceUtil.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C40511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $colorArgb;
        final /* synthetic */ int $paletteStyleIndex;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C40511(int i, int i2, Continuation<? super C40511> continuation) {
            super(2, continuation);
            this.$colorArgb = i;
            this.$paletteStyleIndex = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C40511(this.$colorArgb, this.$paletteStyleIndex, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C40511) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object prevValue$iv;
            AppSettings it;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    MutableStateFlow $this$update$iv = PreferenceUtil.mutableAppSettingsStateFlow;
                    int i = this.$colorArgb;
                    int i2 = this.$paletteStyleIndex;
                    do {
                        prevValue$iv = $this$update$iv.getValue();
                        it = (AppSettings) prevValue$iv;
                    } while (!$this$update$iv.compareAndSet(prevValue$iv, AppSettings.copy$default(it, null, false, i, i2, 3, null)));
                    PreferenceUtilKt.f513kv.encode("theme_color", this.$colorArgb);
                    PreferenceUtilKt.f513kv.encode(PreferenceUtilKt.PALETTE_STYLE, this.$paletteStyleIndex);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final void modifyThemeSeedColor(int colorArgb, int paletteStyleIndex) {
        BuildersKt__Builders_commonKt.launch$default(App.INSTANCE.getApplicationScope(), Dispatchers.getIO(), null, new C40511(colorArgb, paletteStyleIndex, null), 2, null);
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.util.PreferenceUtil$switchDynamicColor$1 */
    /* JADX INFO: compiled from: PreferenceUtil.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.util.PreferenceUtil$switchDynamicColor$1", m210f = "PreferenceUtil.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C40521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $enabled;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C40521(boolean z, Continuation<? super C40521> continuation) {
            super(2, continuation);
            this.$enabled = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C40521(this.$enabled, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C40521) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object prevValue$iv;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    MutableStateFlow $this$update$iv = PreferenceUtil.mutableAppSettingsStateFlow;
                    boolean z = this.$enabled;
                    do {
                        prevValue$iv = $this$update$iv.getValue();
                    } while (!$this$update$iv.compareAndSet(prevValue$iv, AppSettings.copy$default((AppSettings) prevValue$iv, null, z, 0, 0, 13, null)));
                    PreferenceUtilKt.f513kv.encode("dynamic_color", this.$enabled);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public static /* synthetic */ void switchDynamicColor$default(PreferenceUtil preferenceUtil, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = !mutableAppSettingsStateFlow.getValue().isDynamicColorEnabled();
        }
        preferenceUtil.switchDynamicColor(z);
    }

    public final void switchDynamicColor(boolean enabled) {
        BuildersKt__Builders_commonKt.launch$default(App.INSTANCE.getApplicationScope(), Dispatchers.getIO(), null, new C40521(enabled, null), 2, null);
    }
}
