package net.evalentin.batterygraph;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class EmptyActivity extends Activity{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Context context = this.getApplicationContext();
		Intent intent = new Intent(context , BackgroundService.class); 
		startService(intent);
	}
}
