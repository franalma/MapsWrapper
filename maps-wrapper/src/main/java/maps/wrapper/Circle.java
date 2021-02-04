package maps.wrapper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class Circle {
    com.huawei.hms.maps.model.Circle hmsCircle;
    com.google.android.gms.maps.model.Circle gmsCircle;

    Circle(com.huawei.hms.maps.model.Circle hmsCircle) {
        this.hmsCircle = hmsCircle;
    }

    Circle(com.google.android.gms.maps.model.Circle gmsCircle) {
        this.gmsCircle = gmsCircle;
    }


    public void remove() {
        if (hmsCircle != null) hmsCircle.remove();
        if (gmsCircle != null) gmsCircle.remove();
    }

    public String getId() {
        if (hmsCircle != null) return hmsCircle.getId();
        if (gmsCircle != null) return gmsCircle.getId();
        return null;
    }

    public void setCenter(LatLng latLng) {
        if (hmsCircle != null) hmsCircle.setCenter(latLng.huawei);
        if (gmsCircle != null) gmsCircle.setCenter(latLng.google);
    }


    public void setRadius(double value) {
        if (hmsCircle != null) hmsCircle.setRadius(value);
        if (gmsCircle != null) gmsCircle.setRadius(value);
    }

    public double getRadius() {
        if (hmsCircle != null) return hmsCircle.getRadius();
        if (gmsCircle != null) return gmsCircle.getRadius();
        return -1;
    }

    public void setStrokeWidth(float value) {
        if (hmsCircle != null) hmsCircle.setStrokeWidth(value);
        if (gmsCircle != null) gmsCircle.setStrokeWidth(value);
    }

    public float getStrokeWidth() {
        if (hmsCircle != null) return hmsCircle.getStrokeWidth();
        if (gmsCircle != null) return gmsCircle.getStrokeWidth();
        return -1;
    }

    public void setStrokeColor(int value) {
        if (hmsCircle != null) hmsCircle.setStrokeColor(value);
        if (gmsCircle != null) gmsCircle.setStrokeColor(value);
    }

    public int getStrokeColor() {
        if (hmsCircle != null) return hmsCircle.getStrokeColor();
        if (gmsCircle != null) return gmsCircle.getStrokeColor();
        return -1;
    }

    public void setStrokePattern(@Nullable List<PatternItem> values) {
        if (values != null) {
            List<com.google.android.gms.maps.model.PatternItem> vGoogle = new ArrayList<>();
            List<com.huawei.hms.maps.model.PatternItem> vHuawei = new ArrayList<>();

            for (PatternItem item : values) {
                vGoogle.add(item.gPattern);
                vHuawei.add(item.hPattern);
            }
            if (gmsCircle != null) gmsCircle.setStrokePattern(vGoogle);
            if (hmsCircle != null) hmsCircle.setStrokePattern(vHuawei);
        }

    }

    @Nullable
    public List<PatternItem> getStrokePattern() {
        List<PatternItem> values = new ArrayList<>();
        List<com.google.android.gms.maps.model.PatternItem> vGoogle;
        List<com.huawei.hms.maps.model.PatternItem> vHuawei;
        if (gmsCircle != null) {
            vGoogle = gmsCircle.getStrokePattern();
            for (com.google.android.gms.maps.model.PatternItem item : vGoogle) {
                values.add(new PatternItem(item, null));
            }
        }
        if (hmsCircle != null) {
            vHuawei = hmsCircle.getStrokePattern();
            for (com.huawei.hms.maps.model.PatternItem item : vHuawei) {
                values.add(new PatternItem(null, item));
            }
        }

        return values;
    }

    public void setFillColor(int value) {
        if (hmsCircle != null) hmsCircle.setFillColor(value);
        if (gmsCircle != null) gmsCircle.setFillColor(value);
    }

    public int getFillColor() {
        if (hmsCircle != null) return hmsCircle.getFillColor();
        if (gmsCircle != null) return gmsCircle.getFillColor();
        return -1;
    }

    public void setZIndex(float value) {
        if (hmsCircle != null) hmsCircle.setZIndex(value);
        if (gmsCircle != null) gmsCircle.setZIndex(value);
    }

    public float getZIndex() {
        if (hmsCircle != null) return hmsCircle.getZIndex();
        if (gmsCircle != null) return gmsCircle.getZIndex();
        return -1;
    }

    public void setVisible(boolean value) {
        if (hmsCircle != null) hmsCircle.setVisible(value);
        if (gmsCircle != null) gmsCircle.setVisible(value);
    }

    public boolean isVisible() {
        if (hmsCircle != null) return hmsCircle.isVisible();
        if (gmsCircle != null) return gmsCircle.isVisible();
        return false;
    }

    public void setClickable(boolean value) {
        if (hmsCircle != null) hmsCircle.setClickable(value);
        if (gmsCircle != null) gmsCircle.setClickable(value);

    }

    public boolean isClickable() {
        if (hmsCircle != null) return hmsCircle.isClickable();
        if (gmsCircle != null) return gmsCircle.isClickable();
        return false;
    }

    public <T> void setTag(@Nullable T value) {
        if (hmsCircle != null) hmsCircle.setTag(value);
        if (gmsCircle != null) gmsCircle.setTag(value);
    }

    @Nullable
    public Object getTag() {
        if (hmsCircle != null) return hmsCircle.getTag();
        if (gmsCircle != null) return gmsCircle.getTag();
        return null;
    }


}
