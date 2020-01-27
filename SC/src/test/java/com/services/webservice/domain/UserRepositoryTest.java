package com.services.webservice.domain;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@AfterAll
	public void cleanUp() {
		userRepository.deleteAll();
	}
	
	@Test
	public void userDataCheck() {
		userRepository.save(User.builder()
				.studentNum(2019631001)
				.name("±èµ¿¹Î")
				.phoneNumber("01027703108")
				.build());
		
		User user = (userRepository.findAll()).get(0);
		
		assertEquals(user.getName(), "±èµ¿¹Î");
		
	}
}
