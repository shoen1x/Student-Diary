package jp.co.cyberagent.android.gpuimage;

import java.util.List;

public class GPUImageTwoPassFilter extends GPUImageFilterGroup {
    public GPUImageTwoPassFilter(String firstVertexShader, String firstFragmentShader, String secondVertexShader, String secondFragmentShader) {
        super((List<GPUImageFilter>) null);
        addFilter(new GPUImageFilter(firstVertexShader, firstFragmentShader));
        addFilter(new GPUImageFilter(secondVertexShader, secondFragmentShader));
    }
}
