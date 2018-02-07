package win.yulongsun.demo.springboot.test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import win.yulongsun.demo.springboot.test.controller.TestController;

/**
 * @author Sun.YuLong on 2018/2/6.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(TestController.class)
public class MyControllerTest {
}
