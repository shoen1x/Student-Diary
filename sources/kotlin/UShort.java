package kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\b@\u0018\u0000 f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001fB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0010J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0013J\u001b\u0010\u001b\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J\u0013\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\rHÖ\u0001J\u0013\u0010%\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b&\u0010\u0005J\u0013\u0010'\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u0005J\u001b\u0010)\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b*\u0010\u0010J\u001b\u0010)\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b+\u0010\u0013J\u001b\u0010)\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\b,\u0010\u001fJ\u001b\u0010)\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b-\u0010\u0018J\u001b\u0010.\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b/\u0010\u000bJ\u001b\u00100\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u0010J\u001b\u00100\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b2\u0010\u0013J\u001b\u00100\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u001fJ\u001b\u00100\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b4\u0010\u0018J\u001b\u00105\u001a\u0002062\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b7\u00108J\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b:\u0010\u0010J\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b;\u0010\u0013J\u001b\u00109\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\b<\u0010\u001fJ\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b=\u0010\u0018J\u001b\u0010>\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b?\u0010\u0010J\u001b\u0010>\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u0013J\u001b\u0010>\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u001fJ\u001b\u0010>\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bB\u0010\u0018J\u0010\u0010C\u001a\u00020DH\b¢\u0006\u0004\bE\u0010FJ\u0010\u0010G\u001a\u00020HH\b¢\u0006\u0004\bI\u0010JJ\u0010\u0010K\u001a\u00020LH\b¢\u0006\u0004\bM\u0010NJ\u0010\u0010O\u001a\u00020\rH\b¢\u0006\u0004\bP\u0010QJ\u0010\u0010R\u001a\u00020SH\b¢\u0006\u0004\bT\u0010UJ\u0010\u0010V\u001a\u00020\u0003H\b¢\u0006\u0004\bW\u0010\u0005J\u000f\u0010X\u001a\u00020YH\u0016¢\u0006\u0004\bZ\u0010[J\u0013\u0010\\\u001a\u00020\u000eH\bø\u0001\u0000¢\u0006\u0004\b]\u0010FJ\u0013\u0010^\u001a\u00020\u0011H\bø\u0001\u0000¢\u0006\u0004\b_\u0010QJ\u0013\u0010`\u001a\u00020\u0014H\bø\u0001\u0000¢\u0006\u0004\ba\u0010UJ\u0013\u0010b\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\bc\u0010\u0005J\u001b\u0010d\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\be\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006g"}, d2 = {"Lkotlin/UShort;", "", "data", "", "constructor-impl", "(S)S", "data$annotations", "()V", "and", "other", "and-xj2QHRw", "(SS)S", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "compareTo-xj2QHRw", "(SS)I", "dec", "dec-impl", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(SJ)J", "div-xj2QHRw", "equals", "", "", "hashCode", "inc", "inc-impl", "inv", "inv-impl", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or", "or-xj2QHRw", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(S)B", "toDouble", "", "toDouble-impl", "(S)D", "toFloat", "", "toFloat-impl", "(S)F", "toInt", "toInt-impl", "(S)I", "toLong", "", "toLong-impl", "(S)J", "toShort", "toShort-impl", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "toUByte", "toUByte-impl", "toUInt", "toUInt-impl", "toULong", "toULong-impl", "toUShort", "toUShort-impl", "xor", "xor-xj2QHRw", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15})
/* compiled from: UShort.kt */
public final class UShort implements Comparable<UShort> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    private final short data;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UShort m310boximpl(short s) {
        return new UShort(s);
    }

    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private int m314compareToxj2QHRw(short s) {
        return m315compareToxj2QHRw(this.data, s);
    }

    public static /* synthetic */ void data$annotations() {
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m322equalsimpl(short s, Object obj) {
        if (obj instanceof UShort) {
            if (s == ((UShort) obj).m357unboximpl()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m323equalsimpl0(short s, short s2) {
        throw null;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m324hashCodeimpl(short s) {
        return s;
    }

    public boolean equals(Object obj) {
        return m322equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m324hashCodeimpl(this.data);
    }

    public String toString() {
        return m351toStringimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ short m357unboximpl() {
        return this.data;
    }

    private /* synthetic */ UShort(short data2) {
        this.data = data2;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static short m316constructorimpl(short data2) {
        return data2;
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return m314compareToxj2QHRw(((UShort) obj).m357unboximpl());
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u0004XTø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u0013\u0010\u0006\u001a\u00020\u0004XTø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lkotlin/UShort$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UShort;", "S", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15})
    /* compiled from: UShort.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private static final int m311compareTo7apg3OU(short $this, byte other) {
        return Intrinsics.compare((int) 65535 & $this, (int) other & 255);
    }

    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private static int m315compareToxj2QHRw(short $this, short other) {
        return Intrinsics.compare((int) $this & MAX_VALUE, (int) 65535 & other);
    }

    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private static final int m313compareToWZ4Q5Ns(short $this, int other) {
        return UnsignedKt.uintCompare(UInt.m150constructorimpl(65535 & $this), other);
    }

    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private static final int m312compareToVKZWuLQ(short $this, long other) {
        return UnsignedKt.ulongCompare(ULong.m219constructorimpl(((long) $this) & 65535), other);
    }

    /* renamed from: plus-7apg3OU  reason: not valid java name */
    private static final int m332plus7apg3OU(short $this, byte other) {
        return UInt.m150constructorimpl(UInt.m150constructorimpl(65535 & $this) + UInt.m150constructorimpl(other & 255));
    }

    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    private static final int m335plusxj2QHRw(short $this, short other) {
        return UInt.m150constructorimpl(UInt.m150constructorimpl($this & MAX_VALUE) + UInt.m150constructorimpl(65535 & other));
    }

    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    private static final int m334plusWZ4Q5Ns(short $this, int other) {
        return UInt.m150constructorimpl(UInt.m150constructorimpl(65535 & $this) + other);
    }

    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    private static final long m333plusVKZWuLQ(short $this, long other) {
        return ULong.m219constructorimpl(ULong.m219constructorimpl(((long) $this) & 65535) + other);
    }

    /* renamed from: minus-7apg3OU  reason: not valid java name */
    private static final int m327minus7apg3OU(short $this, byte other) {
        return UInt.m150constructorimpl(UInt.m150constructorimpl(65535 & $this) - UInt.m150constructorimpl(other & 255));
    }

    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    private static final int m330minusxj2QHRw(short $this, short other) {
        return UInt.m150constructorimpl(UInt.m150constructorimpl($this & MAX_VALUE) - UInt.m150constructorimpl(65535 & other));
    }

    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    private static final int m329minusWZ4Q5Ns(short $this, int other) {
        return UInt.m150constructorimpl(UInt.m150constructorimpl(65535 & $this) - other);
    }

    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    private static final long m328minusVKZWuLQ(short $this, long other) {
        return ULong.m219constructorimpl(ULong.m219constructorimpl(((long) $this) & 65535) - other);
    }

    /* renamed from: times-7apg3OU  reason: not valid java name */
    private static final int m341times7apg3OU(short $this, byte other) {
        return UInt.m150constructorimpl(UInt.m150constructorimpl(65535 & $this) * UInt.m150constructorimpl(other & 255));
    }

    /* renamed from: times-xj2QHRw  reason: not valid java name */
    private static final int m344timesxj2QHRw(short $this, short other) {
        return UInt.m150constructorimpl(UInt.m150constructorimpl($this & MAX_VALUE) * UInt.m150constructorimpl(65535 & other));
    }

    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    private static final int m343timesWZ4Q5Ns(short $this, int other) {
        return UInt.m150constructorimpl(UInt.m150constructorimpl(65535 & $this) * other);
    }

    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    private static final long m342timesVKZWuLQ(short $this, long other) {
        return ULong.m219constructorimpl(ULong.m219constructorimpl(((long) $this) & 65535) * other);
    }

    /* renamed from: div-7apg3OU  reason: not valid java name */
    private static final int m318div7apg3OU(short $this, byte other) {
        return UnsignedKt.m376uintDivideJ1ME1BU(UInt.m150constructorimpl(65535 & $this), UInt.m150constructorimpl(other & 255));
    }

    /* renamed from: div-xj2QHRw  reason: not valid java name */
    private static final int m321divxj2QHRw(short $this, short other) {
        return UnsignedKt.m376uintDivideJ1ME1BU(UInt.m150constructorimpl($this & MAX_VALUE), UInt.m150constructorimpl(65535 & other));
    }

    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    private static final int m320divWZ4Q5Ns(short $this, int other) {
        return UnsignedKt.m376uintDivideJ1ME1BU(UInt.m150constructorimpl(65535 & $this), other);
    }

    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    private static final long m319divVKZWuLQ(short $this, long other) {
        return UnsignedKt.m378ulongDivideeb3DHEI(ULong.m219constructorimpl(((long) $this) & 65535), other);
    }

    /* renamed from: rem-7apg3OU  reason: not valid java name */
    private static final int m337rem7apg3OU(short $this, byte other) {
        return UnsignedKt.m377uintRemainderJ1ME1BU(UInt.m150constructorimpl(65535 & $this), UInt.m150constructorimpl(other & 255));
    }

    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    private static final int m340remxj2QHRw(short $this, short other) {
        return UnsignedKt.m377uintRemainderJ1ME1BU(UInt.m150constructorimpl($this & MAX_VALUE), UInt.m150constructorimpl(65535 & other));
    }

    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    private static final int m339remWZ4Q5Ns(short $this, int other) {
        return UnsignedKt.m377uintRemainderJ1ME1BU(UInt.m150constructorimpl(65535 & $this), other);
    }

    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    private static final long m338remVKZWuLQ(short $this, long other) {
        return UnsignedKt.m379ulongRemaindereb3DHEI(ULong.m219constructorimpl(((long) $this) & 65535), other);
    }

    /* renamed from: inc-impl  reason: not valid java name */
    private static final short m325incimpl(short $this) {
        return m316constructorimpl((short) ($this + 1));
    }

    /* renamed from: dec-impl  reason: not valid java name */
    private static final short m317decimpl(short $this) {
        return m316constructorimpl((short) ($this - 1));
    }

    /* renamed from: rangeTo-xj2QHRw  reason: not valid java name */
    private static final UIntRange m336rangeToxj2QHRw(short $this, short other) {
        return new UIntRange(UInt.m150constructorimpl($this & MAX_VALUE), UInt.m150constructorimpl(65535 & other), (DefaultConstructorMarker) null);
    }

    /* renamed from: and-xj2QHRw  reason: not valid java name */
    private static final short m309andxj2QHRw(short $this, short other) {
        return m316constructorimpl((short) ($this & other));
    }

    /* renamed from: or-xj2QHRw  reason: not valid java name */
    private static final short m331orxj2QHRw(short $this, short other) {
        return m316constructorimpl((short) ($this | other));
    }

    /* renamed from: xor-xj2QHRw  reason: not valid java name */
    private static final short m356xorxj2QHRw(short $this, short other) {
        return m316constructorimpl((short) ($this ^ other));
    }

    /* renamed from: inv-impl  reason: not valid java name */
    private static final short m326invimpl(short $this) {
        return m316constructorimpl((short) (~$this));
    }

    /* renamed from: toByte-impl  reason: not valid java name */
    private static final byte m345toByteimpl(short $this) {
        return (byte) $this;
    }

    /* renamed from: toShort-impl  reason: not valid java name */
    private static final short m350toShortimpl(short $this) {
        return $this;
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    private static final int m348toIntimpl(short $this) {
        return 65535 & $this;
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    private static final long m349toLongimpl(short $this) {
        return ((long) $this) & 65535;
    }

    /* renamed from: toUByte-impl  reason: not valid java name */
    private static final byte m352toUByteimpl(short $this) {
        return UByte.m83constructorimpl((byte) $this);
    }

    /* renamed from: toUShort-impl  reason: not valid java name */
    private static final short m355toUShortimpl(short $this) {
        return $this;
    }

    /* renamed from: toUInt-impl  reason: not valid java name */
    private static final int m353toUIntimpl(short $this) {
        return UInt.m150constructorimpl(65535 & $this);
    }

    /* renamed from: toULong-impl  reason: not valid java name */
    private static final long m354toULongimpl(short $this) {
        return ULong.m219constructorimpl(((long) $this) & 65535);
    }

    /* renamed from: toFloat-impl  reason: not valid java name */
    private static final float m347toFloatimpl(short $this) {
        return (float) (65535 & $this);
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    private static final double m346toDoubleimpl(short $this) {
        return (double) (65535 & $this);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m351toStringimpl(short $this) {
        return String.valueOf(65535 & $this);
    }
}
