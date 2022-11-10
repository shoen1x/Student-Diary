package androidx.renderscript;

import android.os.Build;
import androidx.renderscript.Script;

public class ScriptIntrinsicResize extends ScriptIntrinsic {
    private static final int INTRINSIC_API_LEVEL = 21;
    private Allocation mInput;

    protected ScriptIntrinsicResize(long id, RenderScript rs) {
        super(id, rs);
    }

    public static ScriptIntrinsicResize create(RenderScript rs) {
        boolean mUseIncSupp = rs.isUseNative() && Build.VERSION.SDK_INT < 21;
        ScriptIntrinsicResize si = new ScriptIntrinsicResize(rs.nScriptIntrinsicCreate(12, 0, mUseIncSupp), rs);
        si.setIncSupp(mUseIncSupp);
        return si;
    }

    public void setInput(Allocation ain) {
        Element e = ain.getElement();
        if (e.isCompatible(Element.U8(this.mRS)) || e.isCompatible(Element.U8_2(this.mRS)) || e.isCompatible(Element.U8_3(this.mRS)) || e.isCompatible(Element.U8_4(this.mRS)) || e.isCompatible(Element.F32(this.mRS)) || e.isCompatible(Element.F32_2(this.mRS)) || e.isCompatible(Element.F32_3(this.mRS)) || e.isCompatible(Element.F32_4(this.mRS))) {
            this.mInput = ain;
            setVar(0, (BaseObj) ain);
            return;
        }
        throw new RSIllegalArgumentException("Unsupported element type.");
    }

    public Script.FieldID getFieldID_Input() {
        return createFieldID(0, (Element) null);
    }

    public void forEach_bicubic(Allocation aout) {
        if (aout != this.mInput) {
            forEach_bicubic(aout, (Script.LaunchOptions) null);
            return;
        }
        throw new RSIllegalArgumentException("Output cannot be same as Input.");
    }

    public void forEach_bicubic(Allocation aout, Script.LaunchOptions opt) {
        forEach(0, (Allocation) null, aout, (FieldPacker) null, opt);
    }

    public Script.KernelID getKernelID_bicubic() {
        return createKernelID(0, 2, (Element) null, (Element) null);
    }
}
