package maps.wrapper;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class Polygon {
    com.google.android.gms.maps.model.Polygon google;
    com.huawei.hms.maps.model.Polygon huawei;

    Polygon(com.google.android.gms.maps.model.Polygon google,
                   com.huawei.hms.maps.model.Polygon huawei) {
        this.google = google;
        this.huawei = huawei;
    }

    public void setStrokeWidth(float value) {
        if (google != null) google.setStrokeWidth(value);
        if (huawei != null) huawei.setStrokeWidth(value);
    }

    public float getStrokeWidth() {
        float result = -1.0F;
        if (google != null) return google.getStrokeWidth();
        if (huawei != null) return huawei.getStrokeWidth();
        return result;
    }

    public void setStrokeColor(int value) {
        if (google != null) google.setStrokeColor(value);
        if (huawei != null) huawei.setStrokeColor(value);
    }

    public int getStrokeColor() {
        int result = 0;
        if (google != null) return google.getStrokeColor();
        if (huawei != null) return huawei.getStrokeColor();
        return result;
    }

    public void setStrokeJointType(int value) {
        if (google != null) google.setStrokeJointType(value);
        if (huawei != null) huawei.setStrokeJointType(value);
    }

    public void setStrokePattern(List<PatternItem> values) {
        if (values != null){
            if (google != null) {
                List<com.google.android.gms.maps.model.PatternItem> gValues = new ArrayList<>();
                for (PatternItem item: values){
                    gValues.add(item.gPattern);
                }
                google.setStrokePattern(gValues);
            }
            if (huawei != null){
                List<com.huawei.hms.maps.model.PatternItem> hValues = new ArrayList<>();
                for (PatternItem item: values){
                    hValues.add(item.hPattern);
                }
                huawei.setStrokePattern(hValues);
            }
        }

    }



    public int getStrokeJointType() {
        int result = 0;
        if (google != null) return google.getStrokeJointType();
        if (huawei != null) return huawei.getStrokeJointType();
        return result;
    }

    public void setFillColor(int value) {
        if (google != null) google.setFillColor(value);
        if (huawei != null) huawei.setFillColor(value);
    }

    public int getFillColor() {
        int result = 0;
        if (google != null) return google.getFillColor();
        if (huawei != null) return huawei.getFillColor();
        return result;
    }

    public void setTag(@Nullable Object value) {
        if (google != null) google.setTag(value);
        if (huawei != null) huawei.setTag(value);
    }

    @Nullable
    public Object getTag() {
        if (google != null) return google.getTag();
        if (huawei != null) return huawei.getTag();
        return null;
    }

    public void setClickable(boolean value){
        if (google != null) google.setClickable(value);
        if (huawei != null) huawei.setClickable(value);
    }

}
