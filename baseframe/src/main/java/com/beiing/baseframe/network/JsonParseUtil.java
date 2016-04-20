package com.beiing.baseframe.network;

import com.squareup.moshi.Moshi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by chenliu on 2016/4/14.
 * 描述：json 解析工具
 */
public class JsonParseUtil {
    public static <T> T convertMap(Class<T> type, Map map) {
        Moshi moshi = new Moshi.Builder().build();
        String json = moshi.adapter(Map.class).toJson(map);
        T obj = null;
        try {
            obj = moshi.adapter(type).fromJson(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static  <T> List<T> getTranslateResult(Class<T> clz, List<Map> resultList) {
        List<T> list = new ArrayList<>();
        if (null != resultList && resultList.size() > 0) {
            for (Map map : resultList) {
                list.add(convertMap(clz, map));
            }
        }
        return list;
    }


}
