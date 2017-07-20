package win.yulongsun.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import win.yulongsun.service.TestService;

/**
 * @author sunyulong on 2016/12/29.
 */
public class TestServiceImpl implements TestService {
    public String getName() {
        return "yulongsun";
    }
}
