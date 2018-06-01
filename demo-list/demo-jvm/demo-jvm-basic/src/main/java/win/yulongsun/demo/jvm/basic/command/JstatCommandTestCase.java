package win.yulongsun.demo.jvm.basic.command;

/**
 * @author Sun.YuLong on 2018/6/1.
 */
public class JstatCommandTestCase {
    //------------------------------------------------------------------------
    // jstat -gcutil pid 采样时间间隔 采样次数
    //------------------------------------------------------------------------

    /**jstat -gcutil 16556 1000 5
     *
     *   S0     S1     E      O      M     CCS    YGC     YGCT    FGC    FGCT     GCT
     *   0.00   0.00  10.03   0.00  17.52  19.76      0    0.000     0    0.000    0.000
     *   0.00   0.00  10.03   0.00  17.52  19.76      0    0.000     0    0.000    0.000
     *   0.00   0.00  10.03   0.00  17.52  19.76      0    0.000     0    0.000    0.000
     *   0.00   0.00  10.03   0.00  17.52  19.76      0    0.000     0    0.000    0.000
     *   0.00   0.00  10.03   0.00  17.52  19.76      0    0.000     0    0.000    0.000
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("test");
    }
}
