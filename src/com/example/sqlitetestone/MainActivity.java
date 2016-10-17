package com.example.sqlitetestone;

import com.example.sqlitetestone.dbSqlite.DBSQLiteHelper;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private SQLiteDatabase db;

	
    private DBSQLiteHelper dbHelper;
    private Button btnLogin,btnReset;
    private EditText etUsername,etPassword;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//SQLite���ݿ�Ĵ������ʼ��
		dbHelper=new DBSQLiteHelper(this,"aqlText.db",1);
		//�ؼ���������ע��
		initWidget();
		//�����¼�������
		addClickListener();
		
	}
private void initDbData(){
	//db.execSQL(sql);(�ʺ��ڳ�ʼ������
}
	private void initWidget(){
		btnLogin=(Button)this.findViewById(R.id.btnLogin);
		btnReset=(Button)this.findViewById(R.id.btnReset);
		
		etUsername=(EditText)this.findViewById(R.id.etUsername);
		etPassword=(EditText)this.findViewById(R.id.etPassword);
		
	}
	//�����������������¼�����ز���
	private void  addClickListener(){
		//���ڲ����������ʵ����
		btnOnClickListener btncol=new btnOnClickListener();
		//����ť�ؼ����¼�
		btnLogin.setOnClickListener(btncol);
		btnReset.setOnClickListener(btncol);
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	//�ڲ���
	private class btnOnClickListener implements OnClickListener{
		public void onClick(View v){
			switch(v.getId()){
			case R.id.btnLogin:
				
				String strUname=etUsername.getText().toString().trim();
				String strPwd=etPassword.getText().toString().trim();
				//String sql="select * from userlogin where username='"+strUmane+'" and password='"+strPwd+"';
				String sql="select *from userlogin where username=?";
				db=dbHelper.getReadableDatabase();
				//ͨ��new String ƴ��
				//�������Ӵʣ����л��壬�ر����Ӵ�
				Cursor c=db.rawQuery(sql,new String[]{strUname});
				while(c.moveToNext()){
					String pwd=c.getString(c.getColumnIndex("password"));
					if(pwd==strPwd){
						System.out.println("��¼�ɹ�������");
						break;
					}
				}
				c.close();
				
				
				
				break;
			case R.id.btnReset:
				//���ݳ�ʼ����������������
				etUsername.setText("");
				etPassword.setText("");
				break;
			default:
				break;
			}
		}
	}

}
