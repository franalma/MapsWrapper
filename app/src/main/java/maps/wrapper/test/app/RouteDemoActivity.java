package maps.wrapper.test.app;

import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.annotations.SerializedName;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import maps.wrapper.CameraUpdate;
import maps.wrapper.CameraUpdateFactory;
import maps.wrapper.ExtendedMap;
import maps.wrapper.LatLng;
import maps.wrapper.MarkerOptions;
import maps.wrapper.OnMapReadyCallback;
import maps.wrapper.PolylineOptions;
import maps.wrapper.SupportMapFragment;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


public class RouteDemoActivity extends AppCompatActivity implements OnMapReadyCallback {


    class Directions{
        @SerializedName("geocoded_waypoints")
        List<GeocodedWaypoint> geocodedWaypoints = new ArrayList<>();
        @SerializedName("routes")
        List<Route> routes = new ArrayList<>();
        @SerializedName("status")
        String status = "";
    }

    class GeocodedWaypoint{
        @SerializedName("geocoder_status")
        String geocoderStatus = "";
        @SerializedName("place_id")
        String placeId = "";
        @SerializedName("types")
        List<String> types = new ArrayList<>();
    }

    class Route{
        @SerializedName("bounds")
        Bounds bounds  = new Bounds();
        @SerializedName("copyrights")
        String copyrights = "";
        @SerializedName("legs")
        List<Leg> legs = new ArrayList<>();
        @SerializedName("overview_polyline")
        OverviewPolyline overviewPolyline = new OverviewPolyline();
        @SerializedName("summary")
        String summary;
        @SerializedName("warnings")
        List<Object> warnings = new ArrayList<>();
        @SerializedName("waypoint_order")
        List<Integer> waypointOrder = new ArrayList<>();
    }

    class Bounds{
        @SerializedName("northeast")
        Location northeast = new Location();
        @SerializedName("southwest")
        Location southwest = new Location();
    }

    class TextValue{
        @SerializedName("text")
        String text = "";
        @SerializedName("value")
        int value = 0;
    }

    class Location{
        @SerializedName("lat")
        Double lat = 0.0;
        @SerializedName("lng")
        Double lng = 0.0;
    }

    class Leg{
        @SerializedName("distance")
        TextValue distance = new TextValue();
        @SerializedName("duration")
        TextValue duration = new TextValue();
        @SerializedName("end_address")
        String endAddress = "";
        @SerializedName("end_location")
        Location endLocation = new Location();
        @SerializedName("start_address")
        String startAddress = "";
        @SerializedName("start_location")
        Location startLocation = new Location();
        @SerializedName("steps")
        List<Step> steps = new ArrayList<>();
        @SerializedName("traffic_speed_entry")
        List<Object> traffictSpeedEntry = new ArrayList<>();
        @SerializedName("via_waypoint")
        List<Object> viaWaypoint = new ArrayList<>();

    }

    class OverviewPolyline{
        @SerializedName("points")
        String points = "";
    }

    class Polyline{
        @SerializedName("points")
        String points = "";
    }

    class Step{
        @SerializedName("distance")
        TextValue distance = new TextValue();
        @SerializedName("duration")
        TextValue duration = new TextValue();
        @SerializedName("end_location")
        Location endLocation = new Location();
        @SerializedName("html_instructions")
        String htmlInstructions = "";
        @SerializedName("maneuver")
        String maneuver = "";
        @SerializedName("polyline")
        Polyline polyline = new Polyline();
        @SerializedName("start_location")
        Location startLocation = new Location();
        @SerializedName("travel_mode")
        String travelMode = "";
    }

    interface DirectionsApi{
        @GET("json")
        Call<Directions> getDirections(@Query("origin")String origin,
                                       @Query("destination") String destination,
                                       @Query("key")String key);

    }

    public Call<Directions> runGetDirections(String orig, String dest, String key) {
        DirectionsApi directionsApi = retrofit.create(DirectionsApi.class);
        return directionsApi.getDirections(orig, dest, key);
    }


    private String BASE_URL = "https://maps.googleapis.com/maps/api/directions/";
    private ExtendedMap map;
    private Retrofit retrofit;
    OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_demo);
        SupportMapFragment supportMapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        assert supportMapFragment != null;
        supportMapFragment.getMapAsync(this);
        interceptor();
    }

    private void interceptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
    }

    Thread askDirections =  new Thread(){
        @Override
        public void run() {
            super.run();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
            Call<Directions> directionsCall = runGetDirections("Toronto", "Montreal", getString(R.string.maps_api_key));
            try{
                Response<Directions> response = directionsCall.execute();
                if (response.isSuccessful() && response.body() != null){
                    runOnUiThread(() -> {
                        setMarkers(response.body());
                        drawRoute(response.body());
                    });
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    };


    @Override
    public void onMapReady(ExtendedMap map) {
        this.map = map;
        askDirections.start();
    }


    private Directions setMarkers(Directions directions){

        if (directions.routes.size() >0){
            Leg leg = directions.routes.get(0).legs.get(0);
            LatLng startLocation = new LatLng(leg.startLocation.lat, leg.startLocation.lng);
            MarkerOptions startMarker = new MarkerOptions().position(startLocation);
            map.addMarker(startMarker);

            LatLng endLoation =  new LatLng(leg.endLocation.lat, leg.endLocation.lng);
            MarkerOptions endMarker = new MarkerOptions().position(endLoation);
            map.addMarker(endMarker);

            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(startLocation, 5f);
            map.moveCamera(cameraUpdate);
        }
        return directions;
    }

    private Directions drawRoute(Directions directions){
        if (directions.routes.size() >0){

            PolylineOptions polylineOptions = new PolylineOptions()
                    .geodesic(true)
                    .color(getResources().getColor(R.color.colorPrimary))
                    .addAll(decodePath(directions.routes.get(0).overviewPolyline.points));
            map.addPolyline(polylineOptions);
        }
        return directions;
    }


    private List<LatLng> decodePath(String input){
        List<LatLng> path = new ArrayList<>();
        int len = input.length();
        char[] inputChars = input.toCharArray();
        int index = 0;
        int lat = 0, lng = 0;
        while(index < len){
            int sum = 0;
            int shift = 0;
            int b;
            do{
                b = (int) inputChars[index++] - 63;
                sum |= (b & 31) << shift;
                shift += 5;
            }while (b >= 32 && index < inputChars.length);
            lat += (sum & 1) != 0 ? ~(sum >> 1):sum >> 1;
            sum = 0;
            shift = 0;
            do {
                b = (int) inputChars[index++] - 63;
                sum |= (b & 31) << shift;
                shift += 5;
            }while (b >= 32 && index < inputChars.length);
            lng += (sum & 1) != 0 ? ~(sum >> 1):sum >> 1;
            LatLng latLng = new LatLng(lat/100000.0, lng /100000.0);
            path.add(latLng);

        }
        return path;
    }

}
