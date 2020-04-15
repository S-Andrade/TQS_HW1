
package com.ua.airQuality.models.air;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class AirQualityDataTest {
    
    private AirQualityData airQualityData;
    private Location location;
    private Current current;
    
    public AirQualityDataTest(){
        int[] coor = new int[] {1,2};
        location = new Location("Point", coor);
        current = new Current(new Weather(), new Pollution());
        airQualityData = new AirQualityData("Aveiro", "Aveiro", "Portugal", location, current);
    }
    
    @Test
    public void test(){
      assertEquals(1,1);  
    }
    
    @Test
    public void testGetCountry(){
        assertEquals("Portugal", airQualityData.getCountry());
    }

    @Test
    public void testGetState(){
        assertEquals("Aveiro", airQualityData.getState());
    }
    
    @Test
    public void testGetCity(){
        assertEquals("Aveiro", airQualityData.getCity());
    }
   
    @Test
    public void testGetLocation(){
        assertEquals(location, airQualityData.getLocation());
    }
    
    @Test
    public void testGetCurrent(){
        assertEquals(current, airQualityData.getCurrent());
    }
    
    @Test
    public void testSetCountry(){
        airQualityData.setCountry("Japan");
        assertEquals("Japan",airQualityData.getCountry());
    }

    @Test
    public void testSetState(){
        airQualityData.setState("Tokyo");
        assertEquals("Tokyo",airQualityData.getState());
    }
    
    @Test
    public void testSetCity(){
        airQualityData.setCity("Tokyo");
        assertEquals("Tokyo",airQualityData.getCity());
    }

    @Test
    public void testSetLocation(){
        int[] coor = new int[] {5,8};
        Location local = new Location("Point",coor);
        airQualityData.setLocation(local);
        assertEquals(local,airQualityData.getLocation());
    }
}
