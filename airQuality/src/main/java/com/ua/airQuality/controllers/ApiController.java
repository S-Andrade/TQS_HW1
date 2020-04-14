package com.ua.airQuality.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ua.airQuality.services.ConsumeService;
import com.ua.airQuality.services.CityService;
import com.ua.airQuality.services.StateService;
import com.ua.airQuality.services.CountryService;
import com.ua.airQuality.models.location.Cities;
import com.ua.airQuality.models.location.City;
import com.ua.airQuality.models.location.States;
import com.ua.airQuality.models.location.State;
import com.ua.airQuality.models.location.Country;
import com.ua.airQuality.models.air.AirQuality;
import com.ua.airQuality.models.air.Pollution;
import com.ua.airQuality.models.air.Weather;
import com.ua.airQuality.services.PollutionService;
import com.ua.airQuality.services.WeatherService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api")
public class ApiController {
    
    @Autowired
    private CityService cityService;
    
    @Autowired
    private StateService stateService;
    
    @Autowired
    private CountryService countryService;
    
    @Autowired
    private PollutionService pollutionService;
    
    @Autowired
    private WeatherService weatherService;
    
    private ConsumeService consumeService = new ConsumeService();
    
        
    @GetMapping(path="allCountries")
    public List<Country> getAllCountries(){ 
        return countryService.getAllCountries();
    }
    
    @GetMapping(path="allStates")
    public List<State> getAllStates(){
        return stateService.getAllStates();
    }
    
    @GetMapping(path="states/{country}")
    public List<State> getStatesByCountry(@PathVariable(value="country") String country){
        if(stateService.getStatesByCountry(country).isEmpty()){
            consumeService.consumeStates(country, stateService);
        }
        return stateService.getStatesByCountry(country);
    }
    
    
    @GetMapping(path="allCities")
    public List<City> getAllCities(){
        return cityService.getAllCities();
    }
    
    @GetMapping(path="cities/{country}/{state}")
    public List<City> getCitiesByCountryAndState(@PathVariable(value="country") String country, @PathVariable(value="state") String state){
        if(cityService.getCitiesByCountryAndState(country,state).isEmpty()){
            consumeService.consumeCities(state, country,cityService);
        }
        return cityService.getCitiesByCountryAndState(country,state);
    }      
        
    @GetMapping(path="allPollution")
    public List<Pollution> getAllPollution(){
        return pollutionService.getAllPollution();
    }
    
    @GetMapping(path="pollution/{country}/{state}/{city}")
    public List<Pollution> getPollutionByCountryAndStateAndCity(@PathVariable(value="country") String country, @PathVariable(value="state") String state,@PathVariable(value="city") String city){
        if(pollutionService.getPollutionByCountryAndStateAndCity(country,state,city).isEmpty()){
            consumeService.consumeAirQuality(city, state, country, pollutionService, weatherService);
        }
        return pollutionService.getPollutionByCountryAndStateAndCity(country,state,city);
    }
    
    @GetMapping(path="currentPollution/{country}/{state}/{city}")
    public Pollution getCurrentPollution(@PathVariable(value="country") String country, @PathVariable(value="state") String state,@PathVariable(value="city") String city){
      consumeService.consumeAirQuality(city, state, country, pollutionService, weatherService);
      return pollutionService.getCurrentPollution(country,state,city);
    }
    
    @GetMapping(path="allWeather")
    public List<Weather> getAllWeather(){
        return weatherService.getAllWeather();
    }
   
    @GetMapping(path="weather/{country}/{state}/{city}")
    public List<Weather> getWeatherByCountryAndStateAndCity(@PathVariable(value="country") String country, @PathVariable(value="state") String state,@PathVariable(value="city") String city){
        if(weatherService.getWeatherByCountryAndStateAndCity(country,state,city).isEmpty()){
            consumeService.consumeAirQuality(city, state, country, pollutionService, weatherService);
        }
        return weatherService.getWeatherByCountryAndStateAndCity(country,state,city);
    }
    
    @GetMapping(path="currentWeather/{country}/{state}/{city}")
    public Weather getCurrentWeather(@PathVariable(value="country") String country, @PathVariable(value="state") String state,@PathVariable(value="city") String city){
      consumeService.consumeAirQuality(city, state, country, pollutionService, weatherService);
      return weatherService.getCurrentWeather(country,state,city);
    }
}
