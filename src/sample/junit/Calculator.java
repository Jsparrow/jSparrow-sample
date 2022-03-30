package sample.junit;

public class Calculator {
	
	public int add(int a, int b) {
		return a + b;
	}

	/**
	 * Not so accurate division method. 
	 * 
	 * @param dividend
	 * @param divisor
	 * @return an int, so try to not get fractions as a result!
	 * @throws CalculatorException 
	 */
	public int divide(int dividend, int divisor) throws DivisionByZeroException {
		try {
			return dividend / divisor;
		} catch (ArithmeticException e) {
			throw new DivisionByZeroException(e.getMessage());
		}
	}
}
