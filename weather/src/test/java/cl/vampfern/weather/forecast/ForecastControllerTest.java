package cl.vampfern.weather.forecast;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import cl.vampfern.weather.city.CityService;
import cl.vampfern.weather.weatherbitio.DataResource;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class ForecastControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ForecastService forecastService;
	
	@MockBean
	private CityService cityService;
	
	@Test
	public void getForecasts() throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", "value");
		
		DataResource dataResource = new DataResource();
		dataResource.setData(map);
		
		given(forecastService.getDailyForecastData(Mockito.anyLong())).willReturn(dataResource);
		
		this.mockMvc.perform(get("/api/forecast/1"))
        .andExpect(status().isOk())
        .andExpect(content().json("{'data':{'key':'value'}}"));
	}

	@Test
	public void getForecastsWithNoParam() throws Exception {
		given(forecastService.getDailyForecastData(Mockito.anyLong())).willReturn(new Object());
		
		this.mockMvc.perform(get("/api/forecast/"))
        .andExpect(status().is4xxClientError())
        .andExpect(content().json("{'message':'Parameter city_id cannot be empty'}"));
	}
	
	@Test
	public void getForecastsWithInvalidParam() throws Exception {
		given(forecastService.getDailyForecastData(Mockito.anyLong())).willReturn(new Object());
		
		this.mockMvc.perform(get("/api/forecast/letters"))
        .andExpect(status().is4xxClientError())
        .andExpect(content().json("{'message':'Invalid request'}"));
	}

}
