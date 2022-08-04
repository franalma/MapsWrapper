package maps.wrapper;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;

import java.util.Arrays;

public enum MapResolverStrategy {
    FORCE_GOOGLE(new String[]{"google"}),
    FORCE_HUAWEI(new String[]{"huawei"}),
    GOOGLE_THEN_HUAWEI(new String[]{"auto", "google_then_huawei"}),
    HUAWEI_THEN_GOOGLE(new String[]{"huawei_then_google"}),
    ;
    private final String[] values;

    MapResolverStrategy(String[] values) {
        this.values = values;
    }

    public static MapResolverStrategy fromValue(String value) {
        for (MapResolverStrategy item : values()) {
            if (Arrays.asList(item.values).contains(value)) {
                return item;
            }
        }
        return GOOGLE_THEN_HUAWEI;
    }

    static Fragment useRequiredMapFragment(MapResolverStrategy strategy, Context context)
            throws MapResolverException {
        switch (strategy) {
            case FORCE_GOOGLE:
                return getGoogleFragment();
            case FORCE_HUAWEI:
                return getHuaweiFragment(context);
            case GOOGLE_THEN_HUAWEI: {
                if (ApiAvailability.isGoogleAvailable(context)) return getGoogleFragment();
                if (ApiAvailability.isHuaweiAvailable(context)) return getHuaweiFragment(context);
            }
            case HUAWEI_THEN_GOOGLE: {
                if (ApiAvailability.isHuaweiAvailable(context)) return getHuaweiFragment(context);
                if (ApiAvailability.isGoogleAvailable(context)) return getGoogleFragment();
            }
        }
        throw new MapResolverException();
    }


    static FrameLayout useRequiredMapView(Context context, AttributeSet attr, int defStyleAttr, MapResolverStrategy strategy)
            throws MapResolverException {
        switch (strategy) {
            case FORCE_GOOGLE:
                return getGoogleMapView(context, attr, defStyleAttr);
            case FORCE_HUAWEI:
                return getHuaweiMapView(context, attr, defStyleAttr);
            case GOOGLE_THEN_HUAWEI: {
                if (ApiAvailability.isGoogleAvailable(context))
                    return getGoogleMapView(context, attr, defStyleAttr);
                if (ApiAvailability.isHuaweiAvailable(context))
                    return getHuaweiMapView(context, attr, defStyleAttr);
            }
            case HUAWEI_THEN_GOOGLE: {
                if (ApiAvailability.isHuaweiAvailable(context))
                    return getHuaweiMapView(context, attr, defStyleAttr);
                if (ApiAvailability.isGoogleAvailable(context))
                    return getGoogleMapView(context, attr, defStyleAttr);
            }
        }
        throw new MapResolverException();
    }

    private static com.google.android.gms.maps.MapView getGoogleMapView(Context context, AttributeSet attr, int defStyle) {
        return new com.google.android.gms.maps.MapView(context, attr, defStyle);
    }

    private static com.huawei.hms.maps.MapView getHuaweiMapView(Context context, AttributeSet attr, int defStyle) {
        com.huawei.hms.maps.MapsInitializer.initialize(context);
        return new com.huawei.hms.maps.MapView(context, attr, defStyle);
    }

    private static Fragment getGoogleFragment() {
        return com.google.android.gms.maps.SupportMapFragment.newInstance();
    }

    private static Fragment getHuaweiFragment(Context context) {
        com.huawei.hms.maps.MapsInitializer.initialize(context);
        return com.huawei.hms.maps.SupportMapFragment.newInstance();
    }

    static boolean isGoogleAvailable(Context context) {
        return ApiAvailability.isGoogleAvailable(context);
    }

    static boolean isHuaweiAvailable(Context context) {
        return ApiAvailability.isHuaweiAvailable(context);
    }


}
