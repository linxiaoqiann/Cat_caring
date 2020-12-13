package com.example.cat_caring.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cat_caring.MainActivity;
import com.example.cat_caring.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);//即activity_login.xml
        findViews();
        UserService uService=new UserService(Login.this);
        uService.inittable();
    }
    private EditText username;
    private EditText password;
    private Button login;
    private Button register;

    private void findViews() {
        username=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);
        login=(Button) findViewById(R.id.login);
        register=(Button) findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=username.getText().toString();
                System.out.println(name);
                String pass=password.getText().toString();
                System.out.println(pass);

                Log.i("TAG",name+"_"+pass);
                UserService uService=new UserService(Login.this);
                boolean flag=uService.login(name, pass);

                if(flag){
                    Log.i("TAG","登录成功");
                    Toast.makeText(Login.this, "登录成功", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    Log.i("TAG","登录失败");
                    Toast.makeText(Login.this, "登录失败", Toast.LENGTH_LONG).show();
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });
    }
}