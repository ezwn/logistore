package logistore;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import logistore.controllers.StatusController;

@ActiveProfiles("test")
@SpringBootTest
public class ApplicationTest {

	@Autowired
	private StatusController controller;
	
	@Test
	public void contextLoads() {
		assertNotNull(controller);
	}
	
}
