package com.beiing.androidfram.test_recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.beiing.androidfram.R;
import com.beiing.baseframe.baseadapter.forrecyclerview.OnItemClickListener;
import com.beiing.baseframe.bases.BaseActivity0;

public class MultiItemRvActivity extends BaseActivity0
{
    private RecyclerView mRecyclerView;

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
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ChatAdapterForRv adapter = new ChatAdapterForRv(this, ChatMessage.MOCK_DATAS);
        adapter.setOnItemClickListener(new OnItemClickListener<ChatMessage>()
        {
            @Override
            public void onItemClick(ViewGroup parent, View view, ChatMessage o, int position)
            {
                Toast.makeText(MultiItemRvActivity.this, "Click:" + position + " => " + o.getContent(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onItemLongClick(ViewGroup parent, View view, ChatMessage o, int position)
            {
                Toast.makeText(MultiItemRvActivity.this, "LongClick:" + position + " => " + o.getContent(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        mRecyclerView.setAdapter(adapter);

    }


}
