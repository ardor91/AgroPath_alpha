package com.example.p0031firstproject;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MyLocationListener implements LocationListener {

    private static final String TAG = "myLogs";
    private Context currentContext;
    private TextView gpsOut;

    public MyLocationListener(Context context, TextView gpsOut)
    {
        currentContext = context;
        this.gpsOut = gpsOut;
    }

    @Override
    public void onLocationChanged(Location location) {
        Toast.makeText(currentContext,"Location changed : Lat: " +
                        location.getLatitude()+ " Lng: " + location.getLongitude(),
                Toast.LENGTH_SHORT).show();
        String longitude = "Longitude: " +location.getLongitude();
        Log.d(TAG, longitude);
        String latitude = "Latitude: " +location.getLatitude();
        Log.d(TAG, latitude);

        gpsOut.setText(gpsOut.getText() + "\nLONG: " + longitude + "; LAT: " + latitude);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        gpsOut.setText(gpsOut.getText() + "\nGPS PROVIDER STATUS CHANGED!");
    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
