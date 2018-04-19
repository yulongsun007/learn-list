package win.yulongsun.demo.spring.core.aop;


import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Sun.YuLong on 2018/3/15.
 */
public class UserManagerImplTest {

    @Test
    public void findUserById() {
//        UserManagerImpl manager = new UserManagerImpl();
//        String          user    = manager.findUserById(1);
//        System.out.println(user);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");
        UserManager                    manager = (UserManager) context.getBean("userManagerImpl");
        System.out.println(manager.findUserById(1));

    }


    @Test
    public void testInvokeFindUserById() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");
        UserManager                    manager = (UserManager) context.getBean("userManagerImpl");
        //
        Class<?> clazz = ClassUtils.forName("win.yulongsun.demo.spring.core.aop.UserManagerImpl",ClassUtils.getDefaultClassLoader());
        Method   method = clazz.getDeclaredMethods()[0];
//        ReflectionUtils.invokeMethod(method,clazz.newInstance());
        method.invoke(clazz.newInstance(),1);
        manager.findUserById(1);
    }
}