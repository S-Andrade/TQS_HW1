
package com.ua.airQuality.models.air;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class LocationTest {
    
    private Location location;
    private int[] coor = new int[] {1,2};

    
    public LocationTest(){
        location = new Location("Point", coor);
    }
    
    @Test
    public void testGetType(){
        assertEquals("Point", location.getType());
    }

    @Test
    public void testGetCoordinates(){
        assertEquals(coor, location.getCoordinates());
    }
   
    
    @Test
    public void testSetType(){
        location.setType("Maria");
        assertEquals("Maria",location.getType());
    }

    @Test
    public void testSetCoordinates(){
        int[] coor = new int[] {5,6};
        location.setCoordinates(coor);
        assertEquals(coor, location.getCoordinates());
    }
  
}
