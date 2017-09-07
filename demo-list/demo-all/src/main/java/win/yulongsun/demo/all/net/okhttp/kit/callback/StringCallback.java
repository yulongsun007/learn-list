package win.yulongsun.demo.all.net.okhttp.kit.callback;

import okhttp3.Response;
import win.yulongsun.demo.all.net.okhttp.kit.callback.interal.ICallback;

/**
 * @author Sun.Yulong on 2017/9/6.
 */
public abstract class StringCallback implements ICallback<String> {

    @Override
    public String parseNetworkResponse(Response response) throws Exception {
        //将结果解析成String
        return response.body().toString();
    }
}
