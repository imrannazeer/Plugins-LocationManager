package com.sysvine.locationmanager;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;

public class LocationManager extends CordovaPlugin {


	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if ("gpsAlert".equals(action)) {
			try {				
				System.out.println("**********************Native function is called**************************");
				AlertDialog.Builder alertDialog = new AlertDialog.Builder(this.cordova.getActivity());

				// Setting Dialog Title
				alertDialog.setTitle("GPS Settings");
				
				alertDialog.setCancelable(false);

				// Setting Dialog Message
				alertDialog.setMessage("Please enable GPS");

				// On pressing Settings button
				alertDialog.setPositiveButton("Cancel",
						new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
					}
				});

				// on pressing cancel button
				alertDialog.setNegativeButton("Settings",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
						cordova.getActivity().startActivity(intent);
						dialog.dismiss();
						}
					});

				// Showing Alert Message
				alertDialog.show();
				
			} catch (Exception e) {
				return false;
			}
			callbackContext.success();
			return true;
		}
		return false;  
	}

}