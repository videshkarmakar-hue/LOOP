package androidx.compose.p001ui.text;

import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.Shadow;
import androidx.compose.p001ui.graphics.drawscope.DrawStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontSynthesis;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.text.intl.Locale;
import androidx.compose.p001ui.text.intl.LocaleList;
import androidx.compose.p001ui.text.style.BaselineShift;
import androidx.compose.p001ui.text.style.LineHeightStyle;
import androidx.compose.p001ui.text.style.TextAlign;
import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.p001ui.text.style.TextDirection;
import androidx.compose.p001ui.text.style.TextGeometricTransform;
import androidx.compose.p001ui.text.style.TextIndent;
import androidx.compose.p001ui.text.style.TextMotion;
import androidx.compose.p001ui.unit.TextUnit;
import androidx.compose.p001ui.unit.TextUnitKt;
import androidx.compose.p001ui.unit.TextUnitType;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000æ\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aL\u0010N\u001a\u0004\u0018\u0001HO\"\u0014\b\u0000\u0010P*\u000e\u0012\u0004\u0012\u0002HQ\u0012\u0004\u0012\u0002HR0\u0001\"\u0004\b\u0001\u0010Q\"\u0004\b\u0002\u0010R\"\u0006\b\u0003\u0010O\u0018\u00012\b\u0010S\u001a\u0004\u0018\u0001HR2\u0006\u0010T\u001a\u0002HPH\u0080\b¢\u0006\u0002\u0010U\u001a\"\u0010N\u001a\u0004\u0018\u0001HO\"\u0006\b\u0000\u0010O\u0018\u00012\b\u0010S\u001a\u0004\u0018\u00010\u0003H\u0080\b¢\u0006\u0002\u0010V\u001aI\u0010W\u001a\u00020\u0003\"\u0014\b\u0000\u0010P*\u000e\u0012\u0004\u0012\u0002HQ\u0012\u0004\u0012\u0002HR0\u0001\"\u0004\b\u0001\u0010Q\"\u0004\b\u0002\u0010R2\b\u0010S\u001a\u0004\u0018\u0001HQ2\u0006\u0010T\u001a\u0002HP2\u0006\u0010X\u001a\u00020YH\u0000¢\u0006\u0002\u0010Z\u001a\u001f\u0010W\u001a\u0004\u0018\u0001HP\"\u0004\b\u0000\u0010P2\b\u0010S\u001a\u0004\u0018\u0001HPH\u0000¢\u0006\u0002\u0010V\" \u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"(\u0010\u0006\u001a\u001c\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\b0\u0007\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"(\u0010\t\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\b\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000b\"\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00030\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0005\"\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010!\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00030\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0005\"\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010(\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010*\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010,\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b.\u0010\u000b\" \u0010/\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b1\u0010\u000b\"\u001a\u00102\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00030\u0001*\u0002058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b6\u00107\"$\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030\u0001*\u0002088@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b6\u00109\"$\u00104\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00030\u0001*\u00020:8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b6\u0010;\"$\u00104\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00030\u0001*\u00020<8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b6\u0010=\"$\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00030\u0001*\u00020>8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b6\u0010?\"$\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00030\u0001*\u00020@8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b6\u0010A\"$\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00030\u0001*\u00020B8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b6\u0010C\"$\u00104\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001*\u00020D8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b6\u0010E\"$\u00104\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00030\u0001*\u00020F8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b6\u0010G\"$\u00104\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00030\u0001*\u00020H8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b6\u0010I\"$\u00104\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00030\u0001*\u00020J8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b6\u0010K\"$\u00104\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00030\u0001*\u00020L8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b6\u0010M¨\u0006["}, m195d2 = {"AnnotatedStringSaver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/AnnotatedString;", "", "getAnnotatedStringSaver", "()Landroidx/compose/runtime/saveable/Saver;", "AnnotationRangeListSaver", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "AnnotationRangeSaver", "getAnnotationRangeSaver$annotations", "()V", "BaselineShiftSaver", "Landroidx/compose/ui/text/style/BaselineShift;", "ClickableSaver", "Landroidx/compose/ui/text/LinkAnnotation$Clickable;", "ColorSaver", "Landroidx/compose/ui/graphics/Color;", "FontWeightSaver", "Landroidx/compose/ui/text/font/FontWeight;", "LinkSaver", "Landroidx/compose/ui/text/LinkAnnotation$Url;", "LocaleListSaver", "Landroidx/compose/ui/text/intl/LocaleList;", "LocaleSaver", "Landroidx/compose/ui/text/intl/Locale;", "OffsetSaver", "Landroidx/compose/ui/geometry/Offset;", "ParagraphStyleSaver", "Landroidx/compose/ui/text/ParagraphStyle;", "getParagraphStyleSaver", "ShadowSaver", "Landroidx/compose/ui/graphics/Shadow;", "SpanStyleSaver", "Landroidx/compose/ui/text/SpanStyle;", "getSpanStyleSaver", "TextDecorationSaver", "Landroidx/compose/ui/text/style/TextDecoration;", "TextGeometricTransformSaver", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "TextIndentSaver", "Landroidx/compose/ui/text/style/TextIndent;", "TextRangeSaver", "Landroidx/compose/ui/text/TextRange;", "TextUnitSaver", "Landroidx/compose/ui/unit/TextUnit;", "getTextUnitSaver$annotations", "UrlAnnotationSaver", "Landroidx/compose/ui/text/UrlAnnotation;", "getUrlAnnotationSaver$annotations", "VerbatimTtsAnnotationSaver", "Landroidx/compose/ui/text/VerbatimTtsAnnotation;", "Saver", "Landroidx/compose/ui/geometry/Offset$Companion;", "getSaver", "(Landroidx/compose/ui/geometry/Offset$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/graphics/Color$Companion;", "(Landroidx/compose/ui/graphics/Color$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/graphics/Shadow$Companion;", "(Landroidx/compose/ui/graphics/Shadow$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/TextRange$Companion;", "(Landroidx/compose/ui/text/TextRange$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/font/FontWeight$Companion;", "(Landroidx/compose/ui/text/font/FontWeight$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/intl/Locale$Companion;", "(Landroidx/compose/ui/text/intl/Locale$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/intl/LocaleList$Companion;", "(Landroidx/compose/ui/text/intl/LocaleList$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/style/BaselineShift$Companion;", "(Landroidx/compose/ui/text/style/BaselineShift$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/style/TextDecoration$Companion;", "(Landroidx/compose/ui/text/style/TextDecoration$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/style/TextGeometricTransform$Companion;", "(Landroidx/compose/ui/text/style/TextGeometricTransform$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/style/TextIndent$Companion;", "(Landroidx/compose/ui/text/style/TextIndent$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/unit/TextUnit$Companion;", "(Landroidx/compose/ui/unit/TextUnit$Companion;)Landroidx/compose/runtime/saveable/Saver;", "restore", "Result", ExifInterface.GPS_DIRECTION_TRUE, "Original", "Saveable", DownloadUtil.CookieScheme.VALUE, "saver", "(Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;)Ljava/lang/Object;", "(Ljava/lang/Object;)Ljava/lang/Object;", "save", "scope", "Landroidx/compose/runtime/saveable/SaverScope;", "(Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;Landroidx/compose/runtime/saveable/SaverScope;)Ljava/lang/Object;", "ui-text_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SaversKt {
    private static final Saver<AnnotatedString, Object> AnnotatedStringSaver = SaverKt.Saver(new Function2<SaverScope, AnnotatedString, Object>() { // from class: androidx.compose.ui.text.SaversKt$AnnotatedStringSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope $this$Saver, AnnotatedString it) {
            return CollectionsKt.arrayListOf(SaversKt.save(it.getText()), SaversKt.save(it.getSpanStyles(), SaversKt.AnnotationRangeListSaver, $this$Saver), SaversKt.save(it.getParagraphStyles(), SaversKt.AnnotationRangeListSaver, $this$Saver), SaversKt.save(it.getAnnotations$ui_text_release(), SaversKt.AnnotationRangeListSaver, $this$Saver));
        }
    }, new Function1<Object, AnnotatedString>() { // from class: androidx.compose.ui.text.SaversKt$AnnotatedStringSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final AnnotatedString invoke(Object it) {
            List list;
            List list2;
            Intrinsics.checkNotNull(it, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list3 = (List) it;
            Object value$iv = list3.get(1);
            Saver saver$iv = SaversKt.AnnotationRangeListSaver;
            List list4 = null;
            List list5 = (Intrinsics.areEqual(value$iv, (Object) false) || value$iv == null) ? null : (List) saver$iv.restore(value$iv);
            List spanStylesOrNull = list5;
            Object value$iv2 = list3.get(2);
            Saver saver$iv2 = SaversKt.AnnotationRangeListSaver;
            List list6 = (Intrinsics.areEqual(value$iv2, (Object) false) || value$iv2 == null) ? null : (List) saver$iv2.restore(value$iv2);
            List paragraphStylesOrNull = list6;
            Object value$iv3 = list3.get(0);
            String str = value$iv3 != null ? (String) value$iv3 : null;
            Intrinsics.checkNotNull(str);
            if (spanStylesOrNull != null) {
                List list7 = spanStylesOrNull;
                if (list7.isEmpty()) {
                    list7 = null;
                }
                list = list7;
            } else {
                list = null;
            }
            if (paragraphStylesOrNull != null) {
                List list8 = paragraphStylesOrNull;
                if (list8.isEmpty()) {
                    list8 = null;
                }
                list2 = list8;
            } else {
                list2 = null;
            }
            Object value$iv4 = list3.get(3);
            Saver saver$iv3 = SaversKt.AnnotationRangeListSaver;
            if (!Intrinsics.areEqual(value$iv4, (Object) false) && value$iv4 != null) {
                list4 = (List) saver$iv3.restore(value$iv4);
            }
            return new AnnotatedString(str, list, list2, list4);
        }
    });
    private static final Saver<List<AnnotatedString.Range<? extends Object>>, Object> AnnotationRangeListSaver = SaverKt.Saver(new Function2<SaverScope, List<? extends AnnotatedString.Range<? extends Object>>, Object>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeListSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope $this$Saver, List<? extends AnnotatedString.Range<? extends Object>> list) {
            List target$iv = new ArrayList(list.size());
            int size = list.size();
            for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                Object item$iv$iv = list.get(index$iv$iv);
                target$iv.add(SaversKt.save((AnnotatedString.Range) item$iv$iv, SaversKt.AnnotationRangeSaver, $this$Saver));
            }
            List $this$fastMap$iv = target$iv;
            return $this$fastMap$iv;
        }
    }, new Function1<Object, List<? extends AnnotatedString.Range<? extends Object>>>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeListSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final List<? extends AnnotatedString.Range<? extends Object>> invoke(Object it) {
            Intrinsics.checkNotNull(it, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) it;
            ArrayList target$iv = new ArrayList(list.size());
            int size = list.size();
            for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                Object item$iv$iv = list.get(index$iv$iv);
                ArrayList arrayList = target$iv;
                Saver saver$iv = SaversKt.AnnotationRangeSaver;
                AnnotatedString.Range range = null;
                if (!Intrinsics.areEqual(item$iv$iv, (Object) false) && item$iv$iv != null) {
                    Object it$iv = saver$iv.restore(item$iv$iv);
                    range = (AnnotatedString.Range) it$iv;
                }
                Intrinsics.checkNotNull(range);
                AnnotatedString.Range range2 = range;
                arrayList.add(range2);
            }
            return target$iv;
        }
    });
    private static final Saver<AnnotatedString.Range<? extends Object>, Object> AnnotationRangeSaver = SaverKt.Saver(new Function2<SaverScope, AnnotatedString.Range<? extends Object>, Object>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeSaver$1

        /* JADX INFO: compiled from: Savers.kt */
        @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AnnotationType.values().length];
                try {
                    iArr[AnnotationType.Paragraph.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[AnnotationType.Span.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[AnnotationType.VerbatimTts.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[AnnotationType.Url.ordinal()] = 4;
                } catch (NoSuchFieldError e4) {
                }
                try {
                    iArr[AnnotationType.Link.ordinal()] = 5;
                } catch (NoSuchFieldError e5) {
                }
                try {
                    iArr[AnnotationType.Clickable.ordinal()] = 6;
                } catch (NoSuchFieldError e6) {
                }
                try {
                    iArr[AnnotationType.String.ordinal()] = 7;
                } catch (NoSuchFieldError e7) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope $this$Saver, AnnotatedString.Range<? extends Object> range) {
            AnnotationType marker;
            Object item;
            Object item2 = range.getItem();
            if (item2 instanceof ParagraphStyle) {
                marker = AnnotationType.Paragraph;
            } else if (item2 instanceof SpanStyle) {
                marker = AnnotationType.Span;
            } else if (item2 instanceof VerbatimTtsAnnotation) {
                marker = AnnotationType.VerbatimTts;
            } else if (item2 instanceof UrlAnnotation) {
                marker = AnnotationType.Url;
            } else if (item2 instanceof LinkAnnotation.Url) {
                marker = AnnotationType.Link;
            } else {
                marker = item2 instanceof LinkAnnotation.Clickable ? AnnotationType.Clickable : AnnotationType.String;
            }
            switch (WhenMappings.$EnumSwitchMapping$0[marker.ordinal()]) {
                case 1:
                    Object item3 = range.getItem();
                    Intrinsics.checkNotNull(item3, "null cannot be cast to non-null type androidx.compose.ui.text.ParagraphStyle");
                    item = SaversKt.save((ParagraphStyle) item3, SaversKt.getParagraphStyleSaver(), $this$Saver);
                    break;
                case 2:
                    Object item4 = range.getItem();
                    Intrinsics.checkNotNull(item4, "null cannot be cast to non-null type androidx.compose.ui.text.SpanStyle");
                    item = SaversKt.save((SpanStyle) item4, SaversKt.getSpanStyleSaver(), $this$Saver);
                    break;
                case 3:
                    Object item5 = range.getItem();
                    Intrinsics.checkNotNull(item5, "null cannot be cast to non-null type androidx.compose.ui.text.VerbatimTtsAnnotation");
                    item = SaversKt.save((VerbatimTtsAnnotation) item5, SaversKt.VerbatimTtsAnnotationSaver, $this$Saver);
                    break;
                case 4:
                    Object item6 = range.getItem();
                    Intrinsics.checkNotNull(item6, "null cannot be cast to non-null type androidx.compose.ui.text.UrlAnnotation");
                    item = SaversKt.save((UrlAnnotation) item6, SaversKt.UrlAnnotationSaver, $this$Saver);
                    break;
                case 5:
                    Object item7 = range.getItem();
                    Intrinsics.checkNotNull(item7, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Url");
                    item = SaversKt.save((LinkAnnotation.Url) item7, SaversKt.LinkSaver, $this$Saver);
                    break;
                case 6:
                    Object item8 = range.getItem();
                    Intrinsics.checkNotNull(item8, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Clickable");
                    item = SaversKt.save((LinkAnnotation.Clickable) item8, SaversKt.ClickableSaver, $this$Saver);
                    break;
                case 7:
                    item = SaversKt.save(range.getItem());
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            return CollectionsKt.arrayListOf(SaversKt.save(marker), item, SaversKt.save(Integer.valueOf(range.getStart())), SaversKt.save(Integer.valueOf(range.getEnd())), SaversKt.save(range.getTag()));
        }
    }, new Function1<Object, AnnotatedString.Range<? extends Object>>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeSaver$2

        /* JADX INFO: compiled from: Savers.kt */
        @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AnnotationType.values().length];
                try {
                    iArr[AnnotationType.Paragraph.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[AnnotationType.Span.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[AnnotationType.VerbatimTts.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[AnnotationType.Url.ordinal()] = 4;
                } catch (NoSuchFieldError e4) {
                }
                try {
                    iArr[AnnotationType.Link.ordinal()] = 5;
                } catch (NoSuchFieldError e5) {
                }
                try {
                    iArr[AnnotationType.Clickable.ordinal()] = 6;
                } catch (NoSuchFieldError e6) {
                }
                try {
                    iArr[AnnotationType.String.ordinal()] = 7;
                } catch (NoSuchFieldError e7) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final AnnotatedString.Range<? extends Object> invoke(Object it) {
            Object it$iv;
            Object it$iv2;
            String str;
            Intrinsics.checkNotNull(it, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) it;
            Object value$iv = list.get(0);
            Object it$iv3 = null;
            AnnotationType annotationType = value$iv != null ? (AnnotationType) value$iv : null;
            Intrinsics.checkNotNull(annotationType);
            AnnotationType marker = annotationType;
            Object value$iv2 = list.get(2);
            if (value$iv2 == null) {
                it$iv = null;
            } else {
                it$iv = (Integer) value$iv2;
            }
            Intrinsics.checkNotNull(it$iv);
            int start = ((Number) it$iv).intValue();
            Object value$iv3 = list.get(3);
            if (value$iv3 == null) {
                it$iv2 = null;
            } else {
                it$iv2 = (Integer) value$iv3;
            }
            Intrinsics.checkNotNull(it$iv2);
            int end = ((Number) it$iv2).intValue();
            Object value$iv4 = list.get(4);
            if (value$iv4 == null) {
                str = null;
            } else {
                str = (String) value$iv4;
            }
            Intrinsics.checkNotNull(str);
            String tag = str;
            switch (WhenMappings.$EnumSwitchMapping$0[marker.ordinal()]) {
                case 1:
                    Object value$iv5 = list.get(1);
                    Saver<ParagraphStyle, Object> paragraphStyleSaver = SaversKt.getParagraphStyleSaver();
                    if (!Intrinsics.areEqual(value$iv5, (Object) false) && value$iv5 != null) {
                        it$iv3 = paragraphStyleSaver.restore(value$iv5);
                    }
                    Intrinsics.checkNotNull(it$iv3);
                    return new AnnotatedString.Range<>(it$iv3, start, end, tag);
                case 2:
                    Object value$iv6 = list.get(1);
                    Saver<SpanStyle, Object> spanStyleSaver = SaversKt.getSpanStyleSaver();
                    if (!Intrinsics.areEqual(value$iv6, (Object) false) && value$iv6 != null) {
                        it$iv3 = spanStyleSaver.restore(value$iv6);
                    }
                    Intrinsics.checkNotNull(it$iv3);
                    return new AnnotatedString.Range<>(it$iv3, start, end, tag);
                case 3:
                    Object value$iv7 = list.get(1);
                    Saver saver$iv = SaversKt.VerbatimTtsAnnotationSaver;
                    if (!Intrinsics.areEqual(value$iv7, (Object) false) && value$iv7 != null) {
                        it$iv3 = (VerbatimTtsAnnotation) saver$iv.restore(value$iv7);
                    }
                    Intrinsics.checkNotNull(it$iv3);
                    return new AnnotatedString.Range<>(it$iv3, start, end, tag);
                case 4:
                    Object value$iv8 = list.get(1);
                    Saver saver$iv2 = SaversKt.UrlAnnotationSaver;
                    if (!Intrinsics.areEqual(value$iv8, (Object) false) && value$iv8 != null) {
                        it$iv3 = (UrlAnnotation) saver$iv2.restore(value$iv8);
                    }
                    Intrinsics.checkNotNull(it$iv3);
                    return new AnnotatedString.Range<>(it$iv3, start, end, tag);
                case 5:
                    Object value$iv9 = list.get(1);
                    Saver saver$iv3 = SaversKt.LinkSaver;
                    if (!Intrinsics.areEqual(value$iv9, (Object) false) && value$iv9 != null) {
                        it$iv3 = (LinkAnnotation.Url) saver$iv3.restore(value$iv9);
                    }
                    Intrinsics.checkNotNull(it$iv3);
                    return new AnnotatedString.Range<>(it$iv3, start, end, tag);
                case 6:
                    Object value$iv10 = list.get(1);
                    Saver saver$iv4 = SaversKt.ClickableSaver;
                    if (!Intrinsics.areEqual(value$iv10, (Object) false) && value$iv10 != null) {
                        it$iv3 = (LinkAnnotation.Clickable) saver$iv4.restore(value$iv10);
                    }
                    Intrinsics.checkNotNull(it$iv3);
                    return new AnnotatedString.Range<>(it$iv3, start, end, tag);
                case 7:
                    Object value$iv11 = list.get(1);
                    if (value$iv11 != null) {
                        it$iv3 = (String) value$iv11;
                    }
                    Intrinsics.checkNotNull(it$iv3);
                    return new AnnotatedString.Range<>(it$iv3, start, end, tag);
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    });
    private static final Saver<VerbatimTtsAnnotation, Object> VerbatimTtsAnnotationSaver = SaverKt.Saver(new Function2<SaverScope, VerbatimTtsAnnotation, Object>() { // from class: androidx.compose.ui.text.SaversKt$VerbatimTtsAnnotationSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope $this$Saver, VerbatimTtsAnnotation it) {
            return SaversKt.save(it.getVerbatim());
        }
    }, new Function1<Object, VerbatimTtsAnnotation>() { // from class: androidx.compose.ui.text.SaversKt$VerbatimTtsAnnotationSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final VerbatimTtsAnnotation invoke(Object it) {
            String str = it != null ? (String) it : null;
            Intrinsics.checkNotNull(str);
            return new VerbatimTtsAnnotation(str);
        }
    });
    private static final Saver<UrlAnnotation, Object> UrlAnnotationSaver = SaverKt.Saver(new Function2<SaverScope, UrlAnnotation, Object>() { // from class: androidx.compose.ui.text.SaversKt$UrlAnnotationSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope $this$Saver, UrlAnnotation it) {
            return SaversKt.save(it.getUrl());
        }
    }, new Function1<Object, UrlAnnotation>() { // from class: androidx.compose.ui.text.SaversKt$UrlAnnotationSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final UrlAnnotation invoke(Object it) {
            String str = it != null ? (String) it : null;
            Intrinsics.checkNotNull(str);
            return new UrlAnnotation(str);
        }
    });
    private static final Saver<LinkAnnotation.Url, Object> LinkSaver = SaverKt.Saver(new Function2<SaverScope, LinkAnnotation.Url, Object>() { // from class: androidx.compose.ui.text.SaversKt$LinkSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope $this$Saver, LinkAnnotation.Url it) {
            return SaversKt.save(it.getUrl());
        }
    }, new Function1<Object, LinkAnnotation.Url>() { // from class: androidx.compose.ui.text.SaversKt$LinkSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final LinkAnnotation.Url invoke(Object it) {
            String str = it != null ? (String) it : null;
            Intrinsics.checkNotNull(str);
            return new LinkAnnotation.Url(str);
        }
    });
    private static final Saver<LinkAnnotation.Clickable, Object> ClickableSaver = SaverKt.Saver(new Function2<SaverScope, LinkAnnotation.Clickable, Object>() { // from class: androidx.compose.ui.text.SaversKt$ClickableSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope $this$Saver, LinkAnnotation.Clickable it) {
            return SaversKt.save(it.getTag());
        }
    }, new Function1<Object, LinkAnnotation.Clickable>() { // from class: androidx.compose.ui.text.SaversKt$ClickableSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final LinkAnnotation.Clickable invoke(Object it) {
            String str = it != null ? (String) it : null;
            Intrinsics.checkNotNull(str);
            return new LinkAnnotation.Clickable(str);
        }
    });
    private static final Saver<ParagraphStyle, Object> ParagraphStyleSaver = SaverKt.Saver(new Function2<SaverScope, ParagraphStyle, Object>() { // from class: androidx.compose.ui.text.SaversKt$ParagraphStyleSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope $this$Saver, ParagraphStyle it) {
            return CollectionsKt.arrayListOf(SaversKt.save(TextAlign.m6651boximpl(it.getTextAlign())), SaversKt.save(TextDirection.m6665boximpl(it.getTextDirection())), SaversKt.save(TextUnit.m6988boximpl(it.getLineHeight()), SaversKt.getSaver(TextUnit.INSTANCE), $this$Saver), SaversKt.save(it.getTextIndent(), SaversKt.getSaver(TextIndent.INSTANCE), $this$Saver));
        }
    }, new Function1<Object, ParagraphStyle>() { // from class: androidx.compose.ui.text.SaversKt$ParagraphStyleSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final ParagraphStyle invoke(Object it) {
            TextDirection textDirection;
            Intrinsics.checkNotNull(it, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) it;
            Object value$iv = list.get(0);
            TextAlign textAlign = value$iv != null ? (TextAlign) value$iv : null;
            Intrinsics.checkNotNull(textAlign);
            int value = textAlign.getValue();
            Object value$iv2 = list.get(1);
            if (value$iv2 == null) {
                textDirection = null;
            } else {
                textDirection = (TextDirection) value$iv2;
            }
            Intrinsics.checkNotNull(textDirection);
            int value2 = textDirection.getValue();
            Object value$iv3 = list.get(2);
            TextUnit textUnitRestore = (Intrinsics.areEqual(value$iv3, (Object) false) || value$iv3 == null) ? null : SaversKt.getSaver(TextUnit.INSTANCE).restore(value$iv3);
            Intrinsics.checkNotNull(textUnitRestore);
            long packedValue = textUnitRestore.getPackedValue();
            Object value$iv4 = list.get(3);
            TextIndent textIndentRestore = (Intrinsics.areEqual(value$iv4, (Object) false) || value$iv4 == null) ? null : SaversKt.getSaver(TextIndent.INSTANCE).restore(value$iv4);
            return new ParagraphStyle(value, value2, packedValue, textIndentRestore, (PlatformParagraphStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 496, (DefaultConstructorMarker) null);
        }
    });
    private static final Saver<SpanStyle, Object> SpanStyleSaver = SaverKt.Saver(new Function2<SaverScope, SpanStyle, Object>() { // from class: androidx.compose.ui.text.SaversKt$SpanStyleSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope $this$Saver, SpanStyle it) {
            return CollectionsKt.arrayListOf(SaversKt.save(Color.m4281boximpl(it.m6199getColor0d7_KjU()), SaversKt.getSaver(Color.INSTANCE), $this$Saver), SaversKt.save(TextUnit.m6988boximpl(it.getFontSize()), SaversKt.getSaver(TextUnit.INSTANCE), $this$Saver), SaversKt.save(it.getFontWeight(), SaversKt.getSaver(FontWeight.INSTANCE), $this$Saver), SaversKt.save(it.getFontStyle()), SaversKt.save(it.getFontSynthesis()), SaversKt.save(-1), SaversKt.save(it.getFontFeatureSettings()), SaversKt.save(TextUnit.m6988boximpl(it.getLetterSpacing()), SaversKt.getSaver(TextUnit.INSTANCE), $this$Saver), SaversKt.save(it.getBaselineShift(), SaversKt.getSaver(BaselineShift.INSTANCE), $this$Saver), SaversKt.save(it.getTextGeometricTransform(), SaversKt.getSaver(TextGeometricTransform.INSTANCE), $this$Saver), SaversKt.save(it.getLocaleList(), SaversKt.getSaver(LocaleList.INSTANCE), $this$Saver), SaversKt.save(Color.m4281boximpl(it.getBackground()), SaversKt.getSaver(Color.INSTANCE), $this$Saver), SaversKt.save(it.getTextDecoration(), SaversKt.getSaver(TextDecoration.INSTANCE), $this$Saver), SaversKt.save(it.getShadow(), SaversKt.getSaver(Shadow.INSTANCE), $this$Saver));
        }
    }, new Function1<Object, SpanStyle>() { // from class: androidx.compose.ui.text.SaversKt$SpanStyleSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final SpanStyle invoke(Object it) {
            Intrinsics.checkNotNull(it, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) it;
            Object value$iv = list.get(0);
            Color colorRestore = (Intrinsics.areEqual(value$iv, (Object) false) || value$iv == null) ? null : SaversKt.getSaver(Color.INSTANCE).restore(value$iv);
            Intrinsics.checkNotNull(colorRestore);
            long jM4301unboximpl = colorRestore.m4301unboximpl();
            Object value$iv2 = list.get(1);
            TextUnit textUnitRestore = (Intrinsics.areEqual(value$iv2, (Object) false) || value$iv2 == null) ? null : SaversKt.getSaver(TextUnit.INSTANCE).restore(value$iv2);
            Intrinsics.checkNotNull(textUnitRestore);
            long packedValue = textUnitRestore.getPackedValue();
            Object value$iv3 = list.get(2);
            FontWeight fontWeightRestore = (Intrinsics.areEqual(value$iv3, (Object) false) || value$iv3 == null) ? null : SaversKt.getSaver(FontWeight.INSTANCE).restore(value$iv3);
            Object value$iv4 = list.get(3);
            FontStyle fontStyle = value$iv4 != null ? (FontStyle) value$iv4 : null;
            Object value$iv5 = list.get(4);
            FontSynthesis fontSynthesis = value$iv5 != null ? (FontSynthesis) value$iv5 : null;
            Object value$iv6 = list.get(6);
            String str = value$iv6 != null ? (String) value$iv6 : null;
            Object value$iv7 = list.get(7);
            TextUnit textUnitRestore2 = (Intrinsics.areEqual(value$iv7, (Object) false) || value$iv7 == null) ? null : SaversKt.getSaver(TextUnit.INSTANCE).restore(value$iv7);
            Intrinsics.checkNotNull(textUnitRestore2);
            long packedValue2 = textUnitRestore2.getPackedValue();
            Object value$iv8 = list.get(8);
            BaselineShift baselineShiftRestore = (Intrinsics.areEqual(value$iv8, (Object) false) || value$iv8 == null) ? null : SaversKt.getSaver(BaselineShift.INSTANCE).restore(value$iv8);
            Object value$iv9 = list.get(9);
            TextGeometricTransform textGeometricTransformRestore = (Intrinsics.areEqual(value$iv9, (Object) false) || value$iv9 == null) ? null : SaversKt.getSaver(TextGeometricTransform.INSTANCE).restore(value$iv9);
            Object value$iv10 = list.get(10);
            LocaleList localeListRestore = (Intrinsics.areEqual(value$iv10, (Object) false) || value$iv10 == null) ? null : SaversKt.getSaver(LocaleList.INSTANCE).restore(value$iv10);
            Object value$iv11 = list.get(11);
            Color colorRestore2 = (Intrinsics.areEqual(value$iv11, (Object) false) || value$iv11 == null) ? null : SaversKt.getSaver(Color.INSTANCE).restore(value$iv11);
            Intrinsics.checkNotNull(colorRestore2);
            long jM4301unboximpl2 = colorRestore2.m4301unboximpl();
            Object value$iv12 = list.get(12);
            TextDecoration textDecorationRestore = (Intrinsics.areEqual(value$iv12, (Object) false) || value$iv12 == null) ? null : SaversKt.getSaver(TextDecoration.INSTANCE).restore(value$iv12);
            Object value$iv13 = list.get(13);
            Shadow shadowRestore = (Intrinsics.areEqual(value$iv13, (Object) false) || value$iv13 == null) ? null : SaversKt.getSaver(Shadow.INSTANCE).restore(value$iv13);
            return new SpanStyle(jM4301unboximpl, packedValue, fontWeightRestore, fontStyle, fontSynthesis, (FontFamily) null, str, packedValue2, baselineShiftRestore, textGeometricTransformRestore, localeListRestore, jM4301unboximpl2, textDecorationRestore, shadowRestore, (PlatformSpanStyle) null, (DrawStyle) null, 49184, (DefaultConstructorMarker) null);
        }
    });
    private static final Saver<TextDecoration, Object> TextDecorationSaver = SaverKt.Saver(new Function2<SaverScope, TextDecoration, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextDecorationSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope $this$Saver, TextDecoration it) {
            return Integer.valueOf(it.getMask());
        }
    }, new Function1<Object, TextDecoration>() { // from class: androidx.compose.ui.text.SaversKt$TextDecorationSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final TextDecoration invoke(Object it) {
            Intrinsics.checkNotNull(it, "null cannot be cast to non-null type kotlin.Int");
            return new TextDecoration(((Integer) it).intValue());
        }
    });
    private static final Saver<TextGeometricTransform, Object> TextGeometricTransformSaver = SaverKt.Saver(new Function2<SaverScope, TextGeometricTransform, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextGeometricTransformSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope $this$Saver, TextGeometricTransform it) {
            return CollectionsKt.arrayListOf(Float.valueOf(it.getScaleX()), Float.valueOf(it.getSkewX()));
        }
    }, new Function1<Object, TextGeometricTransform>() { // from class: androidx.compose.ui.text.SaversKt$TextGeometricTransformSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final TextGeometricTransform invoke(Object it) {
            Intrinsics.checkNotNull(it, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Float>");
            List list = (List) it;
            return new TextGeometricTransform(((Number) list.get(0)).floatValue(), ((Number) list.get(1)).floatValue());
        }
    });
    private static final Saver<TextIndent, Object> TextIndentSaver = SaverKt.Saver(new Function2<SaverScope, TextIndent, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextIndentSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope $this$Saver, TextIndent it) {
            return CollectionsKt.arrayListOf(SaversKt.save(TextUnit.m6988boximpl(it.getFirstLine()), SaversKt.getSaver(TextUnit.INSTANCE), $this$Saver), SaversKt.save(TextUnit.m6988boximpl(it.getRestLine()), SaversKt.getSaver(TextUnit.INSTANCE), $this$Saver));
        }
    }, new Function1<Object, TextIndent>() { // from class: androidx.compose.ui.text.SaversKt$TextIndentSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final TextIndent invoke(Object it) {
            Intrinsics.checkNotNull(it, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) it;
            Object value$iv = list.get(0);
            TextUnit textUnitRestore = null;
            TextUnit textUnitRestore2 = (Intrinsics.areEqual(value$iv, (Object) false) || value$iv == null) ? null : SaversKt.getSaver(TextUnit.INSTANCE).restore(value$iv);
            Intrinsics.checkNotNull(textUnitRestore2);
            long packedValue = textUnitRestore2.getPackedValue();
            Object value$iv2 = list.get(1);
            Saver<TextUnit, Object> saver = SaversKt.getSaver(TextUnit.INSTANCE);
            if (!Intrinsics.areEqual(value$iv2, (Object) false) && value$iv2 != null) {
                textUnitRestore = saver.restore(value$iv2);
            }
            Intrinsics.checkNotNull(textUnitRestore);
            return new TextIndent(packedValue, textUnitRestore.getPackedValue(), null);
        }
    });
    private static final Saver<FontWeight, Object> FontWeightSaver = SaverKt.Saver(new Function2<SaverScope, FontWeight, Object>() { // from class: androidx.compose.ui.text.SaversKt$FontWeightSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope $this$Saver, FontWeight it) {
            return Integer.valueOf(it.getWeight());
        }
    }, new Function1<Object, FontWeight>() { // from class: androidx.compose.ui.text.SaversKt$FontWeightSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final FontWeight invoke(Object it) {
            Intrinsics.checkNotNull(it, "null cannot be cast to non-null type kotlin.Int");
            return new FontWeight(((Integer) it).intValue());
        }
    });
    private static final Saver<BaselineShift, Object> BaselineShiftSaver = SaverKt.Saver(new Function2<SaverScope, BaselineShift, Object>() { // from class: androidx.compose.ui.text.SaversKt$BaselineShiftSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SaverScope saverScope, BaselineShift baselineShift) {
            return m6179invoke8a2Sb4w(saverScope, baselineShift.m6548unboximpl());
        }

        /* JADX INFO: renamed from: invoke-8a2Sb4w, reason: not valid java name */
        public final Object m6179invoke8a2Sb4w(SaverScope $this$Saver, float it) {
            return Float.valueOf(it);
        }
    }, new Function1<Object, BaselineShift>() { // from class: androidx.compose.ui.text.SaversKt$BaselineShiftSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke-jTk7eUs, reason: not valid java name and merged with bridge method [inline-methods] */
        public final BaselineShift invoke(Object it) {
            Intrinsics.checkNotNull(it, "null cannot be cast to non-null type kotlin.Float");
            return BaselineShift.m6542boximpl(BaselineShift.m6543constructorimpl(((Float) it).floatValue()));
        }
    });
    private static final Saver<TextRange, Object> TextRangeSaver = SaverKt.Saver(new Function2<SaverScope, TextRange, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextRangeSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SaverScope saverScope, TextRange textRange) {
            return m6185invokeFDrldGo(saverScope, textRange.getPackedValue());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: invoke-FDrldGo, reason: not valid java name */
        public final Object m6185invokeFDrldGo(SaverScope $this$Saver, long it) {
            return CollectionsKt.arrayListOf(SaversKt.save(Integer.valueOf(TextRange.m6251getStartimpl(it))), SaversKt.save(Integer.valueOf(TextRange.m6246getEndimpl(it))));
        }
    }, new Function1<Object, TextRange>() { // from class: androidx.compose.ui.text.SaversKt$TextRangeSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke-VqIyPBM, reason: not valid java name and merged with bridge method [inline-methods] */
        public final TextRange invoke(Object it) {
            Intrinsics.checkNotNull(it, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) it;
            Object value$iv = list.get(0);
            Object it$iv = value$iv != null ? (Integer) value$iv : null;
            Intrinsics.checkNotNull(it$iv);
            int iIntValue = ((Number) it$iv).intValue();
            Object value$iv2 = list.get(1);
            Object it$iv2 = value$iv2 != null ? (Integer) value$iv2 : null;
            Intrinsics.checkNotNull(it$iv2);
            return TextRange.m6239boximpl(TextRangeKt.TextRange(iIntValue, ((Number) it$iv2).intValue()));
        }
    });
    private static final Saver<Shadow, Object> ShadowSaver = SaverKt.Saver(new Function2<SaverScope, Shadow, Object>() { // from class: androidx.compose.ui.text.SaversKt$ShadowSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope $this$Saver, Shadow it) {
            return CollectionsKt.arrayListOf(SaversKt.save(Color.m4281boximpl(it.getColor()), SaversKt.getSaver(Color.INSTANCE), $this$Saver), SaversKt.save(Offset.m4038boximpl(it.getOffset()), SaversKt.getSaver(Offset.INSTANCE), $this$Saver), SaversKt.save(Float.valueOf(it.getBlurRadius())));
        }
    }, new Function1<Object, Shadow>() { // from class: androidx.compose.ui.text.SaversKt$ShadowSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Shadow invoke(Object it) {
            Intrinsics.checkNotNull(it, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) it;
            Object value$iv = list.get(0);
            Color colorRestore = (Intrinsics.areEqual(value$iv, (Object) false) || value$iv == null) ? null : SaversKt.getSaver(Color.INSTANCE).restore(value$iv);
            Intrinsics.checkNotNull(colorRestore);
            long jM4301unboximpl = colorRestore.m4301unboximpl();
            Object value$iv2 = list.get(1);
            Offset offsetRestore = (Intrinsics.areEqual(value$iv2, (Object) false) || value$iv2 == null) ? null : SaversKt.getSaver(Offset.INSTANCE).restore(value$iv2);
            Intrinsics.checkNotNull(offsetRestore);
            long packedValue = offsetRestore.getPackedValue();
            Object value$iv3 = list.get(2);
            Float f = value$iv3 != null ? (Float) value$iv3 : null;
            Intrinsics.checkNotNull(f);
            return new Shadow(jM4301unboximpl, packedValue, f.floatValue(), null);
        }
    });
    private static final Saver<Color, Object> ColorSaver = SaverKt.Saver(new Function2<SaverScope, Color, Object>() { // from class: androidx.compose.ui.text.SaversKt$ColorSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SaverScope saverScope, Color color) {
            return m6181invoke4WTKRHQ(saverScope, color.m4301unboximpl());
        }

        /* JADX INFO: renamed from: invoke-4WTKRHQ, reason: not valid java name */
        public final Object m6181invoke4WTKRHQ(SaverScope $this$Saver, long it) {
            return ULong.m7861boximpl(it);
        }
    }, new Function1<Object, Color>() { // from class: androidx.compose.ui.text.SaversKt$ColorSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke-ijrfgN4, reason: not valid java name and merged with bridge method [inline-methods] */
        public final Color invoke(Object it) {
            Intrinsics.checkNotNull(it, "null cannot be cast to non-null type kotlin.ULong");
            return Color.m4281boximpl(Color.m4287constructorimpl(((ULong) it).getData()));
        }
    });
    private static final Saver<TextUnit, Object> TextUnitSaver = SaverKt.Saver(new Function2<SaverScope, TextUnit, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextUnitSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SaverScope saverScope, TextUnit textUnit) {
            return m6187invokempE4wyQ(saverScope, textUnit.getPackedValue());
        }

        /* JADX INFO: renamed from: invoke-mpE4wyQ, reason: not valid java name */
        public final Object m6187invokempE4wyQ(SaverScope $this$Saver, long it) {
            return CollectionsKt.arrayListOf(SaversKt.save(Float.valueOf(TextUnit.m6998getValueimpl(it))), SaversKt.save(TextUnitType.m7023boximpl(TextUnit.m6997getTypeUIouoOA(it))));
        }
    }, new Function1<Object, TextUnit>() { // from class: androidx.compose.ui.text.SaversKt$TextUnitSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke-XNhUCwk, reason: not valid java name and merged with bridge method [inline-methods] */
        public final TextUnit invoke(Object it) {
            Intrinsics.checkNotNull(it, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) it;
            Object value$iv = list.get(0);
            Object it$iv = value$iv != null ? (Float) value$iv : null;
            Intrinsics.checkNotNull(it$iv);
            float fFloatValue = ((Number) it$iv).floatValue();
            Object value$iv2 = list.get(1);
            TextUnitType textUnitType = value$iv2 != null ? (TextUnitType) value$iv2 : null;
            Intrinsics.checkNotNull(textUnitType);
            return TextUnit.m6988boximpl(TextUnitKt.m7010TextUnitanM5pPY(fFloatValue, textUnitType.getType()));
        }
    });
    private static final Saver<Offset, Object> OffsetSaver = SaverKt.Saver(new Function2<SaverScope, Offset, Object>() { // from class: androidx.compose.ui.text.SaversKt$OffsetSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SaverScope saverScope, Offset offset) {
            return m6183invokeUv8p0NA(saverScope, offset.getPackedValue());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: invoke-Uv8p0NA, reason: not valid java name */
        public final Object m6183invokeUv8p0NA(SaverScope $this$Saver, long it) {
            return Offset.m4046equalsimpl0(it, Offset.INSTANCE.m4064getUnspecifiedF1C5BW0()) ? (Serializable) false : CollectionsKt.arrayListOf(SaversKt.save(Float.valueOf(Offset.m4049getXimpl(it))), SaversKt.save(Float.valueOf(Offset.m4050getYimpl(it))));
        }
    }, new Function1<Object, Offset>() { // from class: androidx.compose.ui.text.SaversKt$OffsetSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke-x-9fifI, reason: not valid java name and merged with bridge method [inline-methods] */
        public final Offset invoke(Object it) {
            if (Intrinsics.areEqual(it, (Object) false)) {
                return Offset.m4038boximpl(Offset.INSTANCE.m4064getUnspecifiedF1C5BW0());
            }
            Intrinsics.checkNotNull(it, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) it;
            Object value$iv = list.get(0);
            Object it$iv = value$iv != null ? (Float) value$iv : null;
            Intrinsics.checkNotNull(it$iv);
            float fFloatValue = ((Number) it$iv).floatValue();
            Object value$iv2 = list.get(1);
            Object it$iv2 = value$iv2 != null ? (Float) value$iv2 : null;
            Intrinsics.checkNotNull(it$iv2);
            return Offset.m4038boximpl(OffsetKt.Offset(fFloatValue, ((Number) it$iv2).floatValue()));
        }
    });
    private static final Saver<LocaleList, Object> LocaleListSaver = SaverKt.Saver(new Function2<SaverScope, LocaleList, Object>() { // from class: androidx.compose.ui.text.SaversKt$LocaleListSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope $this$Saver, LocaleList it) {
            List<Locale> localeList = it.getLocaleList();
            List target$iv = new ArrayList(localeList.size());
            int size = localeList.size();
            for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                Object item$iv$iv = localeList.get(index$iv$iv);
                Locale locale = (Locale) item$iv$iv;
                target$iv.add(SaversKt.save(locale, SaversKt.getSaver(Locale.INSTANCE), $this$Saver));
            }
            List $this$fastMap$iv = target$iv;
            return $this$fastMap$iv;
        }
    }, new Function1<Object, LocaleList>() { // from class: androidx.compose.ui.text.SaversKt$LocaleListSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final LocaleList invoke(Object it) {
            Locale locale;
            Intrinsics.checkNotNull(it, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) it;
            ArrayList target$iv = new ArrayList(list.size());
            int size = list.size();
            for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                Object item$iv$iv = list.get(index$iv$iv);
                ArrayList arrayList = target$iv;
                Saver<Locale, Object> saver = SaversKt.getSaver(Locale.INSTANCE);
                if (Intrinsics.areEqual(item$iv$iv, (Object) false)) {
                    locale = null;
                } else if (item$iv$iv != null) {
                    Object it$iv = saver.restore(item$iv$iv);
                    locale = (Locale) it$iv;
                } else {
                    locale = null;
                }
                Intrinsics.checkNotNull(locale);
                arrayList.add(locale);
            }
            return new LocaleList(target$iv);
        }
    });
    private static final Saver<Locale, Object> LocaleSaver = SaverKt.Saver(new Function2<SaverScope, Locale, Object>() { // from class: androidx.compose.ui.text.SaversKt$LocaleSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope $this$Saver, Locale it) {
            return it.toLanguageTag();
        }
    }, new Function1<Object, Locale>() { // from class: androidx.compose.ui.text.SaversKt$LocaleSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Locale invoke(Object it) {
            Intrinsics.checkNotNull(it, "null cannot be cast to non-null type kotlin.String");
            return new Locale((String) it);
        }
    });

    private static /* synthetic */ void getAnnotationRangeSaver$annotations() {
    }

    private static /* synthetic */ void getTextUnitSaver$annotations() {
    }

    private static /* synthetic */ void getUrlAnnotationSaver$annotations() {
    }

    public static final <T extends Saver<Original, Saveable>, Original, Saveable> Object save(Original original, T t, SaverScope scope) {
        Object objSave;
        if (original == null || (objSave = t.save(scope, original)) == null) {
            return false;
        }
        return objSave;
    }

    public static final /* synthetic */ <T extends Saver<Original, Saveable>, Original, Saveable, Result> Result restore(Saveable saveable, T t) {
        if (Intrinsics.areEqual((Object) saveable, (Object) false) || saveable == null) {
            return null;
        }
        Result result = (Result) t.restore(saveable);
        Intrinsics.reifiedOperationMarker(1, "Result");
        return result;
    }

    public static final <T> T save(T t) {
        return t;
    }

    public static final /* synthetic */ <Result> Result restore(Object obj) {
        if (obj == null) {
            return null;
        }
        Intrinsics.reifiedOperationMarker(1, "Result");
        return (Result) obj;
    }

    public static final Saver<AnnotatedString, Object> getAnnotatedStringSaver() {
        return AnnotatedStringSaver;
    }

    public static final Saver<ParagraphStyle, Object> getParagraphStyleSaver() {
        return ParagraphStyleSaver;
    }

    public static final Saver<SpanStyle, Object> getSpanStyleSaver() {
        return SpanStyleSaver;
    }

    public static final Saver<TextDecoration, Object> getSaver(TextDecoration.Companion $this$Saver) {
        return TextDecorationSaver;
    }

    public static final Saver<TextGeometricTransform, Object> getSaver(TextGeometricTransform.Companion $this$Saver) {
        return TextGeometricTransformSaver;
    }

    public static final Saver<TextIndent, Object> getSaver(TextIndent.Companion $this$Saver) {
        return TextIndentSaver;
    }

    public static final Saver<FontWeight, Object> getSaver(FontWeight.Companion $this$Saver) {
        return FontWeightSaver;
    }

    public static final Saver<BaselineShift, Object> getSaver(BaselineShift.Companion $this$Saver) {
        return BaselineShiftSaver;
    }

    public static final Saver<TextRange, Object> getSaver(TextRange.Companion $this$Saver) {
        return TextRangeSaver;
    }

    public static final Saver<Shadow, Object> getSaver(Shadow.Companion $this$Saver) {
        return ShadowSaver;
    }

    public static final Saver<Color, Object> getSaver(Color.Companion $this$Saver) {
        return ColorSaver;
    }

    public static final Saver<TextUnit, Object> getSaver(TextUnit.Companion $this$Saver) {
        return TextUnitSaver;
    }

    public static final Saver<Offset, Object> getSaver(Offset.Companion $this$Saver) {
        return OffsetSaver;
    }

    public static final Saver<LocaleList, Object> getSaver(LocaleList.Companion $this$Saver) {
        return LocaleListSaver;
    }

    public static final Saver<Locale, Object> getSaver(Locale.Companion $this$Saver) {
        return LocaleSaver;
    }
}
