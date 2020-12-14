package com.example.cat_caring.Fragment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.cat_caring.R;
import com.example.cat_caring.db.cat;

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
        cat zheermaoo = new cat(1,"苏格兰折耳猫","白","2019-01-01","公","健康","不咬人"); //添加苹果图片
        catList.add(zheermaoo);
    }
}
