# MapsWrapper

[![](https://jitpack.io/v/franalma/MapsWrapper.svg)](https://jitpack.io/#franalma/MapsWrapper/)

Wrapper that unifies Google Maps (**GM**) and Huawei Maps (**HM**) SDKs in a single API. At runtime, the wrapper routes the calls according to the [map resolution strategy]( #map-resolution-strategy) which by default will use GM first and HM second (if GM is not available). On the new HMS Huawei devices, only HM is available.

The wrapper is mainly intended as an addition to an already existent **GM** implementation, when support for **HM** is also needed. Because the wrapper's API is 1:1 with the **GM** API (except the actual map which has been renamed from`GoogleMap`/`HuaweiMap` to `ExtendedMap`) replacing/renaming the current imports from `com.google.android.gms.maps.*`  to `maps.wrapper.*` would result in a working implementation on both **GM** and **HM**, in a couple of minutes of work. Explicit calls to `GoogleMap` need as well a rename to `ExtendedMap`.



## Usage

Here's an activity layout with a `SupportMapFragment`:

```xml
<?xml version="1.0" encoding="utf-8"?>
<fragment xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/map"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:type="auto">
</fragment>
```

This is the activity class:

```java
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import maps.wrapper.CameraUpdateFactory;
import maps.wrapper.ExtendedMap;
import maps.wrapper.LatLng;
import maps.wrapper.MarkerOptions;
import maps.wrapper.OnMapReadyCallback;
import maps.wrapper.SupportMapFragment;

/**
 * This shows how to create a simple activity with a map and a marker on the map.
 */
public class BasicMapDemoActivity extends AppCompatActivity implements OnMapReadyCallback {
    private SupportMapFragment fragment;
    private LatLng sydney = new LatLng(-33.862, 151.21);
    private float zoomLevel = 13f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_map_demo);
        fragment = (SupportMapFragment)
                this.getSupportFragmentManager().findFragmentById(R.id.id_framelayout_map);
        assert  fragment != null;
        fragment.getMapAsync(this);
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just move the camera to Sydney and add a marker in Sydney.
     */
    @Override
    public void onMapReady(ExtendedMap map) {
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, zoomLevel));
        map.addMarker(new MarkerOptions().position(sydney));
    }
}

```

##### Map resolution strategy

The `app:type="auto"` attribute in the fragment layout defines the map resolution strategy. Currently, 5 strategies are available:

- `auto`: same as `google_then_huawei`.
- `google_then_huawei`: tries to use **GM** first. If not available
falls back to **HM**.
- `huawei_then_google`: tries to use **HM** first. If not available
falls back to **GM**.
- `force_google`: tries to use only **GM**.
- `force_huawei`: tries to use only **HM**.

If no map resolution strategy is explicitly requested, it defaults to the strategy defined in
`MapResolverStrategy.default`. By default this is `auto` but can be
overridden programmatically. In case the strategy cannot be satisfied (i.e. requesting `force_google` on an HMS device) `MapResolverException` will be thrown.



## Extended API

Some classes have enhanced API support:

- `SupportMapFragment` supports a suspend `mapAsync()` method that returns a `ExtendedMap`.
- `MapView` supports a suspend `mapAsync()` method that returns a `ExtendedMap`.



## Add the wrapper as a dependency

In your root `build.gradle` add [Jitpack](https://jitpack.io/) to the list of known repositories. Check that the Huawei and Google own repositories are there as well.

```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
		maven { url 'https://developer.huawei.com/repo/' }
		google()
	}
}
```

Then add the actual library dependency in your app `build.gradle`:

```gradle
dependencies {
    implementation 'com.github.franalma:MapsWrapper:1.2.0'
}
```

You no longer need to explicitly define **GM** or **HM** dependencies in your app's `build.gradle` because the library takes care of that.



## Obtaining an API key

Both maps SDKs require authentication. Follow the instructions on how to setup your app:

- **GM**: https://developers.google.com/maps/documentation/android-sdk/start
- **HM**: https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides-V5/android-sdk-config-agc-0000001061560289-V5

The demo project included in this repository is a fork of the official [Google Maps sample demos](https://github.com/googlemaps/android-samples) with all calls going through the wrapper. 



## Unsupported map types by HM

Currently, HM lacks satellite imagery.  Therefore, requesting any of  `ExtendedMap.MAP_TYPE_HYBRID` or `ExtendedMap.MAP_TYPE_SATELLITE` via `ExtendedMap.setMapType()` will simply fallback to `ExtendedMap.MAP_TYPE_NORMAL` for HM.

Call`ExtendedMap.isMapTypeSupported()` ([go to definition](https://github.com/franalma/MapsWrapper/blob/8271e3a216d826277621f8501945d83bc8d56c53/maps-wrapper/src/main/java/maps/wrapper/ExtendedMap.java#L232)) to check at runtime if the underlying GM or HM map supports the desired map type.