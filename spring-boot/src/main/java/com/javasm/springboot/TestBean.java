package com.javasm.springboot;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:test.properties")
public class TestBean {

    @Value("${user.name}")
    private String name;

   public void test(){
       System.out.println("获取自定义的"+name);

   }

}
