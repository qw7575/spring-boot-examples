package com.qw.springmvc.example.tomcat.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class WebInitializar implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        // 创建容器
        AnnotationConfigWebApplicationContext app = new AnnotationConfigWebApplicationContext();
        // 配置自定义配置文件
        app.register(SpringMvcConfig.class);
        // 注册
        DispatcherServlet dispatcherServlet = new DispatcherServlet(app);
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
        dynamic.addMapping("/");
        // 优先级
        dynamic.setLoadOnStartup(1);
    }
}
