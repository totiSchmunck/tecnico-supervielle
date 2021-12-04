package com.demo.tecnico.supervielle.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan({"com.demo.tecnico.supervielle"})
@EntityScan(basePackages = {"com.demo.tecnico.supervielle.entity"})
@EnableJpaRepositories("com.demo.tecnico.supervielle.repository")
public class DemoApp extends SpringBootServletInitializer{
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoApp.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApp.class, args);
	}

}
