package com.example.cat_caring.Fragment2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.cat_caring.R;
import com.example.cat_caring.R.layout;

import java.util.ArrayList;
import java.util.List;


public class Fragment2_1 extends Fragment {
    private List<cat_pinlei> pinleiList = new ArrayList<cat_pinlei>();
    private ListView listView = null;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view=inflater.inflate(layout.pinlei,container,false);
        return view;
    }
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        initFruits(); // 初始化水果数据
        pinleiAdapter adapter = new pinleiAdapter(getContext(), R.layout.pinlei_item, pinleiList);//实例化FruitAdapter
        listView = getActivity().findViewById(R.id.listView);//绑定Listview
        listView.setAdapter(adapter);//设置Adapter
    }
    private void initFruits() {
        cat_pinlei zheermao = new cat_pinlei("苏格兰折耳猫","1-5","温顺",R.drawable.zheermao); //添加苹果图片
        pinleiList.add(zheermao);
        cat_pinlei yingduan = new cat_pinlei("英国短毛猫", "1-5","温顺",R.drawable.yingduan); //添加苹果图片
        pinleiList.add(yingduan);
        cat_pinlei meiduan = new cat_pinlei("美国短毛猫", "1-5","温顺",R.drawable.meiduan); //添加苹果图片
        pinleiList.add(meiduan);
        cat_pinlei jiafei = new cat_pinlei("加菲猫", "1-5","温顺",R.drawable.jiafei); //添加苹果图片
        pinleiList.add(jiafei);
        cat_pinlei buou = new cat_pinlei("布偶猫", "1-5","温顺",R.drawable.buou); //添加苹果图片
        pinleiList.add(buou);     //添加文本apple
        //添加文本orange
    }
}