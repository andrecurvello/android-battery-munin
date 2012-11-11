package net.evalentin.batterygraph;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.util.Log;

public class BatteryReceive extends BroadcastReceiver {

	private String webService = "http://myserver.fr/webservice.php?value=";
	
	@Override
	public void onReceive(Context context, Intent i) {
		
		Context c = context.getApplicationContext();
		Intent intent = c.registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
		
		int battery = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
		//Log.d("BAT", battery+"");
		
		if(intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED)) {
			
			try {
				WriteServer task = new WriteServer();
				task.execute(webService+battery);
			}
			catch(Exception e) {
				Log.d("error",e.toString());
			}

		}
	}
}
