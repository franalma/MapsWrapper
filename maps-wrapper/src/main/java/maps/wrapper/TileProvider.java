package maps.wrapper;

public interface TileProvider {
    Tile NO_TILE = new Tile(com.google.android.gms.maps.model.TileProvider.NO_TILE,
            com.huawei.hms.maps.model.TileProvider.NO_TILE);

    Tile getTile(int x, int y, int zoom);
}
