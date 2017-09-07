package win.yulongsun.demo.all.net.okhttp.kit;

import okhttp3.OkHttpClient;
import win.yulongsun.demo.all.net.okhttp.kit.builder.GetBuilder;
import win.yulongsun.demo.all.net.okhttp.kit.builder.PostBuilder;

/**
 * 使用方法
 *  OkHttpKit.get()
             .url("")
             .addParams("key", "value")
             .build()
             .connectTimeout(20000)
             .readTimeout(20000)
             .writeTimeout(20000)
             .execute(new StringCallback() {
                @Override
                public void onError(Call call, Exception e) {}

                @Override
                public void onResponse(String response) {}
            });
 *
 * @author Sun.Yulong on 2017/9/6.
 */
public class OkHttpKit {

    public static final long DEFAULT_MILLISECONDS = 10 * 1000L; //10s
    private static OkHttpKit    sInstance;
    private        OkHttpClient mOkHttpClient;


    public OkHttpKit(OkHttpClient okHttpClient) {
        if (okHttpClient == null) {
            mOkHttpClient = new OkHttpClient();
        } else {
            mOkHttpClient = okHttpClient;
        }
    }

    public static OkHttpKit getInstance() {
        if (sInstance == null) {
            synchronized (OkHttpKit.class) {
                if (sInstance == null) {
                    sInstance = new OkHttpKit(null);
                }
            }
        }
        return sInstance;
    }

    public OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }


    ///////////////////////////////////////////////////////////////////////////

    public static GetBuilder get() {
        return new GetBuilder();
    }

    public static PostBuilder post() {
        return new PostBuilder();
    }


}
