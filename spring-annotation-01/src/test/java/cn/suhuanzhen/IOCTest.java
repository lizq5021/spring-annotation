package cn.suhuanzhen;

import cn.suhuanzhen.bean.Person;
import cn.suhuanzhen.config.MainConfig;
import cn.suhuanzhen.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import javax.sound.midi.SoundbankResource;
import java.util.Map;

/**
 * @version 1.0
 * @Auther: lizq
 * @Date: 2018/8/26 17:50
 * @Description:
 */
public class IOCTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void test2(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("ioc容器创建完成...");
        Object person1 = annotationConfigApplicationContext.getBean("person");
        Object person2 = annotationConfigApplicationContext.getBean("person");
        System.out.println(person1 == person2);

    }

    @Test
    public void test03(){
        String[] beanNames = applicationContext.getBeanNamesForType(Person.class);

        //获取操作系统的运行环境
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        //获取操作系统的名字
        String osName = environment.getProperty("os.name");
        System.out.println(osName);

        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);

        System.out.println(beansOfType);


    }

}
