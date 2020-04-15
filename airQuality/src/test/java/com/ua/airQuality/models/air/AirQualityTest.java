
package com.ua.airQuality.models.air;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class AirQualityTest {
    
    private AirQuality airQuality;
    private AirQualityData data;
    
    public AirQualityTest(){
        data = new AirQualityData("Aveiro", "Aveiro", "Portugal", new Location(), new Current());
        airQuality = new AirQuality("success",data);
    }
    
    @Test
    public void testGetStatus(){
        assertEquals("success", airQuality.getStatus());
    }

    @Test
    public void testGetData(){
        assertEquals(data,airQuality.getData());
    }
    
    @Test
    public void testSetStatus(){
        airQuality.setStatus("veryGood");
        assertEquals("veryGood",airQuality.getStatus());
    }
    
    @Test
    public void testSetData(){
        AirQualityData result =new AirQualityData("Tokyo", "Tokyo", "Japan", new Location(), new Current());
        airQuality.setData(result);
        assertEquals(result,airQuality.getData());
    }

}
