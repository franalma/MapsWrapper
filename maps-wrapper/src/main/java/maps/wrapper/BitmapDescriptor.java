package maps.wrapper;

public class BitmapDescriptor {
    com.huawei.hms.maps.model.BitmapDescriptor huawei;
    com.google.android.gms.maps.model.BitmapDescriptor google;

    public BitmapDescriptor(com.huawei.hms.maps.model.BitmapDescriptor huawei,
                            com.google.android.gms.maps.model.BitmapDescriptor google) {
        this.huawei = huawei;
        this.google = google;
    }
}
