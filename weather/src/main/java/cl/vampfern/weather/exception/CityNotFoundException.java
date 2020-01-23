package cl.vampfern.weather.exception;

public class CityNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2035596616035162891L;

	public CityNotFoundException(String message) {
		super(message);
	}
	
}
