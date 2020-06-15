package com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper;

import android.content.Context;

public class MapsInitializer {
    public static void initialize(Context context){
        try{
            com.google.android.gms.maps.MapsInitializer.initialize(context);
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            com.huawei.hms.maps.MapsInitializer.initialize(context);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
