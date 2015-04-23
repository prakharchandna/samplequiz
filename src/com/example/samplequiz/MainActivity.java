package com.example.samplequiz;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import android.support.v7.app.ActionBarActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	
	String url="http://www.androidbegin.com";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}
	
	public void goquiz(View v)
	{
		new quiz().execute();
	}
		
	private class quiz extends AsyncTask<Void,Void,Void>
	{ String quizt;
     
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			try {
				Document document = Jsoup.connect(url).get();
				/*Elements quiztext=document.select("div.entry clearfix");
				quizt=quiztext.attr("strong");
				*/
				Elements description = document
						.select("meta[name=description]");
					quizt = description.attr("content");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		
		TextView tv=(TextView) findViewById(R.id.textView1);
		tv.setText(quizt);
	}
}
}