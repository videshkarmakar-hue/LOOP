package androidx.compose.foundation.text;

import androidx.compose.p001ui.text.input.ImeAction;
import androidx.compose.p001ui.text.input.ImeOptions;
import androidx.compose.p001ui.text.input.KeyboardCapitalization;
import androidx.compose.p001ui.text.input.KeyboardType;
import androidx.compose.p001ui.text.input.PlatformImeOptions;
import androidx.compose.p001ui.text.intl.LocaleList;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyboardOptions.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 H2\u00020\u0001:\u0001HBQ\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fB/\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u0010B;\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0011BG\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0012BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0014J:\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00103JF\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105JR\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b6\u00107J^\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b8\u00109J^\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eø\u0001\u0000¢\u0006\u0004\b8\u0010:J\u0013\u0010;\u001a\u00020\u00052\b\u0010<\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0017\u0010=\u001a\u00020\u00002\b\u0010<\u001a\u0004\u0018\u00010\u0000H\u0001¢\u0006\u0002\b>J\b\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020\u00002\b\u0010<\u001a\u0004\u0018\u00010\u0000J\u0017\u0010B\u001a\u00020C2\b\b\u0002\u0010D\u001a\u00020\u0005H\u0000¢\u0006\u0002\bEJ\b\u0010F\u001a\u00020GH\u0016R\u001a\u0010\u0004\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0018R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010!\u001a\u00020\u00038BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\"\u0010\u001fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0019\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b%\u0010\u001fR\u001a\u0010&\u001a\u00020\t8@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b'\u0010\u001fR\u0014\u0010(\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0018R\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b)\u0010\u001fR\u001a\u0010*\u001a\u00020\u00078BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b+\u0010\u001fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b.\u0010\u001aR\u0014\u0010/\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0018\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006I"}, m195d2 = {"Landroidx/compose/foundation/text/KeyboardOptions;", "", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "autoCorrect", "", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "platformImeOptions", "Landroidx/compose/ui/text/input/PlatformImeOptions;", "showKeyboardOnFocus", "hintLocales", "Landroidx/compose/ui/text/intl/LocaleList;", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(IZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "autoCorrectEnabled", "(ILjava/lang/Boolean;IILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAutoCorrect$annotations", "()V", "getAutoCorrect", "()Z", "getAutoCorrectEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "autoCorrectOrDefault", "getAutoCorrectOrDefault", "getCapitalization-IUNYP9k", "()I", "I", "capitalizationOrDefault", "getCapitalizationOrDefault-IUNYP9k", "getHintLocales", "()Landroidx/compose/ui/text/intl/LocaleList;", "getImeAction-eUduSuo", "imeActionOrDefault", "getImeActionOrDefault-eUduSuo$foundation_release", "isCompletelyUnspecified", "getKeyboardType-PjHm6EE", "keyboardTypeOrDefault", "getKeyboardTypeOrDefault-PjHm6EE", "getPlatformImeOptions", "()Landroidx/compose/ui/text/input/PlatformImeOptions;", "getShowKeyboardOnFocus", "showKeyboardOnFocusOrDefault", "getShowKeyboardOnFocusOrDefault$foundation_release", "copy", "copy-3m2b7yw", "(IZII)Landroidx/compose/foundation/text/KeyboardOptions;", "copy-ij11fho", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;)Landroidx/compose/foundation/text/KeyboardOptions;", "copy-H-u8-rc", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;)Landroidx/compose/foundation/text/KeyboardOptions;", "copy-INvB4aQ", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;)Landroidx/compose/foundation/text/KeyboardOptions;", "(ILjava/lang/Boolean;IILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;)Landroidx/compose/foundation/text/KeyboardOptions;", "equals", "other", "fillUnspecifiedValuesWith", "fillUnspecifiedValuesWith$foundation_release", "hashCode", "", "merge", "toImeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "singleLine", "toImeOptions$foundation_release", "toString", "", "Companion", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class KeyboardOptions {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KeyboardOptions Default = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
    private static final KeyboardOptions SecureTextField = new KeyboardOptions(0, (Boolean) false, KeyboardType.INSTANCE.m6491getPasswordPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 121, (DefaultConstructorMarker) null);
    private final Boolean autoCorrectEnabled;
    private final int capitalization;
    private final LocaleList hintLocales;
    private final int imeAction;
    private final int keyboardType;
    private final PlatformImeOptions platformImeOptions;
    private final Boolean showKeyboardOnFocus;

    public /* synthetic */ KeyboardOptions(int i, Boolean bool, int i2, int i3, PlatformImeOptions platformImeOptions, Boolean bool2, LocaleList localeList, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, bool, i2, i3, platformImeOptions, bool2, localeList);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Please use the new constructor that takes optional autoCorrect parameter.", replaceWith = @ReplaceWith(expression = "KeyboardOptions(capitalization = capitalization, autoCorrectEnabled = autoCorrect, keyboardType = keyboardType, imeAction = imeAction,platformImeOptions = platformImeOptions, showKeyboardOnFocus = showKeyboardOnFocus,hintLocales = hintLocales)", imports = {}))
    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions, Boolean bool, LocaleList localeList, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, i2, i3, platformImeOptions, bool, localeList);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions, Boolean bool, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, i2, i3, platformImeOptions, bool);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, i2, i3, platformImeOptions);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new constructor that takes optional platformImeOptions parameter.")
    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, i2, i3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Please use the autoCorrectMode property.")
    public static /* synthetic */ void getAutoCorrect$annotations() {
    }

    private KeyboardOptions(int capitalization, Boolean autoCorrectEnabled, int keyboardType, int imeAction, PlatformImeOptions platformImeOptions, Boolean showKeyboardOnFocus, LocaleList hintLocales) {
        this.capitalization = capitalization;
        this.autoCorrectEnabled = autoCorrectEnabled;
        this.keyboardType = keyboardType;
        this.imeAction = imeAction;
        this.platformImeOptions = platformImeOptions;
        this.showKeyboardOnFocus = showKeyboardOnFocus;
        this.hintLocales = hintLocales;
    }

    public /* synthetic */ KeyboardOptions(int i, Boolean bool, int i2, int i3, PlatformImeOptions platformImeOptions, Boolean bool2, LocaleList localeList, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? KeyboardCapitalization.INSTANCE.m6467getUnspecifiedIUNYP9k() : i, (i4 & 2) != 0 ? null : bool, (i4 & 4) != 0 ? KeyboardType.INSTANCE.m6494getUnspecifiedPjHm6EE() : i2, (i4 & 8) != 0 ? ImeAction.INSTANCE.m6440getUnspecifiedeUduSuo() : i3, (i4 & 16) != 0 ? null : platformImeOptions, (i4 & 32) != 0 ? null : bool2, (i4 & 64) == 0 ? localeList : null, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: renamed from: getCapitalization-IUNYP9k, reason: not valid java name and from getter */
    public final int getCapitalization() {
        return this.capitalization;
    }

    public final Boolean getAutoCorrectEnabled() {
        return this.autoCorrectEnabled;
    }

    /* JADX INFO: renamed from: getKeyboardType-PjHm6EE, reason: not valid java name and from getter */
    public final int getKeyboardType() {
        return this.keyboardType;
    }

    /* JADX INFO: renamed from: getImeAction-eUduSuo, reason: not valid java name and from getter */
    public final int getImeAction() {
        return this.imeAction;
    }

    public final PlatformImeOptions getPlatformImeOptions() {
        return this.platformImeOptions;
    }

    public final Boolean getShowKeyboardOnFocus() {
        return this.showKeyboardOnFocus;
    }

    public final LocaleList getHintLocales() {
        return this.hintLocales;
    }

    /* JADX INFO: compiled from: KeyboardOptions.kt */
    @Metadata(m194d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, m195d2 = {"Landroidx/compose/foundation/text/KeyboardOptions$Companion;", "", "()V", "Default", "Landroidx/compose/foundation/text/KeyboardOptions;", "getDefault$annotations", "getDefault", "()Landroidx/compose/foundation/text/KeyboardOptions;", "SecureTextField", "getSecureTextField$foundation_release$annotations", "getSecureTextField$foundation_release", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getDefault$annotations() {
        }

        public static /* synthetic */ void getSecureTextField$foundation_release$annotations() {
        }

        private Companion() {
        }

        public final KeyboardOptions getDefault() {
            return KeyboardOptions.Default;
        }

        public final KeyboardOptions getSecureTextField$foundation_release() {
            return KeyboardOptions.SecureTextField;
        }
    }

    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions, Boolean bool, LocaleList localeList, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? KeyboardCapitalization.INSTANCE.m6467getUnspecifiedIUNYP9k() : i, z, (i4 & 4) != 0 ? KeyboardType.INSTANCE.m6494getUnspecifiedPjHm6EE() : i2, (i4 & 8) != 0 ? ImeAction.INSTANCE.m6440getUnspecifiedeUduSuo() : i3, (i4 & 16) != 0 ? null : platformImeOptions, (i4 & 32) != 0 ? null : bool, (i4 & 64) != 0 ? null : localeList, (DefaultConstructorMarker) null);
    }

    private KeyboardOptions(int capitalization, boolean autoCorrect, int keyboardType, int imeAction, PlatformImeOptions platformImeOptions, Boolean showKeyboardOnFocus, LocaleList hintLocales) {
        this(capitalization, Boolean.valueOf(autoCorrect), keyboardType, imeAction, platformImeOptions, showKeyboardOnFocus, hintLocales, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? KeyboardCapitalization.INSTANCE.m6467getUnspecifiedIUNYP9k() : i, (i4 & 2) != 0 ? Default.getAutoCorrectOrDefault() : z, (i4 & 4) != 0 ? KeyboardType.INSTANCE.m6494getUnspecifiedPjHm6EE() : i2, (i4 & 8) != 0 ? ImeAction.INSTANCE.m6432getDefaulteUduSuo() : i3, (DefaultConstructorMarker) null);
    }

    private KeyboardOptions(int capitalization, boolean autoCorrect, int keyboardType, int imeAction) {
        this(capitalization, Boolean.valueOf(autoCorrect), keyboardType, imeAction, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 96, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? KeyboardCapitalization.INSTANCE.m6465getNoneIUNYP9k() : i, (i4 & 2) != 0 ? Default.getAutoCorrectOrDefault() : z, (i4 & 4) != 0 ? KeyboardType.INSTANCE.m6493getTextPjHm6EE() : i2, (i4 & 8) != 0 ? ImeAction.INSTANCE.m6432getDefaulteUduSuo() : i3, (i4 & 16) != 0 ? null : platformImeOptions, (DefaultConstructorMarker) null);
    }

    private KeyboardOptions(int capitalization, boolean autoCorrect, int keyboardType, int imeAction, PlatformImeOptions platformImeOptions) {
        this(capitalization, Boolean.valueOf(autoCorrect), keyboardType, imeAction, platformImeOptions, Boolean.valueOf(Default.getShowKeyboardOnFocusOrDefault$foundation_release()), (LocaleList) null, 64, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions, Boolean bool, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? KeyboardCapitalization.INSTANCE.m6465getNoneIUNYP9k() : i, (i4 & 2) != 0 ? Default.getAutoCorrectOrDefault() : z, (i4 & 4) != 0 ? KeyboardType.INSTANCE.m6493getTextPjHm6EE() : i2, (i4 & 8) != 0 ? ImeAction.INSTANCE.m6432getDefaulteUduSuo() : i3, (i4 & 16) != 0 ? null : platformImeOptions, (i4 & 32) == 0 ? bool : null, (DefaultConstructorMarker) null);
    }

    private KeyboardOptions(int capitalization, boolean autoCorrect, int keyboardType, int imeAction, PlatformImeOptions platformImeOptions, Boolean showKeyboardOnFocus) {
        this(capitalization, Boolean.valueOf(autoCorrect), keyboardType, imeAction, platformImeOptions, showKeyboardOnFocus, (LocaleList) null, (DefaultConstructorMarker) null);
    }

    public final boolean getAutoCorrect() {
        return getAutoCorrectOrDefault();
    }

    private final boolean getAutoCorrectOrDefault() {
        Boolean bool = this.autoCorrectEnabled;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    /* JADX INFO: renamed from: getCapitalizationOrDefault-IUNYP9k, reason: not valid java name */
    private final int m1186getCapitalizationOrDefaultIUNYP9k() {
        KeyboardCapitalization keyboardCapitalizationM6452boximpl = KeyboardCapitalization.m6452boximpl(this.capitalization);
        int it = keyboardCapitalizationM6452boximpl.getValue();
        if (KeyboardCapitalization.m6455equalsimpl0(it, KeyboardCapitalization.INSTANCE.m6467getUnspecifiedIUNYP9k())) {
            keyboardCapitalizationM6452boximpl = null;
        }
        return keyboardCapitalizationM6452boximpl != null ? keyboardCapitalizationM6452boximpl.getValue() : KeyboardCapitalization.INSTANCE.m6465getNoneIUNYP9k();
    }

    /* JADX INFO: renamed from: getKeyboardTypeOrDefault-PjHm6EE, reason: not valid java name */
    private final int m1187getKeyboardTypeOrDefaultPjHm6EE() {
        KeyboardType keyboardTypeM6469boximpl = KeyboardType.m6469boximpl(this.keyboardType);
        int it = keyboardTypeM6469boximpl.getValue();
        if (KeyboardType.m6472equalsimpl0(it, KeyboardType.INSTANCE.m6494getUnspecifiedPjHm6EE())) {
            keyboardTypeM6469boximpl = null;
        }
        return keyboardTypeM6469boximpl != null ? keyboardTypeM6469boximpl.getValue() : KeyboardType.INSTANCE.m6493getTextPjHm6EE();
    }

    /* JADX INFO: renamed from: getImeActionOrDefault-eUduSuo$foundation_release, reason: not valid java name */
    public final int m1195getImeActionOrDefaulteUduSuo$foundation_release() {
        ImeAction imeActionM6416boximpl = ImeAction.m6416boximpl(this.imeAction);
        int it = imeActionM6416boximpl.getValue();
        if (ImeAction.m6419equalsimpl0(it, ImeAction.INSTANCE.m6440getUnspecifiedeUduSuo())) {
            imeActionM6416boximpl = null;
        }
        return imeActionM6416boximpl != null ? imeActionM6416boximpl.getValue() : ImeAction.INSTANCE.m6432getDefaulteUduSuo();
    }

    public final boolean getShowKeyboardOnFocusOrDefault$foundation_release() {
        Boolean bool = this.showKeyboardOnFocus;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private final boolean isCompletelyUnspecified() {
        return KeyboardCapitalization.m6455equalsimpl0(this.capitalization, KeyboardCapitalization.INSTANCE.m6467getUnspecifiedIUNYP9k()) && this.autoCorrectEnabled == null && KeyboardType.m6472equalsimpl0(this.keyboardType, KeyboardType.INSTANCE.m6494getUnspecifiedPjHm6EE()) && ImeAction.m6419equalsimpl0(this.imeAction, ImeAction.INSTANCE.m6440getUnspecifiedeUduSuo()) && this.platformImeOptions == null && this.showKeyboardOnFocus == null && this.hintLocales == null;
    }

    public static /* synthetic */ ImeOptions toImeOptions$foundation_release$default(KeyboardOptions keyboardOptions, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = ImeOptions.INSTANCE.getDefault().getSingleLine();
        }
        return keyboardOptions.toImeOptions$foundation_release(z);
    }

    public final ImeOptions toImeOptions$foundation_release(boolean singleLine) {
        return new ImeOptions(singleLine, m1186getCapitalizationOrDefaultIUNYP9k(), getAutoCorrectOrDefault(), m1187getKeyboardTypeOrDefaultPjHm6EE(), m1195getImeActionOrDefaulteUduSuo$foundation_release(), this.platformImeOptions, this.hintLocales, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: renamed from: copy-INvB4aQ$default, reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m1183copyINvB4aQ$default(KeyboardOptions keyboardOptions, int i, Boolean bool, int i2, int i3, PlatformImeOptions platformImeOptions, Boolean bool2, LocaleList localeList, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = keyboardOptions.capitalization;
        }
        return keyboardOptions.m1190copyINvB4aQ(i, (i4 & 2) != 0 ? keyboardOptions.autoCorrectEnabled : bool, (i4 & 4) != 0 ? keyboardOptions.keyboardType : i2, (i4 & 8) != 0 ? keyboardOptions.imeAction : i3, (i4 & 16) != 0 ? keyboardOptions.platformImeOptions : platformImeOptions, (i4 & 32) != 0 ? null : bool2, (i4 & 64) != 0 ? null : localeList);
    }

    /* JADX INFO: renamed from: copy-INvB4aQ, reason: not valid java name */
    public final KeyboardOptions m1190copyINvB4aQ(int capitalization, Boolean autoCorrectEnabled, int keyboardType, int imeAction, PlatformImeOptions platformImeOptions, Boolean showKeyboardOnFocus, LocaleList hintLocales) {
        return new KeyboardOptions(capitalization, autoCorrectEnabled, keyboardType, imeAction, platformImeOptions, showKeyboardOnFocus, hintLocales, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: renamed from: copy-INvB4aQ$default, reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m1184copyINvB4aQ$default(KeyboardOptions keyboardOptions, int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions, Boolean bool, LocaleList localeList, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = keyboardOptions.capitalization;
        }
        return keyboardOptions.m1191copyINvB4aQ(i, (i4 & 2) != 0 ? keyboardOptions.getAutoCorrectOrDefault() : z, (i4 & 4) != 0 ? keyboardOptions.keyboardType : i2, (i4 & 8) != 0 ? keyboardOptions.imeAction : i3, (i4 & 16) != 0 ? keyboardOptions.platformImeOptions : platformImeOptions, (i4 & 32) != 0 ? Boolean.valueOf(keyboardOptions.getShowKeyboardOnFocusOrDefault$foundation_release()) : bool, (i4 & 64) != 0 ? keyboardOptions.hintLocales : localeList);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Please use the copy function that takes an autoCorrectMode parameter.", replaceWith = @ReplaceWith(expression = "copy(capitalization = capitalization, autoCorrectEnabled = autoCorrect, keyboardType = keyboardType, imeAction = imeAction,platformImeOptions = platformImeOptions, showKeyboardOnFocus = showKeyboardOnFocus ?: true,hintLocales = hintLocales)", imports = {}))
    /* JADX INFO: renamed from: copy-INvB4aQ, reason: not valid java name */
    public final KeyboardOptions m1191copyINvB4aQ(int capitalization, boolean autoCorrect, int keyboardType, int imeAction, PlatformImeOptions platformImeOptions, Boolean showKeyboardOnFocus, LocaleList hintLocales) {
        return new KeyboardOptions(capitalization, Boolean.valueOf(autoCorrect), keyboardType, imeAction, platformImeOptions, showKeyboardOnFocus, hintLocales, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: renamed from: copy-H-u8-rc$default, reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m1182copyHu8rc$default(KeyboardOptions keyboardOptions, int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions, Boolean bool, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = keyboardOptions.capitalization;
        }
        return keyboardOptions.m1189copyHu8rc(i, (i4 & 2) != 0 ? keyboardOptions.getAutoCorrectOrDefault() : z, (i4 & 4) != 0 ? keyboardOptions.keyboardType : i2, (i4 & 8) != 0 ? keyboardOptions.imeAction : i3, (i4 & 16) != 0 ? keyboardOptions.platformImeOptions : platformImeOptions, (i4 & 32) != 0 ? keyboardOptions.showKeyboardOnFocus : bool);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: copy-H-u8-rc, reason: not valid java name */
    public final /* synthetic */ KeyboardOptions m1189copyHu8rc(int capitalization, boolean autoCorrect, int keyboardType, int imeAction, PlatformImeOptions platformImeOptions, Boolean showKeyboardOnFocus) {
        return new KeyboardOptions(capitalization, Boolean.valueOf(autoCorrect), keyboardType, imeAction, platformImeOptions, showKeyboardOnFocus, this.hintLocales, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: renamed from: copy-ij11fho$default, reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m1185copyij11fho$default(KeyboardOptions keyboardOptions, int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = keyboardOptions.capitalization;
        }
        return keyboardOptions.m1192copyij11fho(i, (i4 & 2) != 0 ? keyboardOptions.getAutoCorrectOrDefault() : z, (i4 & 4) != 0 ? keyboardOptions.keyboardType : i2, (i4 & 8) != 0 ? keyboardOptions.imeAction : i3, (i4 & 16) != 0 ? keyboardOptions.platformImeOptions : platformImeOptions);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: copy-ij11fho, reason: not valid java name */
    public final /* synthetic */ KeyboardOptions m1192copyij11fho(int capitalization, boolean autoCorrect, int keyboardType, int imeAction, PlatformImeOptions platformImeOptions) {
        return new KeyboardOptions(capitalization, Boolean.valueOf(autoCorrect), keyboardType, imeAction, platformImeOptions, this.showKeyboardOnFocus, this.hintLocales, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: renamed from: copy-3m2b7yw$default, reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m1181copy3m2b7yw$default(KeyboardOptions keyboardOptions, int i, boolean z, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = keyboardOptions.capitalization;
        }
        if ((i4 & 2) != 0) {
            z = keyboardOptions.getAutoCorrectOrDefault();
        }
        if ((i4 & 4) != 0) {
            i2 = keyboardOptions.keyboardType;
        }
        if ((i4 & 8) != 0) {
            i3 = keyboardOptions.imeAction;
        }
        return keyboardOptions.m1188copy3m2b7yw(i, z, i2, i3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new copy function that takes optional platformImeOptions parameter.")
    /* JADX INFO: renamed from: copy-3m2b7yw, reason: not valid java name */
    public final /* synthetic */ KeyboardOptions m1188copy3m2b7yw(int capitalization, boolean autoCorrect, int keyboardType, int imeAction) {
        return new KeyboardOptions(capitalization, Boolean.valueOf(autoCorrect), keyboardType, imeAction, this.platformImeOptions, this.showKeyboardOnFocus, this.hintLocales, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof KeyboardOptions) && KeyboardCapitalization.m6455equalsimpl0(this.capitalization, ((KeyboardOptions) other).capitalization) && Intrinsics.areEqual(this.autoCorrectEnabled, ((KeyboardOptions) other).autoCorrectEnabled) && KeyboardType.m6472equalsimpl0(this.keyboardType, ((KeyboardOptions) other).keyboardType) && ImeAction.m6419equalsimpl0(this.imeAction, ((KeyboardOptions) other).imeAction) && Intrinsics.areEqual(this.platformImeOptions, ((KeyboardOptions) other).platformImeOptions) && Intrinsics.areEqual(this.showKeyboardOnFocus, ((KeyboardOptions) other).showKeyboardOnFocus) && Intrinsics.areEqual(this.hintLocales, ((KeyboardOptions) other).hintLocales);
    }

    public int hashCode() {
        int result = KeyboardCapitalization.m6456hashCodeimpl(this.capitalization);
        int i = result * 31;
        Boolean bool = this.autoCorrectEnabled;
        int result2 = i + (bool != null ? bool.hashCode() : 0);
        int result3 = ((((result2 * 31) + KeyboardType.m6473hashCodeimpl(this.keyboardType)) * 31) + ImeAction.m6420hashCodeimpl(this.imeAction)) * 31;
        PlatformImeOptions platformImeOptions = this.platformImeOptions;
        int result4 = (result3 + (platformImeOptions != null ? platformImeOptions.hashCode() : 0)) * 31;
        Boolean bool2 = this.showKeyboardOnFocus;
        int result5 = (result4 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        LocaleList localeList = this.hintLocales;
        return result5 + (localeList != null ? localeList.hashCode() : 0);
    }

    public String toString() {
        return "KeyboardOptions(capitalization=" + ((Object) KeyboardCapitalization.m6457toStringimpl(this.capitalization)) + ", autoCorrectEnabled=" + this.autoCorrectEnabled + ", keyboardType=" + ((Object) KeyboardType.m6474toStringimpl(this.keyboardType)) + ", imeAction=" + ((Object) ImeAction.m6421toStringimpl(this.imeAction)) + ", platformImeOptions=" + this.platformImeOptions + "showKeyboardOnFocus=" + this.showKeyboardOnFocus + ", hintLocales=" + this.hintLocales + ')';
    }

    public final KeyboardOptions merge(KeyboardOptions other) {
        KeyboardOptions keyboardOptionsFillUnspecifiedValuesWith$foundation_release;
        return (other == null || (keyboardOptionsFillUnspecifiedValuesWith$foundation_release = other.fillUnspecifiedValuesWith$foundation_release(this)) == null) ? this : keyboardOptionsFillUnspecifiedValuesWith$foundation_release;
    }

    public final KeyboardOptions fillUnspecifiedValuesWith$foundation_release(KeyboardOptions other) {
        Boolean bool;
        PlatformImeOptions platformImeOptions;
        Boolean bool2;
        LocaleList localeList;
        if (other == null || other.isCompletelyUnspecified() || Intrinsics.areEqual(other, this)) {
            return this;
        }
        if (isCompletelyUnspecified()) {
            return other;
        }
        KeyboardCapitalization keyboardCapitalizationM6452boximpl = KeyboardCapitalization.m6452boximpl(this.capitalization);
        int it = keyboardCapitalizationM6452boximpl.getValue();
        if (KeyboardCapitalization.m6455equalsimpl0(it, KeyboardCapitalization.INSTANCE.m6467getUnspecifiedIUNYP9k())) {
            keyboardCapitalizationM6452boximpl = null;
        }
        int value = keyboardCapitalizationM6452boximpl != null ? keyboardCapitalizationM6452boximpl.getValue() : other.capitalization;
        Boolean bool3 = this.autoCorrectEnabled;
        if (bool3 != null) {
            bool = bool3;
        } else {
            bool = other.autoCorrectEnabled;
        }
        KeyboardType keyboardTypeM6469boximpl = KeyboardType.m6469boximpl(this.keyboardType);
        int it2 = keyboardTypeM6469boximpl.getValue();
        if (KeyboardType.m6472equalsimpl0(it2, KeyboardType.INSTANCE.m6494getUnspecifiedPjHm6EE())) {
            keyboardTypeM6469boximpl = null;
        }
        int value2 = keyboardTypeM6469boximpl != null ? keyboardTypeM6469boximpl.getValue() : other.keyboardType;
        ImeAction imeActionM6416boximpl = ImeAction.m6416boximpl(this.imeAction);
        int it3 = imeActionM6416boximpl.getValue();
        ImeAction imeAction = ImeAction.m6419equalsimpl0(it3, ImeAction.INSTANCE.m6440getUnspecifiedeUduSuo()) ? null : imeActionM6416boximpl;
        int value3 = imeAction != null ? imeAction.getValue() : other.imeAction;
        PlatformImeOptions platformImeOptions2 = this.platformImeOptions;
        if (platformImeOptions2 != null) {
            platformImeOptions = platformImeOptions2;
        } else {
            platformImeOptions = other.platformImeOptions;
        }
        Boolean bool4 = this.showKeyboardOnFocus;
        if (bool4 != null) {
            bool2 = bool4;
        } else {
            bool2 = other.showKeyboardOnFocus;
        }
        LocaleList localeList2 = this.hintLocales;
        if (localeList2 != null) {
            localeList = localeList2;
        } else {
            localeList = other.hintLocales;
        }
        return new KeyboardOptions(value, bool, value2, value3, platformImeOptions, bool2, localeList, (DefaultConstructorMarker) null);
    }
}
