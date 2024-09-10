package com.edgaritzak.gradeManagerSystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.edgaritzak.gradeManagerSystem.service.StudentServiceImpl;
import com.edgaritzak.gradeManagerSystem.service.SystemUserServiceImpl;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	
	@Bean
	public CommandLineRunner comandLineRunner(SystemUserServiceImpl systemUserServiceImpl, StudentServiceImpl studentServiceImpl){
		return runner -> {
			systemUserServiceImpl.findStudentsByGroup(1);
			studentServiceImpl.findBySystemUserId(1);
		};
	}
}
