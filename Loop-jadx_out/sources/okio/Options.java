package okio;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Options.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0015B\u001f\b\u0002\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000eH\u0096\u0002R\u001e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006X\u0080\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, m195d2 = {"Lokio/Options;", "Lkotlin/collections/AbstractList;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "byteStrings", "", "trie", "", "([Lokio/ByteString;[I)V", "getByteStrings$okio", "()[Lokio/ByteString;", "[Lokio/ByteString;", "size", "", "getSize", "()I", "getTrie$okio", "()[I", "get", "index", "Companion", "okio"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Options extends AbstractList<ByteString> implements RandomAccess {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ByteString[] byteStrings;
    private final int[] trie;

    public /* synthetic */ Options(ByteString[] byteStringArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteStringArr, iArr);
    }

    @JvmStatic
    /* JADX INFO: renamed from: of */
    public static final Options m246of(ByteString... byteStringArr) {
        return INSTANCE.m247of(byteStringArr);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object element) {
        if (element instanceof ByteString) {
            return contains((ByteString) element);
        }
        return false;
    }

    public /* bridge */ boolean contains(ByteString element) {
        return super.contains(element);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object element) {
        if (element instanceof ByteString) {
            return indexOf((ByteString) element);
        }
        return -1;
    }

    public /* bridge */ int indexOf(ByteString element) {
        return super.indexOf(element);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object element) {
        if (element instanceof ByteString) {
            return lastIndexOf((ByteString) element);
        }
        return -1;
    }

    public /* bridge */ int lastIndexOf(ByteString element) {
        return super.lastIndexOf(element);
    }

    /* JADX INFO: renamed from: getByteStrings$okio, reason: from getter */
    public final ByteString[] getByteStrings() {
        return this.byteStrings;
    }

    /* JADX INFO: renamed from: getTrie$okio, reason: from getter */
    public final int[] getTrie() {
        return this.trie;
    }

    private Options(ByteString[] byteStrings, int[] trie) {
        this.byteStrings = byteStrings;
        this.trie = trie;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.byteStrings.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ByteString get(int index) {
        return this.byteStrings[index];
    }

    /* JADX INFO: compiled from: Options.kt */
    @Metadata(m194d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JT\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002J!\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u0016\"\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0017R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, m195d2 = {"Lokio/Options$Companion;", "", "()V", "intCount", "", "Lokio/Buffer;", "getIntCount", "(Lokio/Buffer;)J", "buildTrieRecursive", "", "nodeOffset", "node", "byteStringOffset", "", "byteStrings", "", "Lokio/ByteString;", "fromIndex", "toIndex", "indexes", "of", "Lokio/Options;", "", "([Lokio/ByteString;)Lokio/Options;", "okio"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        /* JADX INFO: renamed from: of */
        public final Options m247of(ByteString... byteStrings) throws IOException {
            Intrinsics.checkNotNullParameter(byteStrings, "byteStrings");
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (byteStrings.length == 0) {
                return new Options(new ByteString[0], new int[]{0, -1}, defaultConstructorMarker);
            }
            List list = ArraysKt.toMutableList(byteStrings);
            CollectionsKt.sort(list);
            Collection destination$iv$iv = new ArrayList(byteStrings.length);
            for (ByteString byteString : byteStrings) {
                destination$iv$iv.add(-1);
            }
            Collection $this$toTypedArray$iv = (List) destination$iv$iv;
            Integer[] numArr = (Integer[]) $this$toTypedArray$iv.toArray(new Integer[0]);
            List indexes = CollectionsKt.mutableListOf(Arrays.copyOf(numArr, numArr.length));
            int index$iv = 0;
            int length = byteStrings.length;
            int i = 0;
            while (i < length) {
                int index$iv2 = index$iv + 1;
                int callerIndex = index$iv;
                int sortedIndex = CollectionsKt.binarySearch$default(list, byteStrings[i], 0, 0, 6, (Object) null);
                indexes.set(sortedIndex, Integer.valueOf(callerIndex));
                i++;
                index$iv = index$iv2;
            }
            if (!(((ByteString) list.get(0)).size() > 0)) {
                throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
            }
            for (int a = 0; a < list.size(); a++) {
                ByteString prefix = (ByteString) list.get(a);
                int b = a + 1;
                while (b < list.size()) {
                    ByteString byteString2 = (ByteString) list.get(b);
                    if (!byteString2.startsWith(prefix)) {
                        break;
                    }
                    if (!(byteString2.size() != prefix.size())) {
                        throw new IllegalArgumentException(("duplicate option: " + byteString2).toString());
                    }
                    if (((Number) indexes.get(b)).intValue() > ((Number) indexes.get(a)).intValue()) {
                        list.remove(b);
                        indexes.remove(b);
                    } else {
                        b++;
                    }
                }
            }
            Buffer trieBytes = new Buffer();
            buildTrieRecursive$default(this, 0L, trieBytes, 0, list, 0, 0, indexes, 53, null);
            int[] trie = new int[(int) getIntCount(trieBytes)];
            int i2 = 0;
            while (!trieBytes.exhausted()) {
                trie[i2] = trieBytes.readInt();
                i2++;
            }
            Object[] objArrCopyOf = Arrays.copyOf(byteStrings, byteStrings.length);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, size)");
            return new Options((ByteString[]) objArrCopyOf, trie, defaultConstructorMarker);
        }

        static /* synthetic */ void buildTrieRecursive$default(Companion companion, long j, Buffer buffer, int i, List list, int i2, int i3, List list2, int i4, Object obj) throws IOException {
            companion.buildTrieRecursive((i4 & 1) != 0 ? 0L : j, buffer, (i4 & 4) != 0 ? 0 : i, list, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? list.size() : i3, list2);
        }

        private final void buildTrieRecursive(long nodeOffset, Buffer node, int byteStringOffset, List<? extends ByteString> byteStrings, int fromIndex, int toIndex, List<Integer> indexes) throws IOException {
            int fromIndex2;
            ByteString from;
            int prefixIndex;
            ByteString from2;
            ByteString to;
            int rangeEnd;
            List<? extends ByteString> list = byteStrings;
            List<Integer> list2 = indexes;
            if (!(fromIndex < toIndex)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            for (int i = fromIndex; i < toIndex; i++) {
                if (!(list.get(i).size() >= byteStringOffset)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
            ByteString from3 = list.get(fromIndex);
            ByteString to2 = list.get(toIndex - 1);
            if (byteStringOffset != from3.size()) {
                fromIndex2 = fromIndex;
                from = from3;
                prefixIndex = -1;
            } else {
                int prefixIndex2 = list2.get(fromIndex).intValue();
                int fromIndex3 = fromIndex + 1;
                fromIndex2 = fromIndex3;
                from = list.get(fromIndex3);
                prefixIndex = prefixIndex2;
            }
            if (from.getByte(byteStringOffset) != to2.getByte(byteStringOffset)) {
                int selectChoiceCount = 1;
                for (int i2 = fromIndex2 + 1; i2 < toIndex; i2++) {
                    if (list.get(i2 - 1).getByte(byteStringOffset) != list.get(i2).getByte(byteStringOffset)) {
                        selectChoiceCount++;
                    }
                }
                ByteString to3 = to2;
                long childNodesOffset = nodeOffset + getIntCount(node) + ((long) 2) + ((long) (selectChoiceCount * 2));
                node.writeInt(selectChoiceCount);
                node.writeInt(prefixIndex);
                for (int i3 = fromIndex2; i3 < toIndex; i3++) {
                    byte rangeByte = list.get(i3).getByte(byteStringOffset);
                    if (i3 == fromIndex2 || rangeByte != list.get(i3 - 1).getByte(byteStringOffset)) {
                        int other$iv = 255 & rangeByte;
                        node.writeInt(other$iv);
                    }
                }
                Buffer childNodes = new Buffer();
                int rangeStart = fromIndex2;
                while (rangeStart < toIndex) {
                    byte rangeByte2 = list.get(rangeStart).getByte(byteStringOffset);
                    int i4 = rangeStart + 1;
                    while (true) {
                        if (i4 >= toIndex) {
                            i4 = toIndex;
                            break;
                        } else if (rangeByte2 != list.get(i4).getByte(byteStringOffset)) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                    int rangeEnd2 = rangeStart + 1;
                    if (rangeEnd2 == i4 && byteStringOffset + 1 == list.get(rangeStart).size()) {
                        node.writeInt(list2.get(rangeStart).intValue());
                        rangeEnd = i4;
                    } else {
                        int rangeEnd3 = i4;
                        node.writeInt(((int) (childNodesOffset + getIntCount(childNodes))) * (-1));
                        rangeEnd = rangeEnd3;
                        buildTrieRecursive(childNodesOffset, childNodes, byteStringOffset + 1, byteStrings, rangeStart, rangeEnd, indexes);
                    }
                    rangeStart = rangeEnd;
                    fromIndex2 = fromIndex2;
                    prefixIndex = prefixIndex;
                    from = from;
                    selectChoiceCount = selectChoiceCount;
                    to3 = to3;
                    list = byteStrings;
                    list2 = indexes;
                }
                node.writeAll(childNodes);
                return;
            }
            int prefixIndex3 = prefixIndex;
            ByteString from4 = from;
            int fromIndex4 = fromIndex2;
            ByteString to4 = to2;
            int i5 = byteStringOffset;
            int iMin = Math.min(from4.size(), to4.size());
            int scanByteCount = 0;
            while (true) {
                if (i5 >= iMin) {
                    from2 = from4;
                    to = to4;
                    break;
                }
                from2 = from4;
                to = to4;
                if (from2.getByte(i5) != to.getByte(i5)) {
                    break;
                }
                scanByteCount++;
                i5++;
                to4 = to;
                from4 = from2;
            }
            long childNodesOffset2 = nodeOffset + getIntCount(node) + ((long) 2) + ((long) scanByteCount) + 1;
            node.writeInt(-scanByteCount);
            node.writeInt(prefixIndex3);
            int i6 = byteStringOffset + scanByteCount;
            for (int i7 = byteStringOffset; i7 < i6; i7++) {
                byte $this$and$iv = from2.getByte(i7);
                node.writeInt($this$and$iv & UByte.MAX_VALUE);
            }
            int i8 = fromIndex4 + 1;
            if (i8 == toIndex) {
                if (!(byteStringOffset + scanByteCount == byteStrings.get(fromIndex4).size())) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                node.writeInt(indexes.get(fromIndex4).intValue());
            } else {
                Buffer childNodes2 = new Buffer();
                node.writeInt(((int) (childNodesOffset2 + getIntCount(childNodes2))) * (-1));
                buildTrieRecursive(childNodesOffset2, childNodes2, byteStringOffset + scanByteCount, byteStrings, fromIndex4, toIndex, indexes);
                node.writeAll(childNodes2);
            }
        }

        private final long getIntCount(Buffer $this$intCount) {
            return $this$intCount.size() / ((long) 4);
        }
    }
}
