package br.com.microservices.integracaoserasa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class IntegracaoSerasaApplication {
	public static void main(String[] args) {
		SpringApplication.run(IntegracaoSerasaApplication.class, args);
	}
}
