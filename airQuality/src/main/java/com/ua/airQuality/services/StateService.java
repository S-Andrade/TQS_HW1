
package com.ua.airQuality.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ua.airQuality.repositories.StateRepository;
import com.ua.airQuality.models.location.State;
import java.util.List;

@Service
@Transactional
public class StateService {
    
   @Autowired
   private StateRepository stateRepository;
   
   
   public List<State>  getAllStates() {
       return stateRepository.findAll();
   }
   
   public void save(State state){
       List<State> allStates = stateRepository.findAll();
       if(!allStates.contains(state)){
           stateRepository.save(state);
       }
   }
   
   public List<State> getStatesByCountry(String country){
       return stateRepository.findAllByCountry(country);
   }
}
