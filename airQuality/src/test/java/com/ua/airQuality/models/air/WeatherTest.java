
package com.ua.airQuality.models.air;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class WeatherTest {
    
    private Weather weather;
    
    
    public WeatherTest(){
        weather = new Weather("2020-04-14T21:00:00.000Z", "24", "1012", "64", "3.06", "189", "10n");
    }
    
    @Test
    public void testGetTs(){
        assertEquals("2020-04-14T21:00:00.000Z", weather.getTs());
    }

    @Test
    public void testGetTp(){
        assertEquals("24", weather.getTp());
    }
    
    @Test
    public void testGetPr(){
        assertEquals("1012", weather.getPr());
    }
    
    @Test
    public void testGetHu(){
        assertEquals("64", weather.getHu());
    }
    
    @Test
    public void testGetWs(){
        assertEquals("3.06", weather.getWs());
    }
    
    @Test
    public void testGetWd(){
        assertEquals("189", weather.getWd());
    }
    
    @Test
    public void testGetIc(){
        assertEquals("10n", weather.getIc());
    }
   
    
    @Test
    public void testSetTs(){
        weather.setTs("2020-04-14T23:00:00.000Z");
        assertEquals("2020-04-14T23:00:00.000Z",weather.getTs());
    }
    
    @Test
    public void testSetTp(){
        weather.setTp("15");
        assertEquals("15",weather.getTp());
    }
    
    @Test
    public void testSetPr(){
        weather.setPr("1006");
        assertEquals("1006",weather.getPr());
    }
    
    @Test
    public void testSetHu(){
        weather.setHu("82");
        assertEquals("82",weather.getHu());
    }
    
    @Test
    public void testSetWs(){
        weather.setWs("2.49");
        assertEquals("2.49",weather.getWs());
    }
    
    @Test
    public void testSetWd(){
        weather.setWd("118");
        assertEquals("118",weather.getWd());
    }
    
    @Test
    public void testSetIc(){
        weather.setIc("10n");
        assertEquals("10n",weather.getIc());
    }
    
   

}
