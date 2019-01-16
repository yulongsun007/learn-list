package win.yulongsun.demo.basic.compile;


import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;

/**
 * @author Sun.YuLong on 2018/2/13.
 */
public class DemoJavaCompiler {
    public static void main(String[] args) {
        String classPath = DemoJavaCompiler.class.getResource("/").getPath();
        String str = "import classloader.Printer;"
                + "public class MyPrinter1 implements Printer {"
                + "public void print() {"
                + "System.out.println(\"test1\");"
                + "}}";
        try {
            FileWriter fileWriter = new FileWriter(classPath + "MyPrinter1.java");
            fileWriter.write(str);
            fileWriter.close();
            //
            JavaCompiler                       compiler            = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager            standardFileManager = compiler.getStandardFileManager(null, Locale.getDefault(), Charset.defaultCharset());
            Iterable<? extends JavaFileObject> javaFileObjects     = standardFileManager.getJavaFileObjects(classPath + "MyPrinter1.java");
            //
            Boolean callResult = compiler.getTask(null, standardFileManager, null, null, null, javaFileObjects).call();
            System.out.println("callResult::" + callResult);
            //
            //指定class路径，默认和源代码路径一致，加载class
//            URLClassLoader classLoader = new URLClassLoader(new URL[]{new URL("file:" + classPath)});
//            Printer        printer     = (Printer)classLoader.loadClass("MyPrinter1").newInstance();
//            printer.print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
