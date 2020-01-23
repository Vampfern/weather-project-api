package cl.vampfern.weather.forecast;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import cl.vampfern.weather.exception.WeatherbitIOClientNoDataException;
import cl.vampfern.weather.weatherbitio.DataResource;
import cl.vampfern.weather.weatherbitio.WeatherbitIOClient;

@Service
public class ForecastServiceImpl implements ForecastService {
	
	@Autowired
	WeatherbitIOClient weatherbitIOClient;

	@Override
	public Object getDailyForecastData(Long city_id) {
		
		EntityModel<DataResource> data = weatherbitIOClient.getDailyForecast(city_id);
		
		if (Objects.isNull(data)) {
			throw new WeatherbitIOClientNoDataException("No data found for city id " + city_id);
		}
		
		return data.getContent().getData();
	}

}
