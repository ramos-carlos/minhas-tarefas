package br.com.tarefas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class MinhasTarefasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinhasTarefasApplication.class, args);
	}

    @Bean
    CommandLineRunner testPassword(PasswordEncoder encoder) {
        return args -> {
            System.out.println("BCrypt de '123' = " + encoder.encode("123"));
        };
    }



}
