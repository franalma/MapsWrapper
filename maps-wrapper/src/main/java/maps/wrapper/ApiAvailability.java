package maps.wrapper;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import com.huawei.hms.api.HuaweiApiAvailability;

public class ApiAvailability {
    public static boolean isHuaweiAvailable(Context context){
        return HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(context)
                == com.huawei.hms.api.ConnectionResult.SUCCESS;
    }

    public static boolean isGoogleAvailable(Context context){
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context)
                == com.google.android.gms.common.ConnectionResult.SUCCESS;
    }
}
