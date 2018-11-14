package com.example.englishgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WritteList extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.writelist);
	}
	public void Onwrite1(View v) 
	{
		Intent intent = new Intent();
    	intent.setClass(WritteList.this, Write1.class);
    	intent.putExtra("write","1");
    	startActivity(intent);
    	finish();
	}
	public void Onwrite2(View v) 
	{
		Intent intent = new Intent();
    	intent.setClass(WritteList.this, Write1.class);
    	intent.putExtra("write","1");
    	startActivity(intent);
    	finish();
	}
	public void Onwrite3(View v) 
	{
		Intent intent = new Intent();
    	intent.setClass(WritteList.this, Write1.class);
    	intent.putExtra("write","1");
    	startActivity(intent);
    	finish();
	}
}
