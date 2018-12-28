package win.yulongsun.demo.net.okhttp.okhttp3;

import okhttp3.*;

import java.io.IOException;

/**
 * OkHttp3使用案例
 *
 * @author Sun.Yulong on 2017/9/7.
 */
public class OkHttp3Case {
    public static void main(String[] args) {
        //get
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("")
                .build();
        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String string = response.body().toString();
                byte[] bytes  = response.body().bytes();


            }
        });

        //post
        FormBody.Builder builder  = new FormBody.Builder();
        FormBody         formBody = builder.add("key", "val").build();
        request = new Request.Builder().url("").post(formBody).build();

        //
    }
}
