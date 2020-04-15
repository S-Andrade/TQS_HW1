
package com.ua.airQuality.converters;

import com.ua.airQuality.models.location.City;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class CityConverterTest {
    
    private CityConverter converter;
    private City city;
    
    public CityConverterTest(){
        converter = new CityConverter();
        city = new City("Aveiro");
        city.setId(0);
    }
    
    @Test
    public void convertFromDToString() {
        assertNull(converter.convertToDatabaseColumn(null));

        String expected_out = "{\"id\":0,\"city\":\"Aveiro\"}";
        assertEquals(converter.convertToDatabaseColumn(city), expected_out);
    }
    
    @Test
    public void convertFromStringToD() {
        assertNull(converter.convertToDatabaseColumn(null));
        
        String to_convert = "{\"id\":0,\"city\":\"Aveiro\"}";
        assertEquals(converter.convertToEntityAttribute(to_convert).getId(),city.getId());
        assertEquals(converter.convertToEntityAttribute(to_convert).getCity(),city.getCity());
        
    }
    
    
    
}
