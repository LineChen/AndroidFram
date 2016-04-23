package com.beiing.androidfram;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.beiing.androidfram.test_recyclerview.activity.ControlActivity;
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

    /**
     * 测试recyclerview
     * @param view
     */
    public void testRecyclerView(View view) {
        startActivity(new Intent(this, ControlActivity.class));
    }
}







