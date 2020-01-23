package cl.vampfern.weather.city;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class CityServiceTest {

	@Mock
	private CityRepository cityRepository;
	
	@InjectMocks
	private CityService cityService = new CityServiceImpl();
	
	@Test
	public void getAll() throws Exception {
		List<City> cities = new ArrayList<City>();
		City city = new City();
		city.setCity_name("Santiago");
		cities.add(city);
		
		when(cityService.getAll()).thenReturn(cities);
		
		assertEquals(cities, cityService.getAll());
	}
	
	@Test
	public void findByCityName() throws Exception {
		List<City> cities = new ArrayList<City>();
		City city = new City();
		city.setCity_name("Santiago");
		cities.add(city);
		
		when(cityService.findByCityName(Mockito.anyString())).thenReturn(cities);
		
		assertEquals(cities, cityService.findByCityName("santiago"));
	}
	
}
