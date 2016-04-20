package com.beiing.baseframe.network;

import android.text.TextUtils;

import org.xutils.http.annotation.HttpResponse;

import java.util.Map;
/**
 * Created by chenliu on 2016/4/13.
 * 描述：根据服务器传过来的参数配置
 */

@HttpResponse(parser = JsonResponseParser.class)
public class DefaultResponse {
    private Integer statusCode;
    private String status; //success:成功； fail:失败
    private String message;
    private Object data;
    private Map map;
    private Integer pagination;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Integer getPagination() {
        return pagination;
    }

    public void setPagination(Integer pagination) {
        this.pagination = pagination;
    }

    public boolean isSuccess() {
        return (!TextUtils.isEmpty(status)) && status.equals("success");
    }

    @Override
    public String toString() {
        return "DefaultResponse{" +
                "statusCode=" + statusCode +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", data='" + data + '\'' +
                ", map=" + map +
                ", pagination=" + pagination +
                '}';
    }
}
