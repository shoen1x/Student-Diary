package androidx.renderscript;

import android.os.Build;
import androidx.renderscript.Script;

public class ScriptIntrinsicBlend extends ScriptIntrinsic {
    private static final int INTRINSIC_API_LEVEL = 19;

    ScriptIntrinsicBlend(long id, RenderScript rs) {
        super(id, rs);
    }

    public static ScriptIntrinsicBlend create(RenderScript rs, Element e) {
        boolean mUseIncSupp = rs.isUseNative() && Build.VERSION.SDK_INT < 19;
        ScriptIntrinsicBlend si = new ScriptIntrinsicBlend(rs.nScriptIntrinsicCreate(7, e.getID(rs), mUseIncSupp), rs);
        si.setIncSupp(mUseIncSupp);
        return si;
    }

    private void blend(int id, Allocation ain, Allocation aout) {
        if (!ain.getElement().isCompatible(Element.U8_4(this.mRS))) {
            throw new RSIllegalArgumentException("Input is not of expected format.");
        } else if (aout.getElement().isCompatible(Element.U8_4(this.mRS))) {
            forEach(id, ain, aout, (FieldPacker) null);
        } else {
            throw new RSIllegalArgumentException("Output is not of expected format.");
        }
    }

    public void forEachClear(Allocation ain, Allocation aout) {
        blend(0, ain, aout);
    }

    public Script.KernelID getKernelIDClear() {
        return createKernelID(0, 3, (Element) null, (Element) null);
    }

    public void forEachSrc(Allocation ain, Allocation aout) {
        blend(1, ain, aout);
    }

    public Script.KernelID getKernelIDSrc() {
        return createKernelID(1, 3, (Element) null, (Element) null);
    }

    public void forEachDst(Allocation ain, Allocation aout) {
    }

    public Script.KernelID getKernelIDDst() {
        return createKernelID(2, 3, (Element) null, (Element) null);
    }

    public void forEachSrcOver(Allocation ain, Allocation aout) {
        blend(3, ain, aout);
    }

    public Script.KernelID getKernelIDSrcOver() {
        return createKernelID(3, 3, (Element) null, (Element) null);
    }

    public void forEachDstOver(Allocation ain, Allocation aout) {
        blend(4, ain, aout);
    }

    public Script.KernelID getKernelIDDstOver() {
        return createKernelID(4, 3, (Element) null, (Element) null);
    }

    public void forEachSrcIn(Allocation ain, Allocation aout) {
        blend(5, ain, aout);
    }

    public Script.KernelID getKernelIDSrcIn() {
        return createKernelID(5, 3, (Element) null, (Element) null);
    }

    public void forEachDstIn(Allocation ain, Allocation aout) {
        blend(6, ain, aout);
    }

    public Script.KernelID getKernelIDDstIn() {
        return createKernelID(6, 3, (Element) null, (Element) null);
    }

    public void forEachSrcOut(Allocation ain, Allocation aout) {
        blend(7, ain, aout);
    }

    public Script.KernelID getKernelIDSrcOut() {
        return createKernelID(7, 3, (Element) null, (Element) null);
    }

    public void forEachDstOut(Allocation ain, Allocation aout) {
        blend(8, ain, aout);
    }

    public Script.KernelID getKernelIDDstOut() {
        return createKernelID(8, 3, (Element) null, (Element) null);
    }

    public void forEachSrcAtop(Allocation ain, Allocation aout) {
        blend(9, ain, aout);
    }

    public Script.KernelID getKernelIDSrcAtop() {
        return createKernelID(9, 3, (Element) null, (Element) null);
    }

    public void forEachDstAtop(Allocation ain, Allocation aout) {
        blend(10, ain, aout);
    }

    public Script.KernelID getKernelIDDstAtop() {
        return createKernelID(10, 3, (Element) null, (Element) null);
    }

    public void forEachXor(Allocation ain, Allocation aout) {
        blend(11, ain, aout);
    }

    public Script.KernelID getKernelIDXor() {
        return createKernelID(11, 3, (Element) null, (Element) null);
    }

    public void forEachMultiply(Allocation ain, Allocation aout) {
        blend(14, ain, aout);
    }

    public Script.KernelID getKernelIDMultiply() {
        return createKernelID(14, 3, (Element) null, (Element) null);
    }

    public void forEachAdd(Allocation ain, Allocation aout) {
        blend(34, ain, aout);
    }

    public Script.KernelID getKernelIDAdd() {
        return createKernelID(34, 3, (Element) null, (Element) null);
    }

    public void forEachSubtract(Allocation ain, Allocation aout) {
        blend(35, ain, aout);
    }

    public Script.KernelID getKernelIDSubtract() {
        return createKernelID(35, 3, (Element) null, (Element) null);
    }
}
