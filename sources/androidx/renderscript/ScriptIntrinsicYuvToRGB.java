package androidx.renderscript;

import android.os.Build;
import androidx.renderscript.Script;

public class ScriptIntrinsicYuvToRGB extends ScriptIntrinsic {
    private static final int INTRINSIC_API_LEVEL = 19;
    private Allocation mInput;

    ScriptIntrinsicYuvToRGB(long id, RenderScript rs) {
        super(id, rs);
    }

    public static ScriptIntrinsicYuvToRGB create(RenderScript rs, Element e) {
        boolean mUseIncSupp = rs.isUseNative() && Build.VERSION.SDK_INT < 19;
        ScriptIntrinsicYuvToRGB si = new ScriptIntrinsicYuvToRGB(rs.nScriptIntrinsicCreate(6, e.getID(rs), mUseIncSupp), rs);
        si.setIncSupp(mUseIncSupp);
        return si;
    }

    public void setInput(Allocation ain) {
        this.mInput = ain;
        setVar(0, (BaseObj) ain);
    }

    public void forEach(Allocation aout) {
        forEach(0, (Allocation) null, aout, (FieldPacker) null);
    }

    public Script.KernelID getKernelID() {
        return createKernelID(0, 2, (Element) null, (Element) null);
    }

    public Script.FieldID getFieldID_Input() {
        return createFieldID(0, (Element) null);
    }
}
