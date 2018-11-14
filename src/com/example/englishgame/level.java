package com.example.englishgame;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class level extends Activity
{
	private int lv1 = 0;
	private int lv2 = 0;
	private int lv3 = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.levellist);

		SharedPreferences sp = this.getSharedPreferences("save", MODE_PRIVATE);
		Editor editor = sp.edit();

		lv1 = sp.getInt("lv1", 0);
		lv2 = sp.getInt("lv2", 0);
		lv3 = sp.getInt("lv3", 0);
	}

	public void Onlevel1icon(View v)
	{
		Intent intent = new Intent();
		intent.setClass(level.this, level1.class);
		// intent.putExtra("BtnS","2");
		startActivity(intent);
		finish();
	}

	public void Onlevel2icon(View v)
	{
		if (lv1 == 1)
		{
			Intent intent = new Intent();
			intent.setClass(level.this, lvl21.class);
			intent.putExtra("BtnS","2");
			startActivity(intent);
			finish();
		}
		else
		{
			Toast.makeText(level.this,"该关未破解！", Toast.LENGTH_SHORT).show();
		}
	}

	public void Onlevel3icon(View v)
	{
		if (lv2 == 1)
		{
			Intent intent = new Intent();
			 intent.setClass(level.this, lvl3.class);
			 //intent.putExtra("BtnS","2");
			startActivity(intent);
			finish();
		}
		else
		{
			Toast.makeText(level.this,"该关未破解！", Toast.LENGTH_SHORT).show();
		}
	}

}
