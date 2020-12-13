package com.example.cat_caring.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.cat_caring.R;
import com.example.cat_caring.db.LoginUser;
import com.example.cat_caring.ui.activity.PersonInfo;
import com.example.cat_caring.ui.activity.Setting;
import com.example.cat_caring.widget.RoundImageView;

public class PersonPageFragment extends Fragment implements View.OnClickListener {
    private ImageView setting;
    private LinearLayout info;
    private LinearLayout shoucang;
    private LinearLayout mydonate;
    private LinearLayout donate;
    private LinearLayout location;
    private TextView info_name,info_account;
    private RoundImageView portrait;
    private LoginUser loginUser = LoginUser.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment3, container, false);
        setting = (ImageView)view.findViewById(R.id.setting);
        info = (LinearLayout)view.findViewById(R.id.info);
        info_name = (TextView)view.findViewById(R.id.info_name);
        portrait = (RoundImageView)view.findViewById(R.id.portrait);
        shoucang = (LinearLayout)view.findViewById(R.id.shoucang);
        mydonate = (LinearLayout)view.findViewById(R.id.mydonate);
        donate = (LinearLayout)view.findViewById(R.id.donate);
        location = (LinearLayout)view.findViewById(R.id.location);
        info.setOnClickListener(this);
        setting.setOnClickListener(this);
        shoucang.setOnClickListener(this);
        mydonate.setOnClickListener(this);
        donate.setOnClickListener(this);
        location.setOnClickListener(this);
        //登录则初始化用户的信息
        initInfo();

        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        //在onStart中init，修改信息后返回不会出现没有修改的情况
       // loginUser.reinit();
        initInfo();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //点击设置按钮的逻辑
            case R.id.setting:
                Intent intent = new Intent(getActivity(), Setting.class);
                getActivity().startActivity(intent);
                break;
            case R.id.info:
                Intent intent1 = new Intent(getActivity(), PersonInfo.class);
                startActivity(intent1);
                break;
            case R.id.mydonate:
                Intent intent2 = new Intent(getActivity(), com.example.cat_caring.ui.activity.mydonate.class);
                startActivity(intent2);
                break;
            case R.id.donate:
                Intent intent3 = new Intent(getActivity(), com.example.cat_caring.ui.activity.newdonate.class);
                startActivity(intent3);
                break;
            case R.id.shoucang:
                Intent intent4 = new Intent(getActivity(), com.example.cat_caring.ui.activity.guanzhu.class);
                startActivity(intent4);
                break;
            case R.id.location:
                Intent intent5 = new Intent(getActivity(), com.example.cat_caring.ui.activity.location.class);
                startActivity(intent5);
                break;
                default:
                break;
        }
    }

    //
    private void initInfo(){
        //info_name.setText(loginUser.getName());
        //portrait.setImageBitmap((new PhotoUtils()).byte2bitmap(loginUser.getPortrait()));
    }
}

