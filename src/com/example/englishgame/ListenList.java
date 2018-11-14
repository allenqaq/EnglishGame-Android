package com.example.englishgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ListenList extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listenlist);
	}

    public void OnListen1(View v) 
	{
		Intent intent = new Intent();
    	intent.setClass(ListenList.this, Listen1.class);
    	intent.putExtra("BtnS","1");
    	startActivity(intent);
	}
    public void OnListen2(View v) 
	{
		Intent intent = new Intent();
    	intent.setClass(ListenList.this, Listen1.class);
    	intent.putExtra("BtnS","1");
    	startActivity(intent);
	}
    public void OnListen3(View v) 
	{
		Intent intent = new Intent();
    	intent.setClass(ListenList.this, Listen1.class);
    	intent.putExtra("BtnS","1");
    	startActivity(intent);
	}
}
