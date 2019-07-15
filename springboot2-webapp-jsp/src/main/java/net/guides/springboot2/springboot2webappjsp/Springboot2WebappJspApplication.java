package net.guides.springboot2.springboot2webappjsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



//@EnableAutoConfiguration
@SpringBootApplication
//@ComponentScan(basePackages = {"net.guides.springboot2.springboot2webappjsp.controllers"})
//@EnableJpaRepositories("net.guides.springboot2.springboot2webappjsp.repositories")

public class Springboot2WebappJspApplication extends SpringBootServletInitializer {	

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		// TODO Auto-generated method stub
		return application.sources(Springboot2WebappJspApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Springboot2WebappJspApplication.class, args);
	}

}
