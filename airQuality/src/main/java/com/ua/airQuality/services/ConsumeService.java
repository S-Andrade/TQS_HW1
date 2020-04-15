package com.ua.airQuality.services;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import com.ua.airQuality.models.location.Countries;
import com.ua.airQuality.models.location.States;
import com.ua.airQuality.models.location.State;
import com.ua.airQuality.models.location.Cities;
import com.ua.airQuality.models.location.City;
import com.ua.airQuality.models.air.AirQuality;
import com.ua.airQuality.models.air.AirQualityData;
import com.ua.airQuality.models.air.Current;
import com.ua.airQuality.models.air.Pollution;
import com.ua.airQuality.models.air.Weather;

@Stateless
public class ConsumeService {
    
   private String key = "2c545c24-9c0a-4850-b7bb-e194d4fe71ea";

    
   public Countries consumeCountries(){
       
       String targetUrl = "http://api.airvisual.com/v2/countries?&key="+key;
       
       Client client = ClientBuilder.newClient();
       Response response = client.target(targetUrl).request().get();
       Countries c = response.readEntity(Countries.class);
       
       response.close();
       client.close();

       return c;
   } 
   
   public States consumeStates(String country, StateService stateService){
       
       String targetUrl = "http://api.airvisual.com/v2/states?country="+ country +"&?&key="+key;
       
       Client client = ClientBuilder.newClient();
       Response response = client.target(targetUrl).request().get();
       States s = response.readEntity(States.class);
       
       for (State state : s.getData()){
           state.setCountry(country);
           stateService.save(state);
       }

       response.close();
       client.close();

       return s;
   } 
   
   public States consumeStates(String country){
       
       String targetUrl = "http://api.airvisual.com/v2/states?country="+ country +"&?&key="+key;
       
       Client client = ClientBuilder.newClient();
       Response response = client.target(targetUrl).request().get();
       States s = response.readEntity(States.class);
       
       for (State state : s.getData()){
           state.setCountry(country);
       }

       response.close();
       client.close();

       return s;
   } 
   
   public Cities consumeCities(String state, String country, CityService cityService){
       
       String targetUrl = "http://api.airvisual.com/v2/cities?state="+state+"&country="+country+"&key="+key;
       
       Client client = ClientBuilder.newClient();
       Response response = client.target(targetUrl).request().get();
       Cities c = response.readEntity(Cities.class);
       
       for (City city : c.getData()){
           city.setCountry(country);
           city.setState(state);
           cityService.save(city);
       }

       response.close();
       client.close();

       return c;
   } 
   
   public Cities consumeCities(String state, String country){
       
       String targetUrl = "http://api.airvisual.com/v2/cities?state="+state+"&country="+country+"&key="+key;
       
       Client client = ClientBuilder.newClient();
       Response response = client.target(targetUrl).request().get();
       Cities c = response.readEntity(Cities.class);
       
      
       
       for (City city : c.getData()){
           city.setCountry(country);
           city.setState(state);
       }

       response.close();
       client.close();

       return c;
   } 
   
   public AirQuality consumeAirQuality(String city, String state, String country, PollutionService pollutionService, WeatherService weatherService){
       
       String targetUrl = "http://api.airvisual.com/v2/city?city="+city+"&state="+state+"&country="+country+"&key="+key;
       
       Client client = ClientBuilder.newClient();
       Response response = client.target(targetUrl).request().get();
       AirQuality aq = response.readEntity(AirQuality.class);
       AirQualityData aqd = aq.getData();
       Current c = aqd.getCurrent();
       Weather w = c.getWeather();
       w.setCity(city);
       w.setState(state);
       w.setCountry(country);
       weatherService.save(w);
       Pollution p = c.getPollution();
       p.setCity(city);
       p.setState(state);
       p.setCountry(country);
       pollutionService.save(p);
       

       response.close();
       client.close();

       return aq;
   } 
   
   public AirQuality consumeAirQuality(String city, String state, String country){
       
       String targetUrl = "http://api.airvisual.com/v2/city?city="+city+"&state="+state+"&country="+country+"&key="+key;
       
       Client client = ClientBuilder.newClient();
       Response response = client.target(targetUrl).request().get();
       AirQuality aq = response.readEntity(AirQuality.class);
       

       response.close();
       client.close();

       return aq;
   } 
}
