package cl.vampfern.weather.forecast;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.hateoas.EntityModel;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import cl.vampfern.weather.exception.WeatherbitIOClientNoDataException;
import cl.vampfern.weather.weatherbitio.DataResource;
import cl.vampfern.weather.weatherbitio.WeatherbitIOClient;

@ExtendWith(SpringExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class ForecastServiceTest {
	
	@Mock
	private WeatherbitIOClient weatherbitIOClient;
	
	@InjectMocks
	private ForecastService forecastService = new ForecastServiceImpl();
	
	@Test
	public void getDailyForecastData() throws Exception {
		EntityModel<DataResource> entityModel = new EntityModel<DataResource>(new DataResource());
		when(weatherbitIOClient.getDailyForecast(Mockito.anyLong())).thenReturn(entityModel);
		
		assertEquals(entityModel, weatherbitIOClient.getDailyForecast(1L));
	}
	
	@Test
	public void getDailyForecastDataEmptyDataException() throws Exception {
		when(weatherbitIOClient.getDailyForecast(Mockito.anyLong())).thenReturn(null);
		
		Exception exception = assertThrows(WeatherbitIOClientNoDataException.class, () -> {
			forecastService.getDailyForecastData(1L);
		});
		
		assertEquals(exception.getMessage(), "No data found for city id 1");
	}
	
}
