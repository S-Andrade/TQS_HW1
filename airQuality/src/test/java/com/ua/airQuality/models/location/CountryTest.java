
package com.ua.airQuality.models.location;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class CountryTest {
    
    private Country country;
    
    public CountryTest(){
        country = new Country("Portugal");
    }
    
    @Test
    public void testGetCountry(){
        assertEquals("Portugal", country.getCountry());
    }

   
    
    @Test
    public void testSetCountry(){
        country.setCountry("Korea");
        assertEquals("Korea",country.getCountry());
    }
    
  
}
