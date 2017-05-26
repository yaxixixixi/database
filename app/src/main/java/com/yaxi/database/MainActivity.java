package com.yaxi.database;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yaxi.database.tansaction.db.MySQLiteOpenHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MySQLiteOpenHelper mySQLiteOpenHelper = new MySQLiteOpenHelper(this);
        SQLiteDatabase db = mySQLiteOpenHelper.getReadableDatabase();
    }
}
