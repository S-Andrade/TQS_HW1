
package com.ua.airQuality.models.air;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class CurrentTest {
    
    private Current current;
    private Weather weather;
    private Pollution pollution;
    
    public CurrentTest(){
        weather = new Weather("2020-04-14T21:00:00.000Z", "24", "1012", "64", "3.06", "189", "10n");
        pollution = new Pollution("2020-04-14T21:00:00.000Z","53","p2","19","p2");
        current = new Current(weather,pollution);
    }
    
    @Test
    public void testGetWeather(){
        assertEquals(weather, current.getWeather());
    }

    @Test
    public void testGetPollution(){
        assertEquals(pollution, current.getPollution());
    }
    
    
    @Test
    public void testSetWeather(){
        Weather w = new Weather("2020-04-14T23:00:00.000Z", "15", "1006", "82", "2.49", "118", "10n");
        current.setWeather(w);
        assertEquals(w,current.getWeather());
    }

    @Test
    public void testSetPollution(){
        Pollution p = new Pollution("2020-04-14T14:00:00.000Z","1","n2","4","n2");
        current.setPollution(p);
        assertEquals(p,current.getPollution());
    }
    
}
