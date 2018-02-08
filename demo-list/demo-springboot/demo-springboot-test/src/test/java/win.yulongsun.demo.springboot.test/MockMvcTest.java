//package win.yulongsun.demo.springboot.test;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import javax.annotation.Resource;
//
//import static org.hamcrest.Matchers.equalTo;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
// * http://www.cnblogs.com/magicalSam/p/7173920.html
// *
// * @author Sun.YuLong on 2018/2/6.
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class MockMvcTest {
//
//    @Resource
//    private WebApplicationContext context;
//
//    private MockMvc mockMvc;
//
//    @Before
//    public void setUp() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//    }
//
//    @Test
//    public void testIndex() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/index")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("index")));
//    }
//
//}
