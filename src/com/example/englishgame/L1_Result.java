package com.example.englishgame;


import android.R.integer;
import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class L1_Result extends Activity
{
	private TextView t;
	private int i=0;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.l1_result);
		
		t = (TextView) findViewById(R.id.l1_result);

		SharedPreferences sp = this.getSharedPreferences("save",MODE_PRIVATE); 
		
		String s=" 您的答案：  1."+sp.getString("L1_1", "")+"  2."+sp.getString("L1_2", "")+"  3."+sp.getString("L1_3", "");
		
	
		Editor editor = sp.edit();
		//DataDeal datadeal = new DataDeal();
		
		i=0;
		if(sp.getString("L1_1", "")=="A")
		{
			i=i+10;
			//datadeal.setLis_correct(1);
			int i1 = sp.getInt("lis_correct",0);
			i1=i1+1;
	        editor.putInt("lis_correct", i1);
		}
		if(sp.getString("L1_2", "")=="B")
		{
			i=i+10;
			//datadeal.setLis_correct(1);
			int i1 = sp.getInt("lis_correct",0);
			i1=i1+1;
	        editor.putInt("lis_correct", i1);
		}
		if(sp.getString("L1_3", "")=="A")
		{
			i=i+10;
			//datadeal.setLis_correct(1);
			int i1 = sp.getInt("lis_correct",0);
			i1=i1+1;
	        editor.putInt("lis_correct", i1);
		}
		i=i+30;
		int ii=0;
		
		//datadeal.setPoints(i);
		ii = sp.getInt("points",0);
		ii=ii+i;
        editor.putInt("points", ii);
      
		//datadeal.setRank(i);
        editor.putInt("rank", ii);
        
		//datadeal.setLis_done(3);
        ii = sp.getInt("lis_done",0);
		ii=ii+3;
        editor.putInt("lis_done", ii);
		
		editor.commit();
		//s="\n听力总结："+String.valueOf(sp.getInt("lis_correct", ""))+"%"+String.valueOf(datadeal.getLis_done());
		
		s=s+"\n"+"听力总结"+sp.getInt("lis_correct", 0)+"%"+sp.getInt("lis_done", 0);
		
		t.setText(s);
	}
	public void OnBack(View v)
	{
		Intent intent = new Intent();
		intent.setClass(L1_Result.this, MainActivity.class);
		startActivity(intent);
		String s="经验增加"+i;
		Toast.makeText(L1_Result.this,s, Toast.LENGTH_SHORT).show();
		finish();
	}
}
