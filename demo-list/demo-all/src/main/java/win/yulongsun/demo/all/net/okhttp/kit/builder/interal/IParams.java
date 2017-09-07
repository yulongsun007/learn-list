package win.yulongsun.demo.all.net.okhttp.kit.builder.interal;

import java.util.Map;

/**
 * @author Sun.Yulong on 2017/9/6.
 */
public interface IParams {

    AbsRequestBuilder params(Map<String, String> params);

    AbsRequestBuilder addParams(String key, String value);

}
