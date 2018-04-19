package win.yulongsun.demo.spring.core.javassist;

import javassist.*;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Sun.YuLong on 2018/4/19.
 */
public class JavassistTest {

    @Test
    public void testCreateClass() throws CannotCompileException, NotFoundException, IOException {
        ClassPool classPool = ClassPool.getDefault();
        //定义类
        CtClass ctClass = classPool.makeClass("JavassistClazz");
        //定义code方法
        CtMethod ctMethod = CtNewMethod.make("public void say(){}", ctClass);
        //插入方法代码
        ctMethod.insertBefore("System.out.println(\"I'm Javassist Class\");");
        ctClass.addMethod(ctMethod);
        //
        ctClass.writeFile();
        System.out.println("代码生成结束");
    }
}
