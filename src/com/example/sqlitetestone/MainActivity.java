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
		
		//SQLite数据库的创建与初始化
		dbHelper=new DBSQLiteHelper(this,"aqlText.db",1);
		//控件的声明与注册
		initWidget();
		//调用事件监听器
		addClickListener();
		
	}
private void initDbData(){
	//db.execSQL(sql);(适合于初始化数据
}
	private void initWidget(){
		btnLogin=(Button)this.findViewById(R.id.btnLogin);
		btnReset=(Button)this.findViewById(R.id.btnReset);
		
		etUsername=(EditText)this.findViewById(R.id.etUsername);
		etPassword=(EditText)this.findViewById(R.id.etPassword);
		
	}
	//监听器，监听所有事件的相关操作
	private void  addClickListener(){
		//对内部类监听进行实例化
		btnOnClickListener btncol=new btnOnClickListener();
		//给按钮控件绑定事件
		btnLogin.setOnClickListener(btncol);
		btnReset.setOnClickListener(btncol);
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	//内部类
	private class btnOnClickListener implements OnClickListener{
		public void onClick(View v){
			switch(v.getId()){
			case R.id.btnLogin:
				
				String strUname=etUsername.getText().toString().trim();
				String strPwd=etPassword.getText().toString().trim();
				//String sql="select * from userlogin where username='"+strUmane+'" and password='"+strPwd+"';
				String sql="select *from userlogin where username=?";
				db=dbHelper.getReadableDatabase();
				//通过new String 拼接
				//创建连接词，进行缓冲，关闭连接词
				Cursor c=db.rawQuery(sql,new String[]{strUname});
				while(c.moveToNext()){
					String pwd=c.getString(c.getColumnIndex("password"));
					if(pwd==strPwd){
						System.out.println("登录成功。。。");
						break;
					}
				}
				c.close();
				
				
				
				break;
			case R.id.btnReset:
				//数据初始化，输入框数据清空
				etUsername.setText("");
				etPassword.setText("");
				break;
			default:
				break;
			}
		}
	}

}
