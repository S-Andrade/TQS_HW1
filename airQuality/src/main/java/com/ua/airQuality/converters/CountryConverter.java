package com.ua.airQuality.converters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import com.ua.airQuality.models.location.Country;

@Converter(autoApply=true)
public class CountryConverter  implements AttributeConverter<Country, String>{
    
    @Override
    public String convertToDatabaseColumn(Country x) {

        if (x == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<Country>(){}.getType();

        return gson.toJson(x, type);
    }

    @Override
    public Country convertToEntityAttribute(String countryID) {

        if (countryID == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<Country>(){}.getType();

        return gson.fromJson(countryID, type);
    }

}
