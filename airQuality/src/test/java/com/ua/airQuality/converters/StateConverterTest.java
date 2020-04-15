
package com.ua.airQuality.converters;

import com.ua.airQuality.models.location.State;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class StateConverterTest {
    
    private StateConverter converter;
    private State state;
    
    public StateConverterTest(){
        converter = new StateConverter();
        state = new State("Aveiro");
        state.setId(0);
    }
    
    @Test
    public void convertFromDToString() {
        assertNull(converter.convertToDatabaseColumn(null));

        String expected_out = "{\"id\":0,\"state\":\"Aveiro\"}";
        assertEquals(converter.convertToDatabaseColumn(state), expected_out);
    }
    
    @Test
    public void convertFromStringToD() {
        assertNull(converter.convertToDatabaseColumn(null));
        
        String to_convert = "{\"id\":0,\"state\":\"Aveiro\"}";
        assertEquals(converter.convertToEntityAttribute(to_convert).getId(),state.getId());
        assertEquals(converter.convertToEntityAttribute(to_convert).getState(),state.getState());
        
    }
    
    
    
}
