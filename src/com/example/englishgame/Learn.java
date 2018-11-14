package com.example.englishgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Learn extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.learn);
	}
	
	public void OnListen(View v) 
	{
		Intent intent = new Intent();
    	intent.setClass(Learn.this, ListenList.class);
    	//intent.putExtra("BtnS","2");
    	startActivity(intent);
    	finish();
	}
	
	public void OnRead(View v) 
	{
		Intent intent = new Intent();
    	intent.setClass(Learn.this, ReadList.class);
    	//intent.putExtra("BtnS","2");
    	startActivity(intent);
    	finish();
	}
	
	public void OnSpeak(View v) 
	{
		Intent intent = new Intent();
    	intent.setClass(Learn.this, SpeakList.class);
    	//intent.putExtra("BtnS","2");
    	startActivity(intent);
    	finish();
	}
	
	public void OnWrite(View v) 
	{
		Intent intent = new Intent();
    	intent.setClass(Learn.this, WritteList.class);
    	//intent.putExtra("BtnS","2");
    	startActivity(intent);
    	finish();
	}
	
}
