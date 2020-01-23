package cl.vampfern.weather.city;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.vampfern.weather.exception.CityNotFoundException;

@RestController
@RequestMapping("/api/city")
public class CityController {
	
	@Autowired
	CityService cityService;

	@GetMapping
	public ResponseEntity<List<City>> getCities() {
		return new ResponseEntity<List<City>>(cityService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{city_name}")
	public ResponseEntity<List<City>> getCitiesByName(@PathVariable String city_name) {
		List<City> cities = cityService.findByCityName(city_name);
		
		if( Objects.isNull(cities) || cities.isEmpty()) {
			throw new CityNotFoundException("No cities were found with city name: " + city_name);
		}
		
		return new ResponseEntity<List<City>>(cities, HttpStatus.OK);
	}
}
