package com.hadis.wxscroll.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hadis.wxscroll.R;
import com.hadis.wxscroll.swipbackhelper.SwipeBackHelper;
import com.hadis.wxscroll.utils.AppManager;

/**
 * activity基本类
 *
 * @author hadis on 16.4.5.
 */
public class BaseActivity extends AppCompatActivity {
    public Toast mToast = null;
    protected ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);

        SwipeBackHelper.onCreate(this);
        SwipeBackHelper.getCurrentPage(this)//获取当前页面
                .setSwipeBackEnable(true)//设置是否可滑动
                .setSwipeSensitivity(0.5f)//对横向滑动手势的敏感程度。0为迟钝 1为敏感
                .setSwipeRelateEnable(true)
                .setScrimColor(Color.TRANSPARENT)//底层阴影颜色
                .setSwipeEdgePercent(0.2f)//可滑动的范围。百分比。0.2表示为左边20%的屏幕
                .setSwipeRelateEnable(true)//是否与下一级activity联动(微信效果)。默认关
                //.setClosePercent(0.8f)//触发关闭Activity百分比
                //.setSwipeEdge(200)//可滑动的范围。px。200表示为左边200px的屏幕
                //.setDisallowInterceptTouchEvent(true)//不抢占事件，默认关（事件将先由子View处理再由滑动关闭处理）
                // .addListener(new SwipeListener() {//滑动监听}
                .setSwipeRelateOffset(300);//activity联动时的偏移量。默认500px。
    }

    public void showToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public void back(View v) {
        onBackPressed();
    }

    public void callBack() {
        back = (ImageView) findViewById(R.id.ivTitleBtnLeft);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();

            }
        });

    }

    public void setTitle(String title) {
        TextView tv;
        tv = (TextView) findViewById(R.id.ivTitleName);
        tv.setText(title);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SwipeBackHelper.onPostCreate(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().finishActivity(this);

        SwipeBackHelper.onDestroy(this);
    }


}
