package maps.wrapper;

public interface TileProvider {
    Tile NO_TILE = new Tile(null  , null);
    Tile getTile(int x, int y, int zoom);
}
