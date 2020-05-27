package com.huawei.fast.huawei.map.hmsgmsmaplayout;

import com.google.android.gms.maps.GoogleMap;
import com.huawei.hms.maps.HuaweiMap;

public interface OnMapReadyCallback {
    void onMapReady(GoogleMap map);
    void onMapReady(HuaweiMap map);
}
