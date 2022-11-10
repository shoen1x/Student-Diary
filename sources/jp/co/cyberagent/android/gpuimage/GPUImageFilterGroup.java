package jp.co.cyberagent.android.gpuimage;

import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;
import jp.co.cyberagent.android.gpuimage.util.TextureRotationUtil;

public class GPUImageFilterGroup extends GPUImageFilter {
    protected List<GPUImageFilter> mFilters;
    private int[] mFrameBufferTextures;
    private int[] mFrameBuffers;
    private final FloatBuffer mGLCubeBuffer;
    private final FloatBuffer mGLTextureBuffer;
    private final FloatBuffer mGLTextureFlipBuffer;
    protected List<GPUImageFilter> mMergedFilters;

    public GPUImageFilterGroup() {
        this((List<GPUImageFilter>) null);
    }

    public GPUImageFilterGroup(List<GPUImageFilter> filters) {
        this.mFilters = filters;
        if (filters == null) {
            this.mFilters = new ArrayList();
        } else {
            updateMergedFilters();
        }
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(GPUImageRenderer.CUBE.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mGLCubeBuffer = asFloatBuffer;
        asFloatBuffer.put(GPUImageRenderer.CUBE).position(0);
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(TextureRotationUtil.TEXTURE_NO_ROTATION.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mGLTextureBuffer = asFloatBuffer2;
        asFloatBuffer2.put(TextureRotationUtil.TEXTURE_NO_ROTATION).position(0);
        float[] flipTexture = TextureRotationUtil.getRotation(Rotation.NORMAL, false, true);
        FloatBuffer asFloatBuffer3 = ByteBuffer.allocateDirect(flipTexture.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mGLTextureFlipBuffer = asFloatBuffer3;
        asFloatBuffer3.put(flipTexture).position(0);
    }

    public void addFilter(GPUImageFilter aFilter) {
        if (aFilter != null) {
            this.mFilters.add(aFilter);
            updateMergedFilters();
        }
    }

    public void onInit() {
        super.onInit();
        for (GPUImageFilter filter : this.mFilters) {
            filter.init();
        }
    }

    public void onDestroy() {
        destroyFramebuffers();
        for (GPUImageFilter filter : this.mFilters) {
            filter.destroy();
        }
        super.onDestroy();
    }

    private void destroyFramebuffers() {
        int[] iArr = this.mFrameBufferTextures;
        if (iArr != null) {
            GLES20.glDeleteTextures(iArr.length, iArr, 0);
            this.mFrameBufferTextures = null;
        }
        int[] iArr2 = this.mFrameBuffers;
        if (iArr2 != null) {
            GLES20.glDeleteFramebuffers(iArr2.length, iArr2, 0);
            this.mFrameBuffers = null;
        }
    }

    public void onOutputSizeChanged(int width, int height) {
        super.onOutputSizeChanged(width, height);
        if (this.mFrameBuffers != null) {
            destroyFramebuffers();
        }
        int size = this.mFilters.size();
        for (int i = 0; i < size; i++) {
            this.mFilters.get(i).onOutputSizeChanged(width, height);
        }
        List<GPUImageFilter> list = this.mMergedFilters;
        if (list != null && list.size() > 0) {
            int size2 = this.mMergedFilters.size();
            this.mFrameBuffers = new int[(size2 - 1)];
            this.mFrameBufferTextures = new int[(size2 - 1)];
            for (int i2 = 0; i2 < size2 - 1; i2++) {
                GLES20.glGenFramebuffers(1, this.mFrameBuffers, i2);
                GLES20.glGenTextures(1, this.mFrameBufferTextures, i2);
                GLES20.glBindTexture(3553, this.mFrameBufferTextures[i2]);
                GLES20.glTexImage2D(3553, 0, 6408, width, height, 0, 6408, 5121, (Buffer) null);
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
                GLES20.glBindFramebuffer(36160, this.mFrameBuffers[i2]);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mFrameBufferTextures[i2], 0);
                GLES20.glBindTexture(3553, 0);
                GLES20.glBindFramebuffer(36160, 0);
            }
        }
    }

    public void onDraw(int textureId, FloatBuffer cubeBuffer, FloatBuffer textureBuffer) {
        List<GPUImageFilter> list;
        runPendingOnDrawTasks();
        if (isInitialized() && this.mFrameBuffers != null && this.mFrameBufferTextures != null && (list = this.mMergedFilters) != null) {
            int size = list.size();
            int previousTexture = textureId;
            int i = 0;
            while (i < size) {
                GPUImageFilter filter = this.mMergedFilters.get(i);
                boolean isNotLast = i < size + -1;
                if (isNotLast) {
                    GLES20.glBindFramebuffer(36160, this.mFrameBuffers[i]);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                }
                if (i == 0) {
                    filter.onDraw(previousTexture, cubeBuffer, textureBuffer);
                } else if (i == size - 1) {
                    filter.onDraw(previousTexture, this.mGLCubeBuffer, size % 2 == 0 ? this.mGLTextureFlipBuffer : this.mGLTextureBuffer);
                } else {
                    filter.onDraw(previousTexture, this.mGLCubeBuffer, this.mGLTextureBuffer);
                }
                if (isNotLast) {
                    GLES20.glBindFramebuffer(36160, 0);
                    previousTexture = this.mFrameBufferTextures[i];
                }
                i++;
            }
        }
    }

    public List<GPUImageFilter> getFilters() {
        return this.mFilters;
    }

    public List<GPUImageFilter> getMergedFilters() {
        return this.mMergedFilters;
    }

    public void updateMergedFilters() {
        if (this.mFilters != null) {
            List<GPUImageFilter> list = this.mMergedFilters;
            if (list == null) {
                this.mMergedFilters = new ArrayList();
            } else {
                list.clear();
            }
            for (GPUImageFilter filter : this.mFilters) {
                if (filter instanceof GPUImageFilterGroup) {
                    ((GPUImageFilterGroup) filter).updateMergedFilters();
                    List<GPUImageFilter> filters = ((GPUImageFilterGroup) filter).getMergedFilters();
                    if (filters != null && !filters.isEmpty()) {
                        this.mMergedFilters.addAll(filters);
                    }
                } else {
                    this.mMergedFilters.add(filter);
                }
            }
        }
    }
}
