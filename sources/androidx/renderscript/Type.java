package androidx.renderscript;

public class Type extends BaseObj {
    boolean mDimFaces;
    boolean mDimMipmaps;
    int mDimX;
    int mDimY;
    int mDimYuv;
    int mDimZ;
    Element mElement;
    int mElementCount;

    public enum CubemapFace {
        POSITIVE_X(0),
        NEGATIVE_X(1),
        POSITIVE_Y(2),
        NEGATIVE_Y(3),
        POSITIVE_Z(4),
        NEGATIVE_Z(5);
        
        int mID;

        private CubemapFace(int id) {
            this.mID = id;
        }
    }

    public Element getElement() {
        return this.mElement;
    }

    public int getX() {
        return this.mDimX;
    }

    public int getY() {
        return this.mDimY;
    }

    public int getZ() {
        return this.mDimZ;
    }

    public int getYuv() {
        return this.mDimYuv;
    }

    public boolean hasMipmaps() {
        return this.mDimMipmaps;
    }

    public boolean hasFaces() {
        return this.mDimFaces;
    }

    public int getCount() {
        return this.mElementCount;
    }

    /* access modifiers changed from: package-private */
    public void calcElementCount() {
        boolean hasLod = hasMipmaps();
        int x = getX();
        int y = getY();
        int z = getZ();
        int faces = 1;
        if (hasFaces()) {
            faces = 6;
        }
        if (x == 0) {
            x = 1;
        }
        if (y == 0) {
            y = 1;
        }
        if (z == 0) {
            z = 1;
        }
        int count = x * y * z * faces;
        while (hasLod && (x > 1 || y > 1 || z > 1)) {
            if (x > 1) {
                x >>= 1;
            }
            if (y > 1) {
                y >>= 1;
            }
            if (z > 1) {
                z >>= 1;
            }
            count += x * y * z * faces;
        }
        this.mElementCount = count;
    }

    Type(long id, RenderScript rs) {
        super(id, rs);
    }

    public long getDummyType(RenderScript mRS, long eid) {
        return mRS.nIncTypeCreate(eid, this.mDimX, this.mDimY, this.mDimZ, this.mDimMipmaps, this.mDimFaces, this.mDimYuv);
    }

    public static Type createX(RenderScript rs, Element e, int dimX) {
        if (dimX >= 1) {
            Type t = new Type(rs.nTypeCreate(e.getID(rs), dimX, 0, 0, false, false, 0), rs);
            t.mElement = e;
            t.mDimX = dimX;
            t.calcElementCount();
            return t;
        }
        throw new RSInvalidStateException("Dimension must be >= 1.");
    }

    public static Type createXY(RenderScript rs, Element e, int dimX, int dimY) {
        if (dimX < 1 || dimY < 1) {
            throw new RSInvalidStateException("Dimension must be >= 1.");
        }
        Type t = new Type(rs.nTypeCreate(e.getID(rs), dimX, dimY, 0, false, false, 0), rs);
        t.mElement = e;
        t.mDimX = dimX;
        t.mDimY = dimY;
        t.calcElementCount();
        return t;
    }

    public static Type createXYZ(RenderScript rs, Element e, int dimX, int dimY, int dimZ) {
        if (dimX < 1 || dimY < 1 || dimZ < 1) {
            throw new RSInvalidStateException("Dimension must be >= 1.");
        }
        Type t = new Type(rs.nTypeCreate(e.getID(rs), dimX, dimY, dimZ, false, false, 0), rs);
        t.mElement = e;
        t.mDimX = dimX;
        t.mDimY = dimY;
        t.mDimZ = dimZ;
        t.calcElementCount();
        return t;
    }

    public static class Builder {
        boolean mDimFaces;
        boolean mDimMipmaps;
        int mDimX = 1;
        int mDimY;
        int mDimZ;
        Element mElement;
        RenderScript mRS;
        int mYuv;

        public Builder(RenderScript rs, Element e) {
            e.checkValid();
            this.mRS = rs;
            this.mElement = e;
        }

        public Builder setX(int value) {
            if (value >= 1) {
                this.mDimX = value;
                return this;
            }
            throw new RSIllegalArgumentException("Values of less than 1 for Dimension X are not valid.");
        }

        public Builder setY(int value) {
            if (value >= 1) {
                this.mDimY = value;
                return this;
            }
            throw new RSIllegalArgumentException("Values of less than 1 for Dimension Y are not valid.");
        }

        public Builder setZ(int value) {
            if (value >= 1) {
                this.mDimZ = value;
                return this;
            }
            throw new RSIllegalArgumentException("Values of less than 1 for Dimension Z are not valid.");
        }

        public Builder setMipmaps(boolean value) {
            this.mDimMipmaps = value;
            return this;
        }

        public Builder setFaces(boolean value) {
            this.mDimFaces = value;
            return this;
        }

        public Builder setYuvFormat(int yuvFormat) {
            if (yuvFormat == 17 || yuvFormat == 842094169) {
                this.mYuv = yuvFormat;
                return this;
            }
            throw new RSIllegalArgumentException("Only NV21 and YV12 are supported..");
        }

        public Type create() {
            if (this.mDimZ > 0) {
                if (this.mDimX < 1 || this.mDimY < 1) {
                    throw new RSInvalidStateException("Both X and Y dimension required when Z is present.");
                } else if (this.mDimFaces) {
                    throw new RSInvalidStateException("Cube maps not supported with 3D types.");
                }
            }
            if (this.mDimY > 0 && this.mDimX < 1) {
                throw new RSInvalidStateException("X dimension required when Y is present.");
            } else if (this.mDimFaces && this.mDimY < 1) {
                throw new RSInvalidStateException("Cube maps require 2D Types.");
            } else if (this.mYuv == 0 || (this.mDimZ == 0 && !this.mDimFaces && !this.mDimMipmaps)) {
                RenderScript renderScript = this.mRS;
                Type t = new Type(renderScript.nTypeCreate(this.mElement.getID(renderScript), this.mDimX, this.mDimY, this.mDimZ, this.mDimMipmaps, this.mDimFaces, this.mYuv), this.mRS);
                t.mElement = this.mElement;
                t.mDimX = this.mDimX;
                t.mDimY = this.mDimY;
                t.mDimZ = this.mDimZ;
                t.mDimMipmaps = this.mDimMipmaps;
                t.mDimFaces = this.mDimFaces;
                t.mDimYuv = this.mYuv;
                t.calcElementCount();
                return t;
            } else {
                throw new RSInvalidStateException("YUV only supports basic 2D.");
            }
        }
    }
}
