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

public class level1 extends Activity
{
	private RadioGroup raGroup1;
	private RadioGroup raGroup2;
	private RadioGroup raGroup3;
	
	private int count=0;
	
	private class SOnCheckedChangeListenerR1_1 implements OnCheckedChangeListener
	{
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId)
		{
			// TODO Auto-generated method stub
			if (checkedId == R.id.LevelradioBtnR1_1)
			{
				//A
				count++;
			}
		}
	}
	
	private class SOnCheckedChangeListenerR1_2 implements OnCheckedChangeListener
	{
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId)
		{
			// TODO Auto-generated method stub
			if (checkedId == R.id.LevelradioBtnR2_2)
			{
				//B
				count++;
			}
		}
	}
	
	private class SOnCheckedChangeListenerR1_3 implements OnCheckedChangeListener
	{
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId)
		{
			// TODO Auto-generated method stub
			if (checkedId == R.id.LevelradioBtnR3_4)
			{
				//D
				count++;
			}
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.level_1);
		
		count=0;
		
		raGroup1 = (RadioGroup) findViewById(R.id.LevelradioGroupR1_1);
		raGroup1.setOnCheckedChangeListener(new SOnCheckedChangeListenerR1_1());
		
		raGroup2 = (RadioGroup) findViewById(R.id.LevelradioGroupR1_2);
		raGroup2.setOnCheckedChangeListener(new SOnCheckedChangeListenerR1_2());
		
		raGroup3 = (RadioGroup) findViewById(R.id.LevelradioGroupR1_3);
		raGroup3.setOnCheckedChangeListener(new SOnCheckedChangeListenerR1_3());	
	}

	public void OnLevelSubmitRead(View v)
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
	        editor.putInt("lv1", 1);
	        
	        editor.commit();
	        
			int i=10;
			Intent intent = new Intent();
			intent.setClass(level1.this, level.class);
			startActivity(intent);
			String s="闯关成功！  经验增加"+i;
			Toast.makeText(level1.this,s, Toast.LENGTH_SHORT).show();
		}
		else
		{
			Toast.makeText(level1.this,"好菜，闯关失败！", Toast.LENGTH_SHORT).show();
		}
		Intent intent = new Intent();
		intent.setClass(level1.this, level.class);
		startActivity(intent);
		finish();
	}
	
}
