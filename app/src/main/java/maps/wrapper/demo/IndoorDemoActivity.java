// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.


package maps.wrapper.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import maps.wrapper.CameraUpdateFactory;
import maps.wrapper.ExtendedMap;
import maps.wrapper.IndoorBuilding;
import maps.wrapper.IndoorLevel;
import maps.wrapper.LatLng;
import maps.wrapper.OnMapReadyCallback;
import maps.wrapper.SupportMapFragment;

import java.util.List;

/**
 * A demo activity showing how to use indoor.
 */
public class IndoorDemoActivity extends AppCompatActivity implements OnMapReadyCallback {

    private ExtendedMap mMap;

    private boolean showLevelPicker = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.indoor_demo);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(ExtendedMap map) {
        mMap = map;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.614631, -122.385153), 18));
    }

    /**
     * Called when the toggle level picker button is clicked.
     */
    public void onToggleLevelPicker(View view) {
        showLevelPicker = !showLevelPicker;
        mMap.getUiSettings().setIndoorLevelPickerEnabled(showLevelPicker);
    }

    /**
     * Called when the focused building info is clicked.
     */
    public void onFocusedBuildingInfo(View view) {
        IndoorBuilding building = mMap.getFocusedBuilding();
        if (building != null) {
            StringBuilder s = new StringBuilder();
            for (IndoorLevel level : building.getLevels()) {
                s.append(level.getName()).append(" ");
            }
            if (building.isUnderground()) {
                s.append("is underground");
            }
            setText(s.toString());
        } else {
            setText("No visible building");
        }
    }

    /**
     * Called when the focused level info is clicked.
     */
    public void onVisibleLevelInfo(View view) {
        IndoorBuilding building = mMap.getFocusedBuilding();
        if (building != null) {
            IndoorLevel level =
                    building.getLevels().get(building.getActiveLevelIndex());
            if (level != null) {
                setText(level.getName());
            } else {
                setText("No visible level");
            }
        } else {
            setText("No visible building");
        }
    }

    /**
     * Called when the activate higher level is clicked.
     */
    public void onHigherLevel(View view) {
        IndoorBuilding building = mMap.getFocusedBuilding();
        if (building != null) {
            List<IndoorLevel> levels = building.getLevels();
            if (!levels.isEmpty()) {
                int currentLevel = building.getActiveLevelIndex();
                // The levels are in 'display order' from top to bottom,
                // i.e. higher levels in the building are lower numbered in the array.
                int newLevel = currentLevel - 1;
                if (newLevel == -1) {
                    newLevel = levels.size() - 1;
                }
                IndoorLevel level = levels.get(newLevel);
                setText("Activiating level " + level.getName());
                level.activate();
            } else {
                setText("No levels in building");
            }
        } else {
            setText("No visible building");
        }
    }

    private void setText(String message) {
        TextView text = (TextView) findViewById(R.id.top_text);
        text.setText(message);
    }
}
