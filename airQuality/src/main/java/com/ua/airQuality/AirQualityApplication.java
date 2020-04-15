package com.ua.airQuality;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import com.ua.airQuality.repositories.CountryRepository;
import com.ua.airQuality.models.location.Countries;
import com.ua.airQuality.models.location.Country;
import com.ua.airQuality.repositories.StateRepository;
import com.ua.airQuality.repositories.CityRepository;
import com.ua.airQuality.repositories.PollutionRepository;
import com.ua.airQuality.repositories.WeatherRepository;
import com.ua.airQuality.services.ConsumeService;



@SpringBootApplication
public class AirQualityApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirQualityApplication.class, args);
	}
        
        
        @Bean
        public CommandLineRunner demo(CountryRepository countryRepository, StateRepository stateRepository, CityRepository cityRepository, PollutionRepository pollutionRepository, WeatherRepository weatherRepository) {
          return (args) -> {
                ConsumeService s = new ConsumeService();
                
                Countries countries = s.consumeCountries();
                for (Country c : countries.getData()){
                    countryRepository.save(c);
                }
  
          };
        }
        
        
        

}
