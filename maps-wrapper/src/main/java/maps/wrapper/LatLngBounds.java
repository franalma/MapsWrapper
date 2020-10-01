package maps.wrapper;

public class LatLngBounds {
    com.google.android.gms.maps.model.LatLngBounds google;
    com.huawei.hms.maps.model.LatLngBounds huawei;

    private LatLngBounds() {
    }

    public LatLngBounds(LatLng southwest, LatLng northeast) {
        this.google = new com.google.android.gms.maps.model.LatLngBounds(southwest.google, northeast.google);
        this.huawei = new com.huawei.hms.maps.model.LatLngBounds(southwest.huawei, northeast.huawei);
    }

    public static LatLngBounds.Builder builder() {
        return new LatLngBounds.Builder();
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
            return latLngBounds;
        }
    }
}
