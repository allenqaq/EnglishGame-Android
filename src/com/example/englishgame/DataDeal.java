package com.example.englishgame;

import android.app.Activity;
import android.R.integer;
import android.R.string;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class DataDeal extends Activity
{
	private int points=0;
	private int rank=0;
	private string tittle;
	private int lis_done=0;
	private int lis_correct=0;
	private int read_done=0;
	private int read_correct=0;
	
	private int level1=0;
	private int level2=0;
	private int level3=0;
	
	private Boolean XZ1;
	private Boolean XZ2;
	private Boolean XZ3;
	private Boolean XZ4;
	
	public void init()
	{	
		SharedPreferences Sa = getSharedPreferences("save", MODE_PRIVATE);
        Editor editor = Sa.edit();
        
        editor.putInt("points", 0);
        editor.putInt("rank", 0);
        editor.putInt("lis_done", 0);
        editor.putInt("lis_correct", 0);
        editor.putInt("read_done", 0);
        editor.putInt("read_correct", 0);
        editor.putString("tittle", "");
        
        editor.putBoolean("XZ1", false);
        editor.putBoolean("XZ2", false);
        editor.putBoolean("XZ2", false);
        editor.putBoolean("XZ2", false);
        
        editor.commit();
	}

	public int getPoints()
	{
		SharedPreferences sp = this.getSharedPreferences("save",MODE_PRIVATE);  
		int i = sp.getInt("points",0);
		return i;
	}

	public void setPoints(int points)
	{
		SharedPreferences sp = this.getSharedPreferences("save",MODE_PRIVATE);
		int i = sp.getInt("points",0);
		i=i+points;
		Editor editor = sp.edit();
        editor.putInt("points", i);
        editor.commit();
	}

	public int getRank()
	{
		SharedPreferences sp = this.getSharedPreferences("save",MODE_PRIVATE);  
		int i = sp.getInt("rank",0);
		return i;
	}

	public void setRank(int rank)
	{
		SharedPreferences sp = this.getSharedPreferences("save",MODE_PRIVATE);
		int i = sp.getInt("rank",0);
		i=i+points;
		Editor editor = sp.edit();
        editor.putInt("rank", i);
        editor.commit();
	}

	public string getTittle()
	{
		return tittle;
	}

	public void setTittle(string tittle)
	{
		this.tittle = tittle;
	}

	public int getLis_done()
	{
		SharedPreferences sp = this.getSharedPreferences("save",MODE_PRIVATE);  
		int i = sp.getInt("lis_done",0);
		return i;
	}

	public void setLis_done(int lis_done)
	{
		SharedPreferences sp = this.getSharedPreferences("save",MODE_PRIVATE);
		Editor editor = sp.edit();
		int i = sp.getInt("lis_done",0);
		i=i+points;
        editor.putInt("lis_done", i);
        editor.commit();
	}

	public int getLis_correct()
	{
		SharedPreferences sp = this.getSharedPreferences("save",MODE_PRIVATE);  
		int i = sp.getInt("lis_correct",0);
		return i;
	}

	public void setLis_correct(int lis_correct)
	{
		SharedPreferences sp = this.getSharedPreferences("save",MODE_PRIVATE);
		int i = sp.getInt("lis_correct",0);
		i=i+points;
		Editor editor = sp.edit();
        editor.putInt("lis_correct", i);
        editor.commit();
	}

	public int getRead_done()
	{
		SharedPreferences sp = this.getSharedPreferences("save",MODE_PRIVATE);  
		int i = sp.getInt("read_done",0);
		return i;
	}

	public void setRead_done(int read_done)
	{
		SharedPreferences sp = this.getSharedPreferences("save",MODE_PRIVATE);
		int i = sp.getInt("read_done",0);
		i=i+points;
		Editor editor = sp.edit();
        editor.putInt("read_done", i);
        editor.commit();
	}

	public int getRead_correct()
	{
		SharedPreferences sp = this.getSharedPreferences("save",MODE_PRIVATE);  
		int i = sp.getInt("read_correct",0);
		return i;
	}

	public void setRead_correct(int read_correct)
	{
		SharedPreferences sp = this.getSharedPreferences("save",MODE_PRIVATE);
		int i = sp.getInt("read_correct",0);
		i=i+points;
		Editor editor = sp.edit();
        editor.putInt("read_correct", i);
        editor.commit();
	}

	public Boolean getXZ1()
	{
		return XZ1;
	}

	public void setXZ1(Boolean xZ1)
	{
		XZ1 = xZ1;
	}

	public Boolean getXZ2()
	{
		return XZ2;
	}

	public void setXZ2(Boolean xZ2)
	{
		XZ2 = xZ2;
	}

	public Boolean getXZ3()
	{
		return XZ3;
	}

	public void setXZ3(Boolean xZ3)
	{
		XZ3 = xZ3;
	}

	public Boolean getXZ4()
	{
		return XZ4;
	}

	public void setXZ4(Boolean xZ4)
	{
		XZ4 = xZ4;
	}
}
