package com.qw.springmvc.example.tomcat;

import com.qw.springmvc.example.tomcat.config.DemoServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.AprLifecycleListener;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

public class SpringMvcTomcatApplication {

    public static int TOMCAT_PORT = 9090;
    public static String TOMCAT_HOSTNAME = "127.0.0.1";
    public static String WEBAPP_PATH = "src/main";
    public static String WEBINF_CLASSES = "/WEB-INF/classes";
    public static String CLASS_PATH = "build/classes";
    public static String INTERNAL_PATH = "/";

    public static void main(String[] args) throws LifecycleException, ServletException {
        Tomcat tomcat = new Tomcat();
        tomcat.setHostname(TOMCAT_HOSTNAME);
//         tomcat 信息保存在项目下
        tomcat.setBaseDir(".");
        tomcat.setPort(TOMCAT_PORT);
//        StandardContext ctx = (StandardContext) tomcat.addWebapp("/tomcat",new File("src/main").getAbsolutePath());
        StandardContext ctx = (StandardContext) tomcat.addWebapp("/tomcat", System.getProperty("user.dir") + File.separator + WEBAPP_PATH);
        ctx.setReloadable(false);
//        ctx.addLifecycleListener(new AprLifecycleListener());
        WebResourceRoot resourceRoot = new StandardRoot(ctx);
        resourceRoot.addPreResources(new DirResourceSet(resourceRoot, WEBINF_CLASSES, System.getProperty("user.dir") + File.separator + CLASS_PATH, INTERNAL_PATH));
//        File file = new File(CLASS_PATH);
//        resourceRoot.addPreResources(new DirResourceSet(resourceRoot, "/build/classes", file.getAbsolutePath(),"/"));
        // 注册servlet
//        tomcat.addServlet("/tomcat", "demoServlet", new DemoServlet());
//        ctx.addServletMappingDecoded("/demo.do", "demoServlet");
        tomcat.start();
        tomcat.getServer().await();
    }


}