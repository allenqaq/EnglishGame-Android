package com.example.englishgame;


import java.io.IOException;




import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.SeekBar;

public class Listen1 extends Activity
{

	private MediaPlayer mp;
	 
	private SeekBar sBar ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listen1_l);
		sBar = (SeekBar)findViewById(R.id.seekbar); 
		
		SharedPreferences sp = this.getSharedPreferences("save",MODE_PRIVATE); 
		
		Intent intent=getIntent();

		mp = new MediaPlayer();
		
		AssetManager am = Listen1.this.getAssets();
		AssetFileDescriptor afd;
		
	    switch (intent.getStringExtra("BtnS"))
	    {
	    case "1":
	    	try
			{
				afd = am.openFd("listening_passage1_1.mp3");
				mp.reset();
				mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(), afd.getLength());
				mp.prepare();
				mp.start();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      break;
	    case "2":
	    	try
			{
				afd = am.openFd("asd.mp3");
				mp.reset();
				mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(), afd.getLength());
				mp.prepare();
				mp.start();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      break;
	    default:
	      break;
	    }
	   
	    DelayThread dThread = new DelayThread(10);  
	    dThread.start();  
	}

	private Handler mHandle = new Handler(){
    	@Override
    	public void handleMessage(Message msg){
    		int position = mp.getCurrentPosition();
    		
    		int mMax = mp.getDuration();
    		int sMax = sBar.getMax();
    		
    		sBar.setProgress(position*sMax/mMax);
    	}
    };

    public class DelayThread extends Thread {
    	int milliseconds;
    	
    	public DelayThread(int i){
    		milliseconds = i;
    	}
    	public void run() {
    		while(true){
    			try {
					sleep(milliseconds);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				mHandle.sendEmptyMessage(0);
    		}
    	}
    }
    
    public void OnNext1(View v) 
	{
		Intent intent = new Intent();
    	intent.setClass(Listen1.this, LisAnw1.class);
    	//intent.putExtra("BtnS","2");
    	startActivity(intent);
    	mp.stop();
    	finish();
	}
}
