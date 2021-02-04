package maps.wrapper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Polyline {
    private com.google.android.gms.maps.model.Polyline google;
    private com.huawei.hms.maps.model.Polyline huawei;

    Polyline(com.google.android.gms.maps.model.Polyline google) {
        this.google = google;
    }

    Polyline(com.huawei.hms.maps.model.Polyline huawei) {
        this.huawei = huawei;
    }

    public Polyline setColor(int value) {
        if (google != null) this.google.setColor(value);
        if (huawei != null) this.huawei.setColor(value);
        return this;
    }

    public int getColor() {
        if (google != null) return google.getColor();
        if (huawei != null) return huawei.getColor();
        return -1;
    }

    public void setStartCap(@NonNull Cap value) {
        if (google != null) google.setStartCap(value.gCap);
        if (huawei != null) huawei.setStartCap(value.hCap);
    }

    public final Cap getStartCap() {
        if (google != null) return new Cap(google.getStartCap(), null);
        if (huawei != null) return new Cap(null, huawei.getStartCap());
        return null;
    }

    public final void setEndCap(@NonNull Cap value) {
        if (google != null) google.setEndCap(value.gCap);
        if (huawei != null) huawei.setEndCap(value.hCap);
    }

    public final Cap getEndCap() {
        if (google != null) return new Cap(google.getEndCap(), null);
        if (huawei != null) return new Cap(null, huawei.getEndCap());
        return null;
    }

    public void setJointType(int value) {
        if (google != null) google.setJointType(value);
        if (huawei != null) huawei.setJointType(value);
    }

    public int getJointType() {
        if (google != null) return google.getJointType();
        if (huawei != null) return huawei.getJointType();
        return -1;
    }

    public void setPattern(@Nullable List<PatternItem> value) {
        if (value != null) {
            List<com.huawei.hms.maps.model.PatternItem> hList = new ArrayList<>();
            List<com.google.android.gms.maps.model.PatternItem> gList = new ArrayList<>();
            for (PatternItem item : value) {
                hList.add(item.hPattern);
                gList.add(item.gPattern);
            }
            if (google != null) google.setPattern(gList);
            if (huawei != null) huawei.setPattern(hList);
        }

    }

    public List<PatternItem> getPatternItem() {
        List<PatternItem> list = new ArrayList<>();
        if (google != null) {
            List<com.google.android.gms.maps.model.PatternItem> gList = google.getPattern();
            for (com.google.android.gms.maps.model.PatternItem item : gList) {
                list.add(new PatternItem(item, null));
            }
        }
        if (huawei != null) {
            List<com.huawei.hms.maps.model.PatternItem> hList = huawei.getPattern();
            for (com.huawei.hms.maps.model.PatternItem item : hList) {
                list.add(new PatternItem(null, item));
            }
        }
        return list;
    }

    public void setWidth(float value) {
        if (google != null) google.setWidth(value);
        if (huawei != null) huawei.setWidth(value);
    }

    public float getWidth() {
        if (google != null) return google.getWidth();
        if (huawei != null) return huawei.getWidth();
        return -1;
    }

    public void setVisible(boolean value) {
        if (google != null) google.setVisible(value);
        if (huawei != null) huawei.setVisible(value);
    }

    public boolean isVisible() {
        if (google != null) return google.isVisible();
        if (huawei != null) return huawei.isVisible();
        return false;
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

    public void setClickable(boolean value) {
        if (google != null) google.setClickable(value);
        if (huawei != null) huawei.setClickable(value);
    }


}
