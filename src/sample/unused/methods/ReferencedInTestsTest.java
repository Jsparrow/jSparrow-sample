package sample.unused.methods;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ReferencedInTestsTest {

	@Test
	public void testRecerencesOnly() {
		UnusedPublicMethods instance = new UnusedPublicMethods();
		String value = instance.usedInTestsOnly();
		assertTrue(value.isEmpty());
	}
	
	@Test
	public void testMultipleInvocationsInSingeTest() {
		ReferencedInTests foo = new ReferencedInTests();
		foo.multipleReferencesInTheSameTestCase();
		String value = foo.multipleReferencesInTheSameTestCase();
		assertEquals("foo", value);
	}
}
