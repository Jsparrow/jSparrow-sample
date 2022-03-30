package sample.junit;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.ExpectedException;

public class FieldsNeedNotBeEffectivelyFInal {

	private FileFinder fileFinder;

	private Calculator calculator;
	
	@Before
	public void init() {
		fileFinder = new FileFinder();
	}

	@Test(expected = IOException.class)
	public void test_fileFinder() throws IOException {
		fileFinder.find(null);
	}

	
	@Before
	public void initCalc() {
		calculator = new Calculator();
	}
	
	@Rule
	ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void divideByZero2() throws DivisionByZeroException {
		expectedException.expect(DivisionByZeroException.class);
		calculator.divide(1, 0);
		fail();
	}

	@Test(expected = DivisionByZeroException.class)
	public void divideByZero() throws DivisionByZeroException {
		calculator.divide(1, 0);
		fail();
	}

	@Test
	public void divideByZero3() {
		Assertions.assertThrows(DivisionByZeroException.class, () -> calculator.divide(1, 0));
		fail();
	}
}
