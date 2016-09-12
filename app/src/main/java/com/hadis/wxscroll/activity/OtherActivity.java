package com.hadis.wxscroll.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hadis.wxscroll.R;
import com.hadis.wxscroll.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class OtherActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        ButterKnife.bind(this);
        callBack();
        setTitle("OtherActivity");
    }

    @OnClick({R.id.btn, R.id.btn1})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn:
                startActivity(new Intent(this, OtherActivity.class));
                break;
            case R.id.btn1:
                startActivity(new Intent(this, ThirdActivity.class));
                break;
        }
    }
}
