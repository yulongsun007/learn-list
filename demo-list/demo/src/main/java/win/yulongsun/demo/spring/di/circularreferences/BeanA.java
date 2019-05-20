package win.yulongsun.demo.spring.di.circularreferences;

/**
 * @author Sun.YuLong on 2018/6/26.
 */
public class BeanA {
    private BeanB beanB;

    public BeanB getBeanB() {
        return beanB;
    }

    public void setBeanB(BeanB beanB) {
        this.beanB = beanB;
    }
}
