# MapsWrapper

[![](https://jitpack.io/v/franalma/MapsWrapper.svg)](https://jitpack.io/#franalma/MapsWrapper/)

Wrapper that unifies Google and Huawei maps in a single API.



## Usage

The API is identical to Google and Huawei Maps API except the map that has been renamed from
`GoogleMap`/`HuaweiMap` to `ExtendedMap`. The rest of the classes and methods have exactly the same names,
so generally by replacing the Google or Huawei imports with this library imports it should do
the trick.

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

Note the `app:type="auto"` attribute in the fragment layout.
This defines the map resolution strategy. Currently 5 strategies are available:

- `auto`: same as `google_then_huawei`.
- `google_then_huawei`: tries to use Google Maps first. If not available
falls back to Huawei. If not available either throws an error.
- `huawei_then_google`: tries to use Huawei Maps first. If not available
falls back to Google. If not available either throws an error.
- `force_google`: tries to use Google Maps. If not available throws error.
- `force_huawei`: tries to use Huawei Maps. If not available throws error.

If no map resolution strategy is defined it defaults to the strategy defined in
`MapResolverStrategy.default`. By default this is `auto` but can be
overridden programmatically.

You can check the *testapplication* module for an example app that contains more exhaustive
examples for each part of the maps API.



## Extended API

Some classes have enhanced API support:

- `SupportMapFragment` supports a suspend `mapAsync()` method that returns a `ExtendedMap`.
- `MapView` supports a suspend `mapAsync()` method that returns a `ExtendedMap`.



## Add as dependency

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
    implementation 'com.github.franalma:MapsWrapper:1.1.5'
}
```

Note that you no longer need to define Google Maps or Huawei Maps dependencies explicitly in your app's `build.gradle`, this library already has dependencies on both of them.



## Obtaining an API key

Both Google Maps and Huawei Maps require an API key. Follow the instructions on how to setup your app:

- Google Maps: https://developers.google.com/maps/documentation/android-sdk/start
- Huawei Maps: https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides-V5/android-sdk-config-agc-0000001061560289-V5