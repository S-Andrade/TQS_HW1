
package com.ua.airQuality.services;

import com.ua.airQuality.models.air.AirQuality;
import com.ua.airQuality.models.location.Cities;
import com.ua.airQuality.models.location.Countries;
import com.ua.airQuality.models.location.States;
import javax.ws.rs.client.ClientBuilder;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;



@RunWith(PowerMockRunner.class)
@PrepareForTest(ClientBuilder.class)
public class CunsumeServiceTest {
    
    private ConsumeService service;
    
    public CunsumeServiceTest(){
        service = new ConsumeService();
    }
    
    @Test
    public void testConsumeCountries(){
        Countries countries = service.consumeCountries();
        assertThat(countries, instanceOf(Countries.class));
    }
    
    @Test
    public void testConsumeStates(){
        States states = service.consumeStates("Portugal");
        assertThat(states, instanceOf(States.class));
    }
    
    @Test
    public void testConsumeCities(){
        Cities cities = service.consumeCities("Aveiro","Portugal");
        assertThat(cities, instanceOf(Cities.class));
    }
    
    @Test
    public void testConsumeAirQuality(){
        AirQuality airQuality = service.consumeAirQuality("Aveiro", "Aveiro", "Portugal");
        assertThat(airQuality, instanceOf(AirQuality.class));
    }
    
}
