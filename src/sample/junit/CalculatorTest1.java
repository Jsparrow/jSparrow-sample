package sample.junit;

import static org.junit.Assert.fail;

import org.junit.*;
import org.junit.rules.ExpectedException;

public class CalculatorTest1 {
	@Rule
	ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void testDivision() throws DivisionByZeroException {
		Calculator calculator = new Calculator();
		expectedException.expect(DivisionByZeroException.class);
		calculator.divide(1, 0);
		fail();
	}
}
