package com.example.cat_caring.Fragment1;

import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amap.api.maps.MapView;
import com.example.cat_caring.Fragment1.schoolcat;
import com.example.cat_caring.R;

import java.util.List;
public class catAdapter extends ArrayAdapter {
    private final int resourceId;

    public catAdapter(Context context, int textViewResourceId, List<schoolcat> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        schoolcat fruit = (schoolcat) getItem(position); // 获取当前项的Fruit实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象
        ImageView catImage = (ImageView) view.findViewById(R.id.cat_image);//获取该布局内的图片视图
        TextView catName = (TextView) view.findViewById(R.id.cat_name);
//获取该布局内的文本视图
        catImage.setImageResource(fruit.getImageId());//为图片视图设置图片资源
        catName.setText(fruit.getName());
        //为文本视图设置文本内容
        return view;
    }
}
