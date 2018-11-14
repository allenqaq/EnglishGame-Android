package com.example.englishgame;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnStudy(View v) 
	{
		Intent intent = new Intent();
    	intent.setClass(MainActivity.this, Learn.class);
    	//intent.putExtra("BtnS","2");
    	startActivity(intent);
	}
    
    public void OnLevel(View v) 
	{
		Intent intent = new Intent();
    	intent.setClass(MainActivity.this,level.class);
    	//intent.putExtra("BtnS","2");
    	startActivity(intent);
	}
    
    public void OnRank(View v) 
	{
		Intent intent = new Intent();
    	intent.setClass(MainActivity.this, Show.class);
    	//intent.putExtra("BtnS","2");
    	startActivity(intent);
	}
    
    public void OnShop(View v) 
	{
		Intent intent = new Intent();
    	intent.setClass(MainActivity.this, Shop.class);
    	//intent.putExtra("BtnS","2");
    	startActivity(intent);
	}
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
        	
        	SharedPreferences sp = this.getSharedPreferences("save",MODE_PRIVATE);
        	Editor editor = sp.edit();
        	
        	editor.putInt("xz1", 0);
        	editor.putInt("xz2", 0);
        	editor.putInt("xz3", 0);
        	editor.putInt("xz4", 0);
        	
        	//editor.putInt("rank", 0);
        	//editor.putInt("points", 0);
        	
        	//editor.putInt("lv1", 0);
        	//editor.putInt("lv2", 0);
        	//editor.putInt("lv3", 0);
        	
        	editor.commit();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
