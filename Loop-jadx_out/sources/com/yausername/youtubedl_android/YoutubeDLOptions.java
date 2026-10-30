package com.yausername.youtubedl_android;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: YoutubeDLOptions.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0005J\u0016\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0005J\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0005R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m195d2 = {"Lcom/yausername/youtubedl_android/YoutubeDLOptions;", "", "()V", "options", "", "", "", "addOption", "option", "argument", "", "buildOptions", "", "getArgument", "getArguments", "hasOption", "", "library_release"}, m196k = 1, m197mv = {1, 7, 1}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class YoutubeDLOptions {
    private final Map<String, List<String>> options = new LinkedHashMap();

    public final YoutubeDLOptions addOption(String option, String argument) {
        Intrinsics.checkNotNullParameter(option, "option");
        Intrinsics.checkNotNullParameter(argument, "argument");
        if (!this.options.containsKey(option)) {
            List arguments = new ArrayList();
            arguments.add(argument);
            this.options.put(option, arguments);
        } else {
            List<String> list = this.options.get(option);
            Intrinsics.checkNotNull(list);
            list.add(argument);
        }
        return this;
    }

    public final YoutubeDLOptions addOption(String option, Number argument) {
        Intrinsics.checkNotNullParameter(option, "option");
        Intrinsics.checkNotNullParameter(argument, "argument");
        if (!this.options.containsKey(option)) {
            List arguments = new ArrayList();
            arguments.add(argument.toString());
            this.options.put(option, arguments);
        } else {
            List<String> list = this.options.get(option);
            Intrinsics.checkNotNull(list);
            list.add(argument.toString());
        }
        return this;
    }

    public final YoutubeDLOptions addOption(String option) {
        Intrinsics.checkNotNullParameter(option, "option");
        if (!this.options.containsKey(option)) {
            List arguments = new ArrayList();
            arguments.add("");
            this.options.put(option, arguments);
        } else {
            List<String> list = this.options.get(option);
            Intrinsics.checkNotNull(list);
            list.add("");
        }
        return this;
    }

    public final String getArgument(String option) {
        Intrinsics.checkNotNullParameter(option, "option");
        String str = null;
        if (!this.options.containsKey(option)) {
            return null;
        }
        List<String> list = this.options.get(option);
        Intrinsics.checkNotNull(list);
        String argument = list.get(0);
        String str2 = argument;
        if (!(str2.length() == 0)) {
            str = str2;
        }
        return str;
    }

    public final List<String> getArguments(String option) {
        Intrinsics.checkNotNullParameter(option, "option");
        if (this.options.containsKey(option)) {
            return this.options.get(option);
        }
        return null;
    }

    public final boolean hasOption(String option) {
        Intrinsics.checkNotNullParameter(option, "option");
        return this.options.containsKey(option);
    }

    public final List<String> buildOptions() {
        List commandList = new ArrayList();
        for (Map.Entry<String, List<String>> entry : this.options.entrySet()) {
            String option = entry.getKey();
            for (String argument : entry.getValue()) {
                commandList.add(option);
                if (argument.length() > 0) {
                    commandList.add(argument);
                }
            }
        }
        return commandList;
    }
}
