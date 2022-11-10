package androidx.renderscript;

import android.os.Build;
import androidx.renderscript.Script;

public class ScriptIntrinsicConvolve3x3 extends ScriptIntrinsic {
    private static final int INTRINSIC_API_LEVEL = 19;
    private Allocation mInput;
    private final float[] mValues = new float[9];

    ScriptIntrinsicConvolve3x3(long id, RenderScript rs) {
        super(id, rs);
    }

    public static ScriptIntrinsicConvolve3x3 create(RenderScript rs, Element e) {
        float[] f = {0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        if (e.isCompatible(Element.U8(rs)) || e.isCompatible(Element.U8_2(rs)) || e.isCompatible(Element.U8_3(rs)) || e.isCompatible(Element.U8_4(rs)) || e.isCompatible(Element.F32(rs)) || e.isCompatible(Element.F32_2(rs)) || e.isCompatible(Element.F32_3(rs)) || e.isCompatible(Element.F32_4(rs))) {
            boolean mUseIncSupp = rs.isUseNative() && Build.VERSION.SDK_INT < 19;
            ScriptIntrinsicConvolve3x3 si = new ScriptIntrinsicConvolve3x3(rs.nScriptIntrinsicCreate(1, e.getID(rs), mUseIncSupp), rs);
            si.setIncSupp(mUseIncSupp);
            si.setCoefficients(f);
            return si;
        }
        throw new RSIllegalArgumentException("Unsupported element type.");
    }

    public void setInput(Allocation ain) {
        this.mInput = ain;
        setVar(1, (BaseObj) ain);
    }

    public void setCoefficients(float[] v) {
        FieldPacker fp = new FieldPacker(36);
        int ct = 0;
        while (true) {
            float[] fArr = this.mValues;
            if (ct < fArr.length) {
                fArr[ct] = v[ct];
                fp.addF32(fArr[ct]);
                ct++;
            } else {
                setVar(0, fp);
                return;
            }
        }
    }

    public void forEach(Allocation aout) {
        forEach(0, (Allocation) null, aout, (FieldPacker) null);
    }

    public void forEach(Allocation aout, Script.LaunchOptions opt) {
        forEach(0, (Allocation) null, aout, (FieldPacker) null, opt);
    }

    public Script.KernelID getKernelID() {
        return createKernelID(0, 2, (Element) null, (Element) null);
    }

    public Script.FieldID getFieldID_Input() {
        return createFieldID(1, (Element) null);
    }
}
