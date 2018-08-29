package cn.suhuanzhen.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @version 1.0
 * @Auther: lizq
 * @Date: 2018/8/29 13:47
 * @Description:自定义扫描规则
 */
public class MyTypeFilter implements TypeFilter {

    /**
     * @param: [metadataReader:读取到当前正在扫描的类的信息, metadataReaderFactory：可以获取到其他任何类信息的]
     * @return: boolean
     * @date: 2018/8/29 13:50
     */
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        //获取当前类注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //虎丘当前正在扫描的类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类资源(类的路径)
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();
        System.out.println("---->"+className);
        if(className.contains("er")){
            return true;
        }
        return false;
    }
}
