package win.yulongsun.app.sb.constant;

/**
 * 封装了和Result相关的常量
 *
 * @author sunyulong on 2017/1/10.
 */
public class ResultConstant {

    //封装了所有Result对应的状态
    public static class CODE {
        public static int SUCCESS = 200;//表示成功
        public static int ERROR   = 400;//表示失败
        public static int UNAUTH  = 600;//表示没有权限

    }

    //封装了Result对应的信息
    public static class MESSAGE {
        public static String DEFAULT_SUCCESS_MESSAGE    = "处理成功";//处理成功的默认消息
        public static String DEFAULT_ERROR_MESSAGE      = "处理失败";//处理失败的默认消息
        public static String DEFAULT_NOT_FOUND_MESSAGE  = "没有找到对应记录";//处理空数据的默认消息
        public static String DEFAULT_MISS_PARAM_MESSAGE = "缺少参数";//处理缺少参数的默认消息
    }


}
