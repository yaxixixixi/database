package com.yaxi.db;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.yaxi.db.dao.DaoMaster;
import com.yaxi.db.dao.DaoSession;
import com.yaxi.db.dao.UserDao;

import java.util.List;

import gen.User;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "woshiyaxi.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();
        userDao = daoSession.getUserDao();

        userDao.deleteAll();


        userDao.insert(new User(1,"yaxi1",24,"safsadgfdfg"));
        userDao.insert(new User(2,"yaxi2",23,"safafdgfdfg"));
        userDao.insert(new User(3,"yaxi3",24,"123dfg"));
        userDao.insert(new User(4,"yaxi4",25,"saf1231412dgfdfg"));
        userDao.insert(new User(5,"yaxi5",26,"saf12321dgfdfg"));
        userDao.insert(new User(6,"yaxi6",27,"s123123123adgfdfg"));

        User user = userDao.queryBuilder()
                .where(UserDao.Properties.Id.eq(1)).build().unique();
        Log.i(TAG, "onCreate: user:"+ user.toString());


        List<User> list = userDao.queryBuilder()
                .where(UserDao.Properties.Id.between(3, 6)).limit(2).build().list();

        for (int i = 0; i < list.size(); i++) {
            Log.i(TAG, "onCreate: list" + list.get(i).toString());
        }

    }
}
