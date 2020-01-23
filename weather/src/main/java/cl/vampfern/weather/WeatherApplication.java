package cl.vampfern.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Lazy;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;

import com.netflix.discovery.EurekaClient;

@SpringBootApplication
@EnableFeignClients
@EnableHypermediaSupport(type = HypermediaType.HAL)
public class WeatherApplication {
	
	@Autowired
	@Lazy
	private EurekaClient eurekaClient;

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);
	}

}
