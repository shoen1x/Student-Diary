package androidx.renderscript;

import android.os.Build;
import androidx.renderscript.Script;

public class ScriptIntrinsic3DLUT extends ScriptIntrinsic {
    private static final int INTRINSIC_API_LEVEL = 19;
    private Element mElement;
    private Allocation mLUT;

    protected ScriptIntrinsic3DLUT(long id, RenderScript rs, Element e) {
        super(id, rs);
        this.mElement = e;
    }

    public static ScriptIntrinsic3DLUT create(RenderScript rs, Element e) {
        if (e.isCompatible(Element.U8_4(rs))) {
            boolean mUseIncSupp = rs.isUseNative() && Build.VERSION.SDK_INT < 19;
            ScriptIntrinsic3DLUT si = new ScriptIntrinsic3DLUT(rs.nScriptIntrinsicCreate(8, e.getID(rs), mUseIncSupp), rs, e);
            si.setIncSupp(mUseIncSupp);
            return si;
        }
        throw new RSIllegalArgumentException("Element must be compatible with uchar4.");
    }

    public void setLUT(Allocation lut) {
        Type t = lut.getType();
        if (t.getZ() == 0) {
            throw new RSIllegalArgumentException("LUT must be 3d.");
        } else if (t.getElement().isCompatible(this.mElement)) {
            this.mLUT = lut;
            setVar(0, (BaseObj) lut);
        } else {
            throw new RSIllegalArgumentException("LUT element type must match.");
        }
    }

    public void forEach(Allocation ain, Allocation aout) {
        forEach(0, ain, aout, (FieldPacker) null);
    }

    public Script.KernelID getKernelID() {
        return createKernelID(0, 3, (Element) null, (Element) null);
    }
}
