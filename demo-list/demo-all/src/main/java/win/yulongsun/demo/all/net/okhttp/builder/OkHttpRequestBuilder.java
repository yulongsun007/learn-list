package win.yulongsun.demo.all.net.okhttp.builder;

import win.yulongsun.demo.all.net.okhttp.request.RequestCall;

import java.util.Map;

/**
 * @author sunyulong on 2017/9/6.
 */
public abstract class OkHttpRequestBuilder<T extends OkHttpRequestBuilder> {
    protected String              url;
    protected Object              tag;
    protected Map<String, Object> headers;
    protected Map<String, Object> params;

    //
    public abstract RequestCall build();


}
