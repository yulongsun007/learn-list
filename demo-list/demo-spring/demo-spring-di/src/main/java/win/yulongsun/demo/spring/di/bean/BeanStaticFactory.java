package win.yulongsun.demo.spring.di.bean;

/**
 * @author Sun.YuLong on 2018/6/27.
 */
public class BeanStaticFactory {

    public static Bean getMyBean() {
        return new Bean();
    }
}
