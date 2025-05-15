package com.nanwe.push;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nanwe.push.mapper")
public class PushAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(PushAdminApplication.class, args);
	}

}
