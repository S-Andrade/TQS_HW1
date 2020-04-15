
package com.ua.airQuality.models.air;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class PollutionTest {
    
    private Pollution pollution;
    
    
    public PollutionTest(){
        pollution = new Pollution("2020-04-14T21:00:00.000Z","53","p2","19","p2");
    }
    
    @Test
    public void testGetTs(){
        assertEquals("2020-04-14T21:00:00.000Z", pollution.getTs());
    }

    @Test
    public void testGetAqius(){
        assertEquals("53", pollution.getAqius());
    }
    
    @Test
    public void testGetMainus(){
        assertEquals("p2", pollution.getMainus());
    }
   
    @Test
    public void testGetAqicn(){
        assertEquals("19", pollution.getAqicn());
    }
    
    @Test
    public void testGetMaincn(){
        assertEquals("p2", pollution.getMaincn());
    }
    
    @Test
    public void testSetTs(){
        pollution.setTs("2020-04-14T23:00:00.000Z");
        assertEquals("2020-04-14T23:00:00.000Z",pollution.getTs());
    }
    
    @Test
    public void testSetAqius(){
        pollution.setAqius("1");
        assertEquals("1",pollution.getAqius());
    }
    
    @Test
    public void testSetMainus(){
        pollution.setMainus("n2");
        assertEquals("n2",pollution.getMainus());
    }
    
    @Test
    public void testSetAqicn(){
        pollution.setAqicn("4");
        assertEquals("4",pollution.getAqicn());
    }
    
    @Test
    public void testSetMaincn(){
        pollution.setMaincn("n2");
        assertEquals("n2",pollution.getMaincn());
    }

   

}
 //"2020-04-14T14:00:00.000Z","1","n2","4","n2"