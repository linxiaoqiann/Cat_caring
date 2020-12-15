package com.example.cat_caring.ui.activity;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.example.cat_caring.MyDatabaseHelper;
import com.example.cat_caring.R;
import com.example.cat_caring.db.LoginUser;
import com.example.cat_caring.db.User;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


public class UserService {
    public User user;
    private MyDatabaseHelper dbHelper;

    Context context;
    SQLiteDatabase sdb;
    public UserService(Context context){
        dbHelper=new MyDatabaseHelper(context);
        this.context=context;
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
           // user = new User(cursor.getString(cursor.getColumnIndex("username")),cursor.getString(cursor.getColumnIndex("password")),cursor.getInt(cursor.getColumnIndex("age")),cursor.getString(cursor.getColumnIndex("sex")));
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
        String sql1="create table if not exists user(id integer primary key autoincrement,username varchar(20),password varchar(20),age integer,sex varchar(2),image BLOB)";
        sdb.execSQL(sql1);
        String sql2="create table if not exists cat(id integer primary key autoincrement,catname varchar(20),maose varchar(20),birthdate varchar(20),sex varchar(2),condition varchar(20),character varchar(100),image BLOB)";
        sdb.execSQL(sql2);
        String sql3="create table if not exists donation(userid integer, maoliang integer,maobohe integer,maosha integer,maoguantou integer,foreign key(userid) REFERENCES user(id))";
        sdb.execSQL(sql3);
    }

    public void  initcat(){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        Drawable drawable1 = context.getResources().getDrawable(R.drawable.buou);
        BitmapDrawable bd1 = (BitmapDrawable) drawable1;
        final Bitmap bitmap1 = bd1.getBitmap();
        Drawable drawable2 = context.getResources().getDrawable(R.drawable.meiduan);
        BitmapDrawable bd2 = (BitmapDrawable) drawable2;
        final Bitmap bitmap2 = bd2.getBitmap();
        Drawable drawable3 = context.getResources().getDrawable(R.drawable.zheermao);
        BitmapDrawable bd3 = (BitmapDrawable) drawable3;
        final Bitmap bitmap3 = bd3.getBitmap();
        Drawable drawable4 = context.getResources().getDrawable(R.drawable.yingduan);
        BitmapDrawable bd4 = (BitmapDrawable) drawable4;
        final Bitmap bitmap4 = bd4.getBitmap();
        String sql="insert into cat(catname,maose,birthdate,sex,condition,character,image) values(?,?,?,?,?,?,?)";
        Object obj[]={"大橘","橘色","2019-01-01","公","在校","黑白相间",bitmabToBytes(bitmap1)};
        Object obj1[]={"大黑","黑色","2019-01-02","母","在校","黑橘相间",bitmabToBytes(bitmap2)};
        Object obj2[]={"大白","白色","2019-01-03","公","毕业","橘白相间",bitmabToBytes(bitmap3)};
        Object obj3[]={"大黄","黄色","2019-01-04","公","喵星","白黑相间",bitmabToBytes(bitmap4)};
        sdb.execSQL(sql, obj);
        sdb.execSQL(sql, obj1);
        sdb.execSQL(sql, obj2);
        sdb.execSQL(sql, obj3);
    }


    //图片转为二进制数据
    public byte[] bitmabToBytes(Bitmap bitmap){
        int size = bitmap.getWidth() * bitmap.getHeight() * 4;
        //创建一个字节数组输出流,流的大小为size
        ByteArrayOutputStream baos= new ByteArrayOutputStream(size);
        try {
            //设置位图的压缩格式，质量为100%，并放入字节数组输出流中
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
            //将字节数组输出流转化为字节数组byte[]
            byte[] imagedata = baos.toByteArray();
            return imagedata;
        }catch (Exception e){
        }finally {
            try {
                bitmap.recycle();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new byte[0];
    }
    public void update(){

    }
}
