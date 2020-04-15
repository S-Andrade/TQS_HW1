
package com.ua.airQuality.controllers;

import com.ua.airQuality.AirQualityApplication;
import com.ua.airQuality.models.air.Pollution;
import com.ua.airQuality.models.air.Weather;
import com.ua.airQuality.models.location.City;
import com.ua.airQuality.models.location.Country;
import com.ua.airQuality.models.location.State;
import com.ua.airQuality.services.CityService;
import com.ua.airQuality.services.CountryService;
import com.ua.airQuality.services.PollutionService;
import com.ua.airQuality.services.StateService;
import com.ua.airQuality.services.WeatherService;
import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = AirQualityApplication.class)
@AutoConfigureMockMvc
public class ApiControllerTest {
    
    @Autowired
    private MockMvc mvc;

    
    @MockBean
    private CountryService countryService;
    
    
    @MockBean
    private StateService stateService;
    
    
    @MockBean
    private CityService cityService;
    
    
    @MockBean
    private PollutionService pollutionService;
    
    
    @MockBean
    private WeatherService weatherService;
    
    @Test
    public void allCountries_Status200() throws Exception{
        Country portugal = new Country("Portugal");
        Country japan = new Country("Japan");
        Country korea = new Country("Korea");
        
        List<Country> allCountries = Arrays.asList(portugal,japan,korea);

        given(countryService.getAllCountries()).willReturn(allCountries);
        
        mvc.perform(get("/api/allCountries")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(3))))
                .andExpect(jsonPath("$[0].country", is(portugal.getCountry())))
                .andExpect(jsonPath("$[1].country", is(japan.getCountry())))
                .andExpect(jsonPath("$[2].country", is(korea.getCountry())));
        
        verify(countryService, VerificationModeFactory.times(1)).getAllCountries();
        reset(countryService);
        
        
    }
    
    @Test
    public void allStates_Status200() throws Exception{
        State aveiro = new State("Aveiro","Portugal");
        State tokyo = new State("Tokyo","Japan");
        State porto = new State("Porto","Portugal");
        
        List<State> allStates = Arrays.asList(aveiro,tokyo,porto);

        given(stateService.getAllStates()).willReturn(allStates);
        
        mvc.perform(get("/api/allStates")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].state", is(aveiro.getState())))
                .andExpect(jsonPath("$[1].state", is(tokyo.getState())))
                .andExpect(jsonPath("$[2].state", is(porto.getState())));
        verify(stateService, VerificationModeFactory.times(1)).getAllStates();
        reset(stateService);
        
    }
    
    @Test
    public void allCities_Status200() throws Exception{
        City aveiro = new City("Aveiro","Aveiro","Portugal");
        City tokyo = new City("Tokyo","Tokyo","Japan");
        City porto = new City("Porto","Porto","Portugal");
        
        List<City> allCities = Arrays.asList(aveiro,tokyo,porto);

        given(cityService.getAllCities()).willReturn(allCities);
        
        mvc.perform(get("/api/allCities")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].city", is(aveiro.getCity())))
                .andExpect(jsonPath("$[1].city", is(tokyo.getCity())))
                .andExpect(jsonPath("$[2].city", is(porto.getCity())));
        verify(cityService, VerificationModeFactory.times(1)).getAllCities();
        reset(cityService);

    }
    
    @Test
    public void allPollution_Status200() throws Exception{
        Pollution luanda = new Pollution();
        luanda.setCity("Luanda");
        luanda.setState("Luanda");
        luanda.setCountry("Angola");
        
        
        List<Pollution> allPollution = Arrays.asList(luanda);

        given(pollutionService.getAllPollution()).willReturn(allPollution);
        
        mvc.perform(get("/api/allPollution")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].city", is(luanda.getCity())));  

        verify(pollutionService, VerificationModeFactory.times(1)).getAllPollution();
        reset(pollutionService);

    }
    
    @Test
    public void allWaether_Status200() throws Exception{
        Weather luanda = new Weather();
        luanda.setCity("Luanda");
        luanda.setState("Luanda");
        luanda.setCountry("Angola");
        
        
        List<Weather> allWeather = Arrays.asList(luanda);

        given(weatherService.getAllWeather()).willReturn(allWeather);
        
        mvc.perform(get("/api/allWeather")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].city", is(luanda.getCity())));  
        verify(weatherService, VerificationModeFactory.times(1)).getAllWeather();
        reset(weatherService);

    }
    
    @Test
    public void getStatesByCountry_Status200() throws Exception{
        State luanda = new State("Luanda","Angola");
              
        List<State> allStates = Arrays.asList(luanda);
        
        given(stateService.getStatesByCountry("Angola")).willReturn(allStates);
        
        mvc.perform(get("/api/states/{countrty}", "Angola")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].state", is(luanda.getState())));
        //verify(stateService, VerificationModeFactory.times(1)).getStatesByCountry("Angola");
        reset(stateService);
    }
    
    @Test
    public void getCitiesByCountryAndState_Status200() throws Exception{
        City luanda = new City("Luanda","Luanda","Angola");
              
        List<City> allCities = Arrays.asList(luanda);
        
        given(cityService.getCitiesByCountryAndState("Angola", "Luanda")).willReturn(allCities);
        
        mvc.perform(get("/api/cities/{country}/{state}", "Angola", "Luanda")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].city", is(luanda.getCity())));
        //verify(cityService, VerificationModeFactory.times(1)).getCitiesByCountryAndState("Angola", "Luanda");
        reset(cityService);
    }
    
    @Test
    public void getPollutionByCountryAndStateAndCity_Status200() throws Exception{
        Pollution luanda = new Pollution();
        luanda.setCity("Luanda");
        luanda.setState("Luanda");
        luanda.setCountry("Angola");
        
        
        List<Pollution> allPollution = Arrays.asList(luanda);

        given(pollutionService.getPollutionByCountryAndStateAndCity("Angola", "Luanda", "Luanda")).willReturn(allPollution);
        
        mvc.perform(get("/api/pollution/{country}/{state}/{city}","Angola", "Luanda", "Luanda")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].city", is(luanda.getCity())));
        //verify(pollutionService, VerificationModeFactory.times(1)).getPollutionByCountryAndStateAndCity("Angola", "Luanda", "Luanda");
        reset(pollutionService);
    }
    
    @Test
    public void getWeatherByCountryAndStateAndCity_Status200() throws Exception{
        Weather luanda = new Weather();
        luanda.setCity("Luanda");
        luanda.setState("Luanda");
        luanda.setCountry("Angola");
        
        
        List<Weather> allWeather = Arrays.asList(luanda);

        given(weatherService.getWeatherByCountryAndStateAndCity("Angola", "Luanda", "Luanda")).willReturn(allWeather);
        
        mvc.perform(get("/api/weather/{country}/{state}/{city}","Angola", "Luanda", "Luanda")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].city", is(luanda.getCity())));
        //verify(weatherService, VerificationModeFactory.times(1)).getWeatherByCountryAndStateAndCity("Angola", "Luanda", "Luanda");
        reset(weatherService);
    }
    
    @Test
    public void getCurrentPollutionByCountryAndStateAndCity_Status200() throws Exception{
        Pollution luanda = new Pollution();
        luanda.setCity("Luanda");
        luanda.setState("Luanda");
        luanda.setCountry("Angola");
        

        given(pollutionService.getCurrentPollution("Angola", "Luanda", "Luanda")).willReturn(luanda);
        
        mvc.perform(get("/api/currentPollution/{country}/{state}/{city}","Angola", "Luanda", "Luanda")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        //verify(pollutionService, VerificationModeFactory.times(1)).getPollutionByCountryAndStateAndCity("Angola", "Luanda", "Luanda");
        reset(pollutionService);
    }
    
    @Test
    public void getCurrentWeatherByCountryAndStateAndCity_Status200() throws Exception{
        Weather luanda = new Weather();
        luanda.setCity("Luanda");
        luanda.setState("Luanda");
        luanda.setCountry("Angola");

        given(weatherService.getCurrentWeather("Angola", "Luanda", "Luanda")).willReturn(luanda);
        
        mvc.perform(get("/api/currentWeather/{country}/{state}/{city}","Angola", "Luanda", "Luanda")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()); 
        //verify(weatherService, VerificationModeFactory.times(1)).getWeatherByCountryAndStateAndCity("Angola", "Luanda", "Luanda");
        reset(weatherService);
    }
   
}
