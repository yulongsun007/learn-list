package win.yulongsun.demo.spring.di.circularreferences;

/**
 * @author Sun.YuLong on 2018/6/26.
 */
public class BeanB {
    private BeanA beanA;

    public BeanA getBeanA() {
        return beanA;
    }

    public void setBeanA(BeanA beanA) {
        this.beanA = beanA;
    }
}
