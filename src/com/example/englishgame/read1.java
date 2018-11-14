package com.example.englishgame;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class read1 extends Activity
{

	private RadioGroup raGroup1;
	private RadioGroup raGroup2;
	private RadioGroup raGroup3;
	
	private class SOnCheckedChangeListenerR1_1 implements OnCheckedChangeListener
	{
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId)
		{
			// TODO Auto-generated method stub
			if (checkedId == R.id.radioBtnR1_1)
			{
				//Toast.makeText(MainActivity.this, "A", Toast.LENGTH_SHORT).show();
				SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        Editor editor = Sa.edit();
		        editor.putString("R1_1","A");
		        editor.commit();
			}
			else if (checkedId == R.id.radioBtnR1_2)
			{
				//Toast.makeText(MainActivity.this, "B", Toast.LENGTH_SHORT).show();
				SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        Editor editor = Sa.edit();
		        editor.putString("R1_1","B");
		        editor.commit();
			}
			else if(checkedId == R.id.radioBtnR1_3)
			{
				//Toast.makeText(MainActivity.this, "C", Toast.LENGTH_SHORT).show();
				SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        Editor editor = Sa.edit();
		        editor.putString("R1_1","C");
		        editor.commit();
			}
			else if(checkedId == R.id.radioBtnR1_4)
			{
				//Toast.makeText(MainActivity.this, "C", Toast.LENGTH_SHORT).show();
				SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        Editor editor = Sa.edit();
		        editor.putString("R1_1","D");
		        editor.commit();
			}
		}
	}
	
	private class SOnCheckedChangeListenerR1_2 implements OnCheckedChangeListener
	{
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId)
		{
			// TODO Auto-generated method stub
			if (checkedId == R.id.radioBtnR2_1)
			{
				//Toast.makeText(MainActivity.this, "A", Toast.LENGTH_SHORT).show();
				SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        Editor editor = Sa.edit();
		        editor.putString("R1_2","A");
		        editor.commit();
			}
			else if (checkedId == R.id.radioBtnR2_2)
			{
				//Toast.makeText(MainActivity.this, "B", Toast.LENGTH_SHORT).show();
				SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        Editor editor = Sa.edit();
		        editor.putString("R1_2","B");
		        editor.commit();
			}
			else if(checkedId == R.id.radioBtnR2_3)
			{
				//Toast.makeText(MainActivity.this, "C", Toast.LENGTH_SHORT).show();
				SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        Editor editor = Sa.edit();
		        editor.putString("R1_2","C");
		        editor.commit();
			}
			else if(checkedId == R.id.radioBtnR2_4)
			{
				//Toast.makeText(MainActivity.this, "C", Toast.LENGTH_SHORT).show();
				SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        Editor editor = Sa.edit();
		        editor.putString("R1_2","D");
		        editor.commit();
			}
		}
	}
	
	private class SOnCheckedChangeListenerR1_3 implements OnCheckedChangeListener
	{
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId)
		{
			// TODO Auto-generated method stub
			if (checkedId == R.id.radioBtnR3_1)
			{
				//Toast.makeText(MainActivity.this, "A", Toast.LENGTH_SHORT).show();
				SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        Editor editor = Sa.edit();
		        editor.putString("R1_3","A");
		        editor.commit();
			}
			else if (checkedId == R.id.radioBtnR3_2)
			{
				//Toast.makeText(MainActivity.this, "B", Toast.LENGTH_SHORT).show();
				SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        Editor editor = Sa.edit();
		        editor.putString("R1_3","B");
		        editor.commit();
			}
			else if(checkedId == R.id.radioBtnR3_3)
			{
				//Toast.makeText(MainActivity.this, "C", Toast.LENGTH_SHORT).show();
				SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        Editor editor = Sa.edit();
		        editor.putString("R1_3","C");
		        editor.commit();
			}
			else if(checkedId == R.id.radioBtnR3_4)
			{
				//Toast.makeText(MainActivity.this, "C", Toast.LENGTH_SHORT).show();
				SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        Editor editor = Sa.edit();
		        editor.putString("R1_3","D");
		        editor.commit();
			}
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.read1);
		
		raGroup1 = (RadioGroup) findViewById(R.id.radioGroupR1_1);
		raGroup1.setOnCheckedChangeListener(new SOnCheckedChangeListenerR1_1());
		
		raGroup2 = (RadioGroup) findViewById(R.id.radioGroupR1_2);
		raGroup2.setOnCheckedChangeListener(new SOnCheckedChangeListenerR1_2());
		
		raGroup3 = (RadioGroup) findViewById(R.id.radioGroupR1_3);
		raGroup3.setOnCheckedChangeListener(new SOnCheckedChangeListenerR1_3());
		
		//Intent intent=getIntent();
	}
	
	public void OnSubmitRead(View v)
	{
		Intent intent = new Intent();
		intent.setClass(read1.this, Read_result1.class);
		startActivity(intent);
		finish();
	}
}
