package win.yulongsun.demo.spring.di.beanfactory;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author Sun.YuLong on 2018/6/28.
 */
public class BeanFactoryVsApplicationContextTest {
    /**
     * ....
     *
     * [2018-06-28 09:48:30]-[main-DEBUG]-[DefaultBeanDefinitionDocumentReader.registerBeanDefinitions:92]: Loading bean definitions
     * [2018-06-28 09:48:30]-[main-DEBUG]-[BeanDefinitionParserDelegate.parseBeanDefinitionElement:451]: No XML 'id' specified - using 'bean' as bean name and [] as aliases
     * [2018-06-28 09:48:30]-[main-DEBUG]-[BeanDefinitionParserDelegate.parseBeanDefinitionElement:451]: No XML 'id' specified - using 'bean2' as bean name and [] as aliases
     * begin get bean.
     * [2018-06-28 09:48:30]-[main-DEBUG]-[XmlBeanFactory.getSingleton:221]: Creating shared instance of singleton bean 'bean'
     * [2018-06-28 09:48:30]-[main-DEBUG]-[XmlBeanFactory.createBean:449]: Creating instance of bean 'bean'
     * [2018-06-28 09:48:30]-[main-DEBUG]-[XmlBeanFactory.doCreateBean:538]: Eagerly caching bean 'bean' to allow for resolving potential circular references
     * [2018-06-28 09:48:30]-[main-DEBUG]-[XmlBeanFactory.createBean:485]: Finished creating instance of bean 'bean'
     * end get bean.
     */
    @Test
    public void testBeanFactoryCreateBean() {
        ClassPathResource resource = new ClassPathResource("spring-bean.xml");
        XmlBeanFactory    factory  = new XmlBeanFactory(resource);
        //
        System.out.println("begin get bean.");
        factory.getBean("bean");
        System.out.println("end get bean.");
    }

    /**
     * [2018-06-28 10:50:56]-[main-DEBUG]-[ClassPathXmlApplicationContext.obtainFreshBeanFactory:616]: Bean factory for org.springframework.context.support.ClassPathXmlApplicationContext@763d9750: org.springframework.beans.factory.support.DefaultListableBeanFactory@47c62251: defining beans [bean,bean2,beanStaticFactory,beanCommonMethodFactory,beanCommon]; root of factory hierarchy
     * [2018-06-28 10:50:56]-[main-DEBUG]-[ClassPathXmlApplicationContext.initMessageSource:733]: Unable to locate MessageSource with name 'messageSource': using default [org.springframework.context.support.DelegatingMessageSource@887af79]
     * [2018-06-28 10:50:56]-[main-DEBUG]-[ClassPathXmlApplicationContext.initApplicationEventMulticaster:757]: Unable to locate ApplicationEventMulticaster with name 'applicationEventMulticaster': using default [org.springframework.context.event.SimpleApplicationEventMulticaster@627551fb]
     * [2018-06-28 10:50:56]-[main-DEBUG]-[DefaultListableBeanFactory.preInstantiateSingletons:728]: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@47c62251: defining beans [bean,bean2,beanStaticFactory,beanCommonMethodFactory,beanCommon]; root of factory hierarchy
     * [2018-06-28 10:50:56]-[main-DEBUG]-[DefaultListableBeanFactory.getSingleton:221]: Creating shared instance of singleton bean 'bean'
     * [2018-06-28 10:50:56]-[main-DEBUG]-[DefaultListableBeanFactory.createBean:449]: Creating instance of bean 'bean'
     * [2018-06-28 10:50:56]-[main-DEBUG]-[DefaultListableBeanFactory.doCreateBean:538]: Eagerly caching bean 'bean' to allow for resolving potential circular references
     * [2018-06-28 10:50:56]-[main-DEBUG]-[DefaultListableBeanFactory.createBean:485]: Finished creating instance of bean 'bean'
     * [2018-06-28 10:50:56]-[main-DEBUG]-[DefaultListableBeanFactory.getSingleton:221]: Creating shared instance of singleton bean 'beanStaticFactory'
     * [2018-06-28 10:50:56]-[main-DEBUG]-[DefaultListableBeanFactory.createBean:449]: Creating instance of bean 'beanStaticFactory'
     * [2018-06-28 10:50:56]-[main-DEBUG]-[DefaultListableBeanFactory.doCreateBean:538]: Eagerly caching bean 'beanStaticFactory' to allow for resolving potential circular references
     * [2018-06-28 10:50:56]-[main-DEBUG]-[DefaultListableBeanFactory.createBean:485]: Finished creating instance of bean 'beanStaticFactory'
     * [2018-06-28 10:50:56]-[main-DEBUG]-[DefaultListableBeanFactory.getSingleton:221]: Creating shared instance of singleton bean 'beanCommonMethodFactory'
     * [2018-06-28 10:50:56]-[main-DEBUG]-[DefaultListableBeanFactory.createBean:449]: Creating instance of bean 'beanCommonMethodFactory'
     * [2018-06-28 10:50:56]-[main-DEBUG]-[DefaultListableBeanFactory.doCreateBean:538]: Eagerly caching bean 'beanCommonMethodFactory' to allow for resolving potential circular references
     * [2018-06-28 10:50:56]-[main-DEBUG]-[DefaultListableBeanFactory.createBean:485]: Finished creating instance of bean 'beanCommonMethodFactory'
     * [2018-06-28 10:50:56]-[main-DEBUG]-[DefaultListableBeanFactory.getSingleton:221]: Creating shared instance of singleton bean 'beanCommon'
     * [2018-06-28 10:50:56]-[main-DEBUG]-[DefaultListableBeanFactory.createBean:449]: Creating instance of bean 'beanCommon'
     * [2018-06-28 10:50:56]-[main-DEBUG]-[DefaultListableBeanFactory.doGetBean:251]: Returning cached instance of singleton bean 'beanCommonMethodFactory'
     * [2018-06-28 10:50:56]-[main-DEBUG]-[DefaultListableBeanFactory.doCreateBean:538]: Eagerly caching bean 'beanCommon' to allow for resolving potential circular references
     * [2018-06-28 10:50:56]-[main-DEBUG]-[DefaultListableBeanFactory.createBean:485]: Finished creating instance of bean 'beanCommon'
     * [2018-06-28 10:50:56]-[main-DEBUG]-[ClassPathXmlApplicationContext.initLifecycleProcessor:784]: Unable to locate LifecycleProcessor with name 'lifecycleProcessor': using default [org.springframework.context.support.DefaultLifecycleProcessor@4493d195]
     * [2018-06-28 10:50:56]-[main-DEBUG]-[DefaultListableBeanFactory.doGetBean:251]: Returning cached instance of singleton bean 'lifecycleProcessor'
     * [2018-06-28 10:50:56]-[main-DEBUG]-[PropertySourcesPropertyResolver.getProperty:91]: Could not find key 'spring.liveBeansView.mbeanDomain' in any property source
     * begin get bean.
     * [2018-06-28 10:50:56]-[main-DEBUG]-[DefaultListableBeanFactory.doGetBean:251]: Returning cached instance of singleton bean 'bean'
     * end get bean.
     */
    @Test
    public void testApplicationContextCreateBean() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
        //
        System.out.println("begin get bean.");
        context.getBean("bean");
        System.out.println("end get bean.");
    }
}
