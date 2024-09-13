package com.edgaritzak.gradeManagerSystem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import com.edgaritzak.gradeManagerSystem.service.UserSessionServiceImpl;

@SpringBootTest
@ComponentScan
public class SessionServiceImplTest {

	@Autowired
    private UserSessionServiceImpl sessionServiceImpl;
	
	@Test 
	void test_SessionService_updateScore() {
		try {sessionServiceImpl.findUserWithRoleDTOByEmail("judy.hopps@example.com");}
		catch(Exception e) {org.junit.jupiter.api.Assertions.fail("Exception thrown during safeOperation: " + e.getMessage());}
	}
	
}
