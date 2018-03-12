package win.yulongsun.demo.all.basic.classloader;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.ClassUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 遍历获取某个路径下的class
 *
 * @author Sun.YuLong on 2018/3/9.
 */
public class ClassLoaderTest {


    @Test
    public void testClassLoader() throws IOException {
        List<String> classes = scanClasses(ClassUtils.getDefaultClassLoader(), "win.yulongsun.demo");
        Assert.assertNotNull(classes);
        //
        for (String clazz : classes) {
            System.out.println(clazz);
        }
    }


    /**
     * 遍历获取某个路径下的class
     *
     * @param packagePath
     * @return
     * @throws IOException
     */
    public List<String> scanClasses(ClassLoader classLoader, String packagePath) throws IOException {
        ArrayList<String> dataList = new ArrayList<>();
        //
        String           resourcePath = ClassUtils.convertClassNameToResourcePath(packagePath);
        Enumeration<URL> resources    = classLoader.getResources(resourcePath);
        while (resources.hasMoreElements()) {
            URL    url       = resources.nextElement();
            String classPath = URLDecoder.decode(url.getFile(), "UTF-8");
            findClasses(classPath, dataList);
        }
        return dataList;
    }


    private void findClasses(String classPath, List<String> resultList) {
        //
        File[] files = new File(classPath).listFiles(pathname -> pathname.isDirectory() || pathname.getName().endsWith(".class"));
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    //递归调用
                    findClasses(f.getAbsolutePath(), resultList);
                } else if (!f.getName().contains("$")) {
                    String classFullPath    = f.getAbsoluteFile().toString();
                    String classPackageName = classFullPath.substring(classFullPath.indexOf("\\classes") + 9, classFullPath.indexOf(".class"));
                    String classFullName    = classPackageName.replace("\\", ".");
                    resultList.add(classFullName);
                }
            }
        }
    }
}
