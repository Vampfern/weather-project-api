package cl.vampfern.weather.city;

import java.util.List;

public interface CityService {
	
	List<City> findByCityName(String stateName);
	List<City> getAll();
	
}
