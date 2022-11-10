package androidx.renderscript;

import android.os.Build;
import androidx.renderscript.Script;

public class ScriptIntrinsicBlur extends ScriptIntrinsic {
    private static final int INTRINSIC_API_LEVEL = 19;
    private Allocation mInput;
    private final float[] mValues = new float[9];

    protected ScriptIntrinsicBlur(long id, RenderScript rs) {
        super(id, rs);
    }

    public static ScriptIntrinsicBlur create(RenderScript rs, Element e) {
        if (e.isCompatible(Element.U8_4(rs)) || e.isCompatible(Element.U8(rs))) {
            boolean mUseIncSupp = rs.isUseNative() && Build.VERSION.SDK_INT < 19;
            ScriptIntrinsicBlur si = new ScriptIntrinsicBlur(rs.nScriptIntrinsicCreate(5, e.getID(rs), mUseIncSupp), rs);
            si.setIncSupp(mUseIncSupp);
            si.setRadius(5.0f);
            return si;
        }
        throw new RSIllegalArgumentException("Unsupported element type.");
    }

    public void setInput(Allocation ain) {
        if (ain.getType().getY() != 0) {
            this.mInput = ain;
            setVar(1, (BaseObj) ain);
            return;
        }
        throw new RSIllegalArgumentException("Input set to a 1D Allocation");
    }

    public void setRadius(float radius) {
        if (radius <= 0.0f || radius > 25.0f) {
            throw new RSIllegalArgumentException("Radius out of range (0 < r <= 25).");
        }
        setVar(0, radius);
    }

    public void forEach(Allocation aout) {
        if (aout.getType().getY() != 0) {
            forEach(0, (Allocation) null, aout, (FieldPacker) null);
            return;
        }
        throw new RSIllegalArgumentException("Output is a 1D Allocation");
    }

    public Script.KernelID getKernelID() {
        return createKernelID(0, 2, (Element) null, (Element) null);
    }

    public Script.FieldID getFieldID_Input() {
        return createFieldID(1, (Element) null);
    }
}
