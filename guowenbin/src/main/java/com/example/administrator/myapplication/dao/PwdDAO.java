package com.example.administrator.myapplication.dao;

/**
 * Created by Administrator on 2019/1/7.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.administrator.myapplication.model.Tb_pwd;

public class PwdDAO {
    private DBOpenHelper helper;
    private SQLiteDatabase db;

    public PwdDAO(Context context){
        helper = new DBOpenHelper(context);
        db = helper.getWritableDatabase();
    }

    /**
     *
     *
     * @param tb_pwd
     */
    public void add(Tb_pwd tb_pwd) {

        db.execSQL("insert into tb_pwd (password) values (?)",
                new Object[] { tb_pwd.getPassword() });
    }

    /**
     *
     *
     * @param tb_pwd
     */
    public void update(Tb_pwd tb_pwd) {


        db.execSQL("update tb_pwd set password = ?",
                new Object[] { tb_pwd.getPassword() });
    }

    /**
     *
     *
     * @return
     */
    public Tb_pwd find() {


        Cursor cursor = db.rawQuery("select password from tb_pwd", null);
        if (cursor.moveToNext()){

        }
        cursor.close();
        return null;
    }

    public long getCount() {
//
        Cursor cursor = db.rawQuery("select count(password) from tb_pwd",
                null);
        if (cursor.moveToNext()){
            return cursor.getLong(0);
        }
        cursor.close();
        return 0;
    }
}
