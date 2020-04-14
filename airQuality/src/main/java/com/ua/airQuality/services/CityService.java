package com.ua.airQuality.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ua.airQuality.repositories.CityRepository;
import com.ua.airQuality.models.location.City;
import java.util.List;

@Service
@Transactional
public class CityService {
    
   @Autowired
   private CityRepository cityRepository;
   
   
   public List<City>  getAllCities() {
       return cityRepository.findAll();
   }
   
   public void save(City city){
       List<City> allCities = cityRepository.findAll();
       if(!allCities.contains(city)){
            cityRepository.save(city);
       }     
       
   }
   
   public List<City> getCitiesByCountryAndState(String country, String state){
       return cityRepository.findAllByCountryAndState(country,state);
   }

    
}
