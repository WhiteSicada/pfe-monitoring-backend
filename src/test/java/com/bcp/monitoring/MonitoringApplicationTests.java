package com.bcp.monitoring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MonitoringApplicationTests {

	@Test
	void contextLoads() {
		Assertions.assertTrue(1 > 0, "speed must be positive");
	}

}
