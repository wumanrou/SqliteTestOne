package com.example.sqlitetestone.dbSqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
//���洫4������
public class DBSQLiteHelper extends SQLiteOpenHelper {
	//���Ĭ����ں��������캯��
	//���캯���������ڣ���4����������Ӧ����ʵ������
	public DBSQLiteHelper(Context context,String name,CursorFactory factory,int version){
		super(context,name,factory,version);
	}

	//���캯������3����
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
