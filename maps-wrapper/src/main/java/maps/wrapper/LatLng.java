package maps.wrapper;

public class LatLng {
    com.huawei.hms.maps.model.LatLng huawei;
    com.google.android.gms.maps.model.LatLng google;

    public double latitude;
    public double longitude;

    public LatLng(double latitude, double longitude) {
        this.huawei = new com.huawei.hms.maps.model.LatLng(latitude, longitude);
        this.google = new com.google.android.gms.maps.model.LatLng(latitude, longitude);
        // LatLng's constructor might change lat/lng
        this.latitude = google.latitude;
        this.longitude = google.longitude;
    }
}
