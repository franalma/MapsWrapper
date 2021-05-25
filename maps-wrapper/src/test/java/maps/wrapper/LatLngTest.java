package maps.wrapper;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LatLngTest {

    @Test
    public void createLatLngUnchanged() {
        double lat = 45.630853;
        double lng = 5.60854;
        LatLng latLng = new LatLng(lat, lng);

        assertEquals(lat, latLng.latitude, 0);
        assertEquals(lng, latLng.longitude, 0);
        assertEquals(lat, latLng.google.latitude, 0);
        assertEquals(lng, latLng.google.longitude, 0);
        assertEquals(lat, latLng.huawei.latitude, 0);
        assertEquals(lng, latLng.huawei.longitude, 0);
    }

    @Test
    public void createLatLngChanged() {
        double lng = 5.60854;
        LatLng latLng = new LatLng(100, lng);

        double expectedLat = 90;
        assertEquals(expectedLat, latLng.latitude, 0);
        assertEquals(lng, latLng.longitude, 0);
        assertEquals(expectedLat, latLng.google.latitude, 0);
        assertEquals(lng, latLng.google.longitude, 0);
        assertEquals(expectedLat, latLng.huawei.latitude, 0);
        assertEquals(lng, latLng.huawei.longitude, 0);
    }

    @Test
    public void equalCoordinates() {
        double lat = 45.630853;
        double lng = 5.60854;
        LatLng latLng1 = new LatLng(lat, lng);
        LatLng latLng2 = new LatLng(lat, lng);

        assertEquals(latLng1, latLng2);
    }
}
