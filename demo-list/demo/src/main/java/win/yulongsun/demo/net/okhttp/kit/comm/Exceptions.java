package win.yulongsun.demo.net.okhttp.kit.comm;

/**
 * @author Sun.Yulong on 2017/9/6.
 */
public class Exceptions {
    public static void illegalArgument(String msg, Object... params) {
        throw new IllegalArgumentException(String.format(msg, params));
    }
}
