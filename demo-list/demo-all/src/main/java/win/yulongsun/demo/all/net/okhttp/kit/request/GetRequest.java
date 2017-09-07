package win.yulongsun.demo.all.net.okhttp.kit.request;

import okhttp3.Request;
import okhttp3.RequestBody;
import win.yulongsun.demo.all.net.okhttp.kit.request.interal.AbsRequest;

import java.util.Map;

/**
 * @author Sun.Yulong on 2017/9/6.
 */
public class GetRequest extends AbsRequest {

    public GetRequest(String url, Map<String, String> headers, Map<String, String> params) {
        super(url, headers, params);
    }

    @Override
    public RequestBody buildRequestBody() {
        return null;
    }

    @Override
    public Request buildRequest(RequestBody requestBody) {
        return builder.get().build();
    }
}
