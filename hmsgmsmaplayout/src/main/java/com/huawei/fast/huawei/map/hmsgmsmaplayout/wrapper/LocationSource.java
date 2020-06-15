package com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper;

import android.location.Location;

public interface LocationSource {
    void activate(OnLocationChangedListener listener);
    void deactivate();

    interface OnLocationChangedListener {
        void onLocationChanged(Location location);
    }

}
