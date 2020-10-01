package maps.wrapper;

import android.view.ViewDebug;

public class CameraPosition {
    com.google.android.gms.maps.model.CameraPosition google;
    com.huawei.hms.maps.model.CameraPosition huawei;
    public float tilt;
    public float zoom;
    public LatLng target ;


    CameraPosition(com.google.android.gms.maps.model.CameraPosition google,
                          com.huawei.hms.maps.model.CameraPosition huawei) {
        this.google = google;
        this.huawei = huawei;
        initTarget();
        initTilt();
        initZoom();

    }

    @ViewDebug.ExportedProperty()
    public void initTarget(){
        if (google != null)target = new LatLng(google.target.latitude, google.target.longitude);
        if (huawei != null)target = new LatLng(huawei.target.latitude, huawei.target.longitude);
    }

    public void initZoom(){
        if (google != null) zoom = google.zoom;
        if (huawei != null) zoom = huawei.zoom;
    }


    public void initTilt(){
        if (google != null) tilt = google.tilt;
        if (huawei != null) tilt= huawei.tilt;
    }


   public static Builder builder(){
        return new Builder();
   }

   public static CameraPosition fromLatLngZoom(LatLng latLng, float zoom){
        return new CameraPosition(com.google.android.gms.maps.model.CameraPosition.fromLatLngZoom(latLng.google,zoom),
                        com.huawei.hms.maps.model.CameraPosition.fromLatLngZoom(latLng.huawei,zoom));
    }

      public static class Builder{
        private com.huawei.hms.maps.model.CameraPosition.Builder huawei;
        private com.google.android.gms.maps.model.CameraPosition.Builder google;

        public  Builder() {
            google = new com.google.android.gms.maps.model.CameraPosition.Builder();
            huawei = new com.huawei.hms.maps.model.CameraPosition.Builder();
        }

        public Builder(CameraPosition cameraPosition){
            if (cameraPosition.google != null) google = new com.google.android.gms.maps.model.CameraPosition.Builder(cameraPosition.google);
            if (cameraPosition.huawei != null) huawei = new com.huawei.hms.maps.model.CameraPosition.Builder(cameraPosition.huawei);
        }

         public Builder bearing(float value) {
            google = google.bearing(value);
            huawei = huawei.bearing(value);
            return this;
         }

         public CameraPosition.Builder target(LatLng value) {
             google = google.target(value.google);
             huawei = huawei.target(value.huawei);
             return this;
         }

         public CameraPosition.Builder tilt(float value) {
             google = google.tilt(value);
             huawei = huawei.tilt(value);
             return this;
         }

         public CameraPosition.Builder zoom(float value) {
             google = google.zoom(value);
             huawei = huawei.zoom(value);
             return this;
         }

         public CameraPosition build(){
             com.google.android.gms.maps.model.CameraPosition pGoogle = null;
             com.huawei.hms.maps.model.CameraPosition pHuawei = null;
            if (google != null) pGoogle = google.build();
            if (huawei != null) pHuawei = huawei.build();
            return new CameraPosition(pGoogle, pHuawei);
         }


    }
}
