package com.tobiasjohansson.demooptimize;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DemoOptimizeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoOptimizeApplication.class, args);
	}

}
