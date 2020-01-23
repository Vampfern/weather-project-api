package cl.vampfern.weather.weatherbitio;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "weatherbitioclient", url = "http://api.weatherbit.io/v2.0/forecast/")
public interface WeatherbitIOClient {

	@RequestMapping(method = RequestMethod.GET, value = "/daily?key=44644f4eb4574ccb9c05731c721b7e24&days=7&city_id={city_id}")
	EntityModel<DataResource> getDailyForecast(@RequestParam(value = "city_id") Long city_id);

}
