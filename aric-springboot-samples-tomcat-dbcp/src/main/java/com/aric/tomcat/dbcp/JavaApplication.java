package com.aric.tomcat.dbcp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration //exclude = {DataSourceAutoConfiguration.class}
@ComponentScan({"com.aric.tomcat.dbcp", "aric.springboot.config"})
@EnableCaching
public class JavaApplication extends SpringBootServletInitializer {

    private static Logger logger = LoggerFactory.getLogger(JavaApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JavaApplication.class);
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext application = SpringApplication.run(JavaApplication.class, args);
        if (logger.isDebugEnabled()) {
            String[] beanDefinitionNames = application.getBeanDefinitionNames();
            for (String beanName : beanDefinitionNames) {
                logger.debug(beanName);
            }
        }
    }
}

