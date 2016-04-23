package com.beiing.androidfram.test_recyclerview.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.beiing.androidfram.R;
import com.beiing.androidfram.bean.Content;
import com.beiing.baseframe.baseadapter.ViewHolder;
import com.beiing.baseframe.baseadapter.forrecyclerview.CommonAdapter;
import com.beiing.baseframe.baseadapter.forrecyclerview.ItemSupport;

import org.xutils.x;

import java.util.List;

/**
 * Created by chenliu on 2016/4/22.
 * 描述：
 */
public class SimpleRecyclerviewAdapter extends CommonAdapter<Content> {
    public SimpleRecyclerviewAdapter(Context context, List<Content> datas) {
        super(context, datas, new ItemSupport<Content>() {
            @Override
            public int getLayoutId(int itemType) {
                return R.layout.item_content;
            }
        });
    }

    @Override
    public void bindItemView(ViewHolder holder, Content content) {
        switch (holder.getLayoutId()){
            case R.layout.item_content:
                holder.setText(R.id.title, content.getTitle());
                holder.setText(R.id.desc, content.getDesc());
                ImageView icon = holder.getView(R.id.icon);
                x.image().bind(icon, content.getIconUrl());
                break;
        }

    }

    @Override
    protected void bindHeaderView(ViewHolder holder) {
        ImageView image = holder.getView(R.id.icon);
        x.image().bind(image, "http://sd.china.com.cn/uploadfile/2015/1110/20151110124254756.jpg");
        holder.setText(R.id.tv_header, "这是头部噢");
    }

    @Override
    protected void bindFooterView(ViewHolder holder) {
        holder.setText(R.id.title, "上拉加载更多美女哦");
    }


}













