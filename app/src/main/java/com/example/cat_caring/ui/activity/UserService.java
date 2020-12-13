package com.example.cat_caring.ui.activity;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cat_caring.MyDatabaseHelper;
import com.example.cat_caring.db.User;


public class UserService {
    private MyDatabaseHelper dbHelper;
    public UserService(Context context){
        dbHelper=new MyDatabaseHelper(context);
    }

    public boolean login(String username,String password){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String sql="select * from user where username=? and password=?";

        Cursor cursor=sdb.rawQuery(sql, new String[]{username,password});
        if(cursor.moveToFirst()==true){
            cursor.close();
            return true;
        }
        return false;
    }
    public boolean register(User user){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String sql="insert into user(username,password,age,sex) values(?,?,?,?)";
        Object obj[]={user.getUsername(),user.getPassword(),user.getAge(),user.getSex()};
        sdb.execSQL(sql, obj);
        return true;
    }
}
