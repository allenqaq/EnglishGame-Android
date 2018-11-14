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
	private ImageButton record = null; 						// ��ť��Ϣ
	private ImageButton stop = null; 						// ��ť��Ϣ
	private TextView info = null; 							// ��ʾ��Ϣ
	private MediaRecorder mediaRecorder = null; 			// MediaRecorder����
	private File recordAudioSaveFile = null; 				// �ļ�����Ŀ¼·��
	private File recordAudioSaveFileDir = null; 			// �ļ�����Ŀ¼
	private String recordAudioSaveFileName = null; 			// ��Ƶ�ļ���������
	private SimpleAdapter recordSimpleAdapter = null; 		// ������
	private ListView reclist = null; 						// �����б���ͼ

	private String recDir = "mldnrec";						// ����Ŀ¼

	private boolean sdcardExists = false;					// �ж�SD���Ƿ����
	private boolean isRecord = false;						// �ж��Ƿ�����¼��

	private List<Map<String, Object>> recordFiles = null; 	// �������е�List����

	private void getRecordFiles() { 						// ȡ��ȫ��¼���ļ�
		this.recordFiles = new ArrayList<Map<String, Object>>(); // ʵ����List����
		System.out.println(this.recordAudioSaveFileDir.listFiles().length);
		if (this.sdcardExists) { 							// ���SD������
			File files[] = this.recordAudioSaveFileDir.listFiles();// �г�Ŀ¼�е��ļ�
			for (int x = 0; x < files.length; x++) {
				Map<String, Object> fileInfo = new HashMap<String, Object>();
				fileInfo.put("filename", files[x].getName());	// ������ʾ����
				this.recordFiles.add(fileInfo);				// ��������
			}
			this.recordSimpleAdapter = new SimpleAdapter(this,
					this.recordFiles, R.layout.recordfiles,
					new String[] { "filename" }, 
					new int[] { R.id.filename });			// ʵ����������
			this.reclist.setAdapter(this.recordSimpleAdapter); // �����б���ͼ
		}
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);				// ���ò��ֹ�����
		this.record = (ImageButton) super.findViewById(R.id.record);	// �������
		this.stop = (ImageButton) super.findViewById(R.id.stop);		// �������
		this.info = (TextView) super.findViewById(R.id.info);			// �������
		this.reclist = (ListView) super.findViewById(R.id.reclist); 	// �������

		if (this.sdcardExists = Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) { 				// �ж�SD���Ƿ����
			this.recordAudioSaveFileDir = new File(Environment
					.getExternalStorageDirectory().toString()
					+ File.separator
					+ MyMediaRecorderDemo.this.recDir + File.separator); // ����¼��Ŀ¼
			if (!this.recordAudioSaveFileDir.exists()) { 	// ���ļ��в�����
				this.recordAudioSaveFileDir.mkdirs(); 		// �����µ��ļ���
			}
		}

		this.getRecordFiles(); 								// ȡ��ȫ�����ļ��б�
		this.stop.setOnClickListener(new StopOnClickListenerImpl()); // ���õ����¼�
		this.record.setOnClickListener(new RecordOnClickListenerImpl()); // ���õ����¼�
		this.stop.setEnabled(false); 						// ��ͣť��ʱ������
		this.reclist.setOnItemClickListener(
				new OnItemClickListenerImpl());				// ���õ����¼�
	}
	private class RecordOnClickListenerImpl implements OnClickListener {
		@Override
		public void onClick(View v) {
			if (MyMediaRecorderDemo.this.sdcardExists) {		// ���SD������
				MyMediaRecorderDemo.this.recordAudioSaveFileName = 
					MyMediaRecorderDemo.this.recordAudioSaveFileDir
						.toString()
						+ File.separator
						+ "MLDNRecord_" 
						+ System.currentTimeMillis() + ".3gp"; // �ļ���������
				MyMediaRecorderDemo.this.recordAudioSaveFile = new File(
					MyMediaRecorderDemo.this.recordAudioSaveFileName); // ȡ����Ƶ�ļ�����·��
				MyMediaRecorderDemo.this.mediaRecorder = new MediaRecorder(); // ʵ����MediaRecorder
				MyMediaRecorderDemo.this.mediaRecorder
					.setAudioSource(
							MediaRecorder.AudioSource.MIC);		// ����¼��ԴΪMIC
				MyMediaRecorderDemo.this.mediaRecorder
					.setOutputFormat(
							MediaRecorder.OutputFormat.THREE_GPP);	// ���������ʽ
				MyMediaRecorderDemo.this.mediaRecorder
					.setAudioEncoder(
							MediaRecorder.AudioEncoder.DEFAULT);	// ������Ƶ����
				MyMediaRecorderDemo.this.mediaRecorder
					.setOutputFile(MyMediaRecorderDemo.
							this.recordAudioSaveFileName); 			// ��������ļ�
				try {
					MyMediaRecorderDemo.this.mediaRecorder.prepare();// ׼��¼��
				} catch (Exception e) {
					e.printStackTrace();
				}
				MyMediaRecorderDemo.this.mediaRecorder.start();		// ��ʼ¼��
				MyMediaRecorderDemo.this.info.setText("����¼����...");	// ��ʾ��Ϣ
				MyMediaRecorderDemo.this.stop.setEnabled(true); 	// ֹͣ��ť����
				MyMediaRecorderDemo.this.record.setEnabled(false); 	// ¼����ť����
				MyMediaRecorderDemo.this.isRecord = true; 			// ����¼��
			}
		}
	}
	private class StopOnClickListenerImpl implements OnClickListener {
		@Override
		public void onClick(View v) {
			if (MyMediaRecorderDemo.this.isRecord) { 			// �Ѿ���ʼ¼������ֹͣ
				MyMediaRecorderDemo.this.mediaRecorder.stop(); 	// ֹͣ¼��
				MyMediaRecorderDemo.this.mediaRecorder.release(); // �ͷ���Դ
				MyMediaRecorderDemo.this.record.setEnabled(true); // ¼����ť����
				MyMediaRecorderDemo.this.info.setText("¼���������ļ�·��Ϊ��"
						+ MyMediaRecorderDemo.this.recordAudioSaveFile);

			}
			MyMediaRecorderDemo.this.getRecordFiles(); 			// ���¼����б�
		}
	}

	private class OnItemClickListenerImpl implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> adapter, View view,
				int position, long id) {							// ѡ���
			if (MyMediaRecorderDemo.this.recordSimpleAdapter.
					getItem(position) instanceof Map) {				// �ж��Ƿ���Mapʵ��
				Map<?, ?> map = (Map<?, ?>) MyMediaRecorderDemo.this.recordSimpleAdapter
						.getItem(position);							// ȡ��ָ��λ�õ�����
				Uri uri = Uri.fromFile(new File(
						MyMediaRecorderDemo.this.recordAudioSaveFileDir
								.toString()
								+ File.separator
								+ map.get("filename")));			// ���������Uri
				Intent intent = new Intent(Intent.ACTION_VIEW);		// ָ��Action
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);		// ���ӱ��
				intent.setDataAndType(uri, "audio/mp3");			// �������ݲ��ŵ�MIME
				MyMediaRecorderDemo.this.startActivity(intent);		// ����Activity
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
		String s="��������"+i;
		Toast.makeText(MyMediaRecorderDemo.this,s, Toast.LENGTH_SHORT).show();
		finish();
	}
}