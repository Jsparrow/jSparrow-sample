package sample.junit;

public class CalculatorException extends Exception {

	private static final long serialVersionUID = 7212940875245428881L;

	public CalculatorException() {
		super();
	}

	public CalculatorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CalculatorException(String message, Throwable cause) {
		super(message, cause);
	}

	public CalculatorException(String message) {
		super(message);
	}

	public CalculatorException(Throwable cause) {
		super(cause);
	}
	
}
