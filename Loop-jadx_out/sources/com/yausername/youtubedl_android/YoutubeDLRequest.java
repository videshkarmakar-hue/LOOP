package com.yausername.youtubedl_android;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: YoutubeDLRequest.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0004\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007J\u0014\u0010\f\u001a\u00020\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0003J\u0016\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006J\u0018\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u0003J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0003R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m195d2 = {"Lcom/yausername/youtubedl_android/YoutubeDLRequest;", "", "url", "", "(Ljava/lang/String;)V", "urls", "", "(Ljava/util/List;)V", "customCommandList", "", "options", "Lcom/yausername/youtubedl_android/YoutubeDLOptions;", "addCommands", "commands", "addOption", "option", "argument", "", "buildCommand", "getArguments", "getOption", "hasOption", "", "library_release"}, m196k = 1, m197mv = {1, 7, 1}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class YoutubeDLRequest {
    private final List<String> customCommandList;
    private final YoutubeDLOptions options;
    private final List<String> urls;

    public YoutubeDLRequest(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.options = new YoutubeDLOptions();
        this.customCommandList = new ArrayList();
        this.urls = CollectionsKt.listOf(url);
    }

    public YoutubeDLRequest(List<String> urls) {
        Intrinsics.checkNotNullParameter(urls, "urls");
        this.options = new YoutubeDLOptions();
        this.customCommandList = new ArrayList();
        this.urls = urls;
    }

    public final YoutubeDLRequest addOption(String option, String argument) {
        Intrinsics.checkNotNullParameter(option, "option");
        Intrinsics.checkNotNullParameter(argument, "argument");
        this.options.addOption(option, argument);
        return this;
    }

    public final YoutubeDLRequest addOption(String option, Number argument) {
        Intrinsics.checkNotNullParameter(option, "option");
        Intrinsics.checkNotNullParameter(argument, "argument");
        this.options.addOption(option, argument);
        return this;
    }

    public final YoutubeDLRequest addOption(String option) {
        Intrinsics.checkNotNullParameter(option, "option");
        this.options.addOption(option);
        return this;
    }

    public final YoutubeDLRequest addCommands(List<String> commands) {
        Intrinsics.checkNotNullParameter(commands, "commands");
        this.customCommandList.addAll(commands);
        return this;
    }

    public final String getOption(String option) {
        Intrinsics.checkNotNullParameter(option, "option");
        return this.options.getArgument(option);
    }

    public final List<String> getArguments(String option) {
        Intrinsics.checkNotNullParameter(option, "option");
        return this.options.getArguments(option);
    }

    public final boolean hasOption(String option) {
        Intrinsics.checkNotNullParameter(option, "option");
        return this.options.hasOption(option);
    }

    public final List<String> buildCommand() {
        List commandList = new ArrayList();
        commandList.addAll(this.options.buildOptions());
        commandList.addAll(this.customCommandList);
        commandList.addAll(this.urls);
        return commandList;
    }
}
