package cl.vampfern.weather.forecast;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.vampfern.weather.exception.MissingParamException;

@RestController
@RequestMapping("/api/forecast")
public class ForecastController {

	ForecastService service;
	
	public ForecastController(ForecastService service) {
		this.service = service;
	}
	
	@GetMapping(value = {"/", "/{city_id}"})
	public ResponseEntity<?> getForecasts(@PathVariable(required = false) Long city_id){
		if ( Objects.isNull(city_id) ) {
			throw new MissingParamException("Parameter city_id cannot be empty");
		}
		
		return new ResponseEntity<Object>(service.getDailyForecastData(city_id), HttpStatus.OK);
	}
	
}
