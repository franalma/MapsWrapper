package maps.wrapper;

import java.net.URL;

public abstract class UrlTileProvider implements TileProvider {
    com.huawei.hms.maps.model.UrlTileProvider huawei;
    com.google.android.gms.maps.model.UrlTileProvider google;

    public UrlTileProvider(int width, int height) {

        google = new com.google.android.gms.maps.model.UrlTileProvider(width, height) {
            @Override
            public URL getTileUrl(int x, int y, int zoom) {
                return UrlTileProvider.this.getTileUrl(x, y, zoom);
            }
        };
        huawei = new com.huawei.hms.maps.model.UrlTileProvider(width, height) {
            @Override
            public URL getTileUrl(int x, int y, int zoom) {
                return UrlTileProvider.this.getTileUrl(x, y, zoom);
            }
        };
    }

    public Tile getTile(int x, int y, int zoom) {
        return new Tile(this.google.getTile(x, y, zoom), this.huawei.getTile(x, y, zoom));
    }

    public abstract URL getTileUrl(int x, int y, int zoom);
}
