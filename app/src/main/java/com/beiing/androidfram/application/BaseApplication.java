package com.beiing.androidfram.application;

import android.app.Application;

import org.xutils.x;

/**
 * Created by chenliu on 2016/4/13.
 * 描述：
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
