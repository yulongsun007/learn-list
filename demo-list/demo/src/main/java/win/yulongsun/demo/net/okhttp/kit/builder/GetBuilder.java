package win.yulongsun.demo.net.okhttp.kit.builder;

import win.yulongsun.demo.net.okhttp.kit.builder.interal.AbsRequestBuilder;
import win.yulongsun.demo.net.okhttp.kit.builder.interal.IParams;
import win.yulongsun.demo.net.okhttp.kit.request.GetRequest;
import win.yulongsun.demo.net.okhttp.kit.request.interal.RequestCall;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 作用：
 * 1.组装URL
 * 2.组装参数
 *
 * @author Sun.Yulong on 2017/9/6.
 */
public class GetBuilder extends AbsRequestBuilder<GetBuilder> implements IParams {
    @Override
    public RequestCall build() {
        //1. 组装url参数
        if (params != null) {
            Set<Map.Entry<String, String>>      entries  = params.entrySet();
            Iterator<Map.Entry<String, String>> iterator = entries.iterator();
            StringBuffer                        buffer   = new StringBuffer();
            buffer.append(url).append("&");
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                buffer.append(entry.getKey()).append("=").append(entry.getValue());
            }
            url = buffer.toString();
        }
        // 2. 组装request
        GetRequest request = new GetRequest(url, params, headers);
        return request.build();
    }


    @Override
    public AbsRequestBuilder params(Map<String, String> params) {
        this.params = params;
        return this;
    }

    @Override
    public AbsRequestBuilder addParams(String key, String value) {
        if (params == null) {
            params = new LinkedHashMap<>();
        }
        params.put(key, value);
        return this;
    }
}