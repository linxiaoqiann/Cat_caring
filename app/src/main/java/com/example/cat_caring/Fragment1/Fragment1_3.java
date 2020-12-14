package com.example.cat_caring.Fragment1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.cat_caring.R;
import com.example.cat_caring.db.cat;

import java.util.ArrayList;
import java.util.List;

public class Fragment1_3 extends Fragment {
    private List<cat> catList = new ArrayList<cat>();
    private ListView listView = null;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.xiuxue, container, false);
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initFruits(); // 初始化水果数据
        catAdapter adapter = new catAdapter(getContext(), R.layout.schoolcat_item, catList);//实例化FruitAdapter
        listView = getView().findViewById(R.id.listView);//绑定Listview
        listView.setAdapter(adapter);//设置Adapter
    }

    private void initFruits() {
        cat zheermaoo = new cat(1,"苏格兰折耳猫","白","2019-01-01","公","健康","不咬人"); //添加苹果图片
        catList.add(zheermaoo);
    }
}
