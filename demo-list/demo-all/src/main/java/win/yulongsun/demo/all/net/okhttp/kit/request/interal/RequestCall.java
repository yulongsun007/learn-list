package win.yulongsun.demo.all.net.okhttp.kit.request.interal;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import win.yulongsun.demo.all.net.okhttp.kit.OkHttpKit;
import win.yulongsun.demo.all.net.okhttp.kit.callback.interal.ICallback;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static win.yulongsun.demo.all.net.okhttp.kit.OkHttpKit.DEFAULT_MILLISECONDS;

/**
 * @author Sun.Yulong on 2017/9/6.
 */
public class RequestCall {
    private long       readTimeout;
    private long       writeTimeout;
    private long       connectTimeout;
    private AbsRequest okHttpRequest;

    public RequestCall(AbsRequest okHttpRequest) {
        this.okHttpRequest = okHttpRequest;
    }

    public RequestCall readTimeout(long readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    public RequestCall writeTimeout(long writeTimeout) {
        this.writeTimeout = writeTimeout;
        return this;
    }

    public RequestCall connectTimeout(long connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    //
    public void execute(ICallback callback) {
        //
        Request request = okHttpRequest.generateRequest();
        //
        OkHttpClient client = OkHttpKit.getInstance().getOkHttpClient();
        //
        if (readTimeout > 0 || writeTimeout > 0 || connectTimeout > 0) {
            readTimeout = readTimeout > 0 ? readTimeout : DEFAULT_MILLISECONDS;
            writeTimeout = writeTimeout > 0 ? writeTimeout : DEFAULT_MILLISECONDS;
            connectTimeout = connectTimeout > 0 ? connectTimeout : DEFAULT_MILLISECONDS;
            //
            client.newBuilder()
                    .readTimeout(readTimeout, TimeUnit.MILLISECONDS)
                    .writeTimeout(writeTimeout, TimeUnit.MILLISECONDS)
                    .connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
                    .build();
        }
        //
        Call call = client.newCall(request);
        // 执行调用网络操作
        call.enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError(call, e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    // 解析返回结果
                    Object o = callback.parseNetworkResponse(response);
                    // 回调返回
                    callback.onResponse(o);
                } catch (Exception e) {
                    callback.onError(call, e);
                }
            }
        });
    }

}
