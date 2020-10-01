package maps.wrapper;

import java.util.Objects;

public class VisibleRegion {

    public final LatLng nearLeft;

    public final LatLng nearRight;

    public final LatLng farLeft;

    public final LatLng farRight;

    public final LatLngBounds latLngBounds;

    public VisibleRegion(LatLng nearLeft, LatLng nearRight, LatLng farLeft, LatLng farRight, LatLngBounds latLngBounds) {
        this.nearLeft = nearLeft;
        this.nearRight = nearRight;
        this.farLeft = farLeft;
        this.farRight = farRight;
        this.latLngBounds = latLngBounds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisibleRegion that = (VisibleRegion) o;
        return Objects.equals(nearLeft, that.nearLeft) &&
                Objects.equals(nearRight, that.nearRight) &&
                Objects.equals(farLeft, that.farLeft) &&
                Objects.equals(farRight, that.farRight) &&
                Objects.equals(latLngBounds, that.latLngBounds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nearLeft, nearRight, farLeft, farRight, latLngBounds);
    }

    public final String toString() {
        return com.google.android.gms.common.internal.Objects.toStringHelper(this).add("nearLeft", this.nearLeft).add("nearRight", this.nearRight).add("farLeft", this.farLeft).add("farRight", this.farRight).add("latLngBounds", this.latLngBounds).toString();
    }
}
