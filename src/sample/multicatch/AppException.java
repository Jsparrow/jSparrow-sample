package sample.multicatch;

public abstract class AppException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2581703279846697711L;
	
	
	
	public AppException() {
		super();
	}

	public AppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}



	public AppException(String message, Throwable cause) {
		super(message, cause);
	}



	public AppException(String message) {
		super(message);
	}



	public AppException(Throwable cause) {
		super(cause);
	}

	public void appExceptionMethod() {
		
	}
	

}
