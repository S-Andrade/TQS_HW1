
package com.ua.airQuality.converters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import com.ua.airQuality.models.air.Pollution;

@Converter(autoApply=true)
public class PollutionConverter  implements AttributeConverter<Pollution, String>{
    
    @Override
    public String convertToDatabaseColumn(Pollution x) {

        if (x == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<Pollution>(){}.getType();

        return gson.toJson(x, type);
    }

    @Override
    public Pollution convertToEntityAttribute(String pollutionID) {

        if (pollutionID == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<Pollution>(){}.getType();

        return gson.fromJson(pollutionID, type);
    }

}