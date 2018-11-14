package com.example.englishgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SpeakList extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.speaklist);
	}

	public void OnSpeak1(View v) 
	{
		Intent intent = new Intent();
    	intent.setClass(SpeakList.this, MyMediaRecorderDemo.class);
    	intent.putExtra("Speak","1");
    	startActivity(intent);
    	finish();
	}
}
