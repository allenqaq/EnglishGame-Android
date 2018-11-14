package com.example.englishgame;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MyMediaRecorderDemo extends Activity {
	private ImageButton record = null; 						// 按钮信息
	private ImageButton stop = null; 						// 按钮信息
	private TextView info = null; 							// 提示信息
	private MediaRecorder mediaRecorder = null; 			// MediaRecorder对象
	private File recordAudioSaveFile = null; 				// 文件保存目录路径
	private File recordAudioSaveFileDir = null; 			// 文件保存目录
	private String recordAudioSaveFileName = null; 			// 音频文件保存名称
	private SimpleAdapter recordSimpleAdapter = null; 		// 适配器
	private ListView reclist = null; 						// 定义列表视图

	private String recDir = "mldnrec";						// 保存目录

	private boolean sdcardExists = false;					// 判断SD卡是否存在
	private boolean isRecord = false;						// 判断是否正在录音

	private List<Map<String, Object>> recordFiles = null; 	// 保存所有的List数据

	private void getRecordFiles() { 						// 取得全部录音文件
		this.recordFiles = new ArrayList<Map<String, Object>>(); // 实例化List集合
		System.out.println(this.recordAudioSaveFileDir.listFiles().length);
		if (this.sdcardExists) { 							// 如果SD卡存在
			File files[] = this.recordAudioSaveFileDir.listFiles();// 列出目录中的文件
			for (int x = 0; x < files.length; x++) {
				Map<String, Object> fileInfo = new HashMap<String, Object>();
				fileInfo.put("filename", files[x].getName());	// 增加显示内容
				this.recordFiles.add(fileInfo);				// 保存数据
			}
			this.recordSimpleAdapter = new SimpleAdapter(this,
					this.recordFiles, R.layout.recordfiles,
					new String[] { "filename" }, 
					new int[] { R.id.filename });			// 实例化适配器
			this.reclist.setAdapter(this.recordSimpleAdapter); // 定义列表视图
		}
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);				// 调用布局管理器
		this.record = (ImageButton) super.findViewById(R.id.record);	// 查找组件
		this.stop = (ImageButton) super.findViewById(R.id.stop);		// 查找组件
		this.info = (TextView) super.findViewById(R.id.info);			// 查找组件
		this.reclist = (ListView) super.findViewById(R.id.reclist); 	// 查找组件

		if (this.sdcardExists = Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) { 				// 判断SD卡是否存在
			this.recordAudioSaveFileDir = new File(Environment
					.getExternalStorageDirectory().toString()
					+ File.separator
					+ MyMediaRecorderDemo.this.recDir + File.separator); // 保存录音目录
			if (!this.recordAudioSaveFileDir.exists()) { 	// 父文件夹不存在
				this.recordAudioSaveFileDir.mkdirs(); 		// 创建新的文件夹
			}
		}

		this.getRecordFiles(); 								// 取得全部的文件列表
		this.stop.setOnClickListener(new StopOnClickListenerImpl()); // 设置单击事件
		this.record.setOnClickListener(new RecordOnClickListenerImpl()); // 设置单击事件
		this.stop.setEnabled(false); 						// 暂停钮暂时不可用
		this.reclist.setOnItemClickListener(
				new OnItemClickListenerImpl());				// 设置单击事件
	}
	private class RecordOnClickListenerImpl implements OnClickListener {
		@Override
		public void onClick(View v) {
			if (MyMediaRecorderDemo.this.sdcardExists) {		// 如果SD卡存在
				MyMediaRecorderDemo.this.recordAudioSaveFileName = 
					MyMediaRecorderDemo.this.recordAudioSaveFileDir
						.toString()
						+ File.separator
						+ "MLDNRecord_" 
						+ System.currentTimeMillis() + ".3gp"; // 文件保存名称
				MyMediaRecorderDemo.this.recordAudioSaveFile = new File(
					MyMediaRecorderDemo.this.recordAudioSaveFileName); // 取得音频文件保存路径
				MyMediaRecorderDemo.this.mediaRecorder = new MediaRecorder(); // 实例化MediaRecorder
				MyMediaRecorderDemo.this.mediaRecorder
					.setAudioSource(
							MediaRecorder.AudioSource.MIC);		// 设置录音源为MIC
				MyMediaRecorderDemo.this.mediaRecorder
					.setOutputFormat(
							MediaRecorder.OutputFormat.THREE_GPP);	// 定义输出格式
				MyMediaRecorderDemo.this.mediaRecorder
					.setAudioEncoder(
							MediaRecorder.AudioEncoder.DEFAULT);	// 定义音频编码
				MyMediaRecorderDemo.this.mediaRecorder
					.setOutputFile(MyMediaRecorderDemo.
							this.recordAudioSaveFileName); 			// 定义输出文件
				try {
					MyMediaRecorderDemo.this.mediaRecorder.prepare();// 准备录音
				} catch (Exception e) {
					e.printStackTrace();
				}
				MyMediaRecorderDemo.this.mediaRecorder.start();		// 开始录音
				MyMediaRecorderDemo.this.info.setText("正在录音中...");	// 提示信息
				MyMediaRecorderDemo.this.stop.setEnabled(true); 	// 停止按钮可用
				MyMediaRecorderDemo.this.record.setEnabled(false); 	// 录音按钮禁用
				MyMediaRecorderDemo.this.isRecord = true; 			// 正在录音
			}
		}
	}
	private class StopOnClickListenerImpl implements OnClickListener {
		@Override
		public void onClick(View v) {
			if (MyMediaRecorderDemo.this.isRecord) { 			// 已经开始录音，则停止
				MyMediaRecorderDemo.this.mediaRecorder.stop(); 	// 停止录音
				MyMediaRecorderDemo.this.mediaRecorder.release(); // 释放资源
				MyMediaRecorderDemo.this.record.setEnabled(true); // 录音按钮启用
				MyMediaRecorderDemo.this.info.setText("录音结束，文件路径为："
						+ MyMediaRecorderDemo.this.recordAudioSaveFile);

			}
			MyMediaRecorderDemo.this.getRecordFiles(); 			// 重新加载列表
		}
	}

	private class OnItemClickListenerImpl implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> adapter, View view,
				int position, long id) {							// 选项单击
			if (MyMediaRecorderDemo.this.recordSimpleAdapter.
					getItem(position) instanceof Map) {				// 判断是否是Map实例
				Map<?, ?> map = (Map<?, ?>) MyMediaRecorderDemo.this.recordSimpleAdapter
						.getItem(position);							// 取出指定位置的内容
				Uri uri = Uri.fromFile(new File(
						MyMediaRecorderDemo.this.recordAudioSaveFileDir
								.toString()
								+ File.separator
								+ map.get("filename")));			// 定义操作的Uri
				Intent intent = new Intent(Intent.ACTION_VIEW);		// 指定Action
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);		// 增加标记
				intent.setDataAndType(uri, "audio/mp3");			// 设置数据播放的MIME
				MyMediaRecorderDemo.this.startActivity(intent);		// 启动Activity
			}
		}
	}
	public void OnBackSpeak(View v)
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
        editor.commit();
		int i=10;
		Intent intent = new Intent();
		intent.setClass(MyMediaRecorderDemo.this, MainActivity.class);
		startActivity(intent);
		String s="经验增加"+i;
		Toast.makeText(MyMediaRecorderDemo.this,s, Toast.LENGTH_SHORT).show();
		finish();
	}
}