
package com.ua.airQuality.converters;

import com.ua.airQuality.models.air.Weather;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class WeatherConverterTest {
    
    private WeatherConverter converter;
    private Weather weather;
    
    public WeatherConverterTest(){
        converter = new WeatherConverter();
        weather = new Weather("2020-04-14T21:00:00.000Z", "24", "1012", "64", "3.06", "189", "10n");
        weather.setId(0);
    }
    
    @Test
    public void convertFromDToString() {
        assertNull(converter.convertToDatabaseColumn(null));

        String expected_out = "{\"id\":0,\"ts\":\"2020-04-14T21:00:00.000Z\",\"tp\":\"24\",\"pr\":\"1012\",\"hu\":\"64\",\"ws\":\"3.06\",\"wd\":\"189\",\"ic\":\"10n\"}";
        assertEquals(converter.convertToDatabaseColumn(weather), expected_out);
    }
    
    @Test
    public void convertFromStringToD() {
        assertNull(converter.convertToDatabaseColumn(null));
        
        String to_convert = "{\"id\":0,\"ts\":\"2020-04-14T21:00:00.000Z\",\"tp\":\"24\",\"pr\":\"1012\",\"hu\":\"64\",\"ws\":\"3.06\",\"wd\":\"189\",\"ic\":\"10n\"}";
        assertEquals(converter.convertToEntityAttribute(to_convert).getId(),weather.getId());
        assertEquals(converter.convertToEntityAttribute(to_convert).getTs(),weather.getTs());
        assertEquals(converter.convertToEntityAttribute(to_convert).getTp(),weather.getTp());
        assertEquals(converter.convertToEntityAttribute(to_convert).getPr(),weather.getPr());
        assertEquals(converter.convertToEntityAttribute(to_convert).getHu(),weather.getHu());
        assertEquals(converter.convertToEntityAttribute(to_convert).getWs(),weather.getWs());
        assertEquals(converter.convertToEntityAttribute(to_convert).getWd(),weather.getWd());
        assertEquals(converter.convertToEntityAttribute(to_convert).getIc(),weather.getIc());
        
    }
    
    
    
}
