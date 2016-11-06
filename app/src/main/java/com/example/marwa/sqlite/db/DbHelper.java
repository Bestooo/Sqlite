package com.example.marwa.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Marwa on 6/7/2016.
 */
public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context) {
        super(context, Data.DB_NAME, null, Data.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "create table " + Data.TABLE_NAME + " (" + Data.KEY_ID + " integer primary key autoincrement, " +
                Data.KEY_NAME + " text , " + Data.KEY_PHONE + " text )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table " + Data.TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }
}
