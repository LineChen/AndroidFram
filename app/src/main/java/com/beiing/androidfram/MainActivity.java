package com.beiing.androidfram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.xutils.ex.HttpException;
import org.xutils.http.RequestParams;

import com.beiing.androidfram.bean.Category;
import com.beiing.baseframe.network.DefaultResponse;
import com.beiing.baseframe.network.HttpCallback;
import com.beiing.baseframe.network.HttpUtil;
import com.beiing.baseframe.network.JsonParseUtil;
import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HttpUtil.newInstance().with(this, false)
                .doGet(new RequestParams("http://mobile.ximalaya.com/m/category_tag_menu"), new HttpCallback<String>() {
            @Override
            public void onSuccess(String result) {
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
                            Log.e("====", "onError:" + ex.getMessage());
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

    public void goto1(View view) {
        startActivity(new Intent(this, FirstActivity.class));
    }
}
