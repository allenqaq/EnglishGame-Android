package com.example.englishgame;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Write1 extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wirte1);
	}
	public void OnWrite1(View v)
	{
		SharedPreferences sp = this.getSharedPreferences("save",MODE_PRIVATE); 
		Editor editor = sp.edit();
		
		int ii=0;
		
		//datadeal.setPoints(i);
		ii = sp.getInt("points",0);
		ii=ii+10;
        editor.putInt("points", ii);
  
		//datadeal.setRank(i);
        editor.putInt("rank", ii);
		editor.commit();
		
		int i=10;
		Intent intent = new Intent();
		intent.setClass(Write1.this, MainActivity.class);
		startActivity(intent);
		String s="经验增加"+i;
		Toast.makeText(Write1.this,s, Toast.LENGTH_SHORT).show();
		finish();
	}
}
