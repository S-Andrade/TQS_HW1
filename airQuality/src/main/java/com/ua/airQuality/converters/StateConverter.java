package com.ua.airQuality.converters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import com.ua.airQuality.models.location.State;

@Converter(autoApply=true)
public class StateConverter implements AttributeConverter<State, String>{
    
    @Override
    public String convertToDatabaseColumn(State x) {

        if (x == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<State>(){}.getType();

        return gson.toJson(x, type);
    }

    @Override
    public State convertToEntityAttribute(String stateID) {

        if (stateID == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<State>(){}.getType();

        return gson.fromJson(stateID, type);
    }
}
