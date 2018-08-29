package cn.suhuanzhen.config;

import cn.suhuanzhen.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

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
     * prototype:多实例的
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
}
