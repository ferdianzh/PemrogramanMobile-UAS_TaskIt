package com.aan.taskit2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "taskit.db";
    private static final int DATABASE_VERTSION = 1;
    public DataHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERTSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "create table tasks(task_id integer primary key autoincrement, " +
                "task_nama text null, task_tgl text null, task_waktu text null, task_deskripsi text null);";
        Log.d("Data","onCreate: "+sql);
        db.execSQL(sql);

        String sql2 = "create table users(user_id integer primary key autoincrement, " +
                "user_nama text null, user_password text null);";
        Log.d("Data","onCreate: "+sql);
        db.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){
    }
}
