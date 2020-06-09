package com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.maps.GoogleMap;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.maps.CameraUpdate;
import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.LocationSource;
import com.huawei.hms.maps.Projection;
import com.huawei.hms.maps.internal.ILocationSourceDelegate;
import com.huawei.hms.maps.internal.IProjectionDelegate;
import com.huawei.hms.maps.internal.LocationSourceDelegateImpl;
import com.huawei.hms.maps.model.CameraPosition;
import com.huawei.hms.maps.model.GroundOverlay;
import com.huawei.hms.maps.model.GroundOverlayOptions;
import com.huawei.hms.maps.model.IndoorBuilding;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.LatLngBounds;
import com.huawei.hms.maps.model.MapStyleOptions;
import com.huawei.hms.maps.model.Marker;
import com.huawei.hms.maps.model.MarkerOptions;
import com.huawei.hms.maps.model.PointOfInterest;
import com.huawei.hms.maps.model.Polygon;
import com.huawei.hms.maps.model.PolygonOptions;
import com.huawei.hms.maps.model.Polyline;
import com.huawei.hms.maps.model.PolylineOptions;
import com.huawei.hms.maps.model.TileOverlay;
import com.huawei.hms.maps.model.TileOverlayOptions;
import com.huawei.hms.maps.model.internal.ICircleDelegate;
import com.huawei.hms.maps.model.internal.IGroundOverlayDelegate;
import com.huawei.hms.maps.model.internal.IIndoorBuildingDelegate;
import com.huawei.hms.maps.model.internal.IMarkerDelegate;
import com.huawei.hms.maps.model.internal.IPolygonDelegate;
import com.huawei.hms.maps.model.internal.IPolylineDelegate;
import com.huawei.hms.maps.model.internal.ITileOverlayDelegate;
import com.huawei.hms.maps.util.LogM;

public class ExtendedMap {
    private  HuaweiMap huaweiMap;
    private  GoogleMap googleMap;


    public interface OnCameraMoveStartedListener {
        int REASON_GESTURE = 1;
        int REASON_API_ANIMATION = 2;
        int REASON_DEVELOPER_ANIMATION = 3;
        void onCameraMoveStarted(int var1);
    }

    public interface OnCameraIdleListener {
        void onCameraIdle();
    }

    public interface OnCameraMoveListener {
        void onCameraMove();
    }

    public interface OnCameraMoveCanceledListener {
        void onCameraMoveCanceled();
    }

    ExtendedMap(HuaweiMap huaweiMap) {
        this.huaweiMap = huaweiMap;
    }

    ExtendedMap(GoogleMap googleMap) {
        this.googleMap = googleMap;
    }

    public float getMaxZoomLevel() {
        if (huaweiMap != null)  return huaweiMap.getMaxZoomLevel();
        if (googleMap != null ) return googleMap.getMaxZoomLevel();
        return 0;
    }

    public float getMinZoomLevel() {
        if (huaweiMap != null)  return huaweiMap.getMinZoomLevel();
        if (googleMap != null ) return googleMap.getMinZoomLevel();
        return 0;
    }

    public void setOnCameraMoveStartedListener(final OnCameraMoveStartedListener listener) {
        if (huaweiMap != null) {
            huaweiMap.setOnCameraMoveStartedListener(new HuaweiMap.OnCameraMoveStartedListener() {
                @Override
                public void onCameraMoveStarted(int value) {
                    listener.onCameraMoveStarted(value);
                }
            });

        }else if (googleMap != null) {
            googleMap.setOnCameraMoveStartedListener(new GoogleMap.OnCameraMoveStartedListener() {
                @Override
                public void onCameraMoveStarted(int value) {
                    listener.onCameraMoveStarted(value);
                }
            });
        }
    }

    public void setOnCameraIdleListener(final OnCameraIdleListener listener){
        if (huaweiMap != null)  {
            huaweiMap.setOnCameraIdleListener(new HuaweiMap.OnCameraIdleListener() {
                @Override
                public void onCameraIdle() {
                    listener.onCameraIdle();
                }
            });
        }else if(googleMap != null){
            googleMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
                @Override
                public void onCameraIdle() {
                    listener.onCameraIdle();
                }
            });
        }
    }

    public void setOnCameraMoveListener(final OnCameraMoveListener listener) {
        if (huaweiMap != null){
            huaweiMap.setOnCameraMoveListener(new HuaweiMap.OnCameraMoveListener() {
                @Override
                public void onCameraMove() {
                    listener.onCameraMove();
                }
            });
        }else if (googleMap != null){
            googleMap.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() {
                @Override
                public void onCameraMove() {
                    listener.onCameraMove();
                }
            });
        }
    }

    public void setOnCameraMoveCanceledListener(final OnCameraMoveCanceledListener listener) {
        if (huaweiMap != null)  {
            huaweiMap.setOnCameraMoveCanceledListener(new HuaweiMap.OnCameraMoveCanceledListener() {
                @Override
                public void onCameraMoveCanceled() {
                    listener.onCameraMoveCanceled();
                }
            });
        }else if (googleMap != null){
            googleMap.setOnCameraMoveCanceledListener(new GoogleMap.OnCameraMoveCanceledListener() {
                @Override
                public void onCameraMoveCanceled() {
                    listener.onCameraMoveCanceled();
                }
            });
        }
    }

    public boolean isBuildingsEnabled() {
        if (huaweiMap != null)  return huaweiMap.isBuildingsEnabled();
        if (googleMap != null ) return googleMap.isBuildingsEnabled();
        return false;
    }

    public void setBuildingsEnabled(boolean value) {
        if (huaweiMap != null)  huaweiMap.setBuildingsEnabled(value);
        if (googleMap != null ) googleMap.setBuildingsEnabled(value);
    }

    public void setMapType(int type) {
        if (huaweiMap != null)  huaweiMap.setMapType(type);
        if (googleMap != null ) googleMap.setMapType(type);
    }

    public int getMapType() {
        if (huaweiMap != null)  return huaweiMap.getMapType();
        if (googleMap != null ) return googleMap.getMapType();
        return -1;
    }

    public void setMyLocationEnabled(boolean value) {
        if (huaweiMap != null)  huaweiMap.setMyLocationEnabled(value);
        if (googleMap != null ) googleMap.setMyLocationEnabled(value);
    }

    public boolean isMyLocationEnabled() {
        if (huaweiMap != null)  return huaweiMap.isMyLocationEnabled();
        if (googleMap != null ) return googleMap.isMyLocationEnabled();
        return false;
    }

    public UiSettings getUiSettings() {
        if (huaweiMap != null) return new UiSettings(huaweiMap);
        if (googleMap != null) return new UiSettings(googleMap);
        return null;
    }

    public boolean isIndoorEnabled() {
        if (huaweiMap != null)  return huaweiMap.isIndoorEnabled();
        if (googleMap != null ) return googleMap.isIndoorEnabled();
        return false;
    }

    public boolean setIndoorEnabled(boolean value) {
        if (huaweiMap != null)  return huaweiMap.setIndoorEnabled(value);
        if (googleMap != null ) return googleMap.setIndoorEnabled(value);
        return false;
    }

    public boolean isTrafficEnabled() {
        if (huaweiMap != null)  return huaweiMap.isTrafficEnabled();
        if (googleMap != null ) return googleMap.isTrafficEnabled();
        return false;
    }

    public void setContentDescription(String value) {
        if (huaweiMap != null)  huaweiMap.setContentDescription(value);
        if (googleMap != null ) googleMap.setContentDescription(value);
    }

    public void setMaxZoomPreference(float value) {
        if (huaweiMap != null)  huaweiMap.setMaxZoomPreference(value);
        if (googleMap != null ) googleMap.setMaxZoomPreference(value);
    }

    public void setMinZoomPreference(float value) {
        if (huaweiMap != null)  huaweiMap.setMinZoomPreference(value);
        if (googleMap != null ) googleMap.setMinZoomPreference(value);
    }

    public void resetMinMaxZoomPreference() {
        if (huaweiMap != null)  huaweiMap.resetMinMaxZoomPreference();
        if (googleMap != null ) googleMap.resetMinMaxZoomPreference();

    }

    public void setPadding(int var1, int var2, int var3, int var4) {
        if (huaweiMap != null)  huaweiMap.setPadding(var1, var2, var3, var4);
        if (googleMap != null ) googleMap.setPadding(var1, var2, var3, var4);
    }

    public void setTrafficEnabled(boolean value) {
        if (huaweiMap != null)   huaweiMap.setTrafficEnabled(value);
        if (googleMap != null )  googleMap.setTrafficEnabled(value);
    }

    public void clear() {
        if (huaweiMap != null)   huaweiMap.clear();
        if (googleMap != null )  googleMap.clear();
    }

    public Circle addCircle(CircleOptions options) {
        Circle circleW = null;
        if (huaweiMap != null){
            com.huawei.hms.maps.model.Circle circle = huaweiMap.addCircle(options.getHmsCircleOptions());
            circleW = new Circle(circle);
        }
        if (googleMap != null){
            com.google.android.gms.maps.model.Circle circle =googleMap.addCircle(options.getGmsCircleOptions());
            circleW = new Circle(circle);
        }
        return circleW;
    }


    public Polyline addPolyline(PolylineOptions var1) {
        Polyline var2 = null;
        IPolylineDelegate var3 = null;

        try {
            var3 = this.a.addPolyline(var1);
            var2 = new Polyline(var3);
        } catch (RemoteException var5) {
            LogM.d("HuaweiMap", "addPolyline RemoteException: " + var5.toString());
        }

        return var2;
    }

    public Polygon addPolygon(PolygonOptions var1) {
        Polygon var2 = null;
        IPolygonDelegate var3 = null;

        try {
            var3 = this.a.addPolygon(var1);
            var2 = new Polygon(var3);
        } catch (RemoteException var5) {
            LogM.d("HuaweiMap", "addPolygon RemoteException: " + var5.toString());
        }

        return var2;
    }

        public GroundOverlay addGroundOverlay(GroundOverlayOptions var1) {
            GroundOverlay var2 = null;
            IGroundOverlayDelegate var3 = null;

            try {
                var3 = this.a.addGroundOverlay(var1);
                if (var3 != null) {
                    var2 = new GroundOverlay(var3);
                }
            } catch (RemoteException var5) {
                LogM.d("HuaweiMap", "addGroundOverlay RemoteException: " + var5.toString());
            }

            return var2;
        }

        public TileOverlay addTileOverlay(TileOverlayOptions var1) {
            TileOverlay var2 = null;

            try {
                ITileOverlayDelegate var3 = this.a.addTileOverlay(var1);
                var2 = new TileOverlay(var3);
            } catch (RemoteException var4) {
                LogM.e("HuaweiMap", "addTileOverlay RemoteException: " + var4.toString());
            }

            return var2;
        }

        public void setGeoPoliticalView(String var1) {
            try {
                LogM.d("HuaweiMap", "setGeoPoliticalView : " + var1);
                this.a.setGeoPoliticalView(var1);
            } catch (RemoteException var3) {
                LogM.e("HuaweiMap", "setGeoPoliticalView RemoteException: " + var3.toString());
            }

        }

        public void animateCamera(CameraUpdate var1) {
            try {
                LogM.d("HuaweiMap", "animateCamera begin");
                this.a.animateCamera(var1.getCameraUpdate());
            } catch (RemoteException var3) {
                LogM.d("HuaweiMap", "RemoteException: " + var3.toString());
            }

        }

        public void moveCamera(CameraUpdate var1) {
            try {
                LogM.d("HuaweiMap", "moveCamera begin");
                this.a.moveCamera(var1.getCameraUpdate());
            } catch (RemoteException var3) {
                LogM.d("HuaweiMap", "RemoteException: " + var3.toString());
            }

        }

        public void animateCamera(CameraUpdate var1, final com.huawei.hms.maps.HuaweiMap.CancelableCallback var2) {
            LogM.i("HuaweiMap", "animateCamera(update,callback)");

            try {
                this.a.animateCameraWithCallback(var1.getCameraUpdate(), var2 == null ? null : new com.huawei.hms.maps.internal.ICancelableCallback.Stub() {
                    public void onFinish() {
                        var2.onFinish();
                    }

                    public void onCancel() {
                        var2.onCancel();
                    }
                });
            } catch (RemoteException var4) {
                LogM.d("HuaweiMap", "RemoteException" + var4.toString());
            }

        }

        public void animateCamera(CameraUpdate var1, int var2, final com.huawei.hms.maps.HuaweiMap.CancelableCallback var3) {
            try {
                this.a.animateCameraWithDurationAndCallback(var1.getCameraUpdate(), var2, var3 == null ? null : new com.huawei.hms.maps.internal.ICancelableCallback.Stub() {
                    public void onFinish() {
                        var3.onFinish();
                    }

                    public void onCancel() {
                        var3.onCancel();
                    }
                });
            } catch (RemoteException var5) {
                LogM.d("HuaweiMap", "RemoteException" + var5.toString());
            }

            LogM.i("HuaweiMap", "HuaweiMap does not support ");
        }

        public CameraPosition getCameraPosition() {
            CameraPosition var1 = null;

            try {
                LogM.d("HuaweiMap", "getCameraPosition begin");
                var1 = this.a.getCameraPosition();
            } catch (RemoteException var3) {
                LogM.d("HuaweiMap", "RemoteException: " + var3.toString());
            }

            return var1;
        }

        public void setInfoWindowAdapter(final com.huawei.hms.maps.HuaweiMap.InfoWindowAdapter var1) {
            try {
                this.a.setInfoWindowAdapter(new com.huawei.hms.maps.internal.IInfoWindowAdapter.Stub() {
                    public IObjectWrapper getInfoWindow(IMarkerDelegate var1x) {
                        return var1 == null ? null : ObjectWrapper.wrap(var1.getInfoWindow(new Marker(var1x)));
                    }

                    public IObjectWrapper getInfoContents(IMarkerDelegate var1x) {
                        return var1 == null ? null : ObjectWrapper.wrap(var1.getInfoContents(new Marker(var1x)));
                    }
                });
            } catch (RemoteException var3) {
                LogM.e("HuaweiMap", "RemoteException: " + var3.toString());
            }

        }

        public Marker addMarker(MarkerOptions var1) {
            Marker var2 = null;

            try {
                IMarkerDelegate var3 = this.a.addMarker(var1);
                var2 = new Marker(var3);
            } catch (RemoteException var5) {
                LogM.e("HuaweiMap", "RemoteException: " + var5.toString());
            }

            return var2;
        }

        public Projection getProjection() {
            Projection var1 = null;

            try {
                IProjectionDelegate var2 = this.a.getProjection();
                var1 = new Projection(var2);
            } catch (RemoteException var4) {
                LogM.e("HuaweiMap", "getProjection: " + var4.getMessage());
            }

            return var1;
        }

        public void setOnMapLoadedCallback(final com.huawei.hms.maps.HuaweiMap.OnMapLoadedCallback var1) {
            try {
                this.a.setOnMapLoadedCallback(new com.huawei.hms.maps.internal.IOnMapLoadedCallback.Stub() {
                    public void onMapLoaded() {
                        if (var1 != null) {
                            var1.onMapLoaded();
                        }
                    }
                });
            } catch (RemoteException var3) {
                LogM.i("HuaweiMap", "setOnMapLoadedCallback: " + var3.getMessage());
            }

        }

        public void setOnMarkerClickListener(final com.huawei.hms.maps.HuaweiMap.OnMarkerClickListener var1) {
            LogM.i("HuaweiMap", "onMarkerClick setListener start: ");

            try {
                this.a.setMarkerClickListener(var1 == null ? null : new com.huawei.hms.maps.internal.IOnMarkerClickListener.Stub() {
                    public boolean onMarkerClick(IMarkerDelegate var1x) {
                        LogM.i("HuaweiMap", "onMarkerClick callback start: ");
                        Marker var2 = new Marker(var1x);
                        if (null != var1) {
                            var1.onMarkerClick(var2);
                        }

                        return true;
                    }
                });
            } catch (RemoteException var3) {
                LogM.e("HuaweiMap", "RemoteException: " + var3.toString());
            }

        }

        public void setOnMarkerDragListener(final com.huawei.hms.maps.HuaweiMap.OnMarkerDragListener var1) {
            LogM.i("HuaweiMap", "onMarkerDrag setListener start: ");

            try {
                this.a.setMarkerDragListener(var1 == null ? null : new com.huawei.hms.maps.internal.IOnMarkerDragListener.Stub() {
                    public void onMarkerDragStart(IMarkerDelegate var1x) {
                        LogM.i("HuaweiMap", "onMarkerDrag callback start: ");
                        Marker var2 = new Marker(var1x);
                        var1.onMarkerDragStart(var2);
                    }

                    public void onMarkerDrag(IMarkerDelegate var1x) {
                        LogM.i("HuaweiMap", "onMarkerDrag callback start: ");
                        Marker var2 = new Marker(var1x);
                        var1.onMarkerDrag(var2);
                    }

                    public void onMarkerDragEnd(IMarkerDelegate var1x) {
                        LogM.i("HuaweiMap", "onMarkerDrag callback start: ");
                        Marker var2 = new Marker(var1x);
                        var1.onMarkerDragEnd(var2);
                    }
                });
            } catch (RemoteException var3) {
                LogM.e("HuaweiMap", "RemoteException: " + var3.toString());
            }

        }

        public void setOnCircleClickListener(final com.huawei.hms.maps.HuaweiMap.OnCircleClickListener var1) {
            LogM.i("HuaweiMap", "onCircleClick setListener start: ");

            try {
                this.a.setCircleClickListener(var1 == null ? null : new com.huawei.hms.maps.internal.IOnCircleClickListener.Stub() {
                    public void onCircleClick(ICircleDelegate var1x) {
                        LogM.i("HuaweiMap", "onCircleClick callback start: ");
                        Circle var2 = new Circle(var1x);
                        if (null != var1) {
                            var1.onCircleClick(var2);
                        }

                    }
                });
            } catch (RemoteException var3) {
                LogM.e("HuaweiMap", "RemoteException: " + var3.toString());
            }

        }

        public void setOnPolylineClickListener(final com.huawei.hms.maps.HuaweiMap.OnPolylineClickListener var1) {
            LogM.i("HuaweiMap", "setOnCircleClickListener: ");

            try {
                this.a.setPolylineClickListener(var1 == null ? null : new com.huawei.hms.maps.internal.IOnPolylineClickListener.Stub() {
                    public void onPolylineClick(IPolylineDelegate var1x) {
                        LogM.i("HuaweiMap", "onPolylineClick first: ");
                        Polyline var2 = new Polyline(var1x);
                        if (null != var1) {
                            var1.onPolylineClick(var2);
                        }

                    }
                });
            } catch (RemoteException var3) {
                LogM.e("HuaweiMap", "RemoteException: " + var3.toString());
            }

        }

        public void setOnPolygonClickListener(final com.huawei.hms.maps.HuaweiMap.OnPolygonClickListener var1) {
            LogM.i("HuaweiMap", "setOnPolygonClickListener: ");

            try {
                this.a.setPolygonClickListener(var1 == null ? null : new com.huawei.hms.maps.internal.IOnPolygonClickListener.Stub() {
                    public void onPolygonClick(IPolygonDelegate var1x) {
                        LogM.i("HuaweiMap", "onPolygonClick entrance: ");
                        Polygon var2 = new Polygon(var1x);
                        if (null != var1) {
                            var1.onPolygonClick(var2);
                        }

                    }
                });
            } catch (RemoteException var3) {
                LogM.e("HuaweiMap", "RemoteException: " + var3.toString());
            }

        }

        public void setOnMapClickListener(final com.huawei.hms.maps.HuaweiMap.OnMapClickListener var1) {
            LogM.i("HuaweiMap", "setOnMapClickListener: ");

            try {
                this.a.setOnMapClickListener(var1 == null ? null : new com.huawei.hms.maps.internal.IOnMapClickListener.Stub() {
                    public void onMapClick(LatLng var1x) {
                        var1.onMapClick(var1x);
                    }
                });
            } catch (RemoteException var3) {
                LogM.e("HuaweiMap", "RemoteException: " + var3.toString());
            }

        }

        public void setOnMapLongClickListener(final com.huawei.hms.maps.HuaweiMap.OnMapLongClickListener var1) {
            LogM.d("HuaweiMap", "setOnMapLongClickListener");

            try {
                this.a.setOnMapLongClickListener(var1 == null ? null : new com.huawei.hms.maps.internal.IOnMapLongClickListener.Stub() {
                    public void onMapLongClick(LatLng var1x) {
                        LogM.d("HuaweiMap", "onMapLongClick");
                        var1.onMapLongClick(var1x);
                    }
                });
            } catch (RemoteException var3) {
                LogM.e("HuaweiMap", "RemoteException: " + var3.toString());
            }

        }

        public void setOnMyLocationButtonClickListener(final com.huawei.hms.maps.HuaweiMap.OnMyLocationButtonClickListener var1) {
            LogM.i("HuaweiMap", "setOnMyLocationButtonClickListener: ");

            try {
                this.a.setOnMyLocationButtonClickListener(var1 == null ? null : new com.huawei.hms.maps.internal.IOnMyLocationButtonClickListener.Stub() {
                    public boolean onMyLocationButtonClick() {
                        return var1.onMyLocationButtonClick();
                    }
                });
            } catch (RemoteException var3) {
                LogM.e("HuaweiMap", "RemoteException: ");
            }

        }

        public final boolean setMapStyle(@Nullable MapStyleOptions var1) {
            boolean var2 = false;

            try {
                var2 = this.a.setMapStyle(var1);
            } catch (RemoteException var4) {
                LogM.e("HuaweiMap", "RemoteException: " + var4.toString());
            }

            return var2;
        }

        public void snapshot(final com.huawei.hms.maps.HuaweiMap.SnapshotReadyCallback var1, Bitmap var2) {
            try {
                this.a.snapshot(new com.huawei.hms.maps.internal.ISnapshotReadyCallback.Stub() {
                    public void onSnapshotReady(Bitmap var1x) {
                        if (var1 != null) {
                            var1.onSnapshotReady(var1x);
                        }
                    }

                    public void onSnapshotReadyWrapper(IObjectWrapper var1x) {
                    }
                }, ObjectWrapper.wrap(var2));
            } catch (RemoteException var4) {
                LogM.e("HuaweiMap", "snapshot" + var4);
            }

        }

        public void snapshot(final com.huawei.hms.maps.HuaweiMap.SnapshotReadyCallback var1) {
            try {
                this.a.snapshotForTest(new com.huawei.hms.maps.internal.ISnapshotReadyCallback.Stub() {
                    public void onSnapshotReady(Bitmap var1x) {
                        if (var1 != null) {
                            var1.onSnapshotReady(var1x);
                        }
                    }

                    public void onSnapshotReadyWrapper(IObjectWrapper var1x) {
                    }
                });
            } catch (RemoteException var3) {
                LogM.e("HuaweiMap", "snapshot" + var3);
            }

        }

        public void stopAnimation() {
            try {
                this.a.stopAnimation();
            } catch (RemoteException var2) {
                LogM.e("HuaweiMap", "stopAnimation" + var2);
            }

        }

        public void setOnMyLocationClickListener(final com.huawei.hms.maps.HuaweiMap.OnMyLocationClickListener var1) {
            try {
                this.a.setOnMyLocationClickListener(var1 == null ? null : new com.huawei.hms.maps.internal.IOnMyLocationClickListener.Stub() {
                    public void onMyLocationClick(Location var1x) {
                        var1.onMyLocationClick(var1x);
                    }
                });
            } catch (RemoteException var3) {
                LogM.e("HuaweiMap", "setOnMyLocationClickListener RemoteException");
            }

        }

        public void setOnPoiClickListener(final com.huawei.hms.maps.HuaweiMap.OnPoiClickListener var1) {
            try {
                this.a.setOnPoiClickListener(var1 == null ? null : new com.huawei.hms.maps.internal.IOnPoiClickListener.Stub() {
                    public void onPoiClick(PointOfInterest var1x) {
                        var1.onPoiClick(var1x);
                    }
                });
            } catch (RemoteException var3) {
                LogM.e("HuaweiMap", "setOnPoiClickListener" + var3);
            }

        }

        public void setLatLngBoundsForCameraTarget(LatLngBounds var1) {
            try {
                this.a.setLatLngBoundsForCameraTarget(var1);
            } catch (RemoteException var3) {
                LogM.e("HuaweiMap", "RemoteException: " + var3.toString());
            }

        }

        public void setMarkersClustering(boolean var1) {
            try {
                this.a.setMarkersClustering(var1);
            } catch (RemoteException var3) {
                LogM.d("HuaweiMap", "RemoteException: " + var3.toString());
            }

        }

        public void setLocationSource(LocationSource var1) {
            LogM.i("HuaweiMap", "setLocationSource: ");

            try {
                if (var1 == null) {
                    this.a.setLocationSource((ILocationSourceDelegate)null);
                } else {
                    this.a.setLocationSource(new LocationSourceDelegateImpl(var1));
                }
            } catch (RemoteException var3) {
                LogM.e("HuaweiMap", "RemoteException: " + var3.toString());
            }

        }

        public void setOnInfoWindowClickListener(final com.huawei.hms.maps.HuaweiMap.OnInfoWindowClickListener var1) {
            LogM.i("HuaweiMap", "onInfoWindowClick setListener start: ");

            try {
                this.a.setOnInfoWindowClickListener(var1 == null ? null : new com.huawei.hms.maps.internal.IOnInfoWindowClickListener.Stub() {
                    public void onInfoWindowClick(IMarkerDelegate var1x) {
                        LogM.i("HuaweiMap", "onInfoWindowClick callback start: ");
                        Marker var2 = new Marker(var1x);
                        var1.onInfoWindowClick(var2);
                    }
                });
            } catch (RemoteException var3) {
                LogM.e("HuaweiMap", "RemoteException: " + var3.toString());
            }

        }

        public void setOnGroundOverlayClickListener(final com.huawei.hms.maps.HuaweiMap.OnGroundOverlayClickListener var1) {
            try {
                this.a.setOnGroundOverlayClickListener(var1 == null ? null : new com.huawei.hms.maps.internal.IOnGroundOverlayClickListener.Stub() {
                    public void onGroundOverlayClick(IGroundOverlayDelegate var1x) {
                        var1.onGroundOverlayClick(new GroundOverlay(var1x));
                    }
                });
            } catch (RemoteException var3) {
                LogM.e("HuaweiMap", "setOnGroundOverlayClickListener RemoteException: " + var3.toString());
            }

        }

        public void setOnIndoorStateChangeListener(final com.huawei.hms.maps.HuaweiMap.OnIndoorStateChangeListener var1) {
            try {
                this.a.setOnIndoorStateChangeListener(var1 == null ? null : new com.huawei.hms.maps.internal.IOnIndoorStateChangeListener.Stub() {
                    public void onIndoorBuildingFocused() {
                        var1.onIndoorBuildingFocused();
                    }

                    public void onIndoorLevelActivated(IIndoorBuildingDelegate var1x) {
                        var1.onIndoorLevelActivated(new IndoorBuilding(var1x));
                    }
                });
            } catch (RemoteException var3) {
                LogM.e("HuaweiMap", "setOnIndoorStateChangeListener RemoteException: " + var3.toString());
            }

        }

        public void setOnInfoWindowCloseListener(final com.huawei.hms.maps.HuaweiMap.OnInfoWindowCloseListener var1) {
            try {
                this.a.setOnInfoWindowCloseListener(var1 == null ? null : new com.huawei.hms.maps.internal.IOnInfoWindowCloseListener.Stub() {
                    public void onInfoWindowClose(IMarkerDelegate var1x) {
                        var1.onInfoWindowClose(new Marker(var1x));
                    }
                });
            } catch (RemoteException var3) {
                LogM.e("HuaweiMap", "setOnInfoWindowCloseListener RemoteException: " + var3.toString());
            }

        }

        public void setOnInfoWindowLongClickListener(final com.huawei.hms.maps.HuaweiMap.OnInfoWindowLongClickListener var1) {
            try {
                this.a.setOnInfoWindowLongClickListener(var1 == null ? null : new com.huawei.hms.maps.internal.IOnInfoWindowLongClickListener.Stub() {
                    public void onInfoWindowLongClick(IMarkerDelegate var1x) {
                        var1.onInfoWindowLongClick(new Marker(var1x));
                    }
                });
            } catch (RemoteException var3) {
                LogM.e("HuaweiMap", "setOnInfoWindowLongClickListener RemoteException: " + var3.toString());
            }

        }



















}
