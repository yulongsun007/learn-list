package win.yulongsun.demo.net.okhttp.kit.callback;

import okhttp3.Response;
import win.yulongsun.demo.net.okhttp.kit.callback.interal.ICallback;

import java.io.File;
import java.io.InputStream;

/**
 * 文件下载实现类
 *
 * @author Sun.Yulong on 2017/9/7.
 */
public abstract class FileCallback implements ICallback<File> {

    @Override
    public File parseNetworkResponse(Response response) throws Exception {
        // TODO: 2017/9/7
        InputStream inputStream = response.body().byteStream();
        // save file

        return null;
    }

}
