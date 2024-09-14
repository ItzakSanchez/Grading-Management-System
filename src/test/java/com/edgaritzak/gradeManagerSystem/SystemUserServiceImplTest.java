package com.edgaritzak.gradeManagerSystem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import com.edgaritzak.gradeManagerSystem.service.SystemUserServiceImpl;

@SpringBootTest
@ComponentScan
public class SystemUserServiceImplTest {
	
	@Autowired
    private SystemUserServiceImpl systemUserImpl;
	
	
	@Test 
	void test_SystemUser_findStudentsByGroup() {
		try {systemUserImpl.findStudentsByGroup(1);}
		catch(Exception e) {org.junit.jupiter.api.Assertions.fail("Exception thrown during safeOperation: " + e.getMessage());}
	}
	@Test 
	void test_SystemUser_findByEmail() {
		try {systemUserImpl.findByEmail("alice.johnson@example.com");}
		catch(Exception e) {org.junit.jupiter.api.Assertions.fail("Exception thrown during safeOperation: " + e.getMessage());}
	}
	@Test 
	void test_SystemUser_findTeacherById() {
		try {systemUserImpl.findTeacherById(1);}
		catch(Exception e) {org.junit.jupiter.api.Assertions.fail("Exception thrown during safeOperation: " + e.getMessage());}
	}
	@Test 
	void test_SystemUser_findStudentById() {
		try {systemUserImpl.findStudentById(1);}
		catch(Exception e) {org.junit.jupiter.api.Assertions.fail("Exception thrown during safeOperation: " + e.getMessage());}
	}
	@Test 
	void test_SystemUser_findUserById() {
		try {systemUserImpl.findUserById(1);}
		catch(Exception e) {org.junit.jupiter.api.Assertions.fail("Exception thrown during safeOperation: " + e.getMessage());}
	}
	@Test 
	void test_SystemUser_findStudentsWithScoreByGroup() {
		try {systemUserImpl.findStudentsWithScoreByGroup(1);}
		catch(Exception e) {org.junit.jupiter.api.Assertions.fail("Exception thrown during safeOperation: " + e.getMessage());}
	}
	@Test
	void test_SystemUser_findAll() {
		try {systemUserImpl.findAll();}
		catch(Exception e) {org.junit.jupiter.api.Assertions.fail("Exception thrown during safeOperation: " + e.getMessage());}
	}
	
}
