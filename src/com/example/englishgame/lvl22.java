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

public class lvl22 extends Activity
{

	private RadioGroup raGroup1;
	private RadioGroup raGroup2;
	private RadioGroup raGroup3;
	private int count=0;
	
	private class SOnCheckedChangeListenerL1_1lvl22 implements OnCheckedChangeListener
	{
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId)
		{
			// TODO Auto-generated method stub
			if (checkedId == R.id.radioBtnL1_1lvl22)
			{
				count++;
				//Toast.makeText(MainActivity.this, "A", Toast.LENGTH_SHORT).show();
				//SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        //Editor editor = Sa.edit();
		        //editor.putString("L1_1","A");
		        //editor.commit();
			}
			else if (checkedId == R.id.radioBtnL1_2lvl22)
			{
				//Toast.makeText(MainActivity.this, "B", Toast.LENGTH_SHORT).show();
				//SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        //Editor editor = Sa.edit();
		        //editor.putString("L1_1","B");
		        //editor.commit();
			}
			else if(checkedId == R.id.radioBtnL1_3lvl22)
			{
				//Toast.makeText(MainActivity.this, "C", Toast.LENGTH_SHORT).show();
				//SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        //Editor editor = Sa.edit();
		        //editor.putString("L1_1","C");
		        //editor.commit();
			}
			else if(checkedId == R.id.radioBtnL1_4lvl22)
			{
				//Toast.makeText(MainActivity.this, "C", Toast.LENGTH_SHORT).show();
				//SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        //Editor editor = Sa.edit();
		        //editor.putString("L1_1","D");
		        //editor.commit();
			}
		}
	}
	
	private class SOnCheckedChangeListenerL1_2lvl22 implements OnCheckedChangeListener
	{
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId)
		{
			// TODO Auto-generated method stub
			if (checkedId == R.id.radioBtnL2_1lvl22)
			{
				count++;
				//Toast.makeText(MainActivity.this, "A", Toast.LENGTH_SHORT).show();
				//SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        //Editor editor = Sa.edit();
		        //editor.putString("L1_2","A");
		        //editor.commit();
			}
			else if (checkedId == R.id.radioBtnL2_2lvl22)
			{
				//Toast.makeText(MainActivity.this, "B", Toast.LENGTH_SHORT).show();
				//SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        //Editor editor = Sa.edit();
		        //editor.putString("L1_2","B");
		        //editor.commit();
			}
			else if(checkedId == R.id.radioBtnL2_3lvl22)
			{
				//Toast.makeText(MainActivity.this, "C", Toast.LENGTH_SHORT).show();
				//SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		       // Editor editor = Sa.edit();
		        //editor.putString("L1_2","C");
		        //editor.commit();
			}
			else if(checkedId == R.id.radioBtnL2_4lvl22)
			{
				//Toast.makeText(MainActivity.this, "C", Toast.LENGTH_SHORT).show();
				//SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        //Editor editor = Sa.edit();
		        //editor.putString("L1_2","D");
		        //editor.commit();
			}
		}
	}
	
	private class SOnCheckedChangeListenerL1_3lvl22 implements OnCheckedChangeListener
	{
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId)
		{
			// TODO Auto-generated method stub
			if (checkedId == R.id.radioBtnL3_1lvl22)
			{
				count++;
				//Toast.makeText(MainActivity.this, "A", Toast.LENGTH_SHORT).show();
				//SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        //Editor editor = Sa.edit();
		        //editor.putString("L1_3","A");
		        //editor.commit();
			}
			else if (checkedId == R.id.radioBtnL3_2lvl22)
			{
				//Toast.makeText(MainActivity.this, "B", Toast.LENGTH_SHORT).show();
				//SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        //Editor editor = Sa.edit();
		        //editor.putString("L1_3","B");
		        //editor.commit();
			}
			else if(checkedId == R.id.radioBtnL3_3lvl22)
			{
				//Toast.makeText(MainActivity.this, "C", Toast.LENGTH_SHORT).show();
				//SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        //Editor editor = Sa.edit();
		        //editor.putString("L1_3","C");
		        //editor.commit();
			}
			else if(checkedId == R.id.radioBtnL3_4lvl22)
			{
				//Toast.makeText(MainActivity.this, "C", Toast.LENGTH_SHORT).show();
				//SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		        //Editor editor = Sa.edit();
		        //editor.putString("L1_3","D");
		        //editor.commit();
			}
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lvl22);
		count=0;
		raGroup1 = (RadioGroup) findViewById(R.id.radioGroupL1_1lvl22);
		raGroup1.setOnCheckedChangeListener(new SOnCheckedChangeListenerL1_1lvl22());
		
		raGroup2 = (RadioGroup) findViewById(R.id.radioGroupL1_2lvl22);
		raGroup2.setOnCheckedChangeListener(new SOnCheckedChangeListenerL1_2lvl22());
		
		raGroup3 = (RadioGroup) findViewById(R.id.radioGroupL1_3lvl22);
		raGroup3.setOnCheckedChangeListener(new SOnCheckedChangeListenerL1_3lvl22());
	}

	public void OnSubmitlvl22(View v)
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
	        editor.putInt("lv2", 1);
	        editor.commit();
	        
			int i=10;
			Intent intent = new Intent();
			intent.setClass(lvl22.this, level.class);
			startActivity(intent);
			String s="闯关成功！  经验增加"+i;
			Toast.makeText(lvl22.this,s, Toast.LENGTH_SHORT).show();
		}
		else
		{
			Toast.makeText(lvl22.this,"好菜，闯关失败！", Toast.LENGTH_SHORT).show();
		}
		Intent intent = new Intent();
		intent.setClass(lvl22.this, level.class);
		startActivity(intent);
		finish();
	}
}
