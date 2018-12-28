package win.yulongsun.demo.net.okhttp.kit.builder.interal;

import win.yulongsun.demo.net.okhttp.kit.request.interal.RequestCall;

import java.util.Map;

/**
 * @author Sun.Yulong on 2017/9/6.
 */
public abstract class AbsRequestBuilder<T extends AbsRequestBuilder> {
    protected String              url;
    protected Map<String, String> headers;
    protected Map<String, String> params;

    //组装
    public abstract RequestCall build();

    //组装url
    public T url(String url) {
        this.url = url;
        return (T) this;
    }


}
