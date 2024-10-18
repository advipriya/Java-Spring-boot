package com.taskapp.LoginToDo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.taskapp.LoginToDo")
public class LoginToDoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginToDoApplication.class, args);
	}

}
