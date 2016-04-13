package com.beiing.androidfram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.xutils.common.Callback;
import org.xutils.ex.HttpException;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import network.DefaultResponse;
import network.HttpCallback;
import network.HttpUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HttpUtil.newInstance().with(this, false)
                .doGet(new RequestParams("http://mobile.ximalaya.com/m/category_tag_menu"), new HttpCallback<DefaultResponse>() {
            @Override
            public void onSuccess(DefaultResponse result) {
                Log.e("====", "result:" + result);
            }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        super.onError(ex, isOnCallback);
                        if (ex instanceof HttpException) { // 网络错误
                            HttpException httpEx = (HttpException) ex;
                            int responseCode = httpEx.getCode();
                            String responseMsg = httpEx.getMessage();
                            String errorResult = httpEx.getResult();
                            // ...
                            Log.e("====", "onError:" + responseMsg + "," + errorResult);
                        } else {
                            Log.e("====", "onError:");
                        }

                    }
                });


//        BaiduParams params = new BaiduParams();
//        params.wd = "xUtils";
//        Callback.Cancelable cancelable
//                = x.http().get(params,
//                new Callback.CommonCallback<List<BaiduResponse>>() {
//                    @Override
//                    public void onSuccess(List<BaiduResponse> result) {
//                        Toast.makeText(x.app(), result.get(0).toString(), Toast.LENGTH_LONG).show();
//                        Log.e("===", "success:" + result.get(0).toString());
//                    }
//
//                    @Override
//                    public void onError(Throwable ex, boolean isOnCallback) {
//                        Toast.makeText(x.app(), ex.getMessage(), Toast.LENGTH_LONG).show();
//                        Log.e("error", "error!");
////                        if (ex instanceof HttpException) { // 网络错误
////                            HttpException httpEx = (HttpException) ex;
////                            int responseCode = httpEx.getCode();
////                            String responseMsg = httpEx.getMessage();
////                            String errorResult = httpEx.getResult();
////
////                            // ...
////                        } else { // 其他错误
////                            // ...
////                        }
//                    }
//
//                    @Override
//                    public void onCancelled(CancelledException cex) {
//                        Toast.makeText(x.app(), "cancelled", Toast.LENGTH_LONG).show();
//                    }
//
//                    @Override
//                    public void onFinished() {
//
//                    }
//                });

    }
}
