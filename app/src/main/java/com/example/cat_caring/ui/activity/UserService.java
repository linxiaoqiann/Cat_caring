package com.example.cat_caring.ui.activity;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cat_caring.MyDatabaseHelper;
import com.example.cat_caring.db.LoginUser;
import com.example.cat_caring.db.User;


public class UserService {
    public User user;
    private MyDatabaseHelper dbHelper;

    SQLiteDatabase sdb;
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
                int id = new Integer(cursor.getString(0));
                String uname = cursor.getString(1);
                int age = new Integer(cursor.getString(3));
                String sex = cursor.getString(4);
                User user = new User();
                user.setUsername(uname);
                System.out.println(id);
                System.out.println(uname);
                System.out.println(age);
                System.out.println(sex);
                user.setId(id);
                user.setSex(sex);
                user.setAge(age);
                LoginUser.getInstance().login(user);
            cursor.close();
            user = new User(cursor.getString(cursor.getColumnIndex("username")),cursor.getString(cursor.getColumnIndex("password")),cursor.getInt(cursor.getColumnIndex("age")),cursor.getString(cursor.getColumnIndex("sex")));
            return true;
        }
        return false;
    }
    public boolean register(User user){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
//        String sql1="create table user(id integer primary key autoincrement,username varchar(20),password varchar(20),age integer,sex varchar(2))";
//        sdb.execSQL(sql1);
        String sql="insert into user(username,password,age,sex) values(?,?,?,?)";
        Object obj[]={user.getUsername(),user.getPassword(),user.getAge(),user.getSex()};
        sdb.execSQL(sql, obj);
        return true;
    }

//    public boolean donate(donation user){
//        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
////        String sql1="create table user(id integer primary key autoincrement,username varchar(20),password varchar(20),age integer,sex varchar(2))";
////        sdb.execSQL(sql1);
//        String sql="update donation set maoliang=?,maobohe=?,maosha=?,maoguantou=? where userid=?";
//        Object obj[]={user.getuserid(),user.getmaoliang(),user.getmaobohe(),user.getmaosha(),user.getmaoguantou()};
//        sdb.execSQL(sql, obj);
//        return true;
//    }
    public void inittable(){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String sql="create table if not exists user(id integer primary key autoincrement,username varchar(20),password varchar(20),age integer,sex varchar(2))";
        sdb.execSQL(sql);
        String sql1="create table if not exists cat(id integer primary key autoincrement,catname varchar(20),maose varchar(20),birthdate varchar(20),sex varchar(2),condition varchar(20),character varchar(100),image BLOB)";
        sdb.execSQL(sql1);
        String sql2="create table if not exists donation(userid integer, maoliang integer,maobohe integer,maosha integer,maoguantou integer,foreign key(userid) REFERENCES user(id))";
        sdb.execSQL(sql2);
    }
    public void update(){

    }
}
