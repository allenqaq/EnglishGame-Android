package com.example.englishgame;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class lvl3 extends Activity
{
	private RadioGroup raGroup1;
	private RadioGroup raGroup2;
	private RadioGroup raGroup3;
	
	private int count=0;
	
	private class SOnCheckedChangeListenerR1_1lvl3 implements OnCheckedChangeListener
	{
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId)
		{
			// TODO Auto-generated method stub
			if (checkedId == R.id.LevelradioBtnR1_1lvl3)
			{
				//A
				count++;
			}
		}
	}
	
	private class SOnCheckedChangeListenerR1_2lvl3 implements OnCheckedChangeListener
	{
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId)
		{
			// TODO Auto-generated method stub
			if (checkedId == R.id.LevelradioBtnR2_1lvl3)
			{
				//A
				count++;
			}
		}
	}
	
	private class SOnCheckedChangeListenerR1_3lvl3 implements OnCheckedChangeListener
	{
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId)
		{
			// TODO Auto-generated method stub
			if (checkedId == R.id.LevelradioBtnR3_1lvl3)
			{
				//A
				count++;
			}
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lvl3);
		
		count=0;
		
		raGroup1 = (RadioGroup) findViewById(R.id.LevelradioGroupR1_1lvl3);
		raGroup1.setOnCheckedChangeListener(new SOnCheckedChangeListenerR1_1lvl3());
		
		raGroup2 = (RadioGroup) findViewById(R.id.LevelradioGroupR1_2lvl3);
		raGroup2.setOnCheckedChangeListener(new SOnCheckedChangeListenerR1_2lvl3());
		
		raGroup3 = (RadioGroup) findViewById(R.id.LevelradioGroupR1_3lvl3);
		raGroup3.setOnCheckedChangeListener(new SOnCheckedChangeListenerR1_3lvl3());	
	}

	public void OnLevelSubmitReadlvl3(View v)
	{
		if(count>=2)
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
	        editor.putInt("lv3", 1);
	        
	        editor.commit();
	        
			int i=10;
			Intent intent = new Intent();
			intent.setClass(lvl3.this, level.class);
			startActivity(intent);
			String s="���سɹ���  ��������"+i;
			Toast.makeText(lvl3.this,s, Toast.LENGTH_SHORT).show();
		}
		else
		{
			Toast.makeText(lvl3.this,"�òˣ�����ʧ�ܣ�", Toast.LENGTH_SHORT).show();
		}
		Intent intent = new Intent();
		intent.setClass(lvl3.this, level.class);
		startActivity(intent);
		finish();
	}
	
}
