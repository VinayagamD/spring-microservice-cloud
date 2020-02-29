package com.vinay.currencynamingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CurrencyNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyNamingServerApplication.class, args);
	}

}
