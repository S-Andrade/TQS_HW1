package com.ua.airQuality.converters;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import com.ua.airQuality.models.air.Location;

@Converter(autoApply=true)
public class LocationConverter  implements AttributeConverter<Location, String>{
    
    @Override
    public String convertToDatabaseColumn(Location x) {

        if (x == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<Location>(){}.getType();

        return gson.toJson(x, type);
    }

    @Override
    public Location convertToEntityAttribute(String locationID) {

        if (locationID == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<Location>(){}.getType();

        return gson.fromJson(locationID, type);
    }

}
