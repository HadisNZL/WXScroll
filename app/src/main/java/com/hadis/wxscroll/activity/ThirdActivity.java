package com.hadis.wxscroll.activity;

import android.os.Bundle;

import com.hadis.wxscroll.R;
import com.hadis.wxscroll.base.BaseActivity;

public class ThirdActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        callBack();
        setTitle("ThirdActivity");
    }
}
