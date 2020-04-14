package com.ua.airQuality.converters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import com.ua.airQuality.models.location.City;

@Converter(autoApply=true)
public class CityConverter  implements AttributeConverter<City, String>{
    
    @Override
    public String convertToDatabaseColumn(City x) {

        if (x == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<City>(){}.getType();

        return gson.toJson(x, type);
    }

    @Override
    public City convertToEntityAttribute(String cityID) {

        if (cityID == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<City>(){}.getType();

        return gson.fromJson(cityID, type);
    }

}
