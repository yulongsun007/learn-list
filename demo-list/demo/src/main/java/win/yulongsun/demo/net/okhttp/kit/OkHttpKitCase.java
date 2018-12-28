package win.yulongsun.demo.net.okhttp.kit;

import okhttp3.Call;
import win.yulongsun.demo.net.okhttp.kit.callback.StringCallback;

/**
 * @author sunyulong on 2017/9/6.
 */
public class OkHttpKitCase {
    public static void main(String[] args) {
        OkHttpKit.get()
                .url("http://www.badiu.com")
                .addParams("key", "value")
                .build()
                .connectTimeout(20000)
                .readTimeout(20000)
                .writeTimeout(20000)
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {

                    }
                });
    }
}
