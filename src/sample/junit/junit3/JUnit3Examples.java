package sample.junit.junit3;

import junit.framework.TestCase;
import junit.textui.TestRunner;

public class JUnit3Examples extends TestCase {
	
	public void testFail() {
		fail();
	}
	
	public void testPass() {
		assertTrue(true);
	}
	
	
	public static void main(String[]args) {
		TestRunner.run(JUnit3Examples.class);
	}

}
