package com.robustok.gagafarm.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.robustok.gagafarm.Utility.UserPersistenceContract;

/**
 * Created by Administrator on 2017/6/6.
 */

public class GagafarmDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "gagafarm.db";
    private static final String TEXT_TYPE = " TEXT";

    public GagafarmDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + UserPersistenceContract.UserEntry.TABLE_NAME + " (" +
                    UserPersistenceContract.UserEntry.COLUMN_NAME_USERNAME + TEXT_TYPE + " PRIMARY KEY," +
                    UserPersistenceContract.UserEntry.COLUMN_NAME_PASSWORD + TEXT_TYPE +
                    " )";
    public void onCreate(SQLiteDatabase db){
       // db.execSQL("");referenct to todoapp
       db.execSQL(SQL_CREATE_ENTRIES);//创建表
           Log.d("create table user:","ok");
            }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
