package com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper;

public class PolylineOptions {
    com.huawei.hms.maps.model.PolylineOptions hOptions;
    com.google.android.gms.maps.model.PolylineOptions gOptions;

    public PolylineOptions(){
        gOptions = new com.google.android.gms.maps.model.PolylineOptions();
        hOptions = new com.huawei.hms.maps.model.PolylineOptions();

    }

    public  PolylineOptions add(LatLng... values) {
        com.huawei.hms.maps.model.LatLng [] listH = new com.huawei.hms.maps.model.LatLng[values.length];
        com.google.android.gms.maps.model.LatLng[] listG = new com.google.android.gms.maps.model.LatLng[values.length];
        for (int i = 0;i<values.length;i++) {
            listH[i] = values[i].huawei;
            listG[i] =values[i].google;
        }
        hOptions = hOptions.add(listH);
        gOptions = gOptions.add(listG);
        return this;
    }

    public PolylineOptions add(LatLng value) {
       hOptions =  hOptions.add(value.huawei);
       gOptions = gOptions.add(value.google);
        return this;
    }

    //TODO
//    public PolylineOptions addAll(Iterable<LatLng> value) {
//
//    }

    public PolylineOptions clickable(boolean value) {
        hOptions = hOptions.clickable(value);
        gOptions = gOptions.clickable(value);
        return this;
    }

    public PolylineOptions color(int value) {
        hOptions = hOptions.color(value);
        gOptions = gOptions.color(value);
        return this;
    }

//TODO
//    public PolylineOptions endCap(Cap value) {
//        if (isHms) hOptions.endCap(value);
//        if (!isHms) gOptions.endCap(value);
//        return this;
//    }

    public PolylineOptions geodesic(boolean value) {
        hOptions = hOptions.geodesic(value);
        gOptions = gOptions.geodesic(value);
        return this;
    }


    public PolylineOptions jointType(int value) {
       hOptions =  hOptions.jointType(value);
       gOptions = gOptions.jointType(value);
        return this;
    }



    public PolylineOptions visible(boolean value) {
       hOptions =  hOptions.visible(value);
       gOptions = gOptions.visible(value);
        return this;
    }

    public PolylineOptions width(float value) {
        hOptions = hOptions.width(value);
        gOptions = gOptions.width(value);
        return this;
    }

    public PolylineOptions zIndex(float value) {
        hOptions = hOptions.zIndex(value);
        gOptions = gOptions.zIndex(value);
        return this;
    }






}
