package maps.wrapper;

import android.location.Location;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;
import com.huawei.hms.maps.HuaweiMap;


public class ExtendedMap {
    private HuaweiMap huaweiMap;
    private GoogleMap googleMap;


    public final static int MAP_TYPE_NONE = GoogleMap.MAP_TYPE_NONE;
    public final static int MAP_TYPE_NORMAL = GoogleMap.MAP_TYPE_NORMAL;
    public final static int MAP_TYPE_SATELLITE = GoogleMap.MAP_TYPE_SATELLITE;
    public final static int MAP_TYPE_TERRAIN = GoogleMap.MAP_TYPE_TERRAIN;
    public final static int MAP_TYPE_HYBRID = GoogleMap.MAP_TYPE_HYBRID;

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

    public interface CancelableCallback {
        void onFinish();

        void onCancel();
    }

    public interface InfoWindowAdapter {
        View getInfoWindow(Marker marker);

        View getInfoContents(Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng position);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDragStart(Marker marker);

        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);
    }

    public interface OnCircleClickListener {
        void onCircleClick(Circle circle);
    }

    public interface OnPolylineClickListener {
        void onPolylineClick(Polyline polyline);
    }

    public interface OnGroundOverlayClickListener {
        void onGroundOverlayClick(GroundOverlay groundOverlay);
    }

    public interface OnPolygonClickListener {
        void onPolygonClick(Polygon polygon);
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng position);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnInfoWindowCloseListener {
        void onInfoWindowClose(Marker marker);
    }

    public interface OnInfoWindowLongClickListener {
        void onInfoWindowLongClick(Marker marker);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMyLocationButtonClickListener {
        boolean onMyLocationButtonClick();
    }

    ExtendedMap(HuaweiMap huaweiMap) {
        this.huaweiMap = huaweiMap;
    }

    ExtendedMap(GoogleMap googleMap) {
        this.googleMap = googleMap;
    }

    private boolean isGoogle() {
        return googleMap != null;
    }

    private boolean isHuawei() {
        return huaweiMap != null;
    }

    public float getMaxZoomLevel() {
        if (isHuawei()) return huaweiMap.getMaxZoomLevel();
        if (isGoogle()) return googleMap.getMaxZoomLevel();
        return 0;
    }

    public float getMinZoomLevel() {
        if (isHuawei()) return huaweiMap.getMinZoomLevel();
        if (isGoogle()) return googleMap.getMinZoomLevel();
        return 0;
    }

    public void setOnCameraMoveStartedListener(final OnCameraMoveStartedListener listener) {
        if (isHuawei()) {
            huaweiMap.setOnCameraMoveStartedListener(new HuaweiMap.OnCameraMoveStartedListener() {
                @Override
                public void onCameraMoveStarted(int value) {
                    listener.onCameraMoveStarted(value);
                }
            });
        }

        if (isGoogle()) {
            googleMap.setOnCameraMoveStartedListener(new GoogleMap.OnCameraMoveStartedListener() {
                @Override
                public void onCameraMoveStarted(int value) {
                    listener.onCameraMoveStarted(value);
                }
            });
        }
    }

    public void setOnCameraIdleListener(final OnCameraIdleListener listener) {
        if (isHuawei()) {
            huaweiMap.setOnCameraIdleListener(new HuaweiMap.OnCameraIdleListener() {
                @Override
                public void onCameraIdle() {
                    listener.onCameraIdle();
                }
            });
        }
        if (isGoogle()) {
            googleMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
                @Override
                public void onCameraIdle() {
                    listener.onCameraIdle();
                }
            });
        }
    }

    public void setOnCameraMoveListener(final OnCameraMoveListener listener) {
        if (isHuawei()) {
            huaweiMap.setOnCameraMoveListener(new HuaweiMap.OnCameraMoveListener() {
                @Override
                public void onCameraMove() {
                    listener.onCameraMove();
                }
            });
        }
        if (isGoogle()) {
            googleMap.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() {
                @Override
                public void onCameraMove() {
                    listener.onCameraMove();
                }
            });
        }
    }

    public void setOnCameraMoveCanceledListener(final OnCameraMoveCanceledListener listener) {
        if (isHuawei()) {
            huaweiMap.setOnCameraMoveCanceledListener(new HuaweiMap.OnCameraMoveCanceledListener() {
                @Override
                public void onCameraMoveCanceled() {
                    listener.onCameraMoveCanceled();
                }
            });
        }
        if (isGoogle()) {
            googleMap.setOnCameraMoveCanceledListener(new GoogleMap.OnCameraMoveCanceledListener() {
                @Override
                public void onCameraMoveCanceled() {
                    listener.onCameraMoveCanceled();
                }
            });
        }
    }

    public boolean isBuildingsEnabled() {
        if (isHuawei()) return huaweiMap.isBuildingsEnabled();
        if (isGoogle()) return googleMap.isBuildingsEnabled();
        return false;
    }

    public void setBuildingsEnabled(boolean value) {
        if (isHuawei()) huaweiMap.setBuildingsEnabled(value);
        if (isGoogle()) googleMap.setBuildingsEnabled(value);
    }

    /**
     * This is not part of any API (GMS or HMS).
     * Call it to check if the underlying map accepts this mapType. Scenario: should the app still show an UI element the user can press to switch to a different mapType if that's not supported?
     *
     * @param mapType the desired map type to evaluate, i.e. ExtendedMap.MAP_TYPE_HYBRID
     * @return
     */
    public boolean isMapTypeSupported(int mapType) {
        if (isHuawei()) {
            //https://developer.huawei.com/consumer/en/doc/development/HMSCore-References-V5/huaweimap-0000001050151757-V5
            switch (mapType) {
                case ExtendedMap.MAP_TYPE_HYBRID:
                case ExtendedMap.MAP_TYPE_SATELLITE:
                case ExtendedMap.MAP_TYPE_TERRAIN:
                    return false;
                default:
                    return true;
            }
        } else {
            return true;
        }
    }

    public void setMapType(int mapType) {
        if (isHuawei()) {
            if (mapType == ExtendedMap.MAP_TYPE_HYBRID) {
                // Hybrid not yet supported, instead of an empty map, just show the normal layer
                huaweiMap.setMapType(HuaweiMap.MAP_TYPE_NORMAL);
            } else {
                huaweiMap.setMapType(mapType);
            }
        }
        if (isGoogle()) googleMap.setMapType(mapType);
    }

    public int getMapType() {
        if (isHuawei()) return huaweiMap.getMapType();
        if (isGoogle()) return googleMap.getMapType();
        return -1;
    }

    public void setMyLocationEnabled(boolean value) {
        if (isHuawei()) huaweiMap.setMyLocationEnabled(value);
        if (isGoogle()) googleMap.setMyLocationEnabled(value);
    }

    public boolean isMyLocationEnabled() {
        if (isHuawei()) return huaweiMap.isMyLocationEnabled();
        if (isGoogle()) return googleMap.isMyLocationEnabled();
        return false;
    }

    public CameraPosition getCameraPosition() {
        CameraPosition cameraPosition = null;
        if (googleMap != null)
            cameraPosition = new CameraPosition(googleMap.getCameraPosition(), null);
        if (huaweiMap != null)
            cameraPosition = new CameraPosition(null, huaweiMap.getCameraPosition());
        return cameraPosition;
    }


    public UiSettings getUiSettings() {
        if (isGoogle()) return new UiSettings(googleMap);
        if (isHuawei()) return new UiSettings(huaweiMap);
        return null;
    }

    public boolean isIndoorEnabled() {
        if (isHuawei()) return huaweiMap.isIndoorEnabled();
        if (isGoogle()) return googleMap.isIndoorEnabled();
        return false;
    }

    public boolean setIndoorEnabled(boolean value) {
        if (isHuawei()) return huaweiMap.setIndoorEnabled(value);
        if (isGoogle()) return googleMap.setIndoorEnabled(value);
        return false;
    }

    public boolean isTrafficEnabled() {
        if (isHuawei()) return huaweiMap.isTrafficEnabled();
        if (isGoogle()) return googleMap.isTrafficEnabled();
        return false;
    }

    public void setContentDescription(String value) {
        if (isHuawei()) huaweiMap.setContentDescription(value);
        if (isGoogle()) googleMap.setContentDescription(value);
    }

    public void setMaxZoomPreference(float value) {
        if (isHuawei()) huaweiMap.setMaxZoomPreference(value);
        if (isGoogle()) googleMap.setMaxZoomPreference(value);
    }

    public void setMinZoomPreference(float value) {
        if (isHuawei()) huaweiMap.setMinZoomPreference(value);
        if (isGoogle()) googleMap.setMinZoomPreference(value);
    }

    public void resetMinMaxZoomPreference() {
        if (isHuawei()) huaweiMap.resetMinMaxZoomPreference();
        if (isGoogle()) googleMap.resetMinMaxZoomPreference();

    }

    public void setPadding(int var1, int var2, int var3, int var4) {
        if (isHuawei()) huaweiMap.setPadding(var1, var2, var3, var4);
        if (isGoogle()) googleMap.setPadding(var1, var2, var3, var4);
    }

    public void setTrafficEnabled(boolean value) {
        if (isHuawei()) huaweiMap.setTrafficEnabled(value);
        if (isGoogle()) googleMap.setTrafficEnabled(value);
    }

    public void clear() {
        if (isHuawei()) huaweiMap.clear();
        if (isGoogle()) googleMap.clear();
    }

    public Circle addCircle(CircleOptions options) {
        Circle circleW = null;
        if (isHuawei()) {
            com.huawei.hms.maps.model.Circle circle = huaweiMap.addCircle(options.huawei);
            circleW = new Circle(circle);
        }
        if (isGoogle()) {
            com.google.android.gms.maps.model.Circle circle = googleMap.addCircle(options.google);
            circleW = new Circle(circle);
        }
        return circleW;
    }

    public Polyline addPolyline(PolylineOptions value) {
        Polyline result = null;
        if (isGoogle()) {
            result = new Polyline(googleMap.addPolyline(value.gOptions));
        }
        if (isHuawei()) {
            result = new Polyline(huaweiMap.addPolyline(value.hOptions));
        }
        return result;
    }

    public Polygon addPolygon(PolygonOptions value) {
        Polygon result = null;
        if (isGoogle()) {
            result = new Polygon(googleMap.addPolygon(value.google), null);
        }
        if (isHuawei()) {
            result = new Polygon(null, huaweiMap.addPolygon(value.huawei));
        }
        return result;
    }

    public GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        GroundOverlay result = null;

        if (isGoogle()) {
            result = new GroundOverlay(googleMap.addGroundOverlay(groundOverlayOptions.google), null);
        }
        if (isHuawei()) {
            result = new GroundOverlay(null, huaweiMap.addGroundOverlay(groundOverlayOptions.huawei));
        }
        return result;
    }

    public void animateCamera(CameraUpdate value) {
        if (isGoogle()) googleMap.animateCamera(value.google);
        if (isHuawei()) huaweiMap.animateCamera(value.huawei);
    }

    public void moveCamera(CameraUpdate value) {
        if (isGoogle()) googleMap.moveCamera(value.google);
        if (isHuawei()) huaweiMap.moveCamera(value.huawei);
    }

    public void animateCamera(CameraUpdate value, final CancelableCallback callback) {
        if (isGoogle()) {
            googleMap.animateCamera(value.google, new GoogleMap.CancelableCallback() {
                @Override
                public void onFinish() {
                    if (callback != null) callback.onFinish();
                }

                @Override
                public void onCancel() {
                    if (callback != null) callback.onCancel();
                }
            });
        }

        if (isHuawei()) {
            huaweiMap.animateCamera(value.huawei, new HuaweiMap.CancelableCallback() {
                @Override
                public void onFinish() {
                    if (callback != null) callback.onFinish();
                }

                @Override
                public void onCancel() {
                    if (callback != null) callback.onCancel();
                }
            });
        }
    }

    public void animateCamera(CameraUpdate cameraUpdate, int value, final CancelableCallback callback) {
        if (isGoogle()) {
            googleMap.animateCamera(cameraUpdate.google, value, new GoogleMap.CancelableCallback() {
                @Override
                public void onFinish() {
                    if (callback != null) callback.onFinish();
                }

                @Override
                public void onCancel() {
                    if (callback != null) callback.onCancel();
                }
            });
        }

        if (isHuawei()) {
            huaweiMap.animateCamera(cameraUpdate.huawei, value, new HuaweiMap.CancelableCallback() {
                @Override
                public void onFinish() {
                    if (callback != null) callback.onFinish();
                }

                @Override
                public void onCancel() {
                    if (callback != null) callback.onCancel();
                }
            });
        }
    }

    public void setInfoWindowAdapter(final InfoWindowAdapter adapter) {
        if (isGoogle()) {
            googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
                @Override
                public View getInfoWindow(com.google.android.gms.maps.model.Marker marker) {
                    return adapter.getInfoWindow(new Marker(marker, null));
                }

                @Override
                public View getInfoContents(com.google.android.gms.maps.model.Marker marker) {
                    return adapter.getInfoContents(new Marker(marker, null));
                }
            });
        }

        if (isHuawei()) {
            huaweiMap.setInfoWindowAdapter(new HuaweiMap.InfoWindowAdapter() {
                @Override
                public View getInfoContents(com.huawei.hms.maps.model.Marker marker) {
                    return adapter.getInfoContents(new Marker(null, marker));
                }

                @Override
                public View getInfoWindow(com.huawei.hms.maps.model.Marker marker) {
                    return adapter.getInfoWindow(new Marker(null, marker));
                }
            });
        }
    }

    public Marker addMarker(MarkerOptions markerOptions) {
        Marker marker = null;
        if (isGoogle()) marker = new Marker(googleMap.addMarker(markerOptions.google), null);
        if (isHuawei()) marker = new Marker(null, huaweiMap.addMarker(markerOptions.huawei));
        return marker;
    }

    public Projection getProjection() {
        Projection result = null;
        if (isHuawei()) result = new Projection(huaweiMap.getProjection(), null);
        if (isGoogle()) result = new Projection(null, googleMap.getProjection());
        return result;
    }

    public void setOnMarkerClickListener(final OnMarkerClickListener listener) {
        if (isGoogle()) googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(com.google.android.gms.maps.model.Marker marker) {
                return listener.onMarkerClick(new Marker(marker, null));
            }
        });
        if (isHuawei()) huaweiMap.setOnMarkerClickListener(new HuaweiMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(com.huawei.hms.maps.model.Marker marker) {
                return listener.onMarkerClick(new Marker(null, marker));
            }
        });

    }

    public void setOnMarkerDragListener(final OnMarkerDragListener listener) {
        if (isGoogle()) googleMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(com.google.android.gms.maps.model.Marker marker) {
                listener.onMarkerDragStart(new Marker(marker, null));
            }

            @Override
            public void onMarkerDrag(com.google.android.gms.maps.model.Marker marker) {
                listener.onMarkerDrag(new Marker(marker, null));
            }

            @Override
            public void onMarkerDragEnd(com.google.android.gms.maps.model.Marker marker) {
                listener.onMarkerDragEnd(new Marker(marker, null));
            }
        });

        if (isHuawei()) huaweiMap.setOnMarkerDragListener(new HuaweiMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(com.huawei.hms.maps.model.Marker marker) {
                listener.onMarkerDragStart(new Marker(null, marker));
            }

            @Override
            public void onMarkerDrag(com.huawei.hms.maps.model.Marker marker) {
                listener.onMarkerDrag(new Marker(null, marker));
            }

            @Override
            public void onMarkerDragEnd(com.huawei.hms.maps.model.Marker marker) {
                listener.onMarkerDragEnd(new Marker(null, marker));
            }
        });
    }

    public void setOnCircleClickListener(final OnCircleClickListener listener) {
        if (isGoogle()) googleMap.setOnCircleClickListener(new GoogleMap.OnCircleClickListener() {
            @Override
            public void onCircleClick(com.google.android.gms.maps.model.Circle circle) {
                listener.onCircleClick(new Circle(circle));
            }
        });
        if (isHuawei()) huaweiMap.setOnCircleClickListener(new HuaweiMap.OnCircleClickListener() {
            @Override
            public void onCircleClick(com.huawei.hms.maps.model.Circle circle) {
                listener.onCircleClick(new Circle(circle));
            }
        });
    }

    public void setOnPolylineClickListener(final OnPolylineClickListener listener) {
        if (isGoogle())
            googleMap.setOnPolylineClickListener(new GoogleMap.OnPolylineClickListener() {
                @Override
                public void onPolylineClick(com.google.android.gms.maps.model.Polyline polyline) {
                    listener.onPolylineClick(new Polyline(polyline));
                }
            });

        if (isHuawei())
            huaweiMap.setOnPolylineClickListener(new HuaweiMap.OnPolylineClickListener() {
                @Override
                public void onPolylineClick(com.huawei.hms.maps.model.Polyline polyline) {
                    listener.onPolylineClick(new Polyline(polyline));
                }
            });
    }

    public void setOnPolygonClickListener(final OnPolygonClickListener listener) {
        if (isGoogle()) googleMap.setOnPolygonClickListener(new GoogleMap.OnPolygonClickListener() {
            @Override
            public void onPolygonClick(com.google.android.gms.maps.model.Polygon polygon) {
                listener.onPolygonClick(new Polygon(polygon, null));
            }
        });

        if (isHuawei()) huaweiMap.setOnPolygonClickListener(new HuaweiMap.OnPolygonClickListener() {
            @Override
            public void onPolygonClick(com.huawei.hms.maps.model.Polygon polygon) {
                listener.onPolygonClick(new Polygon(null, polygon));
            }
        });
    }

    public void setOnMapClickListener(final OnMapClickListener listener) {
        if (isGoogle()) googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(com.google.android.gms.maps.model.LatLng latLng) {
                listener.onMapClick(new LatLng(latLng.latitude, latLng.longitude));
            }
        });

        if (isHuawei()) huaweiMap.setOnMapClickListener(new HuaweiMap.OnMapClickListener() {
            @Override
            public void onMapClick(com.huawei.hms.maps.model.LatLng latLng) {
                listener.onMapClick(new LatLng(latLng.latitude, latLng.longitude));
            }
        });
    }

    public void setOnMapLongClickListener(final OnMapLongClickListener listener) {
        if (isGoogle()) googleMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(com.google.android.gms.maps.model.LatLng latLng) {
                listener.onMapLongClick(new LatLng(latLng.latitude, latLng.longitude));
            }
        });

        if (isHuawei()) huaweiMap.setOnMapLongClickListener(new HuaweiMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(com.huawei.hms.maps.model.LatLng latLng) {
                listener.onMapLongClick(new LatLng(latLng.latitude, latLng.longitude));
            }
        });
    }

    public void stopAnimation() {
        if (isHuawei()) huaweiMap.stopAnimation();
        if (isGoogle()) googleMap.stopAnimation();
    }

    public void setOnInfoWindowClickListener(final OnInfoWindowClickListener listener) {
        if (isGoogle())
            googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(com.google.android.gms.maps.model.Marker marker) {
                    listener.onInfoWindowClick(new Marker(marker, null));
                }
            });
        if (isHuawei())
            huaweiMap.setOnInfoWindowClickListener(new HuaweiMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(com.huawei.hms.maps.model.Marker marker) {
                    listener.onInfoWindowClick(new Marker(null, marker));
                }
            });
    }

    public void setOnGroundOverlayClickListener(final OnGroundOverlayClickListener listener) {
        if (isGoogle())
            googleMap.setOnGroundOverlayClickListener(new GoogleMap.OnGroundOverlayClickListener() {
                @Override
                public void onGroundOverlayClick(com.google.android.gms.maps.model.GroundOverlay groundOverlay) {
                    listener.onGroundOverlayClick(new GroundOverlay(groundOverlay, null));
                }
            });
        if (isHuawei())
            huaweiMap.setOnGroundOverlayClickListener(new HuaweiMap.OnGroundOverlayClickListener() {
                @Override
                public void onGroundOverlayClick(com.huawei.hms.maps.model.GroundOverlay groundOverlay) {
                    listener.onGroundOverlayClick(new GroundOverlay(null, groundOverlay));
                }
            });
    }

    public void setOnInfoWindowCloseListener(final OnInfoWindowCloseListener listener) {
        if (isGoogle())
            googleMap.setOnInfoWindowCloseListener(new GoogleMap.OnInfoWindowCloseListener() {
                @Override
                public void onInfoWindowClose(com.google.android.gms.maps.model.Marker marker) {
                    listener.onInfoWindowClose(new Marker(marker, null));
                }
            });
        if (isHuawei())
            huaweiMap.setOnInfoWindowCloseListener(new HuaweiMap.OnInfoWindowCloseListener() {
                @Override
                public void onInfoWindowClose(com.huawei.hms.maps.model.Marker marker) {
                    listener.onInfoWindowClose(new Marker(null, marker));
                }
            });
    }

    public void setOnInfoWindowLongClickListener(final OnInfoWindowLongClickListener listener) {
        if (isGoogle())
            googleMap.setOnInfoWindowLongClickListener(new GoogleMap.OnInfoWindowLongClickListener() {
                @Override
                public void onInfoWindowLongClick(com.google.android.gms.maps.model.Marker marker) {
                    listener.onInfoWindowLongClick(new Marker(marker, null));
                }
            });

        if (isHuawei())
            huaweiMap.setOnInfoWindowLongClickListener(new HuaweiMap.OnInfoWindowLongClickListener() {
                @Override
                public void onInfoWindowLongClick(com.huawei.hms.maps.model.Marker marker) {
                    listener.onInfoWindowLongClick(new Marker(null, marker));
                }
            });
    }

    public void setOnMapLoadedCallback(final OnMapLoadedCallback listener) {
        if (isGoogle()) {
            googleMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
                @Override
                public void onMapLoaded() {
                    listener.onMapLoaded();
                }
            });
        }
        if (isHuawei()) {
            huaweiMap.setOnMapLoadedCallback(new HuaweiMap.OnMapLoadedCallback() {
                @Override
                public void onMapLoaded() {
                    listener.onMapLoaded();
                }
            });
        }
    }

    public void setOnMyLocationButtonClickListener(final OnMyLocationButtonClickListener listener) {
        if (isGoogle()) {
            googleMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
                @Override
                public boolean onMyLocationButtonClick() {
                    return listener.onMyLocationButtonClick();
                }
            });
        }
        if (isHuawei()) {
            huaweiMap.setOnMyLocationButtonClickListener(new HuaweiMap.OnMyLocationButtonClickListener() {
                @Override
                public boolean onMyLocationButtonClick() {
                    return listener.onMyLocationButtonClick();
                }
            });
        }
    }

    public void setLatLngBoundsForCameraTarget(LatLngBounds values) {
        if (values != null) {
            if (isGoogle()) googleMap.setLatLngBoundsForCameraTarget(values.google);
            if (isHuawei()) huaweiMap.setLatLngBoundsForCameraTarget(values.huawei);
        }
    }

    public IndoorBuilding getFocusedBuilding() {
        if (isGoogle()) return new IndoorBuilding(googleMap.getFocusedBuilding(), null);
        if (isHuawei()) return new IndoorBuilding(null, huaweiMap.getFocusedBuilding());
        return new IndoorBuilding(null, null);
    }


    public void setLocationSource(final LocationSource locationSource) {
        if (isGoogle()) {
            final com.google.android.gms.maps.LocationSource google = new com.google.android.gms.maps.LocationSource() {
                @Override
                public void activate(final OnLocationChangedListener onLocationChangedListener) {
                    final LocationSource.OnLocationChangedListener listener = new LocationSource.OnLocationChangedListener() {
                        @Override
                        public void onLocationChanged(Location location) {
                            onLocationChangedListener.onLocationChanged(location);
                        }
                    };
                    locationSource.activate(listener);
                }

                @Override
                public void deactivate() {
                    locationSource.deactivate();
                }
            };
            googleMap.setLocationSource(google);
        } else if (isHuawei()) {
            com.huawei.hms.maps.LocationSource huawei = new com.huawei.hms.maps.LocationSource() {
                @Override
                public void activate(final OnLocationChangedListener onLocationChangedListener) {
                    final LocationSource.OnLocationChangedListener listener = new LocationSource.OnLocationChangedListener() {
                        @Override
                        public void onLocationChanged(Location location) {
                            onLocationChangedListener.onLocationChanged(location);
                        }
                    };
                    locationSource.activate(listener);
                }

                @Override
                public void deactivate() {
                    locationSource.deactivate();
                }
            };
            huaweiMap.setLocationSource(huawei);
        }
    }


    public TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) {
        if (isGoogle()) {
            return new TileOverlay(googleMap.addTileOverlay(tileOverlayOptions.google), null);
        }
        if (isHuawei()) {
            return new TileOverlay(null, huaweiMap.addTileOverlay(tileOverlayOptions.huawei));
        }
        return new TileOverlay(null, null);
    }
}
