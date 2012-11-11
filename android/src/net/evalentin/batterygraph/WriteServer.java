package net.evalentin.batterygraph;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.util.Log;


public class WriteServer extends AsyncTask<String, Void, Void> {

	protected Void doInBackground(String... urls) {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(urls[0]);
		HttpResponse response;
		try {
			response = httpclient.execute(httpget);
		} catch (ClientProtocolException e) {
			Log.d("ERR",e.toString());
		} catch (IOException e) {
			Log.d("ERR",e.toString());
		}
		
		return null;
	}
}
