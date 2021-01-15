package ru.fireshine.laba3.config;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.xslt.XsltView;
import org.springframework.web.servlet.view.xslt.XsltViewResolver;

@Configuration
@ComponentScan("ru.fireshine.laba3")
@ServletComponentScan("ru.fireshine.laba3.utils")
public class SpringMvcConfig implements WebMvcConfigurer {
    @Bean(name = "viewResolver")
    public ViewResolver getViewResolver() {
    	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setOrder(1000);
        viewResolver.setPrefix("/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    
    @Bean(name = "XsltViewResolver")
    public ViewResolver getXsltViewResolver(){
         
        XsltViewResolver xsltResolover = new XsltViewResolver();
        xsltResolover.setOrder(0);;
         
        xsltResolover.setViewClass(XsltView.class);
        xsltResolover.setViewNames("dishes_xsl", "restaurants_xsl");
        xsltResolover.setPrefix("/xsl/");
        xsltResolover.setSuffix(".xsl");
         
        return xsltResolover;
    }
    
}