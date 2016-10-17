package com.example.sqlitetestone.dbSqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
//正规传4个参数
public class DBSQLiteHelper extends SQLiteOpenHelper {
	//类的默认入口函数：构造函数
	//构造函数（类的入口），4个参数（响应对象实例化）
	public DBSQLiteHelper(Context context,String name,CursorFactory factory,int version){
		super(context,name,factory,version);
	}

	//构造函数，传3个参
	public DBSQLiteHelper(Context context,String name,int version){
		super(context,name,null,version);
		
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		System.out.println("Creating Database......");
		String CreatTableSql="creat table userlogin("
				+"id integer primary key autoincrement,"
				+"username varchar"
				+"password varchar"
				+"loginNum interger,"
				+"loginDatetime text)";
		db.execSQL(CreatTableSql);
		

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
