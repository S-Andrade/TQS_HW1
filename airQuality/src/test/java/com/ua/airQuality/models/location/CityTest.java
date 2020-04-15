
package com.ua.airQuality.models.location;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class CityTest {
    
    private City city;
    
    public CityTest(){
        city = new City("Aveiro","Aveiro","Portugal");
    }
    
    @Test
    public void testGetCountry(){
        assertEquals("Portugal", city.getCountry());
    }

    @Test
    public void testGetState(){
        assertEquals("Aveiro", city.getState());
    }
    
    @Test
    public void testGetCity(){
        assertEquals("Aveiro", city.getCity());
    }
   
    
    @Test
    public void testSetCountry(){
        city.setCountry("Japan");
        assertEquals("Japan",city.getCountry());
    }

    @Test
    public void testSetState(){
        city.setState("Tokyo");
        assertEquals("Tokyo",city.getState());
    }
    
    @Test
    public void testSetCity(){
        city.setCity("Tokyo");
        assertEquals("Tokyo",city.getCity());
    }
  
}
