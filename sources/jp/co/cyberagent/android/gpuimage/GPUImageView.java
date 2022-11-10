package jp.co.cyberagent.android.gpuimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.core.view.ViewCompat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.IntBuffer;
import java.util.concurrent.Semaphore;
import jp.co.cyberagent.android.gpuimage.GPUImage;

public class GPUImageView extends FrameLayout {
    private GPUImageFilter mFilter;
    public Size mForceSize = null;
    /* access modifiers changed from: private */
    public GLSurfaceView mGLSurfaceView;
    private GPUImage mGPUImage;
    private float mRatio = 0.0f;

    public interface OnPictureSavedListener {
        void onPictureSaved(Uri uri);
    }

    public GPUImageView(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    public GPUImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        GPUImageGLSurfaceView gPUImageGLSurfaceView = new GPUImageGLSurfaceView(context, attrs);
        this.mGLSurfaceView = gPUImageGLSurfaceView;
        addView(gPUImageGLSurfaceView);
        GPUImage gPUImage = new GPUImage(getContext());
        this.mGPUImage = gPUImage;
        gPUImage.setGLSurfaceView(this.mGLSurfaceView);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int newHeight;
        int newHeight2;
        if (this.mRatio != 0.0f) {
            int width = View.MeasureSpec.getSize(widthMeasureSpec);
            int height = View.MeasureSpec.getSize(heightMeasureSpec);
            float f = this.mRatio;
            if (((float) width) / f < ((float) height)) {
                newHeight2 = width;
                newHeight = Math.round(((float) width) / f);
            } else {
                int round = Math.round(((float) height) * f);
                newHeight = height;
                newHeight2 = round;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(newHeight2, 1073741824), View.MeasureSpec.makeMeasureSpec(newHeight, 1073741824));
            return;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public GPUImage getGPUImage() {
        return this.mGPUImage;
    }

    public void setBackgroundColor(float red, float green, float blue) {
        this.mGPUImage.setBackgroundColor(red, green, blue);
    }

    public void setRatio(float ratio) {
        this.mRatio = ratio;
        this.mGLSurfaceView.requestLayout();
        this.mGPUImage.deleteImage();
    }

    public void setScaleType(GPUImage.ScaleType scaleType) {
        this.mGPUImage.setScaleType(scaleType);
    }

    public void setRotation(Rotation rotation) {
        this.mGPUImage.setRotation(rotation);
        requestRender();
    }

    public void setFilter(GPUImageFilter filter) {
        this.mFilter = filter;
        this.mGPUImage.setFilter(filter);
        requestRender();
    }

    public GPUImageFilter getFilter() {
        return this.mFilter;
    }

    public void setImage(Bitmap bitmap) {
        this.mGPUImage.setImage(bitmap);
    }

    public void setImage(Uri uri) {
        this.mGPUImage.setImage(uri);
    }

    public void setImage(File file) {
        this.mGPUImage.setImage(file);
    }

    public void requestRender() {
        this.mGLSurfaceView.requestRender();
    }

    public void saveToPictures(String folderName, String fileName, OnPictureSavedListener listener) {
        new SaveTask(this, folderName, fileName, listener).execute(new Void[0]);
    }

    public void saveToPictures(String folderName, String fileName, int width, int height, OnPictureSavedListener listener) {
        new SaveTask(folderName, fileName, width, height, listener).execute(new Void[0]);
    }

    public Bitmap capture(int width, int height) throws InterruptedException {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mForceSize = new Size(width, height);
            final Semaphore waiter = new Semaphore(0);
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    if (Build.VERSION.SDK_INT < 16) {
                        GPUImageView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    } else {
                        GPUImageView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                    waiter.release();
                }
            });
            post(new Runnable() {
                public void run() {
                    GPUImageView gPUImageView = GPUImageView.this;
                    GPUImageView gPUImageView2 = GPUImageView.this;
                    gPUImageView.addView(new LoadingView(gPUImageView2.getContext()));
                    GPUImageView.this.mGLSurfaceView.requestLayout();
                }
            });
            waiter.acquire();
            this.mGPUImage.runOnGLThread(new Runnable() {
                public void run() {
                    waiter.release();
                }
            });
            requestRender();
            waiter.acquire();
            Bitmap bitmap = capture();
            this.mForceSize = null;
            post(new Runnable() {
                public void run() {
                    GPUImageView.this.mGLSurfaceView.requestLayout();
                }
            });
            requestRender();
            postDelayed(new Runnable() {
                public void run() {
                    GPUImageView.this.removeViewAt(1);
                }
            }, 300);
            return bitmap;
        }
        throw new IllegalStateException("Do not call this method from the UI thread!");
    }

    public Bitmap capture() throws InterruptedException {
        final Semaphore waiter = new Semaphore(0);
        int width = this.mGLSurfaceView.getMeasuredWidth();
        int height = this.mGLSurfaceView.getMeasuredHeight();
        int[] pixelMirroredArray = new int[(width * height)];
        final int i = width;
        final int i2 = height;
        final int[] iArr = pixelMirroredArray;
        this.mGPUImage.runOnGLThread(new Runnable() {
            public void run() {
                IntBuffer pixelBuffer = IntBuffer.allocate(i * i2);
                GLES20.glReadPixels(0, 0, i, i2, 6408, 5121, pixelBuffer);
                int[] pixelArray = pixelBuffer.array();
                for (int i = 0; i < i2; i++) {
                    int j = 0;
                    while (true) {
                        int i2 = i;
                        if (j >= i2) {
                            break;
                        }
                        iArr[(((i2 - i) - 1) * i2) + j] = pixelArray[(i2 * i) + j];
                        j++;
                    }
                }
                waiter.release();
            }
        });
        requestRender();
        waiter.acquire();
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmap.copyPixelsFromBuffer(IntBuffer.wrap(pixelMirroredArray));
        return bitmap;
    }

    public void onPause() {
        this.mGLSurfaceView.onPause();
    }

    public void onResume() {
        this.mGLSurfaceView.onResume();
    }

    public static class Size {
        int height;
        int width;

        public Size(int width2, int height2) {
            this.width = width2;
            this.height = height2;
        }
    }

    private class GPUImageGLSurfaceView extends GLSurfaceView {
        public GPUImageGLSurfaceView(Context context) {
            super(context);
        }

        public GPUImageGLSurfaceView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            if (GPUImageView.this.mForceSize != null) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(GPUImageView.this.mForceSize.width, 1073741824), View.MeasureSpec.makeMeasureSpec(GPUImageView.this.mForceSize.height, 1073741824));
            } else {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }
        }
    }

    private class LoadingView extends FrameLayout {
        public LoadingView(Context context) {
            super(context);
            init();
        }

        public LoadingView(Context context, AttributeSet attrs) {
            super(context, attrs);
            init();
        }

        public LoadingView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            init();
        }

        private void init() {
            ProgressBar view = new ProgressBar(getContext());
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            addView(view);
            setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    private class SaveTask extends AsyncTask<Void, Void, Void> {
        private final String mFileName;
        private final String mFolderName;
        /* access modifiers changed from: private */
        public final Handler mHandler;
        private final int mHeight;
        /* access modifiers changed from: private */
        public final OnPictureSavedListener mListener;
        private final int mWidth;

        public SaveTask(GPUImageView gPUImageView, String folderName, String fileName, OnPictureSavedListener listener) {
            this(folderName, fileName, 0, 0, listener);
        }

        public SaveTask(String folderName, String fileName, int width, int height, OnPictureSavedListener listener) {
            this.mFolderName = folderName;
            this.mFileName = fileName;
            this.mWidth = width;
            this.mHeight = height;
            this.mListener = listener;
            this.mHandler = new Handler();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            try {
                saveImage(this.mFolderName, this.mFileName, this.mWidth != 0 ? GPUImageView.this.capture(this.mWidth, this.mHeight) : GPUImageView.this.capture());
                return null;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        }

        private void saveImage(String folderName, String fileName, Bitmap image) {
            File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            File file = new File(path, folderName + "/" + fileName);
            try {
                file.getParentFile().mkdirs();
                image.compress(Bitmap.CompressFormat.JPEG, 80, new FileOutputStream(file));
                MediaScannerConnection.scanFile(GPUImageView.this.getContext(), new String[]{file.toString()}, (String[]) null, new MediaScannerConnection.OnScanCompletedListener() {
                    public void onScanCompleted(String path, final Uri uri) {
                        if (SaveTask.this.mListener != null) {
                            SaveTask.this.mHandler.post(new Runnable() {
                                public void run() {
                                    SaveTask.this.mListener.onPictureSaved(uri);
                                }
                            });
                        }
                    }
                });
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
