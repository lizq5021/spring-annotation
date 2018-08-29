package cn.suhuanzhen;

import cn.suhuanzhen.bean.Person;
import cn.suhuanzhen.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @version 1.0
 * @Auther: lizq
 * @Date: 2018/8/26 17:24
 * @Description:
 */
public class MainTest {

    public static void main(String[] args) {
        /*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Person person = (Person) context.getBean("person");
        System.out.println(person);*/
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
//        Person person = (Person) context.getBean("person");
        Person person = context.getBean(Person.class);
        System.out.println(person);
    }
}
