package com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper;

import java.util.ArrayList;
import java.util.List;

public class IndoorBuilding {
    com.google.android.gms.maps.model.IndoorBuilding google;
    com.huawei.hms.maps.model.IndoorBuilding huawei;

    public IndoorBuilding(com.google.android.gms.maps.model.IndoorBuilding google,
                          com.huawei.hms.maps.model.IndoorBuilding huawei) {
        this.google = google;
        this.huawei = huawei;
    }

    public  int getDefaultLevelIndex() {
        if (google != null) return google.getDefaultLevelIndex();
        if (huawei != null) return huawei.getDefaultLevelIndex();
        return -1;
    }

    public  int getActiveLevelIndex() {
        if (google != null) return google.getActiveLevelIndex();
        if (huawei != null) return huawei.getActiveLevelIndex();
        return -1;
    }

    public  List<IndoorLevel> getLevels() {
        List<IndoorLevel> values = null;

        if (google != null){
            List<com.google.android.gms.maps.model.IndoorLevel>vGoogle = google.getLevels();
            values =  new ArrayList<>();
            for(com.google.android.gms.maps.model.IndoorLevel item:vGoogle){
                values.add(new IndoorLevel(item, null));
            }
        }
        if (huawei != null){
            List<com.huawei.hms.maps.model.IndoorLevel> vHuawei = huawei.getLevels();
            values =  new ArrayList<>();
            for(com.huawei.hms.maps.model.IndoorLevel item:vHuawei){
                values.add(new IndoorLevel(null, item));
            }
        }
        return values;
    }

    public boolean isUnderground() {
        if (google != null) return google.isUnderground();
        if (huawei != null) return huawei.isUnderground();
        return false;
    }


}
