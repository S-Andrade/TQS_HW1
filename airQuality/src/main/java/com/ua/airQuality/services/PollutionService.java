package com.ua.airQuality.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ua.airQuality.repositories.PollutionRepository;
import com.ua.airQuality.models.air.Pollution;
import java.util.List;
import java.util.Collections;

@Service
@Transactional
public class PollutionService {
    
   @Autowired
   private  PollutionRepository pollutionRepository;
   
   
   public List<Pollution>  getAllPollution() {
       return pollutionRepository.findAll();
   }
   
   public  void save(Pollution pollution){
       List<Pollution> allPollution = pollutionRepository.findAll();
       if(!allPollution.contains(pollution)){
           pollutionRepository.save(pollution);
       }
   }
   
   public List<Pollution> getPollutionByCountryAndStateAndCity(String country, String state, String city){
       return pollutionRepository.findAllPollutionByCountryAndStateAndCity(country,state,city);
   }

    public Pollution getCurrentPollution(String country, String state, String city) {
        List<Pollution> allPollution = pollutionRepository.findAllPollutionByCountryAndStateAndCity(country,state,city);
        Collections.reverse(allPollution);
        return allPollution.get(0);
    }
}
