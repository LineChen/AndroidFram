package com.beiing.baseframe.network;

import org.xutils.common.Callback;
import org.xutils.ex.HttpException;
/**
 * Created by chenliu on 2016/4/13.
 * 描述：扩展网络请求Callback
 */
public abstract class HttpCallback<ResultType> implements Callback.CommonCallback<ResultType> {

    @Override
    public void onSuccess(ResultType result) {

    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
        if (ex instanceof HttpException) {
            ((HttpException) ex).getErrorCode(); //返回的错误码
        }
    }

    @Override
    public void onCancelled(CancelledException cex) {

    }

    @Override
    public void onFinished() {
        //TODO : 统一关闭加载对话框
    }
}
