package maps.wrapper;

public class Gap extends PatternItem {
    public Gap(float value) {
        super(new com.google.android.gms.maps.model.Gap(value),
                new com.huawei.hms.maps.model.Gap(value));
    }
}
