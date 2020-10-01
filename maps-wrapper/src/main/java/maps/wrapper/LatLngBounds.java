package maps.wrapper;

public class LatLngBounds {
    com.google.android.gms.maps.model.LatLngBounds google;
    com.huawei.hms.maps.model.LatLngBounds huawei;

    public LatLng southwest;
    public LatLng northeast;

    private LatLngBounds() {
    }

    public LatLngBounds(LatLng southwest, LatLng northeast) {
        this.google = new com.google.android.gms.maps.model.LatLngBounds(southwest.google, northeast.google);
        this.huawei = new com.huawei.hms.maps.model.LatLngBounds(southwest.huawei, northeast.huawei);
        this.southwest = southwest;
        this.northeast = northeast;
    }

    public static LatLngBounds.Builder builder() {
        return new LatLngBounds.Builder();
    }

    public final boolean contains(LatLng point) {
        if (google != null) {
            return google.contains(new com.google.android.gms.maps.model.LatLng(point.latitude, point.longitude));
        } else if (huawei != null) {
            return huawei.contains(new com.huawei.hms.maps.model.LatLng(point.latitude, point.longitude));
        } else {
            throw new UnsupportedOperationException("Missing underlying GMS/HMS LatLngBounds.");
        }
    }

    public final LatLng getCenter() {
        if (google != null) {
            final com.google.android.gms.maps.model.LatLng center = google.getCenter();
            return new LatLng(center.latitude, center.longitude);
        } else if (huawei != null) {
            final com.huawei.hms.maps.model.LatLng center = huawei.getCenter();
            return new LatLng(center.latitude, center.longitude);
        } else {
            throw new UnsupportedOperationException("Missing underlying GMS/HMS LatLngBounds.");
        }
    }

    public static class Builder {
        private com.google.android.gms.maps.model.LatLngBounds.Builder google;
        private com.huawei.hms.maps.model.LatLngBounds.Builder huawei;

        public Builder() {
            google = new com.google.android.gms.maps.model.LatLngBounds.Builder();
            huawei = new com.huawei.hms.maps.model.LatLngBounds.Builder();
        }

        public Builder include(LatLng position) {
            google = google.include(position.google);
            huawei = huawei.include(position.huawei);
            return this;
        }

        public LatLngBounds build() {
            final LatLngBounds latLngBounds = new LatLngBounds();
            latLngBounds.google = google.build();
            latLngBounds.huawei = huawei.build();
            latLngBounds.southwest = new LatLng(latLngBounds.google.southwest.latitude, latLngBounds.google.southwest.longitude);
            latLngBounds.northeast = new LatLng(latLngBounds.google.northeast.latitude, latLngBounds.google.northeast.longitude);
            return latLngBounds;
        }
    }
}