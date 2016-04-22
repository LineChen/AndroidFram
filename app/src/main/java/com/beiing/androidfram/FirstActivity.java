package com.beiing.androidfram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.beiing.androidfram.test_recyclerview.MultiItemRvActivity;
import com.beiing.androidfram.test_recyclerview.RecyclerViewActivity;
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


    public void gotoRecyclerViewActivity(View view) {
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }

    public void gotoMultiItemRvActivity(View view) {
        startActivity(new Intent(this, MultiItemRvActivity.class));
    }
}







