package win.yulongsun.demo.all.net.nio;

import java.io.IOException;
import java.nio.channels.Selector;

/**http://ifeve.com/selectors/
 *
 * 1、Selector是什么？
 *     选择器。检测NIO通道。
 *
 * 2、
 *
 * Created by Sun.Yulong on 2017/8/23.
 */
public class SelectorCase {

    public static void main(String[] args) throws IOException {
        //1. 创建Selector
        Selector selector = Selector.open();

        //2.将Channel注册到Selector上

    }
}
