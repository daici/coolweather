package com.coolweather.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class CoolWeatherOpenHelper extends SQLiteOpenHelper {
	/**
	 * Province表建表语句
	 */
	public static final String CREATE_PROVINCE = "create table Province ("
			+ "id integer primary key autoincrement, " + "province_name text, "
			+ "province_code text)";
	/**
	 * City表建表语句
	 */
	public static final String CREATE_CITY = "create table City ("
			+ "id integer primary key autoincrement, " + "city_name text, "
			+ "city_code text, " + "province_id integer)";
	/**
	 * County表建表语句
	 */
	public static final String CREATE_COUNTY = "create table County ("
			+ "id integer primary key autoincrement, " + "county_name text, "
			+ "county_code text, " + "city_id integer)";

	public CoolWeatherOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) { // 第一次创建数据库的时候调用，而数据库创建完后，系统便不会再调用此方法
		// TODO Auto-generated method stub
		db.execSQL(CREATE_PROVINCE); // 创建Province表
		db.execSQL(CREATE_CITY); // 创建City表
		db.execSQL(CREATE_COUNTY); // 创建County表

	}

	/*
	 * 当系统在构造SQLiteOpenHelper类的对象时，如果发现版本号不一样，就会自动调用onUpgrade函数，让你在这里对数据库进行升级。根据上述场景
	 * ，在这个函数中把老版本数据库的相应表中增加字段，并给每条记录增加默认值即可。
	 * 新版本号和老版本号都会作为onUpgrade函数的参数传进来，便于开发者知道数据库应该从哪个版本升级到哪个版本。
	 * 升级完成后，数据库会自动存储最新的版本号为当前数据库版本号。
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
