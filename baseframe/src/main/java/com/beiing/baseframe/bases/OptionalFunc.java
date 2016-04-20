package com.beiing.baseframe.bases;

/**
 * Created by chenliu on 2016/4/20.
 * 描述：Baseactivity、BaseFragment中的可选模板方法
 */
public interface OptionalFunc {
    /**
     * 功能描述：<初始化控件>
     */
    void initViews();

    /**
     * 功能描述：<初始化数据>
     */
    void initData();

    /**
     * 功能描述：<设置监听>
     */
    void setListener();

    /**
     * 功能描述：<向后台请求数据>
     */
    void getNetData();
}
