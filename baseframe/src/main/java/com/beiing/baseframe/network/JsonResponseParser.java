package com.beiing.baseframe.network;


import android.util.Log;

import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import org.xutils.http.app.ResponseParser;
import org.xutils.http.request.UriRequest;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chenliu on 2016/4/13.
 * 描述：
 */
public class JsonResponseParser implements ResponseParser {
    @Override
    public void checkResponse(UriRequest request) throws Throwable {

    }

    @Override
    public Object parse(Type resultType, Class<?> resultClass, String result) throws Throwable {
        Moshi moshi = new Moshi.Builder().build();
        return moshi.adapter(resultType).fromJson(result);
    }
}
