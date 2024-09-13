package com.edgaritzak.gradeManagerSystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.edgaritzak.gradeManagerSystem.service.GroupServiceImpl;
import com.edgaritzak.gradeManagerSystem.service.InscriptionsStudentsServiceImpl;
import com.edgaritzak.gradeManagerSystem.service.StudentServiceImpl;
import com.edgaritzak.gradeManagerSystem.service.SystemUserServiceImpl;
import com.edgaritzak.gradeManagerSystem.service.UserSessionServiceImpl;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	
	@Bean
	public CommandLineRunner comandLineRunner(SystemUserServiceImpl systemUserServiceImpl, 
			StudentServiceImpl studentServiceImpl, GroupServiceImpl groupServiceImpl,
			InscriptionsStudentsServiceImpl inscriptionsStudentsServiceImpl,
			UserSessionServiceImpl sessionServiceImpl){
		return runner -> {
			
			System.out.println(sessionServiceImpl.findUserWithRoleDTOByEmail("judy.hopps@example.com"));
			//SYSTEM USER 
//			systemUserServiceImpl.findAll().forEach(x-> System.out.println(x));
//			System.out.println("------------------------------------------------------------------------\n------------------------------------------------------------------------");
//			systemUserServiceImpl.findStudentsByGroup(1).forEach(x-> System.out.println(x.toString()));
//			System.out.println("------------------------------------------------------------------------\n------------------------------------------------------------------------");
//			System.out.println(systemUserServiceImpl.findStudentById(1));
//			System.out.println("------------------------------------------------------------------------\n------------------------------------------------------------------------");
//			System.out.println(systemUserServiceImpl.findTeacherById(1));
//			System.out.println("------------------------------------------------------------------------\n------------------------------------------------------------------------");
//			System.out.println(systemUserServiceImpl.findUserById(6));
//			System.out.println("------------------------------------------------------------------------\n------------------------------------------------------------------------");
//			systemUserServiceImpl.findStudentsWithScoreByGroup(1).forEach(x-> System.out.println(x.toString()));
//			System.out.println("------------------------------------------------------------------------\n------------------------------------------------------------------------");

			//GRUOP
//			System.out.println(groupServiceImpl.findGroupById(1));
//			System.out.println("------------------------------------------------------------------------\n------------------------------------------------------------------------");
//			groupServiceImpl.findTeachersGroups(2).forEach(x-> System.out.println(x.toString()));
//			System.out.println("------------------------------------------------------------------------\n------------------------------------------------------------------------");
//			groupServiceImpl.findTeachersGroupsByTerm(1, 1, 2024).forEach(x-> System.out.println(x.toString()));
//			System.out.println("------------------------------------------------------------------------\n------------------------------------------------------------------------");
//			groupServiceImpl.findStudentsGroups(1).forEach(x-> System.out.println(x.toString()));
//			System.out.println("------------------------------------------------------------------------\n------------------------------------------------------------------------");
//			groupServiceImpl.findStudentsGroupsByTerm(1, 1, 2024).forEach(x-> System.out.println(x.toString()));
//			System.out.println("------------------------------------------------------------------------\n------------------------------------------------------------------------");
//			groupServiceImpl.findTeachersGroupWithCourseDTOByTerm(1, 1, 2024).forEach(x-> System.out.println(x.toString()));
//			System.out.println("------------------------------------------------------------------------\n------------------------------------------------------------------------");
//			groupServiceImpl.findStudentsGroupWithCourseDTOByTerm(1, 1, 2024).forEach(x-> System.out.println(x.toString()));
//			System.out.println("------------------------------------------------------------------------\n------------------------------------------------------------------------");
			
			//INSCRIPTIONS STIDENTS
//			System.out.println(inscriptionsStudentsServiceImpl.findInscriptionsStudentsById(1));
//			System.out.println("------------------------------------------------------------------------\n------------------------------------------------------------------------");
//			inscriptionsStudentsServiceImpl.updateScore(1, 90.30);
//			System.out.println("UPDATE");
//			System.out.println("------------------------------------------------------------------------\n------------------------------------------------------------------------");
//			System.out.println(inscriptionsStudentsServiceImpl.findInscriptionsStudentsById(1));
//			System.out.println("------------------------------------------------------------------------\n------------------------------------------------------------------------");
//			inscriptionsStudentsServiceImpl.findInscriptionsStudentsByGroupId(1).forEach(x-> System.out.println(x.toString()));
//			System.out.println("------------------------------------------------------------------------\n------------------------------------------------------------------------");
		};
	}
}
