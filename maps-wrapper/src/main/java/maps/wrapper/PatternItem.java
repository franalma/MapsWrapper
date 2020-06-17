package maps.wrapper;

public class PatternItem {
    com.google.android.gms.maps.model.PatternItem gPattern;
    com.huawei.hms.maps.model.PatternItem hPattern;

    public PatternItem(com.google.android.gms.maps.model.PatternItem gPattern, com.huawei.hms.maps.model.PatternItem hPattern) {
        this.gPattern = gPattern;
        this.hPattern = hPattern;
    }
}
