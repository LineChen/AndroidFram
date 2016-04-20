package com.beiing.baseframe.bases;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chenliu on 2016/4/20.
 * 描述：1.不使用注入框架，findViewById、setEvent需要自己写
 *       2.MVP模式
 */
public abstract class BaseFragment0<P extends BasePresenter> extends Fragment implements OptionalFunc {

    protected Context mContext;
    protected P mPresenter;
    protected View rootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        int resId = loadView();
        if (rootView == null) {
            rootView = inflater.inflate(resId, container, false);
            initPresenter();
            initViews();
            initData();
            setListener();
            getNetData();
        }
        // 缓存的rootView需要判断是否已经被加过parent，
        // 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }
    protected abstract void initPresenter();

    protected abstract int loadView();

    //--------------------------- 可选模板方法 --------------//
    @Override
    public void initViews() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void getNetData() {

    }


    //---------------------------- 生命周期方法中可以进行 友盟统计、自定义Activity管理器处理 -----//

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}












