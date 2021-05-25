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

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (!(other instanceof LatLng)) {
            return false;
        } else {
            return this.google.equals(((LatLng) other).google);
        }
    }

    @Override
    public int hashCode() {
        return google.hashCode();
    }

    @Override
    public String toString() {
        return google.toString();
    }
}
