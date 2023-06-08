package jp.co.cyberagent.android.gpuimage;

public class GPUImageSmoothToonFilter extends GPUImageFilterGroup {
    GPUImageGaussianBlurFilter blurFilter;
    GPUImageToonFilter toonFilter;

    public GPUImageSmoothToonFilter() {
        GPUImageGaussianBlurFilter gPUImageGaussianBlurFilter = new GPUImageGaussianBlurFilter();
        this.blurFilter = gPUImageGaussianBlurFilter;
        addFilter(gPUImageGaussianBlurFilter);
        GPUImageToonFilter gPUImageToonFilter = new GPUImageToonFilter();
        this.toonFilter = gPUImageToonFilter;
        addFilter(gPUImageToonFilter);
        getFilters().add(this.blurFilter);
        setBlurSize(0.5f);
        setThreshold(0.2f);
        setQuantizationLevels(10.0f);
    }

    public void setTexelWidth(float value) {
        this.toonFilter.setTexelWidth(value);
    }

    public void setTexelHeight(float value) {
        this.toonFilter.setTexelHeight(value);
    }

    public void setBlurSize(float value) {
        this.blurFilter.setBlurSize(value);
    }

    public void setThreshold(float value) {
        this.toonFilter.setThreshold(value);
    }

    public void setQuantizationLevels(float value) {
        this.toonFilter.setQuantizationLevels(value);
    }
}
