/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ua.airQuality.controllers;

import com.ua.airQuality.models.location.City;
import com.ua.airQuality.models.location.Country;
import com.ua.airQuality.models.location.State;
import com.ua.airQuality.services.CityService;
import com.ua.airQuality.services.ConsumeService;
import com.ua.airQuality.services.CountryService;
import com.ua.airQuality.services.PollutionService;
import com.ua.airQuality.services.StateService;
import com.ua.airQuality.services.WeatherService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class WebController {
      
    @Autowired
    private CountryService countryService;
    
    @Autowired
    private StateService stateService;
     
    @Autowired
    private CityService cityService;
    
    @Autowired
    private PollutionService pollutionService;
    
    @Autowired
    private WeatherService weatherService;
    
    
     
    private ConsumeService consumeService = new ConsumeService();

    @GetMapping("/")
    public String getAllCountries(Model model){
        model.addAttribute("country", "Country");
        model.addAttribute("state", "State");
        model.addAttribute("city", "City");
        model.addAttribute("visibility", "hidden");
        model.addAttribute("countries", countryService.getAllCountries());
        return "index";
    }
    
     @GetMapping(path="states/{country}")
        public String getStatesByCountry(@PathVariable(value="country") String country, Model model){
        if(stateService.getStatesByCountry(country).isEmpty()){
            consumeService.consumeStates(country, stateService);
        }
        model.addAttribute("country", country);
        model.addAttribute("state", "State");
        model.addAttribute("city", "City");
        model.addAttribute("visibility", "hidden");
        model.addAttribute("states", stateService.getStatesByCountry(country));
        return "index";
    }
    
    @GetMapping(path="cities/{country}/{state}")
    public String getCitiesByCountryAndState(@PathVariable(value="country") String country, @PathVariable(value="state") String state, Model model){
        if(cityService.getCitiesByCountryAndState(country,state).isEmpty()){
            consumeService.consumeCities(state, country,cityService);
        }
        model.addAttribute("country", country);
        model.addAttribute("state", state);
        model.addAttribute("city", "City");
        model.addAttribute("visibility", "hidden");
        model.addAttribute("cities", cityService.getCitiesByCountryAndState(country,state));
        return "index";
    } 
    
    @GetMapping(path="currentAirQuality/{country}/{state}/{city}")
    public String getCurrentAirQuality(@PathVariable(value="country") String country, @PathVariable(value="state") String state, @PathVariable(value="city") String city,Model model){
        consumeService.consumeAirQuality(city, state, country, pollutionService, weatherService);
        
        model.addAttribute("country", country);
        model.addAttribute("state", state);
        model.addAttribute("city", city);
        model.addAttribute("visibility", "visible");
        model.addAttribute("pollution",pollutionService.getCurrentPollution(country,state,city));
        model.addAttribute("weather",weatherService.getCurrentWeather(country,state,city));
        return "index";
    }
}
