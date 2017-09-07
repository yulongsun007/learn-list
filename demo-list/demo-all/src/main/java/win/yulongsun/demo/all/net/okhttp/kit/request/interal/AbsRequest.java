package win.yulongsun.demo.all.net.okhttp.kit.request.interal;


import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import win.yulongsun.demo.all.net.okhttp.kit.comm.Exceptions;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Sun.Yulong on 2017/9/6.
 */
public abstract class AbsRequest {
    protected String              url;
    protected Map<String, String> headers;
    protected Map<String, String> params;
    protected Request.Builder builder = new Request.Builder();

    public AbsRequest(String url, Map<String, String> headers, Map<String, String> params) {
        this.url = url;
        this.headers = headers;
        this.params = params;
        //1. 调用OKHttp Build Url
        if (url == null || "".equals(url)) {
            Exceptions.illegalArgument("url can not be null.");
        }
        System.out.println("URL is :" + url);
        builder.url(url);
        //2. 调用OKHttp Build Header
        if (headers == null || headers.isEmpty()) {
            return;
        }
        Headers.Builder                     headerBuilder = new Headers.Builder();
        Set<Map.Entry<String, String>>      entrySet      = headers.entrySet();
        Iterator<Map.Entry<String, String>> iterator      = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            headerBuilder.add(entry.getKey(), entry.getValue());
        }
        builder.headers(headerBuilder.build());
    }

    //
    public RequestCall build() {
        return new RequestCall(AbsRequest.this);
    }

    // 构建body
    public abstract RequestBody buildRequestBody();

    //
    public abstract Request buildRequest(RequestBody requestBody);

    public Request generateRequest() {
        RequestBody requestBody = buildRequestBody();
        Request     request     = buildRequest(requestBody);
        return request;
    }
}
