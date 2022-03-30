package sample.multicatch;

public class TypeOneException extends AppException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7844498927774949573L;

	public TypeOneException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeOneException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public TypeOneException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public TypeOneException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public TypeOneException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public void childMethod() {
		
	}

}
