package androidx.renderscript;

import android.util.Log;
import com.google.common.base.Ascii;
import java.util.BitSet;

public class FieldPacker {
    private BitSet mAlignment;
    private byte[] mData;
    private int mLen;
    private int mPos;

    public FieldPacker(int len) {
        this.mPos = 0;
        this.mLen = len;
        this.mData = new byte[len];
        this.mAlignment = new BitSet();
    }

    public FieldPacker(byte[] data) {
        this.mPos = data.length;
        this.mLen = data.length;
        this.mData = data;
        this.mAlignment = new BitSet();
    }

    static FieldPacker createFromArray(Object[] args) {
        FieldPacker fp = new FieldPacker(RenderScript.sPointerSize * 8);
        for (Object arg : args) {
            fp.addSafely(arg);
        }
        fp.resize(fp.mPos);
        return fp;
    }

    public void align(int v) {
        if (v <= 0 || ((v - 1) & v) != 0) {
            throw new RSIllegalArgumentException("argument must be a non-negative non-zero power of 2: " + v);
        }
        while (true) {
            int i = this.mPos;
            if (((v - 1) & i) != 0) {
                this.mAlignment.flip(i);
                byte[] bArr = this.mData;
                int i2 = this.mPos;
                this.mPos = i2 + 1;
                bArr[i2] = 0;
            } else {
                return;
            }
        }
    }

    public void subalign(int v) {
        int i;
        if (((v - 1) & v) == 0) {
            while (true) {
                i = this.mPos;
                if (((v - 1) & i) == 0) {
                    break;
                }
                this.mPos = i - 1;
            }
            if (i > 0) {
                while (this.mAlignment.get(this.mPos - 1)) {
                    int i2 = this.mPos - 1;
                    this.mPos = i2;
                    this.mAlignment.flip(i2);
                }
                return;
            }
            return;
        }
        throw new RSIllegalArgumentException("argument must be a non-negative non-zero power of 2: " + v);
    }

    public void reset() {
        this.mPos = 0;
    }

    public void reset(int i) {
        if (i < 0 || i > this.mLen) {
            throw new RSIllegalArgumentException("out of range argument: " + i);
        }
        this.mPos = i;
    }

    public void skip(int i) {
        int res = this.mPos + i;
        if (res < 0 || res > this.mLen) {
            throw new RSIllegalArgumentException("out of range argument: " + i);
        }
        this.mPos = res;
    }

    public void addI8(byte v) {
        byte[] bArr = this.mData;
        int i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = v;
    }

    public byte subI8() {
        subalign(1);
        byte[] bArr = this.mData;
        int i = this.mPos - 1;
        this.mPos = i;
        return bArr[i];
    }

    public void addI16(short v) {
        align(2);
        byte[] bArr = this.mData;
        int i = this.mPos;
        int i2 = i + 1;
        this.mPos = i2;
        bArr[i] = (byte) (v & 255);
        this.mPos = i2 + 1;
        bArr[i2] = (byte) (v >> 8);
    }

    public short subI16() {
        subalign(2);
        byte[] bArr = this.mData;
        int i = this.mPos - 1;
        this.mPos = i;
        int i2 = i - 1;
        this.mPos = i2;
        return (short) (((short) (bArr[i2] & 255)) | ((short) ((bArr[i] & 255) << 8)));
    }

    public void addI32(int v) {
        align(4);
        byte[] bArr = this.mData;
        int i = this.mPos;
        int i2 = i + 1;
        this.mPos = i2;
        bArr[i] = (byte) (v & 255);
        int i3 = i2 + 1;
        this.mPos = i3;
        bArr[i2] = (byte) ((v >> 8) & 255);
        int i4 = i3 + 1;
        this.mPos = i4;
        bArr[i3] = (byte) ((v >> 16) & 255);
        this.mPos = i4 + 1;
        bArr[i4] = (byte) ((v >> 24) & 255);
    }

    public int subI32() {
        subalign(4);
        byte[] bArr = this.mData;
        int i = this.mPos - 1;
        this.mPos = i;
        int v = (bArr[i] & 255) << Ascii.CAN;
        int i2 = i - 1;
        this.mPos = i2;
        int i3 = i2 - 1;
        this.mPos = i3;
        int i4 = i3 - 1;
        this.mPos = i4;
        return v | ((bArr[i2] & 255) << Ascii.DLE) | ((bArr[i3] & 255) << 8) | (bArr[i4] & 255);
    }

    public void addI64(long v) {
        align(8);
        byte[] bArr = this.mData;
        int i = this.mPos;
        int i2 = i + 1;
        this.mPos = i2;
        bArr[i] = (byte) ((int) (v & 255));
        int i3 = i2 + 1;
        this.mPos = i3;
        bArr[i2] = (byte) ((int) ((v >> 8) & 255));
        int i4 = i3 + 1;
        this.mPos = i4;
        bArr[i3] = (byte) ((int) ((v >> 16) & 255));
        int i5 = i4 + 1;
        this.mPos = i5;
        bArr[i4] = (byte) ((int) ((v >> 24) & 255));
        int i6 = i5 + 1;
        this.mPos = i6;
        bArr[i5] = (byte) ((int) ((v >> 32) & 255));
        int i7 = i6 + 1;
        this.mPos = i7;
        bArr[i6] = (byte) ((int) ((v >> 40) & 255));
        int i8 = i7 + 1;
        this.mPos = i8;
        bArr[i7] = (byte) ((int) ((v >> 48) & 255));
        this.mPos = i8 + 1;
        bArr[i8] = (byte) ((int) ((v >> 56) & 255));
    }

    public long subI64() {
        subalign(8);
        byte[] bArr = this.mData;
        int i = this.mPos - 1;
        this.mPos = i;
        int i2 = i - 1;
        this.mPos = i2;
        int i3 = i2 - 1;
        this.mPos = i3;
        int i4 = i3 - 1;
        this.mPos = i4;
        int i5 = i4 - 1;
        this.mPos = i5;
        int i6 = i5 - 1;
        this.mPos = i6;
        int i7 = i6 - 1;
        this.mPos = i7;
        int i8 = i7 - 1;
        this.mPos = i8;
        return 0 | ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i2]) & 255) << 48) | ((((long) bArr[i3]) & 255) << 40) | ((((long) bArr[i4]) & 255) << 32) | ((((long) bArr[i5]) & 255) << 24) | ((((long) bArr[i6]) & 255) << 16) | ((((long) bArr[i7]) & 255) << 8) | (((long) bArr[i8]) & 255);
    }

    public void addU8(short v) {
        if (v < 0 || v > 255) {
            Log.e("rs", "FieldPacker.addU8( " + v + " )");
            throw new IllegalArgumentException("Saving value out of range for type");
        }
        byte[] bArr = this.mData;
        int i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = (byte) v;
    }

    public void addU16(int v) {
        if (v < 0 || v > 65535) {
            Log.e("rs", "FieldPacker.addU16( " + v + " )");
            throw new IllegalArgumentException("Saving value out of range for type");
        }
        align(2);
        byte[] bArr = this.mData;
        int i = this.mPos;
        int i2 = i + 1;
        this.mPos = i2;
        bArr[i] = (byte) (v & 255);
        this.mPos = i2 + 1;
        bArr[i2] = (byte) (v >> 8);
    }

    public void addU32(long v) {
        if (v < 0 || v > 4294967295L) {
            Log.e("rs", "FieldPacker.addU32( " + v + " )");
            throw new IllegalArgumentException("Saving value out of range for type");
        }
        align(4);
        byte[] bArr = this.mData;
        int i = this.mPos;
        int i2 = i + 1;
        this.mPos = i2;
        bArr[i] = (byte) ((int) (v & 255));
        int i3 = i2 + 1;
        this.mPos = i3;
        bArr[i2] = (byte) ((int) ((v >> 8) & 255));
        int i4 = i3 + 1;
        this.mPos = i4;
        bArr[i3] = (byte) ((int) ((v >> 16) & 255));
        this.mPos = i4 + 1;
        bArr[i4] = (byte) ((int) (255 & (v >> 24)));
    }

    public void addU64(long v) {
        if (v >= 0) {
            align(8);
            byte[] bArr = this.mData;
            int i = this.mPos;
            int i2 = i + 1;
            this.mPos = i2;
            bArr[i] = (byte) ((int) (v & 255));
            int i3 = i2 + 1;
            this.mPos = i3;
            bArr[i2] = (byte) ((int) ((v >> 8) & 255));
            int i4 = i3 + 1;
            this.mPos = i4;
            bArr[i3] = (byte) ((int) ((v >> 16) & 255));
            int i5 = i4 + 1;
            this.mPos = i5;
            bArr[i4] = (byte) ((int) ((v >> 24) & 255));
            int i6 = i5 + 1;
            this.mPos = i6;
            bArr[i5] = (byte) ((int) ((v >> 32) & 255));
            int i7 = i6 + 1;
            this.mPos = i7;
            bArr[i6] = (byte) ((int) ((v >> 40) & 255));
            int i8 = i7 + 1;
            this.mPos = i8;
            bArr[i7] = (byte) ((int) ((v >> 48) & 255));
            this.mPos = i8 + 1;
            bArr[i8] = (byte) ((int) ((v >> 56) & 255));
            return;
        }
        Log.e("rs", "FieldPacker.addU64( " + v + " )");
        throw new IllegalArgumentException("Saving value out of range for type");
    }

    public void addF32(float v) {
        addI32(Float.floatToRawIntBits(v));
    }

    public float subF32() {
        return Float.intBitsToFloat(subI32());
    }

    public void addF64(double v) {
        addI64(Double.doubleToRawLongBits(v));
    }

    public double subF64() {
        return Double.longBitsToDouble(subI64());
    }

    public void addObj(BaseObj obj) {
        if (obj != null) {
            if (RenderScript.sPointerSize == 8) {
                addI64(obj.getID((RenderScript) null));
                addI64(0);
                addI64(0);
                addI64(0);
                return;
            }
            addI32((int) obj.getID((RenderScript) null));
        } else if (RenderScript.sPointerSize == 8) {
            addI64(0);
            addI64(0);
            addI64(0);
            addI64(0);
        } else {
            addI32(0);
        }
    }

    public void addF32(Float2 v) {
        addF32(v.x);
        addF32(v.y);
    }

    public void addF32(Float3 v) {
        addF32(v.x);
        addF32(v.y);
        addF32(v.z);
    }

    public void addF32(Float4 v) {
        addF32(v.x);
        addF32(v.y);
        addF32(v.z);
        addF32(v.w);
    }

    public void addF64(Double2 v) {
        addF64(v.x);
        addF64(v.y);
    }

    public void addF64(Double3 v) {
        addF64(v.x);
        addF64(v.y);
        addF64(v.z);
    }

    public void addF64(Double4 v) {
        addF64(v.x);
        addF64(v.y);
        addF64(v.z);
        addF64(v.w);
    }

    public void addI8(Byte2 v) {
        addI8(v.x);
        addI8(v.y);
    }

    public void addI8(Byte3 v) {
        addI8(v.x);
        addI8(v.y);
        addI8(v.z);
    }

    public void addI8(Byte4 v) {
        addI8(v.x);
        addI8(v.y);
        addI8(v.z);
        addI8(v.w);
    }

    public void addU8(Short2 v) {
        addU8(v.x);
        addU8(v.y);
    }

    public void addU8(Short3 v) {
        addU8(v.x);
        addU8(v.y);
        addU8(v.z);
    }

    public void addU8(Short4 v) {
        addU8(v.x);
        addU8(v.y);
        addU8(v.z);
        addU8(v.w);
    }

    public void addI16(Short2 v) {
        addI16(v.x);
        addI16(v.y);
    }

    public void addI16(Short3 v) {
        addI16(v.x);
        addI16(v.y);
        addI16(v.z);
    }

    public void addI16(Short4 v) {
        addI16(v.x);
        addI16(v.y);
        addI16(v.z);
        addI16(v.w);
    }

    public void addU16(Int2 v) {
        addU16(v.x);
        addU16(v.y);
    }

    public void addU16(Int3 v) {
        addU16(v.x);
        addU16(v.y);
        addU16(v.z);
    }

    public void addU16(Int4 v) {
        addU16(v.x);
        addU16(v.y);
        addU16(v.z);
        addU16(v.w);
    }

    public void addI32(Int2 v) {
        addI32(v.x);
        addI32(v.y);
    }

    public void addI32(Int3 v) {
        addI32(v.x);
        addI32(v.y);
        addI32(v.z);
    }

    public void addI32(Int4 v) {
        addI32(v.x);
        addI32(v.y);
        addI32(v.z);
        addI32(v.w);
    }

    public void addU32(Long2 v) {
        addU32(v.x);
        addU32(v.y);
    }

    public void addU32(Long3 v) {
        addU32(v.x);
        addU32(v.y);
        addU32(v.z);
    }

    public void addU32(Long4 v) {
        addU32(v.x);
        addU32(v.y);
        addU32(v.z);
        addU32(v.w);
    }

    public void addI64(Long2 v) {
        addI64(v.x);
        addI64(v.y);
    }

    public void addI64(Long3 v) {
        addI64(v.x);
        addI64(v.y);
        addI64(v.z);
    }

    public void addI64(Long4 v) {
        addI64(v.x);
        addI64(v.y);
        addI64(v.z);
        addI64(v.w);
    }

    public void addU64(Long2 v) {
        addU64(v.x);
        addU64(v.y);
    }

    public void addU64(Long3 v) {
        addU64(v.x);
        addU64(v.y);
        addU64(v.z);
    }

    public void addU64(Long4 v) {
        addU64(v.x);
        addU64(v.y);
        addU64(v.z);
        addU64(v.w);
    }

    public Float2 subFloat2() {
        Float2 v = new Float2();
        v.y = subF32();
        v.x = subF32();
        return v;
    }

    public Float3 subFloat3() {
        Float3 v = new Float3();
        v.z = subF32();
        v.y = subF32();
        v.x = subF32();
        return v;
    }

    public Float4 subFloat4() {
        Float4 v = new Float4();
        v.w = subF32();
        v.z = subF32();
        v.y = subF32();
        v.x = subF32();
        return v;
    }

    public Double2 subDouble2() {
        Double2 v = new Double2();
        v.y = subF64();
        v.x = subF64();
        return v;
    }

    public Double3 subDouble3() {
        Double3 v = new Double3();
        v.z = subF64();
        v.y = subF64();
        v.x = subF64();
        return v;
    }

    public Double4 subDouble4() {
        Double4 v = new Double4();
        v.w = subF64();
        v.z = subF64();
        v.y = subF64();
        v.x = subF64();
        return v;
    }

    public Byte2 subByte2() {
        Byte2 v = new Byte2();
        v.y = subI8();
        v.x = subI8();
        return v;
    }

    public Byte3 subByte3() {
        Byte3 v = new Byte3();
        v.z = subI8();
        v.y = subI8();
        v.x = subI8();
        return v;
    }

    public Byte4 subByte4() {
        Byte4 v = new Byte4();
        v.w = subI8();
        v.z = subI8();
        v.y = subI8();
        v.x = subI8();
        return v;
    }

    public Short2 subShort2() {
        Short2 v = new Short2();
        v.y = subI16();
        v.x = subI16();
        return v;
    }

    public Short3 subShort3() {
        Short3 v = new Short3();
        v.z = subI16();
        v.y = subI16();
        v.x = subI16();
        return v;
    }

    public Short4 subShort4() {
        Short4 v = new Short4();
        v.w = subI16();
        v.z = subI16();
        v.y = subI16();
        v.x = subI16();
        return v;
    }

    public Int2 subInt2() {
        Int2 v = new Int2();
        v.y = subI32();
        v.x = subI32();
        return v;
    }

    public Int3 subInt3() {
        Int3 v = new Int3();
        v.z = subI32();
        v.y = subI32();
        v.x = subI32();
        return v;
    }

    public Int4 subInt4() {
        Int4 v = new Int4();
        v.w = subI32();
        v.z = subI32();
        v.y = subI32();
        v.x = subI32();
        return v;
    }

    public Long2 subLong2() {
        Long2 v = new Long2();
        v.y = subI64();
        v.x = subI64();
        return v;
    }

    public Long3 subLong3() {
        Long3 v = new Long3();
        v.z = subI64();
        v.y = subI64();
        v.x = subI64();
        return v;
    }

    public Long4 subLong4() {
        Long4 v = new Long4();
        v.w = subI64();
        v.z = subI64();
        v.y = subI64();
        v.x = subI64();
        return v;
    }

    public void addMatrix(Matrix4f v) {
        for (float addF32 : v.mMat) {
            addF32(addF32);
        }
    }

    public Matrix4f subMatrix4f() {
        Matrix4f v = new Matrix4f();
        for (int i = v.mMat.length - 1; i >= 0; i--) {
            v.mMat[i] = subF32();
        }
        return v;
    }

    public void addMatrix(Matrix3f v) {
        for (float addF32 : v.mMat) {
            addF32(addF32);
        }
    }

    public Matrix3f subMatrix3f() {
        Matrix3f v = new Matrix3f();
        for (int i = v.mMat.length - 1; i >= 0; i--) {
            v.mMat[i] = subF32();
        }
        return v;
    }

    public void addMatrix(Matrix2f v) {
        for (float addF32 : v.mMat) {
            addF32(addF32);
        }
    }

    public Matrix2f subMatrix2f() {
        Matrix2f v = new Matrix2f();
        for (int i = v.mMat.length - 1; i >= 0; i--) {
            v.mMat[i] = subF32();
        }
        return v;
    }

    public void addBoolean(boolean v) {
        addI8(v ? (byte) 1 : 0);
    }

    public boolean subBoolean() {
        if (subI8() == 1) {
            return true;
        }
        return false;
    }

    public final byte[] getData() {
        return this.mData;
    }

    public int getPos() {
        return this.mPos;
    }

    private static void addToPack(FieldPacker fp, Object obj) {
        if (obj instanceof Boolean) {
            fp.addBoolean(((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            fp.addI8(((Byte) obj).byteValue());
        } else if (obj instanceof Short) {
            fp.addI16(((Short) obj).shortValue());
        } else if (obj instanceof Integer) {
            fp.addI32(((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            fp.addI64(((Long) obj).longValue());
        } else if (obj instanceof Float) {
            fp.addF32(((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            fp.addF64(((Double) obj).doubleValue());
        } else if (obj instanceof Byte2) {
            fp.addI8((Byte2) obj);
        } else if (obj instanceof Byte3) {
            fp.addI8((Byte3) obj);
        } else if (obj instanceof Byte4) {
            fp.addI8((Byte4) obj);
        } else if (obj instanceof Short2) {
            fp.addI16((Short2) obj);
        } else if (obj instanceof Short3) {
            fp.addI16((Short3) obj);
        } else if (obj instanceof Short4) {
            fp.addI16((Short4) obj);
        } else if (obj instanceof Int2) {
            fp.addI32((Int2) obj);
        } else if (obj instanceof Int3) {
            fp.addI32((Int3) obj);
        } else if (obj instanceof Int4) {
            fp.addI32((Int4) obj);
        } else if (obj instanceof Long2) {
            fp.addI64((Long2) obj);
        } else if (obj instanceof Long3) {
            fp.addI64((Long3) obj);
        } else if (obj instanceof Long4) {
            fp.addI64((Long4) obj);
        } else if (obj instanceof Float2) {
            fp.addF32((Float2) obj);
        } else if (obj instanceof Float3) {
            fp.addF32((Float3) obj);
        } else if (obj instanceof Float4) {
            fp.addF32((Float4) obj);
        } else if (obj instanceof Double2) {
            fp.addF64((Double2) obj);
        } else if (obj instanceof Double3) {
            fp.addF64((Double3) obj);
        } else if (obj instanceof Double4) {
            fp.addF64((Double4) obj);
        } else if (obj instanceof Matrix2f) {
            fp.addMatrix((Matrix2f) obj);
        } else if (obj instanceof Matrix3f) {
            fp.addMatrix((Matrix3f) obj);
        } else if (obj instanceof Matrix4f) {
            fp.addMatrix((Matrix4f) obj);
        } else if (obj instanceof BaseObj) {
            fp.addObj((BaseObj) obj);
        }
    }

    private static int getPackedSize(Object obj) {
        if ((obj instanceof Boolean) || (obj instanceof Byte)) {
            return 1;
        }
        if (obj instanceof Short) {
            return 2;
        }
        if (obj instanceof Integer) {
            return 4;
        }
        if (obj instanceof Long) {
            return 8;
        }
        if (obj instanceof Float) {
            return 4;
        }
        if (obj instanceof Double) {
            return 8;
        }
        if (obj instanceof Byte2) {
            return 2;
        }
        if (obj instanceof Byte3) {
            return 3;
        }
        if ((obj instanceof Byte4) || (obj instanceof Short2)) {
            return 4;
        }
        if (obj instanceof Short3) {
            return 6;
        }
        if ((obj instanceof Short4) || (obj instanceof Int2)) {
            return 8;
        }
        if (obj instanceof Int3) {
            return 12;
        }
        if ((obj instanceof Int4) || (obj instanceof Long2)) {
            return 16;
        }
        if (obj instanceof Long3) {
            return 24;
        }
        if (obj instanceof Long4) {
            return 32;
        }
        if (obj instanceof Float2) {
            return 8;
        }
        if (obj instanceof Float3) {
            return 12;
        }
        if ((obj instanceof Float4) || (obj instanceof Double2)) {
            return 16;
        }
        if (obj instanceof Double3) {
            return 24;
        }
        if (obj instanceof Double4) {
            return 32;
        }
        if (obj instanceof Matrix2f) {
            return 16;
        }
        if (obj instanceof Matrix3f) {
            return 36;
        }
        if (obj instanceof Matrix4f) {
            return 64;
        }
        if (!(obj instanceof BaseObj)) {
            return 0;
        }
        if (RenderScript.sPointerSize == 8) {
            return 32;
        }
        return 4;
    }

    static FieldPacker createFieldPack(Object[] args) {
        int len = 0;
        for (Object arg : args) {
            len += getPackedSize(arg);
        }
        FieldPacker fp = new FieldPacker(len);
        for (Object arg2 : args) {
            addToPack(fp, arg2);
        }
        return fp;
    }

    private boolean resize(int newSize) {
        if (newSize == this.mLen) {
            return false;
        }
        byte[] newData = new byte[newSize];
        System.arraycopy(this.mData, 0, newData, 0, this.mPos);
        this.mData = newData;
        this.mLen = newSize;
        return true;
    }

    private void addSafely(Object obj) {
        boolean retry;
        int oldPos = this.mPos;
        do {
            retry = false;
            try {
                addToPack(this, obj);
                continue;
            } catch (ArrayIndexOutOfBoundsException e) {
                this.mPos = oldPos;
                resize(this.mLen * 2);
                retry = true;
                continue;
            }
        } while (retry);
    }
}
