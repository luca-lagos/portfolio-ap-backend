package com.ap.portfolio.lucalagos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/*@ComponentScan(basePackages = {"com.ap.portfolio.lucalagos.Controller"} )*/
public class LucaLagosApplication {

	public static void main(String[] args) {
		SpringApplication.run(LucaLagosApplication.class, args);
		System.out.println("App initialized :)");
	}

}
