package com.ua.airQuality;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ua.airQuality.models.air.AirQuality;
import com.ua.airQuality.models.air.AirQualityData;
import com.ua.airQuality.models.air.Current;
import com.ua.airQuality.models.air.Pollution;
import com.ua.airQuality.models.air.Weather;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import com.ua.airQuality.repositories.CountryRepository;
import com.ua.airQuality.models.location.Countries;
import com.ua.airQuality.models.location.Country;
import com.ua.airQuality.repositories.StateRepository;
import com.ua.airQuality.models.location.States;
import com.ua.airQuality.models.location.State;
import com.ua.airQuality.repositories.CityRepository;
import com.ua.airQuality.models.location.Cities;
import com.ua.airQuality.models.location.City;
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
                
               /* States states = s.consumeStates("Portugal");
                for (State sta : states.getData()){
                    stateRepository.save(sta);
                }
                
                Cities cities = s.consumeCities("Aveiro","Portugal");
                for (City c : cities.getData()){
                    cityRepository.save(c);
                }
                
                AirQuality aq = s.consumeAirQuality("Aveiro", "Aveiro", "Portugal");
                System.out.println(aq.toString());
                AirQualityData aqd = aq.getData();
                Current c = aqd.getCurrent();
                Weather w = c.getWeather();
                w.setCity("Aveiro");
                w.setState("Aveiro");
                w.setCountry("Portugal");
                weatherRepository.save(w);
                Pollution p = c.getPollution();
                p.setCity("Aveiro");
                p.setState("Aveiro");
                p.setCountry("Portugal");
                pollutionRepository.save(p);*/
                
               
          };
        }
        
        
        

}
