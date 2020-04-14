package com.ua.airQuality.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ua.airQuality.repositories.WeatherRepository;
import com.ua.airQuality.models.air.Weather;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class WeatherService {
    
   @Autowired
   private  WeatherRepository weatherRepository;
   
   
   public List<Weather>  getAllWeather() {
       return weatherRepository.findAll();
   }
   
   public void save(Weather weather){
       List<Weather> allWeather = weatherRepository.findAll();
       if(!allWeather.contains(weather)){
           weatherRepository.save(weather);
       }
   }
   
   public List<Weather> getWeatherByCountryAndStateAndCity(String country, String state, String city){
       return weatherRepository.findAllWeatherByCountryAndStateAndCity(country,state,city);
   }

    public Weather getCurrentWeather(String country, String state, String city) {
        List<Weather> allWeather = weatherRepository.findAllWeatherByCountryAndStateAndCity(country,state,city);
        Collections.reverse(allWeather);
        return allWeather.get(0);
    }
}
