package cl.vampfern.weather.city;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import cl.vampfern.weather.forecast.ForecastService;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class CityControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ForecastService forecastService;
	
	@MockBean
	private CityService cityService;
	
	@Test
	public void getAll() throws Exception {
		List<City> cities = new ArrayList<City>();
		City city = new City();
		city.setCity_name("Santiago");
		cities.add(city);
		
		given(cityService.getAll()).willReturn(cities);
		
		this.mockMvc.perform(get("/api/city"))
        .andExpect(status().isOk())
        .andExpect(content().json("[{'identifier':null,'city_name':'Santiago','state_code':null,'state_name':null,'country_code':null,'country_name':null}]"));
	}
	
	@Test
	public void getCitiesByName() throws Exception {
		List<City> cities = new ArrayList<City>();
		City city = new City();
		city.setCity_name("Santiago");
		cities.add(city);
		
		given(cityService.findByCityName(Mockito.anyString())).willReturn(cities);
		
		this.mockMvc.perform(get("/api/city/santiago"))
        .andExpect(status().isOk())
        .andExpect(content().json("[{'identifier':null,'city_name':'Santiago','state_code':null,'state_name':null,'country_code':null,'country_name':null}]"));
	}
	
	@Test
	public void getCitiesByNameNotFound() throws Exception {
		List<City> cities = new ArrayList<City>();
		
		given(cityService.findByCityName(Mockito.anyString())).willReturn(cities);
		
		this.mockMvc.perform(get("/api/city/santiago"))
        .andExpect(status().isNotFound())
        .andExpect(content().json("{'message':'No cities were found with city name: santiago'}"));
	}
	
}
