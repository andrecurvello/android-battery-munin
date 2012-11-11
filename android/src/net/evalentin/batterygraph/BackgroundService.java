package net.evalentin.batterygraph;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class BackgroundService extends Service {

	private int refreshTimeMin = 20;
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
		
		 Calendar cal = Calendar.getInstance();
		 
		 Intent intentAlarm = new Intent(getApplicationContext(), BatteryReceive.class);
		 PendingIntent sender = PendingIntent.getBroadcast(this, 192837, intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT);
		 
		 AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
		 am.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), refreshTimeMin*1000*60, sender);
	}
}
