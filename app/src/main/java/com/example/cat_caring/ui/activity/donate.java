package com.example.cat_caring.ui.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.cat_caring.Fragment2.pinleiAdapter;
import com.example.cat_caring.ui.activity.donationAdapter;
import com.example.cat_caring.ui.activity.donation;
import com.example.cat_caring.R;

import java.util.ArrayList;
import java.util.List;

public class donate extends AppCompatActivity {
    public static final String BTN_MODE = "BTNMODE"; //按钮模式
    public static final String TEV_MODE = "TEVMODE"; //文本模式

    private static final String TAG = "IViewGroup";
    private final int HorInterval = 10;    //水平间隔
    private final int VerInterval = 10;    //垂直间隔

    private int viewWidth;   //控件的宽度
    private int viewHeight;  //控件的高度

    private ArrayList<String> mTexts = new ArrayList<>();
    private Context mContext;
    private int textModePadding = 15;

    //正常样式
    private float itemTextSize = 18;
    private int itemBGResNor = R.drawable.goods_item_btn_normal;
    private int itemTextColorNor = Color.parseColor("#000000");

    //选中的样式
    private int itemBGResPre = R.drawable.goods_item_btn_selected;
    private int itemTextColorPre = Color.parseColor("#ffffff");

    private List<donation> donationList = new ArrayList<donation>();
    private ListView listView = null;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.donation,container,false);
        return view;
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttongroup);
        initFruits(); // 初始化水果数据
        donationAdapter adapter = new donationAdapter(donate.this, R.layout.donation, donationList);//实例化FruitAdapter
        listView = (ListView) findViewById(R.id.listView);//绑定Listview
        listView.setAdapter(adapter);//设置Adapter
    }
    private void initFruits() {
        donation maoliang = new donation("请输入你想捐赠的猫粮个数：",R.drawable.maoliang); //添加苹果图片
        donationList.add(maoliang);
        donation maosha = new donation("请输入你想捐赠的猫砂袋数：",R.drawable.maosha); //添加苹果图片
        donationList.add(maosha);
        donation maoguantou = new donation("请输入你想捐赠的猫罐头数：", R.drawable.maoguantou); //添加苹果图片
        donationList.add(maoguantou);
        donation maobohe = new donation("请输入你想捐赠的猫草斤数：", R.drawable.maobohe); //添加苹果图片
        donationList.add(maobohe);

    }
}
//    public donate(Context context) {
//        this(context, null);
//    }
//
//    public donate(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        mContext = context;
//    }
//
//    /**
//     * 计算控件的大小
//     */
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        viewWidth = measureWidth(widthMeasureSpec);
//        viewHeight = measureHeight(heightMeasureSpec);
//        Log.e(TAG, "onMeasure:" + viewWidth + ":" + viewHeight);

//        measureChildren(widthMeasureSpec, heightMeasureSpec);

//        setMeasuredDimension(viewWidth, getViewHeight());
//    }
//
//    private int measureWidth(int pWidthMeasureSpec) {
//        int result = 0;
//        int widthMode = MeasureSpec.getMode(pWidthMeasureSpec);
//        int widthSize = MeasureSpec.getSize(pWidthMeasureSpec);
//        switch (widthMode) {
//            /**
//             * mode共有三种情况，取值分别为MeasureSpec.UNSPECIFIED, MeasureSpec.EXACTLY,
//             * MeasureSpec.AT_MOST。
//             *
//             *
//             * MeasureSpec.EXACTLY是精确尺寸，
//             * 当我们将控件的layout_width或layout_height指定为具体数值时如andorid
//             * :layout_width="50dip"，或者为FILL_PARENT是，都是控件大小已经确定的情况，都是精确尺寸。
//             *
//             *
//             * MeasureSpec.AT_MOST是最大尺寸，
//             * 当控件的layout_width或layout_height指定为WRAP_CONTENT时
//             * ，控件大小一般随着控件的子空间或内容进行变化，此时控件尺寸只要不超过父控件允许的最大尺寸即可
//             * 。因此，此时的mode是AT_MOST，size给出了父控件允许的最大尺寸。
//             *
//             *
//             * MeasureSpec.UNSPECIFIED是未指定尺寸，这种情况不多，一般都是父控件是AdapterView，
//             * 通过measure方法传入的模式。
//             */
//            case MeasureSpec.AT_MOST:
//            case MeasureSpec.EXACTLY:
//                result = widthSize;
//                break;
//        }
//        return result;
//    }
//
//    private int measureHeight(int pHeightMeasureSpec) {
//        int result = 0;
//        int heightMode = MeasureSpec.getMode(pHeightMeasureSpec);
//        int heightSize = MeasureSpec.getSize(pHeightMeasureSpec);
//        switch (heightMode) {
//            case MeasureSpec.UNSPECIFIED:
//                result = getSuggestedMinimumHeight();
//                break;
//            case MeasureSpec.AT_MOST:
//            case MeasureSpec.EXACTLY:
//                result = heightSize;
//                break;
//        }
//        return result;
//    }
//
//    /**
//     * 覆写onLayout，其目的是为了指定视图的显示位置，方法执行的前后顺序是在onMeasure之后，因为视图肯定是只有知道大小的情况下，
//     * 才能确定怎么摆放
//     */
//    @Override
//    protected void onLayout(boolean changed, int l, int t, int r, int b) {

//        int posLeft = HorInterval;
//        int posTop = VerInterval;
//        int posRight;
//        int posBottom;
//        for (int i = 0; i < getChildCount(); i++) {
//            View childView = getChildAt(i);

//            int measureHeight = childView.getMeasuredHeight();
//            int measuredWidth = childView.getMeasuredWidth();
//            if (posLeft + getNextHorLastPos(i) > viewWidth) {
//                posLeft = HorInterval;
//                posTop += (measureHeight + VerInterval);
//            }
//            posRight = posLeft + measuredWidth;
//            posBottom = posTop + measureHeight;
//            childView.layout(posLeft, posTop, posRight, posBottom);
//            posLeft += (measuredWidth + HorInterval);
//        }
//    }
//
//    /**
//     * 获取控件的自适应高度
//     *
//     * @return
//     */
//    private int getViewHeight() {
//        int viewwidth = HorInterval;
//        int viewheight = VerInterval;
//        if (getChildCount() > 0) {
//            viewheight = getChildAt(0).getMeasuredHeight() + VerInterval;
//        }
//        for (int i = 0; i < getChildCount(); i++) {
//            View childView = getChildAt(i);

//            int measureHeight = childView.getMeasuredHeight();
//            int measuredWidth = childView.getMeasuredWidth();

//            if (viewwidth + getNextHorLastPos(i) > viewWidth) {

//                viewwidth = (measuredWidth + HorInterval * 2);
//                viewheight += (measureHeight + VerInterval);
//            } else {
//                viewwidth += (measuredWidth + HorInterval);
//            }
//        }
//        return viewheight;
//    }
//    /**
//     * 当前按钮所需的宽度
//     * @param i
//     * @return
//     */
//    private int getNextHorLastPos(int i) {
//        return getChildAt(i).getMeasuredWidth() + HorInterval;
//    }
//
//    private OnGroupItemClickListener onGroupItemClickListener;
//
//    public void setGroupClickListener(OnGroupItemClickListener listener) {
//        onGroupItemClickListener = listener;
//        for (int i = 0; i < getChildCount(); i++) {
//            final X childView = (X) getChildAt(i);
//            final int itemPos = i;
//            childView.setOnClickListener(new OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    onGroupItemClickListener.onGroupItemClick(itemPos);
//                    chooseItemStyle(itemPos);
//                }
//            });
//        }
//    }
//

//    public void chooseItemStyle(int pos) {
//        clearItemsStyle();
//        if (pos < getChildCount()) {
//            X childView = (X) getChildAt(pos);
//            childView.setBackgroundResource(itemBGResPre);
//            childView.setTextColor(itemTextColorPre);
//            setItemPadding(childView);
//        }
//    }
//
//    private void setItemPadding(X view) {
//        if (view instanceof Button) {
//            view.setPadding(textModePadding, 0, textModePadding, 0);
//        } else {
//            view.setPadding(textModePadding, textModePadding, textModePadding, textModePadding);
//        }
//    }
//

//    private void clearItemsStyle() {
//        for (int i = 0; i < getChildCount(); i++) {
//            X childView = (X) getChildAt(i);
//            childView.setBackgroundResource(itemBGResNor);
//            childView.setTextColor(itemTextColorNor);
//            setItemPadding(childView);
//        }
//    }
//
//    public void addItemViews(ArrayList<String> texts, String mode) {
//        mTexts = texts;
//        removeAllViews();
//        for (String text : texts) {
//            addItemView(text, mode);
//        }
//    }
//
//    private void addItemView(String text, String mode) {
//        X childView = null;
//        switch (mode) {
//            case BTN_MODE:
//                childView = (X) new Button(mContext);
//                break;
//            case TEV_MODE:
//                childView = (X) new TextView(mContext);
//                break;
//        }
//        childView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
//                LayoutParams.WRAP_CONTENT));
//        childView.setTextSize(itemTextSize);
//        childView.setBackgroundResource(itemBGResNor);
//        setItemPadding(childView);
//        childView.setTextColor(itemTextColorNor);
//        childView.setText(text);
//        this.addView(childView);
//    }
//
//    public String getChooseText(int itemID) {
//        if (itemID >= 0) {
//            return mTexts.get(itemID);
//        }
//        return null;
//    }
//
//    public void setItemTextSize(float itemTextSize) {
//        this.itemTextSize = itemTextSize;
//    }
//
//    public void setItemBGResNor(int itemBGResNor) {
//        this.itemBGResNor = itemBGResNor;
//    }
//
//    public void setItemTextColorNor(int itemTextColorNor) {
//        this.itemTextColorNor = itemTextColorNor;
//    }
//
//    public void setItemBGResPre(int itemBGResPre) {
//        this.itemBGResPre = itemBGResPre;
//    }
//
//    public void setItemTextColorPre(int itemTextColorPre) {
//        this.itemTextColorPre = itemTextColorPre;
//    }
//
//    public interface OnGroupItemClickListener {
//        void onGroupItemClick(int item);
//    }
//
//}
//