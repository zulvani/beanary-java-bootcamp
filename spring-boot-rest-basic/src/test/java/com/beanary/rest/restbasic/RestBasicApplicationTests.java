package com.beanary.rest.restbasic;

import com.beanary.rest.restbasic.dto.UserAccountDto;
import com.beanary.rest.restbasic.model.UserAccount;
import com.beanary.rest.restbasic.service.ArithmeticService;
import com.beanary.rest.restbasic.service.UserAccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestBasicApplicationTests {

	@Autowired
	UserAccountService userAccountService;

	@Autowired
	ArithmeticService arithmeticService;

	@LocalServerPort
	int randomServerPort;

	@Test
	void testAddSuccess() {
		Assertions.assertEquals(10, arithmeticService.add(5,5 ));
	}

	@Test
	void testRegisterSuccess()  {
		UserAccount ua = userAccountService.post("test@gmail.com", "Test", "abcdef");
		Assertions.assertNotNull(ua.getId());
		Assertions.assertTrue(ua.getId() > 0);
	}

	@Test
	public void testAddEmployeeSuccess() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:"+randomServerPort+"/useraccounts/";
		URI uri = new URI(baseUrl);

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");

		UserAccountDto dto = new UserAccountDto();
		dto.setName("Test");
		dto.setEmail("test@gmail.com");
		dto.setPassword("!23456");
		HttpEntity<UserAccountDto> request = new HttpEntity<>(dto, headers);

		ResponseEntity<UserAccount> result = restTemplate.postForEntity(uri, request, UserAccount.class);

		Assertions.assertEquals(200, result.getStatusCodeValue());
		Assertions.assertTrue(result.getBody().getId() > 0);
		Assertions.assertTrue(result.getBody().getName().equals("Test"));
	}
}
