package sample.unused.fields;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestingUnusedMethods {
	
	@Test
	void test() {
		UnusedMethods um = new UnusedMethods();
		um.publicUnusedTestedMethod();
		assertTrue(true);
	}

}
