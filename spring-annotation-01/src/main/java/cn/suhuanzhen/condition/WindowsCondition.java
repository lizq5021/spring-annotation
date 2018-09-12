package cn.suhuanzhen.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @version 1.0
 * @Auther: lizq
 * @Date: 2018/9/12 18:49
 * @Description:判断操作系统是否是Windows系统
 */
public class WindowsCondition implements Condition {

    /**
     * Description:
     *
     * @auther: lizq
     * @param: [context:判断条件能使用上下文（环境）, metadata：注释信息]
     * @return: boolean
     * @date: 2018/9/12 18:53
     */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //TODO是否是linux系统
        //能获取ioc使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        //获取当前环境信息
        Environment environment = context.getEnvironment();
        //获取bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        String osName = environment.getProperty("os.name");
        if(osName.contains("Windows")){
            return true;
        }
        return false;
    }
}
