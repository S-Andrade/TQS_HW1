
package com.ua.airQuality.converters;

import com.ua.airQuality.models.location.Country;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class CountryConverterTest {
    
    private CountryConverter converter;
    private Country country;
    
    public CountryConverterTest(){
        converter = new CountryConverter();
        country = new Country("Portugal");
        country.setId(0);
    }
    
    @Test
    public void convertFromDToString() {
        assertNull(converter.convertToDatabaseColumn(null));

        String expected_out = "{\"id\":0,\"country\":\"Portugal\"}";
        assertEquals(converter.convertToDatabaseColumn(country), expected_out);
    }
    
    @Test
    public void convertFromStringToD() {
        assertNull(converter.convertToDatabaseColumn(null));
        
        String to_convert = "{\"id\":0,\"country\":\"Portugal\"}";
        assertEquals(converter.convertToEntityAttribute(to_convert).getId(),country.getId());
        assertEquals(converter.convertToEntityAttribute(to_convert).getCountry(),country.getCountry());
        
    }
    
    
    
}
