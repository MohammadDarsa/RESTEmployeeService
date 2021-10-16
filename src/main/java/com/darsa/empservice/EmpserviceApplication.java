package com.darsa.empservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class EmpserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpserviceApplication.class, args);
	}

}
