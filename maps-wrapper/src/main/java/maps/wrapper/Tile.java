package maps.wrapper;

public class Tile {
    com.google.android.gms.maps.model.Tile google;
    com.huawei.hms.maps.model.Tile huawei;

    Tile(com.google.android.gms.maps.model.Tile google, com.huawei.hms.maps.model.Tile huawei) {
        this.google = google;
        this.huawei = huawei;
    }

    public Tile(int width, int height, byte[] buffer) {
        this.google = new com.google.android.gms.maps.model.Tile(width, height, buffer);
        this.huawei = new com.huawei.hms.maps.model.Tile(width, height, buffer);
    }
}
