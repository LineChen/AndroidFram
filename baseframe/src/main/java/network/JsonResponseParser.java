package network;


import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import org.xutils.http.app.ResponseParser;
import org.xutils.http.request.UriRequest;

import java.lang.reflect.Type;
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

        if (result.trim().startsWith("[") && result.trim().endsWith("]")) {
            Class clz = Object.class;
            Pattern pattern = Pattern.compile("\\S+\\<(\\S+)\\>");
            Matcher matcher = pattern.matcher(resultType.toString());
            if (matcher.matches()) {
                clz = Class.forName(matcher.group(1));
            }
            Type type = Types.newParameterizedType(resultClass, clz);
            return moshi.adapter(type).fromJson(result);
        } else {
            return moshi.adapter(resultType).fromJson(result);
        }
    }
}
