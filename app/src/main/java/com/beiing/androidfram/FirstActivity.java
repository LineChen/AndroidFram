package com.beiing.androidfram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.beiing.baseframe.bases.BaseActivity0;

public class FirstActivity extends BaseActivity0 {

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initRoot(Bundle savedInstanceState) {
        setContentView(R.layout.activity_first);
    }

    @Override
    public void initData() {
        super.initData();
        Log.e("=====", "I am the best.");
    }


}
