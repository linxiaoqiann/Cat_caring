package com.example.cat_caring;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.cat_caring.ui.activity.Login;

public class CatcaringTest extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean delete = false;
        Intent intent = new Intent(CatcaringTest.this, Login.class);
        intent.putExtra("first_in", true);
        startActivity(intent);
//        }else{
//            LitePal.deleteDatabase("food_db");
//            (new ToastUtils()).showShort(this,"删除数据库成功");
//        }
    }
}
