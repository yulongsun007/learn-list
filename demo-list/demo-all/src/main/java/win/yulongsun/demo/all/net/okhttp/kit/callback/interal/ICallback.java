package win.yulongsun.demo.all.net.okhttp.kit.callback.interal;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author Sun.Yulong on 2017/9/6.
 */
public interface ICallback<T> {


    //
    T parseNetworkResponse(Response response) throws Exception;

    //
    void onError(Call call, Exception e);

    //
    void onResponse(T response);

}
