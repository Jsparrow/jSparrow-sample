package sample.junit;

import static org.junit.Assert.*;

import org.junit.jupiter.api.*;

public class NestedClasses {
	
	@Test
	public void testFoo() {
		fail();
	}
	
	@Nested
	public class JUnit4Test {
		
		@Test
		public void testFoo2() {
			fail();
		}
	}

}
