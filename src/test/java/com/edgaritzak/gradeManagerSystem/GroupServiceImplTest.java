package com.edgaritzak.gradeManagerSystem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import com.edgaritzak.gradeManagerSystem.service.GroupServiceImpl;

@SpringBootTest
@ComponentScan
public class GroupServiceImplTest {
	
	@Autowired
    private GroupServiceImpl groupServiceImpl;
	
	@Test 
	void test_Group_findGroupById() {
		try {groupServiceImpl.findGroupById(1);}
		catch(Exception e) {org.junit.jupiter.api.Assertions.fail("Exception thrown during safeOperation: " + e.getMessage());}
	}
	@Test 
	void test_Group_findTeachersGroups() {
		try {groupServiceImpl.findTeachersGroups(1);}
		catch(Exception e) {org.junit.jupiter.api.Assertions.fail("Exception thrown during safeOperation: " + e.getMessage());}
	}
	@Test 
	void test_Group_findTeachersGroupsByTerm() {
		try {groupServiceImpl.findTeachersGroupsByTerm(1, 1, 2024);}
		catch(Exception e) {org.junit.jupiter.api.Assertions.fail("Exception thrown during safeOperation: " + e.getMessage());}
	}
	@Test
	void test_Group_findStudentsGroups() {
		try {groupServiceImpl.findStudentsGroups(1);}
		catch(Exception e) {org.junit.jupiter.api.Assertions.fail("Exception thrown during safeOperation: " + e.getMessage());}
	}
	@Test 
	void test_Group_findStudentsGroupsByTerm() {
		try {groupServiceImpl.findStudentsGroupsByTerm(1, 1, 2024);}
		catch(Exception e) {org.junit.jupiter.api.Assertions.fail("Exception thrown during safeOperation: " + e.getMessage());}
	}
	@Test 
	void test_Group_findTeachersGroupWithCourseDTOByTerm() {
		try {groupServiceImpl.findTeachersGroupWithCourseDTOByTerm(1, 1, 2024);}
		catch(Exception e) {org.junit.jupiter.api.Assertions.fail("Exception thrown during safeOperation: " + e.getMessage());}
	}
	@Test 
	void test_Group_findStudentsGroupWithCourseDTOByTerm() {
		try {groupServiceImpl.findStudentsGroupWithCourseDTOByTerm(1, 1, 2024);}
		catch(Exception e) {org.junit.jupiter.api.Assertions.fail("Exception thrown during safeOperation: " + e.getMessage());}
	}
	
}
