package com.example.cat_caring.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cat_caring.R;
//import com.example.cat_caring.db.LoginUser;
import com.example.cat_caring.util.ActivityCollector;
import com.example.cat_caring.widget.TitleLayout;

public class EditName extends AppCompatActivity {
  //  private LoginUser loginUser = LoginUser.getInstance();
    private TitleLayout tl_title;
    private EditText edit_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        setContentView(R.layout.activity_edit_name);

        tl_title = (TitleLayout) findViewById(R.id.tl_title);
        edit_name = (EditText) findViewById(R.id.et_edit_name);
       // edit_name.setText(loginUser.getName());

        //设置监听器
        //如果点击完成，则更新loginUser并销毁
        tl_title.getTextView_forward().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        //        loginUser.setName(edit_name.getText().toString());
                setResult(RESULT_OK);
                finish();
            }
        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
