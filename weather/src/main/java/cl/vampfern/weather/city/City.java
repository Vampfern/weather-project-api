package cl.vampfern.weather.city;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "cities")
@Getter
@Setter
public class City {

	@JsonIgnore
	@Id
	private String id;

	@Field(name = "id")
	private Long identifier;
	private String city_name;
	private String state_code;
	private String state_name;
	private String country_code;
	private String country_name;
	
}
