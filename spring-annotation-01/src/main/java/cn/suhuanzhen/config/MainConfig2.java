package cn.suhuanzhen.config;

import cn.suhuanzhen.bean.Person;
import cn.suhuanzhen.condition.LinuxCondition;
import cn.suhuanzhen.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 * @version 1.0
 * @Auther: lizq
 * @Date: 2018/8/29 14:06
 * @Description:
 */
@Configuration
public class MainConfig2 {

    //默认是单实例的

    /**
     * prototype:多实例的：ioc容器并不会去调用方法创建对象放在容器中
     * singleton：单实例的（默认值）：ioc容器启动就会调用方法创建对象放到ioc容器中
     *            以后每次获取就是直接从容器中拿
     * requset：同一次请求创建一个实例
     * session：同一个session创建一个实例
     *
     * 懒加载：
     *      单实例bean：默认在容器启动的时候创建对象
     *      懒加载：容器启动不创建对象。第一次使用(获取)bean创建对象，并初始化
     *
     */
    //@Scope
    @Lazy
    @Bean
    public Person person(){
        System.out.println("向容器中添加person");
        return new Person("叶小钗",18);
    }

    /**
     * Description: @Conditinal({Condition}) : 按照一定的条件进行判断，满足条件给容器中注册bean
     * @auther: lizq
     * @param: []
     * @return: cn.suhuanzhen.bean.Person
     * @date: 2018/9/12 18:33
     */
    @Conditional({WindowsCondition.class})
    @Bean("blii")
    public Person person01(){
        return new Person("Bill Gates",62);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person02(){
        return new Person("linus",48);
    }

    /**
     * 给容器中注册组件
     * 1.包扫描+组件标注注解(@Controller/@Service/@Repository/@Component)(自己写的类)
     * 2.@Bean(导入第三方包里面的组件)
     * 3.@Import
     */
}
