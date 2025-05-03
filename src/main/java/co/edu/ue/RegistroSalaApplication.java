package co.edu.ue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"co.edu.ue.entity"})
@EnableJpaRepositories(basePackages = {"co.edu.ue.jpa"})
@ComponentScan(basePackages = {"co.edu.ue.controller","co.edu.ue.service","co.edu.ue.dao","co.edu.ue","co.edu.ue.utils"})
@SpringBootApplication
public class RegistroSalaApplication {
	public static void main(String[] args) {
		SpringApplication.run(RegistroSalaApplication.class, args);
	}

}
