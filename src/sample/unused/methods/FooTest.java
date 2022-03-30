package sample.unused.methods;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FooTest {
	
	@Test
	public void testMultipleInvocationsInSingeTest2() {
		ReferencedInTests foo = new ReferencedInTests();
		foo.multipleReferencesInTheSameTestCase();
		String value = foo.multipleReferencesInTheSameTestCase();
		assertEquals("foo", value);
	}
	
	@Test
	public void test() {
		
	}
	
	@Test
	public void testMultipleInvocationsInSingeTest() {
		ReferencedInTests foo = new ReferencedInTests();
		foo.multipleReferencesInTheSameTestCase();
		String value = foo.multipleReferencesInTheSameTestCase();
		assertEquals("foo", value);
	}
	
	@Test
	public void test2() {
		UnusedPublicFieldsAndMethods object = new UnusedPublicFieldsAndMethods();
		object.usedIntestsOnly();
	}

}
