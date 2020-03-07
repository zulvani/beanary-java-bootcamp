package com.beanary.rest.restbasic;

import com.beanary.rest.restbasic.service.ArithmeticService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestBasicApplicationTests {
	@Autowired
	ArithmeticService arithmeticService;

	@Test
	void testAddSuccess() {
		Assertions.assertEquals(10, arithmeticService.add(5,5 ));
	}

}
