package win.yulongsun.demo.all.basic.classloader;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;

/**
 * 遍历获取某个路径下的class
 * @author Sun.YuLong on 2018/3/9.
 */
public class ClassLoaderTestCase {
    public static void main(String[] args) throws IOException {
        Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources("win/yulongsun/demo/");
        while (resources.hasMoreElements()) {
            URL    url       = resources.nextElement();
            String classPath = URLDecoder.decode(url.getFile(), "UTF-8");
            findClasses(classPath);

        }
    }

    private static void findClasses(String classPath) {
        //
        File[] files = new File(classPath).listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory() || pathname.getName().endsWith(".class");
            }
        });
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    //递归调用
                    findClasses(f.getAbsolutePath());
                } else if (!f.getName().contains("$")) {
                    String classFullPath    = f.getAbsoluteFile().toString();
                    String classPackageName = classFullPath.substring(classFullPath.indexOf("\\classes") + 9, classFullPath.indexOf(".class"));
                    System.out.println(classPackageName.replace("\\", "."));
                }
            }
        }
    }
}
