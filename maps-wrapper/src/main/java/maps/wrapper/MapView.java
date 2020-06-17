package maps.wrapper;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.google.android.gms.maps.GoogleMap;
import com.huawei.hms.maps.HuaweiMap;

import maps.wrapper.R;

public class MapView extends FrameLayout {

    private FrameLayout mapView;

    public MapView(Context context) {
        super(context);
    }

    public void onCreate(Bundle bundle){
        if (isGoogleMap()) getGoogleMap().onCreate(bundle);
        else if (isHuaweiMap()) getHuaweMap().onCreate(bundle);
    }

    private com.google.android.gms.maps.MapView  getGoogleMap(){
        return (com.google.android.gms.maps.MapView) mapView;
    }

    private com.huawei.hms.maps.MapView getHuaweMap(){
        return (com.huawei.hms.maps.MapView)mapView;
    }

    private void getGoogleMapAsync(final OnMapReadyCallback callback){
        getGoogleMap().getMapAsync(new com.google.android.gms.maps.OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                callback.onMapReady(new ExtendedMap(googleMap));
            }
        });
    }

    private void getHuaweiMapAsync(final OnMapReadyCallback callback){
        getHuaweMap().getMapAsync(new com.huawei.hms.maps.OnMapReadyCallback() {
            @Override
            public void onMapReady(HuaweiMap huaweiMap) {
                callback.onMapReady(new ExtendedMap(huaweiMap));
            }
        });
    }

    public void getMapAsync(final OnMapReadyCallback callback) {
        if (isGoogleMap()) {
            getGoogleMapAsync(callback);
        } else if (isHuaweiMap()){
            getHuaweiMapAsync(callback);
        }
    }

    private void resolveMapView(Context context, AttributeSet attr, int styleAttr, int styleRes){
       TypedArray attrs =  context.getTheme().obtainStyledAttributes(attr,
                R.styleable.mapResolution,styleAttr, styleRes);
       String type = attrs.getString(R.styleable.mapResolution_type);
       MapResolverStrategy mapResolverStrategy = MapResolverStrategy.fromValue(type);
       try{
           mapView = MapResolverStrategy.useRequiredMapView(context, attr,styleAttr,mapResolverStrategy);
           addView(mapView);
       }catch(Exception e){
           e.printStackTrace();
       }
       attrs.recycle();
    }

    public MapView(Context context, AttributeSet attr) {
        super(context, attr);
        resolveMapView(context, attr, 0, 0);

    }

    public boolean isGoogleMap(){
        return mapView instanceof com.google.android.gms.maps.MapView;
    }

    public boolean isHuaweiMap(){
        return mapView instanceof com.huawei.hms.maps.MapView;
    }
}
