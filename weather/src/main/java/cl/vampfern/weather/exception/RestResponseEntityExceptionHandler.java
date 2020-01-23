package cl.vampfern.weather.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
	protected ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex, WebRequest request) {
		CustomErrorResponse response = new CustomErrorResponse("Invalid request");	
		return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler(value = {MissingParamException.class})
	protected ResponseEntity<Object> handleMissingParam(MissingParamException ex, WebRequest request) {
		CustomErrorResponse response = new CustomErrorResponse(ex.getMessage());	
		return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler(value = {CityNotFoundException.class, WeatherbitIOClientNoDataException.class})
	protected ResponseEntity<Object> handleCityNotFound(RuntimeException ex, WebRequest request) {
		CustomErrorResponse response = new CustomErrorResponse(ex.getMessage());
		return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	} 
	
}
