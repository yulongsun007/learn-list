package win.yulongsun.demo.spring.di.scan;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

/**
 * @author Sun.YuLong on 2018/5/9.
 *
 * @see ClassPathBeanDefinitionScanner 可指定需要扫描的包
 * @see AnnotationTypeFilter 可添加、删除需要扫描的注解
 */
public class CustomBeanDefinitionRegistry implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(beanDefinitionRegistry);
        // 指定include注解
        AnnotationTypeFilter includeFiliter = new AnnotationTypeFilter(CustomComponent.class);
        scanner.addIncludeFilter(includeFiliter);
        // 指定扫描包
        String[] basePackages = {"win.yulongsun.demo.spring.di.scan"};
        scanner.scan(basePackages);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
