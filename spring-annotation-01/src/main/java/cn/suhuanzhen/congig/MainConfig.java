package cn.suhuanzhen.congig;

import cn.suhuanzhen.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Auther: lizq
 * @Date: 2018/8/26 17:35
 * @Description:
 */
//配置类=配置文件
@Configuration //告诉spring这是一个配置类
@ComponentScan(value = "cn.suhuanzhen",includeFilters = {
    @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class,Service.class})
},useDefaultFilters = false)
//@ComponentScan(value = "cn.suhuanzhen") valu指定要扫描的包
//excludeFilters = Filter[] : 指定扫描时按照什么规则排除那些组件
//includeFilters = Filter[] : 指定扫描的时候只需要包含那些组件

public class MainConfig {

    /**
     * Description:
     * @auther: lizq
     * @param: []
     * @return: cn.suhuanzhen.bean.Person
     * @date: 2018/8/26 17:37
     */
    //给容器中注入一个Bean类型为返回值类型id默认是方法名
    @Bean
    public Person person(){
        return new Person("一页书",18);
    }
}
