package win.yulongsun.demo.dubbo.impl;

import org.springframework.stereotype.Service;
import win.yulongsun.demo.dubbo.TestService;

/**
 * @author sunyulong on 2016/12/29.
 */
@Service("testService")
public class TestServiceImpl implements TestService {
    public String getName() {
        return "yulongsun";
    }
}
