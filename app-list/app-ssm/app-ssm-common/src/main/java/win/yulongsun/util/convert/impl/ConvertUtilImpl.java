package win.yulongsun.util.convert.impl;

import org.dozer.DozerBeanMapper;
import win.yulongsun.util.convert.ConvertUtil;

import javax.annotation.Resource;

/**
 * @author sunyulong on 2017/1/20.
 */
public class ConvertUtilImpl implements ConvertUtil {

    @Resource
    private DozerBeanMapper mapper;

    @Override
    public <T> T tran(Object b, Class<T> c) {
        T f = mapper.map(b, c);
        return f;
    }
}
