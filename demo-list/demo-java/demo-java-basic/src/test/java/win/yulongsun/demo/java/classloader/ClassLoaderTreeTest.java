package win.yulongsun.demo.java.classloader;

import org.junit.Test;

/**
 * @author Sun.YuLong on 2018/2/13.
 */
public class ClassLoaderTreeTest {


    @Test
    public void testShowClassLoaders() {
        ClassLoader classLoader = ClassLoaderTree.class.getClassLoader();
        while (classLoader != null) {
            System.out.println(classLoader.toString());
            classLoader = classLoader.getParent();
        }
        System.out.println(classLoader);

//        sun.misc.Launcher$AppClassLoader@18b4aac2-->系统类加载器
//        sun.misc.Launcher$ExtClassLoader@13221655-->
//        null-->
    }

}