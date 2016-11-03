package com.simple.singleton.sample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by zhangzeyan on 16/11/3.
 */

public class DefineSQLiteOpenHelper extends SQLiteOpenHelper {

    private volatile static DefineSQLiteOpenHelper singleton;

    public static DefineSQLiteOpenHelper getSingleton(Context context) {
        if (singleton == null) {
            synchronized (DefineSQLiteOpenHelper.class) {
                if (singleton == null) {
                    singleton = new DefineSQLiteOpenHelper(context);
                }
            }
        }
        return singleton;
    }

    private DefineSQLiteOpenHelper(Context context){
        this(context,"simple_singleton",null,1);
    }

    private DefineSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Book(id int , name varchar(20), price float, author varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
