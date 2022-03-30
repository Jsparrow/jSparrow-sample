package sample.junit.dedicated.assertions;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class JupiterAssertionsBoxedWithPrimitive {
	
	@Test
	public void boxedVsUnboxed() {
		Integer i = 10;
		int j = 10;
		int k = 10;
		int l = 10;
		assertTrue(i == j);
		assertTrue(i == j == false);
		assertTrue(j == i);
		assertTrue(i.equals(j));
		
	}
	
	@Test
	public void boxedVsUnboxed2() {
		Integer i = 10;
		int j = 10;
		assertEquals(i, j, "");
		assertEquals(j, i, "");
		assertTrue(i == j);
		assertTrue(j == i);
		assertTrue(i.equals(j));
		
	}

}
