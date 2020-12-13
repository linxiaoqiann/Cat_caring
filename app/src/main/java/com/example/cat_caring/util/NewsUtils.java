package com.example.cat_caring.util;

import android.content.Context;

import com.example.cat_caring.R;
import com.example.cat_caring.db.NewsBean;

import java.util.ArrayList;

/**
 * Created by My on 2016/11/8.
 */

public class NewsUtils {
    /**
     * @param context 上下文环境
     * @return 新闻集合
     */
    public static ArrayList<NewsBean> getAllNews(Context context) {
        ArrayList<NewsBean> arrayList = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            NewsBean newsBean1 = new NewsBean();
            newsBean1.title = "您捐赠的"+"猫粮"+"已经给猫猫用上啦！";
            newsBean1.des = "感谢您！";
            newsBean1.icon = context.getResources().getDrawable(R.drawable.ic_settings);
            newsBean1.news_url = "";
            arrayList.add(newsBean1);

            NewsBean newsBean2 = new NewsBean();
            newsBean2.title = "您捐赠的"+"猫砂"+"已经给猫猫用上啦！";
            newsBean2.des ="感谢您！";
            newsBean2.icon = context.getResources().getDrawable(R.drawable.ic_settings);
            newsBean2.news_url = "";
            arrayList.add(newsBean2);

            NewsBean newsBean3 = new NewsBean();
            newsBean3.title = "您捐赠的"+"猫零食"+"已经给猫猫用上啦！";
            newsBean3.des ="感谢您！";
            newsBean3.icon = context.getResources().getDrawable(R.drawable.ic_settings);
            newsBean3.news_url = "";
            arrayList.add(newsBean3);
        }
        return arrayList;
    }
}