package com.example.cat_caring.Fragment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cat_caring.MyDatabaseHelper;
import com.example.cat_caring.R;
import com.example.cat_caring.db.LoginUser;
import com.example.cat_caring.db.cat;
import com.example.cat_caring.ui.activity.Login;

public class catinfo extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    cat cat;
    Intent intent;
    TextView id;
    TextView catname;
    TextView maose;
    TextView birthday;
    TextView sex;
    TextView condition;
    TextView character;
    ImageView catImage;
    Button focus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cat_info);
        id=findViewById(R.id.id);
        catname=findViewById(R.id.catname);
        maose=findViewById(R.id.maose);
        birthday=findViewById(R.id.birthday);
        sex=findViewById(R.id.sex);
        condition=findViewById(R.id.condition);
        character=findViewById(R.id.character);
        catImage=findViewById(R.id.imageView3);
        focus=findViewById(R.id.button);
        intent = getIntent();
        cat = (com.example.cat_caring.db.cat) intent.getSerializableExtra("cat");
        focus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dbHelper=new MyDatabaseHelper(catinfo.this);
                SQLiteDatabase sdb=dbHelper.getWritableDatabase();
                String sql="insert into focus(userid,catid) values(?,?)";
                Object obj[]={Integer.toString(LoginUser.getInstance().getId()),Integer.toString(cat.getId())};
                sdb.execSQL(sql, obj);
            }
        });
        initdata();
    }

    public void initdata(){
        id.setText(Integer.toString(cat.getId()));
        catname.setText(cat.getCatname());
        maose.setText(cat.getMaose());
        birthday.setText(cat.getBirthday());
        sex.setText(cat.getSex());
        condition.setText(cat.getCondition());
        character.setText(cat.getCharacter());
        Bitmap imagebitmap = BitmapFactory.decodeByteArray(cat.getImage(), 0, cat.getImage().length);
        //将位图显示为图片
        catImage.setImageBitmap(imagebitmap);
    }
}