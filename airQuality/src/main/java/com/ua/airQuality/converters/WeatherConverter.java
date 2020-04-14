
package com.ua.airQuality.converters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import com.ua.airQuality.models.air.Weather;

@Converter(autoApply=true)
public class WeatherConverter  implements AttributeConverter<Weather, String>{
    
    @Override
    public String convertToDatabaseColumn(Weather x) {

        if (x == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<Weather>(){}.getType();

        return gson.toJson(x, type);
    }

    @Override
    public Weather convertToEntityAttribute(String weatherID) {

        if (weatherID == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<Weather>(){}.getType();

        return gson.fromJson(weatherID, type);
    }

}
