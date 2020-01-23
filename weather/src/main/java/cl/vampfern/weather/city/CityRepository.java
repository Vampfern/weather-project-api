package cl.vampfern.weather.city;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends MongoRepository<City, String> {

	@Query("{city_name: '?0'}")
	List<City> findByCityName(String stateName);
	
}
