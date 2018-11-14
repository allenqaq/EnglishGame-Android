package com.example.englishgame;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.service.notification.NotificationListenerService.Ranking;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class Show extends Activity
{
	private int showpoint=0;
	private int showrank=0;
	
	private int showLC=0;
	private int showLD=0;
	private int showRC=0;
	private int showRD=0;
	private int showAC=0;
	private int showAD=0;
	
	private int showxz1=0;
	private int showxz2=0;
	private int showxz3=0;
	private int showxz4=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show);
		
		ImageView RANK= (ImageView) findViewById(R.id.showrank);
		TextView showTT=(TextView)findViewById(R.id.showtt);
		ProgressBar seekbar=(ProgressBar)findViewById(R.id.showseekbar);
		TextView showPT=(TextView)findViewById(R.id.showpoints);
		TextView showDone=(TextView)findViewById(R.id.showdone);
		TextView showDone1=(TextView)findViewById(R.id.showdone1);
		TextView showDone2=(TextView)findViewById(R.id.showdone2);
		ImageView XZ1= (ImageView) findViewById(R.id.showxz1);
		ImageView XZ2= (ImageView) findViewById(R.id.showxz2);
		ImageView XZ3= (ImageView) findViewById(R.id.showxz3);
		ImageView XZ4= (ImageView) findViewById(R.id.showxz4);
		
		SharedPreferences Sa =getSharedPreferences("save", MODE_PRIVATE);
		
		showpoint=Sa.getInt("points",0);
		showrank=Sa.getInt("rank",0);
		
		showLC=Sa.getInt("lis_correct",0);
		showLD=Sa.getInt("lis_done",0);
		showRC=Sa.getInt("read_correct",0);
		showRD=Sa.getInt("read_done",0);
		showAC=showLC+showRC;
		showAD=showLD+showRD;
		
		showxz1=Sa.getInt("xz1",0);
		showxz2=Sa.getInt("xz2",0);
		showxz3=Sa.getInt("xz3",0);
		showxz4=Sa.getInt("xz4",0);
		
		if(showrank<=200)
		{
			RANK.setImageResource(R.drawable.lpc1);
			RANK.setLayoutParams(new LinearLayout.LayoutParams(150,150));
			showTT.setText("\nLEVEL:1  练体期\n");
			int i=0;
			i=showrank;
			seekbar.setProgress(i);
		}
		else if(showrank<=400)
		{
			RANK.setImageResource(R.drawable.lpc2);
			showTT.setText("\nLEVEL:1  金丹期\n");
			int i=0;
			i=showrank-200;
			seekbar.setProgress(i);
		}
		else if(showrank<=600)
		{
			RANK.setImageResource(R.drawable.lpc3);
			showTT.setText("\nLEVEL:1  元婴期\n");
			int i=0;
			i=showrank-400;
			seekbar.setProgress(i);
		}
		else 
		{
			RANK.setImageResource(R.drawable.lpc4);
			showTT.setText("\nLEVEL:1  入神期\n");
			seekbar.setProgress(200);
		}
		
		String PT="当前经验：  "+showrank+"\n\n您的积分：  "+showpoint+"\n\n";
		showPT.setText(PT);
		
		String s="\n\n听力总结：  "+showLC+" % "+showLD+"\n\n";
		showDone.setText(s);
		
		String s1="\n\n阅读总结：  "+showRC+" % "+showRD+"\n\n";
		showDone1.setText(s1);
		
		String s2="\n\n做题总结：  "+showAC+" % "+showAD+"\n\n";
		showDone2.setText(s2);
		
		if(showxz1==1)
		{
			XZ1.setImageResource(R.drawable.xz1);
			XZ1.setLayoutParams(new LinearLayout.LayoutParams(100,100));
		}
		if(showxz2==1)
		{
			XZ2.setImageResource(R.drawable.xz2);
			XZ2.setLayoutParams(new LinearLayout.LayoutParams(100,100));
		}
		if(showxz3==1)
		{
			XZ3.setImageResource(R.drawable.xz3);
			XZ3.setLayoutParams(new LinearLayout.LayoutParams(100,100));
		}
		if(showxz4==1)
		{
			XZ4.setImageResource(R.drawable.xz4);
			XZ4.setLayoutParams(new LinearLayout.LayoutParams(100,100));
		}
	}
	
	public void OnShowBack(View v)
	{
		Intent intent = new Intent();
		intent.setClass(Show.this, MainActivity.class);
		// intent.putExtra("BtnS","2");
		startActivity(intent);
		finish();
	}
}
