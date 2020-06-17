package maps.wrapper;

public class CustomCap extends Cap{

    public CustomCap(BitmapDescriptor bitmapDescriptor, float length){
        super(bitmapDescriptor.google != null? new com.google.android.gms.maps.model.CustomCap(bitmapDescriptor.google):null,
                bitmapDescriptor.huawei != null? new com.huawei.hms.maps.model.CustomCap(bitmapDescriptor.huawei, length):null );


    }
}
