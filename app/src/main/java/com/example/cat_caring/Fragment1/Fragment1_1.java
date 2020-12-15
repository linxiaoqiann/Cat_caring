package com.example.cat_caring.Fragment1;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.cat_caring.MyDatabaseHelper;
import com.example.cat_caring.R;
import com.example.cat_caring.db.cat;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class Fragment1_1 extends Fragment {
    private List<cat> catList = new ArrayList<cat>();
    private ListView listView = null;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.zaixiao,container,false);
        return view;
    }
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        initFruits(); // 初始化水果数据
        catAdapter adapter = new catAdapter(getContext(), R.layout.schoolcat_item, catList);//实例化FruitAdapter
        listView = getView().findViewById(R.id.listView);//绑定Listview
        listView.setAdapter(adapter);//设置Adapter
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(id == 0) {
                    cat item=(cat) adapter.getItem(position);
                    Toast.makeText(getActivity(), "你点击了第" + item.getCatname() + "项!",
                            Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getActivity(), catinfo.class);
                    startActivity(i);
                }            }

        });


    }

    private void initFruits() {
//        cat zheermaoo = new cat(1,"苏格兰折耳猫","白","2019-01-01","公","健康","不咬人"); //添加苹果图片
//        catList.add(zheermaoo);
        String sql1="select * from cat where condition= ?";
        MyDatabaseHelper dbHelper=new MyDatabaseHelper(getContext());
        SQLiteDatabase sdb=dbHelper.getWritableDatabase();
        Cursor cursor=sdb.rawQuery(sql1, new String[]{"在校"});
        while(cursor.moveToNext()){
             int id = cursor.getInt(cursor.getColumnIndex("id"));
             String catname = cursor.getString(cursor.getColumnIndex("catname"));
             String maose = cursor.getString(cursor.getColumnIndex("maose"));
             String birthday = cursor.getString(cursor.getColumnIndex("birthdate"));
             String sex = cursor.getString(cursor.getColumnIndex("sex"));
             String condition = cursor.getString(cursor.getColumnIndex("condition"));
             String character = cursor.getString(cursor.getColumnIndex("character"));
             byte[] image = cursor.getBlob(cursor.getColumnIndex("image"));
             cat tempcat = new cat(id,catname,maose,birthday,sex,condition,character,image);
             catList.add(tempcat);
        }
    }
}
