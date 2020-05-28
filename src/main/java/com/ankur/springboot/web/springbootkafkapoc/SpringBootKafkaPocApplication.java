package com.ankur.springboot.web.springbootkafkapoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.ankur.springboot.web.springbootkafkapoc.dal.repository")
public class SpringBootKafkaPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaPocApplication.class, args);
	}

}
