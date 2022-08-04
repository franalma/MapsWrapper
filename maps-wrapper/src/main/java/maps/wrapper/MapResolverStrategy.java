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
        boolean hasGMS = ApiAvailability.isGoogleAvailable(context);
        boolean hasHMS = ApiAvailability.isHuaweiAvailable(context);

        switch (strategy) {
            case FORCE_GOOGLE:
                if (hasGMS) return getGoogleFragment();
                break;
            case FORCE_HUAWEI:
                if (hasHMS) return getHuaweiFragment(context);
                break;
            case GOOGLE_THEN_HUAWEI: {
                if (hasGMS) return getGoogleFragment();
                if (hasHMS) return getHuaweiFragment(context);
                break;
            }
            case HUAWEI_THEN_GOOGLE: {
                if (hasHMS) return getHuaweiFragment(context);
                if (hasGMS) return getGoogleFragment();
                break;
            }
        }
        throw new MapResolverException();
    }


    static FrameLayout useRequiredMapView(Context context, AttributeSet attr, int defStyleAttr, MapResolverStrategy strategy)
            throws MapResolverException {
        boolean hasGMS = ApiAvailability.isGoogleAvailable(context);
        boolean hasHMS = ApiAvailability.isHuaweiAvailable(context);

        switch (strategy) {
            case FORCE_GOOGLE:
                if (hasGMS) return getGoogleMapView(context, attr, defStyleAttr);
                break;
            case FORCE_HUAWEI:
                if (hasHMS) return getHuaweiMapView(context, attr, defStyleAttr);
                break;
            case GOOGLE_THEN_HUAWEI: {
                if (hasGMS) return getGoogleMapView(context, attr, defStyleAttr);
                if (hasHMS) return getHuaweiMapView(context, attr, defStyleAttr);
                break;
            }
            case HUAWEI_THEN_GOOGLE: {
                if (hasHMS) return getHuaweiMapView(context, attr, defStyleAttr);
                if (hasGMS) return getGoogleMapView(context, attr, defStyleAttr);
                break;
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
