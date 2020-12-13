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
 //       String sql="create table user(id integer primary key autoincrement,username varchar(20),password varchar(20),age integer,sex varchar(2))";
        //      sdb.execSQL(sql);
 //       String
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
    public void inittable(){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String sql="create table if not exists user(id integer primary key autoincrement,username varchar(20),password varchar(20),age integer,sex varchar(2))";
        sdb.execSQL(sql);
        String sql1="create table if not exists cat(id integer primary key autoincrement,catname varchar(20),maose varchar(20),birthdate varchar(20),sex varchar(2),condition varchar(20),character varchar(100))";
        sdb.execSQL(sql1);
        String sql2="create table if not exists donation(userid integer, maoliang integer,maobohe integer,maosha integer,maoguantou integer,donationcount integer, foreign key(userid) REFERENCES user(id))";
        sdb.execSQL(sql2);


    }
}
