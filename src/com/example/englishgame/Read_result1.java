package com.example.englishgame;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Read_result1 extends Activity
{
	private TextView t;
	private int i=0;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.read_result1);
		
		t = (TextView) findViewById(R.id.r1_result);

		SharedPreferences sp = this.getSharedPreferences("save",MODE_PRIVATE); 
		
		String s=" 您的答案：  1."+sp.getString("R1_1", "")+"  2."+sp.getString("R1_2", "")+"  3."+sp.getString("R1_3", "");
		
	
		Editor editor = sp.edit();
		//DataDeal datadeal = new DataDeal();
		
		i=0;
		if(sp.getString("R1_1", "")=="C")
		{
			i=i+10;
			//datadeal.setread_correct(1);
			int i1 = sp.getInt("read_done",0);
			i1=i1+1;
	        editor.putInt("read_correct", i1);
		}
		if(sp.getString("R1_2", "")=="B")
		{
			i=i+10;
			//datadeal.setread_correct(1);
			int i1 = sp.getInt("read_done",0);
			i1=i1+1;
	        editor.putInt("read_correct", i1);
		}
		if(sp.getString("R1_3", "")=="D")
		{
			i=i+10;
			//datadeal.setread_correct(1);
			int i1 = sp.getInt("read_done",0);
			i1=i1+1;
	        editor.putInt("read_correct", i1);
		}
		i=i+30;
		int ii=0;
		
		//datadeal.setPoints(i);
		ii = sp.getInt("points",0);
		ii=ii+i;
        editor.putInt("points", ii);
      
		//datadeal.setRank(i);
        editor.putInt("rank", ii);
        
		//datadeal.setread_done(3);
        ii = sp.getInt("read_done",0);
		ii=ii+3;
        editor.putInt("read_done", ii);
		
		editor.commit();
		//s="\n听力总结："+String.valueOf(sp.getInt("read_correct", ""))+"%"+String.valueOf(datadeal.getread_done());
		
		s=s+"\n"+"听力总结"+sp.getInt("read_correct", 0)+"%"+sp.getInt("read_done", 0);
		
		t.setText(s);
	}
	
	
	
	public void OnBackRead(View v)
	{
		Intent intent = new Intent();
		intent.setClass(Read_result1.this, MainActivity.class);
		startActivity(intent);
		String s="经验增加"+i;
		Toast.makeText(Read_result1.this,s, Toast.LENGTH_SHORT).show();
		finish();
	}
}
