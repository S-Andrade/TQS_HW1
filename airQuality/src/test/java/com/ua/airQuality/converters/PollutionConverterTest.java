
package com.ua.airQuality.converters;

import com.ua.airQuality.models.air.Pollution;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class PollutionConverterTest {
    
    private PollutionConverter converter;
    private Pollution pollution;
    
    public PollutionConverterTest(){
        converter = new PollutionConverter();
        pollution = new Pollution("2020-04-14T21:00:00.000Z","53","p2","19","p2");
        pollution.setId(0);
    }
    
    @Test
    public void convertFromDToString() {
        assertNull(converter.convertToDatabaseColumn(null));

        String expected_out = "{\"id\":0,\"ts\":\"2020-04-14T21:00:00.000Z\",\"aqius\":\"53\",\"mainus\":\"p2\",\"aqicn\":\"19\",\"maincn\":\"p2\"}";
        assertEquals(converter.convertToDatabaseColumn(pollution), expected_out);
    }
    
    @Test
    public void convertFromStringToD() {
        assertNull(converter.convertToDatabaseColumn(null));
        
        String to_convert = "{\"id\":0,\"ts\":\"2020-04-14T21:00:00.000Z\",\"aqius\":\"53\",\"mainus\":\"p2\",\"aqicn\":\"19\",\"maincn\":\"p2\"}";
        assertEquals(converter.convertToEntityAttribute(to_convert).getId(),pollution.getId());
        assertEquals(converter.convertToEntityAttribute(to_convert).getTs(),pollution.getTs());
        assertEquals(converter.convertToEntityAttribute(to_convert).getAqius(),pollution.getAqius());
        assertEquals(converter.convertToEntityAttribute(to_convert).getMainus(),pollution.getMainus());
        assertEquals(converter.convertToEntityAttribute(to_convert).getAqicn(),pollution.getAqicn());
        assertEquals(converter.convertToEntityAttribute(to_convert).getMaincn(),pollution.getMaincn());
        
    }
    
    
    
}
