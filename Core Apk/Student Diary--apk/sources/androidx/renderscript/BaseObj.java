package androidx.renderscript;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BaseObj {
    private boolean mDestroyed = false;
    private long mID;
    RenderScript mRS;

    BaseObj(long id, RenderScript rs) {
        rs.validate();
        this.mRS = rs;
        this.mID = id;
    }

    /* access modifiers changed from: package-private */
    public void setID(long id) {
        if (this.mID == 0) {
            this.mID = id;
            return;
        }
        throw new RSRuntimeException("Internal Error, reset of object ID.");
    }

    /* access modifiers changed from: package-private */
    public long getID(RenderScript rs) {
        this.mRS.validate();
        if (this.mDestroyed) {
            throw new RSInvalidStateException("using a destroyed object.");
        } else if (this.mID == 0) {
            throw new RSRuntimeException("Internal error: Object id 0.");
        } else if (rs == null || rs == this.mRS) {
            return this.mID;
        } else {
            throw new RSInvalidStateException("using object with mismatched context.");
        }
    }

    /* access modifiers changed from: package-private */
    public android.renderscript.BaseObj getNObj() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public void checkValid() {
        if (this.mID == 0 && getNObj() == null) {
            throw new RSIllegalArgumentException("Invalid object.");
        }
    }

    private void helpDestroy() {
        boolean shouldDestroy = false;
        synchronized (this) {
            if (!this.mDestroyed) {
                shouldDestroy = true;
                this.mDestroyed = true;
            }
        }
        if (shouldDestroy) {
            ReentrantReadWriteLock.ReadLock rlock = this.mRS.mRWLock.readLock();
            rlock.lock();
            if (this.mRS.isAlive()) {
                this.mRS.nObjDestroy(this.mID);
            }
            rlock.unlock();
            this.mRS = null;
            this.mID = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        helpDestroy();
        super.finalize();
    }

    public void destroy() {
        if (!this.mDestroyed) {
            helpDestroy();
            return;
        }
        throw new RSInvalidStateException("Object already destroyed.");
    }

    public int hashCode() {
        long j = this.mID;
        return (int) ((j >> 32) ^ (268435455 & j));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this.mID == ((BaseObj) obj).mID) {
            return true;
        }
        return false;
    }
}
