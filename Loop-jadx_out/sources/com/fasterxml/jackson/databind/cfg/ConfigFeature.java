package com.fasterxml.jackson.databind.cfg;

/* JADX INFO: loaded from: classes18.dex */
public interface ConfigFeature {
    boolean enabledByDefault();

    boolean enabledIn(int i);

    int getMask();
}
