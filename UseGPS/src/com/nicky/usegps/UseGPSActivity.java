package com.nicky.usegps;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UseGPSActivity extends Activity{
	Location loc;

/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState)
{
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main);

/* Use the LocationManager class to obtain GPS locations */
	LocationManager mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
	LocationListener mlocListener = new MyLocationListener();
	mlocManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, mlocListener);
	
	Button gpsbutton = (Button) findViewById(R.id.button1);
	gpsbutton.setOnClickListener(new View.OnClickListener(){
		public void onClick(View view){
    		loc.getLatitude();
    		loc.getLongitude();
    		String Text = "My current location is: " + "Latitude = " + loc.getLatitude() + "Longitude = " + loc.getLongitude();
    		Toast.makeText( getApplicationContext(), Text, Toast.LENGTH_SHORT).show();
    		
    		
    		
    		
    	}

		
		});


}


/* Class My Location Listener */

public class MyLocationListener implements LocationListener

{

	@Override
	public void onLocationChanged(Location loc)

{

	loc.getLatitude();
	loc.getLongitude();
	String Text = "My current location is (2): " + "Latitude = " + loc.getLatitude() + "Longitude = " + loc.getLongitude();
	Toast.makeText( getApplicationContext(), Text, Toast.LENGTH_SHORT).show();
}


@Override
public void onProviderDisabled(String provider)

{

Toast.makeText( getApplicationContext(), "Gps Disabled", Toast.LENGTH_SHORT ).show();

}


@Override
public void onProviderEnabled(String provider)

{
	Toast.makeText( getApplicationContext(), "Gps Enabled", Toast.LENGTH_SHORT).show();

}


@Override

public void onStatusChanged(String provider, int status, Bundle extras)

{


}

}/* End of Class MyLocationListener */

}/* End of UseGps Activity */