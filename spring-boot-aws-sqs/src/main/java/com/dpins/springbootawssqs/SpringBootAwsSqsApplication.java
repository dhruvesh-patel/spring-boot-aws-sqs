package com.dpins.springbootawssqs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;

@SpringBootApplication(exclude = {ContextStackAutoConfiguration.class})
public class SpringBootAwsSqsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAwsSqsApplication.class, args);
	}

}
