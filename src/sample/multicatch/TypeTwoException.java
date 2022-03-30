package sample.multicatch;

public class TypeTwoException extends AppException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6924455773464574884L;

	public TypeTwoException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeTwoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public TypeTwoException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public TypeTwoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public TypeTwoException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public void childMethod() {
		
	}

}
