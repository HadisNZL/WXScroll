package com.hadis.wxscroll.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hadis.wxscroll.R;
import com.hadis.wxscroll.base.BaseActivity;
import com.hadis.wxscroll.swipbackhelper.SwipeBackHelper;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Bind(R.id.btn)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setTitle("仿微信滑动");
        initView();
    }

    private void initView() {
        // 启用状态栏色彩
        SwipeBackHelper.getCurrentPage(this).setSwipeBackEnable(false);
        SwipeBackHelper.getCurrentPage(this).setDisallowInterceptTouchEvent(true);
    }

    @OnClick(R.id.btn)
    public void onClick(View view) {
        startActivity(new Intent(this, OtherActivity.class));
    }
}
