package win.yulongsun.demo.spring.di;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author Sun.YuLong on 2018/3/13.
 */
public class BeanLifeCycle implements InitializingBean, DisposableBean,BeanPostProcessor,BeanFactoryPostProcessor {

    public BeanLifeCycle() {
        System.out.println("构造方法");
    }


    public void init() {
        System.out.println("init");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("PostConstruct");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("PreDestroy");
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessBeforeInitialization");
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessBeforeInitialization");
        return o;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("postProcessBeanFactory");
    }
}
