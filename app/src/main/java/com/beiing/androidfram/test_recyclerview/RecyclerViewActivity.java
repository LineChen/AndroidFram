package com.beiing.androidfram.test_recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.beiing.androidfram.R;
import com.beiing.baseframe.baseadapter.ViewHolder;
import com.beiing.baseframe.baseadapter.forrecyclerview.CommonAdapter;
import com.beiing.baseframe.baseadapter.forrecyclerview.DividerItemDecoration;
import com.beiing.baseframe.baseadapter.forrecyclerview.OnItemClickListener;
import com.beiing.baseframe.bases.BaseActivity0;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends BaseActivity0 {

    private RecyclerView mRecyclerView;
    private List<String> mDatas = new ArrayList<>();

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initRoot(Bundle savedInstanceState) {
        setContentView(R.layout.activity_recyclerview);
    }


    @Override
    public void initViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);

    }

    @Override
    public void initData() {
        initDatas();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        CommonAdapter adapter = new CommonAdapter<String>(this, R.layout.item_list, mDatas) {
            @Override
            public void convert(ViewHolder holder, String s) {
                holder.setText(R.id.id_item_list_title, s);
            }
        };
        adapter.setOnItemClickListener(new OnItemClickListener<String>() {
            @Override
            public void onItemClick(ViewGroup parent, View view, String s, int position) {
                Toast.makeText(RecyclerViewActivity.this, position + s , Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onItemLongClick(ViewGroup parent, View view, String s, int position) {
                return false;
            }
        });

        mRecyclerView.setAdapter(adapter);
    }

    private void initDatas() {
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add((char) i + "");
        }
    }
}
