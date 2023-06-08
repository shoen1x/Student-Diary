package androidx.renderscript;

import android.renderscript.Script;
import android.util.SparseArray;
import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;

public class Script extends BaseObj {
    private final SparseArray<FieldID> mFIDs = new SparseArray<>();
    private final SparseArray<InvokeID> mIIDs = new SparseArray<>();
    private final SparseArray<KernelID> mKIDs = new SparseArray<>();
    private boolean mUseIncSupp = false;

    /* access modifiers changed from: protected */
    public void setIncSupp(boolean useInc) {
        this.mUseIncSupp = useInc;
    }

    /* access modifiers changed from: protected */
    public boolean isIncSupp() {
        return this.mUseIncSupp;
    }

    /* access modifiers changed from: package-private */
    public long getDummyAlloc(Allocation ain) {
        if (ain == null) {
            return 0;
        }
        Type inType = ain.getType();
        long dummyAlloc = this.mRS.nIncAllocationCreateTyped(ain.getID(this.mRS), inType.getDummyType(this.mRS, inType.getElement().getDummyElement(this.mRS)), inType.getX() * inType.getElement().getBytesSize());
        ain.setIncAllocID(dummyAlloc);
        return dummyAlloc;
    }

    public static final class KernelID extends BaseObj {
        Script.KernelID mN;
        Script mScript;
        int mSig;
        int mSlot;

        KernelID(long id, RenderScript rs, Script s, int slot, int sig) {
            super(id, rs);
            this.mScript = s;
            this.mSlot = slot;
            this.mSig = sig;
        }
    }

    /* access modifiers changed from: protected */
    public KernelID createKernelID(int slot, int sig, Element ein, Element eout) {
        int i = slot;
        KernelID k = this.mKIDs.get(slot);
        if (k != null) {
            return k;
        }
        long id = this.mRS.nScriptKernelIDCreate(getID(this.mRS), slot, sig, this.mUseIncSupp);
        if (id != 0) {
            KernelID k2 = new KernelID(id, this.mRS, this, slot, sig);
            this.mKIDs.put(slot, k2);
            return k2;
        }
        throw new RSDriverException("Failed to create KernelID");
    }

    public static final class InvokeID extends BaseObj {
        Script mScript;
        int mSlot;

        InvokeID(long id, RenderScript rs, Script s, int slot) {
            super(id, rs);
            this.mScript = s;
            this.mSlot = slot;
        }
    }

    /* access modifiers changed from: protected */
    public InvokeID createInvokeID(int slot) {
        InvokeID i = this.mIIDs.get(slot);
        if (i != null) {
            return i;
        }
        long id = this.mRS.nScriptInvokeIDCreate(getID(this.mRS), slot);
        if (id != 0) {
            InvokeID i2 = new InvokeID(id, this.mRS, this, slot);
            this.mIIDs.put(slot, i2);
            return i2;
        }
        throw new RSDriverException("Failed to create KernelID");
    }

    public static final class FieldID extends BaseObj {
        Script.FieldID mN;
        Script mScript;
        int mSlot;

        FieldID(long id, RenderScript rs, Script s, int slot) {
            super(id, rs);
            this.mScript = s;
            this.mSlot = slot;
        }
    }

    /* access modifiers changed from: protected */
    public FieldID createFieldID(int slot, Element e) {
        FieldID f = this.mFIDs.get(slot);
        if (f != null) {
            return f;
        }
        long id = this.mRS.nScriptFieldIDCreate(getID(this.mRS), slot, this.mUseIncSupp);
        if (id != 0) {
            FieldID f2 = new FieldID(id, this.mRS, this, slot);
            this.mFIDs.put(slot, f2);
            return f2;
        }
        throw new RSDriverException("Failed to create FieldID");
    }

    /* access modifiers changed from: protected */
    public void invoke(int slot) {
        this.mRS.nScriptInvoke(getID(this.mRS), slot, this.mUseIncSupp);
    }

    /* access modifiers changed from: protected */
    public void invoke(int slot, FieldPacker v) {
        if (v != null) {
            this.mRS.nScriptInvokeV(getID(this.mRS), slot, v.getData(), this.mUseIncSupp);
            return;
        }
        this.mRS.nScriptInvoke(getID(this.mRS), slot, this.mUseIncSupp);
    }

    public void bindAllocation(Allocation va, int slot) {
        Allocation allocation = va;
        this.mRS.validate();
        if (allocation != null) {
            this.mRS.nScriptBindAllocation(getID(this.mRS), allocation.getID(this.mRS), slot, this.mUseIncSupp);
            return;
        }
        this.mRS.nScriptBindAllocation(getID(this.mRS), 0, slot, this.mUseIncSupp);
    }

    public void setTimeZone(String timeZone) {
        this.mRS.validate();
        try {
            this.mRS.nScriptSetTimeZone(getID(this.mRS), timeZone.getBytes(Key.STRING_CHARSET_NAME), this.mUseIncSupp);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    public void forEach(int slot, Allocation ain, Allocation aout, FieldPacker v) {
        byte[] params;
        Allocation allocation = ain;
        Allocation allocation2 = aout;
        if (allocation == null && allocation2 == null) {
            throw new RSIllegalArgumentException("At least one of ain or aout is required to be non-null.");
        }
        long in_id = 0;
        long out_id = 0;
        if (allocation != null) {
            in_id = allocation.getID(this.mRS);
        }
        if (allocation2 != null) {
            out_id = allocation2.getID(this.mRS);
        }
        if (v != null) {
            params = v.getData();
        } else {
            params = null;
        }
        if (this.mUseIncSupp) {
            this.mRS.nScriptForEach(getID(this.mRS), slot, getDummyAlloc(allocation), getDummyAlloc(allocation2), params, this.mUseIncSupp);
            return;
        }
        this.mRS.nScriptForEach(getID(this.mRS), slot, in_id, out_id, params, this.mUseIncSupp);
    }

    /* access modifiers changed from: protected */
    public void forEach(int slot, Allocation ain, Allocation aout, FieldPacker v, LaunchOptions sc) {
        byte[] params;
        Allocation allocation = ain;
        Allocation allocation2 = aout;
        if (allocation == null && allocation2 == null) {
            throw new RSIllegalArgumentException("At least one of ain or aout is required to be non-null.");
        } else if (sc == null) {
            forEach(slot, ain, aout, v);
        } else {
            long in_id = 0;
            long out_id = 0;
            if (allocation != null) {
                in_id = allocation.getID(this.mRS);
            }
            if (allocation2 != null) {
                out_id = allocation2.getID(this.mRS);
            }
            if (v != null) {
                params = v.getData();
            } else {
                params = null;
            }
            if (this.mUseIncSupp) {
                this.mRS.nScriptForEachClipped(getID(this.mRS), slot, getDummyAlloc(allocation), getDummyAlloc(allocation2), params, sc.xstart, sc.xend, sc.ystart, sc.yend, sc.zstart, sc.zend, this.mUseIncSupp);
                return;
            }
            this.mRS.nScriptForEachClipped(getID(this.mRS), slot, in_id, out_id, params, sc.xstart, sc.xend, sc.ystart, sc.yend, sc.zstart, sc.zend, this.mUseIncSupp);
        }
    }

    Script(long id, RenderScript rs) {
        super(id, rs);
    }

    /* access modifiers changed from: protected */
    public void forEach(int slot, Allocation[] ains, Allocation aout, FieldPacker v) {
        forEach(slot, ains, aout, v, (LaunchOptions) null);
    }

    /* access modifiers changed from: protected */
    public void forEach(int slot, Allocation[] ains, Allocation aout, FieldPacker v, LaunchOptions sc) {
        long[] in_ids;
        long out_id;
        byte[] params;
        int[] limits;
        Allocation[] allocationArr = ains;
        Allocation allocation = aout;
        this.mRS.validate();
        if (allocationArr != null) {
            for (Allocation ain : allocationArr) {
                this.mRS.validateObject(ain);
            }
        }
        this.mRS.validateObject(allocation);
        if (allocationArr == null && allocation == null) {
            throw new RSIllegalArgumentException("At least one of ain or aout is required to be non-null.");
        }
        if (allocationArr != null) {
            in_ids = new long[allocationArr.length];
            for (int index = 0; index < allocationArr.length; index++) {
                in_ids[index] = allocationArr[index].getID(this.mRS);
            }
        } else {
            in_ids = null;
        }
        if (allocation != null) {
            out_id = allocation.getID(this.mRS);
        } else {
            out_id = 0;
        }
        if (v != null) {
            params = v.getData();
        } else {
            params = null;
        }
        if (sc != null) {
            limits = new int[]{sc.xstart, sc.xend, sc.ystart, sc.yend, sc.zstart, sc.zend};
        } else {
            limits = null;
        }
        this.mRS.nScriptForEach(getID(this.mRS), slot, in_ids, out_id, params, limits);
    }

    /* access modifiers changed from: protected */
    public void reduce(int slot, Allocation[] ains, Allocation aout, LaunchOptions sc) {
        int[] limits;
        Allocation[] allocationArr = ains;
        Allocation allocation = aout;
        this.mRS.validate();
        if (allocationArr == null || allocationArr.length < 1) {
            throw new RSIllegalArgumentException("At least one input is required.");
        } else if (allocation != null) {
            for (Allocation ain : allocationArr) {
                this.mRS.validateObject(ain);
            }
            long[] in_ids = new long[allocationArr.length];
            for (int index = 0; index < allocationArr.length; index++) {
                in_ids[index] = allocationArr[index].getID(this.mRS);
            }
            long out_id = allocation.getID(this.mRS);
            if (sc != null) {
                limits = new int[]{sc.xstart, sc.xend, sc.ystart, sc.yend, sc.zstart, sc.zend};
            } else {
                limits = null;
            }
            this.mRS.nScriptReduce(getID(this.mRS), slot, in_ids, out_id, limits);
        } else {
            throw new RSIllegalArgumentException("aout is required to be non-null.");
        }
    }

    public void setVar(int index, float v) {
        this.mRS.nScriptSetVarF(getID(this.mRS), index, v, this.mUseIncSupp);
    }

    public void setVar(int index, double v) {
        this.mRS.nScriptSetVarD(getID(this.mRS), index, v, this.mUseIncSupp);
    }

    public void setVar(int index, int v) {
        this.mRS.nScriptSetVarI(getID(this.mRS), index, v, this.mUseIncSupp);
    }

    public void setVar(int index, long v) {
        this.mRS.nScriptSetVarJ(getID(this.mRS), index, v, this.mUseIncSupp);
    }

    public void setVar(int index, boolean v) {
        this.mRS.nScriptSetVarI(getID(this.mRS), index, v ? 1 : 0, this.mUseIncSupp);
    }

    public void setVar(int index, BaseObj o) {
        BaseObj baseObj = o;
        long j = 0;
        if (this.mUseIncSupp) {
            this.mRS.nScriptSetVarObj(getID(this.mRS), index, baseObj == null ? 0 : getDummyAlloc((Allocation) baseObj), this.mUseIncSupp);
            return;
        }
        RenderScript renderScript = this.mRS;
        long id = getID(this.mRS);
        if (baseObj != null) {
            j = baseObj.getID(this.mRS);
        }
        renderScript.nScriptSetVarObj(id, index, j, this.mUseIncSupp);
    }

    public void setVar(int index, FieldPacker v) {
        this.mRS.nScriptSetVarV(getID(this.mRS), index, v.getData(), this.mUseIncSupp);
    }

    public void setVar(int index, FieldPacker v, Element e, int[] dims) {
        Element element = e;
        if (this.mUseIncSupp) {
            this.mRS.nScriptSetVarVE(getID(this.mRS), index, v.getData(), element.getDummyElement(this.mRS), dims, this.mUseIncSupp);
            return;
        }
        this.mRS.nScriptSetVarVE(getID(this.mRS), index, v.getData(), element.getID(this.mRS), dims, this.mUseIncSupp);
    }

    public static class Builder {
        RenderScript mRS;

        Builder(RenderScript rs) {
            this.mRS = rs;
        }
    }

    public static class FieldBase {
        protected Allocation mAllocation;
        protected Element mElement;

        /* access modifiers changed from: protected */
        public void init(RenderScript rs, int dimx) {
            this.mAllocation = Allocation.createSized(rs, this.mElement, dimx, 1);
        }

        /* access modifiers changed from: protected */
        public void init(RenderScript rs, int dimx, int usages) {
            this.mAllocation = Allocation.createSized(rs, this.mElement, dimx, usages | 1);
        }

        protected FieldBase() {
        }

        public Element getElement() {
            return this.mElement;
        }

        public Type getType() {
            return this.mAllocation.getType();
        }

        public Allocation getAllocation() {
            return this.mAllocation;
        }

        public void updateAllocation() {
        }
    }

    public static final class LaunchOptions {
        private int strategy;
        /* access modifiers changed from: private */
        public int xend = 0;
        /* access modifiers changed from: private */
        public int xstart = 0;
        /* access modifiers changed from: private */
        public int yend = 0;
        /* access modifiers changed from: private */
        public int ystart = 0;
        /* access modifiers changed from: private */
        public int zend = 0;
        /* access modifiers changed from: private */
        public int zstart = 0;

        public LaunchOptions setX(int xstartArg, int xendArg) {
            if (xstartArg < 0 || xendArg <= xstartArg) {
                throw new RSIllegalArgumentException("Invalid dimensions");
            }
            this.xstart = xstartArg;
            this.xend = xendArg;
            return this;
        }

        public LaunchOptions setY(int ystartArg, int yendArg) {
            if (ystartArg < 0 || yendArg <= ystartArg) {
                throw new RSIllegalArgumentException("Invalid dimensions");
            }
            this.ystart = ystartArg;
            this.yend = yendArg;
            return this;
        }

        public LaunchOptions setZ(int zstartArg, int zendArg) {
            if (zstartArg < 0 || zendArg <= zstartArg) {
                throw new RSIllegalArgumentException("Invalid dimensions");
            }
            this.zstart = zstartArg;
            this.zend = zendArg;
            return this;
        }

        public int getXStart() {
            return this.xstart;
        }

        public int getXEnd() {
            return this.xend;
        }

        public int getYStart() {
            return this.ystart;
        }

        public int getYEnd() {
            return this.yend;
        }

        public int getZStart() {
            return this.zstart;
        }

        public int getZEnd() {
            return this.zend;
        }
    }
}
