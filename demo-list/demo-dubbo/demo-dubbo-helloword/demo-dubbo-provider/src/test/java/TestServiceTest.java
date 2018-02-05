import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author by sunyulong on 2016/12/29.
 */
public class TestServiceTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"app.xml"});
        context.start();
        System.out.println("提供者服务已注册成功");
        try {
            //让服务一直跑，表示一直提供服务
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
