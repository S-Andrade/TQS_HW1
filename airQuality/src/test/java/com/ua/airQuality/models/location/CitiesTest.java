
package com.ua.airQuality.models.location;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class CitiesTest {
    
    private Cities cities;
    private List<City> data;
    
    public CitiesTest(){
        data = Arrays.asList(new City("Aveiro"),
                new City("Lisboa"),
                new City("Porto"));
        cities = new Cities("success",data);
    }
    
    @Test
    public void testGetStatus(){
        assertEquals("success", cities.getStatus());
    }

    @Test
    public void testGetData(){
        assertEquals(data,cities.getData());
    }
    
    @Test
    public void testSetStatus(){
        cities.setStatus("veryGood");
        assertEquals("veryGood",cities.getStatus());
    }
    
    @Test
    public void testSetData(){
        List<City> result = Arrays.asList(new City("Leiria"));
        cities.setData(result);
        assertEquals(result,cities.getData());
    }

}
