package com.example.cat_caring.ui.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.cat_caring.Fragment1.catAdapter;
import com.example.cat_caring.Fragment1.catinfo;
import com.example.cat_caring.Fragment2.meiduan;
import com.example.cat_caring.MyDatabaseHelper;
import com.example.cat_caring.R;
import com.example.cat_caring.db.cat;
import com.example.cat_caring.util.ActivityCollector;
import com.example.cat_caring.widget.TitleLayout;

import java.util.ArrayList;
import java.util.List;

import static com.amap.api.maps.model.BitmapDescriptorFactory.getContext;

public class guanzhu extends AppCompatActivity {
    private List<cat> catList = new ArrayList<cat>();
    private ListView listView = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        setContentView(R.layout.activity_guanzhu);
        initFruits(); // 初始化水果数据
        catAdapter adapter = new catAdapter(this, R.layout.schoolcat_item, catList);//实例化FruitAdapter
        listView = findViewById(R.id.listView);//绑定Listview
        listView.setAdapter(adapter);//设置Adapter
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(guanzhu.this, catinfo.class);
                startActivity(i);
            }

        });
    }

    private void initFruits() {

//        String sql1="select * from cat where condition= ?";
//        MyDatabaseHelper dbHelper=new MyDatabaseHelper(getContext());
//        SQLiteDatabase sdb=dbHelper.getWritableDatabase();
//        Cursor cursor=sdb.rawQuery(sql1, new String[]{"在校"});
//        while(cursor.moveToNext()){
//            int id = cursor.getInt(cursor.getColumnIndex("id"));
//            String catname = cursor.getString(cursor.getColumnIndex("catname"));
//            String maose = cursor.getString(cursor.getColumnIndex("maose"));
//            String birthday = cursor.getString(cursor.getColumnIndex("birthdate"));
//            String sex = cursor.getString(cursor.getColumnIndex("sex"));
//            String condition = cursor.getString(cursor.getColumnIndex("condition"));
//            String character = cursor.getString(cursor.getColumnIndex("character"));
//            byte[] image = cursor.getBlob(cursor.getColumnIndex("image"));
//            cat tempcat = new cat(id,catname,maose,birthday,sex,condition,character,image);
//            catList.add(tempcat);
//        }
    }
}
