package com.example.englishgame;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Shop extends Activity
{
	private TextView textview;
	private int ii;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shop);
		
		textview = (TextView)findViewById(R.id.rest);
		
		SharedPreferences sp = this.getSharedPreferences("save",MODE_PRIVATE); 
		//Editor editor = sp.edit();
		
		ii=0;
		
		//datadeal.setPoints(i);
		ii = sp.getInt("points",0);
		
		String s="\n\n您的积分为： "+ii+"\n\n";
		
		textview.setText(s);
	}

	public void OnShopxBack(View v)
	{
		Intent intent = new Intent();
		intent.setClass(Shop.this, MainActivity.class);
		// intent.putExtra("BtnS","2");
		startActivity(intent);
		finish();
	}
	
	public void OnShopBLVL(View v)
	{
		if(ii>=100)
		{
			SharedPreferences sp = this.getSharedPreferences("save",MODE_PRIVATE); 
			Editor editor = sp.edit();
			
			ii=ii-100;
			
			int getrank=sp.getInt("rank",0);
			getrank=getrank+100;
			
			editor.putInt("rank", getrank);
			editor.putInt("points", ii);
			editor.commit();
			
			Toast.makeText(Shop.this,"购买成功！\n土豪，下次再来啊！", Toast.LENGTH_SHORT).show();
		}
		else 
		{
			Toast.makeText(Shop.this,"没钱快滚！", Toast.LENGTH_SHORT).show();
		}
		Intent intent = new Intent();
		intent.setClass(Shop.this, Shop.class);
		// intent.putExtra("BtnS","2");
		startActivity(intent);
		finish();
	}
	
	public void OnShopxz1(View v)
	{
		if(ii>=100)
		{
			SharedPreferences sp = this.getSharedPreferences("save",MODE_PRIVATE); 
			Editor editor = sp.edit();
			
			ii=ii-100;
			
			editor.putInt("xz1", 1);
			editor.putInt("points", ii);
			editor.commit();
			
			Toast.makeText(Shop.this,"购买成功！\n土豪，下次再来啊！", Toast.LENGTH_SHORT).show();
		}
		else 
		{
			Toast.makeText(Shop.this,"没钱快滚！", Toast.LENGTH_SHORT).show();
		}
		Intent intent = new Intent();
		intent.setClass(Shop.this, Shop.class);
		// intent.putExtra("BtnS","2");
		startActivity(intent);
		finish();
	}
	
	public void OnShopxz2(View v)
	{
		if(ii>=100)
		{
			SharedPreferences sp = this.getSharedPreferences("save",MODE_PRIVATE); 
			Editor editor = sp.edit();
			
			ii=ii-100;
			
			editor.putInt("xz2", 1);
			editor.putInt("points", ii);
			editor.commit();
			
			Toast.makeText(Shop.this,"购买成功！\n土豪，下次再来啊！", Toast.LENGTH_SHORT).show();
		}
		else 
		{
			Toast.makeText(Shop.this,"没钱快滚！", Toast.LENGTH_SHORT).show();
		}
		Intent intent = new Intent();
		intent.setClass(Shop.this, Shop.class);
		// intent.putExtra("BtnS","2");
		startActivity(intent);
		finish();
	}
	
	public void OnShopxz3(View v)
	{
		if(ii>=100)
		{
			SharedPreferences sp = this.getSharedPreferences("save",MODE_PRIVATE); 
			Editor editor = sp.edit();
			
			ii=ii-100;
			
			editor.putInt("xz3", 1);
			editor.putInt("points", ii);
			editor.commit();
			
			Toast.makeText(Shop.this,"购买成功！\n土豪，下次再来啊！", Toast.LENGTH_SHORT).show();
		}
		else 
		{
			Toast.makeText(Shop.this,"没钱快滚！", Toast.LENGTH_SHORT).show();
		}
		Intent intent = new Intent();
		intent.setClass(Shop.this, Shop.class);
		// intent.putExtra("BtnS","2");
		startActivity(intent);
		finish();
	}
	
	public void OnShopxz4(View v)
	{
		if(ii>=100)
		{
			SharedPreferences sp = this.getSharedPreferences("save",MODE_PRIVATE); 
			Editor editor = sp.edit();
			
			ii=ii-100;
			
			editor.putInt("xz4", 1);
			editor.putInt("points", ii);
			editor.commit();
			
			Toast.makeText(Shop.this,"购买成功！\n土豪，下次再来啊！", Toast.LENGTH_SHORT).show();
		}
		else 
		{
			Toast.makeText(Shop.this,"没钱快滚！", Toast.LENGTH_SHORT).show();
		}
		Intent intent = new Intent();
		intent.setClass(Shop.this, Shop.class);
		// intent.putExtra("BtnS","2");
		startActivity(intent);
		finish();
	}
}
