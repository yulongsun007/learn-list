package win.yulongsun.demo.net.okhttp.kit.callback;

import okhttp3.Response;
import win.yulongsun.demo.net.okhttp.kit.callback.interal.ICallback;

/**
 * @author Sun.Yulong on 2017/9/7.
 */
public abstract class ByteArrayCallback implements ICallback<byte[]> {
    @Override
    public byte[] parseNetworkResponse(Response response) throws Exception {
        return response.body().bytes();
    }
}
