package cl.vampfern.weather.city;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class CityTest {

	@Test
	public void testSetters() {
		City city = new City();
		city.setCity_name("Santiago");
		city.setCountry_code("CL");
		city.setCountry_name("Chile");
		city.setId("1000");
		city.setIdentifier(1L);
		city.setState_code("RM");
		city.setState_name("Metropolitana");
		
		assertEquals(city.getCity_name(), "Santiago");
		assertEquals(city.getCountry_code(), "CL");
		assertEquals(city.getCountry_name(), "Chile");
		assertEquals(city.getId(), "1000");
		assertEquals(city.getIdentifier(), 1L);
		assertEquals(city.getState_code(), "RM");
		assertEquals(city.getState_name(), "Metropolitana");
	}
	
}
