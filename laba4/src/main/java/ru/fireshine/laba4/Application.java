package ru.fireshine.laba4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
	
}