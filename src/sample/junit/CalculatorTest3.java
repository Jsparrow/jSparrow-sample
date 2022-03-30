package sample.junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class CalculatorTest3 {

	@Test
	void divideByZero() {
		Calculator calculator = new Calculator();
		assertThrows(DivisionByZeroException.class, () -> calculator.divide(1, 0));
		fail();
	}
}
