
package com.ua.airQuality.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ua.airQuality.repositories.CountryRepository;
import com.ua.airQuality.models.location.Country;
import java.util.List;

@Service
@Transactional
public class CountryService {
    
   @Autowired
   private CountryRepository countryRepository;
   
   
   public List<Country>  getAllCountries() {
       return countryRepository.findAll();
   }
   
   public void save(Country country){
       List<Country> allCountries = countryRepository.findAll();
       if(!allCountries.contains(country)){
           countryRepository.save(country);
       }
   }
}
