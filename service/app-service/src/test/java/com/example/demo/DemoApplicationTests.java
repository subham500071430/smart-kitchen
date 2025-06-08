package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
		"springdoc.api-docs.enabled=false",
		"springdoc.swagger-ui.enabled=false"
})
public class DemoApplicationTests {
	@Test
	void contextLoads() {}
}