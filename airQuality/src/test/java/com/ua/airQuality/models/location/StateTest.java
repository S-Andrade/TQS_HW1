
package com.ua.airQuality.models.location;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class StateTest {
    
    private State state;
    
    public StateTest(){
        state = new State("Aveiro","Portugal");
    }
    
    @Test
    public void testGetCountry(){
        assertEquals("Portugal", state.getCountry());
    }

    @Test
    public void testGetState(){
        assertEquals("Aveiro", state.getState());
    }
   
    
    @Test
    public void testSetCountry(){
        state.setCountry("Korea");
        assertEquals("Korea",state.getCountry());
    }

    @Test
    public void testSetState(){
        state.setState("Seoul");
        assertEquals("Seoul",state.getState());
    }
  
}
