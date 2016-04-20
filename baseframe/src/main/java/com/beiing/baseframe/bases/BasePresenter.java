package com.beiing.baseframe.bases;

import android.content.Context;

/**
 * Created by chenliu on 2016/4/14.
 * 描述：MVP ：数据业务处理
 */
public abstract class BasePresenter<V extends IBaseView> {
    protected V mView;
    protected Context mContext;

    public BasePresenter(V mView, Context mContext) {
        this.mView = mView;
        this.mContext = mContext;
    }
}
