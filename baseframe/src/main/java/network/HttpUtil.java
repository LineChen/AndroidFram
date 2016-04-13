package network;

import android.app.Activity;
import android.content.Context;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by chenliu on 2016/4/13.
 * 描述：
 */
public class HttpUtil {

    private static Callback.Cancelable mCancelable;
    private Context context;
    private boolean isShowDialog;

    private HttpUtil(){}

    public static HttpUtil newInstance(){
        HttpUtil httpUtil = new HttpUtil();
        return httpUtil;
    }

    public HttpUtil with(Context context, boolean isShowDialog){
        this.context = context;
        this.isShowDialog = isShowDialog;
        return this;
    }

    public <ResultType> void doGet(RequestParams params, Callback.CommonCallback<ResultType> callback) {
        if(isShowDialog){
            if(context instanceof Activity){
                if(!((Activity)context).isFinishing()){
                    // TODO 显示加载对话框
                }
            }
        }
        mCancelable = x.http().get(params, callback);
    }

    public  <ResultType> void doPost(RequestParams params, Callback.CommonCallback<ResultType> callback) {
        if(isShowDialog){
            if(context instanceof Activity){
                if(!((Activity)context).isFinishing()){
                    // TODO 显示加载对话框
                }
            }
        }
        mCancelable = x.http().post(params, callback);
    }

    public  <ResultType> void doPostByJson(String uri, String jsonData, Callback.CommonCallback<ResultType> callback) {
        if(isShowDialog){
            if(context instanceof Activity){
                if(!((Activity)context).isFinishing()){
                    // TODO 显示加载对话框
                }
            }
        }

//        if (!uri.startsWith(Define.API_BASE_URL)) {
//            uri = Define.API_BASE_URL + "/" + uri;
//        }

        RequestParams params = new RequestParams(uri);
        params.setAsJsonContent(true);
//        if (!TextUtils.isEmpty(jsonData)) {
        params.setBodyContent(jsonData);
//        }
        doPost(params, callback);
    }


    public  void cancel() {
        if (null != mCancelable && !mCancelable.isCancelled()) {
            mCancelable.cancel();
        }
    }

}
