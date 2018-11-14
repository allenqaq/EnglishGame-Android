package com.example.englishgame;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class LisAnw1 extends Activity
{

	private RadioGroup raGroup1;
	private RadioGroup raGroup2;
	private RadioGroup raGroup3;
	
	private class SOnCheckedChangeListenerL1_1 implements OnCheckedChangeListener
	{
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId)
		{
			// TODO Auto-generated method stub
			if (checkedId == R.id.radioBtnL1_1)
			{
				//Toast.makeText(MainActivity.this, "A", Toast.LENGTH_SHORT).show();
				SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        Editor editor = Sa.edit();
		        editor.putString("L1_1","A");
		        editor.commit();
			}
			else if (checkedId == R.id.radioBtnL1_2)
			{
				//Toast.makeText(MainActivity.this, "B", Toast.LENGTH_SHORT).show();
				SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        Editor editor = Sa.edit();
		        editor.putString("L1_1","B");
		        editor.commit();
			}
			else if(checkedId == R.id.radioBtnL1_3)
			{
				//Toast.makeText(MainActivity.this, "C", Toast.LENGTH_SHORT).show();
				SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        Editor editor = Sa.edit();
		        editor.putString("L1_1","C");
		        editor.commit();
			}
			else if(checkedId == R.id.radioBtnL1_4)
			{
				//Toast.makeText(MainActivity.this, "C", Toast.LENGTH_SHORT).show();
				SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        Editor editor = Sa.edit();
		        editor.putString("L1_1","D");
		        editor.commit();
			}
		}
	}
	
	private class SOnCheckedChangeListenerL1_2 implements OnCheckedChangeListener
	{
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId)
		{
			// TODO Auto-generated method stub
			if (checkedId == R.id.radioBtnL2_1)
			{
				//Toast.makeText(MainActivity.this, "A", Toast.LENGTH_SHORT).show();
				SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        Editor editor = Sa.edit();
		        editor.putString("L1_2","A");
		        editor.commit();
			}
			else if (checkedId == R.id.radioBtnL2_2)
			{
				//Toast.makeText(MainActivity.this, "B", Toast.LENGTH_SHORT).show();
				SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        Editor editor = Sa.edit();
		        editor.putString("L1_2","B");
		        editor.commit();
			}
			else if(checkedId == R.id.radioBtnL2_3)
			{
				//Toast.makeText(MainActivity.this, "C", Toast.LENGTH_SHORT).show();
				SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        Editor editor = Sa.edit();
		        editor.putString("L1_2","C");
		        editor.commit();
			}
			else if(checkedId == R.id.radioBtnL2_4)
			{
				//Toast.makeText(MainActivity.this, "C", Toast.LENGTH_SHORT).show();
				SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        Editor editor = Sa.edit();
		        editor.putString("L1_2","D");
		        editor.commit();
			}
		}
	}
	
	private class SOnCheckedChangeListenerL1_3 implements OnCheckedChangeListener
	{
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId)
		{
			// TODO Auto-generated method stub
			if (checkedId == R.id.radioBtnL3_1)
			{
				//Toast.makeText(MainActivity.this, "A", Toast.LENGTH_SHORT).show();
				SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        Editor editor = Sa.edit();
		        editor.putString("L1_3","A");
		        editor.commit();
			}
			else if (checkedId == R.id.radioBtnL3_2)
			{
				//Toast.makeText(MainActivity.this, "B", Toast.LENGTH_SHORT).show();
				SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        Editor editor = Sa.edit();
		        editor.putString("L1_3","B");
		        editor.commit();
			}
			else if(checkedId == R.id.radioBtnL3_3)
			{
				//Toast.makeText(MainActivity.this, "C", Toast.LENGTH_SHORT).show();
				SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        Editor editor = Sa.edit();
		        editor.putString("L1_3","C");
		        editor.commit();
			}
			else if(checkedId == R.id.radioBtnL3_4)
			{
				//Toast.makeText(MainActivity.this, "C", Toast.LENGTH_SHORT).show();
				SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        Editor editor = Sa.edit();
		        editor.putString("L1_3","D");
		        editor.commit();
			}
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lisanw1);
		
		raGroup1 = (RadioGroup) findViewById(R.id.radioGroupL1_1);
		raGroup1.setOnCheckedChangeListener(new SOnCheckedChangeListenerL1_1());
		
		raGroup2 = (RadioGroup) findViewById(R.id.radioGroupL1_2);
		raGroup2.setOnCheckedChangeListener(new SOnCheckedChangeListenerL1_2());
		
		raGroup3 = (RadioGroup) findViewById(R.id.radioGroupL1_3);
		raGroup3.setOnCheckedChangeListener(new SOnCheckedChangeListenerL1_3());
	}

	public void OnSubmit(View v)
	{
		Intent intent = new Intent();
		intent.setClass(LisAnw1.this, L1_Result.class);
		startActivity(intent);
		finish();
	}
}
