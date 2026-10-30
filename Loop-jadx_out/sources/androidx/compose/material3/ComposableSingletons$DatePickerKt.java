package androidx.compose.material3;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeftKt;
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRightKt;
import androidx.compose.material.icons.filled.DateRangeKt;
import androidx.compose.material.icons.filled.EditKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.vector.ImageVector;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: DatePicker.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$DatePickerKt {
    public static final ComposableSingletons$DatePickerKt INSTANCE = new ComposableSingletons$DatePickerKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f646lambda1 = ComposableLambdaKt.composableLambdaInstance(1244569435, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ComposableSingletons$DatePickerKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C1379@62038L46,1377@61946L152:DatePicker.kt#uh7d8r");
            if (($changed & 3) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1244569435, $changed, -1, "androidx.compose.material3.ComposableSingletons$DatePickerKt.lambda-1.<anonymous> (DatePicker.kt:1377)");
                }
                ImageVector edit = EditKt.getEdit(Icons.Filled.INSTANCE);
                Strings.Companion companion = Strings.INSTANCE;
                IconKt.m2292Iconww6aTOc(edit, Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_date_picker_switch_to_input_mode), $composer, 0), (Modifier) null, 0L, $composer, 0, 12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f647lambda2 = ComposableLambdaKt.composableLambdaInstance(668820324, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ComposableSingletons$DatePickerKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C1386@62328L49,1384@62231L160:DatePicker.kt#uh7d8r");
            if (($changed & 3) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(668820324, $changed, -1, "androidx.compose.material3.ComposableSingletons$DatePickerKt.lambda-2.<anonymous> (DatePicker.kt:1384)");
                }
                ImageVector dateRange = DateRangeKt.getDateRange(Icons.Filled.INSTANCE);
                Strings.Companion companion = Strings.INSTANCE;
                IconKt.m2292Iconww6aTOc(dateRange, Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_date_picker_switch_to_calendar_mode), $composer, 0), (Modifier) null, 0L, $composer, 0, 12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f648lambda3 = ComposableLambdaKt.composableLambdaInstance(1233169686, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ComposableSingletons$DatePickerKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C2187@94710L50,2185@94582L204:DatePicker.kt#uh7d8r");
            if (($changed & 3) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1233169686, $changed, -1, "androidx.compose.material3.ComposableSingletons$DatePickerKt.lambda-3.<anonymous> (DatePicker.kt:2185)");
                }
                ImageVector keyboardArrowLeft = KeyboardArrowLeftKt.getKeyboardArrowLeft(Icons.AutoMirrored.Filled.INSTANCE);
                Strings.Companion companion = Strings.INSTANCE;
                IconKt.m2292Iconww6aTOc(keyboardArrowLeft, Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_date_picker_switch_to_previous_month), $composer, 0), (Modifier) null, 0L, $composer, 0, 12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f649lambda4 = ComposableLambdaKt.composableLambdaInstance(412350847, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ComposableSingletons$DatePickerKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C2193@95045L46,2191@94916L201:DatePicker.kt#uh7d8r");
            if (($changed & 3) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(412350847, $changed, -1, "androidx.compose.material3.ComposableSingletons$DatePickerKt.lambda-4.<anonymous> (DatePicker.kt:2191)");
                }
                ImageVector keyboardArrowRight = KeyboardArrowRightKt.getKeyboardArrowRight(Icons.AutoMirrored.Filled.INSTANCE);
                Strings.Companion companion = Strings.INSTANCE;
                IconKt.m2292Iconww6aTOc(keyboardArrowRight, Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_date_picker_switch_to_next_month), $composer, 0), (Modifier) null, 0L, $composer, 0, 12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: getLambda-1$material3_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2113getLambda1$material3_release() {
        return f646lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$material3_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2114getLambda2$material3_release() {
        return f647lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$material3_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2115getLambda3$material3_release() {
        return f648lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$material3_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2116getLambda4$material3_release() {
        return f649lambda4;
    }
}
