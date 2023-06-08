package androidx.renderscript;

import android.os.Build;
import androidx.renderscript.Script;
import com.google.firebase.database.core.ValidationPath;

public class ScriptIntrinsicLUT extends ScriptIntrinsic {
    private static final int INTRINSIC_API_LEVEL = 19;
    private final byte[] mCache = new byte[1024];
    private boolean mDirty = true;
    private final Matrix4f mMatrix = new Matrix4f();
    private Allocation mTables;

    protected ScriptIntrinsicLUT(long id, RenderScript rs) {
        super(id, rs);
    }

    public static ScriptIntrinsicLUT create(RenderScript rs, Element e) {
        boolean mUseIncSupp = rs.isUseNative() && Build.VERSION.SDK_INT < 19;
        ScriptIntrinsicLUT si = new ScriptIntrinsicLUT(rs.nScriptIntrinsicCreate(3, e.getID(rs), mUseIncSupp), rs);
        si.setIncSupp(mUseIncSupp);
        si.mTables = Allocation.createSized(rs, Element.U8(rs), 1024);
        for (int ct = 0; ct < 256; ct++) {
            byte[] bArr = si.mCache;
            bArr[ct] = (byte) ct;
            bArr[ct + 256] = (byte) ct;
            bArr[ct + 512] = (byte) ct;
            bArr[ct + ValidationPath.MAX_PATH_LENGTH_BYTES] = (byte) ct;
        }
        si.setVar(0, (BaseObj) si.mTables);
        return si;
    }

    private void validate(int index, int value) {
        if (index < 0 || index > 255) {
            throw new RSIllegalArgumentException("Index out of range (0-255).");
        } else if (value < 0 || value > 255) {
            throw new RSIllegalArgumentException("Value out of range (0-255).");
        }
    }

    public void setRed(int index, int value) {
        validate(index, value);
        this.mCache[index] = (byte) value;
        this.mDirty = true;
    }

    public void setGreen(int index, int value) {
        validate(index, value);
        this.mCache[index + 256] = (byte) value;
        this.mDirty = true;
    }

    public void setBlue(int index, int value) {
        validate(index, value);
        this.mCache[index + 512] = (byte) value;
        this.mDirty = true;
    }

    public void setAlpha(int index, int value) {
        validate(index, value);
        this.mCache[index + ValidationPath.MAX_PATH_LENGTH_BYTES] = (byte) value;
        this.mDirty = true;
    }

    public void forEach(Allocation ain, Allocation aout) {
        if (this.mDirty) {
            this.mDirty = false;
            this.mTables.copyFromUnchecked(this.mCache);
        }
        forEach(0, ain, aout, (FieldPacker) null);
    }

    public Script.KernelID getKernelID() {
        return createKernelID(0, 3, (Element) null, (Element) null);
    }
}
