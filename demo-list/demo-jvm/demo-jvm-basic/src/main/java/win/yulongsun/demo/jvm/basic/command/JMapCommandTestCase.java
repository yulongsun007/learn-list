package win.yulongsun.demo.jvm.basic.command;

/**
 * @author Sun.YuLong on 2018/6/1.
 */
public class JMapCommandTestCase {

    //------------------------------------------------------------------------
    // jmap -heap pid
    //------------------------------------------------------------------------

    /**
     * JDK8 默认情况
     * ----
     * using thread-local object allocation.
     * Parallel GC with 4 thread(s)
     *
     * Heap Configuration:
     *    MinHeapFreeRatio         = 0
     *    MaxHeapFreeRatio         = 100
     *    MaxHeapSize              = 2147483648 (2048.0MB)
     *    NewSize                  = 44564480 (42.5MB)
     *    MaxNewSize               = 715653120 (682.5MB)
     *    OldSize                  = 89653248 (85.5MB)
     *    NewRatio                 = 2
     *    SurvivorRatio            = 8
     *    MetaspaceSize            = 21807104 (20.796875MB)
     *    CompressedClassSpaceSize = 1073741824 (1024.0MB)
     *    MaxMetaspaceSize         = 17592186044415 MB
     *    G1HeapRegionSize         = 0 (0.0MB)
     *
     * Heap Usage:
     * PS Young Generation
     * Eden Space:
     *    capacity = 34078720 (32.5MB)
     *    used     = 3417240 (3.2589340209960938MB)
     *    free     = 30661480 (29.241065979003906MB)
     *    10.027489295372597% used
     * From Space:
     *    capacity = 5242880 (5.0MB)
     *    used     = 0 (0.0MB)
     *    free     = 5242880 (5.0MB)
     *    0.0% used
     * To Space:
     *    capacity = 5242880 (5.0MB)
     *    used     = 0 (0.0MB)
     *    free     = 5242880 (5.0MB)
     *    0.0% used
     * PS Old Generation
     *    capacity = 89653248 (85.5MB)
     *    used     = 0 (0.0MB)
     *    free     = 89653248 (85.5MB)
     *    0.0% used
     *
     * 分析：老年代用了Parallel Old, 新生代用的Parallel Scavenge
     *
     * ----------------------------------------------------
     * JDK8 设置参数
     * -XX:+UseConcMarkSweepGC
     *
     * Heap Configuration:
     *    MinHeapFreeRatio         = 40
     *    MaxHeapFreeRatio         = 70
     *    MaxHeapSize              = 2147483648 (2048.0MB)
     *    NewSize                  = 44695552 (42.625MB)
     *    MaxNewSize               = 348913664 (332.75MB)
     *    OldSize                  = 89522176 (85.375MB)
     *    NewRatio                 = 2
     *    SurvivorRatio            = 8
     *    MetaspaceSize            = 21807104 (20.796875MB)
     *    CompressedClassSpaceSize = 1073741824 (1024.0MB)
     *    MaxMetaspaceSize         = 17592186044415 MB
     *    G1HeapRegionSize         = 0 (0.0MB)
     *
     * Heap Usage:
     * New Generation (Eden + 1 Survivor Space):
     *    capacity = 40239104 (38.375MB)
     *    used     = 3578584 (3.4128036499023438MB)
     *    free     = 36660520 (34.962196350097656MB)
     *    8.893299413426304% used
     * Eden Space:
     *    capacity = 35782656 (34.125MB)
     *    used     = 3578584 (3.4128036499023438MB)
     *    free     = 32204072 (30.712196350097656MB)
     *    10.000889816563644% used
     * From Space:
     *    capacity = 4456448 (4.25MB)
     *    used     = 0 (0.0MB)
     *    free     = 4456448 (4.25MB)
     *    0.0% used
     * To Space:
     *    capacity = 4456448 (4.25MB)
     *    used     = 0 (0.0MB)
     *    free     = 4456448 (4.25MB)
     *    0.0% used
     * concurrent mark-sweep generation:
     *    capacity = 89522176 (85.375MB)
     *    used     = 0 (0.0MB)
     *    free     = 89522176 (85.375MB)
     *    0.0% used
     *
     * 分析： 老年代用CMS收集器，新生代用了ParNew
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("test");
    }
}
