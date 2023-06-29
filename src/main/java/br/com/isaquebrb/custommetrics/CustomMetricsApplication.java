package br.com.isaquebrb.custommetrics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CustomMetricsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomMetricsApplication.class, args);
	}

}
