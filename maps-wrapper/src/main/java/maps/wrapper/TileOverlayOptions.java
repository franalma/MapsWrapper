package maps.wrapper;


import com.huawei.hms.maps.model.Tile;

public class TileOverlayOptions {
    com.huawei.hms.maps.model.TileOverlayOptions huawei;
    com.google.android.gms.maps.model.TileOverlayOptions google;

    public TileOverlayOptions(){
        this.huawei = new com.huawei.hms.maps.model.TileOverlayOptions();
        this.google = new com.google.android.gms.maps.model.TileOverlayOptions();
    }

    public TileOverlayOptions fadeIn(boolean fadeIn) {
        google.fadeIn(fadeIn);
        huawei.fadeIn(fadeIn);
        return this;
    }

    public TileOverlayOptions  transparency (float value){
        google.transparency(value);
        huawei.transparency(value);
        return this;
    }

    public TileOverlayOptions  visible (boolean value){
        google.visible(value);
        huawei.visible(value);
        return this;
    }

    public TileOverlayOptions  zIndex (float value){
        google.zIndex(value);
        huawei.zIndex(value);
        return this;
    }

    public TileOverlayOptions  tileProvider (final TileProvider tileProvider){
       google.tileProvider(new com.google.android.gms.maps.model.TileProvider() {
           @Override
           public com.google.android.gms.maps.model.Tile getTile(int i, int i1, int i2) {
               return tileProvider.getTile(i,i1,i2).google;
           }
       });

        huawei.tileProvider(new com.huawei.hms.maps.model.TileProvider() {
            @Override
            public Tile getTile(int i, int i1, int i2) {
                return tileProvider.getTile(i,i1,i2).huawei;
            }
        });
        return this;
    }
}
