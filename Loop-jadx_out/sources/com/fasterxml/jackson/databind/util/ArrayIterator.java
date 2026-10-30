package com.fasterxml.jackson.databind.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes18.dex */
public class ArrayIterator<T> implements Iterator<T>, Iterable<T> {

    /* JADX INFO: renamed from: _a */
    private final T[] f368_a;
    private int _index = 0;

    public ArrayIterator(T[] a) {
        this.f368_a = a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this._index < this.f368_a.length;
    }

    @Override // java.util.Iterator
    public T next() {
        if (this._index >= this.f368_a.length) {
            throw new NoSuchElementException();
        }
        T[] tArr = this.f368_a;
        int i = this._index;
        this._index = i + 1;
        return tArr[i];
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return this;
    }
}
