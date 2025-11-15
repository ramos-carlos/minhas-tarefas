package br.com.facint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"br.com.facint.model"})
@EnableJpaRepositories(basePackages = {"br.com.facint.repository"})
public class MinhasTarefasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinhasTarefasApplication.class, args);
	}

}
