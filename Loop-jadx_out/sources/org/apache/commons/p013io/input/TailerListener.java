package org.apache.commons.p013io.input;

/* JADX INFO: loaded from: classes18.dex */
public interface TailerListener {
    void fileNotFound();

    void fileRotated();

    void handle(Exception exc);

    void handle(String str);

    void init(Tailer tailer);
}
