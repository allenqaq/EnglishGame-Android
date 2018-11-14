package com.example.englishgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ReadList extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.readlist);
	}
	
	public void OnRead1(View v) 
	{
		Intent intent = new Intent();
    	intent.setClass(ReadList.this, read1.class);
    	intent.putExtra("Read1","1");
    	startActivity(intent);
    	finish();
	}
	public void OnRead2(View v) 
	{
		Intent intent = new Intent();
    	intent.setClass(ReadList.this, read1.class);
    	intent.putExtra("Read1","1");
    	startActivity(intent);
    	finish();
	}
	public void OnRead3(View v) 
	{
		Intent intent = new Intent();
    	intent.setClass(ReadList.this, read1.class);
    	intent.putExtra("Read1","1");
    	startActivity(intent);
    	finish();
	}
}
