package com.gentech.unittesting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.gentech.unittesting.repository.StudentRepositoryTest;
import com.gentech.unittesting.service.StudentServiceTest;

@SpringBootTest(classes = {StudentRepositoryTest.class, StudentServiceTest.class})
class UnittestingSpringbootStudentApplicationTests {

	@Test
	void contextLoads() {
	}

}
