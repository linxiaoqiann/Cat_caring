package com.example.cat_caring.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cat_caring.R;

public class guanzhu extends AppCompatActivity {
    private LinearLayout invis;
    private ListView lv;
    String[] strs;
    @Override
     protected void onCreate(Bundle savedInstanceState) {
                 super.onCreate(savedInstanceState);
                 setContentView(R.layout.activity_guanzhu);
                 invis = (LinearLayout) findViewById(R.id.invis);

                 strs = new String[100];

                 for (int i = 0; i < 20; i++) {
                         strs[i] = "data-----" + i;
                     }

                 lv = (ListView) findViewById(R.id.lv);


               //  lv.addHeaderView(View.inflate(this, R.layout.stick_action, null));//ListView条目中的悬浮部分 添加到头部

                 lv.setAdapter(new ArrayAdapter<String>(this,
                         android.R.layout.simple_list_item_1, strs));
                 lv.setOnScrollListener(new AbsListView.OnScrollListener() {

                     @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                             }

                     @Override
             public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                              if (firstVisibleItem >= 1) {
                                        invis.setVisibility(View.VISIBLE);
                                     } else {

                                    invis.setVisibility(View.GONE);
                                   }
                           }
       });

       }
}
