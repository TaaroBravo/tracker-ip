package com.lautarobravo.tracipapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TracipapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TracipapiApplication.class, args);
	}

}
