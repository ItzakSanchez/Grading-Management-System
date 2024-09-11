package com.edgaritzak.gradeManagerSystem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import com.edgaritzak.gradeManagerSystem.service.InscriptionsStudentsServiceImpl;

@SpringBootTest
@ComponentScan
public class InscriptionsStudentsServiceImplTest {

	@Autowired
    private InscriptionsStudentsServiceImpl inscriptionsStudentsServiceImpl;
	
	@Test 
	void test_InscriptionsStudents_updateScore() {
		try {inscriptionsStudentsServiceImpl.updateScore(1, 90.30);}
		catch(Exception e) {org.junit.jupiter.api.Assertions.fail("Exception thrown during safeOperation: " + e.getMessage());}
	}
	@Test 
	void test_InscriptionsStudents_findInscriptionsStudentsById() {
		try {inscriptionsStudentsServiceImpl.findInscriptionsStudentsById(1);}
		catch(Exception e) {org.junit.jupiter.api.Assertions.fail("Exception thrown during safeOperation: " + e.getMessage());}
	}
	@Test 
	void test_InscriptionsStudents_findStudentsByGroup() {
		try {inscriptionsStudentsServiceImpl.findInscriptionsStudentsByGroupId(1);}
		catch(Exception e) {org.junit.jupiter.api.Assertions.fail("Exception thrown during safeOperation: " + e.getMessage());}
	}
	
	
	
	
}
