package maps.wrapper;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class PolygonOptions {

    com.huawei.hms.maps.model.PolygonOptions huawei;
    com.google.android.gms.maps.model.PolygonOptions google;

    public PolygonOptions() {
        this.huawei = new com.huawei.hms.maps.model.PolygonOptions();
        this.google = new com.google.android.gms.maps.model.PolygonOptions();
    }

    public PolygonOptions add(LatLng value) {
        google = google.add(value.google);
        huawei = huawei.add(value.huawei);
        return this;
    }

    public final PolygonOptions add(LatLng... values) {
        com.huawei.hms.maps.model.LatLng[] hLat = new com.huawei.hms.maps.model.LatLng[values.length];
        com.google.android.gms.maps.model.LatLng[] gLat = new com.google.android.gms.maps.model.LatLng[values.length];
        for (int i = 0; i < values.length; i++) {
            hLat[i] = values[i].huawei;
            gLat[i] = values[i].google;
        }
        google = google.add(gLat);
        huawei = huawei.add(hLat);
        return this;
    }

    public final PolygonOptions addAll(Iterable<LatLng> values) {

        final List<com.huawei.hms.maps.model.LatLng> hList = new ArrayList<>();
        final List<com.google.android.gms.maps.model.LatLng> gList = new ArrayList<>();
        Iterator<LatLng> iterator = values.iterator();
        while (iterator.hasNext()) {
            LatLng item = iterator.next();
            System.out.println("----->item: " + item.hashCode());
            hList.add(item.huawei);
            gList.add(item.google);
        }
        Iterable<com.huawei.hms.maps.model.LatLng> hIterator = new Iterable<com.huawei.hms.maps.model.LatLng>() {
            @NonNull
            @Override
            public Iterator<com.huawei.hms.maps.model.LatLng> iterator() {
                return hList.iterator();
            }
        };

        final Iterable<com.google.android.gms.maps.model.LatLng> gIterator = new Iterable<com.google.android.gms.maps.model.LatLng>() {
            @NonNull
            @Override
            public Iterator<com.google.android.gms.maps.model.LatLng> iterator() {
                return gList.iterator();
            }
        };
        huawei = huawei.addAll(hIterator);
        google = google.addAll(gIterator);
        return this;
    }

    public final PolygonOptions zIndex(float value) {
        huawei = huawei.zIndex(value);
        google = google.zIndex(value);
        return this;
    }

    public PolygonOptions visible(boolean value) {
        huawei = huawei.visible(value);
        google = google.visible(value);
        return this;
    }

    public PolygonOptions geodesic(boolean value) {
        huawei = huawei.geodesic(value);
        google = google.geodesic(value);
        return this;
    }

    public PolygonOptions clickable(boolean value) {
        huawei = huawei.clickable(value);
        google = google.clickable(value);
        return this;
    }

    public PolygonOptions addHole(Iterable<LatLng> values) {
        final List<com.huawei.hms.maps.model.LatLng> hList = new ArrayList<>();
        final List<com.google.android.gms.maps.model.LatLng> gList = new ArrayList<>();
        Iterator<LatLng> iterator = values.iterator();
        while (iterator.hasNext()) {
            LatLng item = iterator.next();
            hList.add(item.huawei);
            gList.add(item.google);
        }
        Iterable<com.huawei.hms.maps.model.LatLng> hIterator = new Iterable<com.huawei.hms.maps.model.LatLng>() {
            @NonNull
            @Override
            public Iterator<com.huawei.hms.maps.model.LatLng> iterator() {
                return hList.iterator();
            }
        };

        final Iterable<com.google.android.gms.maps.model.LatLng> gIterator = new Iterable<com.google.android.gms.maps.model.LatLng>() {
            @NonNull
            @Override
            public Iterator<com.google.android.gms.maps.model.LatLng> iterator() {
                return gList.iterator();
            }
        };
        huawei.addHole(hIterator);
        google.addHole(gIterator);
        return this;
    }


    public final PolygonOptions strokeWidth(float value) {
        huawei = huawei.strokeWidth(value);
        google = google.strokeWidth(value);
        return this;
    }

    public final PolygonOptions strokeColor(int value) {
        huawei = huawei.strokeColor(value);
        google = google.strokeColor(value);
        return this;
    }

    public final PolygonOptions strokeJointType(int value) {
        huawei = huawei.strokeJointType(value);
        google = google.strokeJointType(value);
        return this;
    }


    public final PolygonOptions fillColor(int value) {
        huawei = huawei.fillColor(value);
        google = google.fillColor(value);
        return this;
    }
}
