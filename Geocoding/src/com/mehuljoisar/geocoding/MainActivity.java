package com.mehuljoisar.geocoding;

import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText etAddress;
	private Button btnGetLatLong;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		etAddress = (EditText)findViewById(R.id.etAddress);
		btnGetLatLong = (Button)findViewById(R.id.btnGetLatLong);
		
		btnGetLatLong.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Geocoder mGC = new Geocoder(MainActivity.this);
				List<Address> addressList;
				try {
					addressList = mGC.getFromLocationName(etAddress.getText().toString(), 1);
					Address address = addressList.get(0);
					if(address.hasLatitude() && address.hasLongitude()){
					    double selectedLat = address.getLatitude();
					    double selectedLng = address.getLongitude();
					    
					    Toast.makeText(MainActivity.this, selectedLat+":"+selectedLng, Toast.LENGTH_SHORT).show();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
