package win.yulongsun.demo.jvm.page4;

/**大对象直接进入老年代
 * 前提：新生代使用ParNewGC. 使用PS无效
 * @author Sun.YuLong on 2017/12/22.
 */
public class LargeObjectTestCase {

    /**
     * -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseAdaptiveSizePolicy
     *  -XX:PretenureSizeThreshold=3145728
     *  -XX:+UseParNewGC
     *  //
     *
     * @param args
     */
    public static void main(String[] args) {
        byte[] bytes = new byte[5 * 1024 * 1024];
    }
}
