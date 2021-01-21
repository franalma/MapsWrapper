package maps.wrapper;

import android.support.annotation.Nullable;

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

    public final void setStrokeWidth(float value) {
        if (google != null) google.setStrokeWidth(value);
        if (huawei != null) huawei.setStrokeWidth(value);
    }

    public final float getStrokeWidth() {
        float result = -1.0F;
        if (google != null) return google.getStrokeWidth();
        if (huawei != null) return huawei.getStrokeWidth();
        return result;
    }

    public final void setStrokeColor(int value) {
        if (google != null) google.setStrokeColor(value);
        if (huawei != null) huawei.setStrokeColor(value);
    }

    public final int getStrokeColor() {
        int result = 0;
        if (google != null) return google.getStrokeColor();
        if (huawei != null) return huawei.getStrokeColor();
        return result;
    }

    public final void setStrokeJointType(int value) {
        if (google != null) google.setStrokeJointType(value);
        if (huawei != null) huawei.setStrokeJointType(value);
    }

    public final void setStrokePattern(List<PatternItem> values) {
        if (values != null) {
            if (google != null) {
                List<com.google.android.gms.maps.model.PatternItem> gValues = new ArrayList<>();
                for (PatternItem item : values) {
                    gValues.add(item.gPattern);
                }
                google.setStrokePattern(gValues);
            }
            if (huawei != null) {
                List<com.huawei.hms.maps.model.PatternItem> hValues = new ArrayList<>();
                for (PatternItem item : values) {
                    hValues.add(item.hPattern);
                }
                huawei.setStrokePattern(hValues);
            }
        }

    }

    public final int getStrokeJointType() {
        int result = 0;
        if (google != null) return google.getStrokeJointType();
        if (huawei != null) return huawei.getStrokeJointType();
        return result;
    }

    public final void setFillColor(int value) {
        if (google != null) google.setFillColor(value);
        if (huawei != null) huawei.setFillColor(value);
    }

    public final int getFillColor() {
        int result = 0;
        if (google != null) return google.getFillColor();
        if (huawei != null) return huawei.getFillColor();
        return result;
    }

    public final void setTag(@Nullable Object value) {
        if (google != null) google.setTag(value);
        if (huawei != null) huawei.setTag(value);
    }

    @Nullable
    public final Object getTag() {
        if (google != null) return google.getTag();
        if (huawei != null) return huawei.getTag();
        return null;
    }

    public final void setClickable(boolean value) {
        if (google != null) google.setClickable(value);
        if (huawei != null) huawei.setClickable(value);
    }

    public final void setZIndex(float value) {
        if (google != null) google.setZIndex(value);
        if (huawei != null) huawei.setZIndex(value);
    }

    public final float getZIndex() {
        if (google != null) return google.getZIndex();
        if (huawei != null) return huawei.getZIndex();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS Polygon.");
    }
}
