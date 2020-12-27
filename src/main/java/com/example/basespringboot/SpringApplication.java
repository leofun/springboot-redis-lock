package com.example.basespringboot;

import com.example.basespringboot.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@ComponentScan("com.example.basespringboot.*")
public class SpringApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringApplication.class);
        UserService userService = annotationConfigApplicationContext.getBean(UserService.class);
        userService.sayHello();
    }




}
