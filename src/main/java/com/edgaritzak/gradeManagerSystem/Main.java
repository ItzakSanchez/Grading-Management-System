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
			systemUserServiceImpl.findAll().forEach(x-> System.out.println(x));
			System.out.println("--------------");
			systemUserServiceImpl.findStudentsByGroup(1).forEach(x-> System.out.println(x.toString()));
			//System.out.println(studentServiceImpl.findBySystemUserId(1));
		};
	}
}
