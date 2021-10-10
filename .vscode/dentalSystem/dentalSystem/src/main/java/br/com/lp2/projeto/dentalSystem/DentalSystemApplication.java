package br.com.lp2.projeto.dentalSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"br.*"})
public class DentalSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(DentalSystemApplication.class, args);
	}

}
