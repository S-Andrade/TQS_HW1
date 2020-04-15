
package com.ua.airQuality.models.location;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class StatesTest {
    
    private States states;
    private List<State> data;
    
    public StatesTest(){
        data = Arrays.asList(new State("Aveiro"),
                new State("Lisboa"),
                new State("Porto"));
        states = new States("success",data);
    }
    
    @Test
    public void testGetStatus(){
        assertEquals("success", states.getStatus());
    }

    @Test
    public void testGetData(){
        assertEquals(data,states.getData());
    }
    
    @Test
    public void testSetStatus(){
        states.setStatus("veryGood");
        assertEquals("veryGood",states.getStatus());
    }
    
    @Test
    public void testSetData(){
        List<State> result = Arrays.asList(new State("Leiria"));
        states.setData(result);
        assertEquals(result,states.getData());
    }

}
