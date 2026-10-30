package com.videshkarmakar.loop.util;

import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.caverock.androidsvg.SVGParser;
import com.videshkarmakar.loop.p006ui.common.Route;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: VideoInfo.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m194d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0003\b\u0093\u0001\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ç\u00012\u00020\u0001:\u0004æ\u0001ç\u0001B¯\u0005\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\t\u0018\u00010\u0010\u0012\u001c\b\u0001\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\t\u0018\u00010\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\t\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010#\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010(\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010*\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010+\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010-\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u00100\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u00101\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0001\u00102\u001a\u0004\u0018\u00010\u0014\u0012\b\u00103\u001a\u0004\u0018\u00010\u0014\u0012\b\u00104\u001a\u0004\u0018\u00010\u0014\u0012\b\u00105\u001a\u0004\u0018\u00010\u0014\u0012\b\u00106\u001a\u0004\u0018\u00010\u0006\u0012\b\u00107\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0001\u00108\u001a\u0004\u0018\u00010\u0006\u0012\b\u00109\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010:\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010;\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010<\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010=\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010>\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0001\u0010?\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\t\u0012\u0010\b\u0001\u0010A\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010B\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010C\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010D\u001a\u0004\u0018\u00010E¢\u0006\u0002\u0010FBÃ\u0005\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\u001a\b\u0002\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\t0\u0010\u0012\u001a\b\u0002\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\t0\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\t\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010%\u001a\u00020\u0006\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010.\u001a\u00020\u0006\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010?\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\t\u0012\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010GJ\n\u0010 \u0001\u001a\u00020\u0006HÆ\u0003J\u0011\u0010¡\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010IJ\u0012\u0010¢\u0001\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0003\u0010\u0097\u0001J\f\u0010£\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0012\u0010¤\u0001\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tHÆ\u0003J\f\u0010¥\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010¦\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010NJ\u0012\u0010§\u0001\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\tHÆ\u0003J\u0011\u0010¨\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010NJ\f\u0010©\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010ª\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\n\u0010«\u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010¬\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010®\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010¯\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010°\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\n\u0010±\u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010²\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010³\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010NJ\f\u0010´\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010µ\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0012\u0010¶\u0001\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\f\u0010·\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010¸\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010¹\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010º\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\n\u0010»\u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010¼\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010½\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010¾\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010IJ\u0011\u0010¿\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010IJ\u0011\u0010À\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010IJ\f\u0010Á\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010Â\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010IJ\u0011\u0010Ã\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010IJ\f\u0010Ä\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010Å\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010IJ\f\u0010Æ\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010Ç\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010È\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010IJ\f\u0010É\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010IJ\u0011\u0010Ë\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010NJ\f\u0010Ì\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010Í\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010NJ\u0012\u0010Î\u0001\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\tHÆ\u0003J\u0012\u0010Ï\u0001\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\f\u0010Ð\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010Ò\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010Ó\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u001c\u0010Ô\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\t0\u0010HÆ\u0003J\u001c\u0010Õ\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\t0\u0010HÆ\u0003JÎ\u0005\u0010Ö\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u001a\b\u0002\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\t0\u00102\u001a\b\u0002\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\t0\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\t2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010%\u001a\u00020\u00062\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010.\u001a\u00020\u00062\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010?\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\t2\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0003\u0010×\u0001J\u0017\u0010Ø\u0001\u001a\u00030Ù\u00012\n\u0010Ú\u0001\u001a\u0005\u0018\u00010Û\u0001HÖ\u0003J\n\u0010Ü\u0001\u001a\u00020\u0003HÖ\u0001J\n\u0010Ý\u0001\u001a\u00020\u0006HÖ\u0001J.\u0010Þ\u0001\u001a\u00030ß\u00012\u0007\u0010à\u0001\u001a\u00020\u00002\b\u0010á\u0001\u001a\u00030â\u00012\b\u0010ã\u0001\u001a\u00030ä\u0001HÁ\u0001¢\u0006\u0003\bå\u0001R\u0015\u0010<\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010J\u001a\u0004\bH\u0010IR\u0013\u0010;\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0015\u0010=\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010O\u001a\u0004\bM\u0010NR.\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\t0\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u0013\u0010 \u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bT\u0010LR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bU\u0010LR\u0019\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR \u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010O\u0012\u0004\bX\u0010Q\u001a\u0004\bY\u0010NR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010LR\u001e\u0010(\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b[\u0010Q\u001a\u0004\b\\\u0010LR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010J\u001a\u0004\b]\u0010IR\u001e\u0010*\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b^\u0010Q\u001a\u0004\b_\u0010LR\u001e\u00108\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b`\u0010Q\u001a\u0004\ba\u0010LR\u0015\u0010>\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010O\u001a\u0004\bb\u0010NR\u0011\u0010.\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bc\u0010LR\u0013\u0010$\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bd\u0010LR\u001c\u0010%\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\be\u0010Q\u001a\u0004\bf\u0010LR \u00102\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010J\u0012\u0004\bg\u0010Q\u001a\u0004\bh\u0010IR \u00101\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010J\u0012\u0004\bi\u0010Q\u001a\u0004\bj\u0010IR\u0013\u0010B\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bk\u0010LR\u0013\u0010,\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bl\u0010LR\u001e\u0010-\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bm\u0010Q\u001a\u0004\bn\u0010LR\u001e\u00100\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bo\u0010Q\u001a\u0004\bp\u0010LR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bq\u0010WR\u0015\u00107\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010J\u001a\u0004\br\u0010IR\u0013\u0010)\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bs\u0010LR\u0015\u00105\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010J\u001a\u0004\bt\u0010IR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bu\u0010LR \u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010O\u0012\u0004\bv\u0010Q\u001a\u0004\bw\u0010NR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bx\u0010Q\u001a\u0004\by\u0010LR\u001e\u0010!\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bz\u0010Q\u001a\u0004\b{\u0010LR\u0013\u0010&\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b|\u0010LR \u0010'\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010O\u0012\u0004\b}\u0010Q\u001a\u0004\b~\u0010NR\u0013\u0010/\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010LR \u0010+\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0080\u0001\u0010Q\u001a\u0005\b\u0081\u0001\u0010LR&\u0010?\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0082\u0001\u0010Q\u001a\u0005\b\u0083\u0001\u0010WR&\u0010A\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0084\u0001\u0010Q\u001a\u0005\b\u0085\u0001\u0010WR\u0014\u00106\u001a\u0004\u0018\u00010\u0006¢\u0006\t\n\u0000\u001a\u0005\b\u0086\u0001\u0010LR$\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\t0\u0010¢\u0006\t\n\u0000\u001a\u0005\b\u0087\u0001\u0010SR\u001a\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b\u0088\u0001\u0010WR\u0016\u00103\u001a\u0004\u0018\u00010\u0014¢\u0006\u000b\n\u0002\u0010J\u001a\u0005\b\u0089\u0001\u0010IR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\t\n\u0000\u001a\u0005\b\u008a\u0001\u0010LR\u0012\u0010\u0007\u001a\u00020\u0006¢\u0006\t\n\u0000\u001a\u0005\b\u008b\u0001\u0010LR \u0010C\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u008c\u0001\u0010Q\u001a\u0005\b\u008d\u0001\u0010LR \u0010\u001f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u008e\u0001\u0010Q\u001a\u0005\b\u008f\u0001\u0010LR\u0014\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\t\n\u0000\u001a\u0005\b\u0090\u0001\u0010LR \u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0091\u0001\u0010Q\u001a\u0005\b\u0092\u0001\u0010LR\u0016\u0010:\u001a\u0004\u0018\u00010\u0014¢\u0006\u000b\n\u0002\u0010J\u001a\u0005\b\u0093\u0001\u0010IR\u0014\u00109\u001a\u0004\u0018\u00010\u0006¢\u0006\t\n\u0000\u001a\u0005\b\u0094\u0001\u0010LR$\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\u0014\n\u0003\u0010\u0098\u0001\u0012\u0005\b\u0095\u0001\u0010Q\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R \u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0099\u0001\u0010Q\u001a\u0005\b\u009a\u0001\u0010LR \u0010\"\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u009b\u0001\u0010Q\u001a\u0005\b\u009c\u0001\u0010LR \u0010#\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u009d\u0001\u0010Q\u001a\u0005\b\u009e\u0001\u0010LR\u0016\u00104\u001a\u0004\u0018\u00010\u0014¢\u0006\u000b\n\u0002\u0010J\u001a\u0005\b\u009f\u0001\u0010I¨\u0006è\u0001"}, m195d2 = {"Lcom/videshkarmakar/loop/util/VideoInfo;", "Lcom/videshkarmakar/loop/util/YoutubeDLInfo;", "seen1", "", "seen2", "id", "", "title", "formats", "", "Lcom/videshkarmakar/loop/util/Format;", "thumbnail", "description", "uploader", "uploaderId", "subtitles", "", "Lcom/videshkarmakar/loop/util/SubtitleFormat;", "automaticCaptions", "duration", "", "viewCount", "", "webpageUrl", "tags", "liveStatus", "commentCount", "chapters", "Lcom/videshkarmakar/loop/util/Chapter;", "likeCount", "channel", "uploadDate", "availability", "originalUrl", "webpageUrlBasename", "webpageUrlDomain", "extractor", "extractorKey", "playlist", "playlistIndex", "displayId", "fulltitle", "durationString", "releaseDate", Route.FORMAT_SELECTION, "formatId", "ext", "protocol", "formatNote", "fileSizeApprox", "fileSize", "tbr", "width", "height", "resolution", "fps", "dynamicRange", "vcodec", "vbr", "acodec", "abr", "asr", "epoch", "requestedDownloads", "Lcom/videshkarmakar/loop/util/RequestedDownload;", "requestedFormats", "filename", SVGParser.XML_STYLESHEET_ATTR_TYPE, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getAbr", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getAcodec", "()Ljava/lang/String;", "getAsr", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAutomaticCaptions$annotations", "()V", "getAutomaticCaptions", "()Ljava/util/Map;", "getAvailability", "getChannel", "getChapters", "()Ljava/util/List;", "getCommentCount$annotations", "getCommentCount", "getDescription", "getDisplayId$annotations", "getDisplayId", "getDuration", "getDurationString$annotations", "getDurationString", "getDynamicRange$annotations", "getDynamicRange", "getEpoch", "getExt", "getExtractor", "getExtractorKey$annotations", "getExtractorKey", "getFileSize$annotations", "getFileSize", "getFileSizeApprox$annotations", "getFileSizeApprox", "getFilename", "getFormat", "getFormatId$annotations", "getFormatId", "getFormatNote$annotations", "getFormatNote", "getFormats", "getFps", "getFulltitle", "getHeight", "getId", "getLikeCount$annotations", "getLikeCount", "getLiveStatus$annotations", "getLiveStatus", "getOriginalUrl$annotations", "getOriginalUrl", "getPlaylist", "getPlaylistIndex$annotations", "getPlaylistIndex", "getProtocol", "getReleaseDate$annotations", "getReleaseDate", "getRequestedDownloads$annotations", "getRequestedDownloads", "getRequestedFormats$annotations", "getRequestedFormats", "getResolution", "getSubtitles", "getTags", "getTbr", "getThumbnail", "getTitle", "getType$annotations", "getType", "getUploadDate$annotations", "getUploadDate", "getUploader", "getUploaderId$annotations", "getUploaderId", "getVbr", "getVcodec", "getViewCount$annotations", "getViewCount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getWebpageUrl$annotations", "getWebpageUrl", "getWebpageUrlBasename$annotations", "getWebpageUrlBasename", "getWebpageUrlDomain$annotations", "getWebpageUrlDomain", "getWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/videshkarmakar/loop/util/VideoInfo;", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_debug", "$serializer", "Companion", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
public final /* data */ class VideoInfo implements YoutubeDLInfo {
    private final Double abr;
    private final String acodec;
    private final Integer asr;
    private final Map<String, List<SubtitleFormat>> automaticCaptions;
    private final String availability;
    private final String channel;
    private final List<Chapter> chapters;
    private final Integer commentCount;
    private final String description;
    private final String displayId;
    private final Double duration;
    private final String durationString;
    private final String dynamicRange;
    private final Integer epoch;
    private final String ext;
    private final String extractor;
    private final String extractorKey;
    private final Double fileSize;
    private final Double fileSizeApprox;
    private final String filename;
    private final String format;
    private final String formatId;
    private final String formatNote;
    private final List<Format> formats;
    private final Double fps;
    private final String fulltitle;
    private final Double height;
    private final String id;
    private final Integer likeCount;
    private final String liveStatus;
    private final String originalUrl;
    private final String playlist;
    private final Integer playlistIndex;
    private final String protocol;
    private final String releaseDate;
    private final List<RequestedDownload> requestedDownloads;
    private final List<Format> requestedFormats;
    private final String resolution;
    private final Map<String, List<SubtitleFormat>> subtitles;
    private final List<String> tags;
    private final Double tbr;
    private final String thumbnail;
    private final String title;
    private final String type;
    private final String uploadDate;
    private final String uploader;
    private final String uploaderId;
    private final Double vbr;
    private final String vcodec;
    private final Long viewCount;
    private final String webpageUrl;
    private final String webpageUrlBasename;
    private final String webpageUrlDomain;
    private final Double width;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(Format$$serializer.INSTANCE), null, null, null, null, new LinkedHashMapSerializer(StringSerializer.INSTANCE, new ArrayListSerializer(SubtitleFormat$$serializer.INSTANCE)), new LinkedHashMapSerializer(StringSerializer.INSTANCE, new ArrayListSerializer(SubtitleFormat$$serializer.INSTANCE)), null, null, null, new ArrayListSerializer(StringSerializer.INSTANCE), null, null, new ArrayListSerializer(Chapter$$serializer.INSTANCE), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new ArrayListSerializer(RequestedDownload$$serializer.INSTANCE), new ArrayListSerializer(Format$$serializer.INSTANCE), null, null};

    public VideoInfo() {
        this((String) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (Map) null, (Map) null, (Double) null, (Long) null, (String) null, (List) null, (String) null, (Integer) null, (List) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Double) null, (Double) null, (Double) null, (Double) null, (Double) null, (String) null, (Double) null, (String) null, (String) null, (Double) null, (String) null, (Double) null, (Integer) null, (Integer) null, (List) null, (List) null, (String) null, (String) null, -1, 4194303, (DefaultConstructorMarker) null);
    }

    @SerialName("automatic_captions")
    public static /* synthetic */ void getAutomaticCaptions$annotations() {
    }

    @SerialName("comment_count")
    public static /* synthetic */ void getCommentCount$annotations() {
    }

    @SerialName("display_id")
    public static /* synthetic */ void getDisplayId$annotations() {
    }

    @SerialName("duration_string")
    public static /* synthetic */ void getDurationString$annotations() {
    }

    @SerialName("dynamic_range")
    public static /* synthetic */ void getDynamicRange$annotations() {
    }

    @SerialName("extractor_key")
    public static /* synthetic */ void getExtractorKey$annotations() {
    }

    @SerialName("filesize")
    public static /* synthetic */ void getFileSize$annotations() {
    }

    @SerialName("filesize_approx")
    public static /* synthetic */ void getFileSizeApprox$annotations() {
    }

    @SerialName("format_id")
    public static /* synthetic */ void getFormatId$annotations() {
    }

    @SerialName("format_note")
    public static /* synthetic */ void getFormatNote$annotations() {
    }

    @SerialName("like_count")
    public static /* synthetic */ void getLikeCount$annotations() {
    }

    @SerialName("live_status")
    public static /* synthetic */ void getLiveStatus$annotations() {
    }

    @SerialName("original_url")
    public static /* synthetic */ void getOriginalUrl$annotations() {
    }

    @SerialName("playlist_index")
    public static /* synthetic */ void getPlaylistIndex$annotations() {
    }

    @SerialName("release_date")
    public static /* synthetic */ void getReleaseDate$annotations() {
    }

    @SerialName("requested_downloads")
    public static /* synthetic */ void getRequestedDownloads$annotations() {
    }

    @SerialName("requested_formats")
    public static /* synthetic */ void getRequestedFormats$annotations() {
    }

    @SerialName("_type")
    public static /* synthetic */ void getType$annotations() {
    }

    @SerialName("upload_date")
    public static /* synthetic */ void getUploadDate$annotations() {
    }

    @SerialName("uploader_id")
    public static /* synthetic */ void getUploaderId$annotations() {
    }

    @SerialName("view_count")
    public static /* synthetic */ void getViewCount$annotations() {
    }

    @SerialName("webpage_url")
    public static /* synthetic */ void getWebpageUrl$annotations() {
    }

    @SerialName("webpage_url_basename")
    public static /* synthetic */ void getWebpageUrlBasename$annotations() {
    }

    @SerialName("webpage_url_domain")
    public static /* synthetic */ void getWebpageUrlDomain$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Double getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Long getViewCount() {
        return this.viewCount;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getWebpageUrl() {
        return this.webpageUrl;
    }

    public final List<String> component13() {
        return this.tags;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getLiveStatus() {
        return this.liveStatus;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Integer getCommentCount() {
        return this.commentCount;
    }

    public final List<Chapter> component16() {
        return this.chapters;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Integer getLikeCount() {
        return this.likeCount;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getUploadDate() {
        return this.uploadDate;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getAvailability() {
        return this.availability;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getOriginalUrl() {
        return this.originalUrl;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getWebpageUrlBasename() {
        return this.webpageUrlBasename;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getWebpageUrlDomain() {
        return this.webpageUrlDomain;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final String getExtractor() {
        return this.extractor;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final String getExtractorKey() {
        return this.extractorKey;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final String getPlaylist() {
        return this.playlist;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final Integer getPlaylistIndex() {
        return this.playlistIndex;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final String getDisplayId() {
        return this.displayId;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final String getFulltitle() {
        return this.fulltitle;
    }

    public final List<Format> component3() {
        return this.formats;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final String getDurationString() {
        return this.durationString;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final String getReleaseDate() {
        return this.releaseDate;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final String getFormat() {
        return this.format;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final String getFormatId() {
        return this.formatId;
    }

    /* JADX INFO: renamed from: component34, reason: from getter */
    public final String getExt() {
        return this.ext;
    }

    /* JADX INFO: renamed from: component35, reason: from getter */
    public final String getProtocol() {
        return this.protocol;
    }

    /* JADX INFO: renamed from: component36, reason: from getter */
    public final String getFormatNote() {
        return this.formatNote;
    }

    /* JADX INFO: renamed from: component37, reason: from getter */
    public final Double getFileSizeApprox() {
        return this.fileSizeApprox;
    }

    /* JADX INFO: renamed from: component38, reason: from getter */
    public final Double getFileSize() {
        return this.fileSize;
    }

    /* JADX INFO: renamed from: component39, reason: from getter */
    public final Double getTbr() {
        return this.tbr;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getThumbnail() {
        return this.thumbnail;
    }

    /* JADX INFO: renamed from: component40, reason: from getter */
    public final Double getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component41, reason: from getter */
    public final Double getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component42, reason: from getter */
    public final String getResolution() {
        return this.resolution;
    }

    /* JADX INFO: renamed from: component43, reason: from getter */
    public final Double getFps() {
        return this.fps;
    }

    /* JADX INFO: renamed from: component44, reason: from getter */
    public final String getDynamicRange() {
        return this.dynamicRange;
    }

    /* JADX INFO: renamed from: component45, reason: from getter */
    public final String getVcodec() {
        return this.vcodec;
    }

    /* JADX INFO: renamed from: component46, reason: from getter */
    public final Double getVbr() {
        return this.vbr;
    }

    /* JADX INFO: renamed from: component47, reason: from getter */
    public final String getAcodec() {
        return this.acodec;
    }

    /* JADX INFO: renamed from: component48, reason: from getter */
    public final Double getAbr() {
        return this.abr;
    }

    /* JADX INFO: renamed from: component49, reason: from getter */
    public final Integer getAsr() {
        return this.asr;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component50, reason: from getter */
    public final Integer getEpoch() {
        return this.epoch;
    }

    public final List<RequestedDownload> component51() {
        return this.requestedDownloads;
    }

    public final List<Format> component52() {
        return this.requestedFormats;
    }

    /* JADX INFO: renamed from: component53, reason: from getter */
    public final String getFilename() {
        return this.filename;
    }

    /* JADX INFO: renamed from: component54, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getUploader() {
        return this.uploader;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getUploaderId() {
        return this.uploaderId;
    }

    public final Map<String, List<SubtitleFormat>> component8() {
        return this.subtitles;
    }

    public final Map<String, List<SubtitleFormat>> component9() {
        return this.automaticCaptions;
    }

    public final VideoInfo copy(String id, String title, List<Format> formats, String thumbnail, String description, String uploader, String uploaderId, Map<String, ? extends List<SubtitleFormat>> subtitles, Map<String, ? extends List<SubtitleFormat>> automaticCaptions, Double duration, Long viewCount, String webpageUrl, List<String> tags, String liveStatus, Integer commentCount, List<Chapter> chapters, Integer likeCount, String channel, String uploadDate, String availability, String originalUrl, String webpageUrlBasename, String webpageUrlDomain, String extractor, String extractorKey, String playlist, Integer playlistIndex, String displayId, String fulltitle, String durationString, String releaseDate, String format, String formatId, String ext, String protocol, String formatNote, Double fileSizeApprox, Double fileSize, Double tbr, Double width, Double height, String resolution, Double fps, String dynamicRange, String vcodec, Double vbr, String acodec, Double abr, Integer asr, Integer epoch, List<RequestedDownload> requestedDownloads, List<Format> requestedFormats, String filename, String type) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitles, "subtitles");
        Intrinsics.checkNotNullParameter(automaticCaptions, "automaticCaptions");
        Intrinsics.checkNotNullParameter(extractorKey, "extractorKey");
        Intrinsics.checkNotNullParameter(ext, "ext");
        return new VideoInfo(id, title, formats, thumbnail, description, uploader, uploaderId, subtitles, automaticCaptions, duration, viewCount, webpageUrl, tags, liveStatus, commentCount, chapters, likeCount, channel, uploadDate, availability, originalUrl, webpageUrlBasename, webpageUrlDomain, extractor, extractorKey, playlist, playlistIndex, displayId, fulltitle, durationString, releaseDate, format, formatId, ext, protocol, formatNote, fileSizeApprox, fileSize, tbr, width, height, resolution, fps, dynamicRange, vcodec, vbr, acodec, abr, asr, epoch, requestedDownloads, requestedFormats, filename, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoInfo)) {
            return false;
        }
        VideoInfo videoInfo = (VideoInfo) other;
        return Intrinsics.areEqual(this.id, videoInfo.id) && Intrinsics.areEqual(this.title, videoInfo.title) && Intrinsics.areEqual(this.formats, videoInfo.formats) && Intrinsics.areEqual(this.thumbnail, videoInfo.thumbnail) && Intrinsics.areEqual(this.description, videoInfo.description) && Intrinsics.areEqual(this.uploader, videoInfo.uploader) && Intrinsics.areEqual(this.uploaderId, videoInfo.uploaderId) && Intrinsics.areEqual(this.subtitles, videoInfo.subtitles) && Intrinsics.areEqual(this.automaticCaptions, videoInfo.automaticCaptions) && Intrinsics.areEqual((Object) this.duration, (Object) videoInfo.duration) && Intrinsics.areEqual(this.viewCount, videoInfo.viewCount) && Intrinsics.areEqual(this.webpageUrl, videoInfo.webpageUrl) && Intrinsics.areEqual(this.tags, videoInfo.tags) && Intrinsics.areEqual(this.liveStatus, videoInfo.liveStatus) && Intrinsics.areEqual(this.commentCount, videoInfo.commentCount) && Intrinsics.areEqual(this.chapters, videoInfo.chapters) && Intrinsics.areEqual(this.likeCount, videoInfo.likeCount) && Intrinsics.areEqual(this.channel, videoInfo.channel) && Intrinsics.areEqual(this.uploadDate, videoInfo.uploadDate) && Intrinsics.areEqual(this.availability, videoInfo.availability) && Intrinsics.areEqual(this.originalUrl, videoInfo.originalUrl) && Intrinsics.areEqual(this.webpageUrlBasename, videoInfo.webpageUrlBasename) && Intrinsics.areEqual(this.webpageUrlDomain, videoInfo.webpageUrlDomain) && Intrinsics.areEqual(this.extractor, videoInfo.extractor) && Intrinsics.areEqual(this.extractorKey, videoInfo.extractorKey) && Intrinsics.areEqual(this.playlist, videoInfo.playlist) && Intrinsics.areEqual(this.playlistIndex, videoInfo.playlistIndex) && Intrinsics.areEqual(this.displayId, videoInfo.displayId) && Intrinsics.areEqual(this.fulltitle, videoInfo.fulltitle) && Intrinsics.areEqual(this.durationString, videoInfo.durationString) && Intrinsics.areEqual(this.releaseDate, videoInfo.releaseDate) && Intrinsics.areEqual(this.format, videoInfo.format) && Intrinsics.areEqual(this.formatId, videoInfo.formatId) && Intrinsics.areEqual(this.ext, videoInfo.ext) && Intrinsics.areEqual(this.protocol, videoInfo.protocol) && Intrinsics.areEqual(this.formatNote, videoInfo.formatNote) && Intrinsics.areEqual((Object) this.fileSizeApprox, (Object) videoInfo.fileSizeApprox) && Intrinsics.areEqual((Object) this.fileSize, (Object) videoInfo.fileSize) && Intrinsics.areEqual((Object) this.tbr, (Object) videoInfo.tbr) && Intrinsics.areEqual((Object) this.width, (Object) videoInfo.width) && Intrinsics.areEqual((Object) this.height, (Object) videoInfo.height) && Intrinsics.areEqual(this.resolution, videoInfo.resolution) && Intrinsics.areEqual((Object) this.fps, (Object) videoInfo.fps) && Intrinsics.areEqual(this.dynamicRange, videoInfo.dynamicRange) && Intrinsics.areEqual(this.vcodec, videoInfo.vcodec) && Intrinsics.areEqual((Object) this.vbr, (Object) videoInfo.vbr) && Intrinsics.areEqual(this.acodec, videoInfo.acodec) && Intrinsics.areEqual((Object) this.abr, (Object) videoInfo.abr) && Intrinsics.areEqual(this.asr, videoInfo.asr) && Intrinsics.areEqual(this.epoch, videoInfo.epoch) && Intrinsics.areEqual(this.requestedDownloads, videoInfo.requestedDownloads) && Intrinsics.areEqual(this.requestedFormats, videoInfo.requestedFormats) && Intrinsics.areEqual(this.filename, videoInfo.filename) && Intrinsics.areEqual(this.type, videoInfo.type);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + (this.formats == null ? 0 : this.formats.hashCode())) * 31) + (this.thumbnail == null ? 0 : this.thumbnail.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.uploader == null ? 0 : this.uploader.hashCode())) * 31) + (this.uploaderId == null ? 0 : this.uploaderId.hashCode())) * 31) + this.subtitles.hashCode()) * 31) + this.automaticCaptions.hashCode()) * 31) + (this.duration == null ? 0 : this.duration.hashCode())) * 31) + (this.viewCount == null ? 0 : this.viewCount.hashCode())) * 31) + (this.webpageUrl == null ? 0 : this.webpageUrl.hashCode())) * 31) + (this.tags == null ? 0 : this.tags.hashCode())) * 31) + (this.liveStatus == null ? 0 : this.liveStatus.hashCode())) * 31) + (this.commentCount == null ? 0 : this.commentCount.hashCode())) * 31) + (this.chapters == null ? 0 : this.chapters.hashCode())) * 31) + (this.likeCount == null ? 0 : this.likeCount.hashCode())) * 31) + (this.channel == null ? 0 : this.channel.hashCode())) * 31) + (this.uploadDate == null ? 0 : this.uploadDate.hashCode())) * 31) + (this.availability == null ? 0 : this.availability.hashCode())) * 31) + (this.originalUrl == null ? 0 : this.originalUrl.hashCode())) * 31) + (this.webpageUrlBasename == null ? 0 : this.webpageUrlBasename.hashCode())) * 31) + (this.webpageUrlDomain == null ? 0 : this.webpageUrlDomain.hashCode())) * 31) + (this.extractor == null ? 0 : this.extractor.hashCode())) * 31) + this.extractorKey.hashCode()) * 31) + (this.playlist == null ? 0 : this.playlist.hashCode())) * 31) + (this.playlistIndex == null ? 0 : this.playlistIndex.hashCode())) * 31) + (this.displayId == null ? 0 : this.displayId.hashCode())) * 31) + (this.fulltitle == null ? 0 : this.fulltitle.hashCode())) * 31) + (this.durationString == null ? 0 : this.durationString.hashCode())) * 31) + (this.releaseDate == null ? 0 : this.releaseDate.hashCode())) * 31) + (this.format == null ? 0 : this.format.hashCode())) * 31) + (this.formatId == null ? 0 : this.formatId.hashCode())) * 31) + this.ext.hashCode()) * 31) + (this.protocol == null ? 0 : this.protocol.hashCode())) * 31) + (this.formatNote == null ? 0 : this.formatNote.hashCode())) * 31) + (this.fileSizeApprox == null ? 0 : this.fileSizeApprox.hashCode())) * 31) + (this.fileSize == null ? 0 : this.fileSize.hashCode())) * 31) + (this.tbr == null ? 0 : this.tbr.hashCode())) * 31) + (this.width == null ? 0 : this.width.hashCode())) * 31) + (this.height == null ? 0 : this.height.hashCode())) * 31) + (this.resolution == null ? 0 : this.resolution.hashCode())) * 31) + (this.fps == null ? 0 : this.fps.hashCode())) * 31) + (this.dynamicRange == null ? 0 : this.dynamicRange.hashCode())) * 31) + (this.vcodec == null ? 0 : this.vcodec.hashCode())) * 31) + (this.vbr == null ? 0 : this.vbr.hashCode())) * 31) + (this.acodec == null ? 0 : this.acodec.hashCode())) * 31) + (this.abr == null ? 0 : this.abr.hashCode())) * 31) + (this.asr == null ? 0 : this.asr.hashCode())) * 31) + (this.epoch == null ? 0 : this.epoch.hashCode())) * 31) + (this.requestedDownloads == null ? 0 : this.requestedDownloads.hashCode())) * 31) + (this.requestedFormats == null ? 0 : this.requestedFormats.hashCode())) * 31) + (this.filename == null ? 0 : this.filename.hashCode())) * 31) + (this.type != null ? this.type.hashCode() : 0);
    }

    public String toString() {
        return "VideoInfo(id=" + this.id + ", title=" + this.title + ", formats=" + this.formats + ", thumbnail=" + this.thumbnail + ", description=" + this.description + ", uploader=" + this.uploader + ", uploaderId=" + this.uploaderId + ", subtitles=" + this.subtitles + ", automaticCaptions=" + this.automaticCaptions + ", duration=" + this.duration + ", viewCount=" + this.viewCount + ", webpageUrl=" + this.webpageUrl + ", tags=" + this.tags + ", liveStatus=" + this.liveStatus + ", commentCount=" + this.commentCount + ", chapters=" + this.chapters + ", likeCount=" + this.likeCount + ", channel=" + this.channel + ", uploadDate=" + this.uploadDate + ", availability=" + this.availability + ", originalUrl=" + this.originalUrl + ", webpageUrlBasename=" + this.webpageUrlBasename + ", webpageUrlDomain=" + this.webpageUrlDomain + ", extractor=" + this.extractor + ", extractorKey=" + this.extractorKey + ", playlist=" + this.playlist + ", playlistIndex=" + this.playlistIndex + ", displayId=" + this.displayId + ", fulltitle=" + this.fulltitle + ", durationString=" + this.durationString + ", releaseDate=" + this.releaseDate + ", format=" + this.format + ", formatId=" + this.formatId + ", ext=" + this.ext + ", protocol=" + this.protocol + ", formatNote=" + this.formatNote + ", fileSizeApprox=" + this.fileSizeApprox + ", fileSize=" + this.fileSize + ", tbr=" + this.tbr + ", width=" + this.width + ", height=" + this.height + ", resolution=" + this.resolution + ", fps=" + this.fps + ", dynamicRange=" + this.dynamicRange + ", vcodec=" + this.vcodec + ", vbr=" + this.vbr + ", acodec=" + this.acodec + ", abr=" + this.abr + ", asr=" + this.asr + ", epoch=" + this.epoch + ", requestedDownloads=" + this.requestedDownloads + ", requestedFormats=" + this.requestedFormats + ", filename=" + this.filename + ", type=" + this.type + ")";
    }

    /* JADX INFO: compiled from: VideoInfo.kt */
    @Metadata(m194d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m195d2 = {"Lcom/videshkarmakar/loop/util/VideoInfo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/videshkarmakar/loop/util/VideoInfo;", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<VideoInfo> serializer() {
            return new GeneratedSerializer<VideoInfo>() { // from class: com.videshkarmakar.loop.util.VideoInfo$$serializer
                public static final int $stable = 0;
                private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

                static {
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.videshkarmakar.loop.util.VideoInfo", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN 
                          (wrap com.videshkarmakar.loop.util.VideoInfo$$serializer:0x0002: SGET  A[WRAPPED] (LINE:9) com.videshkarmakar.loop.util.VideoInfo$$serializer.INSTANCE com.videshkarmakar.loop.util.VideoInfo$$serializer)
                         (LINE:9) in method: com.videshkarmakar.loop.util.VideoInfo.Companion.serializer():kotlinx.serialization.KSerializer<com.videshkarmakar.loop.util.VideoInfo>, file: classes10.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method generation error
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:348)
                        	... 5 more
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0011: CONSTRUCTOR (r0v1 'pluginGeneratedSerialDescriptor' kotlinx.serialization.internal.PluginGeneratedSerialDescriptor) = 
                          ("com.videshkarmakar.loop.util.VideoInfo")
                          (wrap com.videshkarmakar.loop.util.VideoInfo$$serializer:0x0009: SGET  A[WRAPPED] com.videshkarmakar.loop.util.VideoInfo$$serializer.INSTANCE com.videshkarmakar.loop.util.VideoInfo$$serializer)
                          (54 int)
                         A[DECLARE_VAR, MD:(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer<?>, int):void (m)] (LINE:9) call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: com.videshkarmakar.loop.util.VideoInfo$$serializer.<clinit>():void, file: classes10.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                        	... 5 more
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: com.videshkarmakar.loop.util.VideoInfo$$serializer
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:813)
                        	at jadx.core.codegen.InsnGen.staticField(InsnGen.java:225)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:492)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:782)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                        	... 15 more
                        */
                    /*
                        this = this;
                        com.videshkarmakar.loop.util.VideoInfo$$serializer r0 = com.videshkarmakar.loop.util.VideoInfo$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.videshkarmakar.loop.util.VideoInfo.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public /* synthetic */ VideoInfo(int seen1, int seen2, String id, String title, List formats, String thumbnail, String description, String uploader, @SerialName("uploader_id") String uploaderId, Map subtitles, @SerialName("automatic_captions") Map automaticCaptions, Double duration, @SerialName("view_count") Long viewCount, @SerialName("webpage_url") String webpageUrl, List tags, @SerialName("live_status") String liveStatus, @SerialName("comment_count") Integer commentCount, List chapters, @SerialName("like_count") Integer likeCount, String channel, @SerialName("upload_date") String uploadDate, String availability, @SerialName("original_url") String originalUrl, @SerialName("webpage_url_basename") String webpageUrlBasename, @SerialName("webpage_url_domain") String webpageUrlDomain, String extractor, @SerialName("extractor_key") String extractorKey, String playlist, @SerialName("playlist_index") Integer playlistIndex, @SerialName("display_id") String displayId, String fulltitle, @SerialName("duration_string") String durationString, @SerialName("release_date") String releaseDate, String format, @SerialName("format_id") String formatId, String ext, String protocol, @SerialName("format_note") String formatNote, @SerialName("filesize_approx") Double fileSizeApprox, @SerialName("filesize") Double fileSize, Double tbr, Double width, Double height, String resolution, Double fps, @SerialName("dynamic_range") String dynamicRange, String vcodec, Double vbr, String acodec, Double abr, Integer asr, Integer epoch, @SerialName("requested_downloads") List requestedDownloads, @SerialName("requested_formats") List requestedFormats, String filename, @SerialName("_type") String type, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen1 & 1) == 0) {
                    this.id = "";
                } else {
                    this.id = id;
                }
                if ((seen1 & 2) == 0) {
                    this.title = "";
                } else {
                    this.title = title;
                }
                if ((seen1 & 4) == 0) {
                    this.formats = CollectionsKt.emptyList();
                } else {
                    this.formats = formats;
                }
                if ((seen1 & 8) == 0) {
                    this.thumbnail = null;
                } else {
                    this.thumbnail = thumbnail;
                }
                if ((seen1 & 16) == 0) {
                    this.description = null;
                } else {
                    this.description = description;
                }
                if ((seen1 & 32) == 0) {
                    this.uploader = null;
                } else {
                    this.uploader = uploader;
                }
                if ((seen1 & 64) == 0) {
                    this.uploaderId = null;
                } else {
                    this.uploaderId = uploaderId;
                }
                if ((seen1 & 128) == 0) {
                    this.subtitles = MapsKt.emptyMap();
                } else {
                    this.subtitles = subtitles;
                }
                if ((seen1 & 256) == 0) {
                    this.automaticCaptions = MapsKt.emptyMap();
                } else {
                    this.automaticCaptions = automaticCaptions;
                }
                if ((seen1 & 512) == 0) {
                    this.duration = null;
                } else {
                    this.duration = duration;
                }
                if ((seen1 & 1024) == 0) {
                    this.viewCount = null;
                } else {
                    this.viewCount = viewCount;
                }
                if ((seen1 & 2048) == 0) {
                    this.webpageUrl = null;
                } else {
                    this.webpageUrl = webpageUrl;
                }
                if ((seen1 & 4096) == 0) {
                    this.tags = CollectionsKt.emptyList();
                } else {
                    this.tags = tags;
                }
                if ((seen1 & 8192) == 0) {
                    this.liveStatus = null;
                } else {
                    this.liveStatus = liveStatus;
                }
                if ((seen1 & 16384) == 0) {
                    this.commentCount = null;
                } else {
                    this.commentCount = commentCount;
                }
                if ((seen1 & 32768) == 0) {
                    this.chapters = null;
                } else {
                    this.chapters = chapters;
                }
                if ((seen1 & 65536) == 0) {
                    this.likeCount = null;
                } else {
                    this.likeCount = likeCount;
                }
                if ((seen1 & 131072) == 0) {
                    this.channel = null;
                } else {
                    this.channel = channel;
                }
                if ((seen1 & 262144) == 0) {
                    this.uploadDate = null;
                } else {
                    this.uploadDate = uploadDate;
                }
                if ((seen1 & 524288) == 0) {
                    this.availability = null;
                } else {
                    this.availability = availability;
                }
                if ((seen1 & 1048576) == 0) {
                    this.originalUrl = null;
                } else {
                    this.originalUrl = originalUrl;
                }
                if ((seen1 & 2097152) == 0) {
                    this.webpageUrlBasename = null;
                } else {
                    this.webpageUrlBasename = webpageUrlBasename;
                }
                if ((seen1 & 4194304) == 0) {
                    this.webpageUrlDomain = null;
                } else {
                    this.webpageUrlDomain = webpageUrlDomain;
                }
                if ((seen1 & 8388608) == 0) {
                    this.extractor = null;
                } else {
                    this.extractor = extractor;
                }
                if ((seen1 & 16777216) == 0) {
                    this.extractorKey = "";
                } else {
                    this.extractorKey = extractorKey;
                }
                if ((seen1 & 33554432) == 0) {
                    this.playlist = null;
                } else {
                    this.playlist = playlist;
                }
                if ((seen1 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) == 0) {
                    this.playlistIndex = null;
                } else {
                    this.playlistIndex = playlistIndex;
                }
                if ((seen1 & 134217728) == 0) {
                    this.displayId = null;
                } else {
                    this.displayId = displayId;
                }
                if ((seen1 & 268435456) == 0) {
                    this.fulltitle = null;
                } else {
                    this.fulltitle = fulltitle;
                }
                if ((seen1 & 536870912) == 0) {
                    this.durationString = null;
                } else {
                    this.durationString = durationString;
                }
                if ((seen1 & BasicMeasure.EXACTLY) == 0) {
                    this.releaseDate = null;
                } else {
                    this.releaseDate = releaseDate;
                }
                if ((seen1 & Integer.MIN_VALUE) == 0) {
                    this.format = null;
                } else {
                    this.format = format;
                }
                if ((seen2 & 1) == 0) {
                    this.formatId = null;
                } else {
                    this.formatId = formatId;
                }
                if ((seen2 & 2) == 0) {
                    this.ext = "";
                } else {
                    this.ext = ext;
                }
                if ((seen2 & 4) == 0) {
                    this.protocol = null;
                } else {
                    this.protocol = protocol;
                }
                if ((seen2 & 8) == 0) {
                    this.formatNote = null;
                } else {
                    this.formatNote = formatNote;
                }
                if ((seen2 & 16) == 0) {
                    this.fileSizeApprox = null;
                } else {
                    this.fileSizeApprox = fileSizeApprox;
                }
                if ((seen2 & 32) == 0) {
                    this.fileSize = null;
                } else {
                    this.fileSize = fileSize;
                }
                if ((seen2 & 64) == 0) {
                    this.tbr = null;
                } else {
                    this.tbr = tbr;
                }
                if ((seen2 & 128) == 0) {
                    this.width = null;
                } else {
                    this.width = width;
                }
                if ((seen2 & 256) == 0) {
                    this.height = null;
                } else {
                    this.height = height;
                }
                if ((seen2 & 512) == 0) {
                    this.resolution = null;
                } else {
                    this.resolution = resolution;
                }
                if ((seen2 & 1024) == 0) {
                    this.fps = null;
                } else {
                    this.fps = fps;
                }
                if ((seen2 & 2048) == 0) {
                    this.dynamicRange = null;
                } else {
                    this.dynamicRange = dynamicRange;
                }
                if ((seen2 & 4096) == 0) {
                    this.vcodec = null;
                } else {
                    this.vcodec = vcodec;
                }
                if ((seen2 & 8192) == 0) {
                    this.vbr = null;
                } else {
                    this.vbr = vbr;
                }
                if ((seen2 & 16384) == 0) {
                    this.acodec = null;
                } else {
                    this.acodec = acodec;
                }
                if ((seen2 & 32768) == 0) {
                    this.abr = null;
                } else {
                    this.abr = abr;
                }
                if ((seen2 & 65536) == 0) {
                    this.asr = null;
                } else {
                    this.asr = asr;
                }
                if ((seen2 & 131072) == 0) {
                    this.epoch = null;
                } else {
                    this.epoch = epoch;
                }
                if ((seen2 & 262144) == 0) {
                    this.requestedDownloads = null;
                } else {
                    this.requestedDownloads = requestedDownloads;
                }
                if ((seen2 & 524288) == 0) {
                    this.requestedFormats = null;
                } else {
                    this.requestedFormats = requestedFormats;
                }
                if ((seen2 & 1048576) == 0) {
                    this.filename = null;
                } else {
                    this.filename = filename;
                }
                if ((seen2 & 2097152) == 0) {
                    this.type = null;
                } else {
                    this.type = type;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public VideoInfo(String id, String title, List<Format> list, String thumbnail, String description, String uploader, String uploaderId, Map<String, ? extends List<SubtitleFormat>> subtitles, Map<String, ? extends List<SubtitleFormat>> automaticCaptions, Double duration, Long viewCount, String webpageUrl, List<String> list2, String liveStatus, Integer commentCount, List<Chapter> list3, Integer likeCount, String channel, String uploadDate, String availability, String originalUrl, String webpageUrlBasename, String webpageUrlDomain, String extractor, String extractorKey, String playlist, Integer playlistIndex, String displayId, String fulltitle, String durationString, String releaseDate, String format, String formatId, String ext, String protocol, String formatNote, Double fileSizeApprox, Double fileSize, Double tbr, Double width, Double height, String resolution, Double fps, String dynamicRange, String vcodec, Double vbr, String acodec, Double abr, Integer asr, Integer epoch, List<RequestedDownload> list4, List<Format> list5, String filename, String type) {
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(subtitles, "subtitles");
                Intrinsics.checkNotNullParameter(automaticCaptions, "automaticCaptions");
                Intrinsics.checkNotNullParameter(extractorKey, "extractorKey");
                Intrinsics.checkNotNullParameter(ext, "ext");
                this.id = id;
                this.title = title;
                this.formats = list;
                this.thumbnail = thumbnail;
                this.description = description;
                this.uploader = uploader;
                this.uploaderId = uploaderId;
                this.subtitles = subtitles;
                this.automaticCaptions = automaticCaptions;
                this.duration = duration;
                this.viewCount = viewCount;
                this.webpageUrl = webpageUrl;
                this.tags = list2;
                this.liveStatus = liveStatus;
                this.commentCount = commentCount;
                this.chapters = list3;
                this.likeCount = likeCount;
                this.channel = channel;
                this.uploadDate = uploadDate;
                this.availability = availability;
                this.originalUrl = originalUrl;
                this.webpageUrlBasename = webpageUrlBasename;
                this.webpageUrlDomain = webpageUrlDomain;
                this.extractor = extractor;
                this.extractorKey = extractorKey;
                this.playlist = playlist;
                this.playlistIndex = playlistIndex;
                this.displayId = displayId;
                this.fulltitle = fulltitle;
                this.durationString = durationString;
                this.releaseDate = releaseDate;
                this.format = format;
                this.formatId = formatId;
                this.ext = ext;
                this.protocol = protocol;
                this.formatNote = formatNote;
                this.fileSizeApprox = fileSizeApprox;
                this.fileSize = fileSize;
                this.tbr = tbr;
                this.width = width;
                this.height = height;
                this.resolution = resolution;
                this.fps = fps;
                this.dynamicRange = dynamicRange;
                this.vcodec = vcodec;
                this.vbr = vbr;
                this.acodec = acodec;
                this.abr = abr;
                this.asr = asr;
                this.epoch = epoch;
                this.requestedDownloads = list4;
                this.requestedFormats = list5;
                this.filename = filename;
                this.type = type;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$app_debug(VideoInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
                KSerializer<Object>[] kSerializerArr = $childSerializers;
                boolean z = output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.id, "");
                if (z) {
                    output.encodeStringElement(serialDesc, 0, self.id);
                }
                boolean z2 = output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.title, "");
                if (z2) {
                    output.encodeStringElement(serialDesc, 1, self.title);
                }
                boolean z3 = output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.formats, CollectionsKt.emptyList());
                if (z3) {
                    output.encodeNullableSerializableElement(serialDesc, 2, kSerializerArr[2], self.formats);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.thumbnail != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.thumbnail);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.description != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.description);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.uploader != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.uploader);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.uploaderId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.uploaderId);
                }
                boolean z4 = output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.subtitles, MapsKt.emptyMap());
                if (z4) {
                    output.encodeSerializableElement(serialDesc, 7, kSerializerArr[7], self.subtitles);
                }
                boolean z5 = output.shouldEncodeElementDefault(serialDesc, 8) || !Intrinsics.areEqual(self.automaticCaptions, MapsKt.emptyMap());
                if (z5) {
                    output.encodeSerializableElement(serialDesc, 8, kSerializerArr[8], self.automaticCaptions);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 9) || self.duration != null) {
                    output.encodeNullableSerializableElement(serialDesc, 9, DoubleSerializer.INSTANCE, self.duration);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 10) || self.viewCount != null) {
                    output.encodeNullableSerializableElement(serialDesc, 10, LongSerializer.INSTANCE, self.viewCount);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 11) || self.webpageUrl != null) {
                    output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.webpageUrl);
                }
                boolean z6 = output.shouldEncodeElementDefault(serialDesc, 12) || !Intrinsics.areEqual(self.tags, CollectionsKt.emptyList());
                if (z6) {
                    output.encodeNullableSerializableElement(serialDesc, 12, kSerializerArr[12], self.tags);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 13) || self.liveStatus != null) {
                    output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.liveStatus);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 14) || self.commentCount != null) {
                    output.encodeNullableSerializableElement(serialDesc, 14, IntSerializer.INSTANCE, self.commentCount);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 15) || self.chapters != null) {
                    output.encodeNullableSerializableElement(serialDesc, 15, kSerializerArr[15], self.chapters);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 16) || self.likeCount != null) {
                    output.encodeNullableSerializableElement(serialDesc, 16, IntSerializer.INSTANCE, self.likeCount);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 17) || self.channel != null) {
                    output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.channel);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 18) || self.uploadDate != null) {
                    output.encodeNullableSerializableElement(serialDesc, 18, StringSerializer.INSTANCE, self.uploadDate);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 19) || self.availability != null) {
                    output.encodeNullableSerializableElement(serialDesc, 19, StringSerializer.INSTANCE, self.availability);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 20) || self.originalUrl != null) {
                    output.encodeNullableSerializableElement(serialDesc, 20, StringSerializer.INSTANCE, self.originalUrl);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 21) || self.webpageUrlBasename != null) {
                    output.encodeNullableSerializableElement(serialDesc, 21, StringSerializer.INSTANCE, self.webpageUrlBasename);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 22) || self.webpageUrlDomain != null) {
                    output.encodeNullableSerializableElement(serialDesc, 22, StringSerializer.INSTANCE, self.webpageUrlDomain);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 23) || self.extractor != null) {
                    output.encodeNullableSerializableElement(serialDesc, 23, StringSerializer.INSTANCE, self.extractor);
                }
                boolean z7 = output.shouldEncodeElementDefault(serialDesc, 24) || !Intrinsics.areEqual(self.extractorKey, "");
                if (z7) {
                    output.encodeStringElement(serialDesc, 24, self.extractorKey);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 25) || self.playlist != null) {
                    output.encodeNullableSerializableElement(serialDesc, 25, StringSerializer.INSTANCE, self.playlist);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 26) || self.playlistIndex != null) {
                    output.encodeNullableSerializableElement(serialDesc, 26, IntSerializer.INSTANCE, self.playlistIndex);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 27) || self.displayId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 27, StringSerializer.INSTANCE, self.displayId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 28) || self.fulltitle != null) {
                    output.encodeNullableSerializableElement(serialDesc, 28, StringSerializer.INSTANCE, self.fulltitle);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 29) || self.durationString != null) {
                    output.encodeNullableSerializableElement(serialDesc, 29, StringSerializer.INSTANCE, self.durationString);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 30) || self.releaseDate != null) {
                    output.encodeNullableSerializableElement(serialDesc, 30, StringSerializer.INSTANCE, self.releaseDate);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 31) || self.format != null) {
                    output.encodeNullableSerializableElement(serialDesc, 31, StringSerializer.INSTANCE, self.format);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 32) || self.formatId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 32, StringSerializer.INSTANCE, self.formatId);
                }
                boolean z8 = output.shouldEncodeElementDefault(serialDesc, 33) || !Intrinsics.areEqual(self.ext, "");
                if (z8) {
                    output.encodeStringElement(serialDesc, 33, self.ext);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 34) || self.protocol != null) {
                    output.encodeNullableSerializableElement(serialDesc, 34, StringSerializer.INSTANCE, self.protocol);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 35) || self.formatNote != null) {
                    output.encodeNullableSerializableElement(serialDesc, 35, StringSerializer.INSTANCE, self.formatNote);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 36) || self.fileSizeApprox != null) {
                    output.encodeNullableSerializableElement(serialDesc, 36, DoubleSerializer.INSTANCE, self.fileSizeApprox);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 37) || self.fileSize != null) {
                    output.encodeNullableSerializableElement(serialDesc, 37, DoubleSerializer.INSTANCE, self.fileSize);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 38) || self.tbr != null) {
                    output.encodeNullableSerializableElement(serialDesc, 38, DoubleSerializer.INSTANCE, self.tbr);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 39) || self.width != null) {
                    output.encodeNullableSerializableElement(serialDesc, 39, DoubleSerializer.INSTANCE, self.width);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 40) || self.height != null) {
                    output.encodeNullableSerializableElement(serialDesc, 40, DoubleSerializer.INSTANCE, self.height);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 41) || self.resolution != null) {
                    output.encodeNullableSerializableElement(serialDesc, 41, StringSerializer.INSTANCE, self.resolution);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 42) || self.fps != null) {
                    output.encodeNullableSerializableElement(serialDesc, 42, DoubleSerializer.INSTANCE, self.fps);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 43) || self.dynamicRange != null) {
                    output.encodeNullableSerializableElement(serialDesc, 43, StringSerializer.INSTANCE, self.dynamicRange);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 44) || self.vcodec != null) {
                    output.encodeNullableSerializableElement(serialDesc, 44, StringSerializer.INSTANCE, self.vcodec);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 45) || self.vbr != null) {
                    output.encodeNullableSerializableElement(serialDesc, 45, DoubleSerializer.INSTANCE, self.vbr);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 46) || self.acodec != null) {
                    output.encodeNullableSerializableElement(serialDesc, 46, StringSerializer.INSTANCE, self.acodec);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 47) || self.abr != null) {
                    output.encodeNullableSerializableElement(serialDesc, 47, DoubleSerializer.INSTANCE, self.abr);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 48) || self.asr != null) {
                    output.encodeNullableSerializableElement(serialDesc, 48, IntSerializer.INSTANCE, self.asr);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 49) || self.epoch != null) {
                    output.encodeNullableSerializableElement(serialDesc, 49, IntSerializer.INSTANCE, self.epoch);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 50) || self.requestedDownloads != null) {
                    output.encodeNullableSerializableElement(serialDesc, 50, kSerializerArr[50], self.requestedDownloads);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 51) || self.requestedFormats != null) {
                    output.encodeNullableSerializableElement(serialDesc, 51, kSerializerArr[51], self.requestedFormats);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 52) || self.filename != null) {
                    output.encodeNullableSerializableElement(serialDesc, 52, StringSerializer.INSTANCE, self.filename);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 53) || self.type != null) {
                    output.encodeNullableSerializableElement(serialDesc, 53, StringSerializer.INSTANCE, self.type);
                }
            }

            public /* synthetic */ VideoInfo(String str, String str2, List list, String str3, String str4, String str5, String str6, Map map, Map map2, Double d, Long l, String str7, List list2, String str8, Integer num, List list3, Integer num2, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, Integer num3, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, Double d2, Double d3, Double d4, Double d5, Double d6, String str27, Double d7, String str28, String str29, Double d8, String str30, Double d9, Integer num4, Integer num5, List list4, List list5, String str31, String str32, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? MapsKt.emptyMap() : map, (i & 256) != 0 ? MapsKt.emptyMap() : map2, (i & 512) != 0 ? null : d, (i & 1024) != 0 ? null : l, (i & 2048) != 0 ? null : str7, (i & 4096) != 0 ? CollectionsKt.emptyList() : list2, (i & 8192) != 0 ? null : str8, (i & 16384) != 0 ? null : num, (i & 32768) != 0 ? null : list3, (i & 65536) != 0 ? null : num2, (i & 131072) != 0 ? null : str9, (i & 262144) != 0 ? null : str10, (i & 524288) != 0 ? null : str11, (i & 1048576) != 0 ? null : str12, (i & 2097152) != 0 ? null : str13, (i & 4194304) != 0 ? null : str14, (i & 8388608) != 0 ? null : str15, (i & 16777216) != 0 ? "" : str16, (i & 33554432) != 0 ? null : str17, (i & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? null : num3, (i & 134217728) != 0 ? null : str18, (i & 268435456) != 0 ? null : str19, (i & 536870912) != 0 ? null : str20, (i & BasicMeasure.EXACTLY) != 0 ? null : str21, (i & Integer.MIN_VALUE) != 0 ? null : str22, (i2 & 1) != 0 ? null : str23, (i2 & 2) != 0 ? "" : str24, (i2 & 4) != 0 ? null : str25, (i2 & 8) != 0 ? null : str26, (i2 & 16) != 0 ? null : d2, (i2 & 32) != 0 ? null : d3, (i2 & 64) != 0 ? null : d4, (i2 & 128) != 0 ? null : d5, (i2 & 256) != 0 ? null : d6, (i2 & 512) != 0 ? null : str27, (i2 & 1024) != 0 ? null : d7, (i2 & 2048) != 0 ? null : str28, (i2 & 4096) != 0 ? null : str29, (i2 & 8192) != 0 ? null : d8, (i2 & 16384) != 0 ? null : str30, (i2 & 32768) != 0 ? null : d9, (i2 & 65536) != 0 ? null : num4, (i2 & 131072) != 0 ? null : num5, (i2 & 262144) != 0 ? null : list4, (i2 & 524288) != 0 ? null : list5, (i2 & 1048576) != 0 ? null : str31, (i2 & 2097152) != 0 ? null : str32);
            }

            public final String getId() {
                return this.id;
            }

            public final String getTitle() {
                return this.title;
            }

            public final List<Format> getFormats() {
                return this.formats;
            }

            public final String getThumbnail() {
                return this.thumbnail;
            }

            public final String getDescription() {
                return this.description;
            }

            public final String getUploader() {
                return this.uploader;
            }

            public final String getUploaderId() {
                return this.uploaderId;
            }

            public final Map<String, List<SubtitleFormat>> getSubtitles() {
                return this.subtitles;
            }

            public final Map<String, List<SubtitleFormat>> getAutomaticCaptions() {
                return this.automaticCaptions;
            }

            public final Double getDuration() {
                return this.duration;
            }

            public final Long getViewCount() {
                return this.viewCount;
            }

            public final String getWebpageUrl() {
                return this.webpageUrl;
            }

            public final List<String> getTags() {
                return this.tags;
            }

            public final String getLiveStatus() {
                return this.liveStatus;
            }

            public final Integer getCommentCount() {
                return this.commentCount;
            }

            public final List<Chapter> getChapters() {
                return this.chapters;
            }

            public final Integer getLikeCount() {
                return this.likeCount;
            }

            public final String getChannel() {
                return this.channel;
            }

            public final String getUploadDate() {
                return this.uploadDate;
            }

            public final String getAvailability() {
                return this.availability;
            }

            public final String getOriginalUrl() {
                return this.originalUrl;
            }

            public final String getWebpageUrlBasename() {
                return this.webpageUrlBasename;
            }

            public final String getWebpageUrlDomain() {
                return this.webpageUrlDomain;
            }

            public final String getExtractor() {
                return this.extractor;
            }

            public final String getExtractorKey() {
                return this.extractorKey;
            }

            public final String getPlaylist() {
                return this.playlist;
            }

            public final Integer getPlaylistIndex() {
                return this.playlistIndex;
            }

            public final String getDisplayId() {
                return this.displayId;
            }

            public final String getFulltitle() {
                return this.fulltitle;
            }

            public final String getDurationString() {
                return this.durationString;
            }

            public final String getReleaseDate() {
                return this.releaseDate;
            }

            public final String getFormat() {
                return this.format;
            }

            public final String getFormatId() {
                return this.formatId;
            }

            public final String getExt() {
                return this.ext;
            }

            public final String getProtocol() {
                return this.protocol;
            }

            public final String getFormatNote() {
                return this.formatNote;
            }

            public final Double getFileSizeApprox() {
                return this.fileSizeApprox;
            }

            public final Double getFileSize() {
                return this.fileSize;
            }

            public final Double getTbr() {
                return this.tbr;
            }

            public final Double getWidth() {
                return this.width;
            }

            public final Double getHeight() {
                return this.height;
            }

            public final String getResolution() {
                return this.resolution;
            }

            public final Double getFps() {
                return this.fps;
            }

            public final String getDynamicRange() {
                return this.dynamicRange;
            }

            public final String getVcodec() {
                return this.vcodec;
            }

            public final Double getVbr() {
                return this.vbr;
            }

            public final String getAcodec() {
                return this.acodec;
            }

            public final Double getAbr() {
                return this.abr;
            }

            public final Integer getAsr() {
                return this.asr;
            }

            public final Integer getEpoch() {
                return this.epoch;
            }

            public final List<RequestedDownload> getRequestedDownloads() {
                return this.requestedDownloads;
            }

            public final List<Format> getRequestedFormats() {
                return this.requestedFormats;
            }

            public final String getFilename() {
                return this.filename;
            }

            public final String getType() {
                return this.type;
            }
        }
