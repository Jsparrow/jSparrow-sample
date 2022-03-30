package sample.junit.dedicatedAssertions;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class EqualsAndNullNessAssertions {

	private UserRepository userRepo;

	@BeforeEach
	void setUp() {
		userRepo = new UserRepoImpl();
	}

	@Test
	void equalityTesting() {
		User expected = new User(0, "John", "Snow");
		User actual = userRepo.findById(0);
		assertTrue(expected.equals(actual));
	}
	
	@Test
	void nullnessTesting() {
		User user = userRepo.findById(0);
		assertTrue(user != null);
	}
	
	@Test
	void usingConstantsAsExpectedValues() {
		User user = userRepo.findById(0);
		assertTrue(user.getFirstName().equals("John"));
	}
	
	@Test
	void comparingPrimitives() {
		User user = userRepo.findById("0");
		int actualId = user.getId();
		assertTrue(0 == actualId);
	}
	
	@Test
	void compareSame() {
		User user = userRepo.findById("0");
		User actual = userRepo.save(user);
		assertTrue(user == actual);
	}

}
