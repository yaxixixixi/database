package com.yaxi.database.tansaction.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.yaxi.database.bean.Student;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/11/8.
 */

public class DAO {

    private MySQLiteOpenHelper mySQLiteOpenHelper;

    public DAO(Context context) {
        mySQLiteOpenHelper = new MySQLiteOpenHelper(context);
    }

    public void add(Student stu){
        SQLiteDatabase db = mySQLiteOpenHelper.getReadableDatabase();
        db.execSQL("insert into stu (id,name) values(?,?);",new Object[]{stu.id,stu.name});
        db.close();
    }

    public boolean add1(Student stu){
        SQLiteDatabase db = mySQLiteOpenHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("id",stu.id);
        values.put("name",stu.name);
        long result = db.insert("stu", null, values);
        db.close();

        if(result != -1){//-1代表添加失败
            return true;
        }else{
            return false;
        }
    }



    public void query(){
        Student stu;
        ArrayList<Student> list = new ArrayList<>();
        SQLiteDatabase db = mySQLiteOpenHelper.getReadableDatabase();
        Cursor cursor = db.query("stu", new String[]{"id", "name"}, "id = ?", new String[]{0 + ""}, null, null, null);
        if (cursor!=null && cursor.getCount()>0) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                stu = new Student();
                stu.id = id;
                stu.name = name;
                list.add(stu);
            }
            cursor.close();
        }
        db.close();
    }



    public void transaction(){
        SQLiteDatabase db = mySQLiteOpenHelper.getReadableDatabase();
        try {
            db.beginTransaction();
            db.execSQL("update stu set name = zhangsan where id = ?",new String[]{0+""});
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }

    }

}
