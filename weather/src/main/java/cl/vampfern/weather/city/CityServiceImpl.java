package cl.vampfern.weather.city;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class CityServiceImpl implements CityService {
	
	CityRepository cityRepository;
	
	@Autowired
	public CityServiceImpl(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Override
	public List<City> findByCityName(String stateName) {
		return cityRepository.findByCityName(stateName);
	}

	@Override
	public List<City> getAll() {
		return cityRepository.findAll();
	}

}
