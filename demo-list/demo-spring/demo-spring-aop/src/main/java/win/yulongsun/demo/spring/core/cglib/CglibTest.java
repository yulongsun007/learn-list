package win.yulongsun.demo.spring.core.cglib;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * https://blog.csdn.net/luanlouis/article/details/24589193
 *
 * @author Sun.YuLong on 2018/4/19.
 */
public class CglibTest {


    @Test
    public void testCreateClass() {
        CglibClass clazz = new CglibClass();
        //
        Hacker hacker = new Hacker();
        //
        Enhancer enhancer = new Enhancer();
        //设置要代理的类
        enhancer.setSuperclass(clazz.getClass());
        //设置回调
        enhancer.setCallback(hacker);
        //
        CglibClass proxy = (CglibClass) enhancer.create();
        proxy.say();
    }



    class Hacker implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("------before invoke------");
            //
            methodProxy.invokeSuper(o, objects);
            //
            System.out.println("------after invoke------");
            return null;
        }
    }

    /**问题：
     * java.lang.IllegalArgumentException: Superclass has no null constructors but no arguments were given
     *
     * 	at org.springframework.cglib.proxy.Enhancer.emitConstructors(Enhancer.java:931)
     * 	at org.springframework.cglib.proxy.Enhancer.generateClass(Enhancer.java:631)
     * 	at org.springframework.cglib.core.DefaultGeneratorStrategy.generate(DefaultGeneratorStrategy.java:25)
     * 	at org.springframework.cglib.core.AbstractClassGenerator.generate(AbstractClassGenerator.java:329)
     * 	at org.springframework.cglib.proxy.Enhancer.generate(Enhancer.java:492)
     * 	at org.springframework.cglib.core.AbstractClassGenerator$ClassLoaderData$3.apply(AbstractClassGenerator.java:93)
     * 	at org.springframework.cglib.core.AbstractClassGenerator$ClassLoaderData$3.apply(AbstractClassGenerator.java:91)
     * 	at org.springframework.cglib.core.internal.LoadingCache$2.call(LoadingCache.java:54)
     * 	at java.util.concurrent.FutureTask.run$$$capture(FutureTask.java:266)
     * 	at java.util.concurrent.FutureTask.run(FutureTask.java)
     * 	at org.springframework.cglib.core.internal.LoadingCache.createEntry(LoadingCache.java:61)
     * 	at org.springframework.cglib.core.internal.LoadingCache.get(LoadingCache.java:34)
     * 	at org.springframework.cglib.core.AbstractClassGenerator$ClassLoaderData.get(AbstractClassGenerator.java:116)
     * 	at org.springframework.cglib.core.AbstractClassGenerator.create(AbstractClassGenerator.java:291)
     * 	at org.springframework.cglib.proxy.Enhancer.createHelper(Enhancer.java:480)
     * 	at org.springframework.cglib.proxy.Enhancer.create(Enhancer.java:305)
     * 	at win.yulongsun.demo.spring.core.cglib.CglibTest.testCreateClass(CglibTest.java:29)
     * 	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
     * 	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
     * 	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
     * 	at java.lang.reflect.Method.invoke(Method.java:498)
     * 	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:45)
     * 	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:15)
     * 	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:42)
     * 	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:20)
     * 	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:263)
     * 	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:68)
     * 	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:47)
     * 	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:231)
     * 	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:60)
     * 	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:229)
     * 	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:50)
     * 	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:222)
     * 	at org.junit.runners.ParentRunner.run(ParentRunner.java:300)
     * 	at org.junit.runners.Suite.runChild(Suite.java:128)
     * 	at org.junit.runners.Suite.runChild(Suite.java:24)
     * 	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:231)
     * 	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:60)
     * 	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:229)
     * 	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:50)
     * 	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:222)
     * 	at org.junit.runners.ParentRunner.run(ParentRunner.java:300)
     * 	at org.junit.runner.JUnitCore.run(JUnitCore.java:157)
     * 	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
     * 	at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)
     * 	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)
     * 	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)
     *
     *
     * 解决：
     * 需要将类放在外部。
     */


}

