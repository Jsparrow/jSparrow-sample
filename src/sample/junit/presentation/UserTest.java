package sample.junit.presentation;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserTest {
	
	@Test
	public void find() {
		User expected = new User("10", "Lorenzo", "Insigne");
		User actual = userRepo.findById(10);
		assertThat(expected, equalTo(actual));
	}
	
	UserRepository invalidUserRepository = new UserRepository();
	UserRepository userRepo = new UserRepository();
	
	@Test
	public void find2() {
		User actual = new User("10", "Lorenzo", "Insigne");
		User expected = userRepo.findById(10);
		assertEquals(expected, actual, "Expecting Insigne");
	}
	
	

	
	@Test
	public void userTest() {
		
	}
	
	@Test
	void invalidUserRepository() {
	    User user = new User("10", "Lorenzo", "Insigne");
	    assertThrows(PersistenceException.class, () -> invalidUserRepository.save(user));
	}
	
	@Test(timeout=100)
	public void timeoutTest2() throws PersistenceException {
		userRepo.save(new User("10", "Lorenzo", "Insigne"));
	}
	
	@Test
	public void timeoutTest() {
		assertTimeout(ofMillis(100), () -> userRepo.save(new User("10", "Lorenzo", "Insigne")));
	}
}
