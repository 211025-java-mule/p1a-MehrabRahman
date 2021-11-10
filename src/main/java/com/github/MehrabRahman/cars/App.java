package com.github.MehrabRahman.cars;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class App {
    public static void main(String[] args) {
        ApplicationContext spring = new AnnotationConfigApplicationContext(BeanConfig.class);
        AnnotationConfigWebApplicationContext mvc = new AnnotationConfigWebApplicationContext();
        mvc.setParent(spring);
        mvc.scan("com.github.MehrabRahman.cars");

        Tomcat server = spring.getBean(Tomcat.class);
        server.addServlet("", "dispatcher", new DispatcherServlet(mvc)).addMapping("/");
        try {
            server.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
        server.getServer().await();
    }
}
