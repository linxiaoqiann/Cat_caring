package com.example.cat_caring.Fragment1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.cat_caring.Fragment1.schoolcat;
import com.example.cat_caring.Fragment1.catAdapter;
import com.example.cat_caring.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment1_1 extends Fragment {
    private List<schoolcat> catList = new ArrayList<schoolcat>();
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
    }
    private void initFruits() {
        schoolcat zheermaoo = new schoolcat("苏格兰折耳猫",R.drawable.zheermao); //添加苹果图片
        catList.add(zheermaoo);
        schoolcat yingduann = new schoolcat("英国短毛猫",R.drawable.yingduan); //添加苹果图片
        catList.add(yingduann);
        schoolcat meiduann = new schoolcat("美国短毛猫", R.drawable.meiduan); //添加苹果图片
        catList.add(meiduann);
        schoolcat jiafeii = new schoolcat("加菲猫", R.drawable.jiafei); //添加苹果图片
        catList.add(jiafeii);
        schoolcat buouu = new schoolcat("布偶猫",R.drawable.buou); //添加苹果图片
        catList.add(buouu);     //添加文本apple
        //添加文本orange
    }
}
