package androidx.renderscript;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.Surface;
import androidx.renderscript.Element;
import androidx.renderscript.Type;
import com.bumptech.glide.load.Key;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Allocation extends BaseObj {
    public static final int USAGE_GRAPHICS_TEXTURE = 2;
    public static final int USAGE_IO_INPUT = 32;
    public static final int USAGE_IO_OUTPUT = 64;
    public static final int USAGE_SCRIPT = 1;
    public static final int USAGE_SHARED = 128;
    static BitmapFactory.Options mBitmapOptions;
    Allocation mAdaptedAllocation;
    boolean mAutoPadding = false;
    Bitmap mBitmap;
    ByteBuffer mByteBuffer = null;
    long mByteBufferStride = 0;
    boolean mConstrainedFace;
    boolean mConstrainedLOD;
    boolean mConstrainedY;
    boolean mConstrainedZ;
    int mCurrentCount;
    int mCurrentDimX;
    int mCurrentDimY;
    int mCurrentDimZ;
    boolean mIncAllocDestroyed;
    long mIncCompatAllocation;
    boolean mReadAllowed = true;
    Type.CubemapFace mSelectedFace = Type.CubemapFace.POSITIVE_X;
    int mSelectedLOD;
    int mSelectedY;
    int mSelectedZ;
    int mSize;
    Type mType;
    int mUsage;
    boolean mWriteAllowed = true;

    private Element.DataType validateObjectIsPrimitiveArray(Object d, boolean checkType) {
        Class c = d.getClass();
        if (c.isArray()) {
            Class cmp = c.getComponentType();
            if (!cmp.isPrimitive()) {
                throw new RSIllegalArgumentException("Object passed is not an Array of primitives.");
            } else if (cmp == Long.TYPE) {
                if (!checkType) {
                    return Element.DataType.SIGNED_64;
                }
                validateIsInt64();
                return this.mType.mElement.mType;
            } else if (cmp == Integer.TYPE) {
                if (!checkType) {
                    return Element.DataType.SIGNED_32;
                }
                validateIsInt32();
                return this.mType.mElement.mType;
            } else if (cmp == Short.TYPE) {
                if (!checkType) {
                    return Element.DataType.SIGNED_16;
                }
                validateIsInt16();
                return this.mType.mElement.mType;
            } else if (cmp == Byte.TYPE) {
                if (!checkType) {
                    return Element.DataType.SIGNED_8;
                }
                validateIsInt8();
                return this.mType.mElement.mType;
            } else if (cmp == Float.TYPE) {
                if (checkType) {
                    validateIsFloat32();
                }
                return Element.DataType.FLOAT_32;
            } else if (cmp != Double.TYPE) {
                return null;
            } else {
                if (checkType) {
                    validateIsFloat64();
                }
                return Element.DataType.FLOAT_64;
            }
        } else {
            throw new RSIllegalArgumentException("Object passed is not an array of primitives.");
        }
    }

    public enum MipmapControl {
        MIPMAP_NONE(0),
        MIPMAP_FULL(1),
        MIPMAP_ON_SYNC_TO_TEXTURE(2);
        
        int mID;

        private MipmapControl(int id) {
            this.mID = id;
        }
    }

    public long getIncAllocID() {
        return this.mIncCompatAllocation;
    }

    public void setIncAllocID(long id) {
        this.mIncCompatAllocation = id;
    }

    private long getIDSafe() {
        Allocation allocation = this.mAdaptedAllocation;
        if (allocation != null) {
            return allocation.getID(this.mRS);
        }
        return getID(this.mRS);
    }

    public Element getElement() {
        return this.mType.getElement();
    }

    public int getUsage() {
        return this.mUsage;
    }

    public void setAutoPadding(boolean useAutoPadding) {
        this.mAutoPadding = useAutoPadding;
    }

    public int getBytesSize() {
        if (this.mType.mDimYuv != 0) {
            return (int) Math.ceil(((double) (this.mType.getCount() * this.mType.getElement().getBytesSize())) * 1.5d);
        }
        return this.mType.getCount() * this.mType.getElement().getBytesSize();
    }

    private void updateCacheInfo(Type t) {
        this.mCurrentDimX = t.getX();
        this.mCurrentDimY = t.getY();
        this.mCurrentDimZ = t.getZ();
        int i = this.mCurrentDimX;
        this.mCurrentCount = i;
        int i2 = this.mCurrentDimY;
        if (i2 > 1) {
            this.mCurrentCount = i * i2;
        }
        int i3 = this.mCurrentDimZ;
        if (i3 > 1) {
            this.mCurrentCount *= i3;
        }
    }

    private void setBitmap(Bitmap b) {
        this.mBitmap = b;
    }

    Allocation(long id, RenderScript rs, Type t, int usage) {
        super(id, rs);
        if ((usage & -228) == 0) {
            if ((usage & 32) != 0) {
                this.mWriteAllowed = false;
                if ((usage & -36) != 0) {
                    throw new RSIllegalArgumentException("Invalid usage combination.");
                }
            }
            this.mType = t;
            this.mUsage = usage;
            this.mIncCompatAllocation = 0;
            this.mIncAllocDestroyed = false;
            if (t != null) {
                this.mSize = t.getCount() * this.mType.getElement().getBytesSize();
                updateCacheInfo(t);
            }
            if (RenderScript.sUseGCHooks) {
                try {
                    RenderScript.registerNativeAllocation.invoke(RenderScript.sRuntime, new Object[]{Integer.valueOf(this.mSize)});
                } catch (Exception e) {
                    Log.e("RenderScript_jni", "Couldn't invoke registerNativeAllocation:" + e);
                    throw new RSRuntimeException("Couldn't invoke registerNativeAllocation:" + e);
                }
            }
        } else {
            throw new RSIllegalArgumentException("Unknown usage specified.");
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        if (RenderScript.sUseGCHooks) {
            RenderScript.registerNativeFree.invoke(RenderScript.sRuntime, new Object[]{Integer.valueOf(this.mSize)});
        }
        super.finalize();
    }

    private void validateIsInt64() {
        if (this.mType.mElement.mType != Element.DataType.SIGNED_64 && this.mType.mElement.mType != Element.DataType.UNSIGNED_64) {
            throw new RSIllegalArgumentException("64 bit integer source does not match allocation type " + this.mType.mElement.mType);
        }
    }

    private void validateIsInt32() {
        if (this.mType.mElement.mType != Element.DataType.SIGNED_32 && this.mType.mElement.mType != Element.DataType.UNSIGNED_32) {
            throw new RSIllegalArgumentException("32 bit integer source does not match allocation type " + this.mType.mElement.mType);
        }
    }

    private void validateIsInt16() {
        if (this.mType.mElement.mType != Element.DataType.SIGNED_16 && this.mType.mElement.mType != Element.DataType.UNSIGNED_16) {
            throw new RSIllegalArgumentException("16 bit integer source does not match allocation type " + this.mType.mElement.mType);
        }
    }

    private void validateIsInt8() {
        if (this.mType.mElement.mType != Element.DataType.SIGNED_8 && this.mType.mElement.mType != Element.DataType.UNSIGNED_8) {
            throw new RSIllegalArgumentException("8 bit integer source does not match allocation type " + this.mType.mElement.mType);
        }
    }

    private void validateIsFloat32() {
        if (this.mType.mElement.mType != Element.DataType.FLOAT_32) {
            throw new RSIllegalArgumentException("32 bit float source does not match allocation type " + this.mType.mElement.mType);
        }
    }

    private void validateIsFloat64() {
        if (this.mType.mElement.mType != Element.DataType.FLOAT_64) {
            throw new RSIllegalArgumentException("64 bit float source does not match allocation type " + this.mType.mElement.mType);
        }
    }

    private void validateIsObject() {
        if (this.mType.mElement.mType != Element.DataType.RS_ELEMENT && this.mType.mElement.mType != Element.DataType.RS_TYPE && this.mType.mElement.mType != Element.DataType.RS_ALLOCATION && this.mType.mElement.mType != Element.DataType.RS_SAMPLER && this.mType.mElement.mType != Element.DataType.RS_SCRIPT) {
            throw new RSIllegalArgumentException("Object source does not match allocation type " + this.mType.mElement.mType);
        }
    }

    public Type getType() {
        return this.mType;
    }

    public void syncAll(int srcLocation) {
        if (srcLocation == 1 || srcLocation == 2) {
            this.mRS.validate();
            this.mRS.nAllocationSyncAll(getIDSafe(), srcLocation);
            return;
        }
        throw new RSIllegalArgumentException("Source must be exactly one usage type.");
    }

    public void ioSend() {
        if ((this.mUsage & 64) != 0) {
            this.mRS.validate();
            this.mRS.nAllocationIoSend(getID(this.mRS));
            return;
        }
        throw new RSIllegalArgumentException("Can only send buffer if IO_OUTPUT usage specified.");
    }

    public void ioSendOutput() {
        ioSend();
    }

    public ByteBuffer getByteBuffer() {
        byte[] data;
        int xBytesSize = this.mType.getX() * this.mType.getElement().getBytesSize();
        if (this.mRS.getDispatchAPILevel() >= 21) {
            if (this.mByteBuffer == null || (this.mUsage & 32) != 0) {
                this.mByteBuffer = this.mRS.nAllocationGetByteBuffer(getID(this.mRS), xBytesSize, this.mType.getY(), this.mType.getZ());
            }
            return this.mByteBuffer;
        } else if (this.mType.getZ() > 0) {
            return null;
        } else {
            if (this.mType.getY() > 0) {
                data = new byte[(this.mType.getY() * xBytesSize)];
                copy2DRangeToUnchecked(0, 0, this.mType.getX(), this.mType.getY(), data, Element.DataType.SIGNED_8, xBytesSize * this.mType.getY());
            } else {
                data = new byte[xBytesSize];
                copy1DRangeToUnchecked(0, this.mType.getX(), data);
            }
            ByteBuffer bBuffer = ByteBuffer.wrap(data).asReadOnlyBuffer();
            this.mByteBufferStride = (long) xBytesSize;
            return bBuffer;
        }
    }

    public long getStride() {
        if (this.mByteBufferStride == 0) {
            if (this.mRS.getDispatchAPILevel() > 21) {
                this.mByteBufferStride = this.mRS.nAllocationGetStride(getID(this.mRS));
            } else {
                this.mByteBufferStride = (long) (this.mType.getX() * this.mType.getElement().getBytesSize());
            }
        }
        return this.mByteBufferStride;
    }

    public void ioReceive() {
        if ((this.mUsage & 32) != 0) {
            this.mRS.validate();
            this.mRS.nAllocationIoReceive(getID(this.mRS));
            return;
        }
        throw new RSIllegalArgumentException("Can only receive if IO_INPUT usage specified.");
    }

    public void copyFrom(BaseObj[] d) {
        this.mRS.validate();
        validateIsObject();
        if (d.length != this.mCurrentCount) {
            throw new RSIllegalArgumentException("Array size mismatch, allocation sizeX = " + this.mCurrentCount + ", array length = " + d.length);
        } else if (RenderScript.sPointerSize == 8) {
            long[] i = new long[(d.length * 4)];
            for (int ct = 0; ct < d.length; ct++) {
                i[ct * 4] = d[ct].getID(this.mRS);
            }
            copy1DRangeFromUnchecked(0, this.mCurrentCount, (Object) i);
        } else {
            int[] i2 = new int[d.length];
            for (int ct2 = 0; ct2 < d.length; ct2++) {
                i2[ct2] = (int) d[ct2].getID(this.mRS);
            }
            copy1DRangeFromUnchecked(0, this.mCurrentCount, i2);
        }
    }

    private void validateBitmapFormat(Bitmap b) {
        Bitmap.Config bc = b.getConfig();
        if (bc != null) {
            int i = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[bc.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            if (this.mType.getElement().mKind != Element.DataKind.PIXEL_RGBA || this.mType.getElement().getBytesSize() != 2) {
                                throw new RSIllegalArgumentException("Allocation kind is " + this.mType.getElement().mKind + ", type " + this.mType.getElement().mType + " of " + this.mType.getElement().getBytesSize() + " bytes, passed bitmap was " + bc);
                            }
                        }
                    } else if (this.mType.getElement().mKind != Element.DataKind.PIXEL_RGB || this.mType.getElement().getBytesSize() != 2) {
                        throw new RSIllegalArgumentException("Allocation kind is " + this.mType.getElement().mKind + ", type " + this.mType.getElement().mType + " of " + this.mType.getElement().getBytesSize() + " bytes, passed bitmap was " + bc);
                    }
                } else if (this.mType.getElement().mKind != Element.DataKind.PIXEL_RGBA || this.mType.getElement().getBytesSize() != 4) {
                    throw new RSIllegalArgumentException("Allocation kind is " + this.mType.getElement().mKind + ", type " + this.mType.getElement().mType + " of " + this.mType.getElement().getBytesSize() + " bytes, passed bitmap was " + bc);
                }
            } else if (this.mType.getElement().mKind != Element.DataKind.PIXEL_A) {
                throw new RSIllegalArgumentException("Allocation kind is " + this.mType.getElement().mKind + ", type " + this.mType.getElement().mType + " of " + this.mType.getElement().getBytesSize() + " bytes, passed bitmap was " + bc);
            }
        } else {
            throw new RSIllegalArgumentException("Bitmap has an unsupported format for this operation");
        }
    }

    /* renamed from: androidx.renderscript.Allocation$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_8888.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private void validateBitmapSize(Bitmap b) {
        if (this.mCurrentDimX != b.getWidth() || this.mCurrentDimY != b.getHeight()) {
            throw new RSIllegalArgumentException("Cannot update allocation from bitmap, sizes mismatch");
        }
    }

    private void copyFromUnchecked(Object array, Element.DataType dt, int arrayLen) {
        this.mRS.validate();
        int i = this.mCurrentDimZ;
        if (i > 0) {
            copy3DRangeFromUnchecked(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, i, array, dt, arrayLen);
            return;
        }
        int i2 = this.mCurrentDimY;
        if (i2 > 0) {
            copy2DRangeFromUnchecked(0, 0, this.mCurrentDimX, i2, array, dt, arrayLen);
            return;
        }
        copy1DRangeFromUnchecked(0, this.mCurrentCount, array, dt, arrayLen);
    }

    public void copyFromUnchecked(Object array) {
        copyFromUnchecked(array, validateObjectIsPrimitiveArray(array, false), Array.getLength(array));
    }

    public void copyFromUnchecked(int[] d) {
        copyFromUnchecked(d, Element.DataType.SIGNED_32, d.length);
    }

    public void copyFromUnchecked(short[] d) {
        copyFromUnchecked(d, Element.DataType.SIGNED_16, d.length);
    }

    public void copyFromUnchecked(byte[] d) {
        copyFromUnchecked(d, Element.DataType.SIGNED_8, d.length);
    }

    public void copyFromUnchecked(float[] d) {
        copyFromUnchecked(d, Element.DataType.FLOAT_32, d.length);
    }

    public void copyFrom(Object array) {
        copyFromUnchecked(array, validateObjectIsPrimitiveArray(array, true), Array.getLength(array));
    }

    public void copyFrom(int[] d) {
        validateIsInt32();
        copyFromUnchecked(d, Element.DataType.SIGNED_32, d.length);
    }

    public void copyFrom(short[] d) {
        validateIsInt16();
        copyFromUnchecked(d, Element.DataType.SIGNED_16, d.length);
    }

    public void copyFrom(byte[] d) {
        validateIsInt8();
        copyFromUnchecked(d, Element.DataType.SIGNED_8, d.length);
    }

    public void copyFrom(float[] d) {
        validateIsFloat32();
        copyFromUnchecked(d, Element.DataType.FLOAT_32, d.length);
    }

    public void copyFrom(Bitmap b) {
        this.mRS.validate();
        if (b.getConfig() == null) {
            Bitmap newBitmap = Bitmap.createBitmap(b.getWidth(), b.getHeight(), Bitmap.Config.ARGB_8888);
            new Canvas(newBitmap).drawBitmap(b, 0.0f, 0.0f, (Paint) null);
            copyFrom(newBitmap);
            return;
        }
        validateBitmapSize(b);
        validateBitmapFormat(b);
        this.mRS.nAllocationCopyFromBitmap(getID(this.mRS), b);
    }

    public void copyFrom(Allocation a) {
        this.mRS.validate();
        if (this.mType.equals(a.getType())) {
            copy2DRangeFrom(0, 0, this.mCurrentDimX, this.mCurrentDimY, a, 0, 0);
            return;
        }
        throw new RSIllegalArgumentException("Types of allocations must match.");
    }

    public void setFromFieldPacker(int xoff, FieldPacker fp) {
        this.mRS.validate();
        int eSize = this.mType.mElement.getBytesSize();
        byte[] data = fp.getData();
        int data_length = fp.getPos();
        int count = data_length / eSize;
        if (eSize * count == data_length) {
            copy1DRangeFromUnchecked(xoff, count, data);
            return;
        }
        throw new RSIllegalArgumentException("Field packer length " + data_length + " not divisible by element size " + eSize + ".");
    }

    public void setFromFieldPacker(int xoff, int component_number, FieldPacker fp) {
        this.mRS.validate();
        if (component_number >= this.mType.mElement.mElements.length) {
            throw new RSIllegalArgumentException("Component_number " + component_number + " out of range.");
        } else if (xoff >= 0) {
            byte[] data = fp.getData();
            int data_length = fp.getPos();
            int eSize = this.mType.mElement.mElements[component_number].getBytesSize() * this.mType.mElement.mArraySizes[component_number];
            if (data_length == eSize) {
                this.mRS.nAllocationElementData1D(getIDSafe(), xoff, this.mSelectedLOD, component_number, data, data_length);
                return;
            }
            throw new RSIllegalArgumentException("Field packer sizelength " + data_length + " does not match component size " + eSize + ".");
        } else {
            throw new RSIllegalArgumentException("Offset must be >= 0.");
        }
    }

    private void data1DChecks(int off, int count, int len, int dataSize, boolean usePadding) {
        this.mRS.validate();
        if (off < 0) {
            throw new RSIllegalArgumentException("Offset must be >= 0.");
        } else if (count < 1) {
            throw new RSIllegalArgumentException("Count must be >= 1.");
        } else if (off + count > this.mCurrentCount) {
            throw new RSIllegalArgumentException("Overflow, Available count " + this.mCurrentCount + ", got " + count + " at offset " + off + ".");
        } else if (usePadding) {
            if (len < (dataSize / 4) * 3) {
                throw new RSIllegalArgumentException("Array too small for allocation type.");
            }
        } else if (len < dataSize) {
            throw new RSIllegalArgumentException("Array too small for allocation type.");
        }
    }

    public void generateMipmaps() {
        this.mRS.nAllocationGenerateMipmaps(getID(this.mRS));
    }

    private void copy1DRangeFromUnchecked(int off, int count, Object array, Element.DataType dt, int arrayLen) {
        boolean usePadding;
        int dataSize = this.mType.mElement.getBytesSize() * count;
        if (!this.mAutoPadding || this.mType.getElement().getVectorSize() != 3) {
            usePadding = false;
        } else {
            usePadding = true;
        }
        Element.DataType dataType = dt;
        data1DChecks(off, count, arrayLen * dataType.mSize, dataSize, usePadding);
        this.mRS.nAllocationData1D(getIDSafe(), off, this.mSelectedLOD, count, array, dataSize, dataType, this.mType.mElement.mType.mSize, usePadding);
    }

    public void copy1DRangeFromUnchecked(int off, int count, Object array) {
        copy1DRangeFromUnchecked(off, count, array, validateObjectIsPrimitiveArray(array, false), Array.getLength(array));
    }

    public void copy1DRangeFromUnchecked(int off, int count, int[] d) {
        copy1DRangeFromUnchecked(off, count, d, Element.DataType.SIGNED_32, d.length);
    }

    public void copy1DRangeFromUnchecked(int off, int count, short[] d) {
        copy1DRangeFromUnchecked(off, count, d, Element.DataType.SIGNED_16, d.length);
    }

    public void copy1DRangeFromUnchecked(int off, int count, byte[] d) {
        copy1DRangeFromUnchecked(off, count, d, Element.DataType.SIGNED_8, d.length);
    }

    public void copy1DRangeFromUnchecked(int off, int count, float[] d) {
        copy1DRangeFromUnchecked(off, count, d, Element.DataType.FLOAT_32, d.length);
    }

    public void copy1DRangeFrom(int off, int count, Object array) {
        copy1DRangeFromUnchecked(off, count, array, validateObjectIsPrimitiveArray(array, true), Array.getLength(array));
    }

    public void copy1DRangeFrom(int off, int count, int[] d) {
        validateIsInt32();
        copy1DRangeFromUnchecked(off, count, d, Element.DataType.SIGNED_32, d.length);
    }

    public void copy1DRangeFrom(int off, int count, short[] d) {
        validateIsInt16();
        copy1DRangeFromUnchecked(off, count, d, Element.DataType.SIGNED_16, d.length);
    }

    public void copy1DRangeFrom(int off, int count, byte[] d) {
        validateIsInt8();
        copy1DRangeFromUnchecked(off, count, d, Element.DataType.SIGNED_8, d.length);
    }

    public void copy1DRangeFrom(int off, int count, float[] d) {
        validateIsFloat32();
        copy1DRangeFromUnchecked(off, count, d, Element.DataType.FLOAT_32, d.length);
    }

    public void copy1DRangeFrom(int off, int count, Allocation data, int dataOff) {
        Allocation allocation = data;
        this.mRS.nAllocationData2D(getIDSafe(), off, 0, this.mSelectedLOD, this.mSelectedFace.mID, count, 1, allocation.getID(this.mRS), dataOff, 0, allocation.mSelectedLOD, allocation.mSelectedFace.mID);
    }

    private void validate2DRange(int xoff, int yoff, int w, int h) {
        if (this.mAdaptedAllocation == null) {
            if (xoff < 0 || yoff < 0) {
                throw new RSIllegalArgumentException("Offset cannot be negative.");
            } else if (h < 0 || w < 0) {
                throw new RSIllegalArgumentException("Height or width cannot be negative.");
            } else if (xoff + w > this.mCurrentDimX || yoff + h > this.mCurrentDimY) {
                throw new RSIllegalArgumentException("Updated region larger than allocation.");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void copy2DRangeFromUnchecked(int xoff, int yoff, int w, int h, Object array, Element.DataType dt, int arrayLen) {
        int sizeBytes;
        boolean usePadding;
        this.mRS.validate();
        validate2DRange(xoff, yoff, w, h);
        int dataSize = this.mType.mElement.getBytesSize() * w * h;
        int sizeBytes2 = dt.mSize * arrayLen;
        if (!this.mAutoPadding || this.mType.getElement().getVectorSize() != 3) {
            if (dataSize <= sizeBytes2) {
                usePadding = false;
                sizeBytes = sizeBytes2;
            } else {
                throw new RSIllegalArgumentException("Array too small for allocation type.");
            }
        } else if ((dataSize / 4) * 3 <= sizeBytes2) {
            usePadding = true;
            sizeBytes = dataSize;
        } else {
            throw new RSIllegalArgumentException("Array too small for allocation type.");
        }
        this.mRS.nAllocationData2D(getIDSafe(), xoff, yoff, this.mSelectedLOD, this.mSelectedFace.mID, w, h, array, sizeBytes, dt, this.mType.mElement.mType.mSize, usePadding);
    }

    public void copy2DRangeFrom(int xoff, int yoff, int w, int h, Object array) {
        copy2DRangeFromUnchecked(xoff, yoff, w, h, array, validateObjectIsPrimitiveArray(array, true), Array.getLength(array));
    }

    public void copy2DRangeFrom(int xoff, int yoff, int w, int h, byte[] data) {
        validateIsInt8();
        copy2DRangeFromUnchecked(xoff, yoff, w, h, data, Element.DataType.SIGNED_8, data.length);
    }

    public void copy2DRangeFrom(int xoff, int yoff, int w, int h, short[] data) {
        validateIsInt16();
        copy2DRangeFromUnchecked(xoff, yoff, w, h, data, Element.DataType.SIGNED_16, data.length);
    }

    public void copy2DRangeFrom(int xoff, int yoff, int w, int h, int[] data) {
        validateIsInt32();
        copy2DRangeFromUnchecked(xoff, yoff, w, h, data, Element.DataType.SIGNED_32, data.length);
    }

    public void copy2DRangeFrom(int xoff, int yoff, int w, int h, float[] data) {
        validateIsFloat32();
        copy2DRangeFromUnchecked(xoff, yoff, w, h, data, Element.DataType.FLOAT_32, data.length);
    }

    public void copy2DRangeFrom(int xoff, int yoff, int w, int h, Allocation data, int dataXoff, int dataYoff) {
        Allocation allocation = data;
        this.mRS.validate();
        validate2DRange(xoff, yoff, w, h);
        this.mRS.nAllocationData2D(getIDSafe(), xoff, yoff, this.mSelectedLOD, this.mSelectedFace.mID, w, h, allocation.getID(this.mRS), dataXoff, dataYoff, allocation.mSelectedLOD, allocation.mSelectedFace.mID);
    }

    public void copy2DRangeFrom(int xoff, int yoff, Bitmap data) {
        this.mRS.validate();
        if (data.getConfig() == null) {
            Bitmap newBitmap = Bitmap.createBitmap(data.getWidth(), data.getHeight(), Bitmap.Config.ARGB_8888);
            new Canvas(newBitmap).drawBitmap(data, 0.0f, 0.0f, (Paint) null);
            copy2DRangeFrom(xoff, yoff, newBitmap);
            return;
        }
        validateBitmapFormat(data);
        validate2DRange(xoff, yoff, data.getWidth(), data.getHeight());
        this.mRS.nAllocationData2D(getIDSafe(), xoff, yoff, this.mSelectedLOD, this.mSelectedFace.mID, data);
    }

    private void validate3DRange(int xoff, int yoff, int zoff, int w, int h, int d) {
        if (this.mAdaptedAllocation == null) {
            if (xoff < 0 || yoff < 0 || zoff < 0) {
                throw new RSIllegalArgumentException("Offset cannot be negative.");
            } else if (h < 0 || w < 0 || d < 0) {
                throw new RSIllegalArgumentException("Height or width cannot be negative.");
            } else if (xoff + w > this.mCurrentDimX || yoff + h > this.mCurrentDimY || zoff + d > this.mCurrentDimZ) {
                throw new RSIllegalArgumentException("Updated region larger than allocation.");
            }
        }
    }

    private void copy3DRangeFromUnchecked(int xoff, int yoff, int zoff, int w, int h, int d, Object array, Element.DataType dt, int arrayLen) {
        int sizeBytes;
        boolean usePadding;
        this.mRS.validate();
        validate3DRange(xoff, yoff, zoff, w, h, d);
        int dataSize = this.mType.mElement.getBytesSize() * w * h * d;
        int sizeBytes2 = dt.mSize * arrayLen;
        if (!this.mAutoPadding || this.mType.getElement().getVectorSize() != 3) {
            if (dataSize <= sizeBytes2) {
                usePadding = false;
                sizeBytes = sizeBytes2;
            } else {
                throw new RSIllegalArgumentException("Array too small for allocation type.");
            }
        } else if ((dataSize / 4) * 3 <= sizeBytes2) {
            usePadding = true;
            sizeBytes = dataSize;
        } else {
            throw new RSIllegalArgumentException("Array too small for allocation type.");
        }
        this.mRS.nAllocationData3D(getIDSafe(), xoff, yoff, zoff, this.mSelectedLOD, w, h, d, array, sizeBytes, dt, this.mType.mElement.mType.mSize, usePadding);
    }

    public void copy3DRangeFrom(int xoff, int yoff, int zoff, int w, int h, int d, Object array) {
        copy3DRangeFromUnchecked(xoff, yoff, zoff, w, h, d, array, validateObjectIsPrimitiveArray(array, true), Array.getLength(array));
    }

    public void copy3DRangeFrom(int xoff, int yoff, int zoff, int w, int h, int d, Allocation data, int dataXoff, int dataYoff, int dataZoff) {
        Allocation allocation = data;
        this.mRS.validate();
        validate3DRange(xoff, yoff, zoff, w, h, d);
        this.mRS.nAllocationData3D(getIDSafe(), xoff, yoff, zoff, this.mSelectedLOD, w, h, d, allocation.getID(this.mRS), dataXoff, dataYoff, dataZoff, allocation.mSelectedLOD);
    }

    public void copyTo(Bitmap b) {
        this.mRS.validate();
        validateBitmapFormat(b);
        validateBitmapSize(b);
        this.mRS.nAllocationCopyToBitmap(getID(this.mRS), b);
    }

    private void copyTo(Object array, Element.DataType dt, int arrayLen) {
        this.mRS.validate();
        boolean usePadding = false;
        if (this.mAutoPadding && this.mType.getElement().getVectorSize() == 3) {
            usePadding = true;
        }
        if (usePadding) {
            if (dt.mSize * arrayLen < (this.mSize / 4) * 3) {
                throw new RSIllegalArgumentException("Size of output array cannot be smaller than size of allocation.");
            }
        } else if (dt.mSize * arrayLen < this.mSize) {
            throw new RSIllegalArgumentException("Size of output array cannot be smaller than size of allocation.");
        }
        this.mRS.nAllocationRead(getID(this.mRS), array, dt, this.mType.mElement.mType.mSize, usePadding);
    }

    public void copyTo(Object array) {
        copyTo(array, validateObjectIsPrimitiveArray(array, true), Array.getLength(array));
    }

    public void copyTo(byte[] d) {
        validateIsInt8();
        copyTo(d, Element.DataType.SIGNED_8, d.length);
    }

    public void copyTo(short[] d) {
        validateIsInt16();
        copyTo(d, Element.DataType.SIGNED_16, d.length);
    }

    public void copyTo(int[] d) {
        validateIsInt32();
        copyTo(d, Element.DataType.SIGNED_32, d.length);
    }

    public void copyTo(float[] d) {
        validateIsFloat32();
        copyTo(d, Element.DataType.FLOAT_32, d.length);
    }

    private void copy1DRangeToUnchecked(int off, int count, Object array, Element.DataType dt, int arrayLen) {
        boolean usePadding;
        int dataSize = this.mType.mElement.getBytesSize() * count;
        if (!this.mAutoPadding || this.mType.getElement().getVectorSize() != 3) {
            usePadding = false;
        } else {
            usePadding = true;
        }
        Element.DataType dataType = dt;
        data1DChecks(off, count, arrayLen * dataType.mSize, dataSize, usePadding);
        this.mRS.nAllocationRead1D(getIDSafe(), off, this.mSelectedLOD, count, array, dataSize, dataType, this.mType.mElement.mType.mSize, usePadding);
    }

    public void copy1DRangeToUnchecked(int off, int count, Object array) {
        copy1DRangeToUnchecked(off, count, array, validateObjectIsPrimitiveArray(array, false), Array.getLength(array));
    }

    public void copy1DRangeToUnchecked(int off, int count, int[] d) {
        copy1DRangeToUnchecked(off, count, d, Element.DataType.SIGNED_32, d.length);
    }

    public void copy1DRangeToUnchecked(int off, int count, short[] d) {
        copy1DRangeToUnchecked(off, count, d, Element.DataType.SIGNED_16, d.length);
    }

    public void copy1DRangeToUnchecked(int off, int count, byte[] d) {
        copy1DRangeToUnchecked(off, count, d, Element.DataType.SIGNED_8, d.length);
    }

    public void copy1DRangeToUnchecked(int off, int count, float[] d) {
        copy1DRangeToUnchecked(off, count, d, Element.DataType.FLOAT_32, d.length);
    }

    public void copy1DRangeTo(int off, int count, Object array) {
        copy1DRangeToUnchecked(off, count, array, validateObjectIsPrimitiveArray(array, true), Array.getLength(array));
    }

    public void copy1DRangeTo(int off, int count, int[] d) {
        validateIsInt32();
        copy1DRangeToUnchecked(off, count, d, Element.DataType.SIGNED_32, d.length);
    }

    public void copy1DRangeTo(int off, int count, short[] d) {
        validateIsInt16();
        copy1DRangeToUnchecked(off, count, d, Element.DataType.SIGNED_16, d.length);
    }

    public void copy1DRangeTo(int off, int count, byte[] d) {
        validateIsInt8();
        copy1DRangeToUnchecked(off, count, d, Element.DataType.SIGNED_8, d.length);
    }

    public void copy1DRangeTo(int off, int count, float[] d) {
        validateIsFloat32();
        copy1DRangeToUnchecked(off, count, d, Element.DataType.FLOAT_32, d.length);
    }

    /* access modifiers changed from: package-private */
    public void copy2DRangeToUnchecked(int xoff, int yoff, int w, int h, Object array, Element.DataType dt, int arrayLen) {
        int sizeBytes;
        boolean usePadding;
        this.mRS.validate();
        validate2DRange(xoff, yoff, w, h);
        int dataSize = this.mType.mElement.getBytesSize() * w * h;
        int sizeBytes2 = dt.mSize * arrayLen;
        if (!this.mAutoPadding || this.mType.getElement().getVectorSize() != 3) {
            if (dataSize <= sizeBytes2) {
                usePadding = false;
                sizeBytes = sizeBytes2;
            } else {
                throw new RSIllegalArgumentException("Array too small for allocation type.");
            }
        } else if ((dataSize / 4) * 3 <= sizeBytes2) {
            usePadding = true;
            sizeBytes = dataSize;
        } else {
            throw new RSIllegalArgumentException("Array too small for allocation type.");
        }
        this.mRS.nAllocationRead2D(getIDSafe(), xoff, yoff, this.mSelectedLOD, this.mSelectedFace.mID, w, h, array, sizeBytes, dt, this.mType.mElement.mType.mSize, usePadding);
    }

    public void copy2DRangeTo(int xoff, int yoff, int w, int h, Object array) {
        copy2DRangeToUnchecked(xoff, yoff, w, h, array, validateObjectIsPrimitiveArray(array, true), Array.getLength(array));
    }

    public void copy2DRangeTo(int xoff, int yoff, int w, int h, byte[] data) {
        validateIsInt8();
        copy2DRangeToUnchecked(xoff, yoff, w, h, data, Element.DataType.SIGNED_8, data.length);
    }

    public void copy2DRangeTo(int xoff, int yoff, int w, int h, short[] data) {
        validateIsInt16();
        copy2DRangeToUnchecked(xoff, yoff, w, h, data, Element.DataType.SIGNED_16, data.length);
    }

    public void copy2DRangeTo(int xoff, int yoff, int w, int h, int[] data) {
        validateIsInt32();
        copy2DRangeToUnchecked(xoff, yoff, w, h, data, Element.DataType.SIGNED_32, data.length);
    }

    public void copy2DRangeTo(int xoff, int yoff, int w, int h, float[] data) {
        validateIsFloat32();
        copy2DRangeToUnchecked(xoff, yoff, w, h, data, Element.DataType.FLOAT_32, data.length);
    }

    static {
        BitmapFactory.Options options = new BitmapFactory.Options();
        mBitmapOptions = options;
        options.inScaled = false;
    }

    public static Allocation createTyped(RenderScript rs, Type type, MipmapControl mips, int usage) {
        RenderScript renderScript = rs;
        Type type2 = type;
        rs.validate();
        if (type.getID(rs) == 0) {
            MipmapControl mipmapControl = mips;
            throw new RSInvalidStateException("Bad Type");
        } else if (rs.usingIO() || (usage & 32) == 0) {
            long id = rs.nAllocationCreateTyped(type.getID(rs), mips.mID, usage, 0);
            if (id != 0) {
                return new Allocation(id, rs, type, usage);
            }
            throw new RSRuntimeException("Allocation creation failed.");
        } else {
            throw new RSRuntimeException("USAGE_IO not supported, Allocation creation failed.");
        }
    }

    public static Allocation createTyped(RenderScript rs, Type type, int usage) {
        return createTyped(rs, type, MipmapControl.MIPMAP_NONE, usage);
    }

    public static Allocation createTyped(RenderScript rs, Type type) {
        return createTyped(rs, type, MipmapControl.MIPMAP_NONE, 1);
    }

    public static Allocation createSized(RenderScript rs, Element e, int count, int usage) {
        RenderScript renderScript = rs;
        rs.validate();
        Element element = e;
        Type.Builder b = new Type.Builder(rs, e);
        b.setX(count);
        Type t = b.create();
        long id = rs.nAllocationCreateTyped(t.getID(rs), MipmapControl.MIPMAP_NONE.mID, usage, 0);
        if (id != 0) {
            return new Allocation(id, rs, t, usage);
        }
        throw new RSRuntimeException("Allocation creation failed.");
    }

    public static Allocation createSized(RenderScript rs, Element e, int count) {
        return createSized(rs, e, count, 1);
    }

    static Element elementFromBitmap(RenderScript rs, Bitmap b) {
        Bitmap.Config bc = b.getConfig();
        if (bc == Bitmap.Config.ALPHA_8) {
            return Element.A_8(rs);
        }
        if (bc == Bitmap.Config.ARGB_4444) {
            return Element.RGBA_4444(rs);
        }
        if (bc == Bitmap.Config.ARGB_8888) {
            return Element.RGBA_8888(rs);
        }
        if (bc == Bitmap.Config.RGB_565) {
            return Element.RGB_565(rs);
        }
        throw new RSInvalidStateException("Bad bitmap type: " + bc);
    }

    static Type typeFromBitmap(RenderScript rs, Bitmap b, MipmapControl mip) {
        Type.Builder tb = new Type.Builder(rs, elementFromBitmap(rs, b));
        tb.setX(b.getWidth());
        tb.setY(b.getHeight());
        tb.setMipmaps(mip == MipmapControl.MIPMAP_FULL);
        return tb.create();
    }

    public static Allocation createFromBitmap(RenderScript rs, Bitmap b, MipmapControl mips, int usage) {
        RenderScript renderScript = rs;
        Bitmap bitmap = b;
        MipmapControl mipmapControl = mips;
        int i = usage;
        rs.validate();
        if (b.getConfig() != null) {
            Type t = typeFromBitmap(rs, b, mips);
            if (mipmapControl == MipmapControl.MIPMAP_NONE && t.getElement().isCompatible(Element.RGBA_8888(rs)) && i == 131) {
                long id = rs.nAllocationCreateBitmapBackedAllocation(t.getID(renderScript), mipmapControl.mID, b, usage);
                if (id != 0) {
                    Allocation alloc = new Allocation(id, rs, t, usage);
                    alloc.setBitmap(bitmap);
                    return alloc;
                }
                throw new RSRuntimeException("Load failed.");
            }
            long id2 = rs.nAllocationCreateFromBitmap(t.getID(renderScript), mipmapControl.mID, b, usage);
            if (id2 != 0) {
                return new Allocation(id2, rs, t, usage);
            }
            throw new RSRuntimeException("Load failed.");
        } else if ((i & 128) == 0) {
            Bitmap newBitmap = Bitmap.createBitmap(b.getWidth(), b.getHeight(), Bitmap.Config.ARGB_8888);
            new Canvas(newBitmap).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            return createFromBitmap(renderScript, newBitmap, mipmapControl, i);
        } else {
            throw new RSIllegalArgumentException("USAGE_SHARED cannot be used with a Bitmap that has a null config.");
        }
    }

    public void setSurface(Surface sur) {
        this.mRS.validate();
        if ((this.mUsage & 64) != 0) {
            this.mRS.nAllocationSetSurface(getID(this.mRS), sur);
            return;
        }
        throw new RSInvalidStateException("Allocation is not USAGE_IO_OUTPUT.");
    }

    public static Allocation createFromBitmap(RenderScript rs, Bitmap b) {
        return createFromBitmap(rs, b, MipmapControl.MIPMAP_NONE, ScriptIntrinsicBLAS.NON_UNIT);
    }

    public static Allocation createCubemapFromBitmap(RenderScript rs, Bitmap b, MipmapControl mips, int usage) {
        RenderScript renderScript = rs;
        MipmapControl mipmapControl = mips;
        rs.validate();
        int height = b.getHeight();
        int width = b.getWidth();
        if (width % 6 != 0) {
            Bitmap bitmap = b;
            throw new RSIllegalArgumentException("Cubemap height must be multiple of 6");
        } else if (width / 6 == height) {
            boolean z = false;
            if (((height + -1) & height) == 0) {
                Element e = elementFromBitmap(rs, b);
                Type.Builder tb = new Type.Builder(renderScript, e);
                tb.setX(height);
                tb.setY(height);
                tb.setFaces(true);
                if (mipmapControl == MipmapControl.MIPMAP_FULL) {
                    z = true;
                }
                tb.setMipmaps(z);
                Type t = tb.create();
                long id = rs.nAllocationCubeCreateFromBitmap(t.getID(renderScript), mipmapControl.mID, b, usage);
                if (id != 0) {
                    return new Allocation(id, rs, t, usage);
                }
                throw new RSRuntimeException("Load failed for bitmap " + b + " element " + e);
            }
            Bitmap bitmap2 = b;
            throw new RSIllegalArgumentException("Only power of 2 cube faces supported");
        } else {
            Bitmap bitmap3 = b;
            throw new RSIllegalArgumentException("Only square cube map faces supported");
        }
    }

    public static Allocation createCubemapFromBitmap(RenderScript rs, Bitmap b) {
        return createCubemapFromBitmap(rs, b, MipmapControl.MIPMAP_NONE, 2);
    }

    public static Allocation createCubemapFromCubeFaces(RenderScript rs, Bitmap xpos, Bitmap xneg, Bitmap ypos, Bitmap yneg, Bitmap zpos, Bitmap zneg, MipmapControl mips, int usage) {
        return null;
    }

    public static Allocation createCubemapFromCubeFaces(RenderScript rs, Bitmap xpos, Bitmap xneg, Bitmap ypos, Bitmap yneg, Bitmap zpos, Bitmap zneg) {
        return createCubemapFromCubeFaces(rs, xpos, xneg, ypos, yneg, zpos, zneg, MipmapControl.MIPMAP_NONE, 2);
    }

    public static Allocation createFromBitmapResource(RenderScript rs, Resources res, int id, MipmapControl mips, int usage) {
        rs.validate();
        if ((usage & 224) == 0) {
            Bitmap b = BitmapFactory.decodeResource(res, id);
            Allocation alloc = createFromBitmap(rs, b, mips, usage);
            b.recycle();
            return alloc;
        }
        throw new RSIllegalArgumentException("Unsupported usage specified.");
    }

    public static Allocation createFromBitmapResource(RenderScript rs, Resources res, int id) {
        return createFromBitmapResource(rs, res, id, MipmapControl.MIPMAP_NONE, 3);
    }

    public static Allocation createFromString(RenderScript rs, String str, int usage) {
        rs.validate();
        try {
            byte[] allocArray = str.getBytes(Key.STRING_CHARSET_NAME);
            Allocation alloc = createSized(rs, Element.U8(rs), allocArray.length, usage);
            alloc.copyFrom(allocArray);
            return alloc;
        } catch (Exception e) {
            throw new RSRuntimeException("Could not convert string to utf-8.");
        }
    }

    public void destroy() {
        if (this.mIncCompatAllocation != 0) {
            boolean shouldDestroy = false;
            synchronized (this) {
                if (!this.mIncAllocDestroyed) {
                    shouldDestroy = true;
                    this.mIncAllocDestroyed = true;
                }
            }
            if (shouldDestroy) {
                ReentrantReadWriteLock.ReadLock rlock = this.mRS.mRWLock.readLock();
                rlock.lock();
                if (this.mRS.isAlive()) {
                    this.mRS.nIncObjDestroy(this.mIncCompatAllocation);
                }
                rlock.unlock();
                this.mIncCompatAllocation = 0;
            }
        }
        if ((this.mUsage & 96) != 0) {
            setSurface((Surface) null);
        }
        super.destroy();
    }
}
