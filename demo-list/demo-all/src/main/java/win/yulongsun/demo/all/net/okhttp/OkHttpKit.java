package win.yulongsun.demo.all.net.okhttp;

import win.yulongsun.demo.all.net.okhttp.builder.GetBuilder;
import win.yulongsun.demo.all.net.okhttp.builder.PostBuilder;

/**
 * @author sunyulong on 2017/9/6.
 */
public class OkHttpKit {


    public static GetBuilder get() {
        return new GetBuilder();
    }

    public static PostBuilder post(){
        return new PostBuilder();
    }


}
