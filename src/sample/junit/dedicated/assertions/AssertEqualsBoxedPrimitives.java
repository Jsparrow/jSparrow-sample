package sample.junit.dedicated.assertions;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class AssertEqualsBoxedPrimitives {
	
	@Test
	public void comparingBoxedWithUnboxedPrimitives() {
Integer i = 10;
assertTrue(i == 10);
		assertTrue(i.equals(10));

		Character c = 'C';
		assertTrue(c.equals('c'));
	}

}
