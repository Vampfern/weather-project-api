package cl.vampfern.weather.exception;

public class MissingParamException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5131058443891969111L;

	public MissingParamException(String message) {
		super(message);
	}
	
}
