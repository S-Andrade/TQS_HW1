
package com.ua.airQuality.models.location;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class CountriesTest {
    
    private Countries countries;
    private List<Country> data;
    
    public CountriesTest(){
        data = Arrays.asList(new Country("Portugal"),
                new Country("Angola"),
                new Country("Japan"));
        countries = new Countries("success",data);
    }
    
    @Test
    public void testGetStatus(){
        assertEquals("success", countries.getStatus());
    }

    @Test
    public void testGetData(){
        assertEquals(data,countries.getData());
    }
    
    @Test
    public void testSetStatus(){
        countries.setStatus("veryGood");
        assertEquals("veryGood",countries.getStatus());
    }
    
    @Test
    public void testSetData(){
        List<Country> result = Arrays.asList(new Country("Korea"));
        countries.setData(result);
        assertEquals(result,countries.getData());
    }

}
