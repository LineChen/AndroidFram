package com.beiing.androidfram.test_recyclerview.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.beiing.androidfram.R;
import com.beiing.androidfram.bean.Content;
import com.beiing.androidfram.test_recyclerview.adapter.GridAdapter;
import com.beiing.baseframe.baseadapter.forrecyclerview.DividerItemDecoration;
import com.beiing.baseframe.baseadapter.forrecyclerview.OnItemClickListener;
import com.beiing.baseframe.baseadapter.forrecyclerview.OnRecyclerViewScrollListener;

import java.util.ArrayList;
import java.util.List;

public class GridLayoutActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private List<Content> list = new ArrayList<Content>();
    GridAdapter adapter;
    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            List<Content> list= (List<Content>) msg.obj;
            adapter.getDatas().addAll(list);
            adapter.notifyDataSetChanged();
            adapter.setFooterView(0);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        initData();
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GridAdapter(this, list);
        adapter.setHeaderView(R.layout.item_header);

        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        adapter.setOnItemClickListener(new OnItemClickListener<Content>() {
            @Override
            public void onItemClick(ViewGroup parent, View view, Content content, int position) {
                Toast.makeText(GridLayoutActivity.this, position + content.getTitle(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onItemLongClick(ViewGroup parent, View view, Content content, int position) {
                Toast.makeText(GridLayoutActivity.this, position + content.getTitle(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        recyclerView.addOnScrollListener(new OnRecyclerViewScrollListener<Content>() {
            @Override
            public void onStart() {
                adapter.setFooterView(R.layout.item_footer);
                Log.e("====", "item_count:" + adapter.getItemCount());
                recyclerView.smoothScrollToPosition(adapter.getItemCount());
            }

            @Override
            public void onLoadMore() {
                Log.e("===", "onLoadMore");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Log.e("TAG","模拟网络请求数据");
                            Thread.sleep(5000);
                            Message message = Message.obtain();
                            message.obj = list;
                            mHandler.sendMessage(message);
                            setLoadingMore(false);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }

    private void initData() {
        Content c = new Content();
        c.setIconUrl("http://p1.qqyou.com/pic/uploadpic/2013-5/26/2013052611174240620.jpg");
        c.setTitle("摇滚水果");
        c.setDesc("比基尼女郎，掀摇滚热浪。滨江区滨文路577号华润超市4楼。");
        list.add(c);


        c = new Content();
        c.setIconUrl("http://g.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=d4d0c467b5de9c82a630f18b59b1ac3c/e850352ac65c103815cbee9cb4119313b07e8932.jpg");
        c.setTitle("坏蛋必须死");
        c.setDesc("说好悬疑片，能否严肃点。余杭区临平南苑街道藕花洲大街303号沃尔玛4楼。");
        list.add(c);


        c = new Content();
        c.setIconUrl("http://att2.citysbs.com/fz/bbs_attachments/2010/month_1002/10020312250ba11460cb93cf95.jpg");
        c.setTitle("诡影迷情");
        c.setDesc("头七夜半时，亡妻回魂日。临安市锦城街道钱王街855号万华广场四楼。");
        list.add(c);

        c = new Content();
        c.setIconUrl("http://cdn.duitang.com/uploads/item/201510/11/20151011195344_aVZRx.jpeg");
        c.setTitle("坏蛋必须死");
        c.setDesc("说好悬疑片，能否严肃点。余杭区临平南苑街道藕花洲大街303号沃尔玛4楼。");
        list.add(c);

        c.setIconUrl("http://p1.qqyou.com/pic/uploadpic/2013-5/26/2013052611174240620.jpg");
        c.setTitle("摇滚水果");
        c.setDesc("比基尼女郎，掀摇滚热浪。滨江区滨文路577号华润超市4楼。");
        list.add(c);


        c = new Content();
        c.setIconUrl("http://g.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=d4d0c467b5de9c82a630f18b59b1ac3c/e850352ac65c103815cbee9cb4119313b07e8932.jpg");
        c.setTitle("坏蛋必须死");
        c.setDesc("说好悬疑片，能否严肃点。余杭区临平南苑街道藕花洲大街303号沃尔玛4楼。");
        list.add(c);


        c = new Content();
        c.setIconUrl("http://att2.citysbs.com/fz/bbs_attachments/2010/month_1002/10020312250ba11460cb93cf95.jpg");
        c.setTitle("诡影迷情");
        c.setDesc("头七夜半时，亡妻回魂日。临安市锦城街道钱王街855号万华广场四楼。");
        list.add(c);

        c = new Content();
        c.setIconUrl("http://cdn.duitang.com/uploads/item/201510/11/20151011195344_aVZRx.jpeg");
        c.setTitle("坏蛋必须死");
        c.setDesc("说好悬疑片，能否严肃点。余杭区临平南苑街道藕花洲大街303号沃尔玛4楼。");
        list.add(c);

        c.setIconUrl("http://p1.qqyou.com/pic/uploadpic/2013-5/26/2013052611174240620.jpg");
        c.setTitle("摇滚水果");
        c.setDesc("比基尼女郎，掀摇滚热浪。滨江区滨文路577号华润超市4楼。");
        list.add(c);


        c = new Content();
        c.setIconUrl("http://g.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=d4d0c467b5de9c82a630f18b59b1ac3c/e850352ac65c103815cbee9cb4119313b07e8932.jpg");
        c.setTitle("坏蛋必须死");
        c.setDesc("说好悬疑片，能否严肃点。余杭区临平南苑街道藕花洲大街303号沃尔玛4楼。");
        list.add(c);


        c = new Content();
        c.setIconUrl("http://att2.citysbs.com/fz/bbs_attachments/2010/month_1002/10020312250ba11460cb93cf95.jpg");
        c.setTitle("诡影迷情");
        c.setDesc("头七夜半时，亡妻回魂日。临安市锦城街道钱王街855号万华广场四楼。");
        list.add(c);

        c = new Content();
        c.setIconUrl("http://cdn.duitang.com/uploads/item/201510/11/20151011195344_aVZRx.jpeg");
        c.setTitle("坏蛋必须死");
        c.setDesc("说好悬疑片，能否严肃点。余杭区临平南苑街道藕花洲大街303号沃尔玛4楼。");
        list.add(c);
    }
}
