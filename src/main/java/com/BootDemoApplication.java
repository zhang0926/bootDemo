package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient

@SpringBootApplication
public class BootDemoApplication {

//	@Bean
//	@LoadBalanced
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}


	public static void main(String[] args) {
//		SpringApplication bootstrap = new SpringApplication(BootDemoApplication.class);
//		bootstrap.setBanner(new Banner() {
//			@Override
//			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
//				System.out.println("nihao 123456");
//			}
//		});
//		bootstrap.setBannerMode(Banner.Mode.CONSOLE);
//		bootstrap.run(args);
		SpringApplication.run(BootDemoApplication.class, args);
	}

}
