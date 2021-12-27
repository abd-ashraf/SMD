package com.example.smdlab._13_a_SensorsExample;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.smdlab.R;

public class SensorMainActivity extends AppCompatActivity implements SensorEventListener {
    SensorManager sensorManager;
    boolean color = false;
    View v;
    long lastTimeUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        lastTimeUpdate = System.currentTimeMillis();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            getMyAccelerometerValue(event);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void getMyAccelerometerValue(SensorEvent Event) {
        float[] values = Event.values;
        float x = values[0];
        float y = values[1];
        float z = values[2];
        float acceleration = (x*x + y*y + z*z) / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
        long actualTime = Event.timestamp;

        if (acceleration >= 2) {
            if (actualTime - lastTimeUpdate < 150) {
                return;
            }
            lastTimeUpdate = actualTime;
            Toast.makeText(this, "Device was Shooked", Toast.LENGTH_SHORT).show();
            getWindow().getDecorView().setBackgroundColor(Color.RED);
        }
    }

    public void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

}