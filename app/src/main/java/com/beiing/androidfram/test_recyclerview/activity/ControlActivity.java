package com.beiing.androidfram.test_recyclerview.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.beiing.androidfram.R;

public class ControlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
    }

    public void goSimpleRecActivity(View view) {
        startActivity(new Intent(this, SimpleRecyclerViewActivity.class));
    }


    public void goGridLayoutActivity(View view) {
        startActivity(new Intent(this, GridLayoutActivity.class));
    }

    public void goStaggerActivity(View view) {
        startActivity(new Intent(this, StaggerActivity.class));
    }
}
